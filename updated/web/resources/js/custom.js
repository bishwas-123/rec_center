$(function(){
    (function(){
        //"use strict"
        $("#form-signin").on("submit",function(event){

            if($("#inputEmail").val()=="" || $("#inputPassword").val()==""){
                $("#profile-name").text("Fields Should not be empty !").css("color","red");
                if($("#inputEmail").val()=="") {$("#inputEmail").focus();}
                else{ $("#inputPassword").focus();}
                event.preventDefault();
            }
        });
        $("#inputEmail").on("blur",function (){
                $(this).trigger("keypress");
        });
        $("#inputEmail").on("keypress",function () {
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
            if(pattern.test($("#inputEmail").val().trim())){

            }else{
                $("#inputEmail").focus();
            }
            //result="<span style='color:green;'>Correct username !</span>";
        }
        else {
            result = "<span style='color:red;'>Invalid user email !</span>";
            $("#inputEmail").focus();
        }

            $("#profile-name").empty();
            $("#profile-name").html(result);
       }
    })();
    function currentTime() {
        var date = new Date(); /* creating object of Date class */
        var hour = date.getHours();
        var min = date.getMinutes();
        var sec = date.getSeconds();
        hour = updateTime(hour);
        min = updateTime(min);
        sec = updateTime(sec);
        document.getElementById("clock").innerText = hour + " : " + min + " : " + sec; /* adding time to the div */
        var t = setTimeout(function(){ currentTime() }, 1000); /* setting timer */
    }

    function updateTime(k) {
        if (k < 10) {
            return "0" + k;
        }
        else {
            return k;
        }
    }

    currentTime(); /* calling currentTime() function to initiate the process */




$("#punch-in-out").on("submit",function(event){
    var test=$("#userId-checkIn").val();
    if(!test.match(/^\d+$/)){
        return false;
    }
});
}(jQuery));


