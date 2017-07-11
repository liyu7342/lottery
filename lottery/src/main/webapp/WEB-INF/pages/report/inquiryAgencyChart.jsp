<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="p-5">
    <div class="toolbar auto">
        <table class="toolbar-form">
            <tr>
                <td class="col-width">日期
                    <input type="text" name="" id="inquiryAgencyDate" class="form-input md"  readonly="readonly" />
                    <input type="hidden" name="inquiryAgencyDateFrom" id="inquiryAgencyDateFrom" />
                    <input type="hidden" name="inquiryAgencyDateTo" id="inquiryAgencyDateTo" />
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
<div class="f-cf f-be pielist">
    <div class="f-fl item-left">
        <div class="f-bw item-wrap">
            <p class="p-5 f-tc f-fwb fs-md"></p>
            <div id="inquiryAgencypie" class="w-auto item-height"></div>

        </div>
    </div>
    <div class="f-fl item-right">
        <div class="f-bw item-wrap">
            <p class="p-5 f-tc f-fwb fs-md"></p>
            <div id="inquiryErrorpie" class="w-auto item-height"></div>
        </div>
    </div>
</div>
<div class="f-be line">
</div>
<script type="text/javascript">
    var _inquiryAgencypie,_inquiryErrorpie;
    $(function() {
        initdateRangePicker({
            id: "inquiryAgencyDate",
            start: "From",
            end: "To"
        });
        _search();
    });

    function  _search() {
        $.ajax({
            url: "/report/getInquiryAgencyPieDate",
            type: "POST",
            async: true,
            cache: false,
            dataType: "json",
            data: {
                inquiryTimeFrom: $("#inquiryAgencyDateFrom").val(),
                inquiryTimeTo: $("#inquiryAgencyDateTo").val()
            },success:function(data) {
                if (data) {
                    var  total = 0;
                    var legendArry=[],dataArry=[];
                    _inquiryAgencypie = echarts.init(document.getElementById('inquiryAgencypie'));
                    $.each(data, function (name, value) {
                        if(value !== 0){
                            legendArry.push(name);
                            dataArry.push({"name":name,"value":value});
                            total += value;
                        }
                    });
                    if(total!==0){
                        initDraw("1",_inquiryAgencypie,option,legendArry,dataArry);
                    }else{
                        bindNull("#inquiryAgencypie");
                    }
                }else{
                    bindNull("#inquiryAgencypie");
                }
            },error:function(){
                bindNull("#inquiryAgencypie");
            }
        });
        $.ajax({
            url: "/report/getInquiryErrorPieDate",
            type: "POST",
            async: true,
            cache: false,
            dataType: "json",
            data: {
                inquiryTimeFrom: $("#inquiryAgencyDateFrom").val(),
                inquiryTimeTo: $("#inquiryAgencyDateTo").val()
            },success:function(data) {
                if (data) {
                    var  total = 0;
                    var legendArry=[],dataArry=[];
                    _inquiryErrorpie = echarts.init(document.getElementById('inquiryErrorpie'));
                    $.each(data, function (name, value) {
                        if(value !== 0){
                            legendArry.push(name);
                            dataArry.push({"name":name,"value":value});
                            total += value;
                        }
                    });
                    if(total!==0){
                        initDraw("2",_inquiryErrorpie,option,legendArry,dataArry);
                    }else{
                        bindNull("#inquiryErrorpie");
                    }
                }else{
                    bindNull("#inquiryErrorpie");
                }
            },error:function(){
                bindNull("#inquiryErrorpie");
            }
        });
    }

//    function initPie() {
//        _inquiryAgencypie = echarts.init(document.getElementById("inquiryAgencypie"));
//        _inquiryErrorpie = echarts.init(document.getElementById("inquiryErrorpie"));
//        initDraw('1', _inquiryAgencypie, option);
//        initDraw('2', _inquiryErrorpie, option);
//    }
</script>
