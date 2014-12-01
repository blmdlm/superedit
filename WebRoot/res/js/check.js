var precheckid = 0;
function showprecheck(page) {
	$
			.post(
					"B_preCheck/showprecheck",
					{
						"page" : page
					},
					function(data) {
						if (data != null) {
							var x = document.getElementById("prechecklist");
							x.innerHTML = "";
							var inhtml = "";
							for (var i = 0; i < data.length; i++) {
								inhtml = inhtml
										+ "<tr class=\"success\"><td></td><td></td><td>"
										+ data[i].title
										+ "</td><td></td><td></td><td id=\"name\">"
										+ data[i].author
										+ "</td><td></td><td></td><td>"
										+ data[i].time
										+ "</td><td></td><td></td><td><button type=\"button\" class=\"btn btn-success\" style=\"width:150px;\" onclick=\"changecurid("
										+ data[i].id
										+ ")\" data-toggle=\"modal\" data-target=\"#myModal\">进入审稿</button></td></tr>";
							}

							x.innerHTML = inhtml;
						}

					});

}

function changecurid(id) {
	precheckid = id;
}
function issure(i) {
	if (i == 1) {
		$.post("B_preCheck/EnterOnCheck", {
			"precheckid" : precheckid
		}, function(data) {
			if (data == 1) {
				window.location.href = "B_onCheck";
			} else {
				window.location.href = "B_preCheck";
			}
		});
	} else {
		precheckid = 0;
		window.location.href = "B_preCheck";
	}
}
function showoncheck(page) {

	$
			.post(
					"B_onCheck/showoncheck",
					{
						"page" : page
					},
					function(data) {
						if (data != null) {
							var x = document.getElementById("onchecklist");
							x.innerHTML = "";
							var inhtml = "";
							for (var i = 0; i < data.length; i++) {
								inhtml = inhtml
										+ "<tr class=\"success\"><td></td><td></td><td>"
										+ data[i].title
										+ "</td><td></td><td></td><td id=\"name\">"
										+ data[i].author
										+ "</td><td></td><td></td><td>"
										+ data[i].time
										+ "</td><td></td><td></td><td><button type=\"button\" class=\"btn btn-success\" style=\"width:150px;\" onclick=\"download("
										+ data[i].id
										+ ")\" data-toggle=\"modal\" data-target=\"#myModal\">下载</button></td>"
										+ "<td></td><td></td><td><button type=\"button\" class=\"btn btn-success\" style=\"width:150px;\" \" data-toggle=\"modal\" data-target=\"#uploadbox\" onclick=\"upload('"
										+ data[i].id + "')\">上传</button></td>"
										+ "</tr>";
							}

							x.innerHTML = inhtml;
						}

					});

}

function showpostcheck(page) {

	$
			.post(
					"B_onCheck/showpostcheck",
					{
						"page" : page
					},
					function(data) {
						if (data != null) {
							var x = document.getElementById("onchecklist");
							x.innerHTML = "";
							var inhtml = "";
							for (var i = 0; i < data.length; i++) {
								inhtml = inhtml
										+ "<tr class=\"success\"><td></td><td></td><td>"
										+ data[i].title
										+ "</td><td></td><td></td><td id=\"name\">"
										+ data[i].author
										+ "</td><td></td><td></td><td>"
										+ data[i].time
										+ "</td><td></td><td></td><td><button type=\"button\" class=\"btn btn-success\" style=\"width:150px;\" onclick=\"download("
										+ data[i].id
										+ ")\" data-toggle=\"modal\" data-target=\"#myModal\">下载</button></td>"
										+ "</tr>";
							}

							x.innerHTML = inhtml;
						}

					});

}
function download(id) {

	$.post("B_onCheck/showcuraudit", {
		"id" : id
	}, function(data) {
		var x = document.getElementById("downloadtitle");
		x.innerHTML = data.title;
		x = document.getElementById("downloadsummary");
		x.innerHTML = data.summary;
		x = document.getElementById("downloadorigin");
		x.onclick = function() {
			downloadOrigin(data.originlink);
		};
		x = document.getElementById("downloadlast");
		x.onclick = function() {
			downloadLast(data.lastlink);
		};
	});
}
function downloadOrigin(url) {
	openUrl(url);
}
function downloadLast(url) {
	openUrl(url);
}
function upload(id) {
	var x = document.getElementById("auditId");
	x.value = id;
}
function openUrl(url) {
	if (document.all) {
		var a = document.createElement("A");
		a.target = "_blank";
		a.href = url;
		document.body.appendChild(a);
		a.click();
		setTimeout(function() {
			a.parentNode.removeChild(a);
		}, 50);
	} else
		window.open(url, "_blank");
}
function finshupload() {
	$.post("B_onCheck/finishupload", {
		"id" : document.getElementById("auditId").value
	}, function(data) {
	});
}

