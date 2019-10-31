<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="text-center">

<h1>List of families</h1>


		<c:forEach var="family" items="${listOfFamilies}">
			 <div class="row gift-list">
 				<div class="col-lg-4 offset-lg-4 border rounded"> 
				<h5>${family.familyName}</h5>
				${family.familyNickname}				
				<c:if test="${not empty family.parent2FirstName}">
				<br>Parents: ${family.parent1FirstName} and ${family.parent2FirstName}
				</c:if>
				</div>	
			</div>
		</c:forEach>

</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
