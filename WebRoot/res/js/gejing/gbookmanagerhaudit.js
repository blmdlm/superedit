


var xmlHttp;
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
	}esle{
		xmlHttp.onreadystatechange=callback;
		xmlHttp.open("POST",url,true);
		xmlHttp.sendRequestHeader("Content-type","application/x-www-form-urlencoded;");
		xmlHttp.send(parameter);
	}
}


//调用方法



function handleAudit (id,status) {
	url="messagemanager/gbookmanager/handleaudit";
	sendAsynchronRequest(url,null,loadCallBack);	
}

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
			alert("正在加载连接对象");
		}
		if (xmlHttp.readyState==2) {
			alert("加载完毕连接对象");
		};
		if (xmlHttp.readyState==3) {
			alert("数据获取中");
		};
	}catch(e){
		alert(e);
	}











}