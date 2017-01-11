<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/lib/jquery-1.10.2.min.js"></script>

<link rel="stylesheet" href="/gytlvi/static/plugins/layui/css/layui.css">
<script type="text/javascript" src="/gytlvi/static/plugins/layer/layer.js"></script>
<title>Insert title here</title>
<style>
body {
	padding: 20px;
}
</style>
</head>
<body>
	<form class="layui-form">
		<div class="layui-form-item">
			<label class="layui-form-label">帐号</label>
			<div class="layui-input-block">
				<input type="text" id="username" name="username" required lay-verify="required" placeholder="帐号" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-inline">
				<input type="password" id="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">重复密码</label>
			<div class="layui-input-inline">
				<input type="password" id="password_" name="password_" required lay-verify="required" placeholder="再次输入密码" autocomplete="off" class="layui-input">
			</div>
			<div class="layui-form-mid layui-word-aux"></div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="reg">提交注册</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
<script src="/gytlvi/static/plugins/layui/layui.js"></script>
<script type="text/javascript">
	layui.use('form', function() {
		var form = layui.form();
		$("#username").val("");
		$("#password").val("");
		$("#password_").val("");
		$("#username").focus();
		//监听提交
		form.on('submit(reg)', function(data) {
			//layer.msg(JSON.stringify(data.field));
			var loadIn = layer.load(1, {
				shade : [ 0.1, '#fff' ]
			//0.1透明度的白色背景
			});
			$.ajax({
				type : "post",
				url : "/gytlvi/backstageUser/doReg.html",
				/* data : data.field, */
				datatype : "json",
				success : function(msg) {
					//alert(msg);
					//alert(msg.code);
					if (msg.type == "1") {
						layer.msg(msg.message);
						setTimeout(function() {
							parent.layer.closeAll();
						}, 1000);
					} else {
						layer.close(loadIn);
						layer.msg(msg.message);
					}
				},
				error : function() {
					return false;
				}
			});
			return false;
		});
	});
</script>
</html>