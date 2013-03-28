/**
 * @author birdbeyondl
 */
Ext.application({
	name:'LocalStorage',
	launch:(function(){
 		Ext.regModel("user",{
 			fields:[
 			        {name:'name',type:'string'}
 			        
 			]
 		});
 		
 		var ajaxProxy = new Ext.data.proxy.Ajax({
 			url:'person1.jsp',
 			model:'user',
 			reader:'json'
 		});
 		
 		ajaxProxy.doRequest(new Ext.data.Operation(),function(o){
 			alert(o);
 		});
		
	})
});