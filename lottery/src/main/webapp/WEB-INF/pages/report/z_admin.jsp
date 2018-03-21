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
    <title>${title_userAccount!''} - X6</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">



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
                                <a href="/report/report">上一頁</a>
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

                                    <td><em>代理金額</em></td>
                                    <td><em>代理獎金</em></td>
                                    <td><em>代理佣金</em></td>
                                    <td>代理佣金差</td>
                                    <td>代理盈虧</td>
                                    <td><em>代理上繳</em></td>
                                    <td><em>總代金額</em></td>
                                    <td><em>總代獎金</em></td>
                                    <td><em>總代佣金</em></td>
                                    <td><em>總代佣金差</em></td>
                                    <td><em>總代盈虧</em></td>
                                    <td><em><span class="hc">總代上繳</span></em></td>
                                    <td>股東金額</td>
                                    <td>股東獎金</td>
                                    <td>股東佣金</td>
                                    <td>股東佣金差</td>
                                    <td class="r"><span class="hc">股東盈虧</span></td>
                                    <td class="r"><span class="hc">股東上繳</span></td>
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
                                                <a href="/report/z_gudong?draw_date=${draw_date!''}&draw_date2=${draw_date2!''}&type=1&p_level=5&__account=${reportDto.account!''}&__name=${reportDto.userName!''}&id=${reportDto.id!''}">[<span
                                                        class='greenrpt'>${reportDto.userName!''}</span>]${reportDto.account!''}
                                                </a>
                                                <#else>
                                                    <a href="/report/z_buhuo?draw_date=${draw_date!''}&draw_date2=${draw_date2!''}&type=0&p_level=5&__account=${reportDto.account!''}&__name=${reportDto.userName!''}&id=${reportDto.id!''}">[<span
                                                            class='greenrpt'>${reportDto.userName!''}</span>]${reportDto.account!''}
                                                    </a>
                                            </#if>
                                        </td>
                                        <td>${reportDto.orderNum!'0'}</td>
                                        <td>${reportDto.memberCount!'0'}</td>
                                        <td>${reportDto.amount!'0'}</td>
                                        <td>${reportDto.memberActualAmt!'0'}</td>
                                        <td>${reportDto.zongdaiToParentShareUp!'0'}</td>
                                        <td class="hid">0</td>
                                        <td class="hid">0</td>
                                        <td class="bg">${reportDto.zongdaiToParentWinamt!'0'}</td>
                                        <td>${reportDto.zhancheng!'0'}</td>
                                        <td class="hid">17,870</td>
                                        <td class="hid">-2,188</td>
                                        <td>${reportDto.gudongRetreat!'0'}</td>
                                        <td class="bg">${reportDto.gudongWinamt!'0'}</td>
                                        <td>${reportDto.parentShareUp!'0'}</td>
                                        <td class="hid">55,085</td>
                                        <td class="hid">-8,003</td>
                                        <td class="bg">${reportDto.parentWinamt!'0'}</td>

                                    </tr>
                                </#list>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <td></td>
                                    <td>總計</td>
                                    <td>3,515</td>
                                    <td>64</td>
                                    <td>660,070</td>
                                    <td>-168,889</td>
                                    <td>307,812</td>
                                    <td class="hid">-76,342</td>
                                    <td class="hid">10,912</td>
                                    <td class="bg">-65,429</td>
                                    <td>71,227</td>
                                    <td class="hid">19,805</td>
                                    <td class="hid">-2,599</td>
                                    <td>0</td>
                                    <td class="red" class="bg">17,205</td>
                                    <td>236,585</td>
                                    <td class="hid">56,536</td>
                                    <td class="hid">-8,312</td>
                                    <td class="bg">48,223</td>
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

