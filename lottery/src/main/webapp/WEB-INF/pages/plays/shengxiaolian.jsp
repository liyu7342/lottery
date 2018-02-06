<!DOCTYPE HTML>
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = '';
        try{if(domain){document.domain = domain;}}catch(x){domainOK = 0;}
    </script>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>f2211 - A28</title>
    <link rel="stylesheet" href="../../resources/css/new/common.css" type="text/css">
    <link rel="stylesheet" href="../../resources/css/new//mike.chen.css?ms2.4.7_31064" type="text/css">
</head>
<body class="shengxiaolian">
<div id="htmlcover" style="background-color:rgb(255, 255, 255);filter:alpha(opacity=0);opacity:0;position:absolute;top:0pt;left:0pt;z-index:5;display:block;width:100%;height:100%;"></div>
<div id="doc3" class="yui-t7">
    <div class="play_hd">

    </div>
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="shengxiaolian" class="module" status='{"035":1,"036":1,"037":1,"038":1,"039":1,"040":1,"054":0,"055":0}'>
                        <input type="hidden" id="time_stamp" value="1497965366"/>
                        <input type="hidden" id="cps_time" value="20170621181339"/>
                        <div class="hd"><h2 class="g-tit"><span id="product_name">生肖連</span> 投注（一次最多選擇9個生肖）</h2>
                            <div class="g-pr" id="types"><label for="fushitouzhu"><input type="radio" id="fushitouzhu"   name="type" value="fushi" checked="checked"/>複式投注</label>
                                <label for="tuotoutouzhu"><input type="radio" id="tuotoutouzhu"   name="type" value="tuotou"/>拖頭投注</label></div>
                        </div>
                        <div class="bd">
                            <form id="form_mark">
                                <table class="g-t1">
                                    <thead><tr>
                                        <td>二肖連</td>
                                        <td>三肖連</td>
                                        <td>四肖連</td>
                                        <td class="r">五肖連</td>
                                    </tr></thead>
                                    <tbody id="plays">
                                    <tr>
                                        <th><label for="default_play"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="play" value="2035" type="radio"    checked="checked" id="default_play"/>二肖連(中)</label></th>
                                        <th><label for="sanxiaozhong"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  id="sanxiaozhong" name="play" value="3037" type="radio"  />三肖連(中)</label></th>
                                        <th><label for="sixiaozhong"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  id="sixiaozhong" name="play" value="4039" type="radio"  />四肖連(中)</label></th>
                                        <th><label for="wuxiaozhong"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  id="wuxiaozhong" name="play" value="5054" type="radio"  />五肖連(中)</label></th>
                                    </tr>
                                    <tr>
                                        <th><label for="erxiaobuzhong"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  id="erxiaobuzhong" name="play" value="2036" type="radio"  />二肖連(不中)</label></th>
                                        <th><label for="sanxiaobuzhong"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  id="sanxiaobuzhong" name="play" value="3038" type="radio"  />三肖連(不中)</label></th>
                                        <th><label for="sixiaobuzhong"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  id="sixiaobuzhong" name="play" value="4040" type="radio"  />四肖連(不中)</label></th>
                                        <th><label for="wuxiaobuzhong"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  id="wuxiaobuzhong" name="play" value="5055" type="radio"  />五肖連(不中)</label></th>
                                    </tr>
                                    </tbody></table>
                                <div class="mt g-thd"><h3>請選擇球號</h3></div>
                                <table class="g-t1" id="ball">
                                    <tbody>
                                    <tr>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"    value="01"/>鼠</label></th>
                                        <td><strong>10,22,34,46</strong></td><td width="10%" name="pro_01">  ${(entity.pro_03501)!''}</td>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="02"/>牛</label></th>
                                        <td><strong>09,21,33,45</strong></td><td width="10%" name="pro_02">${(entity.pro_03502)!''}</td>
                                    </tr>
                                    <tr>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="03"/>虎</label></th>
                                        <td><strong>08,20,32,44</strong></td><td name="pro_03">${(entity.pro_03503)!''}</td>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="04"/>兔</label></th>
                                        <td><strong>07,19,31,43</strong></td><td name="pro_04">${(entity.pro_03504)!''}</td>
                                    </tr>
                                    <tr>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="05"/>龍</label></th>
                                        <td><strong>06,18,30,42</strong></td><td name="pro_05">${(entity.pro_03505)!''}</td>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="06"/>蛇</label></th>
                                        <td><strong>05,17,29,41</strong></td><td name="pro_06">${(entity.pro_03506)!''}</td>
                                    </tr>
                                    <tr>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="07"/>馬</label></th>
                                        <td><strong>04,16,28,40</strong></td><td name="pro_07">${(entity.pro_03507)!''}</td>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="08"/>羊</label></th>
                                        <td><strong>03,15,27,39</strong></td><td name="pro_08">${(entity.pro_03508)!''}</td>
                                    </tr>
                                    <tr>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="09"/>猴</label></th>
                                        <td><strong>02,14,26,38</strong></td><td name="pro_09">${(entity.pro_03509)!''}</td>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="10"/>雞</label></th>
                                        <td><strong>01,13,25,37,49</strong></td><td name="pro_10">${(entity.pro_03510)!''}</td>
                                    </tr>
                                    <tr>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="11"/>狗</label></th>
                                        <td><strong>12,24,36,48</strong></td><td name="pro_11">${(entity.pro_03511)!''}</td>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="12"/>豬</label></th>
                                        <td><strong>11,23,35,47</strong></td><td name="pro_12">${(entity.pro_03512)!''}</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div class="g-tn">單注金額&nbsp;<input  <#if isOpen==false> disabled="disabled" class="dis tx" <#else>class="tx"</#if> type="text"  id="sum"/>
                                    <input   <#if isOpen==false> disabled="disabled" class="dis btn2 bds" <#else>class="btn2 bds" </#if> type="submit"  value="訂 單"/>
                                        <input   <#if isOpen==false> disabled="disabled" class="dis btn2 bds" <#else>class="btn2 bds" </#if> type="reset"  value="重 設"/>
                                </div>
                        </div>
                        </form>
                        <div class="ft"></div>
                    </div>
                    <script type="text/javascript">

                        var sw_all_info =${info};
                    </script>
                </div>
            </div>
        </div>
    </div>
    <div id="ft">
        <div id="footer" class="module" style="display:none">
            <div class="hd"></div>
            <div class="bd">Copyright 2008-2017 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid63242f/user/login.html', //登錄路徑
        odds_refersh: 60000, //頁面的賠率刷新頻率,默認改為 60秒
        password_need: false, //是否開啟密碼登陸加密
        marqueeFresh: 60000, //設置跑馬燈頻率為60秒
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/css/new/all.js?ms2.4.7_31064" defer="defer"></script>
</body>
</html>
