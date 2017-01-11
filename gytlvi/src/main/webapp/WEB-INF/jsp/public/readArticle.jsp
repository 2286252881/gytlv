<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:wb="http://open.weibo.com/wb">
<head>
<script src="http://tjs.sjs.sinajs.cn/open/api/js/wb.js?appkey=2835084532" type="text/javascript" charset="utf-8"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">

<link href="/gytlvi/static/public/css/base.css" rel="stylesheet">
<link href="/gytlvi/static/public/css/readArticle.css" rel="stylesheet">

<!--[if lt IE 9]>
<script src="/gytlvi/static/public/js/modernizr.js"></script>
<![endif]-->
<title>小豆芽的个人博客</title>
<style type="text/css">
body {
	font-size: 12pt;
}

.comment_body {
	display: none;
}

#result, #content {
	padding: 5px;
	width: 500px;
	height: 100px;
	margin: 5px 0;
	border: 1px solid #888;
}
#bjz:HOVER {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="wrapper">
		<header><jsp:include page="header.jsp"></jsp:include></header>
		<div>
			<h1 class="t_nav">
				<span>您当前的位置：<a href="/gytlvi/public/index.html">首页</a>&nbsp;&gt;&nbsp;<a>文章阅读</a></span><a href="/gytlvi/public/index.html" class="n1">网站首页</a><a class="n2" style="color: white;">文章阅读</a>
			</h1>
		</div>
		<div class="mainContent">
			<h2 class="c_titile">${article.articlename}</h2>
			<p class="box_c">
				<span style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">发布时间:<fmt:formatDate value="${article.articletime}" pattern="yyyy-MM-dd" />&nbsp;&nbsp;编辑：<a>${article.username}</a>&nbsp;&nbsp;阅读（${article.articleclick>0?article.articleclick:0}）
				</span>
			</p>
			<ul class="contentinfos" style="font-size: 14px;">
				<p>${article.articlecontent}</p>
			</ul>
			<wb:comments url="http://open.weibo.com/widget/comments.php" border="y" fontsize="12" width="auto" appkey="2835084532"></wb:comments>
		</div>
		<div class="sidebar">
			<jsp:include page="newsclicks.jsp"></jsp:include>
		</div>
		<div class="clearfloat"></div>
		<footer>
		<ul>
			<a href="http://www.miitbeian.gov.cn/">鄂ICP备16025167号</a>
		</ul>
		</footer>
	</div>
</body>
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/lib/jquery-1.10.2.min.js"></script>
<link rel="stylesheet" href="/gytlvi/static/plugins/layui/css/layui.css">
<script type="text/javascript">
	$(function(){
		$("pre").attr("style","background:#F2EFFE;");
		$("code").attr("style","color:#290B9F;");
		$(".contentinfos p").attr("style","line-height:25px;");
	});
</script>
</html>