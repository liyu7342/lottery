
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
<body class="admin_create" >
<div id="doc3" class="yui-t2 fixh">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="admcreate" class="module">
                        <div class="hd"><h2 class="g-tit">
                            新增管理員
                            <input type="button" class="btn1 cs" onclick="location.href='../account/admin_list.htm'" value="返回"/></h2></div>
                        <div class="bd g-new">
                            <div class="g-tif"><h3>基本資料設定 </h3></div>
                            <form id="create" method="post" action="admin_create.htm">
                                <table class="g-t1 g-t2 t1">
                                    <tbody nomovod><tr>
                                        <td>名稱</td>
                                        <td id="c_username">
                                            <input type="text" valid='name' maxlength="16" name="__sys_user_userName" value=""
                                            />
                                        </td>
                                        <td>賬號</td>
                                        <td><input type="text" valid='account' maxlength="12" name="__sys_user_userAccount" value=""
                                        /> 1-12個數字或字母字符</td>
                                        <td> 狀態</td>
                                        <td><select class="w4" name="sys_user_status"  >
                                            <option value='1'  selected="selected">啟用</option>
                                            <option value='0' >停用</option>
                                            <option value='2' >停押</option>
                                        </select></td>
                                    </tr>
                                    <tr>
                                        <td> 密碼</td>
                                        <td><input type="password" valid="password' " maxlength="12" name="sys_user_password" value=""/></td>
                                        <td>確認密碼</td>
                                        <td colspan="3"><input type="password" valid="password' " maxlength="12" name="sys_user_repassword2" value=""/> 6-12位數字和字母組成</td>
                                    </tr>
                                    </tbody></table>
                                <table class="g-t1 g-t2 mt t2" id='permission_body'>
                                    <thead>
                                    <th><label><input type="checkbox" value="0" checked="checked"  />全選</label></th>
                                    <td colspan="8">設置權限</td>
                                    </thead>
                                    <tbody nomovod><tr>
                                        <th><label><input type="checkbox" value="01" checked="checked"  />賬號管理</label></th><th><label><input type="checkbox" value="03" checked="checked"  />收付統計</label></th><th><label><input type="checkbox" value="04" checked="checked"  />操盤記錄</label></th><th><label><input type="checkbox" value="05" checked="checked"  />報表查詢</label></th><th><label><input type="checkbox" value="07" checked="checked"  />開獎管理</label></th><th><label><input type="checkbox" value="08" checked="checked"  />注單數據</label></th><th><label><input type="checkbox" value="09" checked="checked"  />系統設定</label></th>  </tr>
                                    </tbody>
                                </table>

                                <div class="g-tn"><input type="submit" class="btn2" value="確 定"/>
                                    <input value="取 消" class="btn2" type="reset" onclick="location.href='../account/admin_list.htm'"/>
                                    <input type="hidden" name="id" value='8955'/>
                                    <input type="hidden" name="op" value='create'/>
                                    <input type="hidden" name="save" value="1"/>
                                    <input type="hidden" name="sys_user_permission"/>
                                    <input type="hidden" name="requestUrl" value='account/admin_list.htm'/>

                                </div>
                            </form>
                        </div>
                        <div class="ft"></div>
                    </div>                </div>
            </div>
        </div>
        <div class="yui-b">
            <div id="userli" curl="0" class="module g-li">
                <div class="hd g-tif">
                    <h3>賬號管理<span>數量</span></h3>
                </div>
                <div class="bd">
                    <ul class="g-hover">
                        <li><a curl='0' href='admin_list.htm'>管理員</a><cite>0</cite></li><li><a curl='5' href='member_list.htm'>會員</a><cite>1</cite></li>        </ul>
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

