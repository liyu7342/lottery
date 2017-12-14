
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = 'pm10.x.mmm33.us';
        window.gms_fcorp = parseInt("0",10);
        try{if(domain){document.domain = domain;}}catch(x){domainOK = 0;}
    </script>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>${user.account!''} - A28</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="shoufutongji" >
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
                            <div class="n2 g-tm">
                                <form>
                                    <div class="n1 g-rl"><strong>收付統計</strong> <a class="btn6 red" href="short_cover_list.htm?game_id=000">補倉明細</a> <select name="type">
                                        <option value="no" >手動</option>
                                        <option value="10" selected>10</option>
                                        <option value="30" >30</option>
                                        <option value="60" >60</option>
                                        <option value="90" >90</option>
                                    </select>
                                        <input class="tx" value="" id="pulse" disabled="disabled" type="text">
                                        <a class="btn1 red" id="refresh" href="?">更新</a>

                                    </div>
                                </form>
                                <div class="fr">

                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="stops" value='0,0,0,0,0,0,0,0,0,0,0,0,0,0,0'>
                        <div class="ft"></div>
                    </div>
                    <div id="tjlianma" class="module g-mt0">
                    <div class="hd"></div>
                        <div class="bd">

                            <input type="hidden" name="category_id" value='14'>
                            <input type="hidden" name="level" value='3'>
                            <table class="g-tl">
                                <tbody nomovod>
                                <tr>
                                    <td class="ts">
                                        <div class="g-tif"><h3 class="m">二尾連(中)
                                            <button class="gms_ctl" to="duobu.htm?game_id=041" act="db" gid="041"  type="button">多補</button></h3></div>
                                        <table class="g-t1 g-t2" gid="041">
                                            <thead>
                                            <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                            </thead>
                                            <tbody>
                                            <#list orderDetails041 as detail>
                                                <tr id="${detail.no!''}">
                                                    <td>${detail_index+1!''}</td>
                                                    <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=041&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                    <td>${detail.shareTotal?int}</td>
                                                    <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=041&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                                </tr>
                                            </#list>
                                            </tbody>
                                            <tfoot>
                                            <tr><td colspan="2">總計</td>
                                                <td>${shareTotal!'0'}</td>
                                                <td>0</td></tr>
                                            </tfoot>
                                            <tr class="hid"><td colspan="3"></td><td><a href="javascript:void(0);" to='/statis/tjlianmamingxi?game_id=041&pageId=2' op='more'>更多</a></td></tr>
                                        </table>
                                    </td>
                                    <td class="ts">
                                        <div class="g-tif"><h3 class="m">二尾連(不中)
                                            <button class="gms_ctl" to="duobu.htm?game_id=042" act="db" gid="042"  type="button">多補</button></h3></div>
                                        <table class="g-t1 g-t2" gid="042">
                                            <thead>
                                            <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                            </thead>
                                            <tbody>
                                            <#list orderDetails042 as detail>
                                                <tr id="${detail.no!''}">
                                                    <td>${detail_index+1!''}</td>
                                                    <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=042&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                    <td>${detail.shareTotal?int}</td>
                                                    <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=042&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                                </tr>
                                            </#list>
                                            </tbody>
                                            <tfoot>
                                            <tr><td colspan="2">總計</td>
                                                <td>${shareTotal042!'0'}</td>
                                                <td>0</td></tr>
                                            </tfoot>
                                        </table>
                                    </td>
                                    <td class="ts">
                                        <div class="g-tif"><h3 class="m">三尾連(中)
                                            <button class="gms_ctl" to="duobu.htm?game_id=043" act="db" gid="043"  type="button">多補</button></h3></div>
                                        <table class="g-t1 g-t2" gid="043">
                                            <thead>
                                            <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                            </thead>
                                            <tbody>
                                            <#list orderDetails043 as detail>
                                                <tr id="${detail.no!''}">
                                                    <td>${detail_index+1!''}</td>
                                                    <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=043&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                    <td>${detail.shareTotal?int}</td>
                                                    <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=043&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                                </tr>
                                            </#list>
                                            </tbody>
                                            <tfoot>
                                            <tr><td colspan="2">總計</td>
                                                <td>${shareTotal043!'0'}</td>
                                                <td>0</td></tr>
                                            </tfoot>
                                            <tr class="hid"><td colspan="3"></td><td><a href="javascript:void(0);" to='/statis/tjlianmamingxi?game_id=043&pageId=2' op='more'>更多</a></td></tr>
                                        </table>
                                    </td>
                                    <td class="ts">
                                        <div class="g-tif"><h3 class="m">三尾連(不中)
                                            <button class="gms_ctl" to="duobu.htm?game_id=044" act="db" gid="044"  type="button">多補</button></h3></div>
                                        <table class="g-t1 g-t2" gid="044">
                                            <thead>
                                            <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                            </thead>
                                            <tbody>
                                            <#list orderDetails044 as detail>
                                                <tr id="${detail.no!''}">
                                                    <td>${detail_index+1!''}</td>
                                                    <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=044&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                    <td>${detail.shareTotal?int}</td>
                                                    <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=044&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                                </tr>
                                            </#list>
                                            </tbody>
                                            <tfoot>
                                            <tr><td colspan="2">總計</td>
                                                <td>${shareTotal044!'0'}</td>
                                                <td>0</td></tr>
                                            </tfoot>
                                            <tr class="hid"><td colspan="3"></td><td><a href="javascript:void(0);" to='/statis/tjlianmamingxi?game_id=044&pageId=2' op='more'>更多</a></td></tr>
                                        </table>
                                    </td>
                                    <td class="ts">
                                        <div class="g-tif"><h3 class="m">四尾連(中)
                                            <button class="gms_ctl" to="duobu.htm?game_id=045" act="db" gid="045"  type="button">多補</button></h3></div>
                                        <table class="g-t1 g-t2" gid="045">
                                            <thead>
                                            <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                            </thead>
                                            <tbody>
                                            <#list orderDetails045 as detail>
                                                <tr id="${detail.no!''}">
                                                    <td>${detail_index+1!''}</td>
                                                    <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=045&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                    <td>${detail.shareTotal?int}</td>
                                                    <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=045&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                                </tr>
                                            </#list>
                                            </tbody>
                                            <tfoot>
                                            <tr><td colspan="2">總計</td>
                                                <td>${shareTotal045!'0'}</td>
                                                <td>0</td></tr>
                                            </tfoot>
                                            <tr class="hid"><td colspan="3"></td><td><a href="javascript:void(0);" to='/statis/tjlianmamingxi?game_id=045&pageId=2' op='more'>更多</a></td></tr>
                                        </table>
                                    </td>
                                    <td class="ts">
                                        <div class="g-tif"><h3 class="m">四尾連(不中)
                                            <button class="gms_ctl" to="duobu.htm?game_id=046" act="db" gid="046"  type="button">多補</button></h3></div>
                                        <table class="g-t1 g-t2" gid="046">
                                            <thead>
                                            <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                            </thead>
                                            <tbody>
                                            <#list orderDetails046 as detail>
                                                <tr id="${detail.no!''}">
                                                    <td>${detail_index+1!''}</td>
                                                    <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=046&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                    <td>${detail.shareTotal?int}</td>
                                                    <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=046&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                                </tr>
                                            </#list>
                                            </tbody>
                                            <tfoot>
                                            <tr><td colspan="2">總計</td>
                                                <td>${shareTotal046!'0'}</td>
                                                <td>0</td></tr>
                                            </tfoot>
                                            <tr class="hid"><td colspan="3"></td><td><a href="javascript:void(0);" to='/statis/tjlianmamingxi?game_id=046&pageId=2' op='more'>更多</a></td></tr>
                                        </table>
                                    </td>
                                </tr>
                                </tbody>
                            </table>

                        </div>
                    <div class="ft"></div>
                </div>
                </div>
            </div>
        </div>
    </div>
    <div id="ft">
        <div id="footer" class="module">
            <div class="hd rh"></div>
            <div class="bd rb">Copyright 2008-2017 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>    <div id="ampp" class="module g-pp">
        <form id="quick_form">
            <div class="hd"></div>
            <div class="bd">
                <span></span> 賠率：<input type='text' class='tx' id='quick_focus' valid="odds" name='key'/>
            </div>
            <div class="ft">
                <input class="btn2" type='submit' id='quick_submit' value='提交'/>
                <input class="btn2" type='button' id='quick_cencel' value='取消'/>
            </div>
        </form>
    </div>    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid63242a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 200000, //設置開關盤刷新頻率
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

