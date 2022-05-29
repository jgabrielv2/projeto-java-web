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
		<label for="nome">Nome: </label> 
		<input type="text" name="nome" id="nome"/>
		<label for="data">Data Abertura: </label>
		<input type="text" name="data" id="data" /> 
		<input type="hidden"
			name="acao" value="NovaEmpresa"> <input type="submit" />
	</form>

</body>
</html>