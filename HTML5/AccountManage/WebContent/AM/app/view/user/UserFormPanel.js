Ext.define('AM.view.user.UserFormPanel',{
	extend:'Ext.form.Panel',
	alias:'widget.UserFormPanel',
	bodyStyle:'padding:10px;background-color:#DCE5F0;border-left:none;',
	defaultType:'textfield',
	defaults:{
		anchor:'-10',
		labelWidth:70
	},
	initComponent:function(){
		this.items = this.buildItems();
		this.callParent();
	},
	buildItems:function(){
		return [
		        {
		        	fieldLabel:'FirstName',
		        	name:'firstname'
		        },{
		        	fieldLabel:'LastName',
		        	name:'lastname'
		        },{
		        	fieldLabel:'Age',
		        	name:'age'
		        }
		 ];
	}
});