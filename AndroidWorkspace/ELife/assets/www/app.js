
var helloTouchApp = new Ext.Application({ //���ÿ�ܵ�Application��Ĺ��캯������һ��Ӧ��
name: 'myApp', //Ϊ���Ӧ��ָ������
useLoadMask: true, //ҳ���ȡ���ǰ����ʾ��Loading...������
launch: function () { //���ǳ�������
Ext.Msg.alert('ELife', 'Hello Elife', Ext.emptyFn);//�������ڱ���Hi������Hello Sencha Touch
	}
});
