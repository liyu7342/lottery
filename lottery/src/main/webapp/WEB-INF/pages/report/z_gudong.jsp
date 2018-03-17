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
    <title>${title_userAccount!''} - A28</title>
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
                                    <td><em>佔成上繳</em></td>
                                    <td class="hid"><em>總代金額</em></td>
                                    <td class="hid"><em>總代佣金</em></td>
                                    <td><em><span class="hc">總代上繳</span></em></td>
                                    <td>本級佔成</td>
                                    <td class="hid">股東獎金</td>
                                    <td class="hid">佣金</td>
                                    <td>佣金差</td>
                                    <td class="r"><span class="hc">股東盈虧</span></td>
                                    <td><em>上級佔成</em></td>
                                    <td class="hid"><em>大股東金額</em></td>
                                    <td class="hid"><em>大股東佣金</em></td>
                                    <td><em><span class="hc">上繳大股東</span></em></td>
                                </tr>
                                </thead>
                                <tbody>
                                <#list reportDtos as reportDto>

                                <tr>
                                    <td>${(reportDto_index)+1!''}</td>
                                    <td>
                                        <#if reportDto.isBucang == 0>
                                            <a href="/report/z_zongdaili?draw_date=${draw_date!''}&draw_date2=${draw_date2!''}&type=1&p_level=5&__account=${reportDto.zongdaiAccount!''}&__name=${reportDto.zongdaiName!''}&id=${reportDto.zongdaiId!''}">[<span
                                                    class='greenrpt'>${reportDto.zongdaiName!''}</span>]${reportDto.zongdaiAccount!''}
                                            </a>
                                            <#else>
                                                <a href="/report/z_buhuo?draw_date=${draw_date!''}&draw_date2=${draw_date2!''}&type=0&p_level=5&__account=${reportDto.zongdaiAccount!''}&__name=${reportDto.zongdaiName!''}&id=${reportDto.zongdaiId!''}">[<span
                                                        class='greenrpt'>${reportDto.zongdaiName!''}</span>]${reportDto.zongdaiAccount!''}
                                                </a>
                                        </#if>
                                    </td>
                                    <td>${reportDto.orderNum!'0'}</td>
                                    <td>${reportDto.memberCount!'0'}</td>
                                    <td>${reportDto.amount!'0'}</td>
                                    <td><#if reportDto.memberAmt gt 0>${reportDto.memberAmt?floor} <#else>${reportDto.memberAmt?ceiling}</#if> </td>
                                    <td><#if reportDto.dailiToZongdai gt 0>${reportDto.dailiToZongdai?floor} <#else>${reportDto.dailiToZongdai?ceiling}</#if> </td>
                                    <td class="hid">0</td>
                                    <td class="hid">0</td>
                                    <td class="bg"><#if reportDto.zongdaiToGudong gt 0>${reportDto.zongdaiToGudong?floor} <#else>${reportDto.zongdaiToGudong?ceiling}</#if> </td>
                                    <td><#if reportDto.gudongAmt gt 0>${reportDto.gudongAmt?floor} <#else>${reportDto.gudongAmt?ceiling}</#if> </td>
                                    <td class="hid">17,870</td>
                                    <td class="hid">-2,188</td>
                                    <td><#if reportDto.gudongRetreatDiff gt 0>${reportDto.gudongRetreatDiff?floor} <#else>${reportDto.gudongRetreatDiff?ceiling}</#if> </td>
                                    <td class="bg"><#if reportDto.gudongTotalamt gt 0>${reportDto.gudongTotalamt?floor} <#else>${reportDto.gudongTotalamt?ceiling}</#if> </td>
                                    <td><#if reportDto.dagudongAmt gt 0>${reportDto.dagudongAmt?floor} <#else>${reportDto.dagudongAmt?ceiling}</#if> </td>
                                    <td class="hid">55,085</td>
                                    <td class="hid">-8,003</td>
                                    <td><#if reportDto.dagudongWinAmt gt 0>${reportDto.dagudongWinAmt?floor} <#else>${reportDto.dagudongWinAmt?ceiling}</#if> </td>


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
                                    <td><#if reportTotal.memberAmt gt 0>${reportTotal.memberAmt?floor} <#else>${reportTotal.memberAmt?ceiling}</#if> </td>
                                    <td><#if reportTotal.dailiToZongdai gt 0>${reportTotal.dailiToZongdai?floor} <#else>${reportTotal.dailiToZongdai?ceiling}</#if> </td>
                                    <td class="hid">0</td>
                                    <td class="hid">0</td>
                                    <td class="bg"><#if reportTotal.zongdaiToGudong gt 0>${reportTotal.zongdaiToGudong?floor} <#else>${reportTotal.zongdaiToGudong?ceiling}</#if> </td>
                                    <td><#if reportTotal.gudongAmt gt 0>${reportTotal.gudongAmt?floor} <#else>${reportTotal.gudongAmt?ceiling}</#if> </td>
                                    <td class="hid">17,870</td>
                                    <td class="hid">-2,188</td>
                                    <td><#if reportTotal.gudongRetreatDiff gt 0>${reportTotal.gudongRetreatDiff?floor} <#else>${reportTotal.gudongRetreatDiff?ceiling}</#if> </td>
                                    <td class="bg"><#if reportTotal.gudongTotalamt gt 0>${reportTotal.gudongTotalamt?floor} <#else>${reportTotal.gudongTotalamt?ceiling}</#if> </td>
                                    <td><#if reportTotal.dagudongAmt gt 0>${reportTotal.dagudongAmt?floor} <#else>${reportTotal.dagudongAmt?ceiling}</#if> </td>
                                    <td class="hid">55,085</td>
                                    <td class="hid">-8,003</td>
                                    <td><#if reportTotal.dagudongWinAmt gt 0>${reportTotal.dagudongWinAmt?floor} <#else>${reportTotal.dagudongWinAmt?ceiling}</#if> </td>

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

