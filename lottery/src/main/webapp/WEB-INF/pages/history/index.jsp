<!DOCTYPE HTML>
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = '';
        try{if(domain){document.domain = domain;}}catch(x){domainOK = 0;}
    </script>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>f2211 - A28</title>
    <link rel="stylesheet" href="../../resources/css/new/common.css" type="text/css">
    <link rel="stylesheet" href="../../resources/css/new/mike.chen.css?ms2.4.7_31064" type="text/css">
</head>
<body class="hislist">
<div id="htmlcover" style="background-color:rgb(255, 255, 255);filter:alpha(opacity=0);opacity:0;position:absolute;top:0pt;left:0pt;z-index:5;display:block;width:100%;height:100%;"></div>
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="hislist" class="module">
                        <div class="hd g-tm"><h2 class="g-tit">會員歷史</h2>
                            <div class="fr">
                            </div>
                        </div>
                        <div class="bd">
                            <table class="g-t1">
                                <thead><tr>
                                    <td>日期</td>
                                    <td>注數</td>
                                    <td>下注金額</td>
                                    <td class="r">結果</td>
                                </tr></thead>
                                <tbody movod='movod'>
                                <#list histories as obj>
                                <tr>
                                    <td> <a href="../order/list?id=${obj.id}&drawdate=${obj.riqi!''}">${obj.riqi!''}</a>
                                    </td>
                                    <td>${(obj.orderNum)!''}</td>
                                    <td>${(obj.amount)!''}</td>
                                    <td>${(obj.winAmount)?ceiling}</td>
                                </tr>
                                </#list>
                                </tbody>
                                <tfoot>
                                <tr class="green">
                                    <td class="red">總計：</td>
                                    <td>0</td>
                                    <td>0</td>
                                    <td>0</td>
                                </tr>
                                </tfoot>
                            </table>
                        </div>
                        <div class="ft"></div>
                    </div>                </div>
            </div>
        </div>
    </div>
    <div id="ft">
        <div id="footer" class="module" style="display:none">
            <div class="hd"></div>
            <div class="bd">Copyright 2008-2017 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid63242f/user/login.html', //登錄路徑
        odds_refersh: 60000, //頁面的賠率刷新頻率,默認改為 60秒
        password_need: false, //是否開啟密碼登陸加密
        marqueeFresh: 60000, //設置跑馬燈頻率為60秒
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/css/new/all.js?ms2.4.7_31064" defer="defer"></script>
 </body>
</html>
