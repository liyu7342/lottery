
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
    <title>f2213 - A28</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resource/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="huiyuan" >
<div id="doc3" class="yui-t2 fixh">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <style>
                        html{overflow-y:hidden;}
                    </style>
                    <div id="huiyuan" class="module">
                        <div class="hd g-tm">
                            <form id="form1" method="GET" action="/user/index">
                                <input type='hidden' name='op' value="slt">
                                <ul>
                                    <li><h2 class="g-tit">會員
                                    </h2></li>
                                    <li>
                                        <select class="s" name="keywordstatus">
                                            <option value=''  selected="selected">全部</option>
                                            <option value='1' >啟用</option>
                                            <option value='0' >停用</option>
                                            <option value='2' >停押</option>
                                            <option value='3' >禁止登錄</option>
                                        </select>&nbsp;
                                        <input type="text" name="keyword" size="12" value="請輸入名稱/賬號" class="gray">
                                        <input type="submit" class="btn10" value="查詢"/>
                                    </li>
                                    <li><h2><a class="btn10 mt red" href='/member/info?op=create&id=8955'>新增</a>&nbsp;&nbsp;
                                        <a id="batchDel" class="btn9 mt red" level="5" href="javascript:void(0)">批量刪除</a>        </h2></li>
                                </ul></form>
                            <div class="fr">
                                <span class="ico">第一頁</span><span class="ico i2">上一頁</span><input type="hidden" value="0" id="buttontype" />
                                第<input value="1" id="pageid" type="text" class="pt" onBlur="javascript:var type=document.getElementById('buttontype').value;document.getElementById('buttontype').value=0;if(type == 0){if(event.keyCode==13){return;}if(isNaN(parseInt(this.value)) || parseInt(this.value)>1){alert('您輸入的數字衹能在 1 ～ 1之間，請重新輸入');document.getElementById('pageid').value=1;return false;}if(this.defaultValue != this.value){location.href='http://pm10.x.mmm33.us:80/msdid63242a_8955/account/member_list.htm?pageId='+parseInt(this.value);}}" onkeydown="javascript:if(event.keyCode==13){document.getElementById('buttontype').value=1;if(isNaN(parseInt(this.value)) || parseInt(this.value)>1){alert('您輸入的數字衹能在 1 ～ 1之間，請重新輸入');document.getElementById('pageid').value=1;return false;}location.href='http://pm10.x.mmm33.us:80/msdid63242a_8955/account/member_list.htm?pageId='+parseInt(this.value);return false;}"/>
                                頁 &nbsp;&nbsp;共1頁<span class="ico i3">下一頁</span><span class="ico i4">最後一頁</span>        &nbsp;</div>
                        </div>
                        <div class="bd">
                            <table class="g-t1 g-t2">
                                <thead><tr>
                                    <td id="batchDelSelectAll"><input type="checkbox" name='checkAllAccount'/></td>
                                    <td>在線</td>
                                    <td>會員賬號</td>
                                    <td>信用額度</td>
                                    <td>盤口</td>

                                    <td>代理%</td>
                                    <td>狀態</td>
                                    <td>新增日期</td>
                                    <td class="r">功能</td>
                                </tr></thead>
                                <tbody>
                                <#list user as obj>
                                <tr level="5">

                                    <th><input style='display:none;' type='checkbox' name='delAccountAll' value='${obj.id}' /></th>
                                    <td class="offline" id="${obj.id}"></td>
                                    <td class="bg tl">${obj.name}&nbsp;&nbsp;</td>
                                    <td>${obj.credits}</td>
                                    <td>${obj.handicap}</td><td>0</td>

                                    <td>${obj.status}</td>
                                    <td>2017-05-30</td>
                                    <td><a class='a_btm_line' act='tingyong' pid=8955 tid='${obj.id}' page='1' href='member_list.htm'>停用</a>/&nbsp;<a class='a_btm_line' act='tingya' pid=8955 tid=24657 page='1' href='member_list.htm'>停押</a>/&nbsp;<a class='a_btm_line' href='member_create.htm?op=upd&id=24657&pageId=1&keywordstatus=1&keyword=&level=5&parentid=0'>修改</a></td>
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
        <div class="yui-b">
            <div id="userli" curl="5" class="module g-li">
                <div class="hd g-tif">
                    <h3>賬號管理<span>數量</span></h3>
                </div>
                <div class="bd">
                    <ul class="g-hover">
                        <li><a curl='0' href='admin_list.htm'>管理員</a><cite>0</cite></li><li><a curl='5' href='/user/index'>會員</a><cite>1</cite></li>        </ul>
                </div>
                <div class="ft">
                    <p>在線會員數：0</p>
                    <p>在線經銷商：1</p>
                    <div class="dotbg"></div>
                </div>
            </div>        </div>
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
        draw_refersh: 20000, //設置開關盤刷新頻率
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

