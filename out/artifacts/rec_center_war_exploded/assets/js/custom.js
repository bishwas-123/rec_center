$(function(){
    "use strict";

    (function(){



        $("#form-signin").on("submit",function(event){
            if($("#email").val()=="" || $("#password").val()==""){
                $("#profile-name").text("Fields Should not be empty !").css("color","red");
                if($("#email").val()=="") {$("#email").focus();}
                else{ $("#password").focus();}
                event.preventDefault();
            }
        });
        $("#email").on("blur",function (){
                $(this).trigger("keypress");
        });
        $("#email").on("keypress",function () {
            if($(this).val().trim().length>0){
                var url=basePath+'/checkuser';
                var email=$(this).val();
                $.post(url,{check:email},validateUser);
            }
        });


       function validateUser(data){
           var result;
        if(data==1){
            var pattern = new RegExp(/^[+a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i);
            if(pattern.test($("#email").val().trim())){

            }else{
                $("#email").focus();
            }
            result="<span style='color:green;'>Correct username !</span>";
        }
        else {
            result = "<span style='color:red;'>Invalid user email !</span>";
            $("#email").focus();
        }

            $("#profile-name").empty();
            $("#profile-name").html(result);
       }
    })();

})


