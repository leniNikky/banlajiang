<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>后台</title>

<frameset rows="76,*" framespacing="0" border="0">
  <frame src="top.jsp?usertotal=${usertotal }" id="header-frame" name="header-frame" frameborder="no" scrolling="no">
  <frameset cols="180, 10, *" framespacing="0" border="0" id="frame-body">
    <frame src="menu.jsp" frameborder="no" scrolling="yes">
    <frame src="bar.jsp" frameborder="no" scrolling="no">
    <frame src="main.jsp" name="mainCont" frameborder="no" scrolling="yes">
  </frameset>
</frameset><noframes></noframes>
</head>
<body>

<input type="hidden" value="${admin.userName }" id="admin">

</body>
</html>