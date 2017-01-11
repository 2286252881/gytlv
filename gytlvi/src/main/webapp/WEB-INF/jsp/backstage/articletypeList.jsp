<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/lib/jquery-1.10.2.min.js"></script>

<link rel="stylesheet" href="/gytlvi/static/plugins/layui/css/layui.css">
<script type="text/javascript" src="/gytlvi/static/plugins/layer/layer.js"></script>

<title>文章分类</title>
</head>
<body>
	<div style="width: 90%; margin: 10px auto;">
		<jsp:include page="navbar/menu.jsp"></jsp:include>
		<div class="layui-form-item" style="margin-top: 17px;">
			<div class="layui-input-inline">
				<button class="layui-btn" id="addArticleType">
					<i class="layui-icon">&#xe608;</i> 添加文章分类
				</button>
			</div>
		</div>
		<table class="layui-table">
			<colgroup>
				<col width="400">
				<col width="400">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th style="text-align: center;">类别</th>
					<th style="text-align: center;">文章数</th>
					<th style="text-align: center;">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${articletypes}" var="articletype">
					<tr>
						<td style="text-align: center;">${articletype.articletypename}</td>
						<td style="text-align: center;">${articletype.countArticle}</td>
						<c:if test="${articletype.id==loginUser.username}">
							<td>不可操作,请添加新的分类!</td>
						</c:if>
						<c:if test="${articletype.id!=loginUser.username}">
							<td style="text-align: center;"><a href="#" onclick="editArticleType('${articletype.id}');" class="layui-icon" style="font-size: 30px; color: #1E9FFF;">&#xe642;</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="#" onclick="delArticleType('${articletype.id}');" class="layui-icon" style="font-size: 30px; color: #1E9FFF;">&#x1006;</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script src="/gytlvi/static/plugins/layui/layui.js"></script>
<script type="text/javascript">
	layui.use('element', function() {
	});
	function reg() {
		layer.open({
			type : 2,
			title : "注册",
			skin : 'layui-layer-rim', //加上边框
			area : [ '600px', '300px' ], //宽高
			content : '/gytlvi/backstageUser/toReg.html',
			end : function() {
				window.location.href = '/gytlvi/backstageUser/tologin.html'
			}
		});
	}
	function login() {
		window.location.href = '/gytlvi/backstageUser/tologin.html'
	}
</script>
<script type="text/javascript">
	$(".layui-nav > li").eq(4).addClass("layui-this");
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
	function editArticleType(id) {
		var id = id;
		layer.prompt({
			title : '输入分类名称',
			formType : 3
		}, function(articletypename, index) {
			$.ajax({
				type : "POST",
				url : "/gytlvi/backstageArticleType/editArticleType.html",
				data : {
					id : id,
					articletypename : articletypename
				},
				dataType : "json",
				success : function(result) {
					if (result.type == "1") {
						layer.msg(result.message, {
							icon : 1
						});
						location.reload();
						layer.close(index);
					}
					if (result.type == "2") {
						layer.msg(result.message, {
							icon : 1
						});
						return;
					}
				}
			});
		});
	}
	function delArticleType(id) {
		layer.confirm('确认删除该分类吗？', {
			btn : [ '删除', '取消' ]
		//按钮
		}, function() {
			$.ajax({
				type : "POST",
				url : "/gytlvi/backstageArticleType/delArticleType.html",
				data : {
					id : id,
				},
				dataType : "json",
				success : function(result) {
					if (result.type == "1") {
						layer.msg(result.message, {
							icon : 1
						});
						location.reload();
					}
				}
			});
		});
	}
</script>
</html>