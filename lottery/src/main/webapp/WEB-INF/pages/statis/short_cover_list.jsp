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
    <link rel="stylesheet" href="http://pm10.x.mmm33.us:80/theme/gray/css/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="http://pm10.x.mmm33.us:80/theme/gray/css/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="short_cover_list">
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="shoufutongji" class="module">
                        <div class="hd">
                            <#include "/statis/staticsheader.jsp">
                        </div>
                        <div class="bd">
                        </div>
                        <input type="hidden" name="stops" value=''>
                        <div class="ft"></div>
                    </div>
                    <div id="tjscl" class="module g-mt0">
                        <div class="hd g-tm">
                        <span class="bcradio">
                            <div class="g-tit">
                                <strong>收付統計 -> <font color="red">補倉</font></strong>
                           </div>
                          </span>
                            <div class="bcdiv">
                                <input type="radio" id="shortCoverRadio" name="shortCoverRadio" value="time">時間 <input
                                    type="radio" id="shortCoverRadio" name="shortCoverRadio" value="play"
                                    checked="checked"><font color="red">球號</font> <select id="shortCoverPlay"
                                                                                          name="shortCoverPlay">
                                <option value='000' <#if game_id=='000'>  selected='selected' </#if>>特碼</option>
                                <option value='001' <#if game_id=='001'>  selected='selected' </#if>>正碼</option>
                                <option value='002' <#if game_id=='002'>  selected='selected' </#if>>正1特</option>
                                <option value='003' <#if game_id=='003'>  selected='selected' </#if>>正2特</option>
                                <option value='004' <#if game_id=='004'>  selected='selected' </#if>>正3特</option>
                                <option value='005' <#if game_id=='005'>  selected='selected' </#if>>正4特</option>
                                <option value='006'<#if game_id=='006'>  selected='selected' </#if>>正5特</option>
                                <option value='007'<#if game_id=='007'>  selected='selected' </#if>>正6特</option>
                                <option value='008'<#if game_id=='008'>  selected='selected' </#if>>二全中</option>
                                <option value='009'<#if game_id=='009'>  selected='selected' </#if>>二中特</option>
                                <option value='010'<#if game_id=='010'>  selected='selected' </#if>>特串</option>
                                <option value='011'<#if game_id=='011'>  selected='selected' </#if>>三全中</option>
                                <option value='012'<#if game_id=='012'>  selected='selected' </#if>>三中二</option>
                                <option value='013'<#if game_id=='013'>  selected='selected' </#if>>過關</option>
                                <option value='014'<#if game_id=='014'>  selected='selected' </#if>>生肖中</option>
                                <option value='053'<#if game_id=='053'>  selected='selected' </#if>>生肖不中</option>
                                <option value='015'<#if game_id=='015'>  selected='selected' </#if>>尾數</option>
                                <option value='016'<#if game_id=='016'>  selected='selected' </#if>>半波</option>
                                <option value='018,017' <#if game_id=='018,017'>  selected='selected' </#if>>六肖</option>
                                <option value='026,025,024,023,022,021,020,019' <#if game_id=='026,025,024,023,022,021,020,019'>  selected='selected' </#if>>兩面</option>
                                <option value='033,032,031,030,029,028,027' <#if game_id=='033,032,031,030,029,028,027'>  selected='selected' </#if>>色波</option>
                                <option value='034'<#if game_id=='034'>  selected='selected' </#if>>特肖</option>
                                <option value='035'<#if game_id=='035'>  selected='selected' </#if>>二肖連(中)</option>
                                <option value='036'<#if game_id=='036'>  selected='selected' </#if>>二肖連(不中)</option>
                                <option value='037'<#if game_id=='037'>  selected='selected' </#if>>三肖連(中)</option>
                                <option value='038'<#if game_id=='038'>  selected='selected' </#if>>三肖連(不中)</option>
                                <option value='039'<#if game_id=='039'>  selected='selected' </#if>>四肖連(中)</option>
                                <option value='040'<#if game_id=='040'>  selected='selected' </#if>>四肖連(不中)</option>
                                <option value='054'<#if game_id=='054'>  selected='selected' </#if>>五肖連(中)</option>
                                <option value='055'<#if game_id=='055'>  selected='selected' </#if>>五肖連(不中)</option>
                                <option value='041'<#if game_id=='041'>  selected='selected' </#if>>二尾連(中)</option>
                                <option value='042'<#if game_id=='042'>  selected='selected' </#if>>二尾連(不中)</option>
                                <option value='043'<#if game_id=='043'>  selected='selected' </#if>>三尾連(中)</option>
                                <option value='044' <#if game_id=='044'>  selected='selected' </#if>>三尾連(不中)</option>
                                <option value='045'<#if game_id=='045'>  selected='selected' </#if>>四尾連(中)</option>
                                <option value='046'<#if game_id=='046'>  selected='selected' </#if>>四尾連(不中)</option>
                                <option value='047'<#if game_id=='047'>  selected='selected' </#if>>五不中</option>
                                <option value='048'<#if game_id=='048'>  selected='selected' </#if>>六不中</option>
                                <option value='049'<#if game_id=='049'>  selected='selected' </#if>>七不中</option>
                                <option value='050'<#if game_id=='050'>  selected='selected' </#if>>八不中</option>
                                <option value='051'<#if game_id=='051'>  selected='selected' </#if>>九不中</option>
                                <option value='052'<#if game_id=='052'>  selected='selected' </#if>>十不中</option>
                            </select>
                            </div>
                        </div>
                        <div class="bd">
                            <table class="g-t1 g-t2" id="main_tab">
                                <thead>
                                <tr>
                                    <td>序號</td>
                                    <td>玩法</td>
                                    <td>注數</td>
                                    <td>補倉金額</td>
                                    <td>佣金收入</td>
                                </tr>
                                </thead>
                                <tbody>
                                <#list orderDetails as orderDetail>
                                    <tr>
                                    <td>${(orderDetail_index)+1!''}</td>
                                    <td>${orderDetail.description!''}</td>
                                    <td>${orderDetail.orderNo!''}</td>
                                    <td>${orderDetail.amount!''}</td>
                                    <td>${orderDetail.retreat?int}</td>
                                    </tr>
                                </#list>
                                <td colspan="2">總計</td>
                                <td>${orderNum!'0'}</td>
                                <td>${amount!'0'}</td>
                                <td>${retreat?floor}</td>
                                </tbody>
                            </table>
                        </div>
                        <div class="ft">
                        </div>
                    </div>
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
        login_path: '/msdid63213790a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 20000, //設置開關盤刷新頻率
        log4js_type: 0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

