<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="container-fluid text-center">
<h1>Add a gift</h1>	
<div>
<img class="col-lg-1 col-md-3 col-sm-4 col-4" src="img/gift.png" alt="Gift" />	
</div>
	<div class= "row">
		<c:if test="${not empty message}">
			<div class="btn btn-outline-danger col-lg-4 offset-lg-4" id="fail-login">
			<svg id="icon-x" xmlns="http://www.w3.org/2000/svg" width="12" height="16" viewBox="0 0 12 16"><path fill-rule="evenodd" d="M7.48 8l3.75 3.75-1.48 1.48L6 9.48l-3.75 3.75-1.48-1.48L4.52 8 .77 4.25l1.48-1.48L6 6.52l3.75-3.75 1.48 1.48L7.48 8z"/></svg>
			<c:out value="${message}"></c:out>
			</div>
		</c:if>
	</div>

<form method="POST" action="/KidsGiftTracker2/gift-added" _lpchecked="1" enctype="multipart/form-data">
<div class="formInputGroup">
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Gift name*" name="giftName" aria-label="Gift name"/>
<div class="container-fluid text-center">
Upload a picture:    	<input type="file" name="file" /><br>
	</div>	

		<div>Pick a kid:
	 		<select name="kidFirstname" class="btn btn-light dropdown-toggle ">
	 			<c:forEach var="kidFirstname" items="${listOfKids}">
	  				<option value="${kidFirstname}">${kidFirstname}</option>
				</c:forEach>
	 		</select>
		</div>
		
<a class="btn btn-info" data-toggle="collapse" href="#giftMoreInfo" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add more info
  </a>
  <div class="collapse" id="giftMoreInfo">
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Occasion" name="giftOccasion" aria-label="Gift occasion"/>
<input type="number" class="form-control col-lg-4 offset-lg-4" placeholder="Year" name="giftYear" aria-label="Year"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Notes" name="giftNotes" aria-label="Notes"/>
</div>

</div>
<input class="btn btn-primary formSubmitButton" type="submit" value="Submit" />
</form>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
