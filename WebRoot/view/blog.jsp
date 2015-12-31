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

</head>
<body>
<div id="menu-wrapper">
	<div id="menu">
		<ul>
			<li><a href="home.do">Homepage</a></li>
			<li><a href="teacherName.do">教学园地</a></li>
			<li ><a href="scientist.do">科研空间</a></li>
			<li><a href="bbs.do">论坛</a></li>
			<li  class="current_page_item"><a href="blog.do?pageNo=${pageNo}">博客</a></li>
			<li><a href="#">Hi,${username}</a></li>
		</ul>
	</div>
	<!-- end #menu -->
</div>

<div id="wrapper">
	<!-- end #header -->				
	<table class="table table-hover">
		<tr>
			<th>教师</th>
			<th>博客地址</th>
		</tr>
		<c:forEach var="t" items="${teacher}">
		<tr>
			<td>${t.username}</td>
			<c:choose>
				<c:when test="${empty t.blog.address}">
					<td><a href="#"  style="text-decoration: none">尚未添加博客地址</a></td>
				</c:when>
				<c:otherwise>
					<td><a href="http://${t.blog.address}">${t.blog.address}</a></td>
				</c:otherwise>
			</c:choose>
		</tr>
		</c:forEach>
	</table>
</div>

<nav>
  <ul class="pager">
  <c:choose>
  	<c:when test="${pageNo>1}">
    <li class="previous"><a href="blog.do?pageNo=${pageNo-1}"><span aria-hidden="true">&larr;</span> Older</a></li>
    </c:when>
    <c:otherwise>
        <li class="previous"><a href="#"><span aria-hidden="true">&larr;</span> Older</a></li>
    </c:otherwise>
   </c:choose>
    	<span>第${pageNo}页</span>/<span>共${totalPages}页</span>
    	<c:choose>
    	<c:when test="${pageNo<totalPages}">
    <li class="next"><a href="blog.do?pageNo=${pageNo+1}">Newer <span aria-hidden="true">&rarr;</span></a></li>
    </c:when>
    <c:otherwise>
        <li class="next"><a href="#">Newer <span aria-hidden="true">&rarr;</span></a></li>
    </c:otherwise>
    </c:choose>
  </ul>
</nav>

<div id="footer" style="position: absolute;bottom: 0px;right:0px;width: 100%;">
	<p>江苏师范大学版权所有 © 1998-2015&nbsp;&nbsp;泉山校区：江苏省徐州市铜山新区上海路101号　邮政编码：221116 　苏ICP备-05007135号</p>
</div>
<!-- end #footer -->
</body>
</html>
