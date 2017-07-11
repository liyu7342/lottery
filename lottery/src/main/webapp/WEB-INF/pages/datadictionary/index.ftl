<link href="../../../resources/library/tree/tree.css" rel="stylesheet" type="text/css"/>
<link href="../../../resources/css/splitter.css" rel="stylesheet" type="text/css"/>

<div class="layout"  style="overflow: hidden;">
<div class="layoutPanel layout-west">
    <div class="btnbartitle">
        <div>
            字典分类
        </div>
    </div>
    <div class="ScrollBar" id="ItemsTree"></div>
</div>
<div class="layoutPanel layout-center" >
    <div class="btnbartitle" style="padding-left: 10px;">
        <div >
            字典数据 - <span id="titleinfo">未选择分类</span>
        </div>
    </div>
    <div class="p-5" style="padding: 10px;">
    <div class="toolbar">
        <table class="toolbar-form">
            <tr>

                <td >
                    <input type="text" name="filter" id="filter" placeholder="名称/编码" class="form-input auto"/>
                </td>
                <td class="col-width" style="width: 240px;">
                    <button type="button" class="btn btn-xs btn-green" onclick="search()">查询</button>
                    <button type="button" class="btn btn-xs btn-blue" onclick="add()">添加</button>
                    <button type="button" class="btn btn-xs btn-blue" onclick="sortmanage()">字典分类</button>
                </td>
            </tr>
        </table>
    </div>
    <table id="gridTable"  class="cell-border nowrap" cellspacing="0" width="100%"></table>
</div>
</div>

</div>

<script type="text/javascript" src="../../../resources/library/tree/tree.js"></script>
<script type="text/javascript" src="../../../resources/library/help/splitter.js"></script>
<script type="text/javascript">
    var  dataDictionaryId = "";
    var inquiryColumns = [{
        title: "名称",
        data: "name",
        width: "120px"
    }, {
        title: "编码",
        data: "code",
        width: "80px"
    }, {
        title: "序号",
        data: "sortCode",
        width: "40px"
    },{title: "操作",
        data: "id",
        width: "40px",
        render:function(id,row,index){
            return '<a href="javascript:void(0);" class="edit" onclick="deleteDetail(\''+id+'\')" >删除</a>';
            deleteDetail
        }
    }];
    var oTable;
$(document).ready(function(){

    loadData("");
    $("#ItemsTree").treeview({
        onnodeclick: function (item) {
          dataDictionaryId = item.id;            //ID
            var  dataDictionaryName = item.text;        //名称
            var dataDictionaryCode = item.value;       //编码
            $("#titleinfo").text(dataDictionaryName + "(" + dataDictionaryCode + ")");
            oTable.destroy();
            loadData(dataDictionaryId);
        },
        url: "/datadictionary/getDataDictionaryTrees"
     });
    $(".layout").splitter({
        splitVertical: true,
        outline: true,
        sizeLeft: 200, minLeft: 100, maxLeft: 250,
        anchorToWindow: true,
        resizeToWidth: true,
        accessKey: "L"
    });
});

    function  search(){
        oTable.destroy();
        loadData(dataDictionaryId);

    }
    function loadData(dataDictionaryId){
        oTable=   $("#gridTable").DataTable({
                "language": {
                    "sProcessing": "处理中...",
                    "sLengthMenu": "显示 _MENU_ 项结果",
                    "sZeroRecords": "没有匹配结果",
                    "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                    "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                    "sInfoPostFix": "",
                    "sSearch": "搜索:",
                    "sUrl": "",
                    "sEmptyTable": "暂无数据",
                    "sLoadingRecords": "载入中...",
                    "sInfoThousands": ",",
                    "oPaginate": {
                        "sFirst": "首页",
                        "sPrevious": "上页",
                        "sNext": "下页",
                        "sLast": "末页"
                    },
                    "oAria": {
                        "sSortAscending": ": 以升序排列此列",
                        "sSortDescending": ": 以降序排列此列"
                    },
                    "select": {
                        "rows": {
                            "_": "选中 %d 行",
                            "0": "点击选中1行",
                            "1": "只有1行选中"
                        }
                    }
                },
                "select": {
                    style: 'single'
                },
                "bServerSide": true,
                "destroy": true,
                "bDestroy": true,
                "dom": '<"toolbar">frtip',
                "bRetrieve": true,
                "scrollX": true,
                "processing": true,
                "bAutoWidth": false,
                "pageLength": 10,
                "searching": false,
                "sPaginationType": "full_numbers",
                "ordering": false,
                "autoWidth": false,
                "iScrollLoadGap": 10,
                "aLengthMenu": [
                    [5, 15, 25, -1],
                    [5, 15, 25, "所有"]
                ],
                "ajax": {
                    url: "/datadictionary/getDataDictionaryDetailDtos",
                    type: "GET",
                    data: {"dataDictionaryId":dataDictionaryId,"filter":$("#filter").val()}
                },
                "columns": inquiryColumns
            });
        }
    function sortmanage(){
        layer.closeAll();
        layer.open({
            type: 2,
            title: '新增估值信息',
            shadeClose: false,
            closeBtn: 1,
            shade: 0.8,
            area: ['800px', '500px'],
            content: '/datadictionary/sortmanage'
        });
    }

    function add(){
        layer.closeAll();
        layer.open({
            type: 2,
            title: $("#titleinfo").text() + '   新增',
            shadeClose: false,
            closeBtn: 1,
            shade: 0.8,
            area: ['420px', '200px'],
            content: '/datadictionary/detailform?itemid='+dataDictionaryId
        });
    }
    //删除
    function deleteDetail(id) {

            $.ajax({
                url:"/datadictionary/delete",
                data:{"keyId":id},
                success: function (result) {
                    if(result && result.Success){
                        layer.alert("删除成功！");
                        search();
                    }
                    else{
                        layer.alert(result.message);
                    }
                }
            })
    }
</script>
