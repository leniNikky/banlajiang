<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改用户权限</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="style/adminStyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form action="Editroot" method="post">
 <div class="wrap">
  <div class="page-title">
    <span class="modular fl"><i class="edit_user"></i><em>修改用户权限</em></span>
  </div>
  <table class="list-style">
  <input type="hidden" name="userID" value="${user.userID }">
   <tr>
    <td style="width:15%;text-align:right;">会员昵称：</td>
    <td>${user.userName }</td>
   </tr>
   <tr>
    <td style="text-align:right;">手机号码：</td>
    <td>${user.phone }</td>
   </tr>
   <tr>
    <td style="text-align:right;">电子邮箱：</td>
    <td>${user.email }</td>
   </tr>
   <tr>
    <td style="text-align:right;">用户权限：</td>
    <td>
     <select class="textBox" value="${user.userroot }" name="userroot">
      <option>0</option>
	  <option>1</option>
      </optgroup>
     </select>
    </td>
   </tr>
   <tr>
    <td style="text-align:right;"></td>
    <td><input type="submit" class="tdBtn" value="更新保存"/></td>
   </tr>
  </table>
  </form>
 </div>
</body>
</html>