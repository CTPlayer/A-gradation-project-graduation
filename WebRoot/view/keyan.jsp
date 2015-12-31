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


<style type="text/css">
table.hovertable {
	font-family: verdana,arial,sans-serif;
	font-size:15px;
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.hovertable th {
	background-color:#c3dde0;
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.hovertable tr {
	background-color:#d4e3e5;
}
table.hovertable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
</style>
</head>
<body>
<div id="menu-wrapper">
	<div id="menu">
		<ul>
			<li><a href="home.do">Homepage</a></li>
			<li><a href="teacherName.do">教学园地</a></li>
			<li  class="current_page_item"><a href="scientist.do">科研空间</a></li>
			<li><a href="#">论坛</a></li>
			<li><a href="blog.do?pageNo=1">博客</a></li>
			<li><a href="#">Hi,${username}</a></li>
		</ul>
	</div>
	<!-- end #menu -->
</div>

<div id="wrapper">
	<!-- end #header -->				
	<div style="margin-top:30px">
	<h2>科研论文</h2>
		<table class="hovertable" style="margin:auto;width:100%">
<tr>
	<th>论文名称</th><th>刊物名称</th><th>发表时间</th><th>级别</th><th>发表者</th>
</tr>
<c:forEach var="p" items="${paper}">
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
	<td>${p.papername}</td><td>${p.publication}</td><td>${p.announcetime}</td><td>${p.level}</td><td>${p.author}</td>
</tr>
</c:forEach>

</table>

<br>
<hr>
<h2>科研项目</h2>
		<table class="hovertable" style="margin:auto;width:100%">
<tr>
	<th>项目名称</th><th>立项时间</th><th>资助单位</th><th>备注</th>
</tr>
<c:forEach var="i" items="${item}">
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
	<td>${i.itemname}</td><td>${i.itemtime}</td><td>${i.support}</td><td>${i.remark}</td>
</tr>
</c:forEach>

</table>
		
	</div>
</div>
<div id="footer" style="position: absolute;bottom: 0px;right:0px;width: 100%;">
	<p>江苏师范大学版权所有 © 1998-2015&nbsp;&nbsp;泉山校区：江苏省徐州市铜山新区上海路101号　邮政编码：221116 　苏ICP备-05007135号</p>
</div>
<!-- end #footer -->
</body>
</html>
