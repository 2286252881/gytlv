<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  src="/gytlvi/static/plugins/angularjs/angular-1.3.0.js"></script>
<script  src="/gytlvi/static/plugins/angularjs/first/HelloAngular_MVC.js"></script>
<title>helloangular</title>
</head>
<body>
	<div ng-controller="HelloAngular">
		<p>{{greeting.text}},Angular</p>
	</div>
</body>
</html>