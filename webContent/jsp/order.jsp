<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="jp.co.rich.item.bean.Item"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>発注依頼ページ</title>
</head>
<body>
	<%@include file="/jsp/common/header.jsp"%>
	<h2>発注依頼ページ</h2>
	<form action="<%=request.getContextPath()%>/Order" method="post">

		<p>
		ID…${item.itemId}</p>
			<input type="hidden" name="itemId" value="${item.itemId}" />
			<input type="hidden" name="stock" value="${item.stock}" />




		<p>
			発注数：<input type="text" name="order" />
		</p>

		<input type="submit" value="発注" />
	</form>
	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>