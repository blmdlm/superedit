//更改模态框
function change(id){
	var x=document.getElementById("confirm");
	x.onclick=function(){ confirm(id);};
	
	
}


function confirm(id){

	
	var url="financial/paymentmanager/unpay";

	$.post(url,{id:id}).done(function(data){
		if(data == "OK"){
			window.location.href="financial/paymentmanager/unpay";  
		}
		
		
	});



}