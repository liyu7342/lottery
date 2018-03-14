
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = 'pm10.x.mmm33.us';
        window.gms_fcorp = parseInt("0",10);
        try{if(domain){document.domain = domain;}}catch(x){domainOK = 0;}
    </script>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>${user.account!''} - A28</title>
    <link rel="stylesheet" href="../../resources/css/new/common.css" type="text/css">
    <link rel="stylesheet" href="../../resources/css/new/mike.chen.css?${JSVersion!''}" type="text/css">

</head>
<body class="odetail">
<div id="htmlcover" style="background-color:rgb(255, 255, 255);filter:alpha(opacity=0);opacity:0;position:absolute;top:0pt;left:0pt;z-index:5;display:block;width:100%;height:100%;"></div>
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="odetail" class="module">
                        <div class="hd" id="popupWindow">
                        <p>${orders.description!''} <em>+ ${orders.amount!'0'}</em></p>
                            <p class="pr">(組合數：<em>${size!'0'}</em>,總金額：<em>${orders.totalAmount!'0'}</em>)</p>
                            <p><span>賠　率</span> ${orders.odds}</p>
                        </div>
                        <div class="bd">
                            <div class="g-thd"><h3>組合清單</h3></div>
                            <table class="g-t1">

                                <tbody nomovod>
                                    ${bodyStr!''}
                                </tbody>
                            </table>
                        </div>
                        <div class="ft"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid6321379a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 20000, //設置開關盤刷新頻率
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/css/new/all.js?${JSVersion!''}" defer="defer"></script>
</body>
</html>

