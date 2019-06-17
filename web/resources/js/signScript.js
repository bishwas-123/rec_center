$(function(){

	'use strict';

	$('#signupBtn').click(addUser);

	function addUser(){
		var userName = $('#userName').val();
		var password = $ ('#password').val();
		var fullName = $ ('#fullName').val();
		var occupation = $ ('#occupation').val();
		var address = $ ('#address').val();
		var contact = $ ('#contact').val();
		var email = $ ('#email').val();
		var dob = $('#dob').val();
		var gender = $('input[name=gender]:checked').val();

		var user = {userName:userName, password:password, fullName:fullName, occupation:occupation, address:address,contact:contact, email:email, dob:dob, gender:gender};

		$.post('signup',{user: JSON.stringify(user)})

			.done(function() {
				$('.card')
					.html("<div>Successfully added! <br> Redirecting to Login Page Shortly</div>");
			})
			.fail(function() {
				alert( "error" );
			})
			.always(function() {
				homePage();
			})();
	}

	function homePage(){
		setTimeout(function() {
			window.location.href = "/login";
		}, 3000);
	}

})

