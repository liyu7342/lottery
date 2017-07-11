<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>云房询价</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type"/>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta content="0" http-equiv="expires"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"
          name="viewport"/>
    <meta content="no-cache,must-revalidate" http-equiv="Cache-Control"/>
    <meta content="telephone=no, address=no" name="format-detection"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"/>
    <link href="../../../resources/css/base.css" rel="stylesheet" type="text/css" />
    <link href="../../../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!--[if IE 7]>
    <link href="../../../resources/css/font-awesome-ie7.min.css" rel="stylesheet" type="text/css">
    <![endif]-->
    <link href="../../../resources/library/jquery-dataTable/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
    <link href="../../../resources/library/jquery-dataTable-fixedColumns/fixedColumns.dataTables.min.css" rel="stylesheet" type="text/css" />
    <link href="../../../resources/library/jquery-dataTable-Select/css/select.dataTables.min.css" rel="stylesheet" type="text/css" />
    <link href="../../../resources/css/index.css?v=<%out.print(application.getAttribute("JSVersion"));%>" rel="stylesheet" type="text/css" />
</head>
<body class="f-oh-x">
<div class="mainWrap" id="mainWrap" style="width:100%;"></div>
<script type="text/javascript" src="../../../resources/library/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/library/layer/layer.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-placeholder/jquery.placeholder.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-dataTable/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-dataTable-fixedColumns/dataTables.fixedColumns.min.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-dataTable-Select/js/dataTables.select.min.js"></script>
<script type="text/javascript" src="../../../resources/library/help/help.js?v=<%out.print(application.getAttribute("JSVersion"));%>"></script>
<script type="text/javascript">
var _loading;
    $(function(){
        var url="../inquiryHistory/index?time="+new Date().getTime();
        <%
        out.print("url+=\"&city=\"+\""+request.getParameter("city")+"\"");
        %>
        <%
        out.print("url+=\"&filter=\"+\""+request.getParameter("filter")+"\"");
        %>
        loadingHtml(url, function(_result) {
            $("#mainWrap").html("").html(_result);
        });
    });
    function loadingHtml(url, fn) {
        _loading = layer.load(2);
        $.ajax({
            url: url,
            type: 'GET',
            beforesend: _loading,
            data: {},
            success: function(result) {
                fn && fn(result);
                layer.close(_loading);
            },
            error: function() {
                layer.close(_loading);
                layer.open({
                    content: '网络异常,请稍后再试!'
                });
            }
        });
    }
</script>
</body>
</html>
