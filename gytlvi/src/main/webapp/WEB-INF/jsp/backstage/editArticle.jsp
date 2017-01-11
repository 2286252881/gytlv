<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" type="text/css" href="/gytlvi/static/wangEditor-2.1.22/dist/css/wangEditor.min.css">
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/wangEditor.min.js"></script>

<link rel="stylesheet" href="/gytlvi/static/plugins/layui/css/layui.css">
<script type="text/javascript" src="/gytlvi/static/plugins/layer/layer.js"></script>
<title>编辑文章页面</title>
</head>
<body>
	<div style="width: 90%; margin: 10px auto;">
		<jsp:include page="navbar/menu.jsp"></jsp:include>
		<input type="hidden" id="articleT" value="${article.articletype}"> <input type="hidden" id="support" value="${article.articlesupport}"> <input type="hidden" id="modle" value="${article.articlemodle}">
		<blockquote style="margin-top: 10px;" class="layui-elem-quote">
			<a href="/gytlvi/backstageArticle/toAllArticle.html">文章列表</a> >>文章编辑
		</blockquote>
		<form action="/gytlvi/backstageArticle/doEditArticle.html" method="post">
			<input type="hidden" id="id" name="id" value="${article.id}">
			<fieldset style="padding: 15px; border: none; border-top: 1px solid #eee;">
				<legend style="color: gray; font-size: 16px">文章分类</legend>
				<div class="layui-form-item">
					<select id="articletype" name="articletype" lay-verify="">
						<option value="">请选择</option>
						<c:forEach items="${articletypes}" var="articlety">
							<option value="${articlety.id}">${articlety.articletypename}</option>
						</c:forEach>
					</select>
				</div>
			</fieldset>
			<fieldset style="padding: 15px; border: none; border-top: 1px solid #eee;">
				<legend style="color: gray; font-size: 16px">其他配置</legend>
				<input type="checkbox" name="articlesupport" id="articlesupport" lay-skin="switch" checked> 是否博主推荐 &nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="articlemodle" value="1" checked="checked">公开 &nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" name="articlemodle" value="0">私有
			</fieldset>
			<fieldset style="padding: 15px; border: none; border-top: 1px solid #eee;">
				<legend style="color: gray; font-size: 16px">文章标题</legend>
				<input type="hidden" id="ck" name="ck" /> <input type="text" name="articlename" id="articlename" placeholder="请输入标题" autocomplete="off" class="layui-input" value="${article.articlename}" />
			</fieldset>
			<fieldset style="border: none; border-top: 1px solid #eee;">
				<legend>
					<span style="color: gray; font-size: 16px">文章内容</span>
				</legend>
			</fieldset>
			<textarea id="textarea2" name="articlecontent" style="height: 400px; max-height: 500px; padding: 20px">${article.articlecontent}</textarea>
			<div style="margin-top: 30px;">
				<button id="btn1" class="layui-btn" lay-submit>更改文章</button>
				<button type="reset" class="layui-btn layui-btn-primary">退出</button>
			</div>
		</form>
	</div>
</body>
<script src="/gytlvi/static/plugins/layui/layui.js"></script>
<script type="text/javascript">
	layui.use('element', function() {
		var element = layui.element();

	});
</script>
<script type="text/javascript">
	$(".layui-nav > li").eq(3).addClass("layui-this");
	//关闭日志打印
	wangEditor.config.printLog = false;
	var editor = new wangEditor('textarea2');
	editor.config.uploadImgUrl = '/gytlvi/upload/uploadImg.html';
	editor.config.uploadImgFileName = 'myFileName';
	// 设置 headers（举例）
	editor.config.uploadHeaders = {
		'Accept' : 'multipart/form-data'
	};
	editor.config.uploadImgFns.onload = function(resultText, xhr) {
		editor.command(null, 'InsertImage', resultText);
	}
	editor.config.hideLinkImg = true;
	editor.create();
	$("#articletype").val($("#articleT").val());
	if ($("#modle").val() == "1") {
		$("input:radio[name='articlemodle']").eq(0).attr("checked", true);
	}
	if ($("#modle").val() == "0") {
		$("input:radio[name='articlemodle']").eq(1).attr("checked", true);
	}
	if ($("#support").val() == "1") {
		$("#articlesupport").attr("checked", true);
	}
	if ($("#support").val() == "0") {
		$("#articlesupport").attr("checked", false);
	}
	$("#btn1").click(function() {
		if ($("#articletype").val() == "") {
			layer.alert('请选择一项文章分类!', {
				icon : 2
			});
			return false;
		}
		if ($("#articlename").val() == "") {
			layer.alert('文章标题不能为空!', {
				icon : 2
			});
			return false;
		}
		if ($("#articlesupport").is(':checked')) {
			$("#articlesupport").val("1");
		} else {
			$("#articlesupport").val("0");
		}
		$("#ck").val($("#articlesupport").val());
		// 获取格式化后的纯文本
		var html = editor.$txt.html();
		// 获取格式化后的纯文本
		var formatText = editor.$txt.formatText();
		if (formatText == "") {
			layer.alert('文章内容不能为空!', {
				icon : 2
			});
			return false;
		}
	});
</script>
</html>