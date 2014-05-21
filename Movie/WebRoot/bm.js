var curnum=0;
function init()
{
	getViewList(0);
}
function getViewList(pagenum)
{
	if(pagenum<0) 
	{
		bm.getHotMovieByPage(0,hmCb);
		curnum=0;
	}
	else
	{
    curnum=pagenum;
	bm.getHotMovieByPage(pagenum,hmCb);
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