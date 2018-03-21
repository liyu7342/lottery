<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = 'pm10.x.mmm33.us';
        window.gms_fcorp = parseInt("0", 10);
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
    <title>${title_userAccount!''} - X6</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="huiyuan">
<div id="doc3" class="yui-t2">
    <div id="bd">
        <div id="yui-main" style="margin-left:3px;">
            <div class="yui-b" style="margin-left:3px;">
                <div class="yui-g">
                    <style>
                        html {
                            overflow-y: hidden;
                        }
                    </style>
                    <div id="" class="module">
                        <div class="hd g-tm">

                            <ul>
                                <li><h2 class="g-tit">开奖結果
                                </h2></li>
                            </ul>
                            <div class="fr">
                                ${page}
                            </div>
                        </div>
                        <div class="bd">
                            <table class="g-t1">
                                <thead>
                                <tr>
                                    <td></td>
                                    <td>期数</td>
                                    <td>開獎結果</td>
                                    <td>總分</td>
                                    <td>特碼單雙</td>
                                    <td>特碼大小</td>
                                    <td>合數單雙</td>
                                    <td>總分單雙</td>
                                    <td class="r">總分大小</td>
                                </tr>
                                </thead>
                                <tbody>
                                <#list handicaps as obj>
                                    <tr level="5">

                                        <td>${obj_index+1!''}</td>
                                        <td class="bg tl">${obj.riqi}&nbsp;&nbsp;</td>
                                        <td class="bl">

                                            <em class="ico n${obj.no1!''}"></em>${obj.xiaoName1!''}
                                            <em class="ico n${obj.no2!''}"></em>${obj.xiaoName2!''}
                                            <em class="ico n${obj.no3!''}"></em>${obj.xiaoName3!''}
                                            <em class="ico n${obj.no4!''}"></em>${obj.xiaoName4!''}
                                            <em class="ico n${obj.no5!''}"></em>${obj.xiaoName5!''}
                                            <em class="ico n${obj.no6!''}"></em>${obj.xiaoName6!''}

                                            <span><#if obj.tema??>+</#if></span> <em class="ico n${obj.tema!''}"></em>
                                            <font
                                                    class="red">${obj.texiaoName!''}</font>

                                        </td>
                                        <td>${obj.zongfen!''}</td>
                                        <td>${obj.teDanshuang!''}</td>
                                        <td>${obj.teDaxiao!''}</td>
                                        <td>${obj.heDanshuang!''}</td>
                                        <td>${obj.zongDanshuang!''}</td>
                                        <td>${obj.zongDaxiao!''}</td>

                                    </tr>
                                </#list>
                                </tbody>
                            </table>

                            <input type="hidden" name="drawstatus" value="1">
                            <input type="hidden" name="delDownLine" value="1">
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
        </div>
    </div>
</div>
<script type="text/javascript">
    function page(pageid,pagesize,keyword){
        location.href="/result/index2?pageId="+pageid;
    }
    window.setting = {
        login_path: '/msdid63242a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 200000, //設置開關盤刷新頻率
        log4js_type: 0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

