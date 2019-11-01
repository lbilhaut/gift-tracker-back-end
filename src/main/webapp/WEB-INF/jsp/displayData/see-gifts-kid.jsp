<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="text-center">

	<h1>See ${kidName}'s gifts</h1>
	<c:forEach var="gift" items="${listOfGifts}">
		 <div class="row gift-list">
	 			<div class="col-lg-2 offset-lg-3 col-md-3 col-sm-4 col-8 offset-2 border rounded"> 
				<img class="img-fluid" src="${gift.giftPictureName}" alt="image of a toy" />
	 		</div>
			<div class="col-lg-4 col-8 offset-2 offset-lg-0 border rounded" id="gift-details">
				<h3>${gift.giftName}</h3>
				<c:if test="${not empty gift.giftOccasion}">
					<p>Occasion: ${gift.giftOccasion}</p>
				</c:if>
				<c:if test="${gift.giftYear != 0}">
					<p>Year: ${gift.giftYear}</p>
				</c:if>
				<c:if test="${not empty gift.giftNotes}">
					<p>Notes: ${gift.giftNotes}</p>
				</c:if>
			</div>
		</div>
	</c:forEach>
					<form method="POST" action="${RELATIVE_PATH}/add-a-gift" _lpchecked="1" class="col-lg-3 offset-lg-3">
					<input type="hidden" name="kidId" value="${kidId}">
					<input class="btn btn-primary formSubmitButton btn-block" type="submit" value="Add a new gift to this kid" />
				</form>		
	
	<div class="col-lg-2 offset-lg-5">
		<a href="${RELATIVE_PATH}/add-a-gift" ><button type="button" class="btn btn-success btn-block">Add a New Gift</button></a>
	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
