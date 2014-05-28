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
                    '<a id="single1"  title="More" rel="tooltip" class="p-link" style="right: 55%;" onclick="tosingle(\''+data[i]["filmId"]+'\')" value="12"></a></span>'
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
' <a href="blog-single.html" class="p-link" style="right:57  <span class="portfolio-img"><span class="hover-span">'+
' <a href="blog-single.html" class="p-link" style="right:57%;"></a> </span>'+ 
        '<img src="'+data[i+3]['photoset'][0]['photolink']+'" alt="photo" style="height:380px" /></span></div></div>'+
'</article></section></li></ul>';
	   i=i+3;
		listElement.appendChild(titleDiv);
	}
}
function showMovie(id)
{
	bm.getFilmById(id,smCb);
}
function smCb(data)
{
	var nameElement = document.getElementById("filmname");
    nameElement.innerHTML="";
    var nameel=document.createElement("h3");
    nameel.innerHTML=data['name'];
    nameElement.appendChild(nameel);
    
	var nameElement1 = document.getElementById("bigname");
    nameElement1.innerHTML="";
    var nameel1=document.createElement("div");
    nameel1.innerHTML='<a href="#">'+data['name']+'</a>';
    nameElement1.appendChild(nameel1);
    
	var desElement = document.getElementById("filmdescription");
    desElement.innerHTML="";
    var desel=document.createElement("blockquote");
    desel.innerHTML='<p style="font-family:微软雅黑;">'+data['description']+'</p>';
    desElement.appendChild(desel);
    

	var directorElement = document.getElementById("director");
	directorElement.innerHTML="";
    var directorel=document.createElement("div");
    directorel.innerHTML='<a href="#">'+data['filmdirector']+'</a>';
    directorElement.appendChild(directorel);
    
	var actorElement = document.getElementById("filmactor");
	actorElement.innerHTML="";
    var actorel=document.createElement("div");
    var actorlist='';
    for(var i=0;i<data['filmactor'].length;i++)
    {
    	if(i!=0)
    	actorlist=actorlist+'/'+'<a href="#">'+data['filmactor'][i]+'</a>';
    	else
    	actorlist=actorlist+'<a href="#">'+data['filmactor'][i]+'</a>';
    }
    actorel.innerHTML=actorlist;
    actorElement.appendChild(actorel);
    
	var typeElement = document.getElementById("filmtype");
	typeElement.innerHTML="";
    var typeel=document.createElement("div");
    var typelist='';
    for(var i=0;i<data['filmtype'].length;i++)
    {
    	if(i!=0)
    	typelist=typelist+'/'+'<a href="#">'+data['filmtype'][i]+'</a>';
    	else
    	typelist=typelist+'<a href="#">'+data['filmtype'][i]+'</a>';
    }
    typeel.innerHTML=typelist;
    typeElement.appendChild(typeel);
    
	var typeElement1 = document.getElementById("tagss");
	typeElement1.innerHTML="";
    var typeel1=document.createElement("div");
    var typelist='<p class="tags">Tags:';
    for(var i=0;i<data['filmtype'].length;i++)
    {
    	if(i!=0)
    	typelist=typelist+'<a href="#">,'+data['filmtype'][i]+'</a>';
    	else
    	typelist=typelist+'<a href="#">'+data['filmtype'][i]+'</a>';
    }
    typelist+='</p>';
    typeel1.innerHTML=typelist;
    typeElement1.appendChild(typeel1);
    
    
    
	var placeElement = document.getElementById("filmplace");
	placeElement.innerHTML="";
    var placeel=document.createElement("div");
    var placelist='';
    for(var i=0;i<data['filmplace'].length;i++)
    {
    	if(i!=0)
    	placelist=placelist+'/'+'<a href="#">'+data['filmplace'][i]+'</a>';
    	else  
    	placelist=placelist+'<a href="#">'+data['filmplace'][i]+'</a>';
    }
    placeel.innerHTML=placelist;
    placeElement.appendChild(placeel);
    
	var updateElement = document.getElementById("filmupdate");
	updateElement.innerHTML="";
    var updateel=document.createElement("div");
    updateel.innerHTML=data['filmupdate'].split(" ")[0];
    updateElement.appendChild(updateel);
    
	var lengthElement = document.getElementById("filmlength");
	lengthElement.innerHTML="";
    var lengthel=document.createElement("div");
    
    lengthel.innerHTML=data['filmlength']+'min';
    lengthElement.appendChild(lengthel);
    
    
	var othernameElement = document.getElementById("filmothername");
	othernameElement.innerHTML="";
    var othernameel=document.createElement("div");
    othernameel.innerHTML=data['filmothername'];
    othernameElement.appendChild(othernameel);
    
	var dblinkElement = document.getElementById("dblink");
	dblinkElement.innerHTML="";
    var dblinkel=document.createElement("div");
    dblinkel.innerHTML='<strong>&#x8C46;&#x74E3;</strong> <a rel="nofollow" href="'+data['dblink'] +'"target="_blank" data-toggle="tooltip" class="x-tooltip" title="&#x8C46;&#x74E3;&#x94FE;&#x63A5;"><span class="badge" style="color: green; font-weight: bold;">'+data['dbgrade']+'</span></a>';
    dblinkElement.appendChild(dblinkel);
    
	var imgElement = document.getElementById("showimg");
	imgElement.innerHTML="";
    var imgel=document.createElement("div");
    imgel.innerHTML='<img src="'+data['photoset'][0]['photolink']+'" alt="photo" style="max-height:400px;" />';
   imgElement.appendChild(imgel);
   
   
	var commentElement = document.getElementById("commentlist");
	commentElement.innerHTML="";
    var commentel=document.createElement("div");
    var commentlist='';
    for(var i=0;i<data['commentSet'].length;i++)
    {
    	commentlist=commentlist+'<li class="clearfix comments_li">'+
        '<img src="images/avatar.png" alt="avatar" class="avatar" />'+
        '<div class="textarea">'+
        '<p class="meta">'+data['commentSet'][i]['addTime']+data['commentSet'][i]['username']+'says:</p><p>'+ data['commentSet'][i]['content']+
        '</p></div></li>';
    }
    commentel.innerHTML=commentlist;
    commentElement.appendChild(commentel);
}

function register()
{
  var useremail=dwr.util.getValue("registeruser");	
  var userpass=dwr.util.getValue("registerpass");
  var userrepass=dwr.util.getValue("registerrepass");
  if(userpass!=userrepass) alert("错误");
  else
  {
	  alert(userpass);
  }

}