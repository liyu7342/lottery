
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = 'pm10.x.mmm33.us';
        window.gms_fcorp = parseInt("0",10);
        try{if(domain){document.domain = domain;}}catch(x){domainOK = 0;}
        var cmset = {token:"",cometUrl: '',cometAction:(domainOK ? '' : 0) ,asname: ''};</script>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>${user.account!''} - A28</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


    <script type="text/javascript" charset="utf-8">
        var header_info = {"status":2,"calc_status":-1,"marquee":"欢迎进入A28 ! 2017年香港六合彩第080期開獎時間為：2017年7月11日（星期2）21:30，本公司於開獎日17:00至17:40開盤，21:30開獎前收盤。如有異動以香港馬會公佈為準!! 敬告：投注後請查看下注明細，確認注單是否交易成功，以免重複下注，所有注單恕不更改，本公司對開獎後的投注均視無效,不便之處敬請諒解","lines":["http:\/\/pm10.x.mmm33.us\/msdid63242a_8955\/lines.htm","http:\/\/pm10.mmm11.us\/msdid63242a_8955\/lines.htm","http:\/\/pm10.a.mmm55.us\/msdid63242a_8955\/lines.htm","http:\/\/pm10.x.mmm44.us\/msdid63242a_8955\/lines.htm","http:\/\/pm10.mmm22.us\/msdid63242a_8955\/lines.htm"],"time_stamp":"20170712084830"};
        function sysInfo(){
            return {chat:''};
        };
    </script>

</head>
<body class="frame_index" >
<style type="text/css">html,body{overflow:hidden;}</style>
<div id="doc3" class="yui-t2">
    <div id="hd">
        <div id="adminheader" class="module" >
            <div class="hd">
                <img class="logo" src="http://pm10.x.mmm33.us:80/theme/logo/logo_msdid_20150727102235.png"/>
                <div class="ct"><div></div></div>
            </div>
            <div class="bd">
                <div class="ps"><div class="h o">
                    <marquee onmouseout="this.start()" onmouseover="this.stop()" scrollamount="3" behavior="scroll" id="marquee" title="點擊查看更多公告"></marquee>
                </div>
                    <div class="rt">賬號:${user.userName!''},管理员</div>
                    <a act="logout" href="/user/logout" class="ico">退 出</a>
                </div>

                <div class="pm gms_pm">
                    <div id="odds_new" title="點擊顯示更多該公司的最新變化的賠率" class="pl gms_ctl" level="4" time="60000">
                        <ul></ul>
                        <div sound="http://pm10.x.mmm33.us:80/theme/gray/media/msg.mp3"></div>
                    </div>
                    <div id="rptprg" class="hid pl gms_ctl">
                        <span class="loadding_small"></span>
                        <span class="progress">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;正在開獎計算中，目前進度為<span id='progress'>0</span>%，請不要刷新頁面!</span>
                    </div>
                    <!--線路切換-->
                    <div class="line_switch" id="linesSwitchBtn" ></div>
                </div>
            </div>
            <div class="lines_box model hid" id="linesSwitch">
                <div id="lines_box"></div>
                <div class="tip"> <span class="red">提示：</span> 反應時間越小，網速越快 </div>
                <div class="line_action">
                    <input type="button" id="testSpeed" value="測 速" class="btn2" />
                    <input type="button" id="closeSpeed" value="關 閉" class="btn2" />
                </div>
            </div>
            <div class="ft">
                <ul class="clearfix" id="nav">
                    <li ><a target="main" href="/handicap/index">盘口管理</a></li>
                    <li ><a target='main' href="/handicap/openindex">開獎管理</a></li>
                    <li ><a target='main' href="http://bmwbmw.6665432.com/fixtures/">開獎日期</a></li>
                    <li ><a target='main' href="/odds/temaa?isDefault=0&handicap=A">(A盘)賠率設置</a></li>
                    <li ><a target='main' href="/odds/temaa?isDefault=0&handicap=B">（B盘）賠率設置</a></li>
                    <li ><a target='main' href="/odds/temaa?isDefault=0&handicap=C">（C盘）賠率設置</a></li>
                    <li ><a target='main' href="/user/index">賬號管理</a></li>
                    <li ><a target='main' href="/statis/statis?category_id=00">收付統計</a></li>
                    <li ><a target='main' href="/oper/index">操作記錄</a></li>

                    <li ><a target='main' href="/result/index" act='result'>開獎結果</a></li>
                    <li ><a target='main' href="/user/password1">密碼變更</a></li>
                </ul>
            </div>
        </div>   </div>
    <div id="bd" class="g-fm"><div class="gfm gfml"></div><div class="gfm gfmr"></div>
        <div id="yui-main">
            <div class="yui-b g-w">
                <div class="yui-g">
                    <iframe id="main" name="main" class="main" src="/rule/notice" allowTransparency="true" frameborder="0" scrolling="yes"></iframe>
                </div>
            </div>
        </div>
    </div>
    <div id="ft">
        <div id="drkusukp" class="module">
            <div class="hd">
                <h2 class="g-tit">新增期數</h2>
            </div>
            <div class="bd">
                <form action="" method="post">
                    <table class="g-t1 g-t2 tl">
                        <thead>
                        <tr><td>項目</td><td class="r">內容</td></tr>
                        </thead>
                        <tbody nomovod>
                        <td>期數名稱</td>
                        <td>
                            <input name="name" valid="draw" value="" maxlength="8"/>
                        </td>
                        </tr>
                        <tr>
                            <td>非特碼<br/>停押時間</td>
                            <td>
                                <span name='draw_dt_fix'> 年  月  日 </span>
                                <input name="nth" valid="hour" value="" maxlength="2"/> 時
                                <input name="ntm" valid="minute" value="" maxlength="2"/> 分
                            </td>
                        </tr>
                        <tr>
                            <td>關盤時間</td>
                            <td>
                                <span name='draw_dt_fix'> 年  月  日 </span>
                                <input name="oth" valid="hour" value="" maxlength="2"/> 時
                                <input name="otm" valid="minute" value="" maxlength="2"/> 分
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="g-tn">
                        <input type="submit" name="submit" class="btn2" value="確 定"/>
                        <input type="button" name="cancel" class="btn2" value="取 消">
                    </div>
                </form>
            </div>
            <div class="ft">
            </div>
        </div>        <div id="loading" class="module">
        <div class="hd"><iframe></iframe></div>
        <div class="bd"><img title="數據加載中..." src="http://pm10.x.mmm33.us:80/theme/gray/media/loading.gif"/></div>
        <div class="ft"></div>
    </div>        <div id="nepeli" class="module">
        <div class="hd"><h2 class="g-tit"><span>本公司</span>最新賠率</h2></div>
        <div class="bd">
            <table class="g-t1 g-t2">
                <thead><tr><td>序號</td><td>公司</td><td>玩法</td><td>號碼</td><td>賠率</td><td>序號</td><td>公司</td><td>玩法</td><td>號碼</td><td class="r">賠率</td></tr></thead>
                <tbody>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                <tr><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td><td class="bg">1</td><td>JR</td><td>正碼</td><td>15</td><td>42.5</td></tr>
                </tbody>
            </table>
            <div class="g-tn"><input type="button" class="btn2" value="關 閉"></div>
        </div>
        <div class="ft"></div>
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
<script type="text/javascript" src="/chat/webchat/js/customer.js" defer="defer"></script>
<!--<script type="text/javascript">
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src ='/chat/webchat/js/customer.js?v='+(+new Date());
    document.body.appendChild(script);
</script>-->
</body>
</html>

