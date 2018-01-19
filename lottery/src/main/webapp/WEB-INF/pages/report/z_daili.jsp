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
    <title>aj022 - A28</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="reportdaili">
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="reportdaili" class="module">
                        <div class="hd g-tm">
                            <ul>
                                <li><h2 class="g-tit">報表管理</h2></li>
                                <li class="ps">
                                    ${banners!''}
                                </li>
                            </ul>
                        </div>
                        <div class="bd">
                            <table class="g-t1 g-t2 tr nw">
                                <thead>
                                <tr>
                                    <td>序號</td>
                                    <td>會員</td>
                                    <td>筆數</td>
                                    <td>下注金額</td>
                                    <td>會員獎金</td>
                                    <td>會員佣金</td>
                                    <td>會員盈虧</td>
                                    <td><em>本級佔成</em></td>
                                    <td class="hid"><em>代理獎金</em></td>
                                    <td class="hid"><em>佣金</em></td>
                                    <td>佣金差</td>
                                    <td class="r"><em><span class="hc">代理盈虧</span></em></td>
                                    <td>上級佔成</td>
                                    <td class="hid">總代金額</td>
                                    <td class="hid">總代佣金</td>
                                    <td><span class="hc">上繳總代</span></td>
                                </tr>
                                </thead>
                                <tbody>
                                <#list reportDtos as reportDto>
                                    <tr>
                                        <td>${(reportDto_index)+1!''}</td>
                                        <td>
                                            <#if reportDto.isBucang == 0>
                                                <a href="/report/z_member?draw_date=${draw_date!''}&draw_date2=${draw_date2!''}&type=1&p_level=5&__account=${reportDto.memberAccount!''}&__name=${reportDto.memberName!''}&id=${reportDto.memberId!''}">[<span
                                                        class='greenrpt'>${reportDto.memberName!''}</span>]${reportDto.memberAccount!''}
                                                </a>
                                                <#else>
                                                    <a href="/report/z_buhuo?draw_date=${draw_date!''}&draw_date2=${draw_date2!''}&type=0&p_level=5&__account=${reportDto.memberAccount!''}&__name=${reportDto.memberName!''}&id=${reportDto.memberId!''}">[<span
                                                            class='greenrpt'>${reportDto.memberName!''}</span>]${reportDto.memberAccount!''}
                                                    </a>
                                            </#if>
                                        </td>
                                        <td>${reportDto.orderNum!'0'}</td>
                                        <td>${reportDto.amount!'0'}</td>
                                        <td><#if reportDto.memberWinamt gt 0>${reportDto.memberWinamt?floor} <#else>${reportDto.memberWinamt?ceiling}</#if> </td>
                                        <td>${reportDto.memberRetreat?floor}</td>
                                        <td><#if reportDto.memberAmt gt 0>${reportDto.memberAmt?floor} <#else>${reportDto.memberAmt?ceiling}</#if> </td>
                                        <td><#if reportDto.dailiAmt gt 0>${reportDto.dailiAmt?floor} <#else>${reportDto.dailiAmt?ceiling}</#if> </td>
                                        <td class="hid">-6,901</td>
                                        <td class="hid">4</td>
                                        <td><#if reportDto.dailiRetreatDiff gt 0>${reportDto.dailiRetreatDiff?floor} <#else>${reportDto.dailiRetreatDiff?ceiling}</#if> </td>
                                        <td class="bg"><#if reportDto.dailiTotalamt gt 0>${reportDto.dailiTotalamt?floor} <#else>${reportDto.dailiTotalamt?ceiling}</#if> </td>

                                        <td>${reportDto.toZongdaiAmt?floor}</td>
                                        <td class="hid">-16,102</td>
                                        <td class="hid">-197</td>
                                        <td class="bg"><#if reportDto.toZongdaiWinamt gt 0>${reportDto.toZongdaiWinamt?floor} <#else>${reportDto.toZongdaiWinamt?ceiling}</#if> </td>

                                    </tr>
                                </#list>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td></td>
                                    <td>總計</td>
                                    <td>${reportTotal.orderNum!'0'}</td>
                                    <td>${reportTotal.amount!'0'}</td>
                                    <td><#if reportTotal.memberWinamt gt 0>${reportTotal.memberWinamt?floor} <#else>${reportTotal.memberWinamt?ceiling}</#if> </td>
                                    <td>${reportTotal.memberRetreat?floor}</td>
                                    <td><#if reportTotal.memberAmt gt 0>${reportTotal.memberAmt?floor} <#else>${reportTotal.memberAmt?ceiling}</#if> </td>
                                    <td><#if reportTotal.dailiAmt gt 0>${reportTotal.dailiAmt?floor} <#else>${reportTotal.dailiAmt?ceiling}</#if> </td>
                                    <td class="hid">-6,901</td>
                                    <td class="hid">4</td>
                                    <td><#if reportTotal.dailiRetreatDiff gt 0>${reportTotal.dailiRetreatDiff?floor} <#else>${reportTotal.dailiRetreatDiff?ceiling}</#if> </td>
                                    <td class="bg red"><#if reportTotal.dailiTotalamt gt 0>${reportTotal.dailiTotalamt?floor} <#else>${reportTotal.dailiTotalamt?ceiling}</#if> </td>

                                    <td>${reportTotal.toZongdaiAmt?floor}</td>
                                    <td class="hid">-16,102</td>
                                    <td class="hid">-197</td>
                                    <td class="bg"><#if reportTotal.toZongdaiWinamt gt 0>${reportTotal.toZongdaiWinamt?floor} <#else>${reportTotal.toZongdaiWinamt?ceiling}</#if> </td>

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
            <div class="bd rb">Copyright 2008-2017 ©SixPlay Online Casino. All rights reserved.</div>
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

