/**
 * @author birdbeyondl
 */
Ext.application({
	name:'LocalStorage',
	launch:(function(){
		//alert("helloworld");
 		Ext.regModel("user",{
 			fields:[
 			        {name:'name',type:'string'}
 			],
 			proxy:{
 				type:'sessionstorage',
 				id:'twitter-searches'
 			}
 		});
		
 		var mystore = new Ext.data.Store({
 			model:user
 		});
 		
 		mystore.add({name:'luo',age:24});
 		mystore.sync();
 		mystore.load();
 		var msg = [];
 		mystore.each(function(record){
 			msg.push(record.get('name'));
 		});
 		alert(msg.join("\n"));
	})
});