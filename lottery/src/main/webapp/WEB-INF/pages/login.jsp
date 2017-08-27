
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <!-- Always force latest IE rendering engine (even in intranet) & Chrome Frame
		Remove this if you use the .htaccess -->
    <meta http-equiv="Pragma" content="no-cache" />
    <title>
        A28
    </title>
    <style type="text/css">
        body, div, form, input, img, p {
            margin: 0;
            padding: 0;
        }
        body {
            font: 14px/1.231 Verdana, Arial, Helvetica, sans-serif;
            color: #333333
        }
        a {
            color: #DD2405;
            text-decoration: underline
        }
        .bg {
            font-size: 0;
            line-height: 0;
            position: absolute;
            top: 0
        }
        .bg img {
            width: 1003px;
            border: 0;
        }

        .opacity {
            background: white;
            filter: alpha(opacity=50);
            z-index: 1;
            opacity: 0.5;
            width: 364px;
            height: 218px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            border-spacing: 0;
            vertical-align: middle;
            margin-top: 8px;
        }
        caption {
            height: 39px;
            font-size: 16px;
            color: #C40C00;
            font-weight: bold;
        }
        caption p {
            position: relative;
            bottom: 2px;
            border-top: 1px solid #FFC84E;
            font-size: 0;
            line-height: 0;
            height: 0
        }
        caption span {
            padding: 0 10px;
            position: relative;
            z-index: 2;
            background: #FFF9D7;
            top: 10px
        }
        th, td {
            padding: 8px 0
        }
        th {
            width: 21%;
            text-align: right;
            padding-left: 4px
        }
        input {
            height: 30px;
            line-height: 30px;
            border: 1px solid #9B9B9B;
            width: 176px
        }
        .sbt {
            width: 100%;
            height: 44px;
            padding: 1px;
            text-align: center;
        }
        .sbt input {
            width: 144px;
            height: 44px;
            color: white;
            background: #c40005;
            font-size: 16px;
            font-weight: bold;
            border: 0;
            cursor: pointer
        }
        .vcode input {
            width: 80px
        }
        .vcode img {
            vertical-align: top;
            height: 32px
        }
        .vbanben {
            font-size:13px;
            line-height:20px;
        }
        .vbanben input, .vbanben label {
            float:left;
            line-height: 30px;
        }
        #shenjiban {
            width:15px;
            border:none
        }
        #chuantongban {
            width:15px;
            border:none
        }
        #password_container{
            width:176px; display:inline-block; height:30px; position:relative;
        }
        #password_container a{
            line-height: 30px;height: 30px;
        }
        #sec {
            width: auto;
        }
        .downloadTip {
            display: none;
            background:#d6d6d6;
            color:#333;
            width:176px;
            height:22px;
            line-height:22px;
            text-decoration:none;
            position:absolute; left:0; top:0;
            font-size: 12px;
        }
        .dtshow {
            display: inline-block;
        }
        /* See license.txt for terms of usage */

        /*3G 线路 start*/
        .clx span {
            background: none repeat scroll 0 0 white;
            border: 1px solid #BEA564;
            color: red;
            margin-left: 5px;
            padding: 0 3px;
        }
        /*3G 线路 end*/
        .header{
            width: 100%;
            height: 80px;
            margin: 0 auto;
        }
        .footer{
            width: 965px;
            background: url("../../resources/images/linebottom.png");
            height:94px;
            clear: both;
            margin: 0 auto;
        }
        .corpname{color: #A64302;font-size: 25px;line-height: 80px;}

        .refreshbox{position: absolute;top: 20px;height: 31px;line-height: 31px;right: 45px;font-size: 13px;color: #010101;}
        .btn_1{      height: 31px;        line-height: 31px;        text-align: center;        cursor: pointer;    }
        .main{
            width: 965px;
            margin: 0 auto 20px;
            color: #000;
        }
        .mainLeft{ float:left;width: 470px;height:368px;background: url(../../resources/images/lineLeft.png) right no-repeat; position:relative}
        .mainRight{float:left;width: 450px;}
        .main p{
            margin: 0;
            height: 50px;
            line-height: 50px;
            position: relative;
        }
        .rightTit{
            position: absolute;
            height: 40px;
            line-height: 40px;
            width: 227px;
            border: 1px solid #878787;
            border-bottom: none;
            border-left: none;
            background-color: #f1f1f1;
            right: 0px;
            bottom: 0px;
        }
        .h-txt{position: absolute;
            height: 50px;
            line-height: 50px;
            color: #cf0002;
            text-align: center;
            width: 220px;
            border: 1px solid #878787;
            border-bottom: none;
            font-size: 18px;font-weight:bold;
            background-color: #fff;}
        .datalist-contain{
            overflow: hidden;
        }
        .datalist{
            width: 398px;
            background: #fff;
            float:left;
            padding:15px 25px;
            border: 1px solid #878787;
        }
        .datalist h2{
            font-size:14px;
            font-weight: bold;
            margin: 8px 0;
            margin-bottom: 7px;
            color: #333333;
            width: 100%;;
        }
        .datalist ul{
            overflow: hidden;
            padding-bottom: 8px;
        }
        .datalist li{
            float: left;
            width: 60px;
            line-height: 25px;
            color: #003399;
            text-align: center;
            margin: 0px 0px 0px 6px;
        }
        .datalist a:link ,.datalist a:visited,.datalist a:hover,.datalist a:active{
            color:#003399;
        }
        .datalist li a{
            display:inline-block;
            width: 100%;
            height: 100%;
            color: #003399;
            font-size:13px;

        }
        .datalist li span{
            font-size: 12px;
            color:#f00;
        }
        .datalist td {height:48px; padding:0;}
        .dlnotice{
            position: absolute;bottom: 0;
            color:#000;
            right: 0px;
            width: 380px;
            padding: 5px;
        }
        .dlnotice dt{margin: 0px;line-height: 24px;font-size: 14px;font-weight: bold;}
        .dlnotice dd{margin: 0px;line-height: 24px;font-size: 13px;}
    </style>
</head>

<body>
<div class="header">
</div>
<div class='main'>
    <div class="mainLeft">
        <dl class="dlnotice">
            <!--<dt>用戶安全須知</dt>
            <dd><font color="red">為了增強安全性，系統增加了密碼安全控件功能，點擊密碼輸入框下載安裝控件，完成後重啟瀏覽器再登錄。</font>您也可以選擇不啟用安全控件功能</dd>
            <dd>如圖所示：<img src="/theme/new/pic/lineother.png" /></dd> -->
        </dl>
    </div>
    <div class="mainRight">
        <p>
            <span class='h-txt'>會員登錄</span><span class="rightTit"></span>
        </p>
        <div class='datalist-contain datalist'>
            <form class="lo login " method="post" id="login_form" action="auth.htm">
                <table>
                    <tr>
                        <th>賬&nbsp;&nbsp;&nbsp;号：</th>
                        <td>
                            <input type="text" maxlength="12" name="__name" valid="account" value="" tabIndex="1" />
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>密&nbsp;&nbsp;&nbsp;碼：</th>
                        <td>
                            <input type="password" maxlength="16" name="password" valid="password" value="" tabIndex="2" id='password_txt'/>
                            <!-- <span id='password_container'></span> -->
                        </td>
                        <td></td>
                    </tr>
                    <tr class="vcode">
                        <th>驗證碼：</th>
                        <td colspan="2">
                            <input type="text" autocomplete="off" maxlength="12" name="VerifyCode" value="" tabIndex="3" />
                            <img id="img_auth" />
                            <a href="javascript:void(0)" onClick="getVImag()">看不清？</a>
                        </td>
                    </tr>
                    <!-- <tr class="vbanben">
                        <th></th>
                        <td colspan='2'>
                            <label for='sec'>
                                <input type='checkbox' id='sec' style="border:none;" />啟用安全控件</label>
                        </td>

                    </tr> -->
                    <tr>
                        <td rowspan="2" colspan="3">
                            <div class="sbt" style="padding:10px 0">
                                <input type="submit" value="登录" name="submit" tabIndex="4" />
                                <input type="hidden" name="status" value="init"/>
                                <input type="hidden" name="__VerifyValue" value=""/>
                                <input type="hidden" name="checksum" value=""/>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>

</div>
<div class="footer"></div>
<script type="text/javascript">
    var form = document.getElementsByTagName('form')[0];
    form.__name.value = "";
    function ajax(op){
        op = op || {};
        op.type = op.type || "POST";
        var xmlhttp = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP");
        xmlhttp.onreadystatechange = function(){
            if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                op.success(xmlhttp.responseText);
            }
        }
        if(op.type == "GET"){
            xmlhttp.open("GET","/getCodeInfo/?" + op.data,true);
            xmlhttp.send(null);
        }
        else {
            xmlhttp.open("POST",op.url,true);
            xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
            xmlhttp.send(op.data);
        }
    }
    function getVImag(){
        document.getElementById("img_auth").src ='/home/getCodeInfo?r='+ Math.random();
       /* ajax({
            url : "/home/getCodeInfo?r="+ Math.random(),
            success : function(v){
                var t = v.split("_");
                document.getElementById("img_auth").src ='/home/getCodeInfo/?t='+t[0];
                document.getElementsByName("__VerifyValue")[0].value = t[1];
            }
        });*/
    }
    getVImag();
    String.prototype.trim = function() {
        return this.replace(/(^\s*)|(\s*$)/g, '');
    };
    function validateForm(form){
        var name = form.__name.value.trim(), password;
        form.__name.value = name;
        if(document.getElementById("password_txt").style.display == "none"){
            password = document.getElementById("textActive").Pwd;
        }
        else {
            password = form.password.value.trim();
        }
        var vcode = form.VerifyCode.value.trim();
        //form.password.value = password;
        if(!((/^[a-zA-Z0-9]+[a-zA-Z0-9_]*$/).test(name)) || name.length>12){
            alert('账号由1-12位英文字母、数字、下划线组成，且第一位不能是下划线');
            form.__name.focus();
            return false;
        }
        if(!((/^[^\u4e00-\u9fa5]{4,16}$/).test(password)) || !password){
            alert('密码由4-16位字符组成');
            //form.password.focus();
            return false;
        }
        if(!(/^\d{4,5}$/.test(vcode)) ){
            alert('验证码由4-5位数字组成！');
            form.VerifyCode.focus();
            return false;
        }
        return true;
    }

    form.onsubmit = function(){
        var param ="userPwd="+encodeURIComponent(form.password.value.trim());
        param +="&userAccount="+encodeURIComponent(form.__name.value.trim());
        param +="&verifyCode="+encodeURIComponent(form.VerifyCode.value.trim());
        ajax({
            url : "/home/doLogin",
            type : "POST",
            data : param,
//                {"userPwd":encodeURIComponent(form.password.value.trim()),
//                "userAccount":encodeURIComponent(form.__name.value),
//                "VerifyCode":encodeURIComponent(form.VerifyCode.value.trim())
//
//            },
            success : function(v){
                v=JSON.parse(v);
                if(!v.success){
                    var tx = v.msg;
                    if (tx.indexOf("账号或密码有误") != -1 || tx.indexOf("密码不正确") != -1 ) {
                        form.__name.value = '';
                        form.password.value = '';
                        alert(tx);
                    }else if(~tx.indexOf('upgrade.png')){
                        location.href = 'home/logout';
                        return false;
                    }else if(~tx.indexOf('账号已经被停用')){
                        alert(tx);
                        return false;
                    }
                    else if(~tx.indexOf('公司被停用了')){
                        alert(tx);
                        return false;
                    }
                    getVImag ();
                }
                else{
                    window.location.href ="/home/index";
                }

//
            }
        });
        return false;
    }
    setTimeout(function(){
        form.__name.focus();
    }, 0);
</script>

<script type="text/javascript">
    //<![CDATA[
    (function() {
        var _analytics_scr = document.createElement('script');
        _analytics_scr.type = 'text/javascript'; _analytics_scr.async = true; _analytics_scr.src = '/_Incapsula_Resource?SWJIYLWA=2977d8d74f63d7f8fedbea018b7a1d05&ns=1';
        var _analytics_elem = document.getElementsByTagName('script')[0]; _analytics_elem.parentNode.insertBefore(_analytics_scr, _analytics_elem);
    })();
    // ]]>
</script></body>

</html>
