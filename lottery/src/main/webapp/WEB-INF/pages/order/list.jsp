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
    <title>f2211 - A28</title>
    <link rel="stylesheet" href="../../resources/css/new/common.css" type="text/css">
    <link rel="stylesheet" href="../../resources/css/new/mike.chen.css?ms2.4.7_31064" type="text/css">
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
                           value='{"marquee":"欢迎进入前台","draws":"","sum":"0.00000","credit":"0.00000","new_order":[],"calc_status":-1,"fail_count":0}'
                           type="hidden"/>
                    <div id="xiazhumsg" class="module ">
                        <div class="hd g-tm">
                            <h2 class="g-tit">
                                <!--當進入的是會員歷史時 下邊的菜單不需要顯示 當公司不需要高額彩時 下邊的菜單同樣不需要-->
                                &nbsp;&nbsp;
                                <input type='radio' name='to_link' id='to_link' value="list.htm" checked='checked'/>
                                <font color='red'>成功明細</font>&nbsp;
                                <input type='radio' name='to_link' id='to_link' value="fail_list.htm"/>
                                失敗明細 <select name="categoryId">
                                <option selected=selected value='-1'>全部</option>
                                <option value='00'>特碼</option>
                                <option value='01'>正碼</option>
                                <option value='02'>正碼特</option>
                                <option value='03'>連碼二</option>
                                <option value='04'>連碼三</option>
                                <option value='05'>過關</option>
                                <option value='06'>生肖</option>
                                <option value='07'>尾數</option>
                                <option value='08'>半波</option>
                                <option value='09'>六肖</option>
                                <option value='10'>兩面</option>
                                <option value='11'>色波</option>
                                <option value='12'>特肖</option>
                                <option value='13'>生肖連</option>
                                <option value='14'>尾數連</option>
                                <option value='15'>不中</option>
                            </select>
                            </h2>
                            <div class="fr">&nbsp;<input type="button" value="打印" class="btn16"
                                                         onclick="javascript:print();return false;"/></div>
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
                                    <td>可贏金額</td>
                                    <td class="r">注單狀態</td>
                                </tr>
                                </thead>
                                <#list orderList as obj>
                                <tr>
                                    <td></td>
                                    <td>B</td>
                                    <td>${(obj.description)!''}</td>
                                    <td>${obj.createdate?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    <td>${(obj.amount)!''}</td>
                                    <td>${(obj.odds)!''}</td>
                                    <td>${(obj.reteat)!''}</td>
                                    <td>${(obj.winAmount)!''}</td>
                                    <td>下注成功</td>
                                </tr>
                                </#list>
                                <tfoot>
                                <tr class="green">
                                    <td colspan="4">小計：</td>
                                    <td>0</td>
                                    <td></td>
                                    <td></td>
                                    <td>0</td>
                                    <td></td>
                                </tr>
                                <tr class="red">
                                    <td colspan="4">總計：</td>
                                    <td>0</td>
                                    <td></td>
                                    <td></td>
                                    <td>0</td>
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
<script type="text/javascript" src="../../resources/css/new/all.js?ms2.4.7_31064" defer="defer"></script>
</body>
</html>
