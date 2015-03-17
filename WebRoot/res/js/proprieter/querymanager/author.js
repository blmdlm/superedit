
//显示结果
function showResult(){
//获取用户输入 
var input=$("#input").val();
 //alert(input);
 
$("#result").fadeIn("slow");
 
 handleQuery(input);
 
}

function handleQuery (name) {
	var url="proprieter/querymanager/author";

	$.post(url,{name:name}).done(function(results){

		if(results != null){
			alert(results); 
		}
		
		
	});

}




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