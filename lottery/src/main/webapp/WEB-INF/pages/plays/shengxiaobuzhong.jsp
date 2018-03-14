<!DOCTYPE HTML>
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = '';
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
    <title>f2211 - A28</title>
    <link rel="stylesheet" href="../../resources/css/new/common.css" type="text/css">
    <link rel="stylesheet" href="../../resources/css/new//mike.chen.css?${JSVersion!''}" type="text/css">
</head>
<body class="frame_shengxiaobuzhong">
<div id="htmlcover"
     style="background-color:rgb(255, 255, 255);filter:alpha(opacity=0);opacity:0;position:absolute;top:0pt;left:0pt;z-index:5;display:block;width:100%;height:100%;"></div>
<div id="doc3" class="yui-t7">
    <div class="play_hd">

    </div>
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="shengxiaobuzhong" class="module" status='{"053":0}'>
                        <input type="hidden" id="time_stamp" value="1497965073"/>
                        <input type="hidden" id="cps_time" value="20170621181221"/>
                        <div class="hd h25"><h2 class="g-tit"><span id="product_name">生肖不中</span> 投注
                            <span id="w_fast" class="w_fast">
        金額：
    <input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="text" id="w_fast_input" maxlength="9" autocomplete="off" />
    <input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="radio" id="jiaqin" name="w_fast" value="jiaqin" /><label for="jiaqin">家禽</label>
    <input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  type="radio" id="yeshou" name="w_fast" value="yeshou" /><label for="yeshou">野獸</label>
    </span>
                        </h2>
                            <input type="button" class="shengxiao_switch shengxiao_switch_zhong" value="生肖中" onclick="window.location='/plays/shengxiao'"/>
                            <input    type="button" class="shengxiao_switch red" value="生肖不中"  disabled  />
                        </div>
                        <div class="bd">
                            <form id="form_mark">
                                <table class="g-t1" id="main_tab">
                                    <thead>
                                    <tr>
                                        <td>生肖</td>
                                        <td>號碼</td>
                                        <td>賠率</td>
                                        <td>金額</td>
                                        <td>生肖</td>
                                        <td>號碼</td>
                                        <td>賠率</td>
                                        <td class="r">金額</td>
                                    </tr>
                                    </thead>
                                    <tbody pro="014">
                                    <tr>
                                        <td class="bg">鼠</td>
                                        <td><strong>${shengxiao.鼠}</strong></td>
                                        <td>${(entity.pro_05301)!''}</td>
                                        <td><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="pro_05301" type="text" />
                                        </td>
                                        <td class="bg">牛</td>
                                        <td><strong>${shengxiao.牛}</strong></td>
                                        <td>${(entity.pro_05302)!''}</td>
                                        <td><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="pro_05302"  type="text" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="bg">虎</td>
                                        <td><strong>${shengxiao.虎}</strong></td>
                                        <td>${(entity.pro_05303)!''}</td>
                                        <td><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="pro_05303" type="text" />
                                        </td>
                                        <td class="bg">兔</td>
                                        <td><strong>${shengxiao.兔}</strong></td>
                                        <td>${(entity.pro_05304)!''}</td>
                                        <td><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="pro_05304" type="text" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="bg">龍</td>
                                        <td><strong>${shengxiao.龍}</strong></td>
                                        <td>${(entity.pro_05305)!''}</td>
                                        <td><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="pro_05305" type="text" />
                                        </td>
                                        <td class="bg">蛇</td>
                                        <td><strong>${shengxiao.蛇}</strong></td>
                                        <td>${(entity.pro_05306)!''}</td>
                                        <td><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="pro_05306" type="text" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="bg">馬</td>
                                        <td><strong>${shengxiao.馬}</strong></td>
                                        <td>${(entity.pro_05307)!''}</td>
                                        <td><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="pro_05307" type="text" />
                                        </td>
                                        <td class="bg">羊</td>
                                        <td><strong>${shengxiao.羊}</strong></td>
                                        <td>${(entity.pro_05308)!''}</td>
                                        <td><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="pro_05308" type="text" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="bg">猴</td>
                                        <td><strong>${shengxiao.猴}</strong></td>
                                        <td>${(entity.pro_05309)!''}</td>
                                        <td><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="pro_05309" type="text" />
                                        </td>
                                        <td class="bg">雞</td>
                                        <td><strong>${shengxiao.雞}</strong></td>
                                        <td>${(entity.pro_05310)!''}</td>
                                        <td><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="pro_05310" type="text" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="bg">狗</td>
                                        <td><strong>${shengxiao.狗}</strong></td>
                                        <td>${(entity.pro_05311)!''}</td>
                                        <td><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="pro_05311" type="text" />
                                        </td>
                                        <td class="bg">豬</td>
                                        <td><strong>${shengxiao.豬}</strong></td>
                                        <td>${(entity.pro_05312)!''}</td>
                                        <td><input   <#if isOpen==false> disabled="disabled" class="dis" </#if>  name="pro_05312" type="text" />
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div class="g-tn">
                                    <input   <#if isOpen==false> disabled="disabled" class="dis btn2 bds" <#else>class="btn2 bds" </#if> type="submit"  value="訂 單"/>
                                    <input   <#if isOpen==false> disabled="disabled" class="dis btn2 bds" <#else>class="btn2 bds" </#if> type="reset"   value="重 設"/>
                                </div>

                            </form>
                        </div>
                        <div class="ft"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="ft">
        <div id="footer" class="module" style="display:none">
            <div class="hd"></div>
            <div class="bd">Copyright 2008-2017 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid63242f/user/login.html', //登錄路徑
        odds_refersh: 60000, //頁面的賠率刷新頻率,默認改為 60秒
        password_need: false, //是否開啟密碼登陸加密
        marqueeFresh: 60000, //設置跑馬燈頻率為60秒
        log4js_type: 0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/css/new/all.js?${JSVersion!''}" defer="defer"></script>
</body>
</html>
