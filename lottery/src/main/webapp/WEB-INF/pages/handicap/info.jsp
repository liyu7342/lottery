
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
            <div class="yui-b" style="margin-left:3px;">
                <div class="yui-g" >
                    <div id="qishu" class="module">
                        <form id="create" method="post" action="/handicap/save">
                            <div class="hd g-tm">
                                <ul>
                                    <li><h2 class="g-tit">新增盘口</h2></li>
                                    <li><a class="btn1 cs"  onclick="location.href='/handicap/index';return false;" href="javascript:void(0)">返回</a></li>
                                </ul>
                            </div>
                            <div class="bd g-new">
                                <div class="g-tif"><h3>基本資料設定</h3></div>
                                <table class="g-t1 g-t2 t1">
                                    <tbody>
                                    <tr>
                                        <td>期数</td>
                                        <td id="c_username"><input type="text" valid='name' maxlength="16" name="qishu" value="${(entity.qishu)!''}" /></td>
                                        <td>状态</td>
                                        <td><label id="">${(entity.status)!''}</label></td>

                                    <tr>
                                        <td>自动开盘时间</td>
                                        <td><input type="text" valid="credit"   size="8" name="opentime" placeholder="" value="${(entity.opentime?string("yyyy-MM-dd HH:mm:ss"))!''}" class="gray"/>
                                        </td>

                                        <td>特码封盘时间</td>
                                        <td>
                                            <input type="text" valid="credit"  size="8" name="temaclosetime" placeholder="" value="${(entity.temaclosetime?string("yyyy-MM-dd HH:mm:ss"))!''}" class="gray"/>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td>正码封盘时间</td>
                                        <td>
                                            <input type="text" valid="credit" title="0~0" name="zhengmaclosetime" placeholder="" value="${(entity.zhengmaclosetime?string("yyyy-MM-dd HH:mm:ss"))!''}" class="gray"/>
                                        </td>
                                        <td colspan="2">
                                        </td>
                                    </tr>
                                    </tbody></table>

                                <div class="g-tn"><input type="submit" name="submit" class="btn2" value="確 定"/>
                                    <input value="取 消" class="btn2" type="reset" onclick="location.href='/handicap/index'"/></div>

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

