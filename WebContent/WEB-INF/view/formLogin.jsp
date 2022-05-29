<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/entrada" var="linkServletNovaEmpresa" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNovaEmpresa }" method="post">
		<label for="login">Login: </label>

		<input type="text" name="login" id="login" />
		<label for="senha">Senha: </label>
		<input type="password" name="senha" id="senha" /> 
		<input type="hidden" name="acao" value="Login"> 
		<input type="submit" />
	</form>

</body>
</html>