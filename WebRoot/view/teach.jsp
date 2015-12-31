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
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"/>

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"/>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

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
			<li class="current_page_item"><a href="#">教学园地</a></li>
			<li><a href="scientist.do">科研空间</a></li>
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
		<table class="hovertable" style="margin:auto;width:100%">
<tr>
	<th>课程名称</th><th>课程类型</th><th>课程性质</th><th>所属专业</th><th>备注</th><th>课件下载</th><th>在线视频</th>
</tr>
<c:forEach var="lession" items="${lessions}">
<tr onmouseover="this.style.backgroundColor='#ffff66';" onmouseout="this.style.backgroundColor='#d4e3e5';">
	<td>${lession.subject}</td><td>${lession.type}</td><td>${lession.property}</td><td>${lession.major}</td><td>${lession.remark }</td>
	<td><c:forEach var="f" items="${lession.upload}"><a href="download.do?storeName=${f.filename}">${f.filename}</a></c:forEach></td>
	<td><c:forEach var="f" items="${lession.upload}"><a href="#" data-toggle="modal" data-target="#myModal">${f.videoname}</a>
	
	<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">${f.videoname}</h4>
      </div>
      <div class="modal-body">
        <video src="uploadvideo/${f.videoname}" controls="controls" height="280px">
			您的浏览器不支持 video 标签。
		</video>
      </div>
    </div>
  </div>
</div>
	
	</c:forEach></td>
</tr>
</c:forEach>

</table>
		
	</div>
	<!--  <div style="text-align:center;margin-bottom:20px;margin-top:20px">
		<a href="#"><img src="view/images/page_up.gif"></a>&nbsp;&nbsp;第1页/共1页&nbsp;&nbsp;<a href=""><img src="view/images/page_down.gif"></a>
	</div>-->
</div>

<div id="footer" style="position: absolute;bottom: 0px;right:0px;width: 100%;">
	<p>江苏师范大学版权所有 © 1998-2015&nbsp;&nbsp;泉山校区：江苏省徐州市铜山新区上海路101号　邮政编码：221116 　苏ICP备-05007135号</p>
</div>
<!-- end #footer -->
</body>
</html>
