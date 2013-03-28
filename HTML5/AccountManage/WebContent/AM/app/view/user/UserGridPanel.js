
Ext.define('AM.view.user.UserGridPanel',{
	extend:'Ext.grid.Panel',
	alias:'widget.UserGridPanel',
	requires:['AM.store.Users'],
	title:'All Users',
	initComponent:function(){
		this.store = AM.store.Users;
		this.columns = this.buildColumns();
		this.callParent();
	
	},
	buildColumns:function(){
		return[
		   {
			   header :'FirstName',
			   dataIndex:'firstname',
			   width:70
		   },
		   {
			   header:'LastName',
			   dataIndex:'lastname',
			   width:70
		   },
		   {
			   header:'Age',
			   dataIndex:'age',
			   width:40
		   }
		];
	}
});