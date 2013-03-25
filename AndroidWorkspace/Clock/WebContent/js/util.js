/*
var mycanvas=document.getElementById('clock');
var context=mycanvas.getContext('2d');
window.onload=init;
function init(){	
	context.translate(100,100);	
	draw();	
	setInterval(draw,1000);
}
function draw(){	
	context.clearRect(-100,-100,200,200);	
	var time=new Date();	
	var hour=(time.getHours()%12)*2*Math.PI/12;	
	var minute=time.getMinutes()*2*Math.PI/60;	
	var second=time.getSeconds()*2*Math.PI/60;	
	context.beginPath();	
	context.arc(0,0,100,0,2*Math.PI,false);	
	context.strokeStyle='#000';        
	context.lineWidth=17;	
	context.stroke();	
	context.fillStyle='#F000';  	
	context.textBaseline='top'; 	
	context.font="normal 14px sans-serif";	
	context.fillText('Canvas',-20,-60);	
	context.strokeStyle="#000";	
	context.lineWidth=5;        
	context.save();	
	context.rotate(hour);	
	context.beginPath();	
	context.moveTo(0,10);	
	context.lineTo(0,-50);	
	context.stroke();	
	context.restore();	
	context.strokeStyle="#000";	
	context.lineWidth=5;        
	context.save();	
	context.rotate(minute);	
	context.beginPath();	
	context.moveTo(0,10);	
	context.lineTo(0,-80);	
	context.stroke();	
	context.restore();	
	context.strokeStyle="#000";	
	context.lineWidth=3;        
	context.save();	
	context.rotate(second);	
	context.beginPath();	
	context.moveTo(0,10);	
	context.lineTo(0,-90);	
	context.stroke();	
	context.restore();
}

*/
var clock = document.getElementById('clock');
var ctx = clock.getContext("2d");
function init(){
	//ctx.fillStyle("#FF0000");
	ctx.fillRect(0,0,150,75);
	draw();
}

function draw(){
	var time = new Date();
	//console.log(time);
	var hour = time.getHours();
}




