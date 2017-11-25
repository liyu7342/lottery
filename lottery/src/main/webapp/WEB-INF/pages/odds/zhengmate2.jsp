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
    <title>${user.userName} - A28</title>
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
                            <a href="/odds/zhengmate2?isDefault=false&handicap=${handicap}" class="on ds d-gray" disabled="disabled">正2特</a>&nbsp;|
                            <a href="/odds/zhengmate3?isDefault=false&handicap=${handicap}" class="">正3特</a>&nbsp;|
                            <a href="/odds/zhengmate4?isDefault=false&handicap=${handicap}" class="">正4特</a>&nbsp;|
                            <a href="/odds/zhengmate5?isDefault=false&handicap=${handicap}" class="">正5特</a>&nbsp;|
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
                                <tbody id="product_mark" pro="003">
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n1">01</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00301"
                                                                      value="${(entity.pro_00301)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n11">11</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00311"
                                                                      value="${(entity.pro_00311)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n21">21</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00321"
                                                                      value="${(entity.pro_00321)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n31">31</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00331"
                                                                      value="${(entity.pro_00331)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n41">41</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00341"
                                                                      value="${(entity.pro_00341)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n2">02</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00302"
                                                                      value="${(entity.pro_00302)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n12">12</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00312"
                                                                      value="${(entity.pro_00312)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n22">22</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00322"
                                                                      value="${(entity.pro_00322)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n32">32</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00332"
                                                                      value="${(entity.pro_00332)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n42">42</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00342"
                                                                      value="${(entity.pro_00342)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n3">03</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00303"
                                                                      value="${(entity.pro_00303)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n13">13</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00313"
                                                                      value="${(entity.pro_00313)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n23">23</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00323"
                                                                      value="${(entity.pro_00323)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n33">33</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00333"
                                                                      value="${(entity.pro_00333)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n43">43</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00343"
                                                                      value="${(entity.pro_00343)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n4">04</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00304"
                                                                      value="${(entity.pro_00304)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n14">14</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00314"
                                                                      value="${(entity.pro_00314)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n24">24</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00324"
                                                                      value="${(entity.pro_00324)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n34">34</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00334"
                                                                      value="${(entity.pro_00334)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n44">44</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00344"
                                                                      value="${(entity.pro_00344)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n5">05</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00305"
                                                                      value="${(entity.pro_00305)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n15">15</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00315"
                                                                      value="${(entity.pro_00315)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n25">25</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00325"
                                                                      value="${(entity.pro_00325)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n35">35</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00335"
                                                                      value="${(entity.pro_00335)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n45">45</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00345"
                                                                      value="${(entity.pro_00345)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n6">06</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00306"
                                                                      value="${(entity.pro_00306)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n16">16</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00316"
                                                                      value="${(entity.pro_00316)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n26">26</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00326"
                                                                      value="${(entity.pro_00326)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n36">36</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00336"
                                                                      value="${(entity.pro_00336)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n46">46</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00346"
                                                                      value="${(entity.pro_00346)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n7">07</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00307"
                                                                      value="${(entity.pro_00307)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n17">17</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00317"
                                                                      value="${(entity.pro_00317)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n27">27</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00327"
                                                                      value="${(entity.pro_00327)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n37">37</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00337"
                                                                      value="${(entity.pro_00337)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n47">47</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00347"
                                                                      value="${(entity.pro_00347)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n8">08</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00308"
                                                                      value="${(entity.pro_00308)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n18">18</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00318"
                                                                      value="${(entity.pro_00318)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n28">28</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00328"
                                                                      value="${(entity.pro_00328)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n38">38</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00338"
                                                                      value="${(entity.pro_00338)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n48">48</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00348"
                                                                      value="${(entity.pro_00348)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n9">09</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00309"
                                                                      value="${(entity.pro_00309)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n19">19</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00319"
                                                                      value="${(entity.pro_00319)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n29">29</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00329"
                                                                      value="${(entity.pro_00329)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n39">39</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00339"
                                                                      value="${(entity.pro_00339)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n49">49</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00349"
                                                                      value="${(entity.pro_00349)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n10">10</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00310"
                                                                      value="${(entity.pro_00310)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n20">20</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00320"
                                                                      value="${(entity.pro_00320)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n30">30</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00330"
                                                                      value="${(entity.pro_00330)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n40">40</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00340"
                                                                      value="${(entity.pro_00340)!''}"/></td>
                                    <td colspan="3"></td>
                                </tr>
                                </tbody>
                            </table>
                            <table class="g-t1 mt">
                                <thead>
                                <tr>
                                    <td class="borderRightNone">類型</td>
                                    <td class="borderLeftNone borderRightNone">賠率</td>
                                    <td class="borderRightNone">類型</td>
                                    <td class="borderLeftNone borderRightNone">賠率</td>
                                    <td class="borderRightNone">類型</td>
                                    <td class="borderLeftNone borderRightNone">賠率</td>
                                </tr>
                                </thead>
                                <tbody>
                                <tr pro="022">
                                    <td class="borderRightNone"><strong>單</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02201"
                                                                      value="${(entity.pro_02201)!''}"/></td>
                                    <td class="borderRightNone"><strong>大</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02203"
                                                                      value="${(entity.pro_02203)!''}"/></td>
                                    <td class="borderRightNone"><strong>合單</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02205"
                                                                      value="${(entity.pro_02205)!''}"/></td>
                                </tr>
                                <tr pro="022">
                                    <td class="borderRightNone"><strong>雙</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02202"
                                                                      value="${(entity.pro_02202)!''}"/></td>
                                    <td class="borderRightNone"><strong>小</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02204"
                                                                      value="${(entity.pro_02204)!''}"/></td>
                                    <td class="borderRightNone"><strong>合雙</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02206"
                                                                      value="${(entity.pro_02206)!''}"/></td>
                                </tr>
                                <tr pro="029">
                                    <td class="borderRightNone"><strong class="red">紅色</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02901"
                                                                      value="${(entity.pro_02901)!''}"/></td>
                                    <td class="borderRightNone"><strong class="blue">藍色</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02902"
                                                                      value="${(entity.pro_02902)!''}"/></td>
                                    <td class="borderRightNone"><strong class="green">綠色</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02903"
                                                                      value="${(entity.pro_02903)!''}"/></td>
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
                        <li><a curl='0' href='/odds/temaa?handicap={handicap}'>特碼</a><cite></cite></li>
                        <li><a curl='0' href='/odds/zhengma?handicap={handicap}'>正碼</a><cite></cite></li>
                        <li><a curl='5' href='/odds/zhengmate?handicap={handicap}'>正馬特</a><cite></cite></li>
                        <li><a curl='0' href='/odds/zheng16?handicap={handicap}'>正1-6</a><cite></cite></li>
                        <li><a curl='0' href='/odds/erquanzh?handicap={handicap}'>連碼</a><cite></cite></li>
                        <li><a curl='0' href='/odds/guoguan?handicap={handicap}'>過關</a><cite></cite></li>
                        <li><a curl='0' href='/odds/shengxiao?handicap={handicap}'>生肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/weishu?handicap={handicap}'>尾數</a><cite></cite></li>
                        <li><a curl='0' href='/odds/banbo?handicap={handicap}'>半波</a><cite></cite></li>
                        <li><a curl='0' href='/odds/liuxiao?handicap={handicap}'>六肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/texiao?handicap={handicap}'>特肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/shengxiaolian?handicap={handicap}'>生肖連</a><cite></cite></li>
                        <li><a curl='0' href='/odds/weishulian?handicap={handicap}'>尾數連</a><cite></cite></li>
                        <li><a curl='0' href='/odds/buzhong?handicap={handicap}'>不中</a><cite></cite></li>
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

