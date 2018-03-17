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
    <title>${title_userAccount!''} - A28</title>
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
                            <a href="/odds/zhengmate3?isDefault=false&handicap=${handicap}" class="on ds d-gray" disabled="disabled">正3特</a>&nbsp;|
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
                                <tbody id="product_mark" pro="004">
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n1">01</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00401"
                                                                      value="${(entity.pro_00401)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n11">11</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00411"
                                                                      value="${(entity.pro_00411)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n21">21</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00421"
                                                                      value="${(entity.pro_00421)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n31">31</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00431"
                                                                      value="${(entity.pro_00431)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n41">41</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00441"
                                                                      value="${(entity.pro_00441)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n2">02</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00402"
                                                                      value="${(entity.pro_00402)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n12">12</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00412"
                                                                      value="${(entity.pro_00412)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n22">22</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00422"
                                                                      value="${(entity.pro_00422)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n32">32</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00432"
                                                                      value="${(entity.pro_00432)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n42">42</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00442"
                                                                      value="${(entity.pro_00442)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n3">03</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00403"
                                                                      value="${(entity.pro_00403)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n13">13</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00413"
                                                                      value="${(entity.pro_00413)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n23">23</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00423"
                                                                      value="${(entity.pro_00423)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n33">33</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00433"
                                                                      value="${(entity.pro_00433)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n43">43</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00443"
                                                                      value="${(entity.pro_00443)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n4">04</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00404"
                                                                      value="${(entity.pro_00404)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n14">14</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00414"
                                                                      value="${(entity.pro_00414)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n24">24</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00424"
                                                                      value="${(entity.pro_00424)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n34">34</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00434"
                                                                      value="${(entity.pro_00434)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n44">44</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00444"
                                                                      value="${(entity.pro_00444)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n5">05</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00405"
                                                                      value="${(entity.pro_00405)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n15">15</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00415"
                                                                      value="${(entity.pro_00415)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n25">25</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00425"
                                                                      value="${(entity.pro_00425)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n35">35</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00435"
                                                                      value="${(entity.pro_00435)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n45">45</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00445"
                                                                      value="${(entity.pro_00445)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n6">06</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00406"
                                                                      value="${(entity.pro_00406)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n16">16</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00416"
                                                                      value="${(entity.pro_00416)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n26">26</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00426"
                                                                      value="${(entity.pro_00426)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n36">36</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00436"
                                                                      value="${(entity.pro_00436)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n46">46</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00446"
                                                                      value="${(entity.pro_00446)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n7">07</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00407"
                                                                      value="${(entity.pro_00407)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n17">17</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00417"
                                                                      value="${(entity.pro_00417)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n27">27</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00427"
                                                                      value="${(entity.pro_00427)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n37">37</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00437"
                                                                      value="${(entity.pro_00437)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n47">47</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00447"
                                                                      value="${(entity.pro_00447)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n8">08</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00408"
                                                                      value="${(entity.pro_00408)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n18">18</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00418"
                                                                      value="${(entity.pro_00418)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n28">28</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00428"
                                                                      value="${(entity.pro_00428)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n38">38</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00438"
                                                                      value="${(entity.pro_00438)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n48">48</em></td>
                                    <td class="borderLeftNone"><input type="text" name="00448"
                                                                      value="${(entity.pro_00448)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n9">09</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00409"
                                                                      value="${(entity.pro_00409)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n19">19</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00419"
                                                                      value="${(entity.pro_00419)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n29">29</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00429"
                                                                      value="${(entity.pro_00429)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n39">39</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00439"
                                                                      value="${(entity.pro_00439)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n49">49</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00449"
                                                                      value="${(entity.pro_00449)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n10">10</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00410"
                                                                      value="${(entity.pro_00410)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n20">20</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00420"
                                                                      value="${(entity.pro_00420)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n30">30</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00430"
                                                                      value="${(entity.pro_00430)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n40">40</em></td>

                                    <td class="borderLeftNone"><input type="text" name="00440"
                                                                      value="${(entity.pro_00440)!''}"/></td>
                                    <td colspan="3"></td>
                                </tr>
                                </tbody>
                            </table>
                            <table class="g-t1 mt">
                                <thead>
                                <tr>
                                    <td class="borderRightNone">類型</td>
                                    <td class="borderLeftNone">賠率</td>
                                    <td class="borderRightNone">類型</td>
                                    <td class="borderLeftNone">賠率</td>
                                    <td class="borderRightNone">類型</td>
                                    <td class="borderLeftNone">賠率</td>
                                </tr>
                                </thead>
                                <tbody>
                                <tr pro="023">
                                    <td class="borderRightNone"><strong>單</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02301"
                                                                      value="${(entity.pro_02301)!''}"/></td>
                                    <td class="borderRightNone"><strong>大</strong></td>
                                    <td class="borderLeftNone"><input type="text"  name="02303"
                                                                      value="${(entity.pro_02303)!''}"/></td>
                                    <td class="borderRightNone"><strong>合單</strong></td>
                                    
                                    <td class="borderLeftNone"><input type="text"  name="02305"
                                                                      value="${(entity.pro_02305)!''}"/></td>
                                </tr>
                                <tr pro="023">
                                    <td class="borderRightNone"><strong>雙</strong></td>
                                    
                                    <td class="borderLeftNone"><input type="text"  name="02302"
                                                                      value="${(entity.pro_02302)!''}"/></td>
                                    <td class="borderRightNone"><strong>小</strong></td>
                                    
                                    <td class="borderLeftNone"><input type="text"  name="02304"
                                                                      value="${(entity.pro_02304)!''}"/></td>
                                    <td class="borderRightNone"><strong>合雙</strong></td>
                                    
                                    <td class="borderLeftNone"><input type="text"  name="02306"
                                                                      value="${(entity.pro_02306)!''}"/></td>
                                </tr>
                                <tr pro="030">
                                    <td class="borderRightNone"><strong class="red">紅色</strong></td>
                                    
                                    <td class="borderLeftNone"><input type="text"  name="03001"
                                                                      value="${(entity.pro_03001)!''}"/></td>
                                    <td class="borderRightNone"><strong class="blue">藍色</strong></td>
                                    
                                    <td class="borderLeftNone"><input type="text"  name="03002"
                                                                      value="${(entity.pro_03002)!''}"/></td>
                                    <td class="borderRightNone"><strong class="green">綠色</strong></td>
                                    
                                    <td class="borderLeftNone"><input type="text"  name="03003"
                                                                      value="${(entity.pro_03003)!''}"/></td>
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

