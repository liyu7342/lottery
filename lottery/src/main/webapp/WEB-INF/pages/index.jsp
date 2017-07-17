<!DOCTYPE html>
<html lang="zh-cn">
<title>AAA_28_Title</title>
<meta name="Keywords" content=""/>
<meta name="Description" content=""/>
<meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
<meta http-equiv="pragma" content="no-cache"/>
<meta content="0" http-equiv="expires"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
      name="viewport"/>
<meta content="no-cache,must-revalidate" http-equiv="Cache-Control"/>
<meta content="telephone=no, address=no" name="format-detection"/>
<meta name="apple-mobile-web-app-capable" content="yes"/>
<meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"/>
<link href="../../resources/css/new/common.css" rel="stylesheet" type="text/css" />
<link href="../../resources/css/new/mike.chen.css" rel="stylesheet" type="text/css" />

<body class="frame_index">
<div id="doc3" class="yui-t2">
    <div class="leftSider">
        <div class="yui-b">
            <div class="outer_logo" id="outer_logo">
                <img class="logo" src="http://pm10.x.mmm33.us:80/theme/logo/logo_msdid_20150727102235.png"/>
                <div class="ct"><div></div></div>
            </div>
            <div class="bg_brown">
                <div id="account" class="module" >
                    <div class="bd">
                        <table class="g-t1">
                            <tbody>
                            <tr><td class="t" width="77">會員賬號</td><td></td></tr>
                            <tr><td class="t">單注最低</td><td></td></tr>
                            <tr><td class="t">單注最高</td><td></td></tr>
                            <tr><td class="t">單項最高</td><td></td></tr>
                            <tr><td class="t">信用額度</td><td></td></tr>
                            <tr><td class="t">已下金額</td><td></td></tr>
                            <tr><td class="t">信用餘額</td><td></td></tr>
                            <tr><td class="t">最新期數</td><td id="draws"></td></tr>
                            </tbody>
                        </table>
                    </div>

                </div>
                <div class="header_link" id="header_link">
                    <div class="item">
                        <a name="detail" target="main" href="/order/list">下註明細</a>|
                        <a name="history" target="main" href="/history/index">會員歷史</a>|
                        <a name="result" target="main" href="/result/index">開獎結果</a>
                    </div>
                    <div class="item">
                        <a name="information" target="main" href="/user/info">會員資訊</a>|
                        <a name="role" target="main" href="/rule/rules">遊戲規則</a>|
                        <a name="setting" target="main" href="/user/repassword">密碼變更</a>
                    </div>
                </div>
                <div id="">
                    <a name="logout" href="user/logout" class="btnLoginOut">退 出</a>
                </div>
            </div>
            <div id="neworderli" class="module" >
                <div class="hd">
                    <div class="order_refreshs">
                        <a href="#" class="btn11" id="neworder_refresh">刷新</a>
                    </div>
                    <h3>最新訂單</h3>
                </div>
                <div class="bd" id="neworderdiv">
                    <div id="failorderdiv">
                        <span class="fail_order_span">失敗注單</span>
                        <a class="fail_order_count" href='order/faillist' target='main' id="fail_count">
                            0			</a>
                    </div>
                    <ul id="new_orders">
                    </ul>
                </div>
                <div class="ft"></div>
            </div>
            <div id="sure" class="module g-bf" >
                <div class="hd"><h3>下注確認</h3></div>
                <div class="bd">
                    <ul id="sure_list"></ul>
                </div>
                <div class="ft">
                    <input class="btn2" value="確 認" type="button" id="order_agree"/>
                    <a class="ico btn2" id="order_cencel" href="?">放 棄</a>
                </div>
            </div>        </div>
    </div>
    <div class="rightContent">
        <div id="header" class="module">
            <div class="hd">
                <!-- <div class="pm" >
                    <div class="line_switch" id="linesSwitchBtn"></div>
                    <div class="lines_box model hid" id="linesSwitch">
                        <div id="lines_box"></div>
                        <div class="tip"> <span class="red">提示：</span> 反應時間越小，網速越快 </div>
                        <div class="line_action">
                            <input type="button" id="testSpeed" value="測 速" class="btn2" />
                            <input type="button" id="closeSpeed" value="關 閉" class="btn2" />
                        </div>
                    </div>
                </div> -->
                <div class="menu" id="product_menu">
                    <a target="main" href="/plays/tema" class="on" ><span>特碼</span></a>
                    <a target="main" href="/plays/zhengma"  ><span>正碼</span></a>
                    <a target="main" href="/plays/zhengmate"  ><span>正碼特</span></a>
                    <a target="main" href="/plays/zheng1_6"  ><span>正1-6</span></a>
                    <a target="main" href="/plays/lianma"  ><span>連碼</span></a>
                    <a target="main" href="/plays/guoguan"  ><span>過關</span></a>
                    <a target="main" href="/plays/shengxiao"  ><span>生肖</span></a>
                    <a target="main" href="/plays/weishu"  ><span>尾數</span></a>
                    <a target="main" href="/plays/banbo"  ><span>半波</span></a>
                    <a target="main" href="/plays/liuxiao"  ><span>六肖</span></a>
                    <a target="main" href="/plays/texiao"  ><span>特肖</span></a>
                    <a target="main" href="/plays/shengxiaolian"  ><span>生肖連</span></a>
                    <a target="main" href="/plays/weishulian"  ><span>尾數連</span></a>
                    <a target="main" href="/plays/buzhong"  ><span>不中</span></a>
                </div>
            </div>
        </div>		<!-- <div class="gfm gfml"></div><div class="gfm gfmr"></div> -->
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <iframe id="main" name="main" class="main" src="/plays/tema" allowTransparency="true" frameborder="0" scrolling="yes"></iframe>
                </div>
            </div>
        </div>
    </div>


</div>

<script type="text/javascript">
    var global_info =${info};
    var global_version_num = 6;
    var global_lines = [];
</script>
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
<script type="text/javascript" src="../../resources/css/new/all.js?ms2.4.7_31064" defer="defer"></script>
</body>
</html>