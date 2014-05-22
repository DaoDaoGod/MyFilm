var curnum=0;
function init()
{
	getViewList(0,3);
	getPreFilms();
}
function getViewList(pagenum,hotgrade)
{
	if(pagenum<0) 
	{
		bm.getHotMovieByPage(0,hotgrade,hmCb);
		curnum=0;
	}
	else
	{
    curnum=pagenum;
	bm.getHotMovieByPage(pagenum,hotgrade,hmCb);
	}
	 
}

function hmCb(data)
{ 
	var listElement = document.getElementById("filmlist");
	listElement.innerHTML="";
	for (var i = 0 ; i < data.length ; i++ )
	{
		var titleDiv = document.createElement("div");
		titleDiv.innerHTML = '<article data-id="id-5" data-type="javascript html" class="span3">'+
            '<div class="block-grey"><div class="block-light"><span class="portfolio-img"> '+
                '<span class="hover-span">'+  
                    '<a href="film-single.html"  title="ฯ๊ว้" rel="tooltip" class="p-link" style="right: 55%;"></a></span>'
			+ '<img src="'+data[i]['photoset'][0]['photolink']+'" alt="photo" style="max-height:370px;" />'+
            '<h3>'+data[i]['name']+'</h3></span></div></div></article>';
		listElement.appendChild(titleDiv);
	}

}
function getPreFilms()
{
	bm.getUpComings(pfCb);
}
function pfCb(data)
{
	var listElement = document.getElementById("prevlist");
	listElement.innerHTML="";
	for (var i = 0 ; i < data.length ; i++ )
	{
		var titleDiv=document.createElement("div");
	    if(i==0) titleDiv.setAttribute("class", "item active");
	    else titleDiv.setAttribute("class", "item");
		titleDiv.class="item";
	   titleDiv.innerHTML='<ul class="inline"><li><section class="row portfolio filtrable"><article data-id="id-1" data-type="javascript html" class="span3">'+
        '<div class="block-grey"><div class="block-light"> <span class="portfolio-img"><span class="hover-span">'+
        ' <a href="blog-single.html" class="p-link" style="right:57%;"></a> </span>'+ 
                '<img src="'+data[i]['photoset'][0]['photolink']+'" alt="photo" style="height:380px" /></span></div></div>'+
    '</article></section></li>'+'<li><section class="row portfolio filtrable"><article data-id="id-1" data-type="javascript html" class="span3">'+
    '<div class="block-grey"><div class="block-light"> <span class="portfolio-img"><span class="hover-span">'+
    ' <a href="blog-single.html" class="p-link" style="right:57%;"></a> </span>'+ 
            '<img src="'+data[i+1]['photoset'][0]['photolink']+'" alt="photo" style="height:380px" /></span></div></div>'+
'</article></section></li>'+'<li><section class="row portfolio filtrable"><article data-id="id-1" data-type="javascript html" class="span3">'+
'<div class="block-grey"><div class="block-light"> <span class="portfolio-img"><span class="hover-span">'+
' <a href="blog-single.html" class="p-link" style="right:57%;"></a> </span>'+ 
        '<img src="'+data[i+2]['photoset'][0]['photolink']+'" alt="photo" style="height:380px" /></span></div></div>'+
'</article></section></li>'+'<li><section class="row portfolio filtrable"><article data-id="id-1" data-type="javascript html" class="span3">'+
'<div class="block-grey"><div class="block-light"> <span class="portfolio-img"><span class="hover-span">'+
' <a href="blog-single.html" class="p-link" style="right:57%;"></a> </span>'+ 
        '<img src="'+data[i+3]['photoset'][0]['photolink']+'" alt="photo" style="height:380px" /></span></div></div>'+
'</article></section></li></ul>';
	   i=i+3;
		listElement.appendChild(titleDiv);
	}


}