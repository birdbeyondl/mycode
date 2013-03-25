/**
 * @author birdbeyondl
 */

 
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
Ext.onReady(function(){
	var carousel1 = new Ext.Carousel({
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
	
	
});


*/	 

        
       
