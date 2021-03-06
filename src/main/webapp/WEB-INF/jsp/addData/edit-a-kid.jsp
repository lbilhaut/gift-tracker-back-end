<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="text-center">

<h1>Edit ${kid.firstname}</h1>	
<div>
<img class="col-lg-1 1 col-md-3 col-sm-4 col-4" src="img/kid.png" alt="Kid" />	
</div>

<form method="POST" action="${RELATIVE_PATH}/kid-edited" _lpchecked="1">
	<div class="formInputGroup">
		<input type="number" class="form-control col-lg-4 offset-lg-4" placeholder="${kid.birthYear}" value="${kid.birthYear}" name="birthYear" aria-label="kid birth year"/>
		<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="${kid.nickname}" value="${kid.nickname}" name="nickname" aria-label="kid nickname"/>
		<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="${kid.firstname}" value="${kid.firstname}" name="firstname" aria-label="kid firstname"/>
		<div>
	 		<select name="familyName" class="btn btn-light dropdown-toggle ">
	 			<c:forEach var="familyName" items="${listOfFamilies}">
	  				<option value="${familyName}">${familyName}</option>
				</c:forEach>
	 		</select>
		</div>
		  <input type="hidden" name="kidId" value="${kid.kidId}">
		<input class="btn btn-primary formSubmitButton" type="submit" value="Submit" />
	</div>
</form>	


</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />