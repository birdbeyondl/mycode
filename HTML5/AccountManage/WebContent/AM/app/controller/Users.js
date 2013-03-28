/**
 * @author birdbeyondl
 */
Ext.define('AM.controller.Users',{
	extend:'Ext.app.Controller',
	views:['user.UserGridPanel'],
	init:function(){
		console.log('Initialized Users! This happens before the Application launch function is called');
		this.control({
			
			'UserGridPanel':{
				itemdblclick:this.editUser 
			}
			
		});
	},
	
	eidtUser:function (grid,record){
		console.log('Double clicked on:'+record.get('username'));
	}
	//onPanelRendered:function(){
	//	console.log('The panel was rendered');
	//}
});