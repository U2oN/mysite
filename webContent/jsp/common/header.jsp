<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String Login = (String) session.getAttribute("Login");
%>

<header>

	<div class="hcontents">
		<div class="title">商品一覧システム</div>

		<%--ログインしたら表示 --%>
		<p>
			<%
				if (Login != null) {
			%>

		<div class="logout">
			<p><%=Login%><a href="<%=request.getContextPath()%>/Logout">ログアウト</a>
			</p>

			<%
				}
			%>
		</div>

	</div>



</header>


<%--<a href="<%= request.getContextPath()%>/Logout">ログアウト</a>--%>
<%--<form action="<%=request.getContextPath()%>/Logout" method="post">
<input type="submit" value="ログアウト" /></form>--%>
