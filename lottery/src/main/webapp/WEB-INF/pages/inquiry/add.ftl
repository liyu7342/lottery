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
    <link href="../../../resources/css/base.css" rel="stylesheet" type="text/css" />
    <link href="../../../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!--[if IE 7]>
    <link href="../../../resources/css/font-awesome-ie7.min.css" rel="stylesheet" type="text/css">
    <![endif]-->
    <link href="../../../resources/library/jquery-date-range-picker/daterangepicker.css" rel="stylesheet" type="text/css"/>
    <link href="../../../resources/library/jquery-autocomplete/jquery.autocomplete.css" rel="stylesheet" type="text/css" />
    <link href="../../../resources/library/jquery-dataTable/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
    <link href="../../../resources/library/jquery-dataTable-fixedColumns/fixedColumns.dataTables.min.css" rel="stylesheet" type="text/css" />
    <link href="../../../resources/library/jquery-dataTable-Select/css/select.dataTables.min.css" rel="stylesheet" type="text/css" />
    <link href="../../../resources/library/swfupload/css/default.css" rel="stylesheet" type="text/css" />
    <link href="../../../resources/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body class="f-oh">
<div class="p-5">
    <div class="form-tb">
        <form id="formData">
            <table>
                <tr>
                    <td class="fuild-width">询价来源</td>
                    <td>
                            <select id="source" name="source" class="inpt">
                                <option value="">请选择</option>
                            <#list sources as source>
                                <option value="${source.name}">${source.name}</option>
                            </#list>
                            </select>
                    </td>
                    <td class="fuild-width">城市</td>
                    <td>
                        <input type="text" name="city" class="inpt" id="city" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">小区名称</td>
                    <td>
                        <input type="text" name="residentialName" class="inpt" id="residentialName" />
                    </td>
                    <td class="fuild-width">朝向</td>
                    <td>
                        <select id="toward" name="toward" class="inpt">
                            <option value="">请选择</option>
                        <#list towards as toward>
                            <option value="${toward}">${toward}</option>
                        </#list>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">评估地址</td>
                    <td colspan="3">
                        <input type="text" name="residentialAddress" class="inpt" id="residentialAddress" />
                    </td>
                </tr>

                <tr>

                    <td class="fuild-width">房产证编号</td>
                    <td>
                        <input type="text" name="fangChanZhengBianHao" class="inpt" id="fangChanZhengBianHao" />
                    </td>
                    <td class="fuild-width">房产证所有人</td>
                    <td>
                        <input type="text" name="fangWuSuoyouQuan" class="inpt" id="fangWuSuoyouQuan" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">共有情况</td>
                    <td>
                        <input type="text" name="gongYouQingKuang" class="inpt" id="gongYouQingKuang" />
                    </td>
                    <td class="fuild-width">登记时间</td>
                    <td>
                        <input type="text" name="dengJiShiJian" class="inpt" id="registrationTime" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">房屋性质</td>
                    <td>
                        <input type="text" name="fangWuXingZhi" class="inpt" id="fangWuXingZhi" />
                    </td>
                    <td class="fuild-width">规划用途</td>
                    <td>
                        <input type="text" name="guiHuaYongTu" class="inpt" id="guiHuaYongTu" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">总楼层</td>
                    <td>
                        <input type="text" name="totalFloor" class="inpt" id="totalfloor" />
                    </td>
                    <td class="fuild-width">所在楼层</td>
                    <td>
                        <input type="text" name="floor" class="inpt" id="floor" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">户号</td>
                    <td>
                        <input type="text" name="huHao" class="inpt" id="" />
                    </td>
                    <td class="fuild-width">建筑面积</td>
                    <td>
                        <input type="text" name="area" class="inpt" id="area" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">套内建筑面积</td>
                    <td>
                        <input type="text" name="taoNeiJianZhuMianJi" class="inpt" id="buildarea" />
                    </td>
                    <td class="fuild-width">地号</td>
                    <td>
                        <input type="text" name="diHao" class="inpt" id="" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">土地使用权取得方式</td>
                    <td>
                        <input type="text" name="tuDiQuDeFangShi" class="inpt" id="" />
                    </td>
                    <td class="fuild-width">土地使用年限</td>
                    <td>
                        <span id="usedTime" class="f-ib wrap"> <input type="text" name="tuDiShiYongFrom" class="inpt s" id="usedTimeFrom"  />至<input type="text" name="tuDiShiYongTo" class="inpt s" id="usedTimeTo"/></span>
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">二次询价</td>
                    <td>
                        <input type="checkbox" id="reInquiryCB" name="isTwoInquiry" value="1">
                    </td>
                    <td class="fuild-width">原总价<font style="color:red;;">(万元)</td>
                    <td>
                        <input type="text" name="totalPrice" class="inpt" id="totalPrice" disabled="disabled"  />
                    </td>
                </tr>

            </table>
        </form>
    </div>
    <form id="picForm" action="/document/doUpload" method="post" enctype="multipart/form-data">
    <div id="picList" class="p-5 pic" >
        <div class="ttmd"> 附件</div>
        <table class="comparisonData">
            <thead>
                <tr>
                    <th class="col-width xs">序列号</th>
                    <th class="col-width ">图片名称</th>
                    <th class="col-width xs">图片大小</th>
                    <th>操作</th>
                </tr>
            </thead>
        </table>
        <div class="scroll">
            <table id="table_detail">
                <tbody>
                </tbody>
            </table>
         </div>
    </div>
    </form>
    <p class="f-tc p-5">
        <span id="spanButtonPlaceholder"></span>
        <button type="button" class="btn btn-blue" id="commit">保存</button>
        <button type="button" class="btn btn-blue" style="display: none" id="view">查看图片附件</button>
    </p>

    <table id="inquiryTable" class="cell-border nowrap" cellspacing="0" width="100%"></table>
</div>
<script type="text/javascript" src="../../../resources/library/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-placeholder/jquery.placeholder.js"></script>
<script type="text/javascript" src="../../../resources/library/layer/layer.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-validation/jquery.validate.min.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-validation/validataboxextend.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-autocomplete/jquery.autocomplete.js"></script>
<script type="text/javascript" src="../../../resources/library/help/jquery.extends.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-date-range-picker/moment.min.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-date-range-picker/jquery.daterangepicker.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-dataTable/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-dataTable-fixedColumns/dataTables.fixedColumns.min.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-dataTable-Select/js/dataTables.select.min.js"></script>
<script type="text/javascript" src="../../../resources/library/swfupload/swfupload/swfupload.js"></script>
<script type="text/javascript" src="../../../resources/library/swfupload/swfupload/swfupload.cookies.js"></script>
<script type="text/javascript" src="../../../resources/library/help/fileuploadmanager.js"></script>
<script type="text/javascript" src="../../../resources/library/help/help.js"></script>
<script type="text/javascript" src="../../../resources/library/help/array.extends.js"></script>
<script type="text/javascript" src="../../../resources/library/help/city.js"></script>
<script type="text/javascript">
    var dialog, swfu;
    $(function() {
        $("#formData").validate({
            onkeyup: false,
            rules: {
                city:{
                    _selected:true,
                    required:true
                },
               /* residentialName:{
                    required:true
                },*/
                residentialAddress:{
                  required:true
                },
                area:{
                    required:true,
                    posintdec:true
                },
                buildarea:{
                    posintdec:true
                },
                floor:{
                    posint:true,
                    formsz:true
                },
                totalfloor:{
                    posint:true,
                    formzs:true

                }
            },
            messages: {
                city:{
                    _selected:"请选择城市"
                },
                residentialName:{
                    required:"请选择小区名称"
                },
                residentialAddress:{
                    required:"评估地址不能为空"
                },

                area:{
                    required:"请输入面积",
                    posintdec:"请最多输入两位小数的数字"
                },
                buildarea:{
                    posintdec:"请最多输入两位小数的数字"
                },
                floor:{
                    posint:"请输入正确所在楼层",
                    formsz:"所在楼层小于或等于总楼层"
                },
                totalfloor:{
                    posint:"请输入正确总楼层",
                    formzs:"总楼层大于或等于所在楼层"
                }
            },
            errorPlacement: function(error, element) {
                if(error[0].innerHTML!=""){
                    dialog = layer.tips(error[0].innerHTML, "#" + element[0].id, {
                        tips: [1, '#F99228']
                    });
                    $("#" + element[0].id).addClass("error");
                }
            },
            success: function(label) {
                layer.close(dialog);
                $("#" + label[0].htmlFor).removeClass("error");
            }
        });

        $("#commit").click(function () {
            var oData =$("#formData").serializeObject();
            if(oData.totalPrice)
                oData.totalPrice =parseInt(oData.totalPrice * 10000) ;
            oData.id='${id!""}';
            oData.isTwoInquiry=oData.isTwoInquiry==1?true:false;
            oData.documents= quedata;
            if($("#formData").valid()){
                $.ajax({
                    url:"/inquiry/insertInquiry",
                    type:"POST",
                    dataType:"json",
                    contentType:"application/json",
                    data: JSON.stringify(oData),
                    success: function (data) {
                        if(data){
                            layer.alert("添加成功", {
                                closeBtn: 0,
                                icon: 6,
                                shade: [0.3, '#000']
                            },function () {
                                parent.search();
                                parent.layer.closeAll();
                            });
                        }
                        else{
                            layer.alert("添加失败", {
                                closeBtn: 0,
                                icon: 2,
                                shade: [0.3, '#000']
                            } );
                        }
                    },
                    error: function () {
                    }
                })
            }
        });
        $("#city").cityAutoComplete(function(event,item,data){});
        $('#residentialName').autocomplete("/inquiry/getResidentialArea", {
            width: $('#residentialName').width(),
            minChars: 0,
            scroll: true,
            matchCase: false,
            scrollHeight: 120,
            delay: 400,
            selectFirst : false,
            matchSubset:false,
            dataType: "json",
            extraParams: {
                cue: function () {
                    return $('#residentialName').val().replace(/( )/g, "");
                },
                city: function () {
                    return $('#city').val();
                }
            },
            parse: function (result) {
                if(result!=null&&result.length > 0){
                    return $.map(result, function (row) {
                        if (row == null) {
                            return;
                        }
                        return {
                            data: row,
                            value: row.SearchFlag == "小区名称" ? row.residentialAreaName : row.residentialAreaName,
                            result: row.SearchFlag == "小区地址" ? row.address : row.address
                        }
                    })
                }else{
                    return {
                        data: [],
                        value: "",
                        result: ""
                    }
                }
            },
            formatItem: function (row, i, max) {
                if (row.SearchFlag == "小区地址") {
                    return row.address;
                }
                return row.residentialAreaName+"&nbsp;&nbsp;("+row.address+")";
            },
            formatResult: function (row, i, max) {
                if (row.SearchFlag == "小区地址") {
                    return row.address;
                }
                return row.address;
            },
            formatMatch: function (row, i, max) {
                if (row.SearchFlag == "小区地址") {
                    return row.address;
                }
                return row.address;
            }
        }).result(function (event, data, formatted) {
            $('#residentialName').val(data.residentialAreaName);
            $('#residentialAddress').val(data.address);
        });
        $("#reInquiryCB").change(function(){
            var isTwo =$(this).is(':checked');
            if(isTwo){
                $("#totalPrice").attr("disabled",false);
                $("#totalPrice").rules("add",{required:true,min:0,max :9999999,messages:{min:"请输入原总价"}});
            }
            else{
                $("#totalPrice").attr("disabled","disabled");
                $("#totalPrice").rules("remove");
                $("#totalPrice").removeClass("error");
            }

        });

        if(${isView}){
            $("form[id=formData] input,select,textarea").attr('disabled',"disabled");
            $("button[id=commit],#picList").hide();
            $("#view").show().click(function(){
                parent.layer.open({
                    type: 2,
                    title: '查看图片附件',
                    shadeClose: false,
                    closeBtn: 1,
                    shade: 0.8,
                    area: ['800px', '540px'],
                    content: '/inquiry/view?id='+"${id}"
                });
            });
            loadData("${id!""}");
        }else {
            $('#usedTime').dateRangePicker({
                singleMonth: true,
                separator: ' 至 ',
                stickyMonths:true,
                getValue: function () {
                    if ($('#usedTimeFrom').val() && $('#usedTimeTo').val())
                        return $('#usedTimeFrom').val() + ' 至 ' + $('#usedTimeTo').val();
                    else
                        return '';
                },
                setValue: function (s, s1, s2) {
                    $('#usedTimeFrom').val(s1);
                    $('#usedTimeTo').val(s2);
                }
            });
            $('#registrationTime').dateRangePicker({
                singleMonth: true,
                singleDate: true,
                getValue: function () {
                    if ($('#registrationTime').val())
                        return $('#registrationTime').val();
                    else
                        return '';
                },
                setValue: function (s, s1, s2) {
                    $('#registrationTime').val(s1);
                }
            });
            document.cookie="name=123";
            swfu = new SWFUpload({
                // Backend Settings
                upload_url: "/document/doUpload",
                // File Upload Settings
                file_size_limit: "10 MB",
                file_types:"*.jpg;*.png;*.jpeg;",
                file_types_description: "*.jpg;*.png;*.jpeg;",
                file_upload_limit: 10,
                swfupload_preload_handler: preLoad,
                swfupload_load_failed_handler: loadFailed,
                file_queue_error_handler: fileQueueError,
                file_dialog_complete_handler: fileDialogComplete,
                upload_progress_handler: uploadProgress,
                upload_error_handler: uploadError,
                upload_success_handler: uploadSuccess,
                upload_complete_handler: uploadComplete,
                // Button settings
                button_placeholder_id: "spanButtonPlaceholder",
                button_width: 120,
                button_height: 36,
                button_text_top_padding: 6,
                button_text_left_padding: 24,
                button_image_url: "../../../resources/images/ap.png",
                button_text: '<span class="bn">添加图片</span>',
                button_text_style: ".bn{ border-radus:5px 5px 0px 0px; cursor:pointer; font-family:'Helvetica Neue',Helvetica,Arial,sans-serif;font-size: 14px;line-height:1.14;color:#ffffff}",
                // Flash Settings
                flash_url: "../../../resources/library/swfupload/swfupload/swfupload.swf",	// Relative to this file
                flash9_url: "../../../resources/library/swfupload/swfupload/swfupload_FP9.swf",
                // custom_settings: { upload_target: "divFileProgressContainer" },
                debug: false
            });


        }
        if('${id!""}'){
            $.ajax({
                url: "/inquiry/getInquiry",
                async:true,
                cache:false,
                data: {"id":"${id!""}"},
                success: function (result) {

                    result.totalPrice=parseFloat(result.totalPrice/10000).toFixed(2);
                    $('#formData').setForm(result);
                    if(result && result.isTwoInquiry)
                        $("#totalPrice").attr("disabled",false);
                }
            });
            loadPic("${id!""}");
        }

    });

    function loadPic(id){
        $.ajax({
            url:"/document/getDocuments",
            data:{"reftable":"inquiry","refrecordId":id},
            cache:false,
            success:function(result){
                for(var i= 0,len=result.length;i<len;i++){
                    var dataitem = {
                        id: result[i].id,
                        fileName: result[i].fileName,
                        fileSize: result[i].fileSize,
                        status: 1,
                        resourceId:result[i].resourceId
                    };
                    quedata.push(dataitem);
                }
                drawHtml(quedata);
            }
        })
    }
    function  loadData(id){
        $("#inquiryTable").DataTable({
            "language": {
                "url": "../../../resources/library/jquery-dataTable/js/Chinese.json"
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
                title: "总价",
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
            $("#inquiryTable").DataTable().columns.adjust();
        });
    }

    /*function  drawHtml(data){
        var drawStr='';
        if(data&&data.length>=1){
            $.each(data,function(i,key){
                drawStr+='<tr><td class="col-width xs f-tc">'+i+'</td><td class="col-width">'+key.name+'</td><td><a href="javascript:;" onclick="del('+key.id+')">删除</a><a href="javascript:;" onclick="down('+key.id+')">下载</a></td></tr>';
            });
        }
        $("#table_detail tbody").html(drawStr);
    }*/

    function del(id){
        layer.confirm('您是否删除当前文件?',{},function(r){
            quedata.removeById(id);
            drawHtml(quedata);
            layer.close(r);
            },function(){});
    }
    function down( resourceId,fileName){
        if(resourceId)
                window.open("/document/download?resourceId="+resourceId +"&fileName="+fileName);
    }


</script>
</body>

</html>
