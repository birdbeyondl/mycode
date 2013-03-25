Ext.setup({
    icon: 'resources/images/icon.png',
    tabletStartupScreen: 'resources/images/tablet_startup.png',
    phoneStartupScreen: 'resources/image/phone_startup.png',
    glossOnIcon: false,
    onReady: function() {
	//监听按钮的Tab事件并弹出提示对话框
	var tapHandler = function(button, event) {
        var txt = "User tapped the '" + button.text + "' button.";
        Ext.Msg.alert('Prompt', txt);         
    };
    //定义第一组按钮
	 var buttonsGroup1 = [{
         text: 'Back',
         ui: 'back',
         handler: tapHandler
     }, {
         text: 'Default',
         handler: tapHandler
     }, {
         text: 'Round',
         ui: 'round',
         handler: tapHandler
     }];
	 //定义第二组按钮
     var buttonsGroup2 = [{
         xtype: 'segmentedbutton',
         items: [{
             text: 'Option 1',
             handler: tapHandler
         }, {
             text: 'Option 2',
             pressed : true,
             handler: tapHandler
         }]
     }];
     //定义显示在TabPanel上的dockedItems对象和显示方式
     var dockedItems = [new Ext.Toolbar({
         ui: 'light',
         dock: 'top',
         items: buttonsGroup1.concat(buttonsGroup2)
     })];
     
     //定义页面的主控件TabPanel和显示在它的TabBar上的对象
     var tabpanel = new Ext.TabPanel({
            fullscreen: true,
            tabBar: {
                dock: 'bottom',
                scroll: 'vertical',
                ui: 'light',                
                sortable: true,
                layout: {
                    pack: 'center'
                },
        	cardSwitchAnimation: {
        		type: 'slide',
        		cover: true
        		}
            },
            //定义各个tab对象和点击它们之后显示的内容
            items: [
            	{ iconCls:'home',title:'Home', cls:'card card2',html:'<iframe width="100%" height="25%" src="home_promotion.html"></iframe><br>' +
            			'											  <iframe width="100%" height="15%" src="home_login.html"></iframe><br>'},
                { iconCls: 'info', title: 'About', cls: 'card card1', html:'<p>This Sample show all kinds of icons in toolbar.</p>' },
              //  { iconCls: 'download', title: 'Download',cls: 'card card2', html: "<p>You clicked 'DownLoad' icon !</p>" },
              //  { iconCls: 'favorites', title: 'Favorites', cls: 'card card3', html: "<p>You clicked 'Favorites' icon !</p>"  },
                
                { iconCls: 'settings', title: 'Settings',cls: 'card card3', html: "<p>You clicked 'Settings' icon !</p>"  },
                { iconCls: 'user', title: 'User',cls: 'card card2', html: "<p>You clicked 'User' icon !</p>"  },
                { iconCls: 'more', title: 'More',cls: 'card card4', html: "<p>You clicked 'More' icon !</p>"  }
            ],
            dockedItems: dockedItems            
        });
    }
});