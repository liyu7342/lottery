//回价单价总价
function _render1(data, type, full, meta) {
    var str = "",
        a = "",
        b = "";
    if (full.price&&full.price!==0) {
        a = '<span>单价(元):' + full.price + '</span>';
        if (full.totalPrice&&full.totalPrice!==0) {
            b = '</br><span>总价(万):' +  parseFloat(full.totalPrice/10000).toFixed(2) ;
        } else {
            b = '</br><span>总价(万):--';
        }
    } else {
        a = '<span>单价(元): --';
        if (full.totalPrice&&full.totalPrice!==0) {
            b = '</br><span>总价(万):' +  parseFloat(full.totalPrice/10000).toFixed(2) ;
        } else {
            b = '</br><span>总价(万):--';
        }
    }
    str = a + b;
    return str;
}
//修正单价总价
function _render2(data, type, full, meta) {
    var str = "",
        a = "",
        b = "";
    if ( full.fixedPrice&& full.fixedPrice!==0) {
        a = '<span>单价(元):' + full.fixedPrice + '</span>';
        if (full.fixedTotalPrice||full.fixedTotalPrice!==0) {
            b = '</br><span>总价(万):' + parseFloat(full.fixedTotalPrice/10000).toFixed(2) ;
        } else {
            b = '</br><span>总价(万):--';
        }
    } else {
        a = '<span>单价(元): --';
        if ( full.fixedTotalPrice&&full.fixedTotalPrice!==0) {
            b = '</br><span>总价(万):' +  parseFloat(full.fixedTotalPrice/10000).toFixed(2) ;
        } else {
            b = '</br><span>总价(万):--';
        }
    }
    str = a + b;
    return str;
}
//价格类型
function _render3(data, type, full, meta) {
    var str = "";
    if (data == 0) {
        str = '系统价格';
    } else if (data == 1) {
        str = '人工核价';
    } else if (data == 2) {
        str = '竞品价格';
    }
    return str;
}

//竞品单价总价
function _render5(data, type, full, meta) {
    var str = "",
        a = "",
        b = "";
    if (full.goodsPrice&&full.goodsPrice!==0) {
        a = '<span>单价(元):' + full.goodsPrice + '</span>';
        if (full.goodsTotalPrice&&full.goodsTotalPrice!==0) {
            b = '</br><span>总价(万):' + parseFloat(full.goodsTotalPrice/10000).toFixed(2) ;
        } else {
            b = '</br><span>总价(万):--';
        }
    } else {
        a = '<span>单价(元): --';
        if (full.goodsTotalPrice&&full.goodsTotalPrice!==0) {
            b = '</br><span>总价(万):' +parseFloat(full.goodsTotalPrice/10000).toFixed(2) ;
        } else {
            b = '</br><span>总价(万):--';
        }
    }
    str = a + b;
    return str;
}

//处理方式
function _render4(data, type, full, meta) {
    var str = "";
    if (data == 0) {
        str = '未处理';
    } else if (data == 1) {
        str = '自动询价';
    } else if (data == 2) {
        str = '人工询价';
    }
    return str;
}

//是否
function _isSuccess(data, type, full, meta) {
    var str = "";
    if (data) {
        str = '是';
    } else {
        str = '否';
    }
    return str;
}

function _renderSourceLink(data, type, full, meta){
    if (full.SourceLink == null || full.SourceLink == ""){
        return data;
    }
    return "<a href=\"" + full.SourceLink + "\" target=\"_blank\" style=\"color:#0967fb\">" + data + "</a>";
}

function _renderFloor(data, type, full, meta){
    return full.Floor+"/"+full.Floors;
}


function _renderTotalPrice(data, type, full, meta){
    var str="";
    if(data&&data!==0){
        str=parseFloat(data/10000).toFixed(2) ;
    }
    return str;
}

//操作
function _renderOperate(data, type, full, meta) {
    var str = '';
    if (full.pocessingMode != 0) {
        str = '<a class="f-ib" href="javascript:void(0);">修正价格</a>'
    }
    return str;
}

//核价因素统计
function _renderArtificialPriceFactors(data, type, full, meta) {
    var str = "";
    if (full.priceType == 1) {
        str = data;
    }
    return str;
}
//模拟Form提交导出数据
function postcall(url, params, target) {
    var tempform = document.createElement("form");
    tempform.action = url;
    tempform.method = "post";
    tempform.traditional = true;
    tempform.style.display = "none";
    if (target) {
        tempform.target = target;
    }

    for (var x in params) {
        var opt = document.createElement("input");
        opt.name = x;
        opt.value = params[x];
        tempform.appendChild(opt);
    }

    var optsubmit = document.createElement("input");
    optsubmit.type = "submit";
    tempform.appendChild(optsubmit);
    document.body.appendChild(tempform);
    tempform.submit();
    document.body.removeChild(tempform);
}

//防止事件冒泡
function stopBubble(e) {
    if (e && e.stopPropagation) {
        e.stopPropagation();
    } else {
        window.event.cancelBubble = true;
    }
}

//初始化列表
function _initTable($elem, $data, $cols) {
    if (_table) {
        _table.clear().destroy();
    }
    _table = $($elem).DataTable({
        "language": {
            "url": "../../resources/library/jquery-data_render1Table/js/Chinese.json"
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
            rightColumns: 1
        },
        "sPaginationType": "full_numbers",
        "ordering": false,
        "autoWidth": false,
        "iScrollLoadGap": 10,
        "aLengthMenu": [
            [10, 25, 50, -1],
            [10, 25, 50, "所有"]
        ],
        "data": $data,
        "columns": $cols
    });
}

//初始化列表
function _initInquiryListTable($elem, $data, $cols,$obj,flag) {
    if (typeof(_inquiryListTable) !== "undefined") {
        _inquiryListTable.clear().destroy();
        $($elem).empty();
    }
    var url="";
    switch ($obj.type){
        case "0":
            url="/inquiry/getInquiryRecordsByResidentialAddress";
            break;
        case "1":
            url="/inquiry/getInquiryRecordsByResidentialName";
            break;
        case "2":
            url="/inquiry/getOfferCase"
            break;
        default:
            url="/inquiry/getInquiryRecordsByResidentialAddress";
    }
    _inquiryListTable = $($elem).DataTable({
        "language": {
            "url": "../../resources/library/jquery-dataTable/js/Chinese.json"
        },
        "bServerSide": true,
        "destroy": true,
        "bDestroy": true,
        "dom": '<"toolbar">frtip',
        "bRetrieve": true,
        "scrollX": true,
        "processing": true,
        "select": {
            style: 'single'
        },
        "bAutoWidth": false,
        "pageLength": 8,
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
        "drawCallback": function( settings ) {
            initHeight(false);
        },
        "ajax": {
            url: url,
            type: "POST",
            data:function(params){
                params.columns="";
                params.search="";
                params.city=$obj.city;
                if(!flag){
                    params.residentialName=$("#otherName").val();
                }else{
                    params.residentialName=$obj.residentialName;
                }
                params.residentialAddress=$obj.residentialAddress;
                return params;
            }
        },
        "columns": $cols
    });
    $(window).resize(function(){
        _inquiryListTable.columns.adjust();
    });
}


//时间插件
function initdateRangePicker(_option) {
    var _$option = $.extend(_option);
    $('#' + _$option.id).dateRangePicker({
        language: 'cn',
        startOfWeek: 'monday',
        separator: ' 至 ',
        format: 'YYYY-MM-DD',
        singleMonth: false,
        autoClose: false
    }).bind('datepicker-apply', function(event, obj) {
        var str1 = "",
            str2 = "",
            str3 = "";
        if (obj.date1 != "" && obj.date2 != "" && obj.date2 != "Invalid Date") {
            str1 = myformatter(new Date(obj.date1));
            str2 = myformatter(new Date(obj.date2));
            str3 = obj.value;
            $('#' + event.currentTarget.id).val(str3);
            $('#' + event.currentTarget.id + _$option.start).attr("value", str1);
            $('#' + event.currentTarget.id + _$option.end).attr("value", str2);
        }

    }).bind('datepicker-apply-clear', function(event, obj) {
        if (obj.value == "") {
            $('#' + event.currentTarget.id + _$option.start).attr("value", "");
            $('#' + event.currentTarget.id + _$option.end).attr("value", "");
        }
        $('#' + event.currentTarget.id).val("");
    });
}

//时间格式话
function myformatter(date) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    var d = date.getDate();
    return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}

//饼图通用
var option = {
    title: {
        x: 'left',
        textStyle: {
            fontSize: 24
        },
        subtextStyle: {
            fontSize: 14
        }
    },
    tooltip: {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        x: 'right',
        y: 'center',
    },
    series: [{
        type: 'pie',
        radius: '55%',
        center: ['50%', '60%'],
        itemStyle: {
            emphasis: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
        },
        label: {
            normal: {
                textStyle: {
                    color: '#333',
                    fontSize: 16
                },
                formatter: function(param) {
                    return param.name + ':\n' + param.percent + '%';
                }
            }
        },
        labelLine: {
            normal: {
                lineStyle: {
                    width: 2
                }
            }
        }
    }]
};

//绘制饼状图
function initDraw($type, $obj, $option, $dataType, $data) {
    var $$option = $.extend({}, $option);
    var totalStr="";
    switch ($type) {
        case '1':
            $$option.title.text = '人工回价统计';
            $$option.title.subtext = '统计周期内所有\n走人工询价的机\n构占比';
            $$option.series[0].name = "人工回价统计";
            $$option.legend.orient = 'vertical';
            $$option.legend.x = 'right';
            $$option.legend.y = 'center';
            totalStr="人工回价总数";
            break;
        case '2':
            $$option.title.text = '推送错误询价';
            $$option.title.subtext = '统计周期内所有\n因机构推送错误\n询价信息占比';
            $$option.series[0].name = '推送错误询价';
            $$option.legend.orient = 'vertical';
            $$option.legend.x = 'right';
            $$option.legend.y = 'center';
            totalStr="错误总数";
            break;
        case '3':
            $$option.title.text = '人工核价分析';
            $$option.title.subtext = '统计周期内所有\n机构走人工询价\n数据质量，数据\n来源人工核价因\n素选中饼图可\n筛选列表数据';
            $$option.series[0].name = '人工核价分析';
            $$option.legend.orient = 'vertical';
            $$option.legend.x = 'right';
            $$option.legend.y = 'center';
            totalStr="人工核价总数";
            break;
        default:
            $$option.title.text = '估值报表';
            $$option.legend.orient = "horizontal";
            $$option.legend.x = "center";
            $$option.legend.y = "top";
            $$option.title.subtext = "";
            $$option.series[0].name = '估值报表';
            totalStr="估值总数";
            break;
    }
    $$option.legend.data = typeof($dataType) === "undefined" ? ['直接访问', '间接访问'] : $dataType;
    $$option.series[0].data = typeof($data) === "undefined" ? [{ value: 335, name: '直接访问' }, { value: 310, name: '间接访问' }] : $data;
    //$$option.legend.data =  $dataType;
    //$$option.series[0].data =  $data;

    $obj.setOption($$option);
    var num =0;
    $.each( $$option.series[0].data,function(i,n){
        num+= n.value;
    });
    $($obj._dom).siblings("p").html(totalStr+"<span class='f-im p-5'>"+num+"</span>笔");
    $(window).resize(function() {
        $obj.resize();
        initHeight(false);
    });
}

//JSONP获取竞品单价
function jsonP(elem){
    $.ajax({
        type: "get",
        dataType: "json",
       /* jsonp: "callback",*/
        async:false,
        data: {
            city: _obj.city,
            filter: _obj.residentialName,
            area: _obj.area,
            toward: _obj.toward,
            floor:_obj.floor
        },
        url: "/inquiry/getCompetePriceByMoHu",
        success: function(result) {
            var price="暂无";
            if(result!=null&&(result.Success=="true" || result.Success == "manually")){
                if(result.Data!=null){
                    price=result.Data.price;
                }
            }
            $(elem).html(price);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            $(elem).html("获取失败");
        }
    });
}

//小区地址和小区名称拆分及价格
function ajaxLoading(type){
    var _data ={},elem="",priceelem="";
    _data.city = _obj.city;
    if(type =="address"){
        _data.filter=_obj.residentialAddress;
        elem="#segmentationByAddress";
        priceelem="#addressInquiryResult";
    }else{
        _data.filter=_obj.residentialName;
        elem="#segmentationByName";
        priceelem="#nameInquiryResult";
    }
    $.ajax({
        type: "get",
        url: "/inquiry/getSegmentationResult",
        async:true,
        data:_data,
        dataType:"json",
        success: function (result) {
            if(result!=null&&result.code==0){
                //小区名称
                var residentialName="";
                //楼层
                var floor=_obj.floor;
                //楼栋名
                var houseBuildingName="";
                //户名
                var houseName="";
                if (result.data.baseInfo.residentials.length > 0 && result.data.baseInfo.residentials[0].residentialName != null
                    && result.data.baseInfo.residentials[0].residentialName != "") {
                    residentialName=result.data.baseInfo.residentials[0].residentialName;
                } else if (result.data.residentialName != null && result.data.residentialName != "") {
                    residentialName=result.data.residentialName;
                }
                if (result.data.floorName != null && result.data.floorName != ""&&parseInt(result.data.floorName)==result.data.floorName) {
                    floor=result.data.floorName;
                }
                if (result.data.houseBuildingName != null && result.data.houseBuildingName != "") {
                    houseBuildingName=result.data.houseBuildingName;
                }
                if (result.data.houseName != null && result.data.houseName != "") {
                    houseName=result.data.houseName;
                }
                if(!residentialName){
                    $(elem).html("暂无");
                }
                else
                    $(elem).html(residentialName);
                $.ajax({
                    type: "get",
                    url: "/inquiry/getInquiryResults",
                    data: {
                        city: _obj.city,
                        filter:residentialName,
                        area:_obj.area,
                        toward:_obj.toward,
                        floor:floor,
                        houseBuildingName:houseBuildingName,
                        houseName:houseName
                    },
                    async:false,
                    dataType:"json",
                    success: function (_result) {
                        if(_result!=null&&_result.Success){
                            $(priceelem).html(_result.Data.price);
                        }else{
                            $(priceelem).html("暂无");
                        }
                    },
                    error: function () {
                        $(priceelem).html("获取失败");
                    }
                });
            }else{
                $(elem).html("暂无");
                $(priceelem).html("暂无");
            }
        },
        error: function () {
            $(elem).html("获取失败");
            $(priceelem).html("获取失败");
        }
    });


}

//获得城市信息
function getCities(param,$fn) {
    $.ajax({
        url:"/inquiry/getCities",
        type:"GET",
        success: function (result) {
            if(result){
                var str="<option value=''>请选择</option>";
                if($fn){
                    str = "";
                }
                for(var i=0;i<result.length;i++){
                    str += "<option value='"+result[i].cityName+"'>"+result[i].cityName+"</option>"

                }
                $(param).html(str);
                $fn&&$fn();
            }
        }

    })
}

//获得询价来源信息
function getSource(elem) {
    getDicDetail(elem,"InquirySource");
}

function getDicDetail(elem,source,notUseSelect,fn) {
    $.ajax({
        url:"/datadictionary/getDictionaryDetailByCode",
        type:"GET",
        data:{"dicCode":source},
        success: function (result) {
            if(!notUseSelect){
                var str = "<option value=''>请选择</option>";
            }
            if(result){
                for(var i=0;i<result.length;i++){
                    str += "<option value='"+result[i].name+"'>"+result[i].name+"</option>"
                }
            }
            $(elem).html(str);
            fn&&fn();
        }

    })
}

//绑定空数据
function bindNull(elem){
    $(elem).siblings("p").html("<span class='f-im f-tc'>暂无数据</span>");
}


//模拟Form提交导出数据
function postcall(url, params, target) {
    var tempform = document.createElement("form");
    tempform.action = url;
    tempform.method = "post";
    tempform.traditional = true;
    tempform.style.display = "none";
    if (target) {
        tempform.target = target;
    }

    for (var x in params) {
        var opt = document.createElement("input");
        opt.name = x;
        opt.value = params[x];
        tempform.appendChild(opt);
    }

    var optsubmit = document.createElement("input");
    optsubmit.type = "submit";
    tempform.appendChild(optsubmit);
    document.body.appendChild(tempform);
    tempform.submit();
    document.body.removeChild(tempform);
}

var loadTips={
    _idx:null,
    showLoading:function(){
        this._idx= layer.load(1,{  shade: [0.1,'#fff'] });
    },
    hideLoadind:function(){
        layer.close(this._idx);
    }
};