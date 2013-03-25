Ext.application({
	name:'Elife',
	launch:function(){
		//alert('ELife');
		Ext.create("Ext.TabPanel",{
			fullscreen:true,
			tabBarPosition:'bottom',
			layout:{
				pack:'center'
				
			},
			items:[
			{
				title:'Home',
				iconCls:'home',
				html:'<iframe width="100%" height="50%" src="home.html"></iframe>'
			},{
				title:'User',
				iconCls:'user',
				html:'<iframe width="100%" height="100%" src="user.html"></iframe>'
			},{
				title:'Settings',
				iconCls:'settings',
				html:'<iframe width="100%" height="100%" src="home.html"></iframe>'
			}
			]
		});
		//alert('home');
	}
});