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
    <title>${title_userAccount!''} - X6</title>
    <link rel="stylesheet" href="../../resources/css/new/common.css" type="text/css">
    <link rel="stylesheet" href="../../resources/css/new//mike.chen.css?${JSVersion!''}" type="text/css">
</head>
<body class="weishulian">
<div id="htmlcover" style="background-color:rgb(255, 255, 255);filter:alpha(opacity=0);opacity:0;position:absolute;top:0pt;left:0pt;z-index:5;display:block;width:100%;height:100%;"></div>
<div id="doc3" class="yui-t7">
    <div class="play_hd">

    </div>
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="weishulian" class="module" status='{"041":0,"042":0,"043":0,"044":0,"045":0,"046":0}'>
                        <input type="hidden" id="time_stamp" value="1497948387"/>
                        <input type="hidden" id="cps_time" value="20170621181353"/>
                        <div class="hd"><h2 class="g-tit"><span id="product_name">尾數連</span> 投注（四尾連一次最多選擇9個尾數）</h2>
                            <div class="g-pr" id="types">
                                <label for="fushitouzhu"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="radio" id="fushitouzhu"   name="type" value="fushi" checked="checked"/>複式投注</label>
                                <label for="tuotoutouzhu"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="radio" id="tuotoutouzhu"   name="type" value="tuotou"/>拖頭投注</label></div>
                        </div>
                        <div class="bd">
                            <form id="form_mark">
                                <table class="g-t1">
                                    <thead><tr>
                                        <td>二尾連</td>
                                        <td>三尾連</td>
                                        <td class="r">四尾連</td>
                                    </tr></thead>
                                    <tbody id="plays">
                                    <tr>
                                        <th><label for="default_play"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="play" value="2041" type="radio"    checked="checked" id="default_play"/>二尾連(中) </label></th>
                                        <th><label for="sanweilian"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="play" id="sanweilian" value="3043" type="radio"  />三尾連(中) </label></th>
                                        <th><label for="siweilian"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="play" id="siweilian" value="4045" type="radio"  />四尾連(中) </label></th>
                                    </tr>
                                    <tr>
                                        <th><label for="erweilianbu"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="play" id="erweilianbu" value="2042" type="radio"  />二尾連(不中) </label></th>
                                        <th><label for="sanweilianbu"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="play" id="sanweilianbu" value="3044" type="radio"  />三尾連(不中) </label></th>
                                        <th><label for="siweilianbu"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="play" id="siweilianbu" value="4046" type="radio"  />四尾連(不中) </label></th>
                                    </tr>
                                    </tbody></table>
                                <div class="mt g-thd"><h3>請選擇球號</h3></div>
                                <table class="g-t1" id="ball">
                                    <tbody>
                                    <tr>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="01"/>1尾</label></th>
                                        <td><strong>01,11,21,31,41</strong></td><td width="10%" name="pro_01">${(entity.pro_04101)!''}</td>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="06"/>6尾</label></th>
                                        <td><strong>06,16,26,36,46</strong></td><td width='10%' name="pro_06">${(entity.pro_04106)!''}</td>
                                    </tr>
                                    <tr>
                                        <th class="bg"><label><input <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="02"/>2尾</label></th>
                                        <td><strong>02,12,22,32,42</strong></td><td name="pro_02">${(entity.pro_04102)!''}</td>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="07"/>7尾</label></th>
                                        <td><strong>07,17,27,37,47</strong></td><td name="pro_07">${(entity.pro_04107)!''}</td>
                                    </tr>
                                    <tr>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="03"/>3尾</label></th>
                                        <td><strong>03,13,23,33,43</strong></td><td name="pro_03">${(entity.pro_04103)!''}</td>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="08"/>8尾</label></th>
                                        <td><strong>08,18,28,38,48 </strong></td><td name="pro_08">${(entity.pro_04108)!''}</td>
                                    </tr>
                                    <tr>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="04"/>4尾</label></th>
                                        <td><strong>04,14,24,34,44</strong></td><td name="pro_04">${(entity.pro_04104)!''}</td>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="09"/>9尾</label></th>
                                        <td><strong>09,19,29,39,49</strong></td><td name="pro_09">${(entity.pro_04109)!''}</td>
                                    </tr>
                                    <tr>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="05"/>5尾</label></th>
                                        <td><strong>05,15,25,35,45</strong></td><td name="pro_05">${(entity.pro_04105)!''}</td>
                                        <th class="bg"><label><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   value="00"/>0尾</label></th>
                                        <td><strong>10,20,30,40 </strong></td><td name="pro_00">${(entity.pro_04100)!''}</td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div class="g-tn">單注金額&nbsp;<input <#if isOpen==false> disabled="disabled" class= tx dis" <#else>class="tx"</#if> type="text"  id="sum"/>
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
            <div class="bd">Copyright 2008-2018 ©SixPlay Online Casino. All rights reserved.</div>
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
<script type="text/javascript" src="../../resources/css/new/all.js?${JSVersion!''}" defer="defer"></script>
</body>
</html>
