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
    <title>f3311 - A28</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="tjlianma" >
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="shoufutongji" class="module">
                        <div class="hd">
                            <table class="g-jft"><tbody nomovod><tr id="total_plays">
                                <td id="00" class="sp wide"><a href="statis.htm?category_id=00"><span>特碼</span><br/><sup title="總佔成收入">59,929</sup></a></td>
                                <td id="01" class="sp"><a href="tjzhengma.htm?category_id=01"><span>正碼</span><sup title="總佔成收入">869</sup></a></td>
                                <td id="02"  class="sp wide"><a href="tjzhengmate.htm?category_id=02&game_id=002"><span>正特</span><sup title="總佔成收入">5</sup></a></td>
                                <td id="03" class="on sp"><a href="tjlianma.htm?category_id=03|04"><span>連碼</span><sup title="總佔成收入">5,100</sup></a></td>
                                <td id="05" class="sp"><a href="guoguan.htm?category_id=05"><span>過關</span><sup title="總佔成收入">0</sup></a></td>
                                <td id="06"  class="sp wide"><a href="shengxiao.htm?category_id=06&game_id=014"><span>生肖</span><sup title="總佔成收入">84,688</sup></a></td>
                                <td id="07" class="sp"><a href="weishu.htm?category_id=07"><span>尾數</span><sup title="總佔成收入">1,470</sup></a></td>

                                <td id="08" class="sp"><a href="banbo.htm?category_id=08"><span>半波</span><sup title="總佔成收入">405</sup></a></td>
                                <td id="12" class="sp"><a href="texiao.htm?category_id=12"><span>特肖</span><sup title="總佔成收入">10,100</sup></a></td>
                                <td id="09" class="sp"><a href="liuxiao.htm?category_id=09"><span>六肖</span><sup title="總佔成收入">2,151</sup></a></td>
                                <td id="10" class="sp"><a href="liangmian.htm?category_id=10"><span>兩面</span><sup title="總佔成收入">8,785</sup></a></td>
                                <td id="11"  class="sp"><a href="sebo.htm?category_id=11"><span>色波</span><sup title="總佔成收入">1,552</sup></a></td>
                                <td id="13" class="sp"><a href="shengxiaolian.htm?category_id=13"><span>生連</span><sup title="總佔成收入">16,748</sup></a></td>
                                <td id="14" class="sp narrow"><a href="weishulian.htm?category_id=14"><span>尾連</span><sup title="總佔成收入">90</sup></a></td>
                                <td id="15" class="sp"><a href="wubuzhong.htm?category_id=15&game_id=047"><span>不中</span><sup title="總佔成收入">1,839</sup></a></td>
                            </tr></tbody></table>
                        </div>
                        <div class="bd">
                            <div class="n2 g-tm">
                                <form>
                                    <div class="n1 g-rl"><strong>收付統計</strong> <a class="btn6 red" href="short_cover_list.htm?game_id=010,009,008">補倉明細</a> <select name="type">
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
                    </div>                <div id="tjlianma" class="module g-mt0">
                    <div class="hd"></div>
                    <div class="bd">

                        <input type="hidden" name="category_id" value='03|04'>
                        <input type="hidden" name="level" value='3'>
                        <table class="g-tl">
                            <tbody nomovod>
                            <tr>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">二全中
                                        <button class="gms_ctl" to="duobu.htm?game_id=008" act="db" gid="008"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="008">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                            <#list orderDetails as detail>
                                            <tr id="${detail.no!''}">
                                                <td>${detail_index+1!''}</td>
                                                <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=008&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                <td>${detail.shareTotal?floor}</td>
                                                <td><a href="javascript:void(0);" to="short_covering.htm?number=${detail.no!''}&game_id=008&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                            </tr>
                                            </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal!'0'}</td>
                                            <td>0</td></tr>
                                        </tfoot>
                                        <tr class="hid"><td colspan="3"></td><td><a href="javascript:void(0);" to='/statis/tjlianmamingxi?game_id=008&pageId=2' op='more'>更多</a></td></tr>
                                    </table>
                                </td>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">二中特
                                        <button class="gms_ctl" to="duobu.htm?game_id=009" act="db" gid="009"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="009">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetails009 as detail>
                                            <tr id="${detail.no!''}">
                                                <td>${detail_index+1!''}</td>
                                                <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=009&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                <td>${detail.shareTotal?floor}</td>
                                                <td><a href="javascript:void(0);" to="short_covering.htm?number=${detail.no!''}&game_id=009&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal009!'0'}</td>
                                            <td>0</td></tr>
                                        </tfoot>
                                    </table>
                                </td>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">特串
                                        <button class="gms_ctl" to="duobu.htm?game_id=010" act="db" gid="010"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="010">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetails010 as detail>
                                            <tr id="${detail.no!''}">
                                                <td>${detail_index+1!''}</td>
                                                <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=010&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                <td>${detail.shareTotal?floor}</td>
                                                <td><a href="javascript:void(0);" to="short_covering.htm?number=${detail.no!''}&game_id=010&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal010!'0'}</td>
                                            <td>0</td></tr>
                                        </tfoot>
                                        <tr class="hid"><td colspan="3"></td><td><a href="javascript:void(0);" to='/statis/tjlianmamingxi?game_id=010&pageId=2' op='more'>更多</a></td></tr>
                                    </table>
                                </td>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">三全中
                                        <button class="gms_ctl" to="duobu.htm?game_id=011" act="db" gid="011"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="011">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetails011 as detail>
                                            <tr id="${detail.no!''}">
                                                <td>${detail_index+1!''}</td>
                                                <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=011&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                <td>${detail.shareTotal?floor}</td>
                                                <td><a href="javascript:void(0);" to="short_covering.htm?number=${detail.no!''}&game_id=011&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                            </tr>
                                        </#list>
                                         </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal011!'0'}</td>
                                            <td>0</td></tr>
                                        </tfoot>
                                        <tr class="hid"><td colspan="3"></td><td><a href="javascript:void(0);" to='/statis/tjlianmamingxi?game_id=011&pageId=2' op='more'>更多</a></td></tr>
                                    </table>
                                </td>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">三中二
                                        <button class="gms_ctl" to="duobu.htm?game_id=012" act="db" gid="012"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="012">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetails012 as detail>
                                            <tr id="${detail.no!''}">
                                                <td>${detail_index+1!''}</td>
                                                <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=012&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                <td>${detail.shareTotal?floor}</td>
                                                <td><a href="javascript:void(0);" to="short_covering.htm?number=${detail.no!''}&game_id=012&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal012!'0'}</td>
                                            <td>0</td></tr>
                                        </tfoot>
                                        <tr class="hid"><td colspan="3"></td><td><a href="javascript:void(0);" to='/statis/tjlianmamingxi?game_id=012&pageId=2' op='more'>更多</a></td></tr>
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
        </div>    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid63242a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 20000, //設置開關盤刷新頻率
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>
