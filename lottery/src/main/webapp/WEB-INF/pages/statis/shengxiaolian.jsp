
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
    <title>${user.account} - X6</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="shengxiaolian" >
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
                                    <div class="n1 g-rl"><strong>收付統計</strong> <a class="btn6 red" href="/statis/short_cover_list?game_id=040,039,038,037,036,035">補倉明細</a> <select name="type">
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

                        <input type="hidden" name="category_id" value='13'>
                        <input type="hidden" name="level" value='2'>
                        <table class="g-tl">
                            <tbody nomovod>
                            <tr>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">二肖連(中)
                                        <button class="gms_ctl" to="duobu.htm?game_id=035" act="db" gid="035"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="035">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetails035 as detail>
                                        <tr id="${detail.no!''}">
                                            <td>${detail_index+1!''}</td>
                                            <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=035&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                            <td>${detail.shareTotal?int}</td>
                                            <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=035&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                        </tr>
                                        </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal035!'0'}</td>
                                            <td>${buhuo035!'0'}</td>
                                        </tr>
                                        </tfoot>
                                        <tr><td colspan="3"></td><td><a href="javascript:void(0);" to='tjlianmamingxi.htm?game_id=035&pageId=2' op='more'>更多</a></td></tr>
                                    </table>
                                </td>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">二肖連(不中)
                                        <button class="gms_ctl" to="duobu.htm?game_id=036" act="db" gid="036"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="036">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetails036 as detail>
                                            <tr id="${detail.no!''}">
                                                <td>${detail_index+1!''}</td>
                                                <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=036&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                <td>${detail.shareTotal?int}</td>
                                                <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=036&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal036!'0'}</td>
                                            <td>${buhuo036!'0'}</td>
                                        </tr>
                                        </tfoot>
                                    </table>
                                </td>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">三肖連(中)
                                        <button class="gms_ctl" to="duobu.htm?game_id=037" act="db" gid="037"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="037">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetails037 as detail>
                                            <tr id="${detail.no!''}">
                                                <td>${detail_index+1!''}</td>
                                                <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=037&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                <td>${detail.shareTotal?int}</td>
                                                <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=037&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal037!'0'}</td>
                                            <td>${buhuo037!'0'}</td>
                                        </tr>
                                        </tfoot>
                                        <tr><td colspan="3"></td><td><a href="javascript:void(0);" to='tjlianmamingxi.htm?game_id=037&pageId=2' op='more'>更多</a></td></tr>
                                    </table>
                                </td>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">三肖連(不中)
                                        <button class="gms_ctl" to="duobu.htm?game_id=038" act="db" gid="038"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="038">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetails038 as detail>
                                            <tr id="${detail.no!''}">
                                                <td>${detail_index+1!''}</td>
                                                <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=038&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                <td>${detail.shareTotal?int}</td>
                                                <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=038&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal038!'0'}</td>
                                            <td>${buhuo038!'0'}</td></tr>
                                        </tfoot>
                                    </table>
                                </td>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">四肖連(中)
                                        <button class="gms_ctl" to="duobu.htm?game_id=039" act="db" gid="039"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="039">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetails039 as detail>
                                            <tr id="${detail.no!''}">
                                                <td>${detail_index+1!''}</td>
                                                <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=039&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                <td>${detail.shareTotal?int}</td>
                                                <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=039&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal039!'0'}</td>
                                            <td>${buhuo039!'0'}</td>
                                        </tr>
                                        </tfoot>
                                        <tr><td colspan="3"></td><td><a href="javascript:void(0);" to='tjlianmamingxi.htm?game_id=039&pageId=2' op='more'>更多</a></td></tr>
                                    </table>
                                </td>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">四肖連(不中)
                                        <button class="gms_ctl" to="duobu.htm?game_id=040" act="db" gid="040"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="040">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetails040 as detail>
                                            <tr id="${detail.no!''}">
                                                <td>${detail_index+1!''}</td>
                                                <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=040&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                <td>${detail.shareTotal?int}</td>
                                                <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=040&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal040!'0'}</td>
                                            <td>${buhuo040!'0'}</td>
                                        </tr>
                                        </tfoot>
                                    </table>
                                </td>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">五肖連(中)
                                        <button class="gms_ctl" to="duobu.htm?game_id=054" act="db" gid="054"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="054">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetails054 as detail>
                                            <tr id="${detail.no!''}">
                                                <td>${detail_index+1!''}</td>
                                                <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=054&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                <td>${detail.shareTotal?int}</td>
                                                <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=054&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal054!'0'}</td>
                                            <td>${buhuo055!'0'}</td>
                                        </tr>
                                        </tfoot>
                                        <tr><td colspan="3"></td><td><a href="javascript:void(0);" to='tjlianmamingxi.htm?game_id=054&pageId=2' op='more'>更多</a></td></tr>
                                    </table>
                                </td>
                                <td class="ts">
                                    <div class="g-tif"><h3 class="m">五肖連(不中)
                                        <button class="gms_ctl" to="duobu.htm?game_id=055" act="db" gid="055"  type="button">多補</button></h3></div>
                                    <table class="g-t1 g-t2" gid="055">
                                        <thead>
                                        <tr><td>序號</td><td>玩法</td><td>佔成收入</td><td class="r">補倉</td></tr>
                                        </thead>
                                        <tbody>
                                        <#list orderDetails055 as detail>
                                            <tr id="${detail.no!''}">
                                                <td>${detail_index+1!''}</td>
                                                <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=055&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                                <td>${detail.shareTotal?int}</td>
                                                <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=055&amt=${detail.buhuo!'0'}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                            </tr>
                                        </#list>
                                        </tbody>
                                        <tfoot>
                                        <tr><td colspan="2">總計</td>
                                            <td>${shareTotal055!'0'}</td>
                                            <td>${buhuo055!'0'}</td>
                                        </tr>
                                        </tfoot>
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
            <div class="bd rb">Copyright 2008-2018 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid63213790a/account/login.html', //登錄路徑
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

