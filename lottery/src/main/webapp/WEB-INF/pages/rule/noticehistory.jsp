
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = '';
        try{if(domain){document.domain = domain;}}catch(x){domainOK = 0;}
    </script>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>${title_userAccount!''} - X6</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
</head>
<body class="notice">
<div id="htmlcover" style="background-color:rgb(255, 255, 255);filter:alpha(opacity=0);opacity:0;position:absolute;top:0pt;left:0pt;z-index:5;display:block;width:100%;height:100%;"></div>
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <form name="frmAction" method="POST"  actType="noticehistory" >
                        <div class="requestData noticehistory">
                            <table ><tbody movod="movod">
                            <tr><th style="width:14%">時間</th><th>公告詳情</th></tr>
                                <tbody class="more_ann_box">
                              <#list noticeList as notice>
                                <tr onmouseover="this.className='new_odd'" onmouseout="this.className=''" >
                                    <td>${notice.createDate?string("yyyy-MM-dd HH:mm:ss")}</td>
                                    <td style="text-align:left;text-indent:2em;word-break: break-all;">${notice.content!''}</td>
                                </tr>
                              </#list>
                                </tbody></table>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <div id="ft">
    </div>
</div>

<script type="text/javascript">
    window.setting = {
        login_path: '/msdid63213790f/user/login.html', //登錄路徑
        odds_refersh: 60000, //頁面的賠率刷新頻率,默認改為 60秒
        password_need: false, //是否開啟密碼登陸加密
        marqueeFresh: 60000, //設置跑馬燈頻率為60秒
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms${JSVersion!''}" defer="defer"></script>
</body>
</html>

