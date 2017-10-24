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
    <title>f2213 - A28</title>
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
                            <li><h2 class="g-tit">特肖</h2>
                            </li>
                        </ul>
                        <form id="form1" method="POST" action="/odds/save">
                        <table class="g-t1" id="main_tab">
                            <thead>
                            <tr>
                                <td>特肖</td>
                                <td>號碼</td>
                                <td>賠率</td>
                                <td>特肖</td>
                                <td>號碼</td>
                                <td>賠率</td>
                            </tr>
                            </thead>
                            <tbody pro="034">
                            <tr>
                                <td class="bg">鼠</td>
                                <td><strong>${shengxiao.鼠}</strong></td>
                                <td><input name="03401" type="text" value="${(entity.pro_03401)!''}"/></td>
                                <td class="bg">牛</td>
                                <td><strong>${shengxiao.牛}</strong></td>
                                <td><input name="03402" type="text" value="${(entity.pro_03402)!''}"/></td>
                            </tr>
                            <tr>
                                <td class="bg">虎</td>
                                <td><strong>${shengxiao.虎}</strong></td>
                                <td><input name="03403" type="text" value="${(entity.pro_03403)!''}"/></td>
                                <td class="bg">兔</td>
                                <td><strong>${shengxiao.兔}</strong></td>
                                <td><input name="03404" type="text" value="${(entity.pro_03404)!''}"/></td>
                            </tr>
                            <tr>
                                <td class="bg">龍</td>
                                <td><strong>${shengxiao.龍}</strong></td>
                                <td><input name="03405" type="text" value="${(entity.pro_03405)!''}"/></td>
                                <td class="bg">蛇</td>
                                <td><strong>${shengxiao.蛇}</strong></td>
                                <td><input name="03406" type="text" value="${(entity.pro_03406)!''}"/></td>
                            </tr>
                            <tr>
                                <td class="bg">馬</td>
                                <td><strong>${shengxiao.馬}</strong></td>
                                <td><input name="03407" type="text" value="${(entity.pro_03407)!''}"/></td>
                                <td class="bg">羊</td>
                                <td><strong>${shengxiao.羊}</strong></td>
                                <td><input name="03408" type="text" value="${(entity.pro_03408)!''}"/></td>
                            </tr>
                            <tr>
                                <td class="bg">猴</td>
                                <td><strong>${shengxiao.猴}</strong></td>
                                <td><input name="03409" type="text" value="${(entity.pro_03409)!''}"/></td>
                                <td class="bg">雞</td>
                                <td><strong>${shengxiao.雞}</strong></td>

                                <td><input name="03410" type="text" value="${(entity.pro_03410)!''}"/></td>
                            </tr>
                            <tr>
                                <td class="bg">狗</td>
                                <td><strong>${shengxiao.狗}</strong></td>
                                <td><input name="03411" type="text" value="${(entity.pro_03411)!''}"/></td>
                                <td class="bg">豬</td>
                                <td><strong>${shengxiao.豬}</strong></td>
                                <td><input name="03412" type="text" value="${(entity.pro_03412)!''}"/></td>
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
                        <li><a curl='0' href='/odds/liuxiao?isDefault=false&handicap=${handicap}'>六肖</a><cite></cite></li>
                        <li><a curl='5' href='/odds/texiao?isDefault=false&handicap=${handicap}'>特肖</a><cite></cite></li>
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
            <div class="bd rb">Copyright 2008-2017 ©SixPlay Online Casino. All rights reserved.</div>
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

