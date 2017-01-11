<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/lib/jquery-1.10.2.min.js"></script>

<link rel="stylesheet" href="/gytlvi/static/plugins/layui/css/layui.css">
<script type="text/javascript" src="/gytlvi/static/plugins/layer/layer.js"></script>
<title>用户登录</title>
<style>
body {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
	background: url("/gytlvi/static/backstage/login/bg.jpg");
	background-size: 100%;
}

.main {
	width: 600px;
	margin: 0 auto;
	margin-top: 150px;
	background-color: transparent;
	color: #fff;
}
@media(max-width :768px){
	.main{
		width: 350px;
		left:117px;
	}
}
.formbox {
	padding: 30px;
	padding-left: 0;
}

.formbox input {
	background-color: transparent;
}
</style>
</head>
<body>
	<div class="main">
		<fieldset class="layui-elem-field">
			<legend>登录</legend>
			<div class="formbox">
				<form class="layui-form">
					<div class="layui-form-item">
						<label class="layui-form-label">帐号</label>
						<div class="layui-input-block">
							<input type="text" name="username" required lay-verify="required" placeholder="帐号" autocomplete="off" class="layui-input" value="">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">密码</label>
						<div class="layui-input-inline">
							<input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" value="">
						</div>
						<div class="layui-form-mid layui-word-aux"></div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit lay-filter="reg">登录</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-input-block">
							<a onclick="Reg()" style="cursor: pointer;">现在注册帐号</a>
							<a href="/gytlvi/" style="float: right;margin-right: 25%">回到首页</a>
						</div>
					</div>
				</form>
			</div>
		</fieldset>
	</div>
</body>
<script src="/gytlvi/static/plugins/layui/layui.js"></script>
<script>
	layui.use('form', function() {
		var form = layui.form();
		//监听提交
		form.on('submit(reg)', function(data) {
			//layer.msg(JSON.stringify(data.field));
			var loadIn = layer.load(1, {
				shade : [ 0.1, '#fff' ]
			//0.1透明度的白色背景
			});

			$.ajax({
				type : "post",
				url : "/gytlvi/backstageUser/dologin.html",
				data : data.field,
				datatype : "json",
				success : function(msg) {
					if (msg.type == "1") {
						layer.msg(msg.message);
						setTimeout(function() {
							location.href = "/gytlvi/public/index.html";
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
<script>
	function Reg() {
		window.location.href="/gytlvi";
		/* layer.open({
			type : 2,
			title : "注册",
			skin : 'layui-layer-rim', //加上边框
			area : ["600px" ,"300px"], //宽高
			content : '/gytlvi/backstageUser/toReg.html',
		}); */
	}
	$(document).ready(function() {
		$(".main").css("margin-top", ($(window).height() - $(".main").height()) * 0.5 + "px");
	});
</script>


</html>