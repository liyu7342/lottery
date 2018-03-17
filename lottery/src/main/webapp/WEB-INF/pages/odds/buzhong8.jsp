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
                    <div id="" class="module">
                        <div class="play_hd">
                            <a href="/odds/buzhong?isDefault=false&handicap=${handicap}" >五不中</a>&nbsp;|
                            <a href="/odds/buzhong6?isDefault=false&handicap=${handicap}" >六不中</a>&nbsp;|
                            <a href="/odds/buzhong7?isDefault=false&handicap=${handicap}">七不中</a>&nbsp;|
                            <a href="/odds/buzhong8?isDefault=false&handicap=${handicap}"  class="on ds d-gray" disabled="disabled">八不中</a>&nbsp;|
                            <a href="/odds/buzhong9?isDefault=false&handicap=${handicap}" class="">九不中</a>
                            <a href="/odds/buzhong10?isDefault=false&handicap=${handicap}" class="">十不中</a>
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
                                <tbody id="product_mark" pro="050">
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n1">01</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05001"
                                                                      value="${(entity.pro_05001)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n11">11</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05011"
                                                                      value="${(entity.pro_05011)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n21">21</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05021"
                                                                      value="${(entity.pro_05021)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n31">31</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05031"
                                                                      value="${(entity.pro_05031)!''}"/></td>

                                    <td class="hand borderRightNone"><em class="ico n41">41</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05041"
                                                                      value="${(entity.pro_05041)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n2">02</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05002"
                                                                      value="${(entity.pro_05002)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n12">12</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05012"
                                                                      value="${(entity.pro_05012)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n22">22</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05022"
                                                                      value="${(entity.pro_05022)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n32">32</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05032"
                                                                      value="${(entity.pro_05032)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n42">42</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05042"
                                                                      value="${(entity.pro_05042)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n3">03</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05003"
                                                                      value="${(entity.pro_05003)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n13">13</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05013"
                                                                      value="${(entity.pro_05013)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n23">23</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05023"
                                                                      value="${(entity.pro_05023)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n33">33</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05033"
                                                                      value="${(entity.pro_05033)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n43">43</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05043"
                                                                      value="${(entity.pro_05043)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n4">04</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05004"
                                                                      value="${(entity.pro_05004)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n14">14</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05014"
                                                                      value="${(entity.pro_05014)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n24">24</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05024"
                                                                      value="${(entity.pro_05024)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n34">34</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05034"
                                                                      value="${(entity.pro_05034)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n44">44</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05044"
                                                                      value="${(entity.pro_05044)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n5">05</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05005"
                                                                      value="${(entity.pro_05005)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n15">15</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05015"
                                                                      value="${(entity.pro_05015)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n25">25</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05025"
                                                                      value="${(entity.pro_05025)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n35">35</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05035"
                                                                      value="${(entity.pro_05035)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n45">45</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05045"
                                                                      value="${(entity.pro_05045)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n6">06</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05006"
                                                                      value="${(entity.pro_05006)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n16">16</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05016"
                                                                      value="${(entity.pro_05016)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n26">26</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05026"
                                                                      value="${(entity.pro_05026)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n36">36</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05036"
                                                                      value="${(entity.pro_05036)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n46">46</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05046"
                                                                      value="${(entity.pro_05046)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n7">07</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05007"
                                                                      value="${(entity.pro_05007)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n17">17</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05017"
                                                                      value="${(entity.pro_05017)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n27">27</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05027"
                                                                      value="${(entity.pro_05027)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n37">37</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05037"
                                                                      value="${(entity.pro_05037)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n47">47</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05047"
                                                                      value="${(entity.pro_05047)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n8">08</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05008"
                                                                      value="${(entity.pro_05008)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n18">18</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05018"
                                                                      value="${(entity.pro_05018)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n28">28</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05028"
                                                                      value="${(entity.pro_05028)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n38">38</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05038"
                                                                      value="${(entity.pro_05038)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n48">48</em></td>
                                    <td class="borderLeftNone"><input type="text" name="05048"
                                                                      value="${(entity.pro_05048)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n9">09</em></td>

                                    <td class="borderLeftNone"><input type="text" name="05009"
                                                                      value="${(entity.pro_05009)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n19">19</em></td>

                                    <td class="borderLeftNone"><input type="text" name="05019"
                                                                      value="${(entity.pro_05019)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n29">29</em></td>

                                    <td class="borderLeftNone"><input type="text" name="05029"
                                                                      value="${(entity.pro_05029)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n39">39</em></td>

                                    <td class="borderLeftNone"><input type="text" name="05039"
                                                                      value="${(entity.pro_05039)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n49">49</em></td>

                                    <td class="borderLeftNone"><input type="text" name="05049"
                                                                      value="${(entity.pro_05049)!''}"/></td>
                                </tr>
                                <tr>
                                    <td class="hand borderRightNone"><em class="ico n10">10</em></td>

                                    <td class="borderLeftNone"><input type="text" name="05010"
                                                                      value="${(entity.pro_05010)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n20">20</em></td>

                                    <td class="borderLeftNone"><input type="text" name="05020"
                                                                      value="${(entity.pro_05020)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n30">30</em></td>

                                    <td class="borderLeftNone"><input type="text" name="05030"
                                                                      value="${(entity.pro_05030)!''}"/></td>
                                    <td class="hand borderRightNone"><em class="ico n40">40</em></td>

                                    <td class="borderLeftNone"><input type="text" name="05040"
                                                                      value="${(entity.pro_05040)!''}"/></td>
                                    <td colspan="3"></td>
                                </tr>
                                </tbody>
                            </table>
 

                            <div class="g-tn">
                                <input type="hidden" value="${handicap}" name="oddSet" id="hiddenOddSet" />
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
                        <li><a curl='0' href='/odds/erquanzh?isDefault=false&handicap=${handicap}'>連碼</a><cite></cite></li>
                        <li><a curl='0' href='/odds/guoguan?isDefault=false&handicap=${handicap}'>過關</a><cite></cite></li>
                        <li><a curl='0' href='/odds/shengxiao?isDefault=false&handicap=${handicap}'>生肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/weishu?isDefault=false&handicap=${handicap}'>尾數</a><cite></cite></li>
                        <li><a curl='0' href='/odds/banbo?isDefault=false&handicap=${handicap}'>半波</a><cite></cite></li>
                        <li><a curl='0' href='/odds/liuxiao?isDefault=false&handicap=${handicap}'>六肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/texiao?isDefault=false&handicap=${handicap}'>特肖</a><cite></cite></li>
                        <li><a curl='0' href='/odds/shengxiaolian?isDefault=false&handicap=${handicap}'>生肖連</a><cite></cite></li>
                        <li><a curl='0' href='/odds/weishulian?isDefault=false&handicap=${handicap}'>尾數連</a><cite></cite></li>
                        <li><a curl='5' href='/odds/buzhong?isDefault=false&handicap=${handicap}'>不中</a><cite></cite></li>
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

