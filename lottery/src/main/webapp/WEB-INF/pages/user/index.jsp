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
                            <form id="form1" method="post" action="/user/index">
                                <input type='hidden' name='op' value="slt">
                                <ul>
                                    <li><h2 class="g-tit">會員
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
                                    <li><h2><a class="btn10 mt red" href='/user/userselect?userType=5'>新增</a>&nbsp;&nbsp;
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
                                    <td>會員賬號</td>
                                    <td>信用額度</td>
                                    <td>盤口</td>

                                    <td>代理%</td>
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
                                        <td class="bg tl">${obj.account!''}&nbsp;&nbsp;[${obj.userName!''},${obj.parentName!''}]</td>
                                        <td>${obj.credits}</td>
                                        <td>${obj.handicap}</td>
                                        <td>${obj.shareUp!'0'}</td>

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
                                            ${obj.createdate?string("yyyy-MM-dd HH:mm:ss")!''}
                                        </td>
                                        <td>
                                            <#if obj.status==0>
                                                <a class='a_btm_line' act='qiyong'   pid="${obj.parentid !''}"
                                                   tid='${obj.id}' page='1' href='member_list.htm'>启用</a>/&nbsp;<a class='a_btm_line' act='tingya'   pid="${obj.parentid !''}" tid='${obj.id}' page='1' href='member_list.htm'>停押</a>/&nbsp;<a class='a_btm_line' act='shanchu'   pid="${obj.parentid !''}" tid='${obj.id}' page='1' href='member_list.htm'>删除</a>/&nbsp;<a class='a_btm_line'   pid="${obj.parentid !''}" href='/member/info?op=upd&id=${obj.id}&pageId=1&keywordstatus=1&keyword=&level=5&parentId=${obj.parentid!''}'>修改</a>
                                            </#if>
                                            <#if obj.status==1>
                                                <a class='a_btm_line' act='tingyong'   pid="${obj.parentid !''}"
                                                   tid='${obj.id}' page='1' href='member_list.htm'>停用</a>/&nbsp;<a class='a_btm_line' act='tingya'   pid="${obj.parentid !''}"
                                                          tid='${obj.id}' page='1' href='member_list.htm'>停押</a>/&nbsp;<a class='a_btm_line'   pid="${obj.parentid !''}" href='/member/info?op=upd&id=${obj.id}&pageId=1&keywordstatus=1&keyword=&level=5&parentId=${obj.parentid!''}'>修改</a>
                                            </#if>
                                            <#if obj.status==2>
                                                <a class='a_btm_line' act='qiyong'   pid="${obj.parentid !''}"
                                                   tid='${obj.id}' page='1' href='member_list.htm'>启用</a>/&nbsp;<a class='a_btm_line' act='tingyong'   pid="${obj.parentid !''}"
                                                   tid='${obj.id}' page='1' href='member_list.htm'>停用</a>/&nbsp;<a class ='a_btm_line' tid="${obj.id}"   pid="${obj.parentid !''}"
                                                   href='/member/info?op=upd&id=${obj.id}&pageId=1&keywordstatus=1&keyword=&level=5&parentId=${obj.parentid!''}'>修改</a>
                                            </#if>
                                            <#if obj.status==3>
                                                <a class='a_btm_line' act='qiyong'  pid="${obj.parentid !''}"
                                                   tid='${obj.id}' page='1' href='member_list.htm'>启用</a>/&nbsp;<a class='a_btm_line' act='tingyong'   pid="${obj.parentid !''}"
                                                   tid='${obj.id}' page='1' href='member_list.htm'>停用</a>/&nbsp;<a class='a_btm_line'
                                                   pid="${obj.parentid !''}" href='/member/info?op=upd&id=${obj.id}&pageId=1&keywordstatus=1&keyword=&level=5&parentId=${obj.parentid!''}'>修改</a>
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
        <#include "left.jsp" />
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
    function page(index) {
        location.href = "/user/index?parentid=${parentid!''}&pageId=" + index;
    }
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

