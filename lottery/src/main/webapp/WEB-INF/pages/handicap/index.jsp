
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
<body class="huiyuan" >
<div id="doc3" class="yui-t2">
    <div id="bd">
        <div id="yui-main" style="margin-left:3px;">
            <div class="yui-b" style="margin-left:3px;">
                <div class="yui-g" >
                    <style>
                        html{overflow-y:hidden;}
                    </style>
                    <div id="" class="module">
                        <div class="hd g-tm">
                            <form id="form1" method="GET" action="/handicap/handicapopen">
                                <input type='hidden' name='op' value="slt">
                                <ul>
                                    <li><h2 class="g-tit">开奖管理
                                    </h2></li>
                                    <li><h2><a class="btn10 mt red" href='/handicap/info?op=create&id='>新增</a>&nbsp;&nbsp;  </h2></li>
                                </ul></form>
                            <div class="fr">
                               ${page}
                            </div>
                        </div>
                        <div class="bd">
                            <table class="g-t1">
                                <thead><tr>
                                    <td id="batchDelSelectAll"><input type="checkbox" name='checkAllAccount'/></td>
                                    <td>期数</td>
                                    <td>正码1</td>
                                    <td>正码2</td>
                                    <td>正码3</td>
                                    <td>正码4</td>
                                    <td>正码5</td>
                                    <td>正码6</td>
                                    <td>特码</td>
                                    <td class="r">功能</td>
                                </tr></thead>
                                <tbody>
                                <#list handicaps as obj>
                                    <tr level="5">

                                        <th><input style='display:none;' type='checkbox' name='delAccountAll' value='${obj.id}' /></th>
                                        <td class="bg tl">${obj.qishu}&nbsp;&nbsp;</td>
                                        <td><em class="ico n${(obj.no1)!''}">${(obj.no1)!''}</em></td>
                                        <td><em class="ico n${(obj.no2)!''}">${(obj.no2)!''}</em></td>
                                        <td><em class="ico n${(obj.no3)!''}">${(obj.no3)!''}</em></td>
                                        <td><em class="ico n${(obj.no4)!''}">${(obj.no4)!''}</em></td>
                                        <td><em class="ico n${(obj.no5)!''}">${(obj.no5)!''}</em></td>
                                        <td><em class="ico n${(obj.no6)!''}">${(obj.no6)!''}</em></td>
                                        <td><em class="ico n${(obj.tema)!''}">${(obj.tema)!''}</em></td>

                                        <td>
                                            <a class='a_btm_line' href='/handicap/info?op=upd&id=${obj.id}&pageId=1&keywordstatus=1&keyword=&level=5'>修改</a></td>
                                    </tr>
                                </#list>
                                </tbody></table>

                            <input type="hidden" name="drawstatus" value="1" >
                            <input type="hidden" name="delDownLine" value="1" >
                        </div>
                        <div class="ft"></div>
                    </div>                </div>
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

