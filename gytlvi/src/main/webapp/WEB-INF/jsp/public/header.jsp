<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#sj, #Music2, #Music1:HOVER {
	cursor: pointer;
}
</style>
<h1 id="logo">
	<a href="/gytlvi/public/index.html"><img src="/gytlvi/static/public/images/logo.png" alt="小菜芽"></a>
	<audio id="audio" autoplay="autoplay" src='' loop="loop"></audio>
	<span style="background-color: green; padding: 10px;"><a id="Music1" style="color: white;">Music</a><a id="Music2" style="color: white;">Music</a></span> <span style="background-color: green; padding: 10px;"><a id="sj" style="color: white;">随机</a></span>
</h1>
<nav>
	<ul>
		<li id="active"><a href="/gytlvi/public/index.html">网站首页</a></li>
		<li><a href="">慢生活</a></li>
		<li><a href="">碎言碎语</a></li>
		<c:if test="${not empty loginUser}">
			<li><a href="/gytlvi/backstageUser/dobackstageMain.html">用户中心</a></li>
		</c:if>
		<c:if test="${empty loginUser}">
			<li><a href="/gytlvi/backstageUser/tologin.html">登录</a></li>
		</c:if>
	</ul>
</nav>
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#Music2").show();
		$("#Music1").hide();
	});
	var audio = $("#audio")[0];
	$("#Music1").click(function() {
		audio.pause();
		$("#Music2").show();
		$("#Music1").hide();
	});
	$("#Music2").click(function() {
		if($("#audio").attr("src")==''){
			var sjs = Math.floor(Math.random() * 10);
			$("#audio").attr("src", '/gytlvi/static/plugins/player/' + sjs + '.mp3');
		}
		if($("#audio").attr("src")!=''){
			audio.play();
		};
		$("#Music1").show();
		$("#Music2").hide();
	});
	$("#sj").click(function() {
		var sjs = Math.floor(Math.random() * 10);
		$("#audio").attr("src", '/gytlvi/static/plugins/player/' + sjs + '.mp3');
	});
</script>