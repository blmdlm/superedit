
//显示结果
function showResult(){
var input=$("#input").val();
 handleQuery(input);

}
//进行搜索
function handleQuery (name) {
	var url="proprieter/querymanager/authorsearch";
	$.post(url,{name:name},function(results){
		if(results != null){   //!!!!!!!!!!!!!!!!!!!!!!===""
			//alert(results);
 			var x=document.getElementById("result");
 		    var inHtml="<div class='row'>";
 			for (var author in results) {
			
				inHtml=inHtml
				 +"<div class='col-xs-6 col-md-3'>"
				 +"<a href='proprieter/querymanager/authordetail?id="+results[author][0]+"' class='thumbnail'>"
				 +"<img src='res/img/"+results[author][2]+".jpg' alt='"+results[author][1]+"' style='width:150px;height:150px'>"
				 +"<center><h3>"+results[author][1]+"</h3></center></a></div>"
					
			};
 		    inHtml=inHtml+"</div>";
 		   x.innerHTML=inHtml;
		};
		
	});
}
// 		    inHtml=inHtml+"<table class='table table-hover table-striped'>"
// 				+"<tr><td>姓名</td>"
// 				+"<td>性别</td>"
// 				+"<td>手机</td>"
// 				+"<td>邮箱</td>"
// 				+"<td>地址</td>"
// 				+"<td>注册时间</td>"
// 				+"<td>投稿数</td>"
// 				+"<td>录用数</td>"
// 				+"<td>录用比</td>"			
// 				+"<td>查看所有稿件</td></tr>";
// 			for (var author in results) {
				
// 				inHtml=inHtml+"<tr class='"+results[author][10]+"'>"
// 				+"<td>"+results[author][1]+"</td>"
// 				+"<td>"+results[author][2]+"</td>"
// 				+"<td>"+results[author][3]+"</td>"
// 				+"<td>"+results[author][4]+"</td>"
// 				+"<td>"+results[author][5]+"</td>"
// 				+"<td>"+results[author][6]+"</td>"
// 				+"<td>"+results[author][7]+"</td>"
// 				+"<td>"+results[author][8]+"</td>"
// 				+"<td>"+results[author][9]+"</td>"
// 				//+"<td><button type='button' class='btn btn-info' data-toggle='modal' data-target='#mymodal' onclick='change("+${results[author][0]}+")'>查看稿件</button></td></tr>";
						
// 			};
						
// 		inHtml=inHtml+"</table>";

// x.innerHTML=inHtml;




// //点击约稿
// function change(id){
// 	//更改模态框的确认按钮的触发函数
// 	var x=document.getElementById("confirm");
// 	x.onclick=function(){ confirm(id);};
	
// 	alert(id);
	
// 	//更改模态框的body内容
// 	var url="editor/authorlib/solicithistory";
// 	$.post(url,{id:id},function(data){
// 		alert(data);
		
// 		if(data == null||data==""){
// 			 document.getElementById('record').style.display = "none";
// 			 document.getElementById('record_title').innerHTML="没有约稿记录";
// 		}else{
// 			 document.getElementById('time').innerHTML=data.time;
// 			 document.getElementById('content').innerHTML=data.content;
// 		}
		
		
// 	});
	
	
	
	
	
// }


// function confirm(id){

// 	var message=$("#message").val();
// 	if(message==null||message==""){
// 		alert("输入不能为空");
// 	}else{
// 	var url="editor/authorlib/solicit";

// 	$.post(url,{id:id,message:message}).done(function(data){
// 		if(data == "OK"){
// 			window.location.href="editor/authorlib/check";  
// 		}
		
		
// 	});
// 	}


// }