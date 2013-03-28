/**
 * 
 */

 Ext.application({
 	name:'proxy',
 	launch:function(){
 		
 		
 		Ext.regModel("user",{
 			fields:[
 			{name:'name',type:'string'},
 			{name:'age',type:'int'}
 			]
 		});
 		
 		//创建数据对象
 		var userData = [
 		{name:'birdbeyondl',age:1},
 		{name:'luo',age:23}
 		];
 		
 		//创建model的代理类
 		var memoryProxy = Ext.create("Ext.data.proxy.Memory",{
 			data:userData,
 			model:'user'
 		});
 		
 		memoryProxy.read(new Ext.data.Operation(),function(result){
 			var datas = result.resultSet.records;
 			Ext.Array.each(datas,function(model){
 				alert(model.get('name'));
 			});
 		});
 	}
 });