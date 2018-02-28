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
    <title>${user.account!''} - A28</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="reportmonth">
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="reportmonth" class="module">
                        <div class="hd g-tm">
                            <ul>
                                <li><h2 class="g-tit">報表管理</h2></li>
                                <li class="ps">本月報表 --
                                    ${currentMonth} （月） --
                                    <a href="/report/report">上一頁</a>
                                </li>
                            </ul>
                            <div class="fr">
                            </div>
                        </div>
                        <div class="bd">
                            <table class="g-t1 g-t2 tr">
                                <thead>
                                <tr>
                                    <td>日期</td>
                                    <td>筆數</td>
                                    <td>下注金額</td>
                                    <td>佔成收入</td>
                                    <td>會員盈虧</td>
                                    <td><#if></#if>股東獎金</td>
                                    <td>佣金</td>
                                    <td>佣金差</td>
                                    <td>股東盈虧</td>
                                </tr>
                                </thead>
                                <tbody>

                                <#list reportList as report>
                                    <tr>
                                        <td>
                                            <a href="/report/user_report?draw_date=${report.riqi}&draw_date2=${report.riqi}">${report.riqi}</a>
                                        </td>
                                        <td>${report.orderNum!'0'}</td>
                                        <td>${report.amount!'0'}</td>
                                        <td>${report.zhancheng?floor}</td>
                                        <td ><#if report.memberWinamt gt 0>${report.memberWinamt?floor} <#else>${report.memberWinamt?ceiling}</#if> </td>

                                        <td ><#if report.userWinamt gt 0>${report.userWinamt?floor} <#else>${report.userWinamt?ceiling}</#if> </td>

                                        <td ><#if report.retreat gt 0>${report.retreat?floor} <#else>${report.retreat?ceiling}</#if> </td>

                                        <td ><#if report.retreatDiff gt 0>${report.retreatDiff?floor} <#else>${report.retreatDiff?ceiling}</#if> </td>

                                        <td ><#if report.userTotalamt gt 0>${report.userTotalamt?floor} <#else>${report.userTotalamt?ceiling}</#if> </td>
                                    </tr>
                                </#list>
                                <tfoot>
                                <tr>
                                    <td>總計</td>
                                    <td>${reportTotal.orderNum!'0'}</td>
                                    <td>${reportTotal.amount!'0'}</td>
                                    <td>${reportTotal.zhancheng?floor}</td>
                                    <td ><#if reportTotal.memberWinamt gt 0>${reportTotal.memberWinamt?floor} <#else>${reportTotal.memberWinamt?ceiling}</#if> </td>

                                    <td ><#if reportTotal.userWinamt gt 0>${reportTotal.userWinamt?floor} <#else>${reportTotal.userWinamt?ceiling}</#if> </td>

                                    <td ><#if reportTotal.retreat gt 0>${reportTotal.retreat?floor} <#else>${reportTotal.retreat?ceiling}</#if> </td>

                                    <td ><#if reportTotal.retreatDiff gt 0>${reportTotal.retreatDiff?floor} <#else>${reportTotal.retreatDiff?ceiling}</#if> </td>

                                    <td ><#if reportTotal.userTotalamt gt 0>${reportTotal.userTotalamt?floor} <#else>${reportTotal.userTotalamt?ceiling}</#if> </td>
                                </tr>
                                </tfoot>
                                </tbody>
                            </table>
                        </div>
                        <div class="ft"></div>
                    </div>
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
        login_path: '/msdid6321379a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 20000, //設置開關盤刷新頻率
        log4js_type: 0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="http://pm10.x.mmm33.us:80/backend/js/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

