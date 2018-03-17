
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
    <title>${title_userAccount!''} - A28</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="reportgongsi" >
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="freportgudong" class="module">
                        <div class="hd g-tm">
                            <ul>
                                <li><h2 class="g-tit">報表管理</h2></li>
                                <li class="ps">股東[<span class='greenrpt'>${user.userName!''}</span>]${user.account!''}
                                    -- 日期範圍：${draw_date!''} ~ ${draw_date2!''}
                                    -- 報表分類：分類賬 -- <a href="${purl!''}" >上一頁</a></li>
                            </ul>
                        </div>
                        <div class="bd">
                            <table class="g-t1 g-t2 tr nw">
                                <thead><tr>
                                    <td>序號</td>
                                    <td>玩法</td>
                                    <td>筆數</td>
                                    <td>下注金額</td>
                                    <td>會員盈虧</td>
                                    <td <#if userType==4> class="hid"</#if> ><em>佔成上繳</em></td>
                                    <td <#if userType==4> class="hid"</#if>><em><span class="hc">
                                    <#if userType==3> 代理商<#elseif userType==2>總代<#elseif userType==1>股東</#if>上繳</span></em></td>
                                    <td>本級佔成</td>

                                    <td>佣金差</td>
                                    <td class="r"><span class="hc"><#if userType==4> 代理商<#elseif userType==3>總代<#elseif userType==2>股東<#elseif userType==1>大股東</#if>盈虧</span></td>
                                    <td><em>上級佔成</em></td>
                                    <td class="hid"><em><#if userType==4> 總代<#elseif userType==3>股東<#elseif userType==2>大股東<#elseif userType==1>管理員</#if>金額</em></td>
                                    <td class="hid"><em><#if userType==4> 總代<#elseif userType==3>股東<#elseif userType==2>大股東<#elseif userType==1>管理員</#if>佣金</em></td>
                                    <td><em><span class="hc">上繳<#if userType==4> 總代<#elseif userType==3>股東<#elseif userType==2>大股東<#elseif userType==1>管理員</#if></span></em></td>
                                </tr>
                                </thead>
                                <tbody>
                                <#list gameReports as report>
                                    <tr>
                                        <td >${report_index+1}</td>
                                        <td >
                                            <#if ismuti>
                                                <a href="/report/reportwanfa?draw_date=${draw_date!''}&draw_date2=${draw_date2!''}&game_id=${report.gameType!''}&category_id=${report.categoryId!''}&number=${report.number!''}">${report.gameDesc!''}</a>
                                            <#else>
                                                <a href="/report/game_report?draw_date=${draw_date!''}&draw_date2=${draw_date2!''}&game_id=${report.gameType!''}&category_id=${report.categoryId!''}">${report.gameDesc!''}</a>
                                            </#if>
                                        </td>
                                        <td>${report.orderNum!'0'}</td>
                                        <td>${report.amount}</td>
                                        <td ><#if report.memberAmt gt 0>${report.memberAmt?floor} <#else>${report.memberAmt?ceiling}</#if> </td>
                                        <td <#if userType==4> class="hid"</#if>><#if report.zhanchengToMe gt 0>${report.zhanchengToMe?floor} <#else>${report.zhanchengToMe?ceiling}</#if> </td>
                                        <td <#if userType==4> class="hid bg"<#else>class="bg "  </#if>><#if report.totalToMe gt 0>${report.totalToMe?floor} <#else>${report.totalToMe?ceiling}</#if> </td>
                                        <td ><#if report.zhancheng gt 0>${report.zhancheng?floor} <#else>${report.zhancheng?ceiling}</#if> </td>
                                        <td ><#if report.retreatDiff gt 0>${report.retreatDiff?floor} <#else>${report.retreatDiff?ceiling}</#if> </td>
                                        <td class="bg"><#if report.totalAmt gt 0>${report.totalAmt?floor} <#else>${report.totalAmt?ceiling}</#if> </td>
                                        <td ><#if report.zhanchengToParent gt 0>${report.zhanchengToParent?floor} <#else>${report.zhanchengToParent?ceiling}</#if> </td>
                                        <td class="bg"><#if report.totalToParent gt 0>${report.totalToParent?floor} <#else>${report.totalToParent?ceiling}</#if> </td>

                                    </tr>
                                </#list>
                                </tbody>
                               <tfoot><tr>
                                <td></td>
                                   <td>總計</td>
                                   <td>${gameTotal.orderNum!'0'}</td>
                                   <td>${gameTotal.amount}</td>
                                   <td  ><#if gameTotal.memberAmt gt 0>${gameTotal.memberAmt?floor} <#else>${gameTotal.memberAmt?ceiling}</#if> </td>
                                   <td  <#if userType==4>class="hid" </#if>><#if gameTotal.zhanchengToMe gt 0>${gameTotal.zhanchengToMe?floor} <#else>${gameTotal.zhanchengToMe?ceiling}</#if> </td>
                                   <td <#if userType==4> class="hid bg"<#else>class="bg "  </#if>><#if gameTotal.totalToMe gt 0>${gameTotal.totalToMe?floor} <#else>${gameTotal.totalToMe?ceiling}</#if> </td>
                                   <td ><#if gameTotal.zhancheng gt 0>${gameTotal.zhancheng?floor} <#else>${gameTotal.zhancheng?ceiling}</#if> </td>
                                   <td ><#if gameTotal.retreatDiff gt 0>${gameTotal.retreatDiff?floor} <#else>${gameTotal.retreatDiff?ceiling}</#if> </td>
                                   <td class="bg"><#if gameTotal.totalAmt gt 0>${gameTotal.totalAmt?floor} <#else>${gameTotal.totalAmt?ceiling}</#if> </td>
                                   <td ><#if gameTotal.zhanchengToParent gt 0>${gameTotal.zhanchengToParent?floor} <#else>${gameTotal.zhanchengToParent?ceiling}</#if> </td>
                                   <td class="bg"><#if gameTotal.totalToParent gt 0>${gameTotal.totalToParent?floor} <#else>${gameTotal.totalToParent?ceiling}</#if> </td>
                                   </tr></tfoot>
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
        </div>    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid6321379a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 20000, //設置開關盤刷新頻率
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="http://pm10.x.mmm33.us:80/backend/js/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

