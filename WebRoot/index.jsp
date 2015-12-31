<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="Remodal example" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>江苏师范大学教师个人网站</title>
<link href="http://fonts.googleapis.com/css?family=Arvo" rel="stylesheet" type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Coda:400,800" rel="stylesheet" type="text/css" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="stylesheet" href="dist/remodal.css" type="text/css" />
<link rel="stylesheet" href="dist/remodal-default-theme.css"  type="text/css" />
  <style>
    .remodal-bg.with-red-theme.remodal-is-opening,
    .remodal-bg.with-red-theme.remodal-is-opened {
      filter: none;
    }
    .remodal-overlay.with-red-theme {
      background-color: #f44336;
    }
    .remodal.with-red-theme {
      background: #fff;
    }
  </style>
 
<script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
<script src="dist/ajax.js"></script>
<style type="text/css">
.hidediv{display:none;}
<style type="text/css">	
body { 
	text-align: center; 
	font: normal 12px "宋体", Arial; 
	margin:0; 
	padding:0; 
	background: #FFF; 
	color:#333;
	line-height:25px;
	}
#pagetop{                                                                                                                           
	float:right;width:420px;                                                                                                                
	}
/*翻页*/
.PicPage070129{padding:8px 0; height:20px;}
.Pagediv070129{float:right;}
.page070129{ width:60px; height:18px;text-align:center; background:#fff;line-height:18px; float:left; margin:0 1px;}
.pageGray070129{ border:1px solid #ddd; color:#999;}
.page070129 a:link,.page070129 a:visited{ color:#007ab7; text-decoration:none;}
.page070129 a:hover{ color:#f60; text-decoration:underline;}
.Pagediv070129 span a:link,.Pagediv070129 span a:visited,.Pagediv070129 span b{ width:20px; height:18px; display:block; border:1px solid #007ab7; text-align:center; margin:0 1px; line-height:18px; font-family:Arial; text-decoration:none; float:left;}
.Pagediv070129 span a:link,.Pagediv070129 span a:visited{ color:#007ab7; background:#fff;}
.Pagediv070129 span a:hover{ border:1px solid #007AB7; text-align:center; line-height:18px; font-family:Arial; text-decoration:none; background:#007ab7; font-weight:bold; color:#fff; position:relative; margin:-5px -4px; width:30px; height:28px; line-height:26px;}
.Pagediv070129 span b{font-weight:bold;color:#fff;background-color: #007AB7;}
.Pagediv070129 span span{ vertical-align:bottom; float:left;}
.Pagediv070129 font{width:20px;height:18px;display:block;border:1px solid #007AB7;text-align:center;margin:0 1px;line-height:18px;font-family:Arial;text-decoration:none;float:left;color: #007AB7;}
</style>
<script>
	
	$(document).ready(function(){
		$(".clikea").click(function(){
  			return false;
		 });
		 $(".page").click(function(){
  			return false;
		 });
		 });
	function f1(event){	
	var tag = $(event);
	var hidediv = $(event).parent().prev(); //entry2
	var hidediv2 = $(event).parent().prev().prev(); //entry1
	 var value = $(event).parent().prev().hasClass('hidediv');
	 if(value === false ){
	 	hidediv.addClass('hidediv');	 
	 	hidediv2.removeClass('hidediv');
	 }else{
	   hidediv.removeClass('hidediv');
	   hidediv2.addClass('hidediv');
	 }	 
	}
</script>
</head>
<body>
<div id="menu-wrapper">
	<div id="menu">
		<ul>
			<li class="current_page_item"><a href="home.do">Homepage</a></li>
			<li><a href="teacherName.do">教学园地</a></li>
			<li><a href="scientist.do">科研空间</a></li>
			<li><a href="bbs.do">论坛</a></li>
			<li><a href="blog.do?pageNo=1">博客</a></li>
			<c:choose>
			<c:when test="${empty username}">
			<li><a href="login.jsp">您尚未登陆，请先登录</a></li>
			</c:when>
			<c:otherwise>
			<li><a href="#">Hi,${username}</a></li>
			</c:otherwise>
			</c:choose>
		</ul>
	</div>
	<!-- end #menu -->
</div>
<div id="header-wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="#">江苏师范大学</a></h1>
			<p>教师个人网站</p>
		</div>
	</div>
</div>
<div id="wrapper">
	<!-- end #header -->
	<div id="page">
		<div id="page-bgtop">
			<div id="page-bgbtm">
				<div id="content">
				<c:forEach var = "announce" items="${ALimt_3}">
					<div class="post">
						<h2 class="title"><a href="#">${announce.title}</a></h2>
						<p class="meta"><span class="date">发布于：${announce.createtime}&nbsp;&nbsp;修改于：${announce.updatetime}</span><span class="posted">Posted by <a href="#">${announce.postedBy}</a></span></p>
						<div style="clear: both;">&nbsp;</div>
						<div class="entry">
						<div class="entry1">
						<c:choose>
							<c:when test="${fn:length(announce.content)>150}">	
								<p>${fn:substring(announce.content, 0, 150)}...</p>
							</c:when>
							<c:otherwise>
								<p>${announce.content}</p>
							</c:otherwise>
						</c:choose>
						</div>
						<div class="entry2 hidediv">
							<p>${announce.content}</p>
						</div>
							<p class="links"><a  href="#" onclick="f1(this);" class='clikea'>展开/收起</a></p>
						</div>
					</div> 
					</c:forEach>
					<div style="clear: both;">&nbsp;</div>
				</div>
				<!-- end #content -->
				<div id="sidebar">
					<ul>
						<li>
							<div style="clear: both;">&nbsp;</div>
						</li>
						<li>
							<p><img src="images/logo.jpg" style="width:200px"></p>
						</li>
						<li id="ct">
							<h2>往期公告</h2>
							<ul>
							<c:forEach var ="info" items="${allList}">
							<!-- dialog开始 -->
								<div class="remodal" data-remodal-id="${info.title}" role="dialog" aria-labelledby="modal1Title" aria-describedby="modal1Desc">
  									<button data-remodal-action="close" class="remodal-close" aria-label="Close"></button>
  									<div>
    									<h2 id="modal1Title">${info.title}</h2>
    									<p id="modal1Desc">${info.content}</p>
  									</div>
  									<br>
								</div>
							<!-- dialog结束 -->
							<div class="remodal-bg">
								<li><span><a href="#${info.title}" style="font-size: 13px;">${info.title}</a>&nbsp;&nbsp;&nbsp;&nbsp;${info.createtime}</span></li>
							</div>
							</c:forEach>
							</ul>
						</li>
						<li>
							<h2>最新热帖</h2>
							<ul>
							
						<c:forEach var="b" items="${bbs}">
								<li><span><a href="discuss.do?bbsid=${b.bbsid}" style="font-size: 13px;">${b.title}</a></span></li>
						</c:forEach> 
			
							</ul>
						</li>
					</ul>
				</div>
				<!-- end #sidebar -->
				<div style="clear: both;">&nbsp;</div>
			</div>
		</div>
	</div>
	<!-- end #page -->
</div>
<div id="footer">
	<p>江苏师范大学版权所有 © 1998-2015  泉山校区：江苏省徐州市铜山新区上海路101号　邮政编码：221116 　苏ICP备-05007135号</p>
</div>
<!-- end #footer -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../libs/jquery/dist/jquery.min.js"><\/script>')</script>
<script src="dist/remodal.js"></script>
<!-- Events -->
<script>
  $(document).on('opening', '.remodal', function () {
    console.log('opening');
  });

  $(document).on('opened', '.remodal', function () {
    console.log('opened');
  });

  $(document).on('closing', '.remodal', function (e) {
    console.log('closing' + (e.reason ? ', reason: ' + e.reason : ''));
  });

  $(document).on('closed', '.remodal', function (e) {
    console.log('closed' + (e.reason ? ', reason: ' + e.reason : ''));
  });

  $(document).on('confirmation', '.remodal', function () {
    console.log('confirmation');
  });

  $(document).on('cancellation', '.remodal', function () {
    console.log('cancellation');
  });
</script>
</body>
</html>
