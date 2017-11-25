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
                            <a href="/odds/zhengmate2?isDefault=false&handicap=${handicap}" class="">正2特</a>&nbsp;|
                            <a href="/odds/zhengmate3?isDefault=false&handicap=${handicap}" class="">正3特</a>&nbsp;|
                            <a href="/odds/zhengmate4?isDefault=false&handicap=${handicap}" class="on ds d-gray" disabled="disabled">正4特</a>&nbsp;|
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
                                <tbody id="product_mark" pro="005">
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n1">01</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00501"
                                                                      value="${(entity.pro_00501)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n11">11</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00511"
                                                                      value="${(entity.pro_00511)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n21">21</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00521"
                                                                      value="${(entity.pro_00521)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n31">31</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00531"
                                                                      value="${(entity.pro_00531)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n41">41</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00541"
                                                                      value="${(entity.pro_00541)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n2">02</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00502"
                                                                      value="${(entity.pro_00502)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n12">12</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00512"
                                                                      value="${(entity.pro_00512)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n22">22</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00522"
                                                                      value="${(entity.pro_00522)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n32">32</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00532"
                                                                      value="${(entity.pro_00532)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n42">42</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00542"
                                                                      value="${(entity.pro_00542)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n3">03</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00503"
                                                                      value="${(entity.pro_00503)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n13">13</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00513"
                                                                      value="${(entity.pro_00513)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n23">23</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00523"
                                                                      value="${(entity.pro_00523)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n33">33</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00533"
                                                                      value="${(entity.pro_00533)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n43">43</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00543"
                                                                      value="${(entity.pro_00543)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n4">04</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00504"
                                                                      value="${(entity.pro_00504)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n14">14</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00514"
                                                                      value="${(entity.pro_00514)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n24">24</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00524"
                                                                      value="${(entity.pro_00524)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n34">34</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00534"
                                                                      value="${(entity.pro_00534)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n44">44</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00544"
                                                                      value="${(entity.pro_00544)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n5">05</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00505"
                                                                      value="${(entity.pro_00505)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n15">15</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00515"
                                                                      value="${(entity.pro_00515)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n25">25</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00525"
                                                                      value="${(entity.pro_00525)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n35">35</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00535"
                                                                      value="${(entity.pro_00535)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n45">45</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00545"
                                                                      value="${(entity.pro_00545)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n6">06</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00506"
                                                                      value="${(entity.pro_00506)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n16">16</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00516"
                                                                      value="${(entity.pro_00516)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n26">26</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00526"
                                                                      value="${(entity.pro_00526)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n36">36</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00536"
                                                                      value="${(entity.pro_00536)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n46">46</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00546"
                                                                      value="${(entity.pro_00546)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n7">07</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00507"
                                                                      value="${(entity.pro_00507)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n17">17</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00517"
                                                                      value="${(entity.pro_00517)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n27">27</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00527"
                                                                      value="${(entity.pro_00527)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n37">37</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00537"
                                                                      value="${(entity.pro_00537)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n47">47</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00547"
                                                                      value="${(entity.pro_00547)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n8">08</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00508"
                                                                      value="${(entity.pro_00508)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n18">18</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00518"
                                                                      value="${(entity.pro_00518)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n28">28</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00528"
                                                                      value="${(entity.pro_00528)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n38">38</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00538"
                                                                      value="${(entity.pro_00538)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n48">48</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00548"
                                                                      value="${(entity.pro_00548)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n9">09</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00509"
                                                                      value="${(entity.pro_00509)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n19">19</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00519"
                                                                      value="${(entity.pro_00519)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n29">29</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00529"
                                                                      value="${(entity.pro_00529)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n39">39</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00539"
                                                                      value="${(entity.pro_00539)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n49">49</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00549"
                                                                      value="${(entity.pro_00549)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n10">10</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00510"
                                                                      value="${(entity.pro_00510)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n20">20</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00520"
                                                                      value="${(entity.pro_00520)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n30">30</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00530"
                                                                      value="${(entity.pro_00530)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n40">40</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00540"
                                                                      value="${(entity.pro_00540)!''}"/></td>
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
                                <tr pro="024">
                                    <td class="borderRightNone"><strong>單</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02401"
                                                                      value="${(entity.pro_02401)!''}"/></td>
                                    <td class="borderRightNone"><strong>大</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02403"
                                                                      value="${(entity.pro_02403)!''}"/></td>
                                    <td class="borderRightNone"><strong>合單</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02405"
                                                                      value="${(entity.pro_02405)!''}"/></td>
                                </tr>
                                <tr pro="024">
                                    <td class="borderRightNone"><strong>雙</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02402"
                                                                      value="${(entity.pro_02402)!''}"/></td>
                                    <td class="borderRightNone"><strong>小</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02404"
                                                                      value="${(entity.pro_02404)!''}"/></td>
                                    <td class="borderRightNone"><strong>合雙</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02406"
                                                                      value="${(entity.pro_02406)!''}"/></td>
                                </tr>
                                <tr pro="031">
                                    <td class="borderRightNone"><strong class="red">紅色</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="03101"
                                                                      value="${(entity.pro_03101)!''}"/></td>
                                    <td class="borderRightNone"><strong class="blue">藍色</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="03102"
                                                                      value="${(entity.pro_03102)!''}"/></td>
                                    <td class="borderRightNone"><strong class="green">綠色</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="03103"
                                                                      value="${(entity.pro_03103)!''}"/></td>
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

