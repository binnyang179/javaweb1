<%--
  Created by IntelliJ IDEA.
  User: crab179
  Date: 4/19/19
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>My JSP 'index.jsp' starting page</title>
</head>
<body>
<h1>失敗</h1>
</body>
</html>
success.jsp  成功页面

${xiaoxi}为EL表达式  获取request域中的键名为xiaoxi的值
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>My JSP 'success.jsp' starting page</title>
</head>
<body>
${xiaoxi} <br>
<a href="Searchall">查看所有用户</a>
</body>
</html>