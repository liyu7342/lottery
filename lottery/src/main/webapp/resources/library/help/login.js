/**
 * Created by Administrator on 2017/4/1.
 */

$(document).ready(function(){
    $('input[type="text"],input[type="password"]').keypress(function (e) {
        if (e.keyCode == 13) {
            doLoginByPwd();
        }
    });

    $("#login").validate({
        onkeyup: false,
        rules: {
            userAccount:{
                required:true
            },
            userPwd:{
                required:true
            }
        },
        messages: {
            userAccount:{
                required:"请输入账号"
            },
            userPwd:{
                required:"请输入密码"
            }
        },
        errorPlacement: function(error, element) {
            if(error[0].innerHTML!=""){
               layer.tips(error[0].innerHTML, "#" + element[0].id, {
                    tips: [1, '#F99228']
                });
                $("#" + element[0].id).addClass("error");
            }
        },
        success: function(label) {
            layer.closeAll();
            $("#" + label[0].htmlFor).removeClass("error");
        }
    });

    $("#btnLogin").click(function(){
        doLoginByPwd();
    });
});


function doLoginByPwd(){
    if(!$("#login").valid())
        return;
    var oData =$("#login").serializeObject();
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/home/doLogin',
        async: false,
        data: oData,
        success: function(data) {
            if(data.success){
                window.location.href = "/home/index";
            }
            if (!data['success']) {
                layer.tips(data.msg+ "！","#txt_user_id", {
                    tips: [1, '#e84c3d'],
                    time: 4000
                });
                return;
            }
        },
        error: function(data) {
        }
    });
}