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
                            <a href="/odds/zhengmate?isDefault=false&handicap=${handicap}"  class="">正1特</a>&nbsp;|
                            <a href="/odds/zhengmate2?isDefault=false&handicap=${handicap}" class="">正2特</a>&nbsp;|
                            <a href="/odds/zhengmate3?isDefault=false&handicap=${handicap}" class="">正3特</a>&nbsp;|
                            <a href="/odds/zhengmate4?isDefault=false&handicap=${handicap}" class="">正4特</a>&nbsp;|
                            <a href="/odds/zhengmate5?isDefault=false&handicap=${handicap}" class="on ds d-gray" disabled="disabled">正5特</a>&nbsp;|
                            <a href="/odds/zhengmate6?isDefault=false&handicap=${handicap}" class="">正6特</a>
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
                                <tbody id="product_mark" pro="006">
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n1">01</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00601"
                                                                      value="${(entity.pro_00601)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n11">11</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00611"
                                                                      value="${(entity.pro_00611)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n21">21</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00621"
                                                                      value="${(entity.pro_00621)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n31">31</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00631"
                                                                      value="${(entity.pro_00631)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n41">41</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00641"
                                                                      value="${(entity.pro_00641)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n2">02</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00602"
                                                                      value="${(entity.pro_00602)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n12">12</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00612"
                                                                      value="${(entity.pro_00612)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n22">22</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00622"
                                                                      value="${(entity.pro_00622)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n32">32</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00632"
                                                                      value="${(entity.pro_00632)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n42">42</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00642"
                                                                      value="${(entity.pro_00642)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n3">03</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00603"
                                                                      value="${(entity.pro_00603)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n13">13</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00613"
                                                                      value="${(entity.pro_00613)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n23">23</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00623"
                                                                      value="${(entity.pro_00623)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n33">33</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00633"
                                                                      value="${(entity.pro_00633)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n43">43</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00643"
                                                                      value="${(entity.pro_00643)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n4">04</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00604"
                                                                      value="${(entity.pro_00604)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n14">14</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00614"
                                                                      value="${(entity.pro_00614)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n24">24</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00624"
                                                                      value="${(entity.pro_00624)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n34">34</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00634"
                                                                      value="${(entity.pro_00634)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n44">44</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00644"
                                                                      value="${(entity.pro_00644)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n5">05</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00605"
                                                                      value="${(entity.pro_00605)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n15">15</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00615"
                                                                      value="${(entity.pro_00615)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n25">25</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00625"
                                                                      value="${(entity.pro_00625)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n35">35</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00635"
                                                                      value="${(entity.pro_00635)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n45">45</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00645"
                                                                      value="${(entity.pro_00645)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n6">06</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00606"
                                                                      value="${(entity.pro_00606)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n16">16</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00616"
                                                                      value="${(entity.pro_00616)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n26">26</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00626"
                                                                      value="${(entity.pro_00626)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n36">36</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00636"
                                                                      value="${(entity.pro_00636)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n46">46</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00646"
                                                                      value="${(entity.pro_00646)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n7">07</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00607"
                                                                      value="${(entity.pro_00607)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n17">17</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00617"
                                                                      value="${(entity.pro_00617)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n27">27</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00627"
                                                                      value="${(entity.pro_00627)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n37">37</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00637"
                                                                      value="${(entity.pro_00637)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n47">47</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00647"
                                                                      value="${(entity.pro_00647)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n8">08</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00608"
                                                                      value="${(entity.pro_00608)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n18">18</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00618"
                                                                      value="${(entity.pro_00618)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n28">28</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00628"
                                                                      value="${(entity.pro_00628)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n38">38</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00638"
                                                                      value="${(entity.pro_00638)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n48">48</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00648"
                                                                      value="${(entity.pro_00648)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n9">09</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00609"
                                                                      value="${(entity.pro_00609)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n19">19</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00619"
                                                                      value="${(entity.pro_00619)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n29">29</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00629"
                                                                      value="${(entity.pro_00629)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n39">39</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00639"
                                                                      value="${(entity.pro_00639)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n49">49</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00649"
                                                                      value="${(entity.pro_00649)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n10">10</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00610"
                                                                      value="${(entity.pro_00610)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n20">20</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00620"
                                                                      value="${(entity.pro_00620)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n30">30</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00630"
                                                                      value="${(entity.pro_00630)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n40">40</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00640"
                                                                      value="${(entity.pro_00640)!''}"/></td>
                                    <td colspan="3"></td>
                                </tr>
                                </tbody>
                            </table>
                            <table class="g-t1 mt">
                                <thead>
                                <tr>
                                    <td class="borderRightNone">類型</td>
                                    <td class="borderLeftNone ">賠率</td>
                                    <td class="borderRightNone">類型</td>
                                    <td class="borderLeftNone ">賠率</td>
                                    <td class="borderRightNone">類型</td>
                                    <td class="borderLeftNone ">賠率</td>
                                </tr>
                                </thead>
                                <tbody>
                                <tr pro="025">
                                    <td class="borderRightNone"><strong>單</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02501"
                                                                      value="${(entity.pro_02501)!''}"/></td>
                                    <td class="borderRightNone"><strong>大</strong></td>

                                    <td class="borderLeftNone"><input type="text"  name="02503"
                                                                      value="${(entity.pro_02503)!''}"/></td>
                                    <td class="borderRightNone"><strong>合單</strong></td>

                                    <td class="borderLeftNone"><input type="text"  name="02505"
                                                                      value="${(entity.pro_02505)!''}"/></td>
                                </tr>
                                <tr pro="025">
                                    <td class="borderRightNone"><strong>雙</strong></td>

                                    <td class="borderLeftNone"><input type="text"  name="02502"
                                                                      value="${(entity.pro_02502)!''}"/></td>
                                    <td class="borderRightNone"><strong>小</strong></td>

                                    <td class="borderLeftNone"><input type="text"  name="02504"
                                                                      value="${(entity.pro_02504)!''}"/></td>
                                    <td class="borderRightNone"><strong>合雙</strong></td>

                                    <td class="borderLeftNone"><input type="text"  name="02506"
                                                                      value="${(entity.pro_02506)!''}"/></td>
                                </tr>
                                <tr pro="032">
                                    <td class="borderRightNone"><strong class="red">紅色</strong></td>

                                    <td class="borderLeftNone"><input type="text"  name="03201"
                                                                      value="${(entity.pro_03201)!''}"/></td>
                                    <td class="borderRightNone"><strong class="blue">藍色</strong></td>

                                    <td class="borderLeftNone"><input type="text"  name="03202"
                                                                      value="${(entity.pro_03202)!''}"/></td>
                                    <td class="borderRightNone"><strong class="green">綠色</strong></td>

                                    <td class="borderLeftNone"><input type="text"  name="03203"
                                                                      value="${(entity.pro_03203)!''}"/></td>
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
                        <li><a curl='0' href='/odds/temaa?handicap=${handicap}'>特碼</a><cite></cite></li>
                        <li><a curl='0' href='/odds/zhengma?handicap=${handicap}'>正碼</a><cite></cite></li>
                        <li><a curl='5' href='/odds/zhengmate?handicap=${handicap}'>正馬特</a><cite></cite></li>
                        <li><a curl='0' href='/odds/zheng16?handicap=${handicap}'>正1-6</a><cite></cite></li>
                        <li><a curl='0' href='/odds/erquanzh?handicap=${handicap}'>連碼</a><cite></cite></li>
                        <li><a curl='0' href='/odds/guoguan?handicap=${handicap}'>過關</a><cite></cite></li>
                        <li><a curl='0' href='/odds/shengxiao?handicap=${handicap}'>生肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/weishu?handicap=${handicap}'>尾數</a><cite></cite></li>
                        <li><a curl='0' href='/odds/banbo?handicap=${handicap}'>半波</a><cite></cite></li>
                        <li><a curl='0' href='/odds/liuxiao?handicap=${handicap}'>六肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/texiao?handicap=${handicap}'>特肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/shengxiaolian?handicap=${handicap}'>生肖連</a><cite></cite></li>
                        <li><a curl='0' href='/odds/weishulian?handicap=${handicap}'>尾數連</a><cite></cite></li>
                        <li><a curl='0' href='/odds/buzhong?handicap=${handicap}'>不中</a><cite></cite></li>
                    </ul>
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

