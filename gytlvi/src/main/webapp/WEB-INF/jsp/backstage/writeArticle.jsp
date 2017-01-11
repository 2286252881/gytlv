<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="/gytlvi/static/plugins/bootstrap-3.3.0/dist/css/bootstrap.min.css">

<link rel="stylesheet" type="text/css" href="/gytlvi/static/wangEditor-2.1.22/dist/css/wangEditor.min.css">
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/wangEditor.min.js"></script>

<link rel="stylesheet" href="/gytlvi/static/plugins/layui/css/layui.css">
<script type="text/javascript" src="/gytlvi/static/plugins/layer/layer.js"></script>

<title>写文章</title>
</head>
<body>
	<div style="width: 90%; margin: 10px auto;">
		<jsp:include page="navbar/menu.jsp"></jsp:include>
		<fildset style="border: none:border-top: 1px solid #eee;"> <legend style="color: gray; font-size: 16px;margin-top: 15px;">添加文章分类 </legend>
		<div style="margin-bottom: 7px;">
			<button class="layui-btn" style="margin-bottom: 10px;" id="addArticleType">
				<i class="layui-icon">&#xe608;</i> 添加文章分类
			</button>
		</div>
		</fildset>
		<fildset style="border: none:border-top: 1px solid #eee;"> <legend style="color: gray; font-size: 16px">选择文章分类</legend>
		<div class="layui-field-box">
			<select style="margin-top: -10px; margin-bottom: 7px; margin-left: -10px;" lay-verify="" id="articleType_2">
				<option value="">请选择</option>
				<c:if test="${not empty articletypes}">
					<c:forEach items="${articletypes}" var="at">
						<option value="${at.id}">${at.articletypename}</option>
					</c:forEach>
				</c:if>
			</select>
		</div>
		</fildset>
		<form id="addArticleForm" action="/gytlvi/backstageArticle/addArticle.html" method="post">
			<input type="hidden" id="aType" name="articletype">
			<fildset style="border: none:border-top: 1px solid #eee;"> <legend style="color: gray; font-size: 16px">填写文章标题</legend>
			<div>
				<input type="text" id="articlename" name="articlename" placeholder="请输入标题" autocomplete="off" class="layui-input">
			</div>
			</fildset>
			<fieldset style="border: none:border-top: 1px solid #eee; margin-top: 17px;">
				<legend style="color: gray; font-size: 16px"> 推荐、公开设置 </legend>
				<div>
					<label class="checkbox-inline"><input type="checkbox" id="articlesupport" name="articlesupport" value="1">博主推荐&nbsp;&nbsp;&nbsp;</label> <label class="radio-inline"><input type="radio" name="articlemodle" value="1" checked="checked">公开</label> <label class="radio-inline"><input type="radio" name="articlemodle" value="0">不公开 </label>
				</div>
			</fieldset>
			<fieldset style="border: none:border-top: 1px solid #eee; margin-top: 17px;">
				<legend style="color: gray; font-size: 16px"> 填写文章内容 </legend>
			</fieldset>
			<div>
				<textarea id="textarea1" name="articlecontent" style="height: 400px; max-height: 500px;">
			</textarea>
				<div style="margin-top: 30px;">
					<button id="btn1" class="layui-btn" lay-submit lay-filter="formDemo">添加文章</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置填写</button>
				</div>
			</div>
		</form>
	</div>
</body>
<script src="/gytlvi/static/plugins/layui/layui.js"></script>
<script type="text/javascript">
 	$(".layui-nav > li").eq(2).addClass("layui-this");
	layui.use('element', function() {
		var element = layui.element();

	});
</script>
<script type="text/javascript">
	//关闭日志打印
	wangEditor.config.printLog = false;

	var editor = new wangEditor('textarea1');
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
	$('#btn1').click(function() {
		// 获取格式化后的纯文本
		var html = editor.$txt.html();
		// 获取格式化后的纯文本
		var formatText = editor.$txt.formatText();
		if ($("#articleType_2").val() == "") {
			layer.alert('请选择一项文章分类!', {
				icon : 2
			});
			return false;
		}
		$("#aType").val($("#articleType_2").val());
		if ($("#articlename").val() == "") {
			layer.alert('文章标题不能为空!', {
				icon : 2
			});
			return false;
		}
		if (formatText == "") {
			layer.alert('文章内容不能为空!', {
				icon : 2
			});
			return false;
		}
		$("#addArticleForm").submit();
	});
	$("#addArticleType").click(function() {
		layer.prompt({
			title : '请填写分类名称',
			formType : 3
		}, function(val, index) {
			$.ajax({
				type : "POST",
				url : "/gytlvi/backstageArticleType/addArticleType.html",
				data : {
					id : $("#id").val(),
					articletypename : val
				},
				dataType : "json",
				success : function(data) {
					if (data.type == "0") {
						layer.msg(data.message, {
							icon : 1
						});
						return;
					}
					if (data.type == "1") {
						layer.msg(data.message, {
							icon : 1
						});
						location.reload();
						layer.close(index);
					}
				}
			});
		});
	});
</script>
</html>