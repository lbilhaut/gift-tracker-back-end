<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="link" value="/add-a-family">
</c:url>
<div class="container-fluid">
	<div class="row">
		<a href="RELATIVE_PATH/register" class="col-lg-2 offset-lg-3"><button type="button" class="btn btn-danger btn-block">Sign up</button></a>
		<a href="RELATIVE_PATH/login" class="col-lg-2"><button type="button" class="btn btn-warning btn-block">Log in</button></a>
		<a href="RELATIVE_PATH/demo" class="col-lg-2"><button type="button" class="btn btn-success btn-block">Demo</button></a>
	</div>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
