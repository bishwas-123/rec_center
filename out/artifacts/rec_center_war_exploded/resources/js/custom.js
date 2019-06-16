$(function(){
    (function(){
        $("#form-signin").on("submit",function(event){
            if($("#inputEmail").val()=="" || $("#inputPassword").val()==""){
                $("#profile-name").text("Fields Should not be empty !").css("color","red");
                if($("#inputEmail").val()=="") $("#inputEmail").focus();
                if($("#inputPassword").val()=="") $("#inputPassword").focus();
                event.preventDefault();
            }
        });
        $("#inputEmail").on("blur",function (){
           // alert();
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
            result="<span style='color:green;'>Correct username !</span>";
        }
        else {
            result = "<span style='color:red;'>Invalid user email !</span>";
            $("#inputEmail").focus();
        }

            $("#profile-name").empty();
            $("#profile-name").html(result);
       }

        function processData(data){
            //data = JSON.parse(data);
            var td0=$('<td>').text(data.id);
            var td1 = $('<td>').text(data.name);
            var td2 = $('<td>').text(data.price);
            var tr = $('<tr>').append(td0).append(td1).append(td2);
            $('#tbl_products>tbody').append(tr);
        }
    })();

})


