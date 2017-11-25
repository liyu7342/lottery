
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
    <title>${user.userName} - A28</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="report" >
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="report" class="module">
                        <div class="hd"><h2 class="g-tit">報表</h2></div>
                        <div class="bd"><form>
                            <div class="g-tif"><h3 class="m">報表</h3></div>
                            <table class="g-t1 g-t2">
                                <colgroup><col width="8%"></col></colgroup>
                                <tbody nomovod>
                                <tr>
                                    <td>日期查詢</td>
                                    <th>
                                        <select name="draw_date">
                                            <#list datelist as obj>
                                                <option value="${obj.text}">${obj.text}</option>
                                            </#list>


                                        </select>
                                        ~
                                        <select name="draw_date2">

                                            <#list datelist as obj>
                                                <option value="${obj.text}">${obj.text}</option>
                                            </#list>
                                        </select>
                                        &nbsp;<button type="button" href="reportmonth.htm">本月報表</button>
                                </tr>
                                <tr>
                                    <td>類別</td>
                                    <th colspan="2">
                                        <label for="kind_user_report"><input type="radio" id="kind_user_report" name="kind" value="/report/user_report" checked="checked">總賬</label>&nbsp;
                                        <label for="kind_game_report"><input type="radio" id="kind_game_report" name="kind" value="/user/game_report" >分類賬</label>
                                    </th>
                                </tr>
                                </tbody></table>
                            <div class="g-tn">
                                <span class="g-tm" style="float:left;">&nbsp;&nbsp;注意：查詢期數跨度不能超過 <em id="report_date_limit">15</em> 期！</span>
                                <input type="submit" class="btn2" value="送出"/>
                            </div>
                        </form></div>
                        <div class="ft"></div>
                    </div>                </div>
            </div>
        </div>
    </div>
    <div id="ft">
        <div id="footer" class="module">
            <div class="hd rh"></div>
            <div class="bd rb">Copyright 2008-2017 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid63242a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 200000, //設置開關盤刷新頻率
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

