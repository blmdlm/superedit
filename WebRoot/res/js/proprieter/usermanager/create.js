


function create(){
	var role=$("#role").val();
	

	alert("role="+role+" email="+email+" password="+password);
	if(role==6){
			
		$("#modalbtn").click();
		

	}else{
		
		var email=$("#email").val();
		var password=$("#password").val();
		var url="proprieter/usermanager/create";
	 	$.post(url,
	 			{
	 			magazineid:0,
	 			role:role,
	 			email:email,
	 			password:password,
	 			},
	 			function(result){
	 			if(result==1){
	 				//跳转
	 				window.location.href="proprieter/usermanager/check";
	 			}else{
	 				alert(result);
	 			}	
	 			
	 		
	 	});
	
	
	}
	
	
	
}


//查看该出版社的所有杂志
function query(){	
	//更改模态框的body内容
	var url="proprieter/usermanager/allmagazines";
	$.post(url,function(results){
		//alert(data);
		
		if(results == null||results==""){
			$("#result").text("没有杂志");
		}else{
			var x=document.getElementById("result");
		    var inHtml="<table class='table table-hover .table-striped table-bordered'>";;
			for (var magazine in results) {
			
				inHtml=inHtml
				+"<tr><td>"+results[magazine][1]+"</td><td><button type='button' onclick='confirm("+results[magazine][0]+")' class='btn btn-info'>选择</button></td></tr>";
				
			};
		 
		   x.innerHTML=inHtml+"</table>";
		}
		
		
	});
	
	
	
	
	
}



function confirm(magazineid){
	var role=$("#role").val();
	var email=$("#email").val();
	var password=$("#password").val();
	var url="proprieter/usermanager/create";
 	$.post(url,
 			{magazineid:magazineid,
 			role:role,
 			email:email,
 			password:password,
 			},
 			function(result){
 			if(result==1){
 				//跳转
 				window.location.href="proprieter/usermanager/check";
 			}else{
 				alert(result);
 			}	
 			
 		
 	});
	
	
}













