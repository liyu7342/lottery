
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = '';
        try{if(domain){document.domain = domain;}}catch(x){domainOK = 0;}
    </script>
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>A28</title>
    <style>
        body {font: 13px/1.231 Verdana,Arial,Helvetica,sans-serif;text-align:center;}
        body,div,h2,form,input{margin:0;padding:0;}
        #doc4{overflow:hidden;width:1003px;text-align:left;margin:auto}
        .hd div{background: url("log.jpg");}
        .g-lo{height:600px;overflow:auto;position:relative;}
        .hd h2 {font-size: 200%;left: 368px;position: absolute;top: 240px;font-weight:normal;}
        li {list-style:none;}
        .hd div {height:600px;left:0;position:absolute;top:0;width:1003px;z-index:1;}
        li label {left:370px;position:absolute;top:290px;}
        li input {background:#FFFFFF;border:1px solid #A8A7A7;height:16px;left:426px;padding:1px;position:absolute;top:289px;width:130px;z-index:2;}
        .ps label {top:328px;}
        .ps input {top:327px;}
        .vimg label {color:#488DB4;font-size:16px;font-weight:600;left:360px;top:364px;z-index:2;}
        .vimg input {top:363px;width: 55px;}
        .vimg img {left:489px;position:absolute;top:358px;z-index:2;}
        .btn {background: url("/theme/gray/css/ico.png") no-repeat scroll 99px 0 transparent;border: 0 none;cursor: pointer;height: 61px;left: 583px;position: absolute;top: 288px;width: 62px;}    input.btn {color:#B8DEF8;font-size:0;z-index:2;}
        div.btn {background: none repeat scroll 0 0 #DDDDDD;line-height: 61px;text-align: center;}
        .ft {color: #4E4E4E;left: 0;position: absolute;text-align: center;top:563px;width:100%;z-index:2;}
        .ft a {color:#4E4E4E;margin-left:10px;text-decoration:underline;}
    </style>
</head>
<body class="login">
<div id="doc4" class="yui-t7">
    <div id="bd">

        <div class="yui-g">
            <script type="text/javascript">
                if(self != top) top.location = window.location;
            </script>
            <div id="adminlogin" class="module g-lo">
                <div class="hd"><h2>系統登錄</h2><div style="background:url('../../resources/images/loginback_msdid_20150724230822.jpg')"></div></div>
                <div class="bd">
                    <form method="post" id="login_form" >
                        <div class="pt">
                            <input type="hidden" name="status" value="init"/>

                            <input type="hidden" name="checksum" value=""/>
                            <ul>
                                <li><label>賬　號：</label><input type="text" maxlength="12" name="__name" valid="account" value=""/></li>
                                <li class="ps"><label>密　碼：</label><input type="password" maxlength="16" name="password" valid="password" value=""/></li>
                                <li class="vimg">
                                    <label>驗證碼：</label>
                                    <input type="text" autocomplete="off" maxlength="12" name="VerifyCode" value=""/>

                                    <img src="/home/getCodeInfo?t="+math().  />
                                </li>
                            </ul>
                            <div class="btn">登 錄</div>
                            <input type="hidden" name="__VerifyValue" value=""/>
                            <input class="btn" type="submit" value="Login" value="登 錄" name="submit"/>
                        </div>
                    </form>

                </div>
                <div class="ft">推薦使用 <em class="ico ie"></em>IE 7 <em class="ico ff"></em>Firefox 3 瀏覽　　提示：如果使用「世界之窗」瀏覽器，請關閉「頁面元素黑名單過濾」功能，以避免影響頁面數據更新速度。<a href="../help.htm" target="_blank">常見問題</a></div>
            </div>
            <script type="text/javascript">
                window.setting = {
                    password_need: false //是否開啟密碼登陸加密
                };
                var form = document.getElementsByTagName('form')[0];
                //清空輸入框所有的值
                form.__name.value = '';
                form.password.value = '';
                //為了特殊用戶的要求，這裡增加了清除密碼的功能。
                var th;
                form.__name.onfocus = function(){
                    if(th){clearInterval(th); th = null;}
                    if(!form.password.value){
                        th = setInterval(function(){
                            form.password.value = '';
                        }, 99);}
                }
                form.__name.onblur = function(){
                    if(th){
                        clearInterval(th);
                        form.password.value = '';
                        th = null;
                    }
                }
                setTimeout(function(){form.__name.focus();}, 0);
                //刪除左右兩端的空格
                String.prototype.trim=function(){
                    return this.replace(/(^\s*)|(\s*$)/g, '');
                }
                function validateForm(form){
                    var name = form.__name.value.trim();
                    form.name.value = name;
                    var password = form.password.value.trim();
                    var vcode = form.VerifyCode.value.trim();
                    form.password.value = password;
                    if(!((/^[a-zA-Z0-9]+[a-zA-Z0-9_]*$/).test(name)) || name.length>12){
                        alert('賬號由1-12位英文字母、數字、下劃線組成，且第一位不能是下劃線');
                        form.__name.focus();
                        return false;
                    }
                    if(!((/^[^\u4e00-\u9fa5]{4,16}$/).test(password))){
                        alert('密碼由4-16位字符組成');
                        form.password.focus();
                        return false;
                    }
                    if(!(/^\d{4,5}$/.test(vcode)) ){
                        alert('驗證碼由4-5位數字組成！');
                        form.VerifyCode.focus();
                        return false;
                    }
                    return true;
                }
                form.onsubmit = function(){
//                    if(!validateForm(this)){
//                        return false;
//                    }
                    if(window.setting.password_need){
                        form.password.value = (hex_md5(hex_md5(form.password.value)+form.checksum.value)).substr(0,10);
                    }
                    var xmlhttp = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHTTP"),param = '';
                    param += 'userAccount='+encodeURIComponent(form.__name.value)+'&';
                    param += 'userPwd='+ encodeURIComponent(form.password.value.trim())+'&';
                    param += 'verifyCode='+encodeURIComponent(form.VerifyCode.value.trim());



                    xmlhttp.onreadystatechange = function(){
                        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
                            var result = xmlhttp.responseText;
                            result = JSON.parse(result);
                            var tx = result.msg;
                            if(!result.success){
                                if (tx.indexOf("賬號或密碼有誤") != -1 || tx.indexOf("密碼不正確") != -1 ) {
                                    form.__name.value = '';
                                    form.password.value = '';
                                    alert(tx.msg);
                                }else if(tx.indexOf('upgrade.png')){
                                    location.href = '/home/logout';
                                    return false;
                                }else if(tx.indexOf('停用')){
                                    alert( '抱歉，公司被停用了！');
                                    return false;
                                }
                                getVImag();
                            }
                            else{
                                window.location.href ="/home/index2";
                            }

                        }
                    }
                    xmlhttp.open("POST","/home/doLogin",true);
                    xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;");
                    xmlhttp.send(param);
                    return false;
                };
                function getVImag (){
                    document.images[0].src ='/home/getCodeInfo/?t='+Math.random();
                }
                getVImag();
            </script>
        </div>
    </div>
</div>
</body>
</html>