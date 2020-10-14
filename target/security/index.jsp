<%@ page language="java" contentType="text/html; utf-8"
     pageEncoding="utf-8" isELIgnored="false"
%>
<html>
<head>
    <title></title>
</head>
<body>
<h3>网站首页</h3>
<a href="${pageContext.request.contextPath}/product/findAll.do">显示商品信息</a>
<jsp:forward page="pages/main.jsp"></jsp:forward>
</body>
</html>