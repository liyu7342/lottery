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
<body class="huiyuan">
<div id="doc3" class="yui-t2 fixh">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <style>
                        html {
                            overflow-y: hidden;
                        }
                    </style>
                    <div id=""class="module">
                        <div class="play_hd">
                            <a href="/odds/erquanzh?isDefault=false&handicap=${handicap}" >二全中</a>&nbsp;|
                            <a href="/odds/erzhongte?isDefault=false&handicap=${handicap}" >二中特</a>&nbsp;|
                            <a href="/odds/techuan?isDefault=false&handicap=${handicap}" class="">特串</a>&nbsp;|
                            <a href="/odds/sanquanzh?isDefault=false&handicap=${handicap}" class="">三全中</a>&nbsp;|
                            <a href="/odds/sanzher?isDefault=false&handicap=${handicap}"class="on ds d-gray" disabled="disabled">三中二</a>
                        </div>
                        <form id="form1" method="POST" action="/odds/save">
                            <table class="g-t1">
                                <thead>
                                <tr>
                                    <td class="borderRightNone">號碼</td>
                                    <td class="borderLeftNone">賠率</td>
                                    <td class="borderRightNone">號碼</td>
                                    <td class="borderLeftNone">賠率</td>
                                    <td class="borderRightNone">號碼</td>
                                    <td class="borderLeftNone">賠率</td>
                                    <td class="borderRightNone">號碼</td>
                                    <td class="borderLeftNone">賠率</td>
                                    <td class="borderRightNone">號碼</td>
                                    <td class="borderLeftNone">賠率</td>
                                </tr>
                                </thead>
                                <tbody id="product_mark" pro="012">
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n1">01</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01201" value="${entity.pro_01201!''}"/>/<input type="text" name="01201_1" value="${entity.pro_01201_1!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n11">11</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01211" value="${entity.pro_01211!''}"/>/<input type="text" name="01211_1" value="${entity.pro_01211_1!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n21">21</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01221" value="${entity.pro_01221!''}"/>/<input type="text" name="01221_1" value="${entity.pro_01221_1!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n31">31</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01231" value="${entity.pro_01231!''}"/>/<input type="text" name="01231_1" value="${entity.pro_01231_1!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n41">41</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01241" value="${entity.pro_01241!''}"/>/<input type="text" name="01241_1" value="${entity.pro_01241_1!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n2">02</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01202" value="${entity.pro_01202!''}"/>/<input type="text" name="01202_1" value="${entity.pro_01202_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n12">12</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01212" value="${entity.pro_01212!''}"/>/<input type="text" name="01212_1" value="${entity.pro_01212_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n22">22</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01222" value="${entity.pro_01222!''}"/>/<input type="text" name="01222_1" value="${entity.pro_01222_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n32">32</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01232" value="${entity.pro_01232!''}"/>/<input type="text" name="01232_1" value="${entity.pro_01232_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n42">42</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01242" value="${entity.pro_01242!''}"/>/<input type="text" name="01242_1" value="${entity.pro_01242_1!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n3">03</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01203" value="${entity.pro_01203!''}"/>/<input type="text" name="01203_1" value="${entity.pro_01203_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n13">13</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01213" value="${entity.pro_01213!''}"/>/<input type="text" name="01213_1" value="${entity.pro_01213_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n23">23</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01223" value="${entity.pro_01223!''}"/>/<input type="text" name="01223_1" value="${entity.pro_01223_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n33">33</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01233" value="${entity.pro_01233!''}"/>/<input type="text" name="01233_1" value="${entity.pro_01233_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n43">43</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01243" value="${entity.pro_01243!''}"/>/<input type="text" name="01243_1" value="${entity.pro_01243_1!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n4">04</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01204" value="${entity.pro_01204!''}"/>/<input type="text" name="01204_1" value="${entity.pro_01204_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n14">14</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01214" value="${entity.pro_01214!''}"/>/<input type="text" name="01214_1" value="${entity.pro_01214_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n24">24</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01224" value="${entity.pro_01224!''}"/>/<input type="text" name="01224_1" value="${entity.pro_01224_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n34">34</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01234" value="${entity.pro_01234!''}"/>/<input type="text" name="01234_1" value="${entity.pro_01234_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n44">44</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01244" value="${entity.pro_01244!''}"/>/<input type="text" name="01244_1" value="${entity.pro_01244_1!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n5">05</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01205" value="${entity.pro_01205!''}"/>/<input type="text" name="01205_1" value="${entity.pro_01205_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n15">15</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01215" value="${entity.pro_01215!''}"/>/<input type="text" name="01215_1" value="${entity.pro_01215_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n25">25</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01225" value="${entity.pro_01225!''}"/>/<input type="text" name="01225_1" value="${entity.pro_01225_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n35">35</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01235" value="${entity.pro_01235!''}"/>/<input type="text" name="01235_1" value="${entity.pro_01235_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n45">45</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01245" value="${entity.pro_01245!''}"/>/<input type="text" name="01245_1" value="${entity.pro_01245_1!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n6">06</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01206" value="${entity.pro_01206!''}"/>/<input type="text" name="01206_1" value="${entity.pro_01206_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n16">16</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01216" value="${entity.pro_01216!''}"/>/<input type="text" name="01216_1" value="${entity.pro_01216_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n26">26</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01226" value="${entity.pro_01226!''}"/>/<input type="text" name="01226_1" value="${entity.pro_01226_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n36">36</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01236" value="${entity.pro_01236!''}"/>/<input type="text" name="01236_1" value="${entity.pro_01236_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n46">46</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01246" value="${entity.pro_01246!''}"/>/<input type="text" name="01246_1" value="${entity.pro_01246_1!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n7">07</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01207" value="${entity.pro_01207!''}"/>/<input type="text" name="01207_1" value="${entity.pro_01207_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n17">17</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01217" value="${entity.pro_01217!''}"/>/<input type="text" name="01217_1" value="${entity.pro_01217_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n27">27</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01227" value="${entity.pro_01227!''}"/>/<input type="text" name="01227_1" value="${entity.pro_01227_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n37">37</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01237" value="${entity.pro_01237!''}"/>/<input type="text" name="01237_1" value="${entity.pro_01237_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n47">47</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01247" value="${entity.pro_01247!''}"/>/<input type="text" name="01247_1" value="${entity.pro_01247_1!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n8">08</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01208" value="${entity.pro_01208!''}"/>/<input type="text" name="01208_1" value="${entity.pro_01208_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n18">18</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01218" value="${entity.pro_01218!''}"/>/<input type="text" name="01218_1" value="${entity.pro_01218_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n28">28</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01228" value="${entity.pro_01228!''}"/>/<input type="text" name="01228_1" value="${entity.pro_01228_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n38">38</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01238" value="${entity.pro_01238!''}"/>/<input type="text" name="01238_1" value="${entity.pro_01238_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n48">48</em></td>
                                    <td class="borderLeftNone"><input type="text" name="01248" value="${entity.pro_01248!''}"/>/<input type="text" name="01248_1" value="${entity.pro_01248_1!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n9">09</em></td>

                                    <td class="borderLeftNone"><input type="text" name="01209" value="${entity.pro_01209!''}"/>/<input type="text" name="01209_1" value="${entity.pro_01209_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n19">19</em></td>

                                    <td class="borderLeftNone"><input type="text" name="01219" value="${entity.pro_01219!''}"/>/<input type="text" name="01219_1" value="${entity.pro_01219_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n29">29</em></td>

                                    <td class="borderLeftNone"><input type="text" name="01229" value="${entity.pro_01229!''}"/>/<input type="text" name="01229_1" value="${entity.pro_01229_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n39">39</em></td>

                                    <td class="borderLeftNone"><input type="text" name="01239" value="${entity.pro_01239!''}"/>/<input type="text" name="01239_1" value="${entity.pro_01239_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n49">49</em></td>

                                    <td class="borderLeftNone"><input type="text" name="01249" value="${entity.pro_01249!''}"/>/<input type="text" name="01249_1" value="${entity.pro_01249_1!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n10">10</em></td>

                                    <td class="borderLeftNone"><input type="text" name="01210" value="${entity.pro_01210!''}"/>/<input type="text" name="01210_1" value="${entity.pro_01210_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n20">20</em></td>

                                    <td class="borderLeftNone"><input type="text" name="01220" value="${entity.pro_01220!''}"/>/<input type="text" name="01220_1" value="${entity.pro_01220_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n30">30</em></td>

                                    <td class="borderLeftNone"><input type="text" name="01230" value="${entity.pro_01230!''}"/>/<input type="text" name="01230_1" value="${entity.pro_01230_1!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n40">40</em></td>

                                    <td class="borderLeftNone"><input type="text" name="01240" value="${entity.pro_01240!''}"/>/<input type="text" name="01240_1" value="${entity.pro_01240_1!''}"/></td>
                                    <td colspan="3"></td>
                                </tr>
                                </tbody>
                            </table>
                            <div class="g-tn">
                                <input type="hidden" value="${handicap}" name="oddSet" id="hiddenOddSet">
                                <input type="submit" class="btn2" value="保 存"/>
                                <input type="reset" class="btn2" value="重 設"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="yui-b">
            <div id="userli" curl="5" class="module g-li">
                <div class="hd g-tif">
                    <h3>賠率設置<span></span></h3>
                </div>
                <div class="bd">
                    <ul class="g-hover">
                        <li><a curl='0' href='/odds/temaa?isDefault=false&handicap=${handicap}'>特碼A</a><cite></cite></li>
                        <li><a curl='0' href='/odds/temab?isDefault=false&handicap=${handicap}'>特碼B</a><cite></cite></li>
                        <li><a curl='0' href='/odds/zhengma?isDefault=false&handicap=${handicap}'>正碼</a><cite></cite></li>
                        <li><a curl='0' href='/odds/zhengmate?isDefault=false&handicap=${handicap}'>正馬特</a><cite></cite></li>
                        <li><a curl='0' href='/odds/zheng16?isDefault=false&handicap=${handicap}'>正1-6</a><cite></cite></li>
                        <li><a curl='5' href='/odds/erquanzh?isDefault=false&handicap=${handicap}'>連碼</a><cite></cite></li>
                        <li><a curl='0' href='/odds/guoguan?isDefault=false&handicap=${handicap}'>過關</a><cite></cite></li>
                        <li><a curl='0' href='/odds/shengxiao?isDefault=false&handicap=${handicap}'>生肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/weishu?isDefault=false&handicap=${handicap}'>尾數</a><cite></cite></li>
                        <li><a curl='0' href='/odds/banbo?isDefault=false&handicap=${handicap}'>半波</a><cite></cite></li>
                        <li><a curl='0' href='/odds/liuxiao?isDefault=false&handicap=${handicap}'>六肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/texiao?isDefault=false&handicap=${handicap}'>特肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/shengxiaolian?isDefault=false&handicap=${handicap}'>生肖連</a><cite></cite></li>
                        <li><a curl='0' href='/odds/weishulian?isDefault=false&handicap=${handicap}'>尾數連</a><cite></cite></li>
                        <li><a curl='0' href='/odds/buzhong?isDefault=false&handicap=${handicap}'>不中</a><cite></cite></li>
                    </ul>
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
        login_path: '/msdid63242a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 200000, //設置開關盤刷新頻率
        log4js_type: 0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

