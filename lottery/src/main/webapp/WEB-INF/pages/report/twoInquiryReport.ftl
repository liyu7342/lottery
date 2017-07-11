<div class="p-5">
    <div class="toolbar auto">
        <table class="toolbar-form">
            <tr>
                <td class="col-width">日期
                    <input type="text" name="" id="inquiryDate" class="form-input md"  readonly="readonly" />
                    <input type="hidden" name="inquiryTimeFrom" id="inquiryDateFrom" />
                    <input type="hidden" name="inquiryTimeFrom" id="inquiryDateTo" />
                </td>
                <td class="col-width">来源机构
                    <select id="source" class="form-input">
                        <option value="">请选择</option>
                    </select>
                </td>
                <td class="col-width dl">城市
                    <input type="text" name="city" id="city" placeholder="请输入或者选择城市名" class="form-input" />
                </td>
                <td class="col-width sm">
                    <button type="button" class="btn btn-xs btn-green" onclick="_search()">查询</button>
                </td>
            </tr>
        </table>
    </div>
    <div class="panel-body">
        <table id="inquiryTable" class="cell-border nowrap" cellspacing="0" width="100%"></table>
    </div>
</div>
<div class="f-be line">
</div>
<div class="p-5">
    <div class="panel">
        <div class="panel-title f-cf">
            <span class="txt f-fwb title"><span id="type"></span>价格变动历史</span>
        </div>
        <div class="panel-body">
            <table id="priceChangeTable" class="cell-border nowrap" cellspacing="0" width="100%"></table>
        </div>
    </div>
</div>
<script type="text/javascript">
    var _priceChangeTable;
    var twoInquiryTable;
    var inquiryColumns = [{
        title: "询价时间",
        data: "inquiryTime",
        width: "80px"
    }, {
        title: "交易编号",
        data: "businessId"
    }, {
        title: "来源",
        data: "source",
        width: "80px"
    }, {
        title: "城市",
        data: "city",
        width: "40px"
    }, {
        title: "小区名称",
        data: "residentialName",
    }, {
        title: "评估地址",
        data: "residentialAddress"
    },
    {
        title: "处理方式",
        data: "pocessingMode",
        render:_render4
    },
    {
    title: "面积",
    data: "area",
    width: "40px"
    }, {
        title: "单价",
        data: "price"
    },{
        title: "总价(万元)",
        data: "totalPrice",
        render:function(totalPrice){return  parseFloat(totalPrice/10000).toFixed(2)},
    },{
        title: "价格变动次数",
        data: "fixedPrice"
    }];

    $(function() {
        initdateRangePicker({
            id: "inquiryDate",
            start: "From",
            end: "To"
        });
        loadData();
        loadPriceChangeData();
        $(window).resize(function () {
            $("#inquiryTable").DataTable().columns.adjust();
        });

        //获取城市
        $("#city").cityAutoComplete(function(event,item,data){

        });
        getSource("#source");

        $("#inquiryTable tbody").on('click', 'tr', function () {
            if (!seletid) {
                if ($(this).hasClass("selected")) {
                    var id=$("#inquiryTable").DataTable().row($(this)).data().id;
                    $("#priceChangeTable").DataTable().destroy();
                    loadPriceChangeData(id);
                }
            } else {
                var id = $("#inquiryTable").DataTable().row($(this)).data().id;
                if ($(this).hasClass("selected") && (seletid !==id)) {
                    $("#priceChangeTable").DataTable().destroy();
                    loadPriceChangeData(id);

                }
            }
        });
    });

    function  _search() {
        $("#inquiryTable").DataTable().destroy();
        loadData();
    }

    function  loadData(){
        twoInquiryTable=   $("#inquiryTable").DataTable({
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
                "sEmptyTable": "暂无数据  <a href='javascript:void(0)' onclick='error(event)'>点击查询询价记录</a>",
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
                url:  "/report/twoInquiryData",
                type: "POST",
                data: {
                    columns:"",
                    search:"",
                    inquiryTimeFrom: $("#inquiryDateFrom").val(),
                    inquiryTimeTo: $("#inquiryDateTo").val(),
                    source:$("#source").val(),
                    city:$("#city").val()
                }
            },
            "columns": inquiryColumns
        });
    }

    function  loadPriceChangeData(id){
        _priceChangeTable= $("#priceChangeTable").DataTable({
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
            "pageLength": 8,
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
                url: "/inquiry/getPriceChanges",
                type: "POST",
                data: {"inquiryId":id}
            },
            "columns": [{
                title: "询价时间",
                data: "createTime",
                width: "120px"
            }, {
                title: "单价",
                data: "price"
            },{
                title: "总价(万元)",
                data: "totalPrice",
                render:function(totalPrice){return  parseFloat(totalPrice/10000).toFixed(2)},
            },{
                title: "价格类型",
                data: "priceType",
                render: _render3
            },
                {
                    title: "核价因素",
                    data: "artificialPriceFactors"
                },
                {
                    title: "二次询价",
                    data: "isTwoInquiry",
                    render: _isSuccess
                },
                {
                    title: "操作人",
                    data: "operator"
                }]
        });
        $(window).resize(function () {
            $("#priceChangeTable").DataTable().columns.adjust();
        });
    }
</script>