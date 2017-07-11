<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.fr.lottery.enums.PocessingMode" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="p-5">
    <form class="toolbar" id="toolbar">
        <table class="toolbar-form">
            <tr>
                <td class="col-width">来源机构
                    <select id="source" class="form-input" name="source">

                    </select>
                </td>
                <td class="col-width">城市
                        <input type="text" id="city" name="city" class="form-input md"   placeholder="请输入或者选择城市名"/>
                </td>
                <td class="col-width">处理方式
                    <select id="pocessingMode" class="form-input" name="pocessingMode">
                        <option value="-1">请选择</option>
                        <%
                            for (PocessingMode mode :
                                    PocessingMode.values()) {
                                out.print("<option value=\"" + mode.ordinal() + "\"" + (mode == PocessingMode.未处理 ? "selected" : "") + ">" + mode.toString() + "</option>");
                            }
                        %>
                    </select>
                </td>
                <td>
                    <input type="text" name="filter" id="filter" placeholder="小区名称/询价地址/总价" class="form-input auto"/>
                </td>
                <td class="col-width lg">
                    <button type="button" class="btn btn-xs btn-green" onclick="search()">查询</button>
                    <button type="button" class="btn btn-xs btn-blue" onclick="add()">添加</button>
                    <button type="button" class="btn btn-xs btn-blue" onclick="exportData()">导出</button>
                    <button type="button" class="btn btn-xs btn-blue" onclick="toggleFilter()">高级查询</button>
                </td>
            </tr>
        </table>
        <div class="filter f-dn" id="filterWrap">
            <table>
                <tr>
                    <td class="col-width">自动回价
                        <select id="autoInquirySuccess" class="form-input" name="autoInquirySuccess">
                            <option value="-1">请选择</option>
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </td>
                    <td class="col-width">人工创建
                        <select id="artificialCreate" class="form-input" name="artificialCreate">
                            <option value="-1">请选择</option>
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </td>
                    <td class="col-width">二次询价
                        <select id="twoInquiry" class="form-input" name="isTwoInquiry">
                            <option value="-1">请选择</option>
                            <option value="1">是</option>
                            <option value="0">否</option>
                        </select>
                    </td>
                    <td class="col-width lg">询价时间
                        <input type="text" name="" id="inquiryDate" class="form-input md"  readonly="readonly" />
                        <input type="hidden" name="inquiryTimeFrom" id="inquiryDateFrom" />
                        <input type="hidden" name="inquiryTimeTo" id="inquiryDateTo" />
                    </td>
                    <td class="col-width">核价因素
                        <select id="artificialPriceFactors" class="form-input" name="artificialPriceFactors">
                        </select>
                    </td>
                </tr>
            </table>
        </div>
    </form>
    <table id="inquiryTable" class="cell-border nowrap" cellspacing="0" width="100%"></table>
</div>
<div id="InquiryWrap">
</div>
<script type="text/javascript">
    var _table, _obj, seletid;
    var dataSet;
    var inquiryColumns = [
        {
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
            data: "residentialName"
        }, {
            title: "评估地址",
            data: "residentialAddress"
        }, {
            title: "面积",
            data: "area",
            width: "40px"
        },  {
            title: "评估价格",
            render: function(data, type, full, meta){
                return '<span>单价(元):' + (full.assessmentPrice && full.assessmentPrice!=0 ? full.assessmentPrice : '--' )+ '</span>'
                        + '</br><span>总价(万):' +( full.assessmentTotalPrice &&  full.assessmentTotalPrice != 0 ? full.assessmentTotalPrice : '--')

            }
        },
        {
            title: "待审核价格",
            render: function(data, type, full, meta){
                return '<span>单价(元):' + (full.verifyPrice && full.verifyPrice!=0 ? full.verifyPrice : '--' )+ '</span>'
                        + '</br><span>总价(万):' +( full.verifyTotalPrice &&  full.verifyTotalPrice != 0 ? full.verifyTotalPrice : '--')

            }
        }, {
            title: "提交账号",
            data: "submitUser"
        },
        {
            title: "反馈价格",
            render: _render1
        }, {
            title: "修正价格",
            render: _render2
        }, {
            title: "价格类型",
            data: "priceType",
            render: _render3
        }, {
            title: "核价因素",
            data: "artificialPriceFactors"
        }, {
            title: "二次询价",
            data: "isTwoInquiry",
            render: _isSuccess
        }, {
            title: "处理方式",
            data: "pocessingMode",
            render: _render4
        },{
            title: "自动回价",
            data: "autoInquirySuccess",
            render: _isSuccess
        }, {
            title: "是否终结",
            data: "end",
            render: _isSuccess
        }, {
            title: "价格异常",
            data: "priceAnomaly",
            render: _isSuccess
        }, {
            title: "人工创建",
            data: "artificialCreate",
            render: _isSuccess
        }, {
            title: "操作人",
            data: "operator",
            width: "80px"
        }, {
            title: "操作",
            data: "id",
            width: "120px",
            render:function(data, type, row, meta){ var $renderstr =  '';
                if(row.artificialCreate){
                    $renderstr +='<a href="javascript:void(0);" class="edit" >编辑</a>';
                }
                if($renderstr!=""){
                    $renderstr +=  '&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" class="view" >查看</a>';
                }else{
                    $renderstr +=  '<a href="javascript:void(0);" class="view" >查看</a>';
                }
                return $renderstr;
              }
        }
    ];


    $(function () {
        $.fn.dataTable.ext.errMode = 'none';
        $("input").placeholder();
        initdateRangePicker({
            id: "inquiryDate",
            start: "From",
            end: "To"
        });
        search();
        //询价城市选择
        $("#city").cityAutoComplete(function(event,item,data){

        });
        getSource("#source","InquirySource");
        getDicDetail("#artificialPriceFactors","ArtificialPriceFactors");

        $("#inquiryTable tbody").on('click', 'tr', function () {

            if (!seletid) {
                if ($(this).hasClass("selected")) {
                    var that =this;
                    initWtap(that);
                }
            } else {
                if ($(this).hasClass("selected") && (seletid !== _table.row($(this)).data().id)) {
                    var that =this;
                    initWtap(that);
                }
            }
        });


        $("#inquiryTable tbody").on('click', '.view', function (event) {
            event.stopPropagation();
            var $$data = _table.row($(this).parents("tr")).data();
            layer.closeAll();
            layer.open({
                type: 2,
                title: '查看估值信息',
                shadeClose: false,
                closeBtn: 1,
                shade: 0.8,
                area: ['800px', '600px'],
                content: '/inquiry/add?isView=true&id='+$$data.id
            });

        });
        $("#inquiryTable tbody").on('click', '.edit', function (event) {
            event.stopPropagation();
            var $$data = _table.row($(this).parents("tr")).data();
            layer.closeAll();
            layer.open({
                type: 2,
                title: '修改估值信息',
                shadeClose: false,
                closeBtn: 1,
                shade: 0.8,
                area: ['800px', '570px'],
                content: '/inquiry/add?isView=false&id='+$$data.id
            });
        });
    });

    function  initWtap(_that){
        _obj = _table.row($(_that)).data();
        seletid = _table.row($(".selected")).data().id;
        loadingHtml("/inquiry/wrap", function (_result) {
            $("#InquiryWrap").html("").html(_result);
            if (_obj.pocessingMode != 0) {
                $("#FirstButton").hide();
                $("#SecondButton,#inquiryButton").show();
            } else {
                $("#SecondButton").hide();
                $("#FirstButton,#inquiryButton").show();
            }
            initHeight();
            _table.columns.adjust();
        });
    }

    function search() {
        seletid="";
        if (_table) {
            _table.clear().destroy();
        }
        _table = $("#inquiryTable").DataTable({
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
            "fixedColumns": {
                leftColumns: 0,
                rightColumns: 1
            },
            "bServerSide": true,
            "destroy": true,
            "bDestroy": true,
            "dom": '<"toolbar">frtip',
            "bRetrieve": true,
            "scrollX": true,
            "processing": true,
            "bAutoWidth": false,
            "pageLength": 5,
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
                url: "/inquiry/getPaging",
                type: "POST",
                data: function (params) {
                    params.columns = "";
                    params.search = "";
                    params.source = $("#source").val();
                    params.city = $("#city").val();
                    params.pocessingMode = $("#pocessingMode").val();
                    params.filter = $("#filter").val();
                    params.autoInquirySuccess=$("#autoInquirySuccess").val();
                    params.artificialCreate =$("#artificialCreate").val();
                    params.inquiryTimeFrom=$("#inquiryDateFrom").val();
                    params.inquiryTimeTo=$("#inquiryDateTo").val();
                    params.isTwoInquiry=$("#twoInquiry").val();
                    params.artificialPriceFactors =$("#artificialPriceFactors").val();
                    return params;
                }
            },
            "columns": inquiryColumns
        });
        $(window).resize(function () {
            _table.columns.adjust();
        });

        if ($("#InquiryWrap").html() !== "") {
            $("#InquiryWrap").html("");
            _obj = {};
        }
    }

    function add() {
        layer.open({
            type: 2,
            title: '新增估值信息',
            shadeClose: false,
            closeBtn: 1,
            shade: 0.8,
            area: ['800px', '570px'],
            content: '/inquiry/add?isView=false'
        });
    }

    function error(event) {
        stopBubble(event);
        layer.open({
            type: 2,
            title: "估值历史",
            shadeClose: false,
            closeBtn: 1,
            shade: 0.8,
            area: ['900px', '540px'],
            content: "/inquiryHistory/indexlayer?city=" + $("#city").val() + "&filter=" + $("#filter").val()
        })
    }

    function exportData(){
        var para= $("#toolbar").serialize();
        window.open("/inquiry/exportData?t="+Math.random()+para)
    }

    function toggleFilter(){
        $("#filterWrap").toggle();
    }

</script>
