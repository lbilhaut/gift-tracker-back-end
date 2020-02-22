<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="link" value="/add-a-family">
</c:url>
<div class="container-fluid text-center">
	<h1>Login in</h1>
	<div class= "row">
		<c:if test="${not empty message}">
			<div class="btn btn-outline-danger col-lg-4 offset-lg-4" id="fail-login">
			<svg id="icon-x" xmlns="http://www.w3.org/2000/svg" width="12" height="16" viewBox="0 0 12 16"><path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48L7.48 8z"/></svg>
			<c:out value="${message}"></c:out>
			</div>
		</c:if>
	</div>
	<form method="POST" action="${RELATIVE_PATH}/user-logged-in" _lpchecked="1">
	<div class="formInputGroup">
		<input type="text" class="form-control col-lg-4" placeholder="Username" name="username" aria-label="user name"/>
		<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Password" name="password" />
	</div>
	<input class="btn btn-primary formSubmitButton" type="submit" value="Submit" />
	</form>
		

</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
