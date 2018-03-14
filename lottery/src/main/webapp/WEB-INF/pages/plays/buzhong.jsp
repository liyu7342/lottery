<!DOCTYPE HTML >
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
    <link rel="stylesheet" href="../../resources/css/new//mike.chen.css?${JSVersion!''}" type="text/css">
</head>
<body class="buzhong">
<div id="htmlcover" style="background-color:rgb(255, 255, 255);filter:alpha(opacity=0);opacity:0;position:absolute;top:0pt;left:0pt;z-index:5;display:block;width:100%;height:100%;"></div>
<div id="doc3" class="yui-t7">
    <div class="play_hd">

    </div>
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="buzhong" class="module" info='${info}'>
                        <div class="hd"><h2 class="g-tit"><span>不中</span> 投注(可選擇<span id="range">5~8</span>項)</h2>
                            <div class="g-pr" id="plays">
                                <a href="" name="0" class="btn1 ds d-gray" >五不中</a>&nbsp;
                                <a href="" name="1" class="btn1">六不中</a>&nbsp;
                                <a href="" name="2" class="btn1">七不中</a>&nbsp;
                                <a href="" name="3" class="btn1">八不中</a>&nbsp;
                                <a href="" name="4" class="btn1">九不中</a>&nbsp;
                                <a href="" name="5" class="btn1" style="margin-right:40px;">十不中</a>
                                <label><input type="radio"    checked="checked" value="fs" name="ty"/>複式投注</label>
                                <label><input type="radio"   value="dz" name="ty"/>多組投注</label></div>
                        </div>
                        <div class="bd">
                            <form id="form_mark">
                                <table class="g-t1" pro="047">
                                    <thead>
                                    <tr>
                                        <td>號碼</td>
                                        <td colspan="2"> 賠率 </td>
                                        <td>號碼</td>
                                        <td colspan="2"> 賠率 </td>
                                        <td>號碼</td>
                                        <td colspan="2"> 賠率 </td>
                                        <td>號碼</td>
                                        <td colspan="2"> 賠率 </td>
                                        <td>號碼</td>
                                        <td colspan="2" class="r"> 賠率 </td>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td><em class="ico n1">01</em></td>
                                        <td width="8%">${entity.pro_04701!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"   /></th>
                                        <td><em class="ico n11">11</em></td>
                                        <td width="8%">${entity.pro_04711!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n21">21</em></td>
                                        <td width="8%">${entity.pro_04721!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n31">31</em></td>
                                        <td width="8%">${entity.pro_04731!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n41">41</em></td>
                                        <td width="8%">${entity.pro_04741!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                    </tr>
                                    <tr>
                                        <td><em class="ico n2">02</em></td>
                                        <td width="8%">${entity.pro_04702!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n12">12</em></td>
                                        <td width="8%">${entity.pro_04712!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n22">22</em></td>
                                        <td width="8%">${entity.pro_04722!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n32">32</em></td>
                                        <td width="8%">${entity.pro_04732!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n42">42</em></td>
                                        <td width="8%">${entity.pro_04742!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                    </tr>
                                    <tr>
                                        <td><em class="ico n3">03</em></td>
                                        <td width="8%">${entity.pro_04703!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n13">13</em></td>
                                        <td width="8%">${entity.pro_04713!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n23">23</em></td>
                                        <td width="8%">${entity.pro_04723!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n33">33</em></td>
                                        <td width="8%">${entity.pro_04733!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n43">43</em></td>
                                        <td width="8%">${entity.pro_04743!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                    </tr>
                                    <tr>
                                        <td><em class="ico n4">04</em></td>
                                        <td width="8%">${entity.pro_04704!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n14">14</em></td>
                                        <td width="8%">${entity.pro_04714!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n24">24</em></td>
                                        <td width="8%">${entity.pro_04724!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n34">34</em></td>
                                        <td width="8%">${entity.pro_04734!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n44">44</em></td>
                                        <td width="8%">${entity.pro_04744!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                    </tr>
                                    <tr>
                                        <td><em class="ico n5">05</em></td>
                                        <td width="8%">${entity.pro_04705!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n15">15</em></td>
                                        <td width="8%">${entity.pro_04715!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n25">25</em></td>
                                        <td width="8%">${entity.pro_04725!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n35">35</em></td>
                                        <td width="8%">${entity.pro_04735!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n45">45</em></td>
                                        <td width="8%">${entity.pro_04745!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                    </tr>
                                    <tr>
                                        <td><em class="ico n6">06</em></td>
                                        <td width="8%">${entity.pro_04706!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n16">16</em></td>
                                        <td width="8%">${entity.pro_04716!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n26">26</em></td>
                                        <td width="8%">${entity.pro_04726!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n36">36</em></td>
                                        <td width="8%">${entity.pro_04736!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n46">46</em></td>
                                        <td width="8%">${entity.pro_04746!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                    </tr>
                                    <tr>
                                        <td><em class="ico n7">07</em></td>
                                        <td width="8%">${entity.pro_04707!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n17">17</em></td>
                                        <td width="8%">${entity.pro_04717!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n27">27</em></td>
                                        <td width="8%">${entity.pro_04727!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n37">37</em></td>
                                        <td width="8%">${entity.pro_04737!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n47">47</em></td>
                                        <td width="8%">${entity.pro_04747!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                    </tr>
                                    <tr>
                                        <td><em class="ico n8">08</em></td>
                                        <td width="8%">${entity.pro_04708!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n18">18</em></td>
                                        <td width="8%">${entity.pro_04718!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n28">28</em></td>
                                        <td width="8%">${entity.pro_04728!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n38">38</em></td>
                                        <td width="8%">${entity.pro_04738!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n48">48</em></td>
                                        <td width="8%">${entity.pro_04748!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                    </tr>
                                    <tr>
                                        <td><em class="ico n9">09</em></td>
                                        <td width="8%">${entity.pro_04709!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n19">19</em></td>
                                        <td width="8%">${entity.pro_04719!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n29">29</em></td>
                                        <td width="8%">${entity.pro_04729!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n39">39</em></td>
                                        <td width="8%">${entity.pro_04739!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n49">49</em></td>
                                        <td width="8%">${entity.pro_04749!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                    </tr>
                                    <tr>
                                        <td><em class="ico n10">10</em></td>
                                        <td width="8%">${entity.pro_04710!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n20">20</em></td>
                                        <td width="8%">${entity.pro_04720!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n30">30</em></td>
                                        <td width="8%">${entity.pro_04730!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td><em class="ico n40">40</em></td>
                                        <td width="8%">${entity.pro_04740!''}</td>
                                        <th class="bg"><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="checkbox"  /></th>
                                        <td colspan="3"></td>
                                    </tr>
                                    </tbody></table>
                                <div class="g-tn left" id='msg'>球號：[]</div>
                                <div class="g-tn"><strong>&nbsp;金額</strong><input <#if isOpen==false> disabled="disabled" class="dis tx" <#else>class="tx"</#if>  type="text"  name="sum"/>
                                    <input   <#if isOpen==false> disabled="disabled" class="dis btn2 bds" <#else>class="btn2 bds"</#if> type="submit"  value="訂 單"/>
                                    <input   <#if isOpen==false> disabled="disabled" class="dis btn2 bds" <#else>class="btn2 bds" </#if> type="reset"  value="重 設"/>
                                </div>
                            </form>
                        </div>

                        <div class="ft"></div>
                    </div>                </div>
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
<script type="text/javascript" src="../../resources/css/new/all.js?${JSVersion!''}" defer="defer"></script>
</body>
</html>
