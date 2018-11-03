<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="robots" content="nofollow"/>
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
<style>
body{width:100%;height:100%;overflow:hidden;background:url(images/pc_loginBg.jpg) no-repeat;background-size:cover;position:absolute;}
</style>
<script src="js/jquery.js"></script>
<script src="js/Particleground.js"></script>
<script>

</script>

</head>
<body>
	<form action="AdminLogin" method="post">
  <section class="loginform">
   <h1>Ban辣匠后台管理系统</h1>
   <ul>
    <li>
     <label>账号：</label>
     <input type="text" class="textBox" name="userName" placeholder="管理员账号" id="userName"/>
    </li>
    <li>
     <label>密码：</label>
     <input type="password" class="textBox" name="userPassword" placeholder="登录密码" id="userPassword"/>
    </li>
    <li>
     <button type="submit" style="height:30px;width:60px;" id="btn">立即登录</button>
    </li>
   </ul>
  </section>
  </form>
  <script type="text/javascript">
  var btn = document.getElementById("btn");
  var userName = document.getElementById("userName");
	var userPassword = document.getElementById("userPassword");
	btn.onclick = function (){
		
		if(userName.value===""){
			alert("请输入管理员账号！")
			return false;
		}else{
		if(userPassword.value===""){
			alert("请输入密码！");
			return false;
		}else{
			return true;
		}
		}
	}
  </script>
</body>
</html>