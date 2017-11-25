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
    <title>${user.userName} - A28</title>
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
                        <div class="play_hd">
                            <a href="/odds/shengxiao?isDefault=false&handicap=${handicap}" class="" >生肖中</a>&nbsp;|
                            <a href="/odds/shengxiaobuzhong?isDefault=false&handicap=${handicap}" disabled="disabled"  class="on ds d-gray" >生肖不中</a>
                        </div>
                        <form id="form1" method="POST" action="/odds/save">
                            <table class="g-t1" id="main_tab">
                                <thead>
                                <tr>
                                    <td>生肖</td>
                                    <td>號碼</td>
                                    <td>賠率</td>
                                    <td>生肖</td>
                                    <td>號碼</td>
                                    <td>賠率</td>
                                </tr>
                                </thead>
                                <tbody pro="053">
                                <tr>
                                    <td class="bg">鼠</td>
                                    <td><strong>${shengxiao.鼠}</strong></td>
                                    
                                    <td><input name="05301" type="text"  value="${(entity.pro_05301)!''}"/>
                                    </td>
                                    <td class="bg">牛</td>
                                    <td><strong>${shengxiao.牛}</strong></td>
                                    <td><input name="05302" type="text" value="${(entity.pro_05302)!''}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="bg">虎</td>
                                    <td><strong>${shengxiao.虎}</strong></td>
                                    
                                    <td><input name="05303" type="text" value="${(entity.pro_05303)!''}" />
                                    </td>
                                    <td class="bg">兔</td>
                                    <td><strong>${shengxiao.兔}</strong></td>

                                    <td><input name="05304" type="text"  value="${(entity.pro_05304)!''}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="bg">龍</td>
                                    <td><strong>${shengxiao.龍}</strong></td>

                                    <td><input name="05305" type="text"  value="${(entity.pro_05305)!''}"/>
                                    </td>
                                    <td class="bg">蛇</td>
                                    <td><strong>${shengxiao.蛇}</strong></td>
                                    <td><input name="05306" type="text" value="${(entity.pro_05306)!''}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="bg">馬</td>
                                    <td><strong>${shengxiao.馬}</strong></td>

                                    <td><input name="05307" type="text" value="${(entity.pro_05307)!''}" />
                                    </td>
                                    <td class="bg">羊</td>
                                    <td><strong>${shengxiao.羊}</strong></td>

                                    <td><input name="05308" type="text"  value="${(entity.pro_05308)!''}"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="bg">猴</td>
                                    <td><strong>${shengxiao.猴}</strong></td>
                                    <td><input name="05309" type="text" value="${(entity.pro_05309)!''}" />
                                    </td>
                                    <td class="bg">雞</td>
                                    <td><strong>${shengxiao.雞}</strong></td>

                                    <td><input name="05310" type="text" value="${(entity.pro_05310)!''}" />
                                    </td>
                                </tr>
                                <tr>
                                    <td class="bg">狗</td>
                                    <td><strong>${shengxiao.狗}</strong></td>

                                    <td><input name="05311" type="text"  value="${(entity.pro_05311)!''}"/>
                                    </td>
                                    <td class="bg">豬</td>
                                    <td><strong>${shengxiao.豬}</strong></td>
                                    <td><input name="05312" type="text" value="${(entity.pro_05312)!''}" />
                                    </td>
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
                        <li><a curl='5' href='/odds/shengxiao?isDefault=false&handicap=${handicap}'>生肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/weishu?isDefault=false&handicap=${handicap}'>尾數</a><cite></cite></li>
                        <li><a curl='0' href='/odds/banbo?isDefault=false&handicap=${handicap}'>半波</a><cite></cite></li>
                        <li><a curl='0' href='/odds/liuxiao?isDefault=false&handicap=${handicap}'>六肖</a><cite></cite></li>
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

