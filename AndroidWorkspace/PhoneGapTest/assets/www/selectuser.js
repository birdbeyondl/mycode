var xmlHttp;

function showUser(str)
{
	alert(" "+str);
	xmlHttp = GetXmlHttpObject();
	if(xmlHttp ==null)
	{
		alert("ä¯ÀÀÆ÷²»Ö§³ÖHTTP Request");
		return;
	}
	var url = "http://10.0.2.2/mysqltest/getuser.php";
	url = url+"?q="+str;
	url = url+"&sid="+Math.random();
	xmlHttp.onreadystatechange=stateChanged;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
}

function stateChanged()
{
	if(xmlHttp.readyState==4||xmlHttp.readyState=="complete")
	{
		document.getElementById("textHint").innerHTML=xmlHttp.responseText;
		
	}
}

function GetXmlHttpObject()
{
	var xmlHttp=null;
	try{
		xmlHttp=new XMLHttpRequest();
	}catch(e){
		try{
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return xmlHttp;
}
