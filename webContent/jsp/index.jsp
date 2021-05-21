<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>ログイン画面</title>
</head>
<body>
	<%@include file="/jsp/common/header.jsp"%>
	<div class="login">
		<p>ログイン画面</p>
		<p>ユーザIDとパスワードを入力してください。</p>
		<%--id,パスワードの認証へ--%>
		<form action="<%=request.getContextPath()%>/Index" method="post">
			ユーザID&nbsp;&nbsp;:<input type="text" name="id" maxlength="5"
			pattern="^[0-9]+$" title="ユーザIDは半角数字で入力して下さい。"
			autofocus required size="19" onInput="checkForm(this)">
			<br>
			パスワード:<input type="password" name="pass"pattern="^[0-9A-Za-z]+$"
			title="パスワードは半角英数字で入力して下さい。"required size="20"
			onInput="checkForm(this)"><br>
			<input type="submit" value="ログイン"><br>
			<script type="text/javascript">

function checkForm($this)
{
    var str=$this.value;
    while(str.match(/[^A-Z^a-z\d\-]/))
    {
        str=str.replace(/[^A-Z^a-z\d\-]/,"");
    }
    $this.value=str;
}
</script>

		<%--整合しなかった場合エラーメッセージ表示 --%>
		<p>
		<div class="error">
			<%
				if (ErrorMessage != null) {
			%>

			<p><%=ErrorMessage%></p>
			<%
				}
			%>
		</div>
	</div>
	<%@include file="/jsp/common/footer.jsp"%>
</body>
</html>