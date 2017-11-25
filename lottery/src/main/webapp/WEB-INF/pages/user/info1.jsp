
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
<body class="userinfo" >
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="ausinfo" class="module">
                        <div class="hd g-tm"><h2 class="g-tit">
                            <a class="btn6 log" href="javascript:void(0)" >個人資訊</a>
                            <a class="btn6 red" href="history.htm">歷史登錄</a>
                        </h2></div>
                        <div class="bd g-new">
                            <div class="g-tif"><h3>基本資料</h3></div>
                            <table class="g-t1 g-t2 t1">
                                <colgroup><col width="10%"/><col width="23%"/><col width="10%"/><col width="23%"/><col width="10%"/></colgroup>
                                <tbody nomovod>
                                <tr>
                                    <td class="bg">名稱</td>
                                    <td>${currentUser.userName!''}</td>
                                    <td class="bg">賬號</td>
                                    <td>${currentUser.account!''}</td>
                                    <td class="bg">補貨設定</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td class="bg">總信用額度</td>
                                    <td>${currentUser.credits!''}</td>
                                    <td class="bg" >自己及下級佔成數</td>
                                    <td >0%</td>
                                    <td class="bg" >盤口</td>
                                    <td> ${currentUser.handicap!''}</td>
                                </tr>
                                <tr>
                                    <td class="bg">補貨是否佔成</td>
                                    <td>是</td>
                                    <td class="bg">狀態</td>
                                    <td colspan="3" >${currentUser.status!''}</td>
                                </tr>
                                </tbody></table>
                            <div class="g-tif mt"><h3>詳細資料</h3></div>
                            <table class="g-t1 g-t2 t2">
                                <colgroup><col width="10%"/></colgroup>
                                <tbody nomovod><tr class="bg">
                                    <td></td><td>特碼A/特碼B</td><td>正碼</td><td>正碼特</td><td>連碼二</td><td>連碼三</td><td>過關</td><td>生肖</td><td>尾數</td>
                                </tr>
                                <tr>
                                    <td class="bg">單注最低</td>
                                    <td>${limitSets.gameType_A00.singlemin!''}</td>
                                    <td>${limitSets.gameType_01.singlemin!''}</td>
                                    <td>${limitSets.gameType_02.singlemin!''}</td>
                                    <td>${limitSets.gameType_03.singlemin!''}</td>
                                    <td>${limitSets.gameType_04.singlemin!''}</td>
                                    <td>${limitSets.gameType_05.singlemin!''}</td>
                                    <td>${limitSets.gameType_06.singlemin!''}</td>
                                    <td>${limitSets.gameType_07.singlemin!''}</td>

                                </tr>
                                <tr>
                                    <td class="bg">單注最高</td>
                                    <td>${limitSets.gameType_A00.singlemax!''}</td>
                                    <td>${limitSets.gameType_01.singlemax!''}</td>
                                    <td>${limitSets.gameType_02.singlemax!''}</td>
                                    <td>${limitSets.gameType_03.singlemax!''}</td>
                                    <td>${limitSets.gameType_04.singlemax!''}</td>
                                    <td>${limitSets.gameType_05.singlemax!''}</td>
                                    <td>${limitSets.gameType_06.singlemax!''}</td>
                                    <td>${limitSets.gameType_07.singlemax!''}</td>
                                </tr>
                                <tr>
                                    <td class="bg">單項最高</td>
                                    <td>${limitSets.gameType_A00.singlehighest!''}</td>
                                    <td>${limitSets.gameType_01.singlehighest!''}</td>
                                    <td>${limitSets.gameType_02.singlehighest!''}</td>
                                    <td>${limitSets.gameType_03.singlehighest!''}</td>
                                    <td>${limitSets.gameType_04.singlehighest!''}</td>
                                    <td>${limitSets.gameType_05.singlehighest!''}</td>
                                    <td>${limitSets.gameType_06.singlehighest!''}</td>
                                    <td>${limitSets.gameType_07.singlehighest!''}</td>
                                </tr>
                                <tr>
                                    <td class="bg">A盤退水</td>
                                    <td>${limitSets.gameType_A00.aRetreat!''}%/${limitSets.gameType_B00.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_01.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_02.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_03.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_04.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_05.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_06.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_07.aRetreat!''}%</td>
                                </tr>

                                <tr>
                                    <td class="bg">B盤退水</td>
                                    <td>${limitSets.gameType_A00.bRetreat!''}%/${limitSets.gameType_B00.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_01.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_02.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_03.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_04.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_05.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_06.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_07.bRetreat!''}%</td>
                                </tr>
                                <tr>
                                    <td class="bg">C盤退水</td>
                                    <td>${limitSets.gameType_A00.cRetreat!''}%/${limitSets.gameType_B00.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_01.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_02.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_03.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_04.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_05.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_06.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_07.cRetreat!''}%</td>
                                </tr>

                                <tr>
                                    <td colspan="9" class="bg3"> </td>
                                </tr>
                                <tr class="bg">
                                    <td/><td>半波</td><td>六肖</td><td>兩面</td><td>色波</td><td>特肖</td><td>生肖連</td><td>尾數連</td><td>不中</td>
                                </tr>
                                <tr>
                                    <td class="bg">單注最低</td>
                                    <td>${limitSets.gameType_08.singlemin!''}</td>
                                    <td>${limitSets.gameType_09.singlemin!''}</td>
                                    <td>${limitSets.gameType_10.singlemin!''}</td>
                                    <td>${limitSets.gameType_11.singlemin!''}</td>
                                    <td>${limitSets.gameType_12.singlemin!''}</td>
                                    <td>${limitSets.gameType_13.singlemin!''}</td>
                                    <td>${limitSets.gameType_14.singlemin!''}</td>
                                    <td>${limitSets.gameType_15.singlemin!''}</td>
                                </tr>
                                <tr>
                                    <td class="bg">單注最高</td>
                                    <td>${limitSets.gameType_08.singlemax!''}</td>
                                    <td>${limitSets.gameType_09.singlemax!''}</td>
                                    <td>${limitSets.gameType_10.singlemax!''}</td>
                                    <td>${limitSets.gameType_11.singlemax!''}</td>
                                    <td>${limitSets.gameType_12.singlemax!''}</td>
                                    <td>${limitSets.gameType_13.singlemax!''}</td>
                                    <td>${limitSets.gameType_14.singlemax!''}</td>
                                    <td>${limitSets.gameType_15.singlemax!''}</td>
                                </tr>
                                <tr>
                                    <td class="bg">單項最高</td>
                                    <td>${limitSets.gameType_08.singlehighest!''}</td>
                                    <td>${limitSets.gameType_09.singlehighest!''}</td>
                                    <td>${limitSets.gameType_10.singlehighest!''}</td>
                                    <td>${limitSets.gameType_11.singlehighest!''}</td>
                                    <td>${limitSets.gameType_12.singlehighest!''}</td>
                                    <td>${limitSets.gameType_13.singlehighest!''}</td>
                                    <td>${limitSets.gameType_14.singlehighest!''}</td>
                                    <td>${limitSets.gameType_15.singlehighest!''}</td>
                                </tr>
                                <tr>
                                    <td class="bg">A盤退水</td>
                                    <td>${limitSets.gameType_08.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_09.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_10.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_11.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_12.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_13.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_14.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_15.aRetreat!''}%</td>
                                </tr>
                                <tr>
                                    <td class="bg">B盤退水</td>
                                    <td>${limitSets.gameType_08.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_09.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_10.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_11.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_12.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_13.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_14.bRetreat!''}%</td>
                                    <td>${limitSets.gameType_15.bRetreat!''}%</td>
                                </tr>
                                <tr>
                                    <td class="bg">C盤退水</td>
                                    <td>${limitSets.gameType_08.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_09.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_10.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_11.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_12.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_13.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_14.cRetreat!''}%</td>
                                    <td>${limitSets.gameType_15.cRetreat!''}%</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
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

