
Ext.setup({
    tabletStartupScreen: 'tablet_startup.png',
    phoneStartupScreen: 'phone_startup.png',
    icon: 'icon.png',
    glossOnIcon: false,
    onReady: function() {
         
//增加注册和登录按钮
	var button_cfg = {
		layout: {
			type: 'vbox',
			pack: 'center',
			align:'stretch'
		},
		cls:'card1',
		scroll:'vertical',
		defaults:{
			layout:{
				type:'hbox'
			},
			flex:1,
			defaults:{
				xtype:'button',
				cls:'demobtn',
				flex:1
			}
		}
	};
	
		button_cfg.items = [{
			
		items:[{
			text:'Register'},
			{
				//ui:'round',
				text:'Login'
			}]
		}];
	

        new Ext.Panel({
            fullscreen: true,
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            defaults: {
                flex: 2
            },
            items: button_cfg
        });
     
    }
});
 
 
 

