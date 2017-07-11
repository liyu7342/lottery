<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="utf-8"/>
    <title>询价系统</title>
    <meta name="Keywords" content=""/>
    <meta name="Description" content=""/>

    <meta http-equiv="pragma" content="no-cache"/>
    <meta content="0" http-equiv="expires"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport"/>
    <meta content="no-cache,must-revalidate" http-equiv="Cache-Control"/>
    <meta content="telephone=no, address=no" name="format-detection"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"/>
    <link href="../../../resources/library/tree/tree.css" type="text/css" rel="stylesheet" />
    <link href="../../../resources/css/index.css" type="text/css" rel="stylesheet" />
    <link href="../../../resources/library/jqgrid/css/jqgrid.css" type="text/css" rel="stylesheet" />
    <script src="../../../resources/library/jquery/jquery.min.js" type="text/javascript"></script>
    <script src="../../../resources/library/jqgrid/jqGrid.js" type="text/javascript"></script>
    <script src="../../../resources/library/layer/layer.js"></script>

    <script type="text/javascript">
        $(function () {
            InitialPage();
            GetGrid();
        });
        //初始化页面
        function InitialPage() {
            //resize重设(表格、树形)宽高
            $(window).resize(function (e) {
                window.setTimeout(function () {
                    $('#gridTable').setGridWidth(($('.gridPanel').width()));
                    $("#gridTable").setGridHeight($(window).height() - 114.5);
                }, 200);
                e.stopPropagation();
            });
        }
        //加载表格
        function GetGrid() {
            var selectedRowIndex = 0;
            $("#gridTable").jqGrid({
                url: "/datadictionary/getGridTreeJson",
                datatype: "json",
                height: $(window).height() - 114.5,
                autowidth: true,
                colModel: [
                    { label: '主键', name: 'id', hidden: true },
                    { label: '名称', name: 'name', index: 'name', width: 200, align: 'left' },
                    { label: '编号', name: 'code', index: 'code', width: 200, align: 'left' },
                    { label: '排序', name: 'sortCode', index: 'sortCode', width: 80, align: 'left' }
                ],
                treeGrid: true,
                treeGridModel: "nested",
                ExpandColumn: "code",
                rowNum: "10000",
                rownumbers: true,
                onSelectRow: function () {
                    selectedRowIndex = $("#" + this.id).getGridParam('selrow');
                },
                gridComplete: function () {
                    $("#" + this.id).setSelection(selectedRowIndex, false);
                }
            });
            //查询事件
            $("#btn_Search").click(function () {
                refresh();
            });
        }
        function refresh(){
            $("#gridTable").jqGrid('setGridParam', {
                postData: { filter: $("#filter").val() },
            }).trigger('reloadGrid');
        }
        //新增
        function btn_add() {
            var rowData = $("#gridTable").jqGrid('getRowData', $("#gridTable").jqGrid('getGridParam', 'selrow'));
            var parentId = rowData["parentId"];
            layer.open({
                type: 2,
                title: '添加分类',
                shadeClose: false,
                closeBtn: 1,
                shade: 0.8,
                area: ['600px', '420px'],
                content: '/datadictionary/itemform'
            });
        };
        //编辑
        function btn_edit() {
            var rowData = $("#gridTable").jqGrid('getRowData', $("#gridTable").jqGrid('getGridParam', 'selrow'));
            var id = rowData["id"];
            if(id){
                layer.open({
                    type: 2,
                    title: '编辑分类',
                    shadeClose: false,
                    closeBtn: 1,
                    shade: 0.8,
                    area: ['800px', '500px'],
                    content: '/datadictionary/itemform?id='+id
                });
            }
        }
        //删除
        function btn_delete() {
            var rowData = $("#gridTable").jqGrid('getRowData', $("#gridTable").jqGrid('getGridParam', 'selrow'));
            var id = rowData["id"];
            if (id) {
                $.ajax({
                    url:"/datadictionary/deleteSortManage",
                    data:{"keyId":id},
                    success: function (result) {
                        if(result && result.Success){
                            layer.alert("删除成功！");
                            $("#gridTable").jqGrid().resetSelection();
                            refresh();

                        }
                        else{
                            layer.alert(result.message);
                        }
                    }
                })

            } else {
                layer.alert({ msg: '请选择需要删除的分类！', type: 0 });
            }
        }
    </script>
</head>
<body>
<div class="tools_bar" style="border-top: none; margin-bottom: 0px;">
    <div class="PartialButton">
        <div class="toolbar">
            <table class="toolbar-form">
                <tr>
                    <td>
                        <input type="text" name="filter" id="filter" placeholder="编码/名称" class="form-input auto"/>
                    </td>
                    <td class="col-width " style="width: 240px;;">

                        <button type="button" id="btn_Search" class="btn btn-xs btn-green" >查询</button>
                        <button type="button" class="btn btn-xs btn-green" onclick="btn_add()">新增</button>
                        <button type="button" class="btn btn-xs btn-blue" onclick="btn_edit()">编辑</button>
                        <button type="button" class="btn btn-xs btn-blue" onclick="btn_delete()">删除</button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>
<div class="gridPanel">
    <table id="gridTable"></table>
</div>
</body>
</html>