
var xmlHttp;

function userlogin()
{
	//var username=document.getElementById("username").value;
	//var password = document.getElementById("password").value;
//	var user ={"username":username,"password":password};
//	alert(username+"  "+password);
	var username = $("#username").val();
	var password = $("#password").val();
	var user ={"username":username,"password":password};
	alert(username+"  "+password);
	xmlHttp=GetXmlHttpObject();
	xmlHttp = GetXmlHttpObject();
	if(xmlHttp ==null)
	{
		alert("ä¯ÀÀÆ÷²»Ö§³ÖHTTP Request");
		return;
	}
	var url = "http://10.0.2.2/mysqltest/login.php";
	url = url+"?username="+username;
	url = url+"&password="+password;
	xmlHttp.onreadystatechange=stateChanged;
	xmlHttp.open("GET",url,true);
	xmlHttp.send(null);
	
}



function stateChanged()
{
	if(xmlHttp.readyState==4||xmlHttp.readyState=="complete")
	{
		var res = xmlHttp.responseText;
		if(res == 0)
			alert("Failed"+res);
		else window.location.href='welcome.html';
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
