<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>江苏师范大学教师个人网站管理系统</title>
<link type="text/css" rel="stylesheet" href="view/css/manager.css" />
<script type="text/javascript" src="view/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="view/js/menu.js"></script>

<!-- <link type="text/css" rel="stylesheet" href="css/manager.css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/menu.js"></script> -->

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- 可选的Bootstrap主题文件（一般不用引入） -->
<link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>

<body>
<div class="top"></div>
<div id="header">
	<div class="logo">教师个人网站后台管理系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><a href="">${email}</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu"	>
				<ul id="nav_dot">
      <li>
          <h4 class="M1">系统公告管理</h4>
          <div class="list-item none">
            <a href='view/addAnnounce.jsp'>发布公告</a>
            <a href="deleteAnnounce.do?pageNo=1">删除公告</a>
          </div>
        </li>
        <li>
          <h4 class="M2">教学园地管理</h4>
          <div class="list-item none">
            <a href='view/addLessions.jsp'>添加课程信息</a>    
            <a href="myLessions.do">我的课程信息</a>
            <a href="view/uploadFile.jsp">添加课件</a>    
           </div>
        </li>
        <li>
          <h4 class="M3">科研空间管理</h4>
          <div class="list-item none">
            <a href='view/addPaper.jsp'>添加论文信息</a>
			<a href='view/addItem.jsp'>添加项目信息</a>
			<a href="myScientist.do">我的科研空间</a>
          </div>
        </li>
				<li>
          <h4 class="M4">论坛管理</h4>
		  <div class="list-item none">
		  <a href="forum.do">论坛管理</a>
			</div>
          
        </li>
				<li>
          <h4 class="M5">博客管理</h4>
		  <div class="list-item none">
			<a href='myBlog.do'>添加博客链接</a>
			</div>
     
        </li>
  </ul>
		</div>
		<div class="m-right" style="background-color: #f6f6f6">
			<br>
			<br>
			<br>
			<div>
				<table class="table table-hover">
					<th>论文名称</th><th>操作</th>
					<c:forEach var="paper" items="${papers}">
					<tr><td>${paper.papername}</td><td><a href="deletePaper.do?pid=${paper.pid}">删除</a></td></tr>
					</c:forEach>
				</table>
				<hr>
				<table class="table table-hover">
					<th>项目名称</th><th>操作</th>
					<c:forEach var="item" items="${items}">
					<tr><td>${item.itemname}</td><td><a href="deleteItem.do?iid=${item.iid}">删除</a></td></tr>
					</c:forEach>
				</table>
				<!-- <nav>
  				 <ul class="pager">
				 <c:choose>
  						<c:when test="${pageNo>1}">
    					<li class="previous"><a href="deleteAnnounce.do?pageNo=${pageNo-1}"><span aria-hidden="true">&larr;</span> Older</a></li>
    					</c:when>
    				<c:otherwise>
        				<li class="previous"><a href="#"><span aria-hidden="true">&larr;</span> Older</a></li>
    				</c:otherwise>
   					</c:choose>
    				<span>第${pageNo}页</span>/<span>共${totalPages}页</span>
    				<c:choose>
    				<c:when test="${pageNo<totalPages}">
    				<li class="next"><a href="deleteAnnounce.do?pageNo=${pageNo+1}">Newer <span aria-hidden="true">&rarr;</span></a></li>
    				</c:when>
    				<c:otherwise>
        			<li class="next"><a href="#">Newer <span aria-hidden="true">&rarr;</span></a></li>
    				</c:otherwise>
    				</c:choose>
    				</ul>
    			</nav> -->
			</div>
		</div>
</div>

<div class="bottom"></div>
<div id="footer"><p>江苏师范大学版权所有 © 1998-2015  泉山校区：江苏省徐州市铜山新区上海路101号　邮政编码：221116 　苏ICP备-05007135号</p></div>
<script>navList(12);</script>
</body>
</html>
