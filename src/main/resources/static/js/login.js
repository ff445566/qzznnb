function userloginfun(){

    $.ajax({
        async : true,
        type : "post",
       url : "http://127.0.0.1:8082/qzznnb/user/login",
        //url: "http://120.27.4.196:8082/qzznnb/user/login",
        data: {
            "phone" : $("#phone").val(),
            "password" : $("#password").val()
        },
        dataType:"text",
        success : function (data) {
            alert("登陆 成功 ");
            console.log(data);
        },
        error :function () {

            alert("it has error");

        }
    })
}