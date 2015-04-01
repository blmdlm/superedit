
 //点击查看详细信息
 
 function check(id){
	 showPayment(id);
	showAudit(id);
	showProofread(id);
	showCompose(id);
	$(".detail").fadeIn("slow");
	
 }
 
 
 function showPayment(id){
	 	var url="chiefeditor/querymanager/payment";
	 	$.post(url,{id:id},function(result){
	 		$("#payment").text(result);
	 	});
	 
}

 
 function showAudit(id){
	 	var url="chiefeditor/querymanager/audit";
	 	$.post(url,{id:id},function(result){
	 		$("#audit").text(result);
	 	});
	 
 }
 
 function showProofread(id){
	 var url="chiefeditor/querymanager/proofread";
	 $.post(url,{id:id},function(result){
		 $("#proofread").text(result);
	 });
	 
 }
 
 function showCompose(id){
	 var url="chiefeditor/querymanager/compose";
	 $.post(url,{id:id},function(result){
		 $("#compose").text(result);
	 });
	 
 }
 

