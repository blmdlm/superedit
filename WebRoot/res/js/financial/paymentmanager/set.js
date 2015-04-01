//更改模态框
function change(id){
	var x=document.getElementById("confirm");
	x.onclick=function(){ set(id);};
	
	
}


function set(id){
var content=$("#content").val();
//alert(id+content);
if(content==null||content==""){
	alert("输入不能为空");
}else{
	
	var url="financial/paymentmanager/set";

	$.post(url,{id:id,content:content}).done(function(data){
		if(data == "OK"){
			window.location.href="financial/paymentmanager/set";  
		}
		
		
	});
}


}