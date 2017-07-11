<%@ page import="com.fr.lottery.enums.InquiryRecordDataSource" %>
<%@ page import="com.fr.lottery.utils.StringUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="p-5">
    <div class="toolbar">
        <table class="toolbar-form">
            <tr>
                <td class="col-width">项目来源
                    <select id="source" class="form-input">
                        <option value="">请选择</option>
                        <%
                            for (InquiryRecordDataSource source:
                                    InquiryRecordDataSource.values()) {
                                out.print("<option value=\""+source.toString()+"\">"+source.toString()+"</option>");
                            }
                        %>
                    </select>
                </td>
                <td class="col-width dl">城市
                    <input type="text" name="city" id="city" placeholder="请输入或者选择城市名" class="form-input" />
                </td>
                <td>
                    <input type="text" name="filter" id="filter" placeholder="小区名称/小区地址/总价" class="form-input auto" />
                </td>
                <td class="col-width xsm">
                    <button type="button" class="btn btn-xs btn-green" onclick="search()">查询</button>
                </td>
            </tr>
        </table>
    </div>
    <table id="inquiryHistoryTable" class="cell-border nowrap" cellspacing="0" width="100%"></table>
</div>
<div id="InquiryWrap">
</div>

<script type="text/javascript">
    var _inquiryHistoryTable;
    var recordColumns = [{
        title: "询价时间",
        data: "inquiryTime"
    }, {
        title: "来源",
        data: "source",
        width: "120px"
    }, {
        title: "城市",
        data: "city",
        width: "80px"
    }, {
        title: "小区名称",
        data: "residentialName",
        width: "160px"
    }, {
        title: "评估地址",
        data: "residentialAddress"
    }, {
        title: "面积",
        data: "area",
        width: "40px"
    }, {
        title: "反馈价格",
        render: _render1,
    },{
        title: "竞品价格",
        render: _render5,
    }];
    var offerColumns = [{
        title: "案例来源",
        data: "CaseFrom",
        render: _renderSourceLink
    }, {
        title: "时间",
        data: "CaseTime"
    }, {
        title: "行政区",
        data: "DistrictName"
    }, {
        title: "小区名称",
        data: "ResidentialAreaName"
    }, {
        title: "建筑面积（㎡）",
        data: "BuildingArea"
    }, {
        title: "单价(元/㎡)",
        data: "UnitPrice"
    }, {
        title: "所在楼层/总楼层",
        data: "Floors",
        render:_renderFloor
    }, {
        title: "朝向",
        data: "Toward"
    }, {
        title: "建成年代",
        data: "BuildingCompletedYear"
    }, {
        title: "总价(万元)",
        data: "TotalPrice",
        render:_renderTotalPrice
    }, {
        title: "户型",
        data: "UnitShape"
    }];
    $(function() {
        $.fn.dataTable.ext.errMode = 'none';
        $("input").placeholder();
        layer.tips('请选择城市和输入小区名称/项目地址/总价（精确查询），再点击查询按钮', '#filter', {
            tips: [1, '#d9534f'],
            time: 2000
        });
        //获取城市
        $("#city").cityAutoComplete(function(event,item,data){

        });
        <%
        if(!StringUtil.isNullOrEmpty(request.getParameter("time"))){
            if(!StringUtil.isNullOrEmpty(request.getParameter("city"))){
                out.print("$(\"#city\").val(\""+request.getParameter("city")+"\");");
            }
            if(!StringUtil.isNullOrEmpty(request.getParameter("filter"))){
                out.print("$(\"#filter\").val(\""+request.getParameter("filter")+"\");");
            }
            out.print("search();");
        }
        %>
    });

    function search(){
        if (_inquiryHistoryTable) {
            _inquiryHistoryTable.clear().destroy();
        }
        _inquiryHistoryTable = $("#inquiryHistoryTable").DataTable({
            "language": {
                "url": "../../../resources/library/jquery-dataTable/js/Chinese.json"
            },
            "bServerSide": true,
            "select": false,
            "destroy": true,
            "bDestroy": true,
            "dom": '<"toolbar">frtip',
            "bRetrieve": true,
            "scrollX": true,
            "processing": true,
            "bAutoWidth": false,
            "searching": false,
            "sPaginationType": "full_numbers",
            "ordering": false,
            "autoWidth": false,
            "iScrollLoadGap": 10,
            "aLengthMenu": [
                [10, 25, 50, -1],
                [10, 25, 50, "所有"]
            ],
            "serverSide": true,
            "ajax": {
                url: "/inquiry/getInquiryRecordsByCondition",
                type: "POST",
                data: {
                    source:$("#source").val(),
                    city:$("#city").val(),
                    filter:$("#filter").val()
                }
            },
            "columns":  recordColumns
        });
    }
</script>
