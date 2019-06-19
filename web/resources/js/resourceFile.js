$(function () {

    function updateHandler(e) {
        e.preventDefault();
        var id = $(this).attr("data-id");
        // alert(id);
        // updateMember(id);
        $('#resources_id').val(id);
        $('#resources_title').val( $(this).attr("data-fullName"));
        $('#resources_category').val( $(this).attr("data-phone"));
        $('#resources_quantity').val( $(this).attr("data-address"));
        $('#resources_description').val( $(this).attr("data-description"));
        $('#mode').val('update');
        $('#resources_id').attr('readonly', true);

    }
    function deleteHandler(e) {
        e.preventDefault();
        alert($(this).attr("id"));
        deleteMember($(this).attr("id"));
    }
    $('#btn_b').click(addmember);
    function addmember() {
        alert("1");
        // var id = $('#member_Id').val();
        var full = $('#resources_title').val();
        var p = $('#resources_category').val();
        var add = $('#resources_quantity').val();
        var add1 = $('#resources_description').val();
        alert("2");
        alert(add1);
        var resources = {title: full, category: p, quantity: add,description: add1};
        if($("#mode").val()==="add")
        {
            alert("add");
            $.post('viewresouces', {resourcesObj: JSON.stringify(resources)}, redefine, "json")
        }
        if($("#mode").val() === "update")
        {
            var id = $('#resources_id').val();
            resources.id=id;
            $.ajax({
                url:'updateresources?id='+ id,
                type:'POST',
                dataType:"json",
                data:{resourcesObj: JSON.stringify(resources)},
                success: function (d) {
                    alert("record has been updated!");
                    $("#ROW_"+ id).remove();
                    redefine(d);

                },
                error:function(request, status, error){
                        alert(request.responseText);
                }

            })
        }

    }

    function redefine(resources) {
        //data = JSON.parse(data);
        var td0 = $('<td>').text(resources.id);
        var td1 = $('<td>').text(resources.title);
        var td2 = $('<td>').text(resources.category);
        var td3 = $('<td>').text(resources.quantity);
        var td4 = $('<td>').text(resources.description);
        var dataId=resources.id;
        var remark = '<td><a  class="update-link" ' +' data-id="' + resources.id + '" data-fullname="' +resources.title+'" data-phone="' + resources.category+'" data-address="'+ resources.quantity+'" data-description="'+ resources.description +'"  href="#addEmployeeModal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a></td>'+
            '<td><a href="#" class="delete-link" id="'+ dataId+'"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a></td>';

        // <a class="update-link" data-id="3" data-fullname="Anna Lundi" data-phone="(509) 4195-2126" data-address="Cornillon" href="#">Edit</a>
        var tr = $('<tr id="ROW_'+resources.id+'">').append(td0).append(td1).append(td2).append(td3).append(td4).append(remark);
        tr.find(".update-link").on('click', updateHandler);
        tr.find(".delete-link").on('click', deleteHandler);

        $('#tbl_resources>tbody').append(tr);
    }

    $(".delete-link").click(deleteHandler);

    $(".update-link").on('click', updateHandler);

    $(".add-link").click(function (e) {
        e.preventDefault();
        var id = $(this).attr("data-id");
        // alert(id);
        // updateMember(id);
        $('#resources_id').val("");
        $('#resources_title').val( "");
        $('#resources_category').val( "");
        $('#resources_quantity').val("");
        $('#resources_description').val("");
        $('#mode').val('add');
        $('#resources_id').attr('readonly', false);

    });


    // function updateMember(id, data){
    //     $.ajax({
    //         url:'memberUpdate?id='+id,
    //         type:'put',
    //         success: function () {
    //             alert("record has been updated!");
    //         }
    //     })
    // }

    function deleteMember(id){
        $.ajax({
            url:'resourceDelete?id='+id,
            type:'delete',
            success: function () {
                $("#ROW_"+id).remove();
                alert("record has been deleted!");
            }
        })
    }

});


//     function getAllMember(){
//     $.ajax({
//         url: 'viewmember',
//         type: "GET",
//         dataType: "json",
//         success: function (members) {
//             alert("hello")
//             var tableBody = $('#tbl_members tbody');
//             tableBody.empty();
//             $(members).each(function (index, element) {
//                 tableBody.append('<tr><td>'+element.fullName+'</td><td>'+element.address+'</td><td>'+element.phone+'</td><td><button onclick="deleteMember('+element.memberId+')">delete</button></td></tr>');
//             })
//         },
//         error: function (error) {
//             alert(error);
//
//         }
//     })
// }

//
//
//
//
//
//     // $('#del').click(deletemember);
//     //
//     // function deletemember() {
//     //   alert("***********************************");
//     //     $('#tbl_members>tbody').remove(this);
//     // }
//
// });

// $(document).ready(function () {
//     var member ={};
//     //redefine(member);
//     $('#btn').click(function () {
//         member.memberId = $('#member_Id').val();
//         member.fullName = $('#member_name').val();
//         member.address = $('#member_address').val();
//         member.phone = $('#phone_number').val();
//         var memberObj = JSON.stringify(member);
//         alert("hello"+ memberObj);
//         $.ajax({
//             type: "POST",
//             data: {memberObj: memberObj},
//             url: 'viewmember',
//            // data: JSON.stringify({data:"memberObj"}),
//             //dataType:"json",
//             //contentType: "application/json; charset=utf-8",
//             success: function () {
//                 alert('saved successfully');
//                 redefine(member);
//             },
//             error: function (error) {
//                 alert(error);
//
//             }
//
//         });
//
//
//     });
//
//     function redefine(member){
//           //data = JSON.parse(data);
//        var td0 = $('<td>').text(member.memberId);
//         var td1 = $('<td>').text(member.fullName);
//         var td2 = $('<td>').text(member.phone);
//         var td3 = $('<td>').text(member.address);
//        var dataId=member.memberId;
//         alert(dataId);
//
//         var remark="<td><a href='/edit?id='+dataId>Edit</a></td>\n" +
//             "<td><button onclick=\"deleteMember(member.memberId)\">Delete</button></td>";
//         var tr = $('<tr>').append(td0).append(td1).append(td2).append(td3).append(remark);
//         $('#tbl_members>tbody').append(tr);
//     }
//
// });
// $(document).ready(function () {
//     $("#btn").click(function () {
//         var fullName = document.getElementById("member_name");
//         var member_address = document.getElementById("member_address");
//         var phone_number = document.getElementById("phone_number");
//         if(fullName.value == "" || member_address == "" || phone_number.value == ""){
//             alert("Please enter all the field!");
//             return false;
//         }
//         alert(fullName.value);
//         $.ajax({
//             type: "POST",
//             contentType: "application/json",
//             url: "viewmember",
//             data: "{'fullName'"+fullName.value + "','member_address'" +member_address +"','phone_number'"+ phone_number +"'}",
//             datatype: "json",
//
//             success: function (data) {
//              // show_data();
//               alert("Submit Successfully");
//              // ClearField();
//             }
//
//         });
//
//     });
// });



