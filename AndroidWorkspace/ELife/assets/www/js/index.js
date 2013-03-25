Ext.setup({
    tabletStartupScreen: 'img/tablet_startup.png',
    phoneStartupScreen: 'img/phone_startup.png',
    icon: 'img/icon.png',
    glossOnIcon: false,
    onReady: function() {
        // Create a Carousel of Items
  
        var BottomTabs = new Ext.TabPanel({
        	tabBar: {
        		dock:'bottom',
        		ui:'light',
        		layout: {
        			pack:'center'
        		}
        	},
        	cardSwitchAnimation: {
        		type:'slide',
        		cover:true
        	},
        	defaults: {
        		scroll:'vertical'
        	},
        	items:[
        		{
        			title:'Home',
        			html:'<iframe  frameborder="0" width="100%" height="100%" src="home1.html"></iframe>',
        			iconCls:'home',
        			cls:'card card1',
        			content:'welcome.html'
        			
        		},
        		
        	{
        		title:'Favarites',
        		badgeText: '4',
        		cls:'card card2',
        		iconCls:'favorites',
        		html:'Favorites Card'
        	},
        	{
        		title:'User',
        		html:'<iframe  frameborder="0" width="100%" height="100%" src="welcome.html"></iframe>',
        		cls:'card card5',
        		iconCls:'user'
        	},
        	{
        		title:'Setting',
        		html:'Settings',
        		cls:'card card4',
        		iconCls:'settings'
        	},{
        		title:'About',
        		html: '<p>Docking</p>',
        		iconCls : 'info',
        		cls:'card card2',
        		badgeText:'4'
        	}]
        });
/*        
        var carousel2 = new Ext.Carousel({
            direction: 'vertical',
            ui: 'light',
            activeItem: 1,
            defaults: {
                cls: 'card'
            },
            items: [{
                title: 'Tab 1',
                html: '<img src="http://img02.taobaocdn.com/tps/i2/T1ayqJXm4zXXXXXXXX-490-170.jpg" alt="img1"/>'
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
*/
        new Ext.Panel({
            fullscreen: true,
            layout: {
                type: 'vbox',
                align: 'stretch'
            },
            defaults: {
                flex: 1
            },
            items: BottomTabs
        });
    }
});