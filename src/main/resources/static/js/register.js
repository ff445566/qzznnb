function registfun(){
    var username = $("#username").val()
    // 身份不能不选择

    console.log(username);
    $.ajax({
        async : true,
        type : "post",
        url : "http://127.0.0.1:8080/user/create",
        data: {
            "username" : username,
            "password" : $("#password").val(),
            "age": $("#age").val(),
            "email": $("#email").val(),
            "usertype" : $("#usertype").val()

        },
        dataType:"json",
        success : function (data) {
            console.log(data)
        },
        error :function () {

            alert("it has error");

        }
    })
}