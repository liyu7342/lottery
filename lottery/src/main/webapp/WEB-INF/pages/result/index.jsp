<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = '';
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
    <title>f2211 - A28</title>
    <link rel="stylesheet" href="../../resources/css/new/common.css" type="text/css">
    <link rel="stylesheet" href="../../resources/css/new/mike.chen.css?${JSVersion!''}" type="text/css">
</head>
<body class="result">
<div id="htmlcover"
     style="background-color:rgb(255, 255, 255);filter:alpha(opacity=0);opacity:0;position:absolute;top:0pt;left:0pt;z-index:5;display:block;width:100%;height:100%;"></div>
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="kjresult" class="module ">
                        <div class="hd g-tm">
                            <div class="n1">
                                <h2 class="g-tit">開獎結果</h2>
                            </div>
                            <div class="fr">
                                ${page}
                            </div>
                        </div>
                        <div class="bd">
                            <table class="g-t1 t2">
                                <thead>
                                <tr>
                                    <td>開獎日期</td>
                                    <td>開獎結果</td>
                                    <td>總分</td>
                                    <td>特碼單雙</td>
                                    <td>特碼大小</td>
                                    <td>合數單雙</td>
                                    <td>總分單雙</td>
                                    <td class="r">總分大小</td>
                                </tr>
                                </thead>
                                <tbody movod='movod'>
                                <#list handicaps as handicap>
                                <tr>
                                    <td>${handicap.riqi!''}</td>
                                    <td class="bl">

                                        <em class="ico n${handicap.no1!''}"></em>${handicap.xiaoName1!''}
                                        <em class="ico n${handicap.no2!''}"></em>${handicap.xiaoName2!''}
                                        <em class="ico n${handicap.no3!''}"></em>${handicap.xiaoName3!''}
                                        <em class="ico n${handicap.no4!''}"></em>${handicap.xiaoName4!''}
                                        <em class="ico n${handicap.no5!''}"></em>${handicap.xiaoName5!''}
                                        <em class="ico n${handicap.no6!''}"></em>${handicap.xiaoName6!''}

                                        <span><#if handicap.tema??>+</#if></span> <em class="ico n${handicap.tema!''}"></em> <font
                                            class="red">${handicap.texiaoName!''}</font>

                                    </td>
                                    <td>${handicap.zongfen!''}</td>
                                    <td>${handicap.teDanshuang!''}</td>
                                    <td>${handicap.teDaxiao!''}</td>
                                    <td>${handicap.heDanshuang!''}</td>
                                    <td>${handicap.zongDanshuang!''}</td>
                                    <td>${handicap.zongDaxiao!''}</td>
                                </tr>
                                </#list>
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
        <div id="footer" class="module" style="display:none">
            <div class="hd"></div>
            <div class="bd">Copyright 2008-2017 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function page(pageid,pagesize,keyword){
        location.href="/result/index?pageId="+pageid;
    }
    window.setting = {
        login_path: '/msdid63242f/user/login.html', //登錄路徑
        odds_refersh: 60000, //頁面的賠率刷新頻率,默認改為 60秒
        password_need: false, //是否開啟密碼登陸加密
        marqueeFresh: 60000, //設置跑馬燈頻率為60秒
        log4js_type: 0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/css/new/all.js?${JSVersion!''}" defer="defer"></script>
</body>
</html>
