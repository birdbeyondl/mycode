/*

Ext.setup({
    tabletStartupScreen: 'tablet_startup.png',
    phoneStartupScreen: 'phone_startup.png',
    icon: 'icon.png',
    glossOnIcon: false,
    onReady: function() {
   
        // Create a Carousel of Items
        var carousel1 = new Ext.Carousel({
            defaults: {
                cls: 'card'
            },
            items: [{
                title: 'Tab 1',
                html: ' <img src="http://img02.taobaocdn.com/tps/i2/T1ayqJXm4zXXXXXXXX-490-170.jpg" alt="img1"/>'
            },
            {
                title: 'Tab 2',
                html: '<img src="http://i.mmcdn.cn/simba/img/T1vQWJXfVsXXXXXXXX.png?noq=y" alt="img2"/>'
            },
            {
                title: 'Tab 3',
                html: '<img src="http://img04.taobaocdn.com/tps/i4/T1ML9JXcBtXXXXXXXX-490-170.png" alt="img3"/>'
            }]
        });
        
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
                flex: 1
            },
            items: carousel1
        });
     /*
    }
});
 */
 
 

 
 
 Ext.application({
 	name:'home',
 	launch:function(){
 		
 		var carousel = new Ext.Carousel({
            defaults: {
                cls: 'card'
            },
            items: [{
                title: 'Tab 1',
                html: ' <img src="http://img02.taobaocdn.com/tps/i2/T1ayqJXm4zXXXXXXXX-490-170.jpg" alt="img1"/>'
            },
            {
                title: 'Tab 2',
                html: '<img src="http://i.mmcdn.cn/simba/img/T1vQWJXfVsXXXXXXXX.png?noq=y" alt="img2"/>'
            },
            {
                title: 'Tab 3',
                html: '<img src="http://img04.taobaocdn.com/tps/i4/T1ML9JXcBtXXXXXXXX-490-170.png" alt="img3"/>'
            }]
        });
 		
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
				ui:'round',
				text:'Register'
			},
			{
				ui:'round',
				text:'Login'
			}]
		}];
 		
 		
 		Ext.create("Ext.Panel",{
 			fullscreen:true,
 			layout:{
 				type:'vbox',
 				align:'stretch'
 			},
 			defaults:{
 				flex:1
 			},
 			items:[carousel,button_cfg]
 		});
 	}
 	
 });
 