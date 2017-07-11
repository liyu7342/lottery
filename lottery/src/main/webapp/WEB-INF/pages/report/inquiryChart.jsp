<%@ page import="com.fr.lottery.enums.PocessingMode" %>
<%@ page import="com.fr.lottery.enums.PriceType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="p-5">
    <div class="toolbar auto">
        <table class="toolbar-form">
            <tr>
                <td class="col-width">日期
                    <input type="text" name="" id="inquiryDate" class="form-input md"  readonly="readonly" />
                    <input type="hidden" name="inquiryDateFrom" id="inquiryDateFrom" />
                    <input type="hidden" name="inquiryDateTo" id="inquiryDateTo" />
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
</div>
<div class="f-be line">
</div>
<div class="p-5">
    <p class="p-5 f-tc f-fwb fs-md"></p>
    <div id="inquiryPie" class="w-auto" style="height:240px"></div>
</div>
<div class="f-be line">
</div>
<div class="p-5">
    <div class="panel">
        <div class="panel-title f-cf">
            <button class="f-fr btn btn-xs btn-blue" type="button" id="export" onclick="_export()">导出</button>
            <span class="txt f-fwb title"><span id="type"></span>估值明细项</span>
        </div>
        <div class="panel-body">
            <table id="pieTable" class="cell-border nowrap" cellspacing="0" width="100%"></table>
        </div>
    </div>
</div>
<script type="text/javascript">
    var _inquiryPie, _pieTable, pocessingModeEnum=[], priceTypeEnum=[], legendArry=[],dataArry=[];
    var _inquiryTimeFrom="",_inquiryTimeTo="",_source="",_city="",_pocessingMode=-2,_priceType=-2;
    <%
    for (PocessingMode mode: PocessingMode.values()){
        out.print("pocessingModeEnum.push({key:"+mode.ordinal()+",value:\""+mode.toString()+"\"});");
    }
    %>
    <%
    for (PriceType type: PriceType.values()){
        out.print("priceTypeEnum.push({key:"+type.ordinal()+",value:\""+type.toString()+"\"});");
    }
    %>
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
        data: "residentialName"
    }, {
        title: "评估地址",
        data: "residentialAddress"
    }, {
        title: "面积",
        data: "area",
        width: "40px"
    }, {
        title: "反馈价格",
        render: _render1
    },{
        title: "修正价格",
        render: _render2
    }, {
        title: "价格类型",
        data: "priceType",
        render: _render3
    }, {
        title: "二次询价",
        data: "isTwoInquiry",
        render: _isSuccess
    },{
        title: "处理方式",
        data: "pocessingMode",
        render: _render4
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
    },  {
        title: "核价因素统计",
        data: "artificialPriceFactors",
        render:_renderArtificialPriceFactors
    },{
        title: "操作人",
        data: "operator",
        width: "80px"
    }];
    $(function() {
        //获取城市
        $("#city").cityAutoComplete(function(event,item,data){

        });
        getSource("#source");
        initdateRangePicker({
            id: "inquiryDate",
            start: "From",
            end: "To"
        });
        _search();
    });

    function _search(){
        _source=$("#source").val();
        _city=$("#city").val();
        _inquiryTimeFrom=$("#inquiryDateFrom").val();
        _inquiryTimeTo=$("#inquiryDateTo").val();
        _searchPie();
        _searchTable();
        $("#type").text("");
    }

    function  _searchPie(){
        $.ajax({
            url:"/report/getPieChartData",
            type: "POST",
            async:true,
            cache:false,
            dataType:"json",
            data:{
                source:_source,
                city:_city,
                inquiryTimeFrom:_inquiryTimeFrom,
                inquiryTimeTo:_inquiryTimeTo
            },success:function(data){
                if(data){
                    legendArry=[];dataArry=[];
                    var _data=[],total=0;
                    _inquiryPie = echarts.init(document.getElementById('inquiryPie'));
                    $.each(data, function (name, value) {
                        _data.push({"key":name,"value":value});
                        total+=value;
                    });
                    if(total!==0){
                        _splite(_data,'#inquiryPie');
                        initDraw("", _inquiryPie, option,legendArry,dataArry);
                        _inquiryPie.on('click', function ($param) {
                            $("#type").text($param.name+"-");
                            _searchTable($param.data.pocessingMode,$param.data.priceType);
                        });
                        $("#export").show();
                    }else{
                        bindNull("#inquiryPie");
                        $("#export").hide();
                    }
                }else{
                    bindNull("#inquiryPie");
                    $("#export").hide();
                }
            },error:function(){
                bindNull("#inquiryPie");
                $("#export").hide();
            }
        });
    }

    function _searchTable($pocessingMode,$priceType){
        if($pocessingMode==null){
            _pocessingMode=-2;
        }
        else {
            _pocessingMode=$pocessingMode;
        }
        if($priceType==null){
            _priceType=-2;
        }
        else {
            _priceType=$priceType;
        }
        if (_pieTable) {
            _pieTable.clear().destroy();
        }
        _pieTable = $("#pieTable").DataTable({
            "language": {
                "url": "../../resources/library/jquery-dataTable/js/Chinese.json"
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
            "processing": false,
            "bAutoWidth": false,
            "searching": false,
            "fixedColumns": {
                leftColumns: 0,
                rightColumns: 1
            },
            "sPaginationType": "full_numbers",
            "ordering": false,
            "autoWidth": false,
            "iScrollLoadGap": 10,
            "aLengthMenu": [
                [ 10, 20,50, -1],
                [ 10, 20,50, "所有"]
            ],
            "lengthChange":true,
            "serverSide": true,
            "ajax": {
                url: "/inquiry/getPaging",
                type: "POST",
                data: function(params){
                    params.columns="";
                    params.search="";
                    params.inquiryTimeFrom=_inquiryTimeFrom;
                    params.inquiryTimeTo=_inquiryTimeTo;
                    params.source=_source;
                    params.city=_city;
                    params.pocessingMode=_pocessingMode;
                    params.priceType=_priceType;
                    return params;
                }
            },
            "initComplete":function(){
                //initHeight();
            },
            "columns":  inquiryColumns
        });
        $(window).resize(function(){ _pieTable.columns.adjust()});
    }

    function _splite(_arry,elem){
        if(_arry&&_arry.length>0){
            $("elem").siblings("p").html("");
            for (var i=0;i<_arry.length;i++){
                var _key = _arry[i].key,_val=_arry[i].value,$pocessingMode,$priceType,_str;
                if(_val!==0){
                    $pocessingMode= _key.split("-")[0];
                    $priceType = _key.split("-")[1];
                    for(var m=0;m<pocessingModeEnum.length;m++){
                        if(Number($pocessingMode) == pocessingModeEnum[m].key){
                            _str=pocessingModeEnum[m].value;
                            for(var n=0;n<priceTypeEnum.length;n++){
                                if(Number($priceType) == priceTypeEnum[n].key){
                                    _str=_str+"-"+ priceTypeEnum[n].value;
                                    legendArry.push(_str);
                                    dataArry.push({name:_str,value:_val,pocessingMode:$pocessingMode,priceType:$priceType})
                                }
                            }
                        }
                    }
                }
            }
        }else{
            bindNull(elem);
        }
    }

    function _export(){
        var data={
            inquiryTimeFrom:_inquiryTimeFrom,
            inquiryTimeTo:_inquiryTimeTo,
            source:_source,
            city:_city,
            pocessingMode:_pocessingMode,
            priceType:_priceType
        };
        postcall("/report/exportInquiryData", data, '_blank');
    }
</script>
