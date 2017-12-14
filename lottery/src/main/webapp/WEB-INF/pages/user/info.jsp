<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = '';
        try{if(domain){document.domain = domain;}}catch(x){domainOK = 0;}
    </script>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>${user.account!''} - A28</title>
    <link rel="stylesheet" href="../../resources/css/new/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/new/mike.chen.css?ms2.4.7_3106" type="text/css">
</head>
<body class="frame_usermsg">
<div id="htmlcover" style="background-color:rgb(255, 255, 255);filter:alpha(opacity=0);opacity:0;position:absolute;top:0pt;left:0pt;z-index:5;display:block;width:100%;height:100%;"></div>
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="usermsg" class="module">
                        <div class="hd">
                            <!-- <h2 class="g-tit"><a class="btn6 log" href="javascript:void(0)" >會員資訊</a>
                          <a class="btn6 red" href="history.htm">歷史登錄</a></h2> -->
                            <div class="itab">
                                <a href="javascript:void(0)" class="on">會員資訊</a>
                                <a href="history.htm">歷史登錄</a>
                            </div>
                        </div>
                        <div class="bd">
                            <table class="g-t1">
                                <colgroup>
                                    <col width="16%" />
                                    <col width="16%" />
                                    <col width="16%" />
                                    <col width="16%" />
                                    <col width="16%" />
                                    <col width="16%" />
                                </colgroup>
                                <thead>
                                <td colspan="6">基本信息</td>
                                </thead>
                                <tbody movod='movod'>
                                <tr>
                                    <td class="bg"> 賬號</td>
                                    <td>${user.userName!''}</td>
                                    <td class="bg">會員名稱</td>
                                    <td>${user.account!''}</td>
                                    <td class="bg"> 信用額度</td>
                                    <td>${user.credits!''}</td>

                                </tr>
                                <tr>
                                    <td class="bg"> 賬號狀態</td>
                                    <td><#if user.status==1>启用 <#elseif user.status==0>停用 <#elseif user.status==2>停押 <#elseif user.status==3>禁止登陆 <#else></#if></td>

                                    <td class="bg">所屬盤口</td>
                                    <td> ${user.handicap!''}</td>
                                    <td class="bg"></td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                            <table class="g-t1 mt">
                                <thead>
                                <tr>
                                    <td width="11%"></td>
                                    <td width="12%">特碼A/特碼B</td>
                                    <td width="11%">正碼</td>
                                    <td width="11%">正碼特</td>
                                    <td width="11%">連碼二</td>
                                    <td width="11%">連碼三</td>
                                    <td width="11%">過關</td>
                                    <td width="11%">生肖</td>
                                    <td width="11%" class="r">尾數</td>
                                </tr>
                                </thead>
                                <tbody movod='movod'>
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
                                    <td class="bg">退水</td>
                                    <td>${limitSets.gameType_A00.aRetreat!''}%/${limitSets.gameType_B00.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_01.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_02.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_03.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_04.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_05.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_06.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_07.aRetreat!''}%</td>
                                </tr></tbody>
                            </table>
                            <table class="g-t1 mt">
                                <thead>
                                <tr>
                                    <td width="11%"></td>
                                    <td width="12%">半波</td>
                                    <td width="11%">六肖</td>
                                    <td width="11%">兩面</td>
                                    <td width="11%">色波</td>
                                    <td width="11%">特肖</td>
                                    <td width="11%">生肖連</td>
                                    <td width="11%">尾數連</td>
                                    <td width="11%" class="r">不中</td>
                                </tr>
                                </thead>
                                <tbody movod='movod'>
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
                                    <td class="bg">退水</td>
                                    <td>${limitSets.gameType_08.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_09.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_10.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_11.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_12.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_13.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_14.aRetreat!''}%</td>
                                    <td>${limitSets.gameType_15.aRetreat!''}%</td>
                                </tr></tbody>
                            </table>
                        </div>
                        <div class="ft">
                        </div>
                    </div>
                </div>
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
        login_path: '/login/login', //登錄路徑
        odds_refersh: 60000, //頁面的賠率刷新頻率,默認改為 60秒
        password_need: false, //是否開啟密碼登陸加密
        marqueeFresh: 60000, //設置跑馬燈頻率為60秒
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>
