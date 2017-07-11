<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <title>询价系统</title>
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
    <link href="../../../resources/css/base.css" rel="stylesheet" type="text/css"/>
    <link href="../../../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!--[if IE 7]>
    <link href="../../../resources/css/font-awesome-ie7.min.css" rel="stylesheet" type="text/css">
    <![endif]-->
    <link href="../../../resources/library/jquery-dataTable/css/jquery.dataTables.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="../../../resources/library/jquery-dataTable-fixedColumns/fixedColumns.dataTables.min.css"
          rel="stylesheet" type="text/css"/>
    <link href="../../../resources/library/jquery-dataTable-Select/css/select.dataTables.min.css" rel="stylesheet"
          type="text/css"/>
    <link href="../../../resources/css/index.css" rel="stylesheet" type="text/css"/>
</head>
<body class="f-oh">
<div class="p-5">
    <table id="table" class="cell-border nowrap" cellspacing="0" width="100%"></table>
</div>
<script type="text/javascript" src="../../../resources/library/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-dataTable/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
        src="../../../resources/library/jquery-dataTable-fixedColumns/dataTables.fixedColumns.min.js"></script>
<script type="text/javascript"
        src="../../../resources/library/jquery-dataTable-Select/js/dataTables.select.min.js"></script>
<script type="text/javascript">
    var city = parent._obj.city;
    var table;
    var columns = [{
        title: "来源",
        data: "source"
    },{
        title: "案例时间",
        data: "caseTime"
    } , {
        title: "单价",
        data: "price"
    }, {
        title: "总价",
        data: "priceTotal"
    },{
        title: "物业类型",
        data: "ctype",
        render:function(ctype){
            if(ctype==1){
                return "住宅";
            }
            else if(ctype==2){
                return "别墅";
            }
            else
                return ctype;
        }
    }, {
        title: "面积",
        data: "area"
    },{
        title: "房屋类型",
        data: "roomType",
        render:function(roomType){
            if(roomType==1){
                return "一居室";
            }
            else if(roomType==2){
                return "二居室";
            }
            else if(roomType==3){
                return "三居室";
            }
            else if(roomType==4){
                return "四居室";
            }
            else if(roomType==5){
                return "五居室";
            }
            else if(roomType==9){
                return "五居室以上";
            }
        }
    },   {
        title: "总楼层",
        data: "totalFloor"
    },{
        title: "所在层",
        data: "cfloor"
    }, {
        title: "朝向",
        data: "toward",
        width: "80px"
    },{
        title: "建筑年份",
        data: "buildYear"
    } , {
        title: "最小面积",
        data: "areaMin"
    }, {
        title: "建筑类型",
        data: "buildType"
    },  {
        title: "案例类型",
        data: "caseType",
        render: caseTimeRender
    }, {
        title: "装修",
        data: "decoration"
    }];

    $(function () {
        $.fn.dataTable.ext.errMode = 'none';
        $('#table').DataTable({
            "language": {
                "url": "../../resources/library/jquery-dataTable/js/Chinese.json"
            },
            "select": {
                style: 'single'
            },
            "destroy": true,
            "bDestroy": true,
            "dom": '<"toolbar">frtip',
            "bRetrieve": true,
            "scrollX": true,
            "processing": false,
            "bAutoWidth": false,
            "searching": false,
            "fixedColumns": {
                leftColumns: 0,
                rightColumns: 0
            },
            "sPaginationType": "full_numbers",
            "ordering": false,
            "autoWidth": false,
            "iScrollLoadGap": 10,
            "aLengthMenu": [
                [10, 20, 50, -1],
                [10, 20, 50, "所有"]
            ],
            "lengthChange": true,
            "columns": columns,
            "ajax": {
                url: "/inquiry/getCasesByIds",
                type: "POST",
                data: function (params) {
                    params.cityName = '${cityName}';
                    params.caseIds='${caseIds}';
                    return params;
                }
            },
        });
    });

    function caseTimeRender(data) {
        var str = "";
        if (data == "1") {
            str = "挂牌";
        } else if (data == "3") {
            str = "成交";
        }
        return str;
    }
</script>
</body>

</html>
