//显示结果
function showResult() {
	var input = $("#input").val();
	handleQuery(input);
}
// 进行搜索
function handleQuery(title) {
	var url = "chiefeditor/querymanager/scriptsearch";
	$.post(url, {
			title : title
			}).done(
					function(results) {
						alert(results);
						if (results != null) { // !!!!!!!!!!!!!!!!!!!!!!===""
							var x = document.getElementById("result");
							var inHtml = "";
							for ( var script in results) {
								inHtml = inHtml
										+ "<div class='panel "
										+ results[script][6]
										+ "'>"
										+ "<div class='panel-heading'>"
										+ results[script][1]
										+ " by "
										+ results[script][3]
										+ "</div>"
										+ "<a href='chiefeditor/querymanager/scriptdetail?id="
										+ results[script][0]
										+ "'><div class='panel-body'>"
										+ results[script][5]
										+ "</div></a></div>"
							}
							;
							x.innerHTML = inHtml;
						}
						;
					});
}
