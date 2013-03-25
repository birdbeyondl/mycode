function submitcheck(){
	var state=localStorage.getItem("LoginState");
	if(state==null){  //未登录状态则验证手机号
	   var CheckPhone=localStorage.getItem("CheckPhone");
	   if(CheckPhone==null){alert("请先验证您的手机号");return;} 
	   else{
		   var phoneObj=JSON.parse(CheckPhone);
	      if(phoneObj.checksign!=1){
		   alert("请先验证您的手机号");
		   return;
	      }
	   }
	}
	
	    //检查手机的有效性
	    var phoneVal=$("#ordertel").val();
	    if(phoneVal=="" ){
		    alert("预定手机号不能空");
		    return;
	    }else if(!new RegExp(/^[1][3,5,8][0-9]{9}$/).test(phoneVal)){
	    	alert("请输入正确格式的订餐人联系电话");
		    return;
	    }
	
	    var ordername=$("#name").val();
	    if(ordername==""){
		    alert("请填写订餐人姓名");
		    return;
	    }
	
	    var restid=localStorage.getItem("restid");
	    var SeatID=localStorage.getItem("SeatID");
	    var Date=localStorage.getItem("Date");
	    var Time=localStorage.getItem("Time");
	    var Number=localStorage.getItem("Number");
	    var requestinfo=$("#requestinfo").val();
	    if(requestinfo==""){
		    postdata="restaurantid="+restid+"&phone="+phoneVal+"&reserveseatingid="+SeatID+"&reservedate="+Date+"&reservetime="+Time+"&reservenum="+Number;
	    }else{
		    postdata="restaurantid="+restid+"&phone="+phoneVal+"&reserveseatingid="+SeatID+"&reservedate="+Date+"&reservetime="+Time+"&reservenum="+Number+"&requestinfo="+requestinfo;
	    }
	
	
	//url : "http://www.0713.me/mobile/rest.php?do=reserveSeating",
	//url : "http://122.205.129.39:8081/0713.me/trunk/home/mobile_rest.php?do=reserveSeating",
	    if(localStorage.getItem("SeatID")!=null){
		    //写订座单
		    $.ajax({
		    type : "get",
		    url : "http://www.0713.me/mobile/rest.php?do=reserveSeating",
		    data : postdata,
		    cache : false,
		    dataType : "json",
		    success : function(data) {
			    if(data.status==1){
				    localStorage.setItem("assignid",data.assignid);//存储订位单ID
				    top.location="mobile_rest_mymenu.html";				
			    }
			    else{
			    	alert("提交失败");
			    }
		    }
	     });	
	    }
	
}

function DateTimecheck(){//获取座位列表前，检查预定时间的有效性
	//检查预定时间，格式：2012-01-09 8:00:00
	var date=$("#date").val();
	
	var times=$("#time").val().split(" ");
	if(times[1]=="上午")
	{
		var hours1=parseInt(times[0].split(":")[0],10);
		var min1=times[0].split(":")[1];
		
		var isopentime=hours1+":"+min1;
		var time=times[0]+":00";
	}
	else
	{
		var hours=parseInt(times[0].split(":")[0],10);
		if(hours!=12){
			hours+=12;
		}
		var min=times[0].split(":")[1];
		
		var isopentime=hours+":"+min;//截取时间，判断是否在营业时间内
		var time=hours+":"+min+":00";
	}
	var ordertime=date+" "+time;//订餐日期时间	
	var curDatetime=curDateTime()//系统当前日期时间
	
	//20分钟内不允许订位
	var availabletime=(Date.parse(ordertime)-Date.parse(curDatetime))/(1000*60);

	if(availabletime>20){
		checkopentime(isopentime,date)//检查是否在营业时间内
	}else{
		alert("对不起，我们不提供20分钟以内的订餐");
	}
}


function checkopentime(time,date)
{
	var restid=localStorage.getItem("restid");
	
	//url : "http://www.0713.me/mobile/rest.php?do=opentime",
	//url : "http://122.205.129.39:8081/0713.me/trunk/home/mobile_rest.php?do=opentime",
	$.ajax({
		type : "get",
		url : "http://www.0713.me/mobile/rest.php?do=opentime",
		data : "restaurantid="+restid+"&time="+time,
		cache : false,
		dataType : "json",
		success : function(data) {
			if(data.status=="1"){
				getavailableseat(time,restid,date);
			}
			else{
				alert("订餐时间已过！本店提供"+data.start+"至"+data.end+"时间段内的订餐服务");
			}
		}
	});
}


function getavailableseat(time,restid,date){
	//检查用餐人数
	var penum=$("#number").val();
	if(penum==""){
		alert("请填写用餐人数");
		return;
	}

	var date=$("#date").val();
	//url : "http://www.0713.me/mobile/rest.php?do=availableSeating",
	//url : "http://122.205.129.39:8081/0713.me/trunk/home/mobile_rest.php?do=availableSeating",
	$.ajax({
		type : "get",
		url : "http://www.0713.me/mobile/rest.php?do=availableSeating",
		data : "restaurantid="+restid+"&date="+date+"&time="+time+"&penum="+penum,
		cache : false,
		dataType : "json",
		success : function(data) {
			if(data.num>0){
				var tmphtml="";
				for(var i=0;i<data.num;i++){
					tmphtml+='<li><a href="#main" onclick="orderseat('+data.seatings[i].seatingid+',\''+data.seatings[i].seatingname+'\',\''+data.seatings[i].roomname+'\')">'+data.seatings[i].seatingname+'|'+data.seatings[i].roomname+'</a></li>';
				}
				$("#lists").empty();
				$("#lists").append(tmphtml);					
				$("#lists").listview('refresh');
			/*	localStorage.setItem("Date",date);
				localStorage.setItem("Time",time);
				localStorage.setItem("Number",penum);
				*/
			}else{
				$("#seatcontent").empty();
				$("#seatcontent").append('<a data-role="button" href="#main" class="ui-btn ui-btn-up-e ui-btn-corner-all ui-shadow ui-btn-up-undefined"><span class="ui-btn-inner ui-btn-corner-all"><span class="ui-btn-text">暂无可订座位</span></span></a>');
			}
		}
	});
}

function orderseat(seatid,seatname,roomname){
	//订座与点餐的餐厅是否一致
	var restid=localStorage.getItem("restid");
	if(localStorage.getItem("RestID")!=restid){
		if(confirm("您已经进入一家新的餐厅,是否确定在新餐厅中点餐?点击'确认':将会为您生成新的菜单,菜单中原有的美食将被删除点击'取消':保留原有菜单,并返回页面 "))
		{
			localStorage.removeItem("DishInfo");//清除存储
			localStorage.setItem("RestID",restid);	
		}
	}
	localStorage.setItem("SeatID",seatid);
	localStorage.setItem("SeatName",seatname);
	localStorage.setItem("RoomName",roomname);
	
	$("#seatbutton").html(seatname+"|"+roomname);	
}


function curDateTime(){  //获取当前日期时间，格式：2012-01-09 8:00:00
	var d = new Date();   
	var year = d.getFullYear();   
	var month = d.getMonth()+1;   
	var ddate = d.getDate();   
	var dday = d.getDay();   
	var hours = d.getHours();   
	var minutes = d.getMinutes();   
	var seconds = d.getSeconds();   
	var ms = d.getMilliseconds();     
	var curDateTime= year;  
	if(month>9)  
		curDateTime = curDateTime +"-"+month;  
	else  
		curDateTime = curDateTime +"-0"+month;  
	if(ddate>9)  
		curDateTime = curDateTime +"-"+ddate;  
	else  
		curDateTime = curDateTime +"-0"+ddate;  
	if(hours>9)  
		curDateTime = curDateTime +" "+hours;  
	else  
		curDateTime = curDateTime +" 0"+hours;  
	if(minutes>9)  
		curDateTime = curDateTime +":"+minutes;  
	else  
		curDateTime = curDateTime +":0"+minutes;  
	if(seconds>9)  
		curDateTime = curDateTime +":"+seconds;  
	else  
		curDateTime = curDateTime +":0"+seconds;  
	return curDateTime;   
}  
  