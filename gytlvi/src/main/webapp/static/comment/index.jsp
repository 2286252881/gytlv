<!DOCTYPE html>
	<link rel="stylesheet" type="text/css" href="jquery.sinaEmotion.css">
	<script src="jquery.min.js"></script>
	<script src="jquery.sinaEmotion.js"></script>
	<style type="text/css">
		body{
			font-size:12pt;
		}
		.comment_body{
			display:none;
		}
		#result,
		#content{
			padding: 5px;
			width: 500px;
			height: 100px;
			margin: 5px 0;
			border: 1px solid #888;
		}
	</style>
</head>
<body>
	<form class="publish">
		<div id="result"></div>
		<textarea class="content" id="content">欢迎使用jQuery Sina Emotion[呵呵]</textarea><br>
		<input class="face" type="button" value="表情">
		<input class="submit" type="button" value="解析">
	</form>
	<form class="comment">
		<a href="http://sandbox.runjs.cn/show/biebksny#" class="reply">评论</a>
		<div class="comment_body" style="display: block;">
			<input class="content" type="text" size="70">
			<input class="face" type="button" value="表情">
			<input class="submit" type="button" value="解析">
		</div>
	</form>
	<form class="comment">
		<a href="http://sandbox.runjs.cn/show/biebksny#" class="reply">评论</a>
		<div class="comment_body">
			<input class="content" type="text" size="70">
			<input class="face" type="button" value="表情">
			<input class="submit" type="button" value="解析">
		</div>
	</form>
	<form class="comment">
		<a href="http://sandbox.runjs.cn/show/biebksny#" class="reply">评论</a>
		<div class="comment_body">
			<input class="content" type="text" size="70">
			<input class="face" type="button" value="表情">
			<input class="submit" type="button" value="解析">
		</div>
	</form>
	<form class="comment">
		<a href="http://sandbox.runjs.cn/show/biebksny#" class="reply">评论</a>
		<div class="comment_body">
			<input class="content" type="text" size="70">
			<input class="face" type="button" value="表情">
			<input class="submit" type="button" value="解析">
		</div>
	</form>
	<form class="comment">
		<a href="http://sandbox.runjs.cn/show/biebksny#" class="reply">评论</a>
		<div class="comment_body">
			<input class="content" type="text" size="70">
			<input class="face" type="button" value="表情">
			<input class="submit" type="button" value="解析">
		</div>
	</form>
	<script type="text/javascript" src="./jQuery新浪表情插件Demo_files/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="./jQuery新浪表情插件Demo_files/jquery-sinaEmotion-2.1.0.min.js"></script>
	<script type="text/javascript">
		$('body').delegate('.reply', {
			click : function(event){
				$(this).next('.comment_body').toggle();
				event.preventDefault();
			}
		});
		$('.submit').bind({
			click : function(){
				var content = $(this).parents('form').find('.content').val();
				$('#result').html(content).parseEmotion();
			}
		});
		$('.face').bind({
			click: function(event){
				if(! $('#sinaEmotion').is(':visible')){
					$(this).sinaEmotion();
					event.stopPropagation();
				}
			}
		});
	</script>

	
