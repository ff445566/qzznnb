function userloginfun(){

    console.log(username);
    $.ajax({
        async : true,
        type : "post",
        url : "http://127.0.0.1:8080/user/login",
        data: {
            "username" : $("#username").val(),
            "password" : $("#password").val()
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