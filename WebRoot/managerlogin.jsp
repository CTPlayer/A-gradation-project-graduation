<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
		<meta charset="utf-8">
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<script src="http://www.imooc.com/data/jquery-1.8.2.min.js" type="text/javascript"></script>
        <script src="http://www.imooc.com/data/jquery-ui-1.9.2.min.js" type="text/javascript"></script>
		<!--webfonts-->
		<!--//webfonts-->
</head>
<body>
	<div class="main">
		<div class="header" >
			<h1>江苏师范大学教师个人网站管理系统登录</h1>
		</div>
		<p>崇德厚学，励志敏行</p>
		<br>
		<br>
		<div id="tab_list">
		<div id="user">				
			<form class="right-form" action="managerlogin.do?pageNo=1"  method="post">			
				<ul>	
				<label style="float: left;color: red">${error1}</label>
				<br>			
				<br>
					<div>					
						<label>管理员账号</label><li><input type="text"  name="email"   required/></li>
						 <label>密码</label><li><input type="password"  name="Password"  required/></li>
							<input type="submit"  value="登录" style="margin-left:0px">
					</div>
					<div class="clear"> </div>
				</ul>
				<div class="clear"> </div>
					
			</form>
		</div>	
		
		</div>
		</div>
			<!-----start-copyright---->
   					<div class="copy-right">
						<p>江苏师范大学版权所有 © 1998-2015  泉山校区：江苏省徐州市铜山新区上海路101号　邮政编码：221116 　苏ICP备-05007135号</p> 
					</div>
				<!-----//end-copyright---->
</body>
</html>