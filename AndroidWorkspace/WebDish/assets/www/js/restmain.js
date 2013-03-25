function Init(){
			var restid=localStorage.getItem("restid");
			
			$.ajax({
				type : "POST",
				url : "http://122.205.129.39:8081/0713.me/trunk/home/mobile_rest.php?do=main",
				data : "restaurantid="+restid,
				cache : false,
				dataType : "json",
				success : function(data) {
				show_data(data);	
				$.mobile.hidePageLoadingMsg();		
				}
			});/*
			
			$.ajax({
				type : "POST",
				url : "http://www.0713.me/mobile/mobile_search.php?ac=newlist",
				data : "searchtype="+searchtype+"&key="+key+"&area="+area+"&kind="+kind+"&page="+page,
				cache : false,
				dataType : "json",
				success : function(data) {
				show_data(data);	
				$.mobile.hidePageLoadingMsg();		
				}
			});
			*/
		}
		function showPic(window, Util, PhotoSwipe,data) {
				 Util.Events.domReady(function (e) {
					 var instance, indicators;
					 instance = PhotoSwipe.attach(
						[	
							{ url: "images/1.jpg" },
							{ url: "images/2.jpg"},
							{ url: "images/3.jpg" },
							{ url: "images/4.jpg" }
						],
						{
							target: window.document.querySelectorAll('#PhotoSwipeTarget')[0],
							preventHide: true,
							getImageSource: function (obj) {
								return obj.url;
							},
							getImageCaption: function (obj) {
								return obj.caption;
							}
						}
					);
					indicators = window.document.querySelectorAll('#Indicators span');
					instance.addEventHandler(PhotoSwipe.EventTypes.onDisplayImage, function (e) {
						var i, len;
						for (i = 0, len = indicators.length; i < len; i++) {
							indicators[i].setAttribute('class', '');
						}
						indicators[e.index].setAttribute('class', 'current');
					});
					instance.show(0);
				});
			}
		function show_data(data){
				//showPic(window, window.Code.Util, window.Code.PhotoSwipe,data);
				
			 	var infohtml='<div id="info" data-theme="e"><p><strong>主&nbsp;打&nbsp;菜:</strong>'+data.info.Cuisine_Name+'<br><strong>地　　址:</strong>'+data.info.Merchant_Address+'<br> <strong>交通路线:</strong>'+data.info.Merchant_Translation+'<br><strong>营业时间:</strong>'+data.info.Merchant_Opentime;
				if(data.info.Merchant_Avgpay!=null)	
				{
					infohtml +=	'<br><strong>参考消费:</strong>￥'+data.info.Merchant_Avgpay+'（每人）';
				}
				infohtml +='<br><strong>服务电话:</strong>'+data.info.Merchant_Contact_Mobile+'<p></div>';
				
				var headerhtml='<div id="guide" data-role="navbar" data-theme="e" class="ui-navbar" role="navigation"><ul class="ui-grid-b"><li class="ui-block-a"><a href="#"  data-icon="home" onclick="GotoIndex()" data-corners="false" data-shadow="false" data-iconshadow="true" data-inline="false" data-wrapperels="span" data-iconpos="top" class="ui-btn ui-btn-up-e ui-btn-icon-top ui-btn-up-undefined"><span class="ui-btn-inner"><span class="ui-btn-text">首页</span><span class="ui-icon ui-icon-home ui-icon-shadow"></span></span></a></li><li class="ui-block-b"><a href="#" onclick="GotoRestSeat('+data.info.Merchant_Name+')" data-icon="grid"  data-corners="false" data-shadow="false" data-iconshadow="true" data-inline="false" data-wrapperels="span" data-iconpos="top" class="ui-btn ui-btn-up-e ui-btn-icon-top ui-btn-up-undefined"><span class="ui-btn-inner"><span class="ui-btn-text">订座</span><span class="ui-icon ui-icon-grid ui-icon-shadow"></span></span></a></li><li class="ui-block-c"><a href="#" onclick="GotoRestDishList('+data.info.Merchant_Name+')" data-icon="plus" data-corners="false" data-shadow="false" data-iconshadow="true" data-inline="false" data-wrapperels="span" data-iconpos="top" class="ui-btn ui-btn-up-e ui-btn-icon-top"><span class="ui-btn-inner"><span class="ui-btn-text">点菜</span><span class="ui-icon ui-icon-plus ui-icon-shadow"></span></span></a></li></ul></div>';
				//显示界面
				$("#title").html(data.info.Merchant_Name);
				$("#header").append(headerhtml);
				//$("#main").append(infohtml);
		}