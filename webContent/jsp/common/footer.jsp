<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String Login2 = (String) session.getAttribute("Login");
%>
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome-animation/0.0.10/font-awesome-animation.css"
	type="text/css" media="all" />


<footer>
<p></p>

	<%
		if (Login2 != null) {
	%>

	<a class="ft" href="https://forms.gle/PpsRzQVsxRH1C6ED6"> <i
		class="fab fa-google faa-spin animated"></i>Googleフォームで入荷依頼する
	</a>
	<%
		}
	%>



</footer>

<%--<a class="ft"
		href="https://twitter.com/intent/tweet?
text=ログインして商品一覧を見る&
url=http://localhost:55000/item_list/jsp/index.jsp/&
hashtags=商品">
		<i class="fab fa-twitter faa-wrench animated"></i>Twitterで勧める
	</a> --%>