<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = 'pm10.x.mmm33.us';
        window.gms_fcorp = parseInt("0", 10);
        try {
            if (domain) {
                document.domain = domain;
            }
        } catch (x) {
            domainOK = 0;
        }
    </script>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>${title_userAccount!''} - X6</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="huiyuan">
<div id="doc3" class="yui-t2 fixh">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <style>
                        html {
                            overflow-y: hidden;
                        }
                    </style>
                    <div id=""class="module">
                        <ul>
                            <li><h2 class="g-tit">六肖</h2>
                            </li>
                        </ul>
                        <form id="form1" method="POST" action="/odds/save">
                            <table class="g-t1">
                                <thead>
                                <tr>
                                    <td class="borderRightNone">六肖</td>
                                    <td class="borderLeftNone">中</td>
                                    <td class="borderRightNone">不中</td>
                                </tr>
                                </thead>
                                <tbody id="product_mark" pro="017">
                                <tr>
                                    <td>六肖</td>
                                    <td class="borderLeftNone"><input type="text" name="01701"
                                                                      value="${(entity.pro_01701)!''}"/></td>
                                    <td class="borderRightNone"><input type="text" name="01801"
                                                                       value="${(entity.pro_01801)!''}"/></td>
                                </tr>
                                                      </tbody>
                            </table>
                            <div class="g-tn">
                                <input type="hidden" value="${handicap}" name="oddSet" id="hiddenOddSet">
                                <input type="submit" class="btn2" value="保 存"/>
                                <input type="reset" class="btn2" value="重 設"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="yui-b">
            <div id="userli" curl="5" class="module g-li">
                <div class="hd g-tif">
                    <h3>賠率設置<span></span></h3>
                </div>
                <div class="bd">
                    <ul class="g-hover">
                        <li><a curl='0' href='/odds/temaa?isDefault=false&handicap=${handicap}'>特碼A</a><cite></cite></li>
                        <li><a curl='0' href='/odds/temab?isDefault=false&handicap=${handicap}'>特碼B</a><cite></cite></li>
                        <li><a curl='0' href='/odds/zhengma?isDefault=false&handicap=${handicap}'>正碼</a><cite></cite></li>
                        <li><a curl='0' href='/odds/zhengmate?isDefault=false&handicap=${handicap}'>正馬特</a><cite></cite></li>
                        <li><a curl='0' href='/odds/zheng16?isDefault=false&handicap=${handicap}'>正1-6</a><cite></cite></li>
                        <li><a curl='0' href='/odds/erquanzh?isDefault=false&handicap=${handicap}'>連碼</a><cite></cite></li>
                        <li><a curl='0' href='/odds/guoguan?isDefault=false&handicap=${handicap}'>過關</a><cite></cite></li>
                        <li><a curl='0' href='/odds/shengxiao?isDefault=false&handicap=${handicap}'>生肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/weishu?isDefault=false&handicap=${handicap}'>尾數</a><cite></cite></li>
                        <li><a curl='0' href='/odds/banbo?isDefault=false&handicap=${handicap}'>半波</a><cite></cite></li>
                        <li><a curl='5' href='/odds/liuxiao?isDefault=false&handicap=${handicap}'>六肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/texiao?isDefault=false&handicap=${handicap}'>特肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/shengxiaolian?isDefault=false&handicap=${handicap}'>生肖連</a><cite></cite></li>
                        <li><a curl='0' href='/odds/weishulian?isDefault=false&handicap=${handicap}'>尾數連</a><cite></cite></li>
                        <li><a curl='0' href='/odds/buzhong?isDefault=false&handicap=${handicap}'>不中</a><cite></cite></li>
                    </ul>
                </div>

            </div>
        </div>
    </div>
    <div id="ft">
        <div id="footer" class="module">
            <div class="hd rh"></div>
            <div class="bd rb">Copyright 2008-2018 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid63242a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 200000, //設置開關盤刷新頻率
        log4js_type: 0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

