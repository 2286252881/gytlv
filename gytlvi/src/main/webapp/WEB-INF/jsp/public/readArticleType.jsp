<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">

<link href="/gytlvi/static/public/css/base.css" rel="stylesheet">
<link href="/gytlvi/static/public/css/readArticle.css" rel="stylesheet">
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/lib/jquery-1.10.2.min.js"></script>

<link rel="stylesheet" href="/gytlvi/static/plugins/layui/css/layui.css">
<script type="text/javascript" src="/gytlvi/static/plugins/layer/layer.js"></script>

<script type="text/javascript" src="/gytlvi/static/plugins/laypage/laypage.js"></script>
<!--[if lt IE 9]>
<script src="/gytlvi/static/public/js/modernizr.js"></script>
<![endif]-->
<title>小豆芽的个人博客</title>
<style type="text/css">
.dateview a:HOVER {
	cursor: pointer;
}
</style>
</head>
<body>
	<div class="wrapper">
		<header><jsp:include page="header.jsp"></jsp:include></header>
		<div>
			<h1 class="t_nav">
				<span> 您当前的位置： <a href="/gytlvi/public/index.html">首页</a><a>文章分类</a></span><a href="/gytlvi/public/index.html" class="n1">网站首页</a> <a class="n2" style="color: white;">${articletype.articletypename}</a>
			</h1>
		</div>
		<div class="mainContent">
			<div class="bloglist" id="mainContent"></div>
			<div>
				<input type="hidden" id="typename" value="${articletype.articletypename}" /> <input type="hidden" id="pageArticletype" value="${articletype.id}"> <input type="hidden" id="pageUserid" value="${articletype.userid}"> <input id="pages" type="hidden" />
				<div id="page1" style="margin-left:60%;overflow: hidden; text-overflow: ellipsis; white-space: nowrap;"></div>
				<div style="clear: both"></div>
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
</body>
<script type="text/javascript">
	function getLocalTime(str) {
		var strDate = new Date(str);
		var sDate = strDate.toLocaleString().split(' ')[0];
		return sDate.replace(/年|月/g, '-').replace(/日/g, '');
	}
	function demo(curr) {
		var actiletypeid = $("#pageArticletype").val();
		var userid = $("#pageUserid").val();
		var url = '/gytlvi/publicArticle/getPublicAllArticle.html?actiletypeid=' + actiletypeid + '&userid=' + userid;
		$.getJSON(url, {
			page : curr || 1
		//向服务端传的参数，此处只是演示
		}, function(res) {
			if (curr == undefined) {
				curr = 1;
			}
			;
			$("#mainContent").html("");
			$("#pages").val(res.count);
			var typename = $("#typename").val();
			//此处仅仅是为了演示变化的内容
			$.each(res.obj, function(i, value) {
				str = '<h3 style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;">' + res.obj[i].articlename + '<span><font style="font-weight: bold;font-size: 12px;">&gt;&gt;阅读：' + res.obj[i].articleclick + '</font></span></h3>';
				str += '<figure> <img src="'+res.obj[i].imgs[0]+'"></figure>';
				str += '<ul><p>' + res.obj[i].articlecontent + '......</p></ul>';
				var onclick_ = 'onclick="toReadArticle(&quot;';
				onclick_ += res.obj[i].id + '&quot;';
				str += '<div style="overflow: hidden; text-overflow: ellipsis; white-space: nowrap;" class="dateview"><a class="readmore" title="' + res.obj[i].articlename + '"' + onclick_ + ');' + '">阅读全文>></a>';
				var createTime = res.obj[i].articletime;
				str += '<span>' + getLocalTime(createTime) + '</span>';
				str += '<span>作者：' + res.obj[0].username + '</span>';
				str += '<span>的博客：[ ' + typename + ' ]';
				str += '</span></div>';
				$("#mainContent").append(str);
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
</script>
<script type="text/javascript">
	var toReadArticle = function(articleid) {
		var userid = $("#pageUserid").val();
		var articletypeid = $("#pageArticletype").val();
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
</script>
</html>