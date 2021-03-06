<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
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
    <title>${user.account} - X6</title>
    <link rel="stylesheet" href="../../resources/css/new/common.css" type="text/css">
    <link rel="stylesheet" href="../../resources/css/new/mike.chen.css?${JSVersion!''}" type="text/css">
</head>
<body class="frame_xiazhumsg">
<div id="htmlcover"
     style="background-color:rgb(255, 255, 255);filter:alpha(opacity=0);opacity:0;position:absolute;top:0pt;left:0pt;z-index:5;display:block;width:100%;height:100%;"></div>
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">

                    <input id='xiazhumsg_header_info'
                           value='${headinfo}'
                           type="hidden"/>
                    <div id="xiazhumsg" class="module ">
                        <div class="hd g-tm">
                            <h2 class="g-tit">
                                <!--當進入的是會員歷史時 下邊的菜單不需要顯示 當公司不需要高額彩時 下邊的菜單同樣不需要-->
                                &nbsp;&nbsp;
                                <input type='radio' name='to_link' id='to_link' value="list??id=${id}" checked='checked'/>
                                <font color='red'>成功明細</font>&nbsp;
                                <input type='radio' name='to_link' id='to_link' value="fail_list?id=${id}"/>
                                失敗明細 <select name="categoryId" id="categoryId">
                                <option selected=selected value='-1'>全部</option>
                                <option value='00' <#if categoryId=="00" >selected=selected</#if>>特碼</option>
                                <option value='01'<#if categoryId=="01" >selected=selected</#if>>正碼</option>
                                <option value='02' <#if categoryId=="02" >selected=selected</#if>>正碼特</option>
                                <option value='03' <#if categoryId=="03" >selected=selected</#if>>連碼二</option>
                                <option value='04' <#if categoryId=="04" >selected=selected</#if>>連碼三</option>
                                <option value='05' <#if categoryId=="05" >selected=selected</#if>>過關</option>
                                <option value='06' <#if categoryId=="06" >selected=selected</#if>>生肖</option>
                                <option value='07' <#if categoryId=="07" >selected=selected</#if>>尾數</option>
                                <option value='08' <#if categoryId=="08" >selected=selected</#if>>半波</option>
                                <option value='09' <#if categoryId=="09" >selected=selected</#if>>六肖</option>
                                <option value='10'<#if categoryId=="10" >selected=selected</#if>>兩面</option>
                                <option value='11' <#if categoryId=="11" >selected=selected</#if>>色波</option>
                                <option value='12' <#if categoryId=="12" >selected=selected</#if>>特肖</option>
                                <option value='13' <#if categoryId=="13" >selected=selected</#if>>生肖連</option>
                                <option value='14' <#if categoryId=="14" >selected=selected</#if>>尾數連</option>
                                <option value='15' <#if categoryId=="15" >selected=selected</#if>>不中</option>
                            </select>
                            </h2>
                            <div class="fr">
                               <div style="margin-right: 52px;">${page}</div>
                                &nbsp;<input type="button" value="打印" class="btn16" onclick="javascript:print();return false;"/></div>
                        </div>
                        <div class="bd">
                            <table class="g-t1">
                                <thead>
                                <tr>

                                    <td>注單號</td>
                                    <td>盤口</td>
                                    <td>玩法</td>
                                    <td>下注時間</td>
                                    <td>下注金額</td>
                                    <td>賠率</td>
                                    <td>退水</td>
                                    <td><#if id=="">可贏金額<#else>结果</#if></td>
                                    <td class="r">注單狀態</td>
                                </tr>
                                </thead>
                                <#list orderList as obj>
                                <tr>
                                    <td>${(obj.orderNo)!''}</td>
                                    <td>${obj.oddset!''}</td>
                                    <td><#if obj.isMuti><a target="popup" href="/order/detail?order_id=${obj.orderNo}" fix="600|400|yes|yes" from_page="report" game_id="${obj.gameType!''}">${(obj.description)!''}</a><#else>${(obj.description)!''}</#if></td>
                                    <td>${obj.createdate?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    <td>${(obj.totalAmount)!''}</td>
                                    <td>${(obj.odds)!''}</td>
                                    <td>${(obj.retreat)!''}%</td>
                                    <td <#if id!="" && obj.winAmount gt 0 >class="red"</#if> >
                                    <#if id=="" && obj.canWinAmount gt 0>${(obj.canWinAmount)?string("#.##")}

                                                <#else>
                                                    ${(obj.winAmount+obj.retreatAmt)?string("#.##")}
                                    </#if>
                                    </td>

                                    <td><#if id=="">下注成功 <#else>成功</#if></td>
                                </tr>
                                </#list>
                                <tfoot>
                                <tr class="green">
                                    <td colspan="4">小計：</td>
                                    <td>${subSum}</td>
                                    <td></td>
                                    <td></td>
                                    <td><#if id=="" && subCanWinAmount gt 0>${(subCanWinAmount)?floor}
                                        <#elseif id=="" && subCanWinAmount lte 0 >
                                            ${subCanWinAmount?ceiling}
                                            <#elseif subWinAmount gt 0>
                                                ${subWinAmount?floor}
                                                <#else>
                                                    ${subWinAmount?ceiling}
                                    </#if>
                                      </td>
                                    <td></td>
                                </tr>
                                <tr class="red">
                                    <td colspan="4">總計：</td>
                                    <td>${totalAmount}</td>
                                    <td></td>
                                    <td></td>
                                    <td><#if id=="" && canWinAmount gt 0>${(canWinAmount)?floor}
                                        <#elseif id=="" && canWinAmount lte 0 >
                                            ${canWinAmount?ceiling}
                                            <#elseif winAmount gt 0>
                                                ${winAmount?floor}
                                                <#else>
                                                    ${winAmount?ceiling}
                                            </#if></td>
                                    <td></td>
                                </tr>
                                </tfoot>
                            </table>
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
            <div class="bd">Copyright 2008-2018 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function page(index){
    location.href="/order/list?pageId="+index+"&categoryId="+$("#categoryId").val()+"&id=${id}"
    }
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
