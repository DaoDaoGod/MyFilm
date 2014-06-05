var curnum=0;
var curuser=0;
var curuserid=0;
var curfilmid=0;
var curgroupid=0;
var groupid=0;
var topicid=0;
var begin='1990';
var end='1954';
var type='null';
var place='null';
var sque=1;
var conditionnum=0;
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
	for (var i = 0 ; i < data.length; i++ )
	{
		var titleDiv = document.createElement("div");
		titleDiv.innerHTML = '<article data-id="id-5" data-type="javascript html" class="span3">'+
            '<div class="block-grey"><div class="block-light"><span class="portfolio-img"> '+
                '<span class="hover-span">'+  
                    '<a id="single1"  title="More" rel="tooltip" class="p-link" style="right: 55%;" onclick="tosingle(\''+data[i]["filmId"]+'\')" value="12"></a></span>'
			+ '<img src="'+data[i]['photoset'][0]['photolink']+'" alt="photo" style="height:380px;" />'+
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
	for (var i = 0 ; i < 12 ; i++ )
	{
		var titleDiv=document.createElement("div");
	    if(i==0) titleDiv.setAttribute("class", "item active");
	    else titleDiv.setAttribute("class", "item");
		titleDiv.class="item";
	   titleDiv.innerHTML='<ul class="inline"><li><section class="row portfolio filtrable"><article data-id="id-1" data-type="javascript html" class="span3">'+
        '<div class="block-grey"><div class="block-light"> <span class="portfolio-img"><span class="hover-span">'+
        '<a id="single1"  title="More" rel="tooltip" class="p-link" style="right: 55%;" onclick="tosingle(\''+data[i]["filmId"]+'\')" value="12"></a></span>'+ 
                '<img src="'+data[i]['photoset'][0]['photolink']+'" alt="photo" style="height:380px" /></span></div></div>'+
    '</article></section></li>'+'<li><section class="row portfolio filtrable"><article data-id="id-1" data-type="javascript html" class="span3">'+
    '<div class="block-grey"><div class="block-light"> <span class="portfolio-img"><span class="hover-span">'+
    '<a id="single1"  title="More" rel="tooltip" class="p-link" style="right: 55%;" onclick="tosingle(\''+data[i+1]["filmId"]+'\')" value="12"></a></span>'+ 
    '<img src="'+data[i+1]['photoset'][0]['photolink']+'" alt="photo" style="height:380px" /></span></div></div>'+
    '</article></section></li>'+'<li><section class="row portfolio filtrable"><article data-id="id-1" data-type="javascript html" class="span3">'+
    '<div class="block-grey"><div class="block-light"> <span class="portfolio-img"><span class="hover-span">'+
    '<a id="single1"  title="More" rel="tooltip" class="p-link" style="right: 55%;" onclick="tosingle(\''+data[i+2]["filmId"]+'\')" value="12"></a></span>'+ 
            '<img src="'+data[i+2]['photoset'][0]['photolink']+'" alt="photo" style="height:380px" /></span></div></div>'+
'</article></section></li>'+'<li><section class="row portfolio filtrable"><article data-id="id-1" data-type="javascript html" class="span3">'+
'<div class="block-grey"><div class="block-light"> <span class="portfolio-img"><span class="hover-span">'+
'<a id="single1"  title="More" rel="tooltip" class="p-link" style="right: 55%;" onclick="tosingle(\''+data[i+3]["filmId"]+'\')" value="12"></a></span>'+ 
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
    var comments='';
    for(var i=0;i<data['commentlist'].length;i++)
    {
    	comments=comments+'<li class="clearfix comments_li">'+
        '<img src="images/avatar.png" alt="avatar" class="avatar" />'+
        '<div class="textarea">'+
        '<p class="meta">'+data['commentlist'][i]['addTime']+data['commentlist'][i]['nickname']+'says:</p><p>'+ data['commentlist'][i]['content']+
        '</p></div></li>';
    }
    commentel.innerHTML=comments;
    commentElement.appendChild(commentel);
}

function register()
{
  var useremail=dwr.util.getValue("registeruser");	
  var userpass=dwr.util.getValue("registerpass");
  var userrepass=dwr.util.getValue("registerrepass");
  if(userpass!=userrepass) alert("密码不一致");
  else
  {
	  if(useremail!=null&&useremail!=""&&userpass!=null&&userrepass!="")
      {

		  bm.createUser(useremail,userpass,registCb);
		  
      }
  }

}
function registCb(data)
{
	if(data==0)
	{
		 var url = location.href;
		 window.location=url;
		 dwr.util.setValue("registeruser","");
		 dwr.util.setValue("registerpass","");
		 dwr.util.setValue("registerrepass","");
	}
	else if (data==2)
	{
		 alert("非常遗憾,已注册相同用户名的账户,请重新注册");
		 dwr.util.setValue("registeruser","");
		 dwr.util.setValue("registerpass","");
		 dwr.util.setValue("registerrepass","");
	}
	else
	{
		 alert("非常遗憾,由于系统原因，你没有注册成功，请重新注册");
		 dwr.util.setValue("registeruser","");
		 dwr.util.setValue("registerpass","");
		 dwr.util.setValue("registerrepass","");
	}
}

function login()
{
	  var useremail=dwr.util.getValue("loginuser");	
	  var userpass=dwr.util.getValue("loginpass");
	  if(useremail!=null&&useremail!=""&&userpass!=null&&userpass!="")
	  {
		 bm.login(useremail,userpass,loginCb);  
	  }
	  else
	  {
		  alert("请输入用户名或密码");
	  }
}
function loginCb(data)
{
	  if(data!=-1)
	  {
			 var url = location.href;
			 window.location=url;
			 dwr.util.setValue("loginuser","");
			 dwr.util.setValue("loginpass","");
	  }
	  else
	  {
		     alert("登陆失败，请检查用户名和密码");
		     dwr.util.setValue("loginuser","");
		     dwr.util.setValue("loginpass","");
	  }
}
function exit()
{
   
	bm.exitlogin(elcb);
}
function elcb(data)
{
	if(data==0)
		{
		 var url = location.href;
		 
		 window.location=url;
		}
}
function islogin()
{
	bm.isLogin(isLoginCb);
}
function isLoginCb(data)
{
		if(data!=null)
		{
			
			curuser=data;
			curuserid=data['userId'];
			var loginElement = document.getElementById("registeraccount");
			var loginElement1 = document.getElementById("loginaccount");
			loginElement.innerHTML='<a style="cursor:pointer;" onclick="exit();">退出</a>';
			loginElement1.innerHTML='<a href="user.html">'+data['nickname']+'</a>';
			if(document.getElementById("commentnickname")!=null&&groupid==0)
			{
				var loginElement2 = document.getElementById("commentnickname");
				var loginElement3 = document.getElementById("commentemail");
				loginElement2.innerHTML="";
				loginElement3.innerHTML="";
			}
		
		}
		
}
function getparm() {
    var url = location.href;
    var tmp1 = url.split("?")[1];
    var tmp2 = tmp1.split("=")[1];
    var parm = tmp2;
    curfilmid=parm;
    showMovie(parm);
}
function addcomment()
{
	var content=dwr.util.getValue("commentinput");
	bm.addNewComment(curfilmid,curuserid,content,fcCb);
}
function fcCb(data)
{
	if(data==0)
	{
	 var url = location.href;
	 window.location=url;
	}
}
function addTopicComment()
{
	var content=dwr.util.getValue("commentinput");
	bm.addNewTopicComment(groupid,topicid,curuserid,content,acCb);
}
function acCb(data)
{
	if(data==0)
	{
	 var url = location.href;
	 window.location=url;
	}
}
function getgroupid() {
    var url = location.href;
    var tmp1 = url.split("?")[1];
    var tmp2 = tmp1.split("=")[1];
    var parm = tmp2;
    groupid=parm;
    showgroup(groupid);
    
}
function showgroup(id)
{
	bm.getGroupById(id,sgcb);
}
function sgcb(data)
{
	var nameElement = document.getElementById("groupname");
    nameElement.innerHTML="";
    var nameel=document.createElement("h1");
    nameel.innerHTML=data['groupName'];
    nameElement.appendChild(nameel);
    
	var desElement = document.getElementById("groupdescription");
    desElement.innerHTML="";
    var desel=document.createElement("p");
    desel.innerHTML=data['groupDescription'];
    desElement.appendChild(desel);
    
    var topicname=document.getElementById("topicname");
    topicname.innerHTML="";
    var topicnameel=document.createElement("div");
    var top1='';
    for(var i=0;i<data['topics'].length;i++)
    {
    	top1=top1+'<div class="row" style="margin-left:0;"><a href="topic.html?groupid='+groupid+'&topicid='+data['topics'][i]['topicId']+'">'+data['topics'][i]['name']+'</a></div>';
    }
    topicnameel.innerHTML=top1;
    topicname.appendChild(topicnameel);
   
    var topicownername=document.getElementById("topicusername");
    topicownername.innerHTML="";
    var topicownernameel=document.createElement("div");
    var top='';
    for(var i=0;i<data['topics'].length;i++)
    {
    	top=top+'<div class="row" style="margin-left:0;"><a href="topic.html">'+'匿名'+'</a></div>';
    }
    topicownernameel.innerHTML=top;
    topicownername.appendChild(topicownernameel);
    

    
    var topictime=document.getElementById("topicaddtime");
    topictime.innerHTML="";
    var topictimeel=document.createElement("div");
    var top2='';
    for(var i=0;i<data['topics'].length;i++)
    {
    	top2=top2+'<div class="row" style="margin-left:0;"><a href="topic.html">'+data['topics'][i]['addtime']+'</a></div>';
    }
    topictimeel.innerHTML=top2;
    topictime.appendChild(topictimeel);
    
    
    var topiccreate=document.getElementById("createtopic");
    topiccreate.innerHTML="";
    var topiccreateel=document.createElement("div");
 
    topiccreateel.innerHTML='<a href="createtopic.html?groupid='+data['groupId']+'">+发表话题</a>';
    topiccreate.appendChild(topiccreateel);
    
}
function splittopic()
{
    var url = location.href;
    var tmp1 = url.split("?")[1];
    var tmp2 = tmp1.split("&")[0];
    var tmp3=  tmp1.split("&")[1];
    groupid=tmp2.split("=")[1];
    topicid=tmp3.split("=")[1];
    showtopic(groupid,topicid);
}
function showtopic(groupid,topicid)
{
	bm.getGroupById(groupid,spcb1);
	bm.getTopicById(topicid,spcb);
}
function spcb1(data)
{
	var nameElement = document.getElementById("groupname");
    nameElement.innerHTML="";
    var nameel=document.createElement("h1");
    nameel.innerHTML=data['groupName'];
    nameElement.appendChild(nameel);
    
	var desElement = document.getElementById("groupdescription");
    desElement.innerHTML="";
    var desel=document.createElement("p");
    desel.innerHTML=data['groupDescription'];
    desElement.appendChild(desel);
}
function spcb(data)
{
	var nameElement = document.getElementById("topicname");
    nameElement.innerHTML="";
    var nameel=document.createElement("h3");
    nameel.innerHTML=data['name'];
    nameElement.appendChild(nameel);
    
	var desElement = document.getElementById("topiccontent");
    desElement.innerHTML="";
    var desel=document.createElement("p");
    desel.innerHTML=data['content'];
    desElement.appendChild(desel);
    
	var commentElement = document.getElementById("commentlist");
	commentElement.innerHTML="";
    var commentel=document.createElement("div");
    var comments='';
    for(var i=0;i<data['topComments'].length;i++)
    {
    	comments=comments+'<li class="clearfix comments_li">'+
        '<img src="images/avatar.png" alt="avatar" class="avatar" />'+
        '<div class="textarea">'+
        '<p class="meta">'+data['topComments'][i]['addtime']+'匿名'+'says:</p><p>'+ data['topComments'][i]['content']+
        '</p></div></li>';
    }
    commentel.innerHTML=comments;
    commentElement.appendChild(commentel);
}
function splitgroup()
{
	   var url = location.href;
	    var tmp1 = url.split("?")[1];
	    var tmp2 = tmp1.split("=")[1];
	    var parm = tmp2;
	    groupid=parm;
    bm.getGroupById(groupid,spcb1);
    
}
function showcreatetopic()
{
	if(curuserid==0) alert("请先登录");
	else
	{
	var topicname=dwr.util.getValue("topicname");
	var topiccontent=dwr.util.getValue("topicinput");
	bm.addNewTopic(groupid,curuserid,topicname,topiccontent,fctcb);
	}
}
function fctcb(data)
{
	if(data==0) 
	{
	alert("发表话题成功");
	dwr.util.setValue("topicname","");
	dwr.util.setValue("topicinput","");
	 var url ="group-single.html?groupid="+groupid;
	 window.location=url;
	}
	
	else
	{
	alert("发表话题未成功");
   
	}
}
function shownewtopic()
{
	bm.getNewestTopicbypage(0,sntcb);
	bm.getNewestGroup(snt1cb);
}
function sntcb(data)
{
   if(data!=null)
	{
	      
		var topicElement = document.getElementById("topiclist");
		topicElement.innerHTML="";
	    var topicel=document.createElement("div");
	    var topics='';
	    for(var i=0;i<data.length;i++)
	    {
	    	topics=topics+'<div class="row"><h5><a href="topic.html?groupid='+data[i]['groupId']+'&topicid='+data[i]['topicId']+'">'+data[i]['name']+
	    	'</a></h5><div class="row"><div class="span1"><img src="example/beauty.jpg"></div>'+
             '<div class="span7"><p>'+data[i]['content']+
              '</p></div></div> <p>来自<a href="group-single.html">'+data[i]['username']+'</a>&nbsp;&nbsp;&nbsp;3分钟前</p>'+
            '<hr style="background:#D3D3D3;" /></div>';
	    }
	    topicel.innerHTML=topics;
	    topicElement.appendChild(topicel);
	}
}
function snt1cb(data)
{
	var groupElement = document.getElementById("grouplist");
	groupElement.innerHTML="";
    var groupel=document.createElement("div");
    var groups='';
    for(var i=0;i<data.length;i++)
    {
    	groups=groups+'<hr style="background:#D3D3D3;" />'+
        '<span class="span1"><img src="example/beauty.jpg" width="50px" height="50px">'+
        '</span><div class="row"><span class=" inline" style="font-size:125%;margin-left:10px;">'+
       '<a href="group-single.html?groupid='+data[i]['groupId']+'">'+data[i]['groupName']+'</a></span><br/><div class="inline" style="margin-top:10px;">'+
        '<a href="group-single.html?groupid='+data[i]['groupId']+'">'+data[i]['droupNumber']+'</a> 成员&nbsp;&nbsp; <a style="cursor:pointer;" onclick="joinAgroup('+data[i]['groupId']+');">+加入圈子</a>'+
        '</div></div>';
    }
    groupel.innerHTML=groups;
    groupElement.appendChild(groupel);
}
function joingroup()
{
	if(curuserid==0) alert("请先登录");
	else 
	{
		bm.joinAgroup(curuserid,groupid,japcb);
	}
}
function joinAgroup(groupida)
{
	if(curuserid==0) alert("请先登录");
	else 
	{
		bm.joinAgroup(curuserid,groupida,japcb);
	}
	
}
function japcb(data)
{
	if(data==0) alert("加入圈子成功");
	else alert("你已经加入该圈子");
}
function findtime(beginyear,endyear)
{
	begin=beginyear;
	end=endyear;
	var Element = document.getElementById("showyear");
	Element.innerHTML='所选年份: '+begin+' ~ '+end;
}
function findtype(filmtype)
{
	type=filmtype;
	var Element = document.getElementById("showtype");
	Element.innerHTML='所选类型: '+type;
}
function findplace(filmplace)
{
    place=filmplace;
	var Element = document.getElementById("showplace");
	Element.innerHTML='所选地点: '+place;
}
function findsqe(sqe)
{
	sque=sqe;
	var Element = document.getElementById("showsqe");
	Element.innerHTML='所选顺序: '+sqe;
}
function findfilmbycondition(pagenum)
{
	if(pagenum<0) 
	{
		bm.getFilmbyConditionbypage(begin,end,type,place,sque,0,ffbcb);
		conditionnum=0;
	}
	else
	{
		conditionnum=pagenum;
		bm.getFilmbyConditionbypage(begin,end,type,place,sque,pagenum,ffbcb);
	}

}
function ffbcb(data)
{
	var listElement = document.getElementById("filmlist");
	listElement.innerHTML="";
	for (var i = 0 ; i < data.length; i++ )
	{
		var titleDiv = document.createElement("div");
		titleDiv.innerHTML = '<article data-id="id-5" data-type="javascript html" class="span3">'+
            '<div class="block-grey"><div class="block-light"><span class="portfolio-img"> '+
                '<span class="hover-span">'+  
                    '<a id="single1"  title="More" rel="tooltip" class="p-link" style="right: 55%;" onclick="tosingle(\''+data[i]["filmId"]+'\')" value="12"></a></span>'
			+ '<img src="'+data[i]['photoset'][0]['photolink']+'" alt="photo" style="height:380px;" />'+
            '<h3>'+data[i]['name']+'</h3></span></div></div></article>';
		listElement.appendChild(titleDiv);
	}
	
}

function addlikestate(like)
{
	if(curuserid==0) 
	 {
		alert("请先登录");
	 }
	else
	 {

		bm.addFilmlikestate(curfilmid,curuserid,like,ascb);
	 }
}
function ascb(data)
{
	if(data==0) alert("加入喜欢列表成功");
}
function addwatchstate(watch)
{
	if(curuserid==0) 
	 {
		alert("请先登录");
	 }
	else
	 {
		bm.addFilmwatchsate(curfilmid,curuserid,watch,awscb);
	 }
}
function awscb(data)
{
	if(data==1) alert("加入计划列表成功");
	else alert("加入已看列表");
}


//user.html
function updateinfo()
{
	var gender=1;
	var nickname=dwr.util.getValue("usernickname");
	var gender=dwr.util.getValue("usergender");
	var year=dwr.util.getValue("userbiryear");
	var month=dwr.util.getValue("userbirmonth");
	var day=dwr.util.getValue("userbirday");
	if(nickname!='')
	{
	if(year!=''&&year<=2000&&1900<=year)
	{
		if(month!=''&&month<=12&&1<=month)
			{
			if(day!=''&&day<=31&&1<=day)
				{
				  bm.updateuserinfo(curuserid,nickname,gender,year,month,day,udicb);
				}
			else 
				alert("日期不满足要求,请重新填写");
			
			}
		else 
			alert("月份不满足要求,请重新填写");
	}
	else 
		alert("年份不满足要求,请重新填写(1900~2000)");
	}
	else 
	alert("昵称不满足要求,请重新填写");
}
function udicb(data)
{
	if(data==0) alert("保存修改成功");
}
function userinit()
{
	timename=setTimeout("showusermovie();",2000);
}
function showusermovie()
{
	showplanmovie();
	showwatchmovie();
	showlikemovie();
	getusergroups();
	showuserinfo();
	
}

function showlikemovie()
{
   bm.getuserlikemovie(curuserid,slmcb);	
}
function slmcb(data)
{
	var nameElement = document.getElementById("likemovie");
    nameElement.innerHTML="";
    var nameel=document.createElement("div");
    var movielist='';
    for(var i=0;i<data.length;i++)
    {
    	movielist=movielist+'<span class="row"><span style="margin-left:200px">'+
    	'<a href="film-single.html?parm='+data[i]['filmId']+'">'+data[i]['name']+'</a></span><span style="margin-left:300px">'+data[i]['filmupdate']+'</span></span>'
    }
    nameel.innerHTML=movielist;
    nameElement.appendChild(nameel);
}

function showplanmovie()
{
	var p=1;
   bm.getuserplanmovie(curuserid,slmcb1);	
}

function slmcb1(data)
{
	var nameElement = document.getElementById("planmovie");
    nameElement.innerHTML="";
    var nameel=document.createElement("div");
    var movielist='';
    for(var i=0;i<data.length;i++)
    {
    	movielist=movielist+'<span class="row"><span style="margin-left:200px">'+
    	'<a href="film-single.html?parm='+data[i]['filmId']+'">'+data[i]['name']+'</a></span><span style="margin-left:300px">'+data[i]['filmupdate']+'</span></span>'
    }
    nameel.innerHTML=movielist;
    nameElement.appendChild(nameel);
}

function showwatchmovie()
{
  var p=2;
   bm.getuserwatchmovie(curuserid,slmcb2);	
}

function slmcb2(data)
{
	var nameElement = document.getElementById("watchmovie");
    nameElement.innerHTML="";
    var nameel=document.createElement("div");
    var movielist='';
    for(var i=0;i<data.length;i++)
    {
    	movielist=movielist+'<span class="row"><span style="margin-left:200px">'+
    	'<a href="film-single.html?parm='+data[i]['filmId']+'">'+data[i]['name']+'</a></span><span style="margin-left:300px">'+data[i]['filmupdate']+'</span></span>'
    }
    nameel.innerHTML=movielist;
    nameElement.appendChild(nameel);
}

function createnewgroup()
{
	var groupname=dwr.util.getValue("groupname");
	var groupdes=dwr.util.getValue("groupdes");
	bm.createAgroup(curuserid,groupname,groupdes,cngcb);
}
function cngcb(data)
{
	if(data==0) alert("创建成功");
	else alert("创建未成功");
}
function getusergroups()
{
	bm.getUserGroups(curuserid,ggcb);
}
function ggcb(data)
{
	var nameElement = document.getElementById("groupshow");
    nameElement.innerHTML="";
    var nameel=document.createElement("div");
    var movielist='';
    for(var i=0;i<data.length;i++)
    {
    	movielist=movielist+'<span class="row"><span style="margin-left:200px">'+
    	'<a href="group-single.html?parm='+data[i]['groupId']+'">'+data[i]['groupName']+'</a></span><span style="margin-left:300px">'+'<a href="#">是</a>'+'</span></span>';
    }
    nameel.innerHTML=movielist;
    nameElement.appendChild(nameel);
}
function showuserinfo()
{
	bm.getUserinfo(curuserid,sucb);
}
function sucb(data)
{
	var nameElement = document.getElementById("shownickname");
    nameElement.innerHTML=data['nickname'];
    var nameElement1 = document.getElementById("showemail");
    nameElement1.innerHTML=data['email'];
    var nameElement2 = document.getElementById("showbirthday");
    nameElement2.innerHTML=data['birthday'];
}
