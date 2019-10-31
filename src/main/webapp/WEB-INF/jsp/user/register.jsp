<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="link" value="/add-a-family">
</c:url>
<div class="container-fluid text-center">
	<h1>Register</h1>
	
<form method="POST" action="${RELATIVE_PATH}/user-signed-up" _lpchecked="1">
<div class="formInputGroup">
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Username" name="username" aria-label="user name"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Password" name="password" />
<!-- <input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Please, retype password" name="retypedPassword" />
 -->
<a class="btn btn-info btn-block wrap col-lg-4 offset-lg-4" data-toggle="collapse" href="#familyMoreInfoParents" role="button" aria-expanded="false" aria-controls="collapseExample">
  Add more information </a>
  <div class="collapse" id="familyMoreInfoParents">
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Firstname" name="firstname" aria-label="first name"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Lastname" name="lastname" aria-label="last name"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Phone number" name="phoneNumber" aria-label="Phone number"/>
<input type="text" class="form-control col-lg-4 offset-lg-4" placeholder="Email address" name="email" aria-label="Email address"/>
</div>

</div>
<input class="btn btn-primary formSubmitButton" type="submit" value="Submit" />
</form>
	

</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
