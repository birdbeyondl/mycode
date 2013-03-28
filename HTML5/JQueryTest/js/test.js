$(function(){
     //alert("testJquery");
      $(".test").css("background-color",'#ff0000');
      $("#a").val("mstar");
      
      var $li_1 = $("<li> 雪梨 </li>");
      var $li_2 = $("<li> 南瓜 </li>");
      $("ul").append($li_1);
      $("ul").append($li_2);
      
});
		

$("p").css("background-color",'#00ff00');

var $ele = $("ul li:eq(1)");
var text = $ele.text();

//alert(text);
//alert($ele.attr("title"));


