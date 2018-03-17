
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
    <title>${title_userAccount!''} - A28</title>
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
                                    <div class="n1 g-rl"><strong>收付統計</strong> <a class="btn6 red" href="/statis/short_cover_list?game_id=016">補倉明細</a> <select name="type">
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
                    </div>                <div id="tongjitema" class="module g-mt0">
                    <div class="hd"></div>
                    <div class="bd">
                        <input type="hidden" name="category_id" value='08'>
                        <input type="hidden" name="game_id" value='016'>
                        <input type="hidden" name="time_stamp" value='1499779795,0,0'>
                        <input type="hidden" name="fresh" value='0'>
                        <input type="hidden" name="level"value="${user.usertype!''}">
                        <input type="hidden" name="odds_set" value='S'>
                        <table class="g-t1 g-t2">
                            <thead>
                            <tr>
                                <td>序號</td>
                                <td>玩法</td>
                                <td>數量</td>
                                <td>下注總額</td>
                                <td><em><span class="hc" act="hide">總佔成</span></em></td>
                                <td >佣金收入</td>
                                <td >彩金</td>
                                <td>平均賠率</td>
                                <td id="totalwinlos_td">勝出金額</td>
                                <td>補倉(<span class="red" id="amt">5,000</span>) <button act="db" class="gms_ctl" to="duobu.htm?game_id=000"  type="button">多補</button> </td>
                                <td act="pl">賠率
                                    <select act="qh" class="red">
                                        <option value="S" selected>全部</option>
                                        <option value="A" >A</option>
                                        <option value="B" >B</option>
                                        <option value="C" >C</option>
                                    </select>
                                </td>
                            </tr>
                            </thead>
                            <tbody>
                            <#list orderDetails as detail>
                                <tr>
                                    <td>${(detail_index)+1!''}</td>
                                    <td><a href="javascript:void(0);" to="/order/xiazhumingxi?game_id=${detail.gameType!''}&number=${detail.no!''}&name=${detail.description?url}">${detail.description!''}</a></td>
                                    <td>${detail.orderNum!''}</td>

                                    <td>${detail.amount!''}</td>
                                    <td>${detail.shareTotal?int}</td>
                                    <td>${detail.yongJin?int}</td>
                                    <td>${detail.caiJin?int}</td>
                                    <td>${detail.aveOdds!'0'}</td>

                                    <td>${detail.winAmount?int}</td>
                                    <td><a href="javascript:void(0);" to="/statis/short_covering?number=${detail.no!''}&game_id=${detail.gameType!''}&description=${detail.description?url}" class="red gms_a">${detail.buhuo!'0'}</a></td>
                                    <td><span oddsSet='A'>${detail.aaOdds!''}</span><span oddsSet='B'  class="hid">${detail.baOdds!''}</span><span   oddsSet='C' class="hid">${detail.caOdds!''}</span></td>
                                </tr>
                            </#list>
                            </tbody>
                            <tfoot><tr>
                                <td></td>
                                <td>總計</td>
                                <td>${orderNum!'0'}</td>
                                <td>${amount!'0'}</td>
                                <td>${shareTotal?int}</td>
                                <td >${yongjin?int}</td>
                                <td class="hid"></td>
                                <td class="hid" >0</td>
                                <td class="hid"></td>
                                <td colspan="10"></td>
                            </tr></tfoot>
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

