/**
 * @author birdbeyondl
 */



Ext.Loader.setConfig({ enabled: true });
Ext.application({
	
	name:'AM',
	appFolder:'app',
	
	controllers:['Users'],
	
	launch:function(){
		
		alert("helloworld");
		console.log('COnsole ');
		//Ext.create('AM.view.user.UserEditorWindow').show();
		
		Ext.create('Ext.container.Viewport',{
			layout:'fit',
			items:[
			    {
			    	xtype:'UserGridPanel',
			    //	xtype:'panel',
			    	title:'Users',
			    	html:'<h1>List of users will<h1>'
			    }
			    ]
		});
	}
});



/*
Ext.Loader.setConfig({ enabled: true });
Ext.Loader.setPath('AM','');
Ext.require('AM.view.user.UserEditorWindow');
Ext.onReady(function(){
	alert("launched");
	Ext.create('AM.view.user.UserEditorWindow').show();
});
*/

