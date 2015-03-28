//显示结果
function showResult() {
	var input = $("#input").val();
	handleQuery(input);

}
// 进行搜索
function handleQuery(name) {
	var url = "chiefeditor/querymanager/authorsearch";
	$.post(url, {
		name : name
	}, function(results) {
		if (results != null) { // !!!!!!!!!!!!!!!!!!!!!!===""
			// alert(results);
			var x = document.getElementById("result");
			var inHtml = "<div class='row'>";
			for ( var author in results) {

				inHtml = inHtml + "<div class='col-xs-6 col-md-3'>"
						+ "<a href='chiefeditor/querymanager/authordetail?id="
						+ results[author][0] + "' class='thumbnail'>"
						+ "<img src='res/img/" + results[author][2]
						+ ".jpg' alt='" + results[author][1]
						+ "' style='width:150px;height:150px'>"
						+ "<center><h3>" + results[author][1]
						+ "</h3></center></a></div>"

			}
			;
			inHtml = inHtml + "</div>";
			x.innerHTML = inHtml;
		}
		;

	});
}
