function userlogin(){
	
	
	var username = $("#username").val();
	var password = $("#password").val();
	var user ={"username":username,"password":password};
	alert(user.username+" "+user.password);
//	alert(username+"  "+password);
    $.ajax({
            type: "POST",
            dataType: "json",
            url: "http://10.0.2.2/mysqltest/login.php",
            data: user,
            success: function(msg){
            	alert(msg.username);
            	
            }
    });       
}