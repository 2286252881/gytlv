<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/lib/jquery-1.10.2.min.js"></script>

<link rel="stylesheet" href="/gytlvi/static/plugins/layui/css/layui.css">
<script type="text/javascript" src="/gytlvi/static/plugins/layer/layer.js"></script>

<script type="text/javascript" src="/gytlvi/static/plugins/laypage/laypage.js"></script>
<title>文章列表</title>
</head>
<body>
	<div style="width: 90%; margin: 10px auto;">
		<jsp:include page="navbar/menu.jsp"></jsp:include>
		<blockquote style="margin-top: 10px;" class="layui-elem-quote">
			<a href="/gytlvi/backstageArticle/toAllArticle.html">文章列表</a>
		</blockquote>
		<table class="layui-table" id="view" lay-even lay-skin="line">
			<colgroup>
				<col width="150">
				<col width="150">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th style="text-align: center;">文章名称</th>
					<th style="text-align: center;">创建时间</th>
					<th style="text-align: center;">ip地址</th>
					<th style="text-align: center;">浏览人数</th>
					<th style="text-align: center;">文章类型</th>
					<th style="text-align: center;">访问模式</th>
					<th style="text-align: center;">是否推荐</th>
					<th style="text-align: center;">文章操作</th>
				</tr>
			<thead>
			<tbody>
			</tbody>
		</table>
		<input id="pages" type="hidden" />
		<div id="page1" style="float: right;"></div>
	</div>
</body>
<script src="/gytlvi/static/plugins/layui/layui.js"></script>
<script type="text/javascript">
	$(".layui-nav > li").eq(3).addClass("layui-this");
	layui.use('element', function() {
		var element = layui.element();
	});
</script>
<script type="text/javascript">
	function getLocalTime(str) {
		var strDate = new Date(str);
		var sDate = strDate.toLocaleString().split(' ')[0];
		return sDate.replace(/年|月/g, '-').replace(/日/g, '');
	}
	function demo(curr) {
		$.getJSON('/gytlvi/backstageArticle/getAllArticle.html', {
			page : curr || 1
		//向服务端传的参数，此处只是演示
		}, function(res) {
			if (curr == undefined) {
				curr = 1;
			}
			;
			$("#view tbody").html("");
			$("#pages").val(res.count);
			//此处仅仅是为了演示变化的内容
			$.each(res.obj, function(i, value) {
				var str = '<tr style="text-align: center">';
				var articlename_ = res.obj[i].articlename;
				if (articlename_.length >= 4) {
					articlename_ = articlename_.substr(0, 3);
					articlename_ += "...."
				}
				str += '<td>' + articlename_ + '</td>';
				var createTime = res.obj[i].articletime;
				str += '<td>' + getLocalTime(createTime) + '</td>';
				str += '<td>' + res.obj[i].articleip + '</td>';
				var clickNum = res.obj[i].articleclick > 0 ? res.obj[i].articleclick : 0;
				str += '<td>' + clickNum + '</td>';
				str += '<td>' + res.obj[i].articletype + '</td>';
				str += '<td>' + res.obj[i].articlemodle + '</td>';
				str += '<td>' + res.obj[i].articlesupport + '</td>';
				str += '<td><a class="layui-icon" style="color:blue" href="/gytlvi/backstageArticle/toEditArticle.html?id=' + res.obj[i].id + '\">&#xe642;</a>&nbsp;&nbsp;&nbsp;<a class="layui-icon" style="color:blue" href="#" onclick="javascript:sureDelArticle(' + "'" + res.obj[i].id + "'" + ');\">&#x1006;</a></td>';
				str += '</tr>';
				$("#view tbody").append(str);
			});
			//显示分页
			laypage({
				skin : 'molv',//皮肤
				groups : 3,//显示几页
				skip : true,//开启跳转
				cont : 'page1', //容器。值支持id名、原生dom对象，jquery对象。【如该容器为】：<div id="page1"></div>
				pages : $("#pages").val(), //通过后台拿到的总页数
				curr : curr || 1, //当前页
				jump : function(obj, first) { //触发分页后的回调
					if (!first) { //点击跳页触发函数自身，并传递当前页：obj.curr
						demo(obj.curr);
					}
				}
			});
		});
	};
	//运行
	demo();
	function sureDelArticle(id) {
		layer.confirm('确认要删除该篇文章吗?', {
			btn : [ '确定删除', '取消' ]
		//按钮
		}, function() {
			window.location.href = "/gytlvi/backstageArticle/delArticle.html?id=" + id;
			layer.msg('删除成功!', {
				icon : 1
			});
		}, function() {
			layer.close();
		});
	}
</script>
</html>