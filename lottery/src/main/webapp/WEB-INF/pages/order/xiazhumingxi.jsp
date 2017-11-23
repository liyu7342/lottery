
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
    <title>aj022 - A28</title>
    <link rel="stylesheet" href="http://pm10.x.mmm33.us:80/theme/gray/css/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="http://pm10.x.mmm33.us:80/theme/gray/css/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="xiazhumingxi" >
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="xiazhumingxi" class="module">
                        <div class="hd g-tm">
                            <h2 class="g-tit">[${name}] 明細</h2>
                            <div class="fr">
                                ${page}
                            </div>
                        </div>
                        <div class="bd">
                            <table class="g-t1 g-t2">
                                <thead>
                                <tr>
                                    <td>注單號</td>
                                    <td>玩法</td>
                                    <td>大股東</td>
                                    <td>股東</td>
                                    <td>總代理</td>
                                    <td>代理</td>
                                    <td>會員</td>
                                    <td>下注時間</td>
                                    <td>下注金額</td>
                                    <td>賠率</td>
                                    <td>退水%</td>
                                    <td>盤口</td>
                                    <td>佔成收入</td>
                                    <td class="r">補貨</td>
                                    <td>注單狀態</td>
                                </tr>
                                </thead>
                                <tbody>
                                <#list details as detail>
                                <tr>
                                    <td>${detail.orderNo!''}</td>
                                    <td>${name}</td>
                                    <td>${detail.dagudongAccount!''}</td>
                                    <td>${detail.gudongAccount!''}</td>
                                    <td>${detail.zongdaiAccount!''}</td>
                                    <td>${detail.dailiAccount!''}</td>
                                    <td>${detail.memberAccount!''}</td>
                                    <td>21:19:31</td>
                                    <td real=8.00000>${detail.amount!'0'}</td>
                                    <td class='red'>${detail.odds!''}</td>
                                    <td>${detail.retreat!''}</td>
                                    <td>B(特A)</td>
                                    <td real=3.2>
                                        3
                                    </td>
                                    <td>X</td>
                                    <td>正常</td>
                                </tr>
                                </#list>

                                <tr>
                                    <td colspan='8'>小計</td>
                                    <td real=283>283</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td real=63.7>63</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td colspan='8'>總計</td>
                                    <td real=6682.00000>6,682</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td real=722.80000>722</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                            <input type="hidden" id="nnnn" name="nnnn" value="20171123">
                            <input type="hidden" id="page_type" name="page_type" value="statis">
                            <input type="hidden" id="h_game" name="h_game" value="000">
                            <input type="hidden" id="h_number" name="h_number" value="22">
                        </div>
                        <div class="ft">
                        </div>
                    </div>                </div>
            </div>
        </div>
    </div>
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
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

