
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
    <title>${title_userAccount!''} - X6</title>
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
                    <div id="choose" class="module">

                        <form id="create" method="post" action="">
                            <div class="hd g-tm"><ul><li><h2 class="g-tit">${title}</h2></li></ul></div>
                            <div class="bd g-new">
                                <div class="g-tif"><h3>選擇上級</h3></div>
                                <table class="g-t1 g-t2 g-tm">
                                    <tbody><tr>
                                        <td width="200">請選擇上級</td>
                                        <th class="tl">
                                            <select name="member_parentId">
                                                <option>選擇上級</option>
                                                <#list users as userobj>
                                                    <option value="${userobj.id}">${userobj.account}</option>
                                                </#list>

                                            </select>
                                        </th>
                                    </tr>
                                    </tbody></table>
                                <input type="hidden" name="choose" value="true">
                                <input type="hidden" id="requestUrl" name="requestUrl" value="${reqUrl}">
                            </div>
                        </form>
                        <div class="ft"></div>
                    </div>                </div>
            </div>
        </div>
        <div class="yui-b">
            <div id="userli" curl="5" class="module g-li">
                <div class="hd g-tif">
                    <h3>賬號管理<span>數量</span></h3>
                </div>
                <div class="bd">
                    <ul class="g-hover">
                        <#if user.usertype lt 1>
                            <li><a curl='0' href='/user/index1'>大股東</a><cite>0</cite></li>
                        </#if>
                        <#if user.usertype lt 2>
                            <li><a curl='0' href='/user/index2'>小股東</a><cite>0</cite></li>
                        </#if>
                        <#if user.usertype lt 3>
                            <li><a curl='0' href='/user/index3'>總代理</a><cite>0</cite></li>
                        </#if>
                        <#if user.usertype lt 4>
                            <li><a curl='5' href='/user/index4'>代理商</a><cite>0</cite></li>
                        </#if>
                        <#if user.usertype lt 5>
                            <li><a curl='0' href='/user/index'>會員</a><cite>0</cite></li>
                        </#if>
                    </ul>
                </div>
                <div class="ft">
                    <p>在線會員數：1</p>
                    <p>在線經銷商：3</p>
                    <div class="dotbg"></div>
                </div>
            </div>        </div>
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

