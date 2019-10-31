<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="text-center">

<h1>See my previous gifts</h1>

<form method="POST" action="/KidsGiftTracker2/previous-gifts-kid" _lpchecked="1">
<div class="formInputGroup">
		<div>
	 		<select name="firstname" class="btn btn-light dropdown-toggle ">
	 			<c:forEach var="firstname" items="${listOfKids}">
	  				<option value="${firstname}">${firstname}</option>
				</c:forEach>
	 		</select>
		</div>
		
			<div>OR Filter by family:
	 		<select name="familyName" class="btn btn-light dropdown-toggle" id="familyPicker">
	 			<c:forEach var="familyName" items="${listOfFamilies}">
	  				<option value="${familyName}">${familyName}</option>
				</c:forEach>
	 		</select>
	 		
	 		<div class="invisible" id="test-visibility">
	 				<div> now pick a kid from this family:
<!-- 	 		<select name="kidFirstname" class="btn btn-light dropdown-toggle ">
	 			<c:forEach var="kidFirstname" items="${listOfKidsFromThisFamily}">
	  				<option value="${kidFirstname}">${kidFirstname}</option>
				</c:forEach>
	 		</select>
	 		 -->
		</div>
	 		
	 		</div>
	 		
		</div>

</div>
<input class="btn btn-primary formSubmitButton" type="submit" value="Submit" />
</form>

</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
