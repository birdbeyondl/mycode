/**
* @author birdbeyondl
*/
var helloTouchApp = new Ext.Application({ 
	name: 'myApp', 
	useLoadMask: true, 
	launch: function () { 
	//Ext.Msg.alert('Hi', 'Hello Sencha Touch', Ext.emptyFn);
	var carousel1 = new Ext.Carousel({
            defaults: {
                cls: 'card',
                flex:'1'
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
	
/*	
	Ext.regModel('elife_kinds',{
		fields:'kind_name'
	});
	var ListStore = new Ext.data.Store({
		model:'elife_kinds',
		getGroupString:function(record){
			return record.get('kind_name')[0];
		},
		data:[{
			kind_name:'Find Cai xi'},{
				kind_name:'Find hotel'},{
					kind_name:'Find Caipin'
			}]
	});
	
	var List = new Ext.Panel({
		items:{
			layout: //  Ext.is.Phone ? 'fit' :
				{
				type :'vbox',
				align :'center',
				pack :'center'
			},
			cls:'demo-list',
			items:[{
				//width:Ext.is.Phone ? undefined:300,
				//height:Ext.is.Phone? undefined:500,
				xtype:'list',
				onItenDisclosure:function(record,btn,index){
					Ext.Msg.alert('Tap','Disclosure',Ext.emptyFn);
				},
				store:ListStore
				//itemTpl:'<div class="" >'
			}]
		}
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
            items: [carousel1,button_cfg]
        });	
	}
});
