//
////显示结果
//function showResult(){
////获取用户输入 
//var input=$("#input").val();
//// alert(input);
// handleQuery(input);
//$("#result").fadeIn("slow");
// 
//
// 
//}
//
//function handleQuery (title) {
//	var url="proprieter/querymanager/script";
//	
//	$.post(url,{title:title}).done(function(results){
//		alert(results);
//		if(results != null){   //!!!!!!!!!!!!!!!!!!!!!!===""
//			var x=document.getElementById("result");
//		    var inHtml="";
//		    inHtml=inHtml+"<table class='table table-hover table-striped'>"
//				+"<tr><td>标题</td>"
//				+"<td>作者</td>"
//				+"<td>杂志</td>"
//				+"<td>投递时间</td>"
//				+"<td>处理状态</td>"
//				+"<td>详细</td></tr>";
//			for (var author in results) {
//				
//				inHtml=inHtml+"<tr class='"+results[author][8]+"'>"
//				+"<td>"+results[author][1]+"</td>"
//				+"<td>"+results[author][3]+"</td>"
//				+"<td>"+results[author][5]+"</td>"
//				+"<td>"+results[author][6]+"</td>"
//				+"<td>"+results[author][7]+"</td>"
//				+"<td><button type='button' class='btn btn-info' data-toggle='modal' data-target='#mymodal' onclick='showDetail("+results[author][0]+")'>查看稿件</button></td></tr>";
//						
//			};
//			
//
//	
//		
//			
//		inHtml=inHtml+"</table>";
//		
//
//
//
//x.innerHTML=inHtml;
//
//
//			};
//			
//		
//		
//		
//	});
//
//}




 //点击查看详细信息
 
 function check(id){
	showPayment(id);
	showAudit(id);
	showProofread(id);
	showCompose(id);
	$(".detail").fadeIn("slow");
	
 }
 
 

 function showPayment(id){
	 	var url="proprieter/querymanager/payment";
	 	$.post(url,{id:id},function(result){
	 		$("#payment").text(result);
	 	});
	 
}
 
 
 function showAudit(id){
	 	var url="proprieter/querymanager/audit";
	 	$.post(url,{id:id},function(result){
	 		$("#audit").text(result);
	 	});
	 
 }
 
 function showProofread(id){
	 var url="proprieter/querymanager/proofread";
	 $.post(url,{id:id},function(result){
		 $("#proofread").text(result);
	 });
	 
 }
 
 function showCompose(id){
	 var url="proprieter/querymanager/compose";
	 $.post(url,{id:id},function(result){
		 $("#compose").text(result);
	 });
	 
 }
 


// function confirm(id){
//
// 	var message=$("#message").val();
// 	if(message==null||message==""){
// 		alert("输入不能为空");
// 	}else{
// 	var url="editor/authorlib/solicit";
//
// 	$.post(url,{id:id,message:message}).done(function(data){
// 		if(data == "OK"){
// 			window.location.href="editor/authorlib/check";  
// 		}
//		
//		
// 	});
// 	}
//
// }