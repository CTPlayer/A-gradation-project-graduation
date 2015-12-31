<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>江苏师范大学教师个人网站</title>
<link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Coda:400,800" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" />

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" />

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<div id="menu-wrapper">
	<div id="menu">
		<ul>
			<li><a href="home.do">Homepage</a></li>
			<li class="current_page_item"><a href="">教学园地</a></li>
			<li><a href="scientist.do">科研空间</a></li>
			<li><a href="bbs.do">论坛</a></li>
			<li><a href="blog.do?pageNo=1">博客</a></li>
			<li><a href="#">Hi,${username}</a></li>
		</ul>
	</div>
	<!-- end #menu -->
</div>
<div>
<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="#">计算机科学与技术学院</a></li>
</ul>
</div>
<div id="xueyuan1">
<table class="table">
	<tr class="active">
		<th style="width: 10%">任课教师</th>

		<th>
		<c:forEach var="teacher" items="${jisuanji}">
		<a href="resource.do?teachername=${teacher.username}">${teacher.username}</a>
		</c:forEach>
		</th>

	</tr>
</table>
</div>
<div>
<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="#">体育学院</a></li>
</ul>
</div>
<div id="xueyuan2">
<table class="table">
	<tr class="warning">
		<th style="width: 10%">任课教师</th>	
		<th>
		<c:forEach var="teacher" items="${tiyu}">	
		<a href="resource.do?teachername=${teacher.username}">${teacher.username}</a>
		</c:forEach>
		</th>
	</tr>
</table>
</div>
<div>
<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="#">生命科学学院</a></li>
</ul>
</div>
<div id="xueyuan3" >
<table class="table">
	<tr class="success">
		<th style="width: 10%">任课教师</th>	
		<th>
		<c:forEach var="teacher" items="${shengming}">	
		<a href="resource.do?teachername=${teacher.username}">${teacher.username}</a>
		</c:forEach>
		</th>
	</tr>
</table>
</div>
<div>
<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="#">音乐学院</a></li>
</ul>
</div>
<div id="xueyuan1">
<table class="table">
	<tr class="info">
		<th style="width: 10%">任课教师</th>
		<th>
		<c:forEach var="teacher" items="${yinyue}">
		<a href="resource.do?teachername=${teacher.username}">${teacher.username}</a>
		</c:forEach>	
		</th>
	</tr>
</table>
</div>
<div>
<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="#">美术学院</a></li>
</ul>
</div>
<div id="xueyuan1">
<table class="table">
	<tr class="danger">
		<th style="width: 10%">任课教师</th>		
		<th>
		<c:forEach var="teacher" items="${meishu}">
		<a href="resource.do?teachername=${teacher.username}">${teacher.username}</a>
		</c:forEach>
		</th>
	</tr>
</table>
</div>

<div id="footer" style="margin-top: 40px">
	<p>江苏师范大学版权所有 © 1998-2015&nbsp;&nbsp;泉山校区：江苏省徐州市铜山新区上海路101号　邮政编码：221116 　苏ICP备-05007135号</p>
</div>
<!-- end #footer -->
<script>
</script>
</body>
</html>
