(function(){

	window.onload = function(){ 

//		// assign function to onclick property of checkbox
//		document.getElementById('familyMoreInfo').onclick = function() {
//			// access properties using this keyword
//			if ( this.checked ) {
//				// if checked ...
//				alert( "You checked the box" );
//			} else {
//				alert( "You didn't check the box" );
//				// if not checked ...
//			}
//		};
//		
		
		var mySelect = document.getElementById("familyPicker");

		mySelect.onchange = function() {
			alert( "You picked a family!" );
		   var x = document.getElementById("familyPicker").value;
		   
		   if ( document.getElementById("test-visibility").classList.contains('invisible') ){
			   document.getElementById("test-visibility").classList.remove('invisible');
			   document.getElementById("test-visibility").classList.add('visible');   
		   }
		   else{
			   document.getElementById("test-visibility").classList.remove('visible');
			   document.getElementById("test-visibility").classList.add('invisible');   
		     
		   }
		   
		};
		
	};
})();
