
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
    <title>${user.userName!''} - A28</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="member_create" >
<div id="doc3" class="yui-t2 fixh">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="qishu" class="module">
                        <form id="create" method="post" action="/handicap/open">
                            <div class="hd g-tm">
                                <ul>
                                    <li><h2 class="g-tit">开奖</h2></li>
                                    <li><a class="btn1 cs"  onclick="location.href='/handicap/openindex';return false;" href="javascript:void(0)">返回</a></li>
                                </ul>
                            </div>
                            <div class="bd g-new">
                                <div class="g-tif"><h3>基本資料設定</h3></div>
                                <table class="g-t1 g-t2 t1">
                                    <tbody >
                                    <tr>
                                        <td>期数</td>
                                        <td id="c_username"><label type="text" valid='name' maxlength="16" name="qishu" value="" >${(entity.qishu)!''}</label></td>
                                        <td colspan="5"></td>

                                    <tr>
                                        <td>正码1</td>
                                        <td>正码2</td>
                                        <td>正码3</td>
                                        <td>正码4</td>
                                        <td>正码5</td>
                                        <td>正码6</td>
                                        <td>特码</td>
                                    </tr>
                                    <tr>
                                        <td><input type="text" name="no1" value="${(entity.no1) !''}" /></td>
                                        <td><input type="text" name="no2" value="${(entity.no2) !''}" /></td>
                                        <td><input type="text" name="no3" value="${(entity.no3) !''}" /></td>
                                        <td><input type="text" name="no4" value="${(entity.no4) !''}" /></td>
                                        <td><input type="text" name="no5" value="${(entity.no5) !''}" /></td>
                                        <td><input type="text" name="no6" value="${(entity.no6 )!''}" /></td>
                                        <td><input type="text" name="tema" value="${entity.tema !''}" /></td>
                                    </tr>
                                    </tbody></table>

                                <div class="g-tn"><input type="submit" name="submit" class="btn2" value="確 定"/>
                                    <input value="取 消" class="btn2" type="reset" onclick="location.href='/handicap/openindex'"/></div>

                                <input type="hidden" name="id" value="${(entity.id)!''}"/>
                                <input type="hidden" name="op" value='create'/>

                            </div>
                        </form>
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
        draw_refersh: 200000, //設置開關盤刷新頻率
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

