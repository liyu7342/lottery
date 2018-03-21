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
    <title>${title_userAccount!''} - X6</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="reportmingxi">
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="reportmingxi" class="module">
                        <div class="hd g-tm">
                            <ul>
                                <li><h2 class="g-tit">報表管理</h2></li>
                                <li class="ps">
                                    ${banner!''}

                                </li>
                            </ul>
                            <div class="fr">
                                ${page}
                            </div>
                        </div>
                        <div class="bd">
                            <table class="g-t1 g-t2 tr">
                                <thead>
                                <tr>
                                    <td>注單編號</td>
                                    <td>盤口</td>
                                    <td>玩法</td>
                                    <td>下注時間</td>
                                    <td>賠率</td>
                                    <td>金額</td>
                                    <td>退水</td>
                                    <td class="r">結果</td>
                                    <td class="r">注單狀態</td>
                                </tr>
                                </thead>
                                <tbody>
                                <#list orderList as obj>
                                    <tr>
                                        <td class="bg">${(obj.orderNo)!''}</td>
                                        <td>${obj.oddset!''}</td>
                                        <td>
                                            <#if obj.isMuti><a target="popup"
                                                               href="/report/detail?order_id=${obj.orderNo}&draw_date=${obj.riqi!''}&sub=1"
                                                               fix="600|400|yes|yes" from_page="report"
                                                               game_id="${obj.gameType!''}">${(obj.description)!''}</a>
                                                <#else>
                                                ${(obj.description)!''}</#if>
                                        </td>
                                        <td>${obj.createdate?string("yyyy-MM-dd HH:mm:ss")}</td>
                                        <td>${(obj.odds)!''}</td>
                                        <td>${(obj.totalAmount)!''}</td>
                                        <td>${(obj.retreat)!''}%</td>
                                        <td
                                        <#if  obj.winAmount gt 0 >class="red"</#if>
                                        >
                                        <#if  obj.winAmount != 0 >
                                            ${(obj.winAmount+obj.retreatAmt)}
                                        <#else >
                                            0
                                        </#if>
                                        </td>
                                        <td>正常</td>
                                    </tr>
                                </#list>
                                </tbody>

                                <tfoot>
                                <tr>
                                    <td colspan="5">合計</td>
                                    <td>${totalAmount!'0'}</td>
                                    <td></td>
                                    <td><#if winAmount lt 0 >${winAmount?ceiling} <#else> ${winAmount?floor}</#if></td>
                                    <td></td>
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
    function page(pageid,pagesize,key){
        location.href="/report/reportmingxi?draw_id=${draw_id}&draw_date0=${draw_date0!''}&type=1&p_level=6&__name=${__name!''}&__account=${__account}&id=${id!''}&pageId="+pageid;
    }
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

