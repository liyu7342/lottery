
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
    <title>${user.account} - X6</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="shangxiabuhuo" >
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="shangxiabuhuo" class="module">
                        <div class="hd g-tif"><h3 class="m"><span class="red">【</span>${gameNumDesc!''}<span class="red">】</span> 下級給上級補貨</h3></div>
                        <form name="frmAction" method="POST" action="/statis/save" id="frmBuhuo" motai='shangxiabuhuo'>
                            <div class="bd">
                                <table class="g-t1 g-t2" width="500">
                                    <tbody nomovod>
                                    <tr>
                                        <td>金額</td>
                                        <td width='90'>
                                            <input type="text" name="order_amt" valid="amount" value="${amt}" class="w" maxlength="9" value="0"/>
                                        </td>
                                        <td>盤口</td>
                                        <td width='90'>
                                            <select name="odds_set" id="odds_set">
                                                <#list oddsList as oddset>
                                                    <option value='${oddset.id}' disc='${oddset["retreat"]}' odds='${oddset["odds"]}' detailOdds=''>
                                                        ${oddset["name"]} 盤
                                                    </option>
                                                </#list>

                                               </select>
                                        </td>
                                        <td>賠率</td>
                                        <td class="red" width='140'><span id="odds_show">${oddsList[0].odds}</span></td>
                                        <td>退水(<font color=red>%</font>)</td>
                                        <td class="red" width='80'><span id="discount_show">${oddsList[0].retreat}</span></td>
                                    </tr>
                                    </tbody>
                                </table>
                                <input type="hidden" name='detailOdds' value=""/>
                                <input type="hidden" name="amt" value="${amt}">
                                <input type="hidden" name="game_id" value="${game_id}">
                                <input type="hidden" name="number" value="${number}">
                                <input type="hidden" name='odds' value="42.480" />
                                <input type="hidden" name="submit_time_msec" value="" />
                                <input type="hidden" name='op' value="create" />
                        </form>
                        <div class="ft">
                        </div>
                    </div>
                    <div id="loading" class="module">
                        <div class="hd"><iframe></iframe></div>
                        <div class="bd"><img title="數據加載中..." src="http://pm10.x.mmm33.us:80/theme/gray/media/loading.gif"/></div>
                        <div class="ft"></div>
                    </div>                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid63213790a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 20000, //設置開關盤刷新頻率
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

