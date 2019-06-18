$(function(){

	'use strict'


	let e1=1,e2=1,e3=1,e4=1;
	var userNamePattern=new RegExp("^[a-zA-z0-9]{4,15}$");
	var addressPattern=new RegExp("^([a-zA-z0-9]{2,15})(( )([a-zA-z0-9]{2,15}))*$");
	var fullNamePattern=new RegExp("^([a-zA-z0-9]{2,15})(( )([a-zA-z0-9]{2,15})){1,5}$");
	var passwordPattern=new RegExp("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}");
	var emailPattern=new RegExp('^[A-Za-z0-9._%+-]{3,}@[A-Za-z0-9.-]{2,}\\.[A-Za-z]{2,6}$');


	$('#address').on('blur',function () {
		if(!($("#address").val().match(addressPattern))){
			$("#myError3").html("<span style='color:red;'> Must contain letters only with one space between words!</span>");
			e1=1;
		}
		else {
			$("#myError3").text('');
			e1=0;
		}
	});

	$('#fullName').on('blur',function () {
		if(!($("#fullName").val().match(fullNamePattern))){
			$("#myError2").html("<span style='color:red;'> Must contain letters only with one space between words!</span>");
			e2=1;
		}
		else {
			$("#myError2").text('');
			e2=0;
		}
	});

	$('#password').on('blur',function () {
		if(!($("#password").val().match(passwordPattern))){
			$("#myError2").html("<span style='color:red;'> Password must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters!</span>");
			e3=1;
		}
		else {
			$("#myError2").text('');
			e3=0;
		}
	});

	$('#email').on('blur',function () {
		if(!($("#email")=="") && !($("#email").val().match(emailPattern))){
			$("#myError1").html("<span style='color:red;'> Invalid email address!</span>");
			e4=1;
		}
		else {
			$("#myError1").text('');
			e4=0;
		}
	});

	$("#userName").on("blur",function(){
		checkUserExistence();
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
			if(e1*e2*e3*e4==1){
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

	function checkUserExistence(event){
		//alert('blur event');
		if(!($("#userName")=="") && !($("#userName").val().match(userNamePattern))){
			$("#myError1").html("<span style='color:red;'> UserName must contain only 4-15 letter and/or numbers!</span>");
			$("#userName").focus();
		}
		else {
			$("#myError1").text('');

		}
		$.ajax({
			url: "checkuser",
			type: "get",
			data: {
				userName:$('#userName').val()
			},

			success: function(response) {
				debugger;
				if(response=="true") {
					$("#myError").html("<span style='color:red;'> alreadey exists!</span>");
					$("#userName").focus();
					//event.preventDefault();
				}
				else{
					$("#myError").text("");
				}
			},
			error: function(xhr) {
				$.alert("something went wrong");
			}
		});
	}

});

