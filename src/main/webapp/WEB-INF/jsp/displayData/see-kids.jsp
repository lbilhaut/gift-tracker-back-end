<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="text-center">

<h1>Kids</h1>

<c:if test="${empty listOfKids}">No kids yet!</c:if> 
		<c:forEach var="kid" items="${listOfKids}">
			 <div class="row gift-list">
 				<div class="col-lg-4 offset-lg-4 border rounded"> 
				<h5>${kid.firstname} 				<c:if test="${not empty kid.nickname}">a.k.a. ${kid.nickname}</c:if></h5>
				<c:if test="${not empty kid.birthYear}">
				<br>Birth year: ${kid.birthYear}
				<br>${kid.firstname} is turning ${currentYear - kid.birthYear} this year.
				</c:if>
				<br><br>
				<div class="container">
				<div class="row">
				<form method="POST" action="/KidsGiftTracker2/delete-a-kid" _lpchecked="1" class="col-lg-3 offset-lg-3">
					<input type="hidden" name="kidId" value="${kid.kidId}">
					<input class="btn btn-primary formSubmitButton btn-block" type="submit" value="Delete" />
				</form>		
				<a href="/KidsGiftTracker2/edit-a-kid?kidId=${kid.kidId}" class="col-lg-3"><button type="button" class="btn btn-primary btn-block">Edit</button></a>
				</div>
				</div>
				</div>	
			</div>
		</c:forEach>
</div>
<div class="text-center">

		<a href="/KidsGiftTracker2/add-a-kid" class="col-lg-2"><button type="button" class="btn btn-primary">Add a New Kid</button></a>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
