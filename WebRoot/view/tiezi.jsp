<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
			<li><a href="teacherName.do">教学园地</a></li>
			<li><a href="scientist.do">科研空间</a></li>
			<li class="current_page_item"><a href="bbs.do">论坛</a></li>
			<li><a href="blog.do?pageNo=1">博客</a></li>
			<li><a href="#">Hi,${username}</a></li>
		</ul>
	</div>
	<!-- end #menu -->
</div>

	<span style="float: right;padding-right: 50px;"><a href="mybbs.do">我的帖子</a></span>
		<table class="table">
		<tr class="danger">		
				<td><span style="font-size: 15px;"><strong>${bbs.title}</strong></span><span style="float: right;margin-right: 50px">${bbs.times}</span><span style="float: right;margin-right: 50px;">postedBy:<span style="color: blue">${bbs.teacher.username}${bbs.user.username}</span></span></td>
		</tr>
		<tr class="active">
				<td><p>&nbsp;&nbsp;&nbsp;&nbsp;${bbs.txt}</p><br></br><br><br/></td>		
		</tr>
		<tr class="active">
				<c:choose>
					<c:when test="${fn:contains(username,'@')}">
						<td><span style="float: right;margin-right: 50px;"><a href=""><button type="button" class="btn btn-default"><a href="#myModal"  data-toggle="modal">回复</a></button></a></span></td>
	            	</c:when>
	            	<c:otherwise>
	            		<td></td>
	            	</c:otherwise>
	            </c:choose>	
		</tr>
</table>

<c:forEach var="a" items="${answers}">
<table class="table">
		<tr class="danger">		
				<td>回复：<span style="float: right;margin-right: 50px">${a.retime}</span><span style="float: right;margin-right: 50px;"><span style="color: blue">answeredBy:${a.teacher.username}</span></span></td>
		</tr>
		<tr class="active">
				<td><p>&nbsp;&nbsp;&nbsp;&nbsp;${a.retxt}</p><br></br><br><br/></td>		
		</tr>
</table>
</c:forEach>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">回复</h4>
      </div>
      <div class="modal-body">
        <form action="answer.do?bbsid=${bbs.bbsid}" method="post">
  <div class="form-group">
    <label for="txt">内容</label>
    <textarea class="form-control" rows="5" name="retxt"></textarea>
  </div>
  
  <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save</button>
      </div>
</form>
      </div>
      
    </div>
  </div>
</div>

<!-- end #footer -->
<script>
</script>
</body>
</html>
