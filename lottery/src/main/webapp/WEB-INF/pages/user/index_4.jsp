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
    <title>${user.account!''} - A28</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="huiyuan">
<div id="doc3" class="yui-t2 fixh">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <style>
                        html {
                            overflow-y: hidden;
                        }
                    </style>
                    <div id="huiyuan" class="module">
                        <div class="hd g-tm">
                            <form id="form1" method="post" action="/user/index4">
                                <input type='hidden' name='op' value="slt">
                                <ul>
                                    <li><h2 class="g-tit">代理
                                    </h2></li>
                                    <li>
                                        <select class="s" name="keywordstatus">
                                            <option value='' selected="selected">全部</option>
                                            <option value='1'>啟用</option>
                                            <option value='0'>停用</option>
                                            <option value='2'>停押</option>
                                            <option value='3'>禁止登錄</option>
                                        </select>&nbsp;
                                        <input type="text" name="keyword" size="12" value="${keyword!''}" class="gray">
                                        <input type="submit" class="btn10" value="查詢"/>
                                    </li>
                                    <li><h2><a class="btn10 mt red" href='/user/userselect?userType=4'>新增</a>&nbsp;&nbsp;
                                        <a id="batchDel" class="btn9 mt red" level="5"
                                           href="javascript:void(0)">批量刪除</a></h2></li>
                                </ul>
                            </form>
                            <div class="fr">
                                <div style="margin-right: 52px;">${page}</div>
                            </div>
                        </div>
                        <div class="bd">
                            <table class="g-t1 g-t2">
                                <thead>
                                <tr>
                                    <td id="batchDelSelectAll"><input type="checkbox" name='checkAllAccount'/></td>
                                    <td>在線</td>
                                    <td>代理賬號</td>
                                    <td>信用額度</td>
                                    <td>盤口</td>
                                    <td>總代理%</td>
                                    <td>代理%</td>
                                    <td>會員數</td>
                                    <td>狀態</td>
                                    <td>新增日期</td>
                                    <td class="r">功能</td>
                                </tr>
                                </thead>
                                <tbody>
                                <#list users as obj>
                                    <tr level="5">

                                        <th><input style='display:none;' type='checkbox' name='delAccountAll'
                                                   value='${obj.id}'/></th>
                                        <td class="offline" id="${obj.id}"></td>
                                        <td class="bg tl"><a href='/user/index?parentid=${obj.id}&level=2'>${obj.account!''}</a>&nbsp;&nbsp;[${obj.userName!''},${obj.parentName!''}]</td>
                                        <td>${obj.credits}</td>
                                        <td>${obj.handicap}</td>
                                        <td>${obj.shareUp!''}</td>
                                        <td>${obj.shareTotal!''}</td>
                                        <td>${obj.memberNumber!''}</td>
                                        <td>
                                            <#if obj.status == 0>
                                                <span class='red'>停用</span>
                                                <#elseif obj.status == 1>
                                                    <span>启用</span>
                                                    <#elseif obj.status == 2>
                                                        <span>停押</span>

                                            </#if>
                                        </td>
                                        <td>
                                            ${obj.createdate?string("yyyy-MM-dd HH:mm:ss")}
                                        </td>
                                        <td><#if obj.status==0>
                                            <a class='a_btm_line' act='qiyong'   pid="${obj.parentid !''}"
                                               tid='${obj.id}' page='1' href='member_list.htm'>启用</a>/&nbsp;<a class='a_btm_line' act='tingya'   pid="${obj.parentid !''}" tid='${obj.id}' page='1' href='member_list.htm'>停押</a>/&nbsp;<a class='a_btm_line' act='shanchu'   pid="${obj.parentid !''}" tid='${obj.id}' page='1' href='member_list.htm'>删除</a>/&nbsp;<a class='a_btm_line'   pid="${obj.parentid !''}" href='/member/info4?op=upd&id=${obj.id}&pageId=1&keywordstatus=1&keyword=&level=5&parentId=${obj.parentid!''}'>修改</a>
                                        </#if>
                                            <#if obj.status==1>
                                                <a class='a_btm_line' act='tingyong'   pid="${obj.parentid !''}"
                                                   tid='${obj.id}' page='1' href='member_list.htm'>停用</a>/&nbsp;<a class='a_btm_line' act='tingya'   pid="${obj.parentid !''}"
                                                                                                                   tid='${obj.id}' page='1' href='member_list.htm'>停押</a>/&nbsp;<a class='a_btm_line'   pid="${obj.parentid !''}" href='/member/info4?op=upd&id=${obj.id}&pageId=1&keywordstatus=1&keyword=&level=5&parentId=${obj.parentid!''}'>修改</a>
                                            </#if>
                                            <#if obj.status==2>
                                                <a class='a_btm_line' act='qiyong'   pid="${obj.parentid !''}"
                                                   tid='${obj.id}' page='1' href='member_list.htm'>启用</a>/&nbsp;<a class='a_btm_line' act='tingyong'   pid="${obj.parentid !''}"
                                                                                                                   tid='${obj.id}' page='1' href='member_list.htm'>停用</a>/&nbsp;<a class ='a_btm_line' tid="${obj.id}"   pid="${obj.parentid !''}"
                                                                                                                                                                                   href='/member/info4?op=upd&id=${obj.id}&pageId=1&keywordstatus=1&keyword=&level=5&parentId=${obj.parentid!''}'>修改</a>
                                            </#if>
                                            <#if obj.status==3>
                                                <a class='a_btm_line' act='qiyong'  pid="${obj.parentid !''}"
                                                   tid='${obj.id}' page='1' href='member_list.htm'>启用</a>/&nbsp;<a class='a_btm_line' act='tingyong'   pid="${obj.parentid !''}"
                                                                                                                   tid='${obj.id}' page='1' href='member_list.htm'>停用</a>/&nbsp;<a class='a_btm_line'
                                                                                                                                                                                   pid="${obj.parentid !''}" href='/member/info4?op=upd&id=${obj.id}&pageId=1&keywordstatus=1&keyword=&level=5&parentId=${obj.parentid!''}'>修改</a>
                                            </#if>
                                        </td>
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
        <div class="yui-b">
            <div id="userli" curl="5" class="module g-li">
                <div class="hd g-tif">
                    <h3>賬號管理<span>數量</span></h3>
                </div>
                <div class="bd">
                    <ul class="g-hover">
                        <#if user.usertype lt 1>
                            <li><a curl='5' href='/user/index1'>大股東</a><cite>0</cite></li>
                        </#if>
                        <#if user.usertype lt 2>
                            <li><a curl='0' href='/user/index2'>小股東</a><cite>${user.gudongNumber!'0'}</cite></li>
                        </#if>
                        <#if user.usertype lt 3>
                            <li><a curl='0' href='/user/index3'>總代理</a><cite>${user.zongdaiNumber!'0'}</cite></li>
                        </#if>
                        <#if user.usertype lt 4>
                            <li><a curl='0' href='/user/index4'>代理商</a><cite>${user.dailiNumber!'0'}</cite></li>
                        </#if>
                        <#if user.usertype lt 5>
                            <li><a curl='0' href='/user/index'>會員</a><cite>${user.memberNumber!'0'}</cite></li>
                        </#if>
                    </ul>
                </div>
                <div class="ft">
                    <div class="dotbg"></div>
                </div>
            </div>
        </div>
    </div>
    <div id="ft">
        <div id="footer" class="module">
            <div class="hd rh"></div>
            <div class="bd rb">Copyright 2008-2017 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function page(index) {
        location.href = "/user/index4?pageId=" + index;
    }
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

