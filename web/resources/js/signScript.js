$(function(){

	'use strict';
	$('#userName').blur(function () {
		$.ajax({
			url: "checkuser",
			type: "get",
			data: {
				userName:$(this).val()
			},
			success: function(response) {
				//Do Something
			},
			error: function(xhr) {
				$.alert('user name already exits, try new');
				$("#userName").focus();
				xhr.preventDefault();
			}
		});
	});

	$('#gotoLogin').click(gotoLogin);
	$('#gotoSignUp').click(gotoSignup);
	$('#signupBtn').click(function () {
		$(".nullCheck").each(function (e) {
			if (this.value== "") {
				// alert("All user information is required");
				$.alert({
					title: 'Attention!',
					content: this.name+' is required',
				});
				e.preventDefault();
			}
		});
		addUser();
	});


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
				logInPage();
			})();
	}


	function logInPage(){
		setTimeout(function() {
			window.location.href = "/login";
		}, 2000);
	}



	function gotoLogin() {
		$.get("login",{},function(responseText) {
			$('body').html(responseText);
		});

	}
	function gotoSignup() {
		$.get("signup",{},function(responseText) {
			$('body').html(responseText);
		});

	}

});

