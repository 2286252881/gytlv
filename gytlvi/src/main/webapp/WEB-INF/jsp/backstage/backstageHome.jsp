<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/lib/jquery-1.10.2.min.js"></script>

<link rel="stylesheet" href="/gytlvi/static/plugins/layui/css/layui.css">
<script type="text/javascript" src="/gytlvi/static/plugins/layer/layer.js"></script>

<title>主页</title>
</head>
<body>
	<div style="width: 90%; margin: 10px auto;">
		<jsp:include page="navbar/menu.jsp"></jsp:include>
		<div>
			<iframe width="100%" height="768px" frameborder="0" scrolling="auto" src="/gytlvi/druid/weburi.html"></iframe>
		</div>
	</div>
</body>
<script src="/gytlvi/static/plugins/layui/layui.js"></script>
<script type="text/javascript">
	$(".layui-nav > li").eq(1).addClass("layui-this");
	layui.use('element', function() {
		var element = layui.element();
	});
</script>
</html>