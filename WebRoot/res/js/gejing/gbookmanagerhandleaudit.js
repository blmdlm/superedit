

//js发送请求
/*var xmlHttp;
function createXMLHttpRequest(){
	if (window.XMLHttpRequest) {//mozilla
		xmlHttp=new XMLHttpRequest();
	}else if (window.ActiveXObject) {//IE
		try{
			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		}catch(e){
			try{
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){

			}
		}
	}


	if (xmlHttp==null) {
		alert("不能创建XMLHttpRequest对象");
		return false;
	};
}

function sendAsynchronRequest(url,parameter,callback){
	createXMLHttpRequest();
	if (parameter==null) {
		xmlHttp.onreadystatechange=callback;
		xmlHttp.open("GET",url,true);
		xmlHttp.send(null);
	}else{
		xmlHttp.onreadystatechange=callback;
		xmlHttp.open("POST",url,true);
		xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;");
		xmlHttp.send(parameter);
	}
}
*/

//jquey发送post请求




//更改模态框
function change(id,status){
	if(status=="2"){
		var x=document.getElementById("confirm01");
		x.onclick=function(){handleAudit(id,2);};
	}else if(status=="3"){}		
	var x=document.getElementById("confirm02");
	x.onclick=function(){handleAudit(id,3);
		
		
	}
	

	
	
}

//调用方法



function handleAudit (id,status) {
	//alert(id+" "+status);
	var url="messagemanager/gbookmanager/handleaudit";
	//var paramter="id="+id+"+&status="+status;
	//js方法
	//sendAsynchronRequest(url,paramter,loadCallBack);
	//jquery方法
	$.post(url,{id:id,status:status}).done(function(data){
//		alert("data="+data);
		if(data == "OK"){
//			alert("jquery跳转");
			window.location.href="messagemanager/gbookmanager/postaudit";  
		}
		
		
	});

}


//js回调函数
function loadCallBack(){
	try{
		if (xmlHttp.readyState==4) {
			if (xmlHttp.status==200) {
				var res=xmlHttp.responseText;
				if (res==null&&res=="") {
					
					alert("返回值有错误");
				}

				if (res=="OK") {
					alert("准备跳转");
					window.location.href="messagemanager/gbookmanager/postaudit";  

				};

		
			}

		}

		if (xmlHttp.readyState==1) {
			//alert("正在加载连接对象");
		}
		if (xmlHttp.readyState==2) {
			//alert("加载完毕连接对象");
		};
		if (xmlHttp.readyState==3) {
			//alert("数据获取中");
		};
	}catch(e){
		alert(e);
	}











}