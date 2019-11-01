<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="link" value="/add-a-family">
</c:url>
<div class="container-fluid">
	<div class= "row">
		<c:if test="${not empty loginSuccess or not empty RegistrationSuccess or not empty message}">
			<div class="btn btn-outline-success col-lg-4 offset-lg-4" id="success-login">
			<svg id="icon-checked" xmlns="http://www.w3.org/2000/svg" width="12" height="16" viewBox="0 0 12 16"><path fill-rule="evenodd" d="M12 5l-8 8-4-4 1.5-1.5L4 10l6.5-6.5L12 5z"/></svg>
			<c:out value="${loginSuccess}"></c:out>
			<c:out value="${RegistrationSuccess}"></c:out>
			<c:out value="${message}"></c:out>
			</div>
		</c:if>
	</div>
	<div class="row">
		<div class="col-lg-4 offset-lg-3" id="dashboard-title">
			<h1>${user.username}'s dashboard</h1>
		</div>
		<a href="${RELATIVE_PATH}/logout" class="col-lg-2"><button type="button" class="btn btn-light btn-block">Log out</button></a>
	</div>
	<c:if test="${user.username == 'Demo'}">
		<c:import url="/WEB-INF/jsp/user/dashboard-demo.jsp" />	
	</c:if>
	<c:import url="/WEB-INF/jsp/user/dashboard-buttons.jsp" />
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
