 //点击查看所有稿件
 function check(authorid){	
 	//更改模态框的body内容
 	var url="chiefeditor/querymanager/allscripts";
 	$.post(url,{authorid:authorid},function(results){
 		//alert(data);
		
 		if(results == null||results==""){
 			$("#result").text("还没有向本杂志投递过稿件");
 		}else{
 			var x=document.getElementById("result");
 		    var inHtml="<table class='table table-hover .table-striped table-bordered'><tr><td>稿件标题</td><td>投递时间</td></tr>";
 			for (var script in results) {
				inHtml=inHtml
				+"<tr><td><a href='chiefeditor/querymanager/scriptdetail?id="+results[script][0]+"'>"+results[script][1]+"</a></td><td>"+results[script][2]+"</td></tr>";
			};
 		    inHtml=inHtml+"</div>";
 		   x.innerHTML=inHtml;
 		}
 	});
}

