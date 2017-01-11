<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>DO</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<!-- 引用css -->
<link rel="stylesheet" type="text/css" href="/gytlvi/static/plugins/draging/css/style.css" />
<!-- 引用js -->
<script type="text/javascript" src="/gytlvi/static/plugins/draging/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/gytlvi/static/plugins/draging/js/drag.js"></script>
<title>图片移动</title>
<style type="text/css">
	.ui-state-disabled, .ui-widget-content .ui-state-disabled, .ui-widget-header .ui-state-disabled{
		opacity: 1 !important;
	}
</style>
<body>
	<div class='box box-4' style="height: 338px">
		<span onclick="fn(this);"><img src="/gytlvi/static/plugins/draging/img/01.jpg" width=150 height=150></span> <span onclick="fn(this);"><img src="/gytlvi/static/plugins/draging/img/02.jpg" width=150 height=150></span> <span onclick="fn(this);"><img src="/gytlvi/static/plugins/draging/img/03.jpg" width=150 height=150></span> <span onclick="fn(this);"><img src="/gytlvi/static/plugins/draging/img/04.jpg" width=150 height=150></span> <span onclick="fn(this);"><img src="/gytlvi/static/plugins/draging/img/05.jpg" width=150 height=150></span> <span onclick="fn(this);"><img src="/gytlvi/static/plugins/draging/img/06.jpg" width=150 height=150></span> <span onclick="fn(this);"><img src="/gytlvi/static/plugins/draging/img/07.jpg" width=150 height=150></span>
	</div>
	<p>点击图片进行组装</p>
	<div class='box box-4' id="content"></div>
</body>
<script type="text/javascript">
	$(function() {
		$("#content").draggable({
			snap : true,
		});
		$("#content").draggable("disable");
	});
	var fn = function(e) {
		var pic = e.innerHTML;
		var moveleft=165;
		var flag = 0;
		if ($("#content dl").length > 0) {
			$.each($("#content dl"), function(index, value) {
				if (pic == $("#content dl")[index].innerHTML) {
					alert("已经添加过该图片，不能重复添加!");
					flag = flag + 1;
				}
			});
			if ($("#content dl").length > 5 && flag == 0) {
				alert("少加点,兄弟!");
			} else {
				if (flag == 0) {
					moveleft=moveleft*$("#content dl").length+'px';
					if($("#content dl").length=1){
						$("#content").append("<dl style='position:absolute;margin-left:12px;left:"+moveleft+"';>" + e.innerHTML + "</dl>");
					}else{
						$("#content").append("<dl style='position: absolute;left:"+moveleft+"';>" + e.innerHTML + "</dl>");
					}
				}
			}
		} else {
			$("#content").append("<dl style='margin-left:13px;'>" + e.innerHTML + "</dl>");
		}
		$("dl").draggable({
			snap : true,
			containment : 'parent'
		});
		$('.box-4 dl').each(function() {
			$(this).dragging({
				move : 'both',
				randomPosition : false
			});
		});
	}
</script>
<link rel="stylesheet" type="text/css" href="/gytlvi/static/plugins/jqueryui/jquery-ui.min.css">
<script src="/gytlvi/static/plugins/jqueryui/jquery-ui.min.js"></script>
</html>