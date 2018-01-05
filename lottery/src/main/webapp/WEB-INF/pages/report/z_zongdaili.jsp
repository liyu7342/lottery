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
<body class="reportzongdaili">
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="reportzongdaili" class="module">
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
                                    <td>代理</td>
                                    <td>筆數</td>
                                    <td>客戶數</td>
                                    <td>下注金額</td>
                                    <td>會員盈虧</td>
                                    <td><em>佔成上繳</em></td>
                                    <td class="hid"><em>代理金額</em></td>
                                    <td class="hid"><em>代理佣金</em></td>
                                    <td><em><span class="hc">代理上繳</span></em></td>
                                    <td>本級佔成</td>
                                    <td class="hid">總代獎金</td>
                                    <td class="hid">佣金</td>
                                    <td>佣金差</td>
                                    <td class="r"><span class="hc">總代盈虧</span></td>
                                    <td><em>上級佔成</em></td>
                                    <td class="hid"><em>股東金額</em></td>
                                    <td class="hid"><em>股東佣金</em></td>
                                    <td><em><span class="hc">上繳股東</span></em></td>
                                </tr>
                                </thead>
                                <tbody>
                                <#list reportDtos as reportDto>
                                    <tr>
                                        <td>${(reportDto_index)+1!''}</td>
                                        <td>
                                            <#if reportDto.isBucang == 0>
                                                <a href="/report/z_daili?draw_date=${draw_date!''}&draw_date2=${draw_date2!''}&type=1&p_level=5&__account=${reportDto.account!''}&__name=${reportDto.userName!''}&id=${reportDto.id!''}">[<span
                                                        class='greenrpt'>${reportDto.userName!''}</span>]${reportDto.account!''}
                                                </a>

                                                <#else>
                                                    <a href="/report/z_buhuo?draw_date=${draw_date!''}&draw_date2=${draw_date2!''}&type=0&p_level=5&__account=${reportDto.account!''}&__name=${reportDto.userName!''}&id=${reportDto.id!''}">[<span
                                                            class='greenrpt'>${reportDto.userName!''}</span>]${reportDto.account!''}.補</a>

                                            </#if>
                                        </td>
                                        <td>${reportDto.orderNum!'0'}</td>
                                        <td>${reportDto.memberCount!'0'}</td>
                                        <td>${reportDto.amount!'0'}</td>
                                        <td>${reportDto.memberActualAmt!'0'}</td>
                                        <td>${reportDto.dailiToParentShareUp!'0'}</td>
                                        <td class="bg">${reportDto.dailiToParentWinamt!'0'}</td>
                                        <td>${reportDto.zhancheng!'0'}</td>
                                        <td>${reportDto.zongdaiRetreat!'0'}</td>
                                        <td class="bg">${reportDto.zongdaiWinamt!'0'}</td>
                                        <td>${reportDto.parentShareUp!'0'}</td>
                                        <td class="bg">${reportDto.parentWinamt!'0'}</td>

                                    </tr>
                                </#list>
                                <tfoot>
                                <tr>
                                    <td></td>
                                    <td>總計</td>
                                    <td>${reportTotal.orderNum!'0'}</td>
                                    <td>${reportTotal.memberCount!'0'}</td>
                                    <td>${reportTotal.amount!'0'}</td>
                                    <td>${reportTotal.memberActualAmt!'0'}</td>
                                    <td>${reportTotal.dailiToParentShareUp!'0'}</td>
                                    <td class="bg">${reportTotal.dailiToParentWinamt!'0'}</td>

                                    <td>${reportTotal.zhancheng!'0'}</td>
                                    <td>${reportTotal.zongdaiRetreat!'0'}</td>
                                    <td class="red" class="bg">${reportTotal.zongdaiWinamt!'0'}</td>
                                    <td>${reportTotal.parentShareUp!'0'}</td>

                                    <td class="bg">${reportTotal.parentWinamt!'0'}</td>
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
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

