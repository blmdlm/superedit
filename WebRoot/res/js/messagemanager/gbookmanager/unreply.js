//更改模态框
function change(id){
	var x=document.getElementById("confirm");
	x.onclick=function(){ reply(id);};
	
	
}


function reply(id){
var content=$("#content").val();
if(content==null||content==""){
	alert("输入不能为空");
}else{
	
	var url="messagemanager/gbookmanager/reply";

	$.post(url,{id:id,content:content}).done(function(data){
		if(data == "OK"){
			window.location.href="messagemanager/gbookmanager/unreply";  
		}
		
		
	});
}


}