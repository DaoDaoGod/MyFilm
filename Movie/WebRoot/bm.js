function init()
{
	getViewList();
}
function getViewList()
{
	bm.getHotMovie(blCb);
	 
}

function blCb(data)
{ 
	var listElement = $("filmshow");
	listElement.innerHTML="";
	for (var i = 0 ; i < data.length ; i++ )
	{
		var titleDiv = document.createElement("div");
		titleDiv.innerHTML = data[i]['name'];
		listElement.appendChild(titleDiv);
	}

}