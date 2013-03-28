function draw()
{
	var canvas = document.getElementById("canvas");
	var text = document.getElementById("textspan");
	
	
	
	if(canvas == null)
	{	
		return false;
	}
		
	var context=canvas.getContext('2d');
	
	var gl = context.createLinearGradient(0,0,0,300);
	
	gl.addColorStop(0,'rgb(255,255,0)');
	gl.addColorStop(1,'rgb(0,255,255)');
	
	text.innerHTML('<h2>hello</h2>');
	
//	context.fillStyle=g1;
	alert("success");
	context.fillRect(0,0,400,300);
	
	var n=0;
	var g2=context.createLinearGradient(0,0,300,0);
	g2.addColorStop(0,'rgba(0,0,255,0.5)');
	g2.addColorStop(1,'rgba(255,0,0,0.5)');
	for(var i =0;i<10;i++){
		context.beginPath();
		context.fillStyle=g2;
		context.arc(i*25,i*25,i*10,0,Math.PI*2,true);
		context.fill();
	}
}

function draw2()
{
	var canvas = document.getElementById('canvas');
	if(canvas == null){
		return false;
	}
	var context = canvas.getContext('2d');
	context.fillStyle = "#EEEEFF";
	context.fillRect(0,0,400,300);
	context.translate(200,50);
	context.fillStyle = 'rgba(255,0,0,0.25)';
	for(var i = 0;i<50;i++){
		context.translate(25,25);
		context.scale(0.95,0.95);
		context.rotate(Math.PI/10);
		context.fillRect(0,0,100,50);
	}
}
