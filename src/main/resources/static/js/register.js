function registfun(){

    $.ajax({
        async : true,
        type : "post",
       url : "http://127.0.0.1:8082/qzznnb/user/create",
        //  url : "http://120.27.4.196:8082/qzznnb/user/create",
        data: {
            "phone" :  $("#phone").val(),
            "password" : $("#password").val(),
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