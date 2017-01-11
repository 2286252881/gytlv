<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul class="layui-nav" lay-filter="">
	<li class="layui-nav-item"><a href="/gytlvi/">博客首页</a></li>
	<li class="layui-nav-item"><a href="/gytlvi/backstageUser/dobackstageMain.html">后台主页</a></li>
	<li class="layui-nav-item"><a href="/gytlvi/backstageArticle/toPreAddArticle.html">文章发布</a></li>
	<li class="layui-nav-item"><a href="/gytlvi/backstageArticle/toAllArticle.html">文章管理</a></li>
	<li class="layui-nav-item"><a href="/gytlvi/backstageArticleType/toArticleType.html">分类管理</a></li>
	<li class="layui-nav-item" style="float: right;"><c:if test="${not empty loginUser}">
			<a href="javascript:;">${loginUser.username}</a>
			<dl class="layui-nav-child" style="text-align: center;">
				<dd>
					<a href="#">个人资料</a>
				</dd>
				<dd>
					<a href="/gytlvi/public/doQuit.html">退出</a>
				</dd>
			</dl>
		</c:if></li>
</ul>
<script type="text/javascript">
	$(".layui-nav>li").click(function(){
		$(this).addClass("class","layui-this");
	});
</script>