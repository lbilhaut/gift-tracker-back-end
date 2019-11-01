<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<c:url var="link" value="/add-a-family">
</c:url>
<div class="container-fluid text-center">
	<h1>Upload a Picture</h1>
	<div class= "row">
	<form method="POST" action="${RELATIVE_PATH}/upload" enctype="multipart/form-data">
    	<input type="file" name="file" /><br/>
    	<input type="submit" value="Submit" />
	</form>
	</div>	
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
