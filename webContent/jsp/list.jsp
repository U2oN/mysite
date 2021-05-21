<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="jp.co.rich.item.bean.Item"%>
<%
	String ErrorMessage = (String) request.getAttribute("ErrorMessage");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>商品一覧</title>
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome-animation/0.0.10/font-awesome-animation.css"
	type="text/css" media="all" />
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.0/js/jquery.tablesorter.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.31.0/js/jquery.tablesorter.widgets.min.js"></script>
<script>
	$(document).ready(function() {
		$("#myTable").tablesorter({
			headers : {
				2 : {
					sorter : false
				},
			},
			sortList : [ [ 0, 0 ] ],/*ID順*/
		});
	});
</script>
</head>
<body>
	<%@include file="/jsp/common/header.jsp"%>
	<div class="listpage">
		<div class="search">
			<div class="NameSearch">
				<%--商品名検索--%>
				<form action="<%=request.getContextPath()%>/NameSearch"
					method="post">
					商品名:<input type="text" name="ItemName" autofocus> <input
						class="ser" type="submit" value="検索">
				</form>
			</div>
			<div class="GenreSearch">
				<%--ジャンル名検索--%>
				<form action="<%=request.getContextPath()%>/GenreSearch"
					method="post">
					ジャンル名: <select name="genreResearch">
						<option value="書籍">書籍</option>
						<option value="食品">食品</option>
						<option value="生活用品">生活用品</option>
					</select> <input class="ser" type="submit" value="検索">
				</form>
			</div>
		</div>

		<div class="containner">
			<%
				if (ErrorMessage == null) {
			%>
			<p>${Item.size()}件ヒットしました<i
					class="fas fa-angle-double-down faa-flash animated"></i>
			</p>
			<%---一覧テーブル--%>
			<table id="myTable" class="table " border="1">
				<thead>
					<tr>
						<th>商品ID</th>
						<th>商品名</th>
						<th class="details">詳細</th>
						<th>登録日</th>
						<th>在庫</th>
						<th>ジャンル名</th>
					</tr>
				</thead>
				<%
					}
				%>
				<tbody>
					<c:forEach var="Item" items="${Item}">
						<tr title=${Item.genre.genreName}>
							<td>${Item.itemId}</td>
							<td>${Item.itemName}</td>
							<td>${Item.details}</td>
							<td>${Item.registerDate}</td>
							<td title=${Item.stock}>${Item.stock}
								<div class="mask">
	<form action="<%=request.getContextPath() %>/Update"method="post">
	<input type="hidden" name="itemId" value="${Item.itemId}"/>
	<input type="hidden" name="stock" value="${Item.stock}"/>
	<input type="submit" value="発注へ" />
	</form>
								</div></td>
							<td>${Item.genre.genreName}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>

		<%--0件の場合のエラーメッセージ --%>
		<p>
		<div class="error">
			<%
				if (ErrorMessage != null) {
			%>

			<p><%=ErrorMessage%></p>
			<a href="<%=request.getContextPath()%>/NameSearch">一覧表示に戻る</a>
			<%
				}
			%>
		</div>
	</div>


	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>