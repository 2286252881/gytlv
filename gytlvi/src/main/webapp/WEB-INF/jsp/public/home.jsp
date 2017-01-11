<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta property="wb:webmaster" content="473f6e01d28d0f48" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">

<link href="/gytlvi/static/public/css/base.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="/gytlvi/static/public/js/modernizr.js"></script>
<![endif]-->
<style type="text/css">
.level1:HOVER {
	cursor: pointer;
}

.dateview a:HOVER {
	cursor: pointer;
}
</style>
<title>小豆芽的个人博客</title>
</head>
<body>
	<div class="wrapper">
		<header> <jsp:include page="header.jsp"></jsp:include> </header>
		<div class="banner">
			<div class="headerPic">
				<a href="/gytlvi/public/index.html"><span>小豆芽</span></a>
			</div>
			<div class="websiteDescription">
				<h2>渡人如渡己，渡已，亦是渡</h2>
				<p>当我们被误解时，会花很多时间去辩白。 但没有用，没人愿意听，大家习惯按自己的所闻、理解做出判别，每的其实都很固执。与其努力且痛苦的试图扭转别人的评判，不如默默承受，给大家多一点时间和空间去了解。而我们省下辩解的功夫，去实现自身更久远的人生价值。其实，渡人如渡己，渡已，亦是渡人。</p>
			</div>
		</div>
		<div class="mainContent">
			<h2 class="title_tj">
				<p>
					<span><font style="color: green;">文章</font>推荐</span>
				</p>
			</h2>
			<div class="bloglist">
				<c:if test="${not empty articles}">
					<c:forEach items="${articles}" var="article">
						<h3 style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">${article.articlename}
							<span><font style="font-weight: bold; font-size: 12px;">&gt;&gt;阅读：(${article.articleclick>0?article.articleclick:0})</font></span>
						</h3>
						<figure> <img src="${article.imgs[0]}"> </figure>
						<ul>
							<p>${article.articlecontent}...</p>
						</ul>
						<div class="dateview">
							<a title="${article.articlename}" onclick='toReadArticle("${article.userid}","${article.id}","${article.articletype}");' class="readmore">阅读全文>></a>
							<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">
								<fmt:formatDate value="${article.articletime}" pattern="yyyy-MM-dd" />
								&nbsp;&nbsp;作者：${article.username}&nbsp;&nbsp;分类：[<a style="color: blue;" onclick='toReadArticleType("${article.userid}","${article.articletype}")'>${article.articleTypename}</a>]
							</div>
						</div>
					</c:forEach>
				</c:if>
				<c:if test="${empty articles}">
					<h3>暂无推荐文章</h3>
				</c:if>
			</div>
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
	<!-- <form id="readArticleType_public" action="" method="POST">
		<input type="hidden" name="useridT" id="useridT" value=""><input type="hidden" name="articletypeidT" id="articletypeidT" value="">
	</form> -->
</body>
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/lib/jquery-1.10.2.min.js"></script>
<link rel="stylesheet" href="/gytlvi/static/plugins/layui/css/layui.css">
<script type="text/javascript" src="/gytlvi/static/plugins/layer/layer.js"></script>
<script type="text/javascript">
	var toReadArticle = function(userid, articleid, articletypeid) {
		$.ajax({
			type : 'POST',
			url : '/gytlvi/publicArticle/clickCount.html',
			data : {
				userid : userid,
				articleid : articleid,
				articletypeid : articletypeid
			},
			dataType : "json",
			success : function(result) {
			}
		});
		window.location.href = "/gytlvi/publicArticle/toReadArticle/" + userid + "/" + articleid + "/" + articletypeid+'.html';
	};
	function toReadArticleType(userid, articletypeid) {
		/*$("#useridT").val(userid);
		$("#articletypeidT").val(articletypeid);
		$("#readArticleType_public").attr("action", "/gytlvi/publicArticle/toReadArticleType.html");
		$("#readArticleType_public").submit(); */
		window.location.href = "/gytlvi/publicArticle/toReadArticleType/" + userid + "/" + articletypeid+'.html';
	};
</script>
</html>