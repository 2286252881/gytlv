<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="news">
	<h3>
		<p>
			最新<span>文章</span>
		</p>
	</h3>
	<ul class="rank">
	</ul>
	<h3 class="ph">
		<p>
			点击<span>排行</span>
		</p>
	</h3>
	<ul class="paih">
	</ul>
	<h3 class="links">
		<p>
			友情<span>链接</span>
		</p>
	</h3>
	<ul class="website">
		<li><a href='http://www.yangqq.com' target="_blank">杨青的的博客</a></li>
	</ul>
</div>
<script type="text/javascript" src="/gytlvi/static/wangEditor-2.1.22/dist/js/lib/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$.ajax({
			type : 'POST',
			url : '/gytlvi/public/getClicksTopTen.html',
			dataType : "json",
			success : function(result) {
				var str="";
				$.each(result, function(i, value) {
					$(".paih").append("<li><a>");
					str = '"' + result[i].userid + '","' + result[i].id + '","' + result[i].articletype + '"';
					$(".paih li:nth-child(+" + (i + 1) + ") a").attr('onclick', 'addclickCount(' + str + ');');
					$(".paih li:nth-child(+" + (i + 1) + ") a").attr('href', 'javascript:void(0);');
					$(".paih > li:nth-child(+" + (i + 1) + ") a").html(result[i].articlename);
				});
			}
		});
		$.ajax({
			type : 'POST',
			url : '/gytlvi/public/getNewsTopTen.html',
			dataType : "json",
			success : function(result) {
				var str="";
				$.each(result, function(i, value) {
					$(".rank").append("<li><a>");
					str = '"' + result[i].userid + '","' + result[i].id + '","' + result[i].articletype + '"';
					$(".rank li:nth-child(+" + (i + 1) + ") a").attr('onclick', 'addclickCount(' + str + ');');
					$(".rank li:nth-child(+" + (i + 1) + ") a").attr('href', 'javascript:void(0);');
					$(".rank li:nth-child(+" + (i + 1) + ") a").html(result[i].articlename);
				});
			}
		});
	});
	var addclickCount = function(userid, articleid, articletypeid) {
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
				alert(result.message);
				console.info(result);
			}
		});
		var url = "/gytlvi/publicArticle/toReadArticle/" + userid + "/" + articleid + "/" + articletypeid+'.html';
		window.location.href=url;
	};
</script>
