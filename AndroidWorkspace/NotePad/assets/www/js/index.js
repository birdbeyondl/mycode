Ext.application({
	name:'NotesApp',
	userLoadMask:true,
	launch:function(){
		//alert('ELife');
		
		

		alert('home');
		Ext.create("Ext.Panel",{
			
			fullscreen:true,
			layout:'card',
			cardAnimation:'slide',
			items:[NotesApp.views.notesListContainer]
			
		});
		
		NotesApp.views.notesListContainer = new Ext.Panel({
			id:'notesListContainer',
			layout:'fit',
			html:'note pad'
		});

	}
});