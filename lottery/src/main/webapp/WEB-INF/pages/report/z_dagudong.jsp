<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = 'pm10.a.mmm55.us';
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
<body class="newreport">
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="reportgudong" class="module">
                        <div class="hd g-tm">
                            <ul>
                                <li><h2 class="g-tit">報表管理</h2></li>
                                <li class="ps">${banners!''}</li>
                            </ul>
                        </div>
                        <div class="bd">
                            <table class="g-t1 g-t2 tr nw">
                                <thead>
                                <tr>
                                    <td>序號</td>
                                    <td>總代</td>
                                    <td>筆數</td>
                                    <td>客戶數</td>
                                    <td>下注金額</td>
                                    <td>會員盈虧</td>
                                    <td class="hid"><em>總代金額</em></td>
                                    <td class="hid"><em>總代佣金</em></td>
                                    <td class="hid">股東獎金</td>
                                    <td class="hid">佣金</td>
                                    <td>占成上缴</td>
                                    <td>股東上缴</td>
                                    <td class="hid">股東獎金</td>
                                    <td class="hid">佣金</td>
                                    <td>本級占成</td>
                                    <td >佣金</td>
                                    <td class="r"><span class="hc">大股東盈亏</span></td>
                                    <td><em>管理员占成</em></td>
                                    <td class="hid"><em>大股東金額</em></td>
                                    <td class="hid"><em>大股東佣金</em></td>
                                    <td><em><span class="hc">分配管理员</span></em></td>
                                </tr>
                                </thead>
                                <tbody>
                                <#list reportDtos as reportDto>
                                    <tr>
                                        <td>${(reportDto_index)+1!''}</td>
                                        <td>
                                            <#if reportDto.isBucang == 0>
                                                <a href="/report/z_gudong?draw_date=${draw_date!''}&draw_date2=${draw_date2!''}&type=1&p_level=5&__account=${reportDto.gudongAccount!''}&__name=${reportDto.gudongName!''}&id=${reportDto.gudongId!''}">[<span
                                                        class='greenrpt'>${reportDto.gudongName!''}</span>]${reportDto.gudongAccount!''}
                                                </a>
                                                <#else>
                                                    <a href="/report/z_buhuo?draw_date=${draw_date!''}&draw_date2=${draw_date2!''}&type=0&p_level=5&__account=${reportDto.gudongAccount!''}&__name=${reportDto.gudongName!''}&id=${reportDto.gudongId!''}">[<span
                                                            class='greenrpt'>${reportDto.gudongName!''}</span>]${reportDto.gudongAccount!''}
                                                    </a>
                                            </#if>
                                        </td>
                                        <td>${reportDto.orderNum!'0'}</td>
                                        <td>${reportDto.memberCount!'0'}</td>
                                        <td>${reportDto.amount!'0'}</td>
                                        <td ><#if reportDto.memberAmt gt 0>${reportDto.memberAmt?floor} <#else>${reportDto.memberAmt?ceiling}</#if> </td>
                                        <td class="hid">0</td>

                                        <td class="hid">0</td>
                                        <td ><#if reportDto.gudongToParent gt 0>${reportDto.gudongToParent?floor} <#else>${reportDto.gudongToParent?ceiling}</#if> </td>
                                        <td class="bg"><#if reportDto.gudongToParentWinamt gt 0>${reportDto.gudongToParentWinamt?floor} <#else>${reportDto.gudongToParentWinamt?ceiling}</#if> </td>
                                        <td ><#if reportDto.dagudongAmt gt 0>${reportDto.dagudongAmt?floor} <#else>${reportDto.dagudongAmt?ceiling}</#if> </td>
                                        <td class="hid">17,870</td>
                                        <td class="hid">-2,188</td>
                                        <td ><#if reportDto.dagudongRetreatDiff gt 0>${reportDto.dagudongRetreatDiff?floor} <#else>${reportDto.dagudongRetreatDiff?ceiling}</#if> </td>
                                        <td ><#if reportDto.dagudongTotalamt gt 0>${reportDto.dagudongTotalamt?floor} <#else>${reportDto.dagudongTotalamt?ceiling}</#if> </td>
                                        <td ><#if reportDto.guanliyuanAmt gt 0>${reportDto.guanliyuanAmt?floor} <#else>${reportDto.guanliyuanAmt?ceiling}</#if> </td>
                                        <td class="hid">55,085</td>
                                        <td class="hid">-8,003</td>
                                        <td class="bg"><#if reportDto.guanliyuanWinAmt gt 0>${reportDto.guanliyuanWinAmt?floor} <#else>${reportDto.guanliyuanWinAmt?ceiling}</#if> </td>

                                    </tr>
                                </#list>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td></td>
                                    <td>總計</td>
                                    <td>${reportTotal.orderNum!'0'}</td>
                                    <td>${reportTotal.memberCount!'0'}</td>
                                    <td>${reportTotal.amount!'0'}</td>
                                    <td ><#if reportTotal.memberAmt gt 0>${reportTotal.memberAmt?floor} <#else>${reportTotal.memberAmt?ceiling}</#if> </td>
                                    <td class="hid">0</td>

                                    <td class="hid">0</td>
                                    <td ><#if reportTotal.gudongToParent gt 0>${reportTotal.gudongToParent?floor} <#else>${reportTotal.gudongToParent?ceiling}</#if> </td>
                                    <td class="bg"><#if reportTotal.gudongToParentWinamt gt 0>${reportTotal.gudongToParentWinamt?floor} <#else>${reportTotal.gudongToParentWinamt?ceiling}</#if> </td>
                                    <td ><#if reportTotal.dagudongAmt gt 0>${reportTotal.dagudongAmt?floor} <#else>${reportTotal.dagudongAmt?ceiling}</#if> </td>
                                    <td class="hid">17,870</td>
                                    <td class="hid">-2,188</td>
                                    <td ><#if reportTotal.dagudongRetreatDiff gt 0>${reportTotal.dagudongRetreatDiff?floor} <#else>${reportTotal.dagudongRetreatDiff?ceiling}</#if> </td>
                                    <td ><#if reportTotal.dagudongTotalamt gt 0>${reportTotal.dagudongTotalamt?floor} <#else>${reportTotal.dagudongTotalamt?ceiling}</#if> </td>
                                    <td ><#if reportTotal.guanliyuanAmt gt 0>${reportTotal.guanliyuanAmt?floor} <#else>${reportTotal.guanliyuanAmt?ceiling}</#if> </td>
                                    <td class="hid">55,085</td>
                                    <td class="hid">-8,003</td>
                                    <td class="bg"><#if reportTotal.guanliyuanWinAmt gt 0>${reportTotal.guanliyuanWinAmt?floor} <#else>${reportTotal.guanliyuanWinAmt?ceiling}</#if> </td>

                                </tr>
                                </tfoot>

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
            <div class="bd rb">Copyright 2008-2018 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid63213790a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 20000, //設置開關盤刷新頻率
        log4js_type: 0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

