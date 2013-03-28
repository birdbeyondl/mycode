Ext.define('AM.view.user.UserEditorWindow',{
	extend:'Ext.Window',
	requires:['AM.view.user.UserGridPanel','AM.view.user.UserFormPanel'],
	height:200,
	width:550,
	border:false,
	layout:{
		type:'hbox',
		align:'strech'
	},
	initComponent:function(){
		alert("UserEditero");
		this.items = this.buildItems();
		this.buttons = this.buildButtons();
		this.callParent();
		this.on('afterrender',this.onAfterRenderLoadForm,this);
		
	},
	
	buildItems:function(){
		return [
		    {
		    	xtype:'UserGridPanel',
		    	itemId:'userForm',
		    	flex:1
		    }
		 ];
	},
	
	buildButtons:function(){
		return [
		   {
			   text:'Save',
			   scope:this,
			   handler:this.onSaveBtn
		   },
		   {
			   text:'New',
			   scope:this,
			   handler:this.onNewBtn
		   }
		];
	},
	
	onGridItemClick:function(view,record){
		var formPanel = this.getComponent('userForm');
		formPanel.loadRecord(record);
	},
	
	onSaveBtn:function(){
		var gridPanel = this.getComponent('userForm'),
		gridStore = gridPanel.getStore(),
		formPanel = this.getComponent('userForm'),
		basicForm = formPanel.getForm(),
		currentRec = basicForm.getRecord(),
		formData = basicForm.getValues(),
		storeIndex = gridStore.indexOf(currentRec),
		key;
		
		currentRec.beginEdit();
		for(key in formData){
			currentRec.set(key,formData[key]);
		}
		currentRec.endEdit();
		currentRec.commit();
		
		if(storeIndex == -1){
			gridStore.add(currentRec);
			gridPanel.getSelectionModel().select(currentRec);
		}
	},
	
	onNewBtn:function(){
		var gridPanel = this.getComponent('userGrid'),
		formPanel = this.getComponent('userForm'),
		newModel = Ext.ModelManager.create({
			
		},'AM.model.User');
		gridPanel.getSelectionModel().clearSelections();
		formPanel.getForm().loadRecord(newModel);
	},
	
	onAfterRenderLoadForm:function(){
		this.onNewBtn();
	}
	
});