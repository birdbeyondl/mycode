function isincart(ID){
	if(localStorage.getItem("DishInfo")!=null){//菜单不为空
		var jsonObj = eval('(' + localStorage.getItem("DishInfo") + ')'); //把json字符串转换成对象
        var findDish = false;//是否找到产品ID,找到则为TRUE,否则为FALSH
        for (var obj in jsonObj) {
            if (jsonObj[obj].DishID == ID) {
                findDish = true;
                break;
            }
        }
        return findDish;
	}else{//菜单为空
		return false;
	}
}

function AddToShoppingCar(ID,Num,Price,Name,RestID) {
    if(localStorage.getItem("RestID")==null){
    
		localStorage.setItem("RestID",RestID);
	}

	else{
		
		if(localStorage.getItem("RestID")!=RestID && localStorage.getItem("DishInfo")!=null){
			if(confirm("您已经进入一家新的餐厅,是否确定在新餐厅中点餐?点击'确认':将会为您生成新的菜单,菜单中原有的美食将被删除点击'取消':保留原有菜单,并返回页面 ")){
				localStorage.removeItem("DishInfo");//清除存储
				localStorage.removeItem("SeatID");
				localStorage.removeItem("SeatName");
				localStorage.removeItem("RoomName");
				
				localStorage.setItem("RestID",RestID);
			}
			else{
				return ;
			}
		}
	}
	
	if($("#"+ID).attr("title")=='已成功加入菜单'){
		$("#"+ID).css("background","FFFFFF");
		$("#"+ID).attr("title","");		
		deletecookie(ID);	
	}
	else{
		$("#"+ID).css("background","FFFF99");
		$("#"+ID).attr("title","已成功加入菜单");	
		addcookie(ID,Num,Price,Name,RestID);
	}
	
}


function addcookie(ID,Num,Price,Name,RestID)
{
	if(localStorage.getItem("DishInfo")!=null){//菜单不为空
		var jsonObj = eval('(' + localStorage.getItem("DishInfo") + ')'); //把json字符串转换成对象
        var findDish = false;//是否找到产品ID,找到则为TRUE,否则为FALSH
        for (var obj in jsonObj) {
            if (jsonObj[obj].DishID == ID) {
                findDish = true;
                break;
            }
        }
        if (findDish== false) { //没找到,则添加
            jsonObj[jsonObj.length] = new Object();
            jsonObj[jsonObj.length-1].DishID = ID;
            jsonObj[jsonObj.length-1].DishNum = Num;
            jsonObj[jsonObj.length-1].DishPrice = Price;
            jsonObj[jsonObj.length-1].DishName = Name;
        }
	}else{//菜单为空
		//构建json字符串
		var jsonStr = "[{'DishID':'" + ID + "','DishNum':'" + Num + "','DishPrice':'" + Price + "','DishName':'" + Name + "'}]"; 
		var jsonObj = eval('(' + jsonStr + ')'); //把json字符串转换成对象
	}
	localStorage.setItem("DishInfo",JSON.stringify(jsonObj));
}

 function deletecookie(ID)
 {	   
	var jsonObj = eval('(' + localStorage.getItem('DishInfo') + ')');
	var i=0;
	var index;
	while(true)
	{
		if(jsonObj[i].DishID==ID) {index=i; break;}
		i++;
	}		
	jsonObj.splice(index,1);	
	localStorage.setItem("DishInfo",JSON.stringify(jsonObj));  //更新存储
}


function getorderdish()
{

	var jsonObj = eval('(' + localStorage.getItem('DishInfo') + ')');
	$("#menu ul").empty();
	var index=0;
	var totalnum = 0;
	var totalmoney = 0;
	for(var obj in jsonObj)
	{
		var temphtml=' <li style="border-bottom:2px solid white"><div id="menu" class="ui-grid-b">'+
    '<div class="ui-block-a" style="line-height:30px;width:40%;">'+
    '<span id="dishname">'+jsonObj[obj].DishName+'</span></div>'+
    '<div class="ui-block-b" style="line-height:30px;width:20%;text-align:center">'+
    '<span id="dishprice">￥'+jsonObj[obj].DishPrice+'</span>元&nbsp;&nbsp;&nbsp;x<span id="dishnum">'+jsonObj[obj].DishNum+'</span></div>'+
    '<div class="ui-block-c" style="line-height:30px;width:40%;text-align:right">'+
    '<span style="cursor:pointer;"><a href="#" data-role="button" data-inline="true" data-icon="minus" data-iconpos="notext" onclick="javascript:delCartQuantity('+index+','+jsonObj[obj].DishID+', 1)">minus</a></span>'+
    '<span style="cursor:pointer;"><a href="#" data-role="button" data-inline="true" data-icon="plus" data-iconpos="notext" onclick="javascript:addCartQuantity('+index+','+jsonObj[obj].DishID+', 1)">plus</a></span>'+
    '<span style="cursor:pointer;"><a href="#" data-role="button" data-inline="true" data-icon="delete" data-iconpos="notext" onclick="javascript:delDishItem('+index+')">delete</a></span></div></div></li>'
		
    index++;
	totalnum+=Number(jsonObj[obj].DishNum);
	totalmoney+=Number(jsonObj[obj].DishPrice)*Number(jsonObj[obj].DishNum);
	
	$("#menu ul").append(temphtml).trigger('create');
	}
	$("#totalprice").text(Math.round(totalmoney*100)/100);	
}
function addCartQuantity(index,ID,Num){

	 var jsonObj = eval('(' + localStorage.getItem('DishInfo') + ')'); 
	 jsonObj[index].DishNum = Number(jsonObj[index].DishNum) + Num;
	 localStorage.setItem("DishInfo",JSON.stringify(jsonObj)); //更新
	 getorderdish();
}
function delCartQuantity(index,ID,Num){

	var jsonObj = eval('(' + localStorage.getItem('DishInfo') + ')'); //如果有，把json字符串转换成对象
	if(Number(jsonObj[index].DishNum)>Num){
		jsonObj[index].DishNum = Number(jsonObj[index].DishNum) - Num;
		localStorage.setItem("DishInfo",JSON.stringify(jsonObj));  //更新
		getorderdish();
	 }
	 else{
		delDishItem(index); 
	 }
}
function delDishItem(index) {
	var jsonObj = eval('(' + localStorage.getItem('DishInfo') + ')'); //如果有，把json字符串转换成对象

	if (confirm("您是否确定删除该笔美食?点击'确认',删除该笔美食点击'取消',返回页面" )){
		
		jsonObj.splice(index,1);
		
		localStorage.setItem("DishInfo",JSON.stringify(jsonObj)); //更新  
		getorderdish();
	}
}


function submitorder(){
	var assignid=localStorage.getItem("assignid");
	if(assignid!=null){
		//提示是否去点菜, 生成订单
		var DishInfo=localStorage.getItem("DishInfo");
		var restid=localStorage.getItem("RestID");
		var phoneVal=localStorage.getItem("OrderPhone");
		var uid=localStorage.getItem("LoginUid");
		if(DishInfo==null||DishInfo==""){
			postdata="uid="+uid+"&RestID="+restid+"&phone="+phoneVal+"&OrderSeatID="+assignid;
		}
		else{
			postdata="uid="+uid+"&RestID="+restid+"&phone="+phoneVal+"&DishInfo="+DishInfo+"&OrderSeatID="+assignid;
		} 
		
		$.ajax({
			type : "get",
			url : "http://www.0713.me/mobile/rest.php?do=order",
			data : postdata,
			cache : false,
			dataType : "json",
			success : function(data) {
				if(data.orderid){
					//清空数据
					localStorage.removeItem("assignid");
					localStorage.removeItem("DishInfo");
					localStorage.removeItem("RestID");
					localStorage.removeItem("OrderPhone");
					localStorage.removeItem("Date");
					localStorage.removeItem("Time");
					localStorage.removeItem("Number");
					localStorage.removeItem("SeatName");
					localStorage.removeItem("RoomName");
					localStorage.removeItem("SeatID");
					
					//给一个订单提交成功的提示
					navigator.notification.alert("订单提交成功!",null,"在线点餐","知道了");
					top.location="mobile_rest_myOrder.html";				
				}else{
					alert("提交失败");
				}
			}
		});
		

	}else{
		navigator.notification.alert("请订座后在提交！",null,"在线点餐","知道了");
		top.location="mobile_rest_orderseat.html";
	}
}
