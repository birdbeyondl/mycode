/**
 * 
 */
 

 

 
 
 (function (){
 	Ext.onReady(function(){
 		
 		/*
 		var win = new Ext.window.Window({
 			width:400,
 			height:300,
 			title:'Window',
 			layout:'fit',
 			shadow:true
 			
 		});
 		
 		Ext.get("btn1").on("click",function(){
 			win.show();
 		});
		*/
 		
 		var obj = {
 			say: function(){
 				alert(1111);
 			}
 		}
 		
 		var func = Ext.Function.alias(obj,'say');
 		func();
 		
 		
 		
 		Ext.define("myWin",{
 			extend:'Ext.window.Window',
 			width:400,
 			height:300,
 			title:'First',
 			initComponent:function(){
 				this.callParent(arguments);
 			}
 		})
 		Ext.create("myWin",{}).show();
 	});
 })();
 	
 
 
 