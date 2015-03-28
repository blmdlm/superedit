 //点击查看所有稿件
 function check(authorid){	
 	//更改模态框的body内容
 	var url="editor/querymanager/allscripts";
 	$.post(url,{authorid:authorid},function(results){
 		//alert(data);
		
 		if(results == null||results==""){
 			$("#result").text("还没有向本杂志投递过稿件");
 		}else{
 			var x=document.getElementById("result01");
 		    var inHtml="<table class='table table-hover .table-striped table-bordered'><tr><td>稿件标题</td><td>投递时间</td></tr>";
 			for (var script in results) {
				inHtml=inHtml
				+"<tr><td><a href='editor/querymanager/scriptdetail?id="+results[script][0]+"'>"+results[script][1]+"</a></td><td>"+results[script][2]+"</td></tr>";
			};
 		    inHtml=inHtml+"</div>";
 		   x.innerHTML=inHtml;
 		}
 	});
}


 
//点击约稿
 function change(id){
 	//更改模态框的确认按钮的触发函数
 	var x=document.getElementById("confirm");
 	x.onclick=function(){ confirm(id);};
 	
 	//alert(id);
 	
 	//更改模态框的body内容
 	var url="editor/querymanager/solicithistory";
 	$.post(url,{id:id},function(data){
 		//alert(data);
 		
 		if(data == null||data==""){
 			 document.getElementById('record').style.display = "none";
 			 document.getElementById('record_title').innerHTML="没有约稿记录";
 		}else{
 			 document.getElementById('time').innerHTML=data.time;
 			 document.getElementById('content').innerHTML=data.content;
 		}
 		
 		
 	});
 	
 	
 	
 	
 	
 }


 function confirm(id){

 	var message=$("#message").val();
 	if(message==null||message==""){
 		alert("输入不能为空");
 	}else{
 	var url="editor/querymanager/solicit";

 	$.post(url,{id:id,message:message}).done(function(data){
 		if(data == "OK"){
 			window.location.href="editor/querymanager/authordetail?id="+id;  
 		}
 		
 		
 	});
 	}


 }