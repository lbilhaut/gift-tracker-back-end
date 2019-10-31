<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div class="text-center">

<h1>Add a family</h1>	
<div>
<img class="col-lg-3 col-md-3 col-xs-4" src="img/family.png" alt="Family" />	
</div>
<form method="POST" action="/KidsGiftTracker2/family-added" _lpchecked="1">
<div class="formInputGroup">
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Family nickname" name="familyNickname" aria-label="family nickname"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Family name" name="familyName" />
<!-- <input type="checkbox" id="familyMoreInfo" name="moreInfo" value="test"><br>
 -->
<a class="btn btn-info btn-block wrap col-lg-4 offset-lg-4" data-toggle="collapse" href="#familyMoreInfoParents" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add parent's first name, email, phone number
  </a>
  <div class="collapse" id="familyMoreInfoParents">
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Parent 1 first name" name="parent1FirstName" aria-label="Parent 1 first name"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Parent 1 phone number" name="parent1PhoneNumber" aria-label="Parent 1 phone number"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Parent 1 phone number" name="parent1Email" aria-label="Parent 1 email address"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Parent 2 first name" name="parent2FirstName" aria-label="Parent 2 first name"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Parent 2 phone number" name="parent2PhoneNumber" aria-label="Parent 2 phone number"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Parent 2 phone number" name="parent2Email" aria-label="Parent 2 email address"/>
</div>
<a class="btn btn-info btn-block col-lg-4 offset-lg-4" data-toggle="collapse" href="#familyMoreInfoAddress" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add family address
  </a>
  <div class="collapse" id="familyMoreInfoAddress">
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Street name" name="addressStreet" aria-label="Parent 1 first name"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="City" name="addressCity" aria-label="Parent 1 phone number"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="ZIP" name="addressZipcode" aria-label="Parent 1 email address"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="State" name="addressState" aria-label="Parent 2 first name"/>

</div>

</div>
<input class="btn btn-primary formSubmitButton" type="submit" value="Submit" />
</form>

</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
