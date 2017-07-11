<div class="line f-be"></div>
<div class="p-5 inquiryWrap ">
    <div class="f-cf p-5 itemd">
        <div class="itemwrap sm">
            <div class="mr-5">
                <h2>价格参考信息</h2>
                <div class="p-5 itemd">
                    <p>小区名称竞品单价<span id="nameCompetePrice" class="f-im"></span>&nbsp;&nbsp;小区地址竞品单价<span
                            id="addressCompetePrice" class="f-im"></span></p>
                    <p>地址拆分后小区名称<span id="segmentationByAddress" class="f-im"></span></p>
                    <p>地址拆分后云房小区单价<span id="addressInquiryResult" class="f-im"></span></p>
                    <p>小区名称拆分后小区名称<span id="segmentationByName" class="f-im"></span></p>
                    <p>小区名称拆分后云房小区单价<span id="nameInquiryResult" class="f-im"></span></p>
                    <p class="f-prz"><span class="f-pa" style="right:2px;top:0;"><button type="button" class="btn btn-xs btn-blue" id="editInfo">修正信息</button></span>客户备注</p>
                    <p id="remarkInfo" class="remarkInfo f-im"></p>
                </div>
            </div>
        </div>
        <div class="itemwrap">
            <div class="mr-5 ml-5">
                <h2>估值回价</h2>
                <div class="p-5 itemd md">
                    <form id="inquiryForm" class="formInfo">
                        <p>
                            <label>单价(元)
                                <input type="text" name="irpPrice" id="irpPrice" class="input"/>
                            </label>
                            <label>总价(万元)
                                <input type="text" name="irpTotalPrice" id="irpTotalPrice" class="input"/>
                            </label>
                        </p>
                        <p>价格类型

                            <label><input type="radio" name="returnPriceType" value="0"/>系统价格</label>
                            <label><input type="radio" name="returnPriceType" value="1"/>人工核价</label>
                            <label><input type="radio" name="returnPriceType" value="2"/>竞品价格</label>
                        </p>
                        <p id="manualInquiry" class="f-dn">人工核价因素统计
                            <select class="select" id="errorType" name="errorType">
                            </select>
                        </p>
                        <p class="p-5" style="padding-bottom: 0; margin-bottom: 0;padding-top: 0;">
                            <textarea placeholder="备注" class="w-auto text-area" id="feedBack" name="feedBack"></textarea>
                        </p>
                        <p class="f-tc">
                            <button type="button" class="btn btn-green" id="FirstButton">回价</button>
                            <button type="button" class="btn btn-green" id="SecondButton" style="display: none;">修正价格
                            </button>
                        </p>
                    </form>
                </div>
            </div>
        </div>
        <div class="itemwrap md v-content">
            <div class="ml-5">
                <h2> 计算估值</h2>
                <div class="p-5 itemd md">
                    <form id="formData" class="formInfo md">
                        <div class="evaluate-input f-pr evaluate-detail">
                            <ul class="list-item list-item-s">
                                <li class="item">
                                    <div class="f-pr analog-box">
                                        <div class="attr">小区名称</div>
                                        <div class="sval f-pr">
                                            <input type="text" class="input pa" id="xiaoquAddress"
                                                   placeholder="请输入小区名称" style="width: 385px;" name="xiaoquAddress"/>
                                            <input class="input" type="hidden" id="xiaoquID" value=""/>
                                            <input class="input" type="hidden" id="chengshi" value=""/>
                                            <input class="input" type="hidden" id="xingzhengqu" value=""/>
                                            <input class="input" type="hidden" id="xiaoquName" value=""/>
                                            <input class="input" type="hidden" id="residentialName" value=""/>
                                            <input class="input" type="hidden" id="jutidizhi" value=""/>
                                            <input class="input" type="hidden" id="jiansuoType" value="普通检索"/>
                                            <input class="input" type="hidden" id="quyu" value=""/>
                                        </div>
                                    </div>
                                </li>
                                <li class="item" id="js_analog">
                                    <div class="f-pr analog-box">
                                        <div class="attr">房屋坐落</div>
                                        <div class="sval f-pr">
                                            <div class="result-main"></div>
                                        </div>
                                    </div>
                                    <input type="hidden" id="louzhuangStr" data-type="louzhuang" data-id="" value=""/>
                                    <input type="hidden" id="danyuanStr" data-type="danyuan" data-id="" value=""/>
                                    <input type="hidden" id="huhaoStr" data-type="hu" data-id="" value=""/>
                                </li>
                                <li class="item">
                                    <div class="spanel small f-fl">
                                        <div class="attr"><span class="f-im">*</span>面积</div>
                                        <div class="sval f-pr">
                                            <input class="input" type="text" value="" id="MianJi" name="MianJi"
                                                   onblur="_fn.getJushileixing()" placeholder="房产面积"/>
                                            <span class="f-im square pa">㎡</span>
                                        </div>
                                    </div>
                                    <div class="spanel small f-dn">
                                        <div class="attr">居室</div>
                                        <div class="sval f-pr select-border">
                                            <select id="JuShiLeiXing" class="select styled " name="JuShiLeiXing">
                                                <option value="0">请选择</option>
                                                <option value="1">一居室</option>
                                                <option value="2">二居室</option>
                                                <option value="3">三居室</option>
                                                <option value="4">四居室</option>
                                                <option value="5">五居室</option>
                                                <option value="9">五室以上</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="spanel small f-fr">
                                        <div class="attr">物业类型</div>
                                        <div class="sval f-pr select-border" style="width: 180px;">
                                            <select id="WuYeLeiXing" class="select styled "
                                                    style="border:none;display:block;width:100%;height:24px;line-height: 24px;"
                                                    name="WuYeLeiXing">
                                                <option value="请选择">请选择</option>
                                                <option value="住宅" selected="selected">住宅</option>
                                                <option value="别墅">别墅</option>
                                            </select>
                                        </div>
                                    </div>
                                </li>
                                <li class="item">
                                    <div class="spanel small">
                                        <div class="attr">朝向</div>
                                        <div class="sval f-pr select-border">
                                            <select id="ChaoXiang" name="ChaoXiang" class="select styled"
                                                    style="border:none;display:block;width:100%;height:24px;line-height: 24px;">
                                                <option value="请选择">请选择</option>
                                                <option value="东">东</option>
                                                <option value="南">南</option>
                                                <option value="西">西</option>
                                                <option value="北">北</option>
                                                <option value="东南">东南</option>
                                                <option value="东北">东北</option>
                                                <option value="东西">东西</option>
                                                <option value="南北">南北</option>
                                                <option value="西南">西南</option>
                                                <option value="西北">西北</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="spanel small f-fr">
                                        <div class="attr">建成年代</div>
                                        <div class="sval f-pr" style="width: 180px;">
                                            <input id="JianChengNianDai" name="JianChengNianDai" placeholder="请输入建成年代"
                                                   class="input w335 block"
                                                   type="text" value="" style="width: 156px;"/>
                                        </div>
                                    </div>
                                </li>
                                <li class="item">
                                    <div class="spanel small f-fl">
                                        <div class="attr">所在</div>
                                        <div class="sval spec-sval">
                                            <div class="f-fl f-pr">
                                                <input type="text" class="input min-input" id="SuoZaiLouCeng"
                                                       name="SuoZaiLouCeng" value="">
                                                <span class="square f-pa">层</span>
                                            </div>
                                            <div class="f-fr f-pr">
                                                <span>共</span>
                                                <input type="text" class="input min-input" id="ZongLouCeng"
                                                       name="ZongLouCeng" value="">
                                                <span class="square f-pa">层</span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="spanel small f-fr">
                                        <div class="attr">特殊因素</div>
                                        <div class="sval f-pr select-border" style="width: 180px;">
                                            <select id="TeShuYinSu" class="select styled"
                                                    style="border:none;display:block;width:100%;height:24px;line-height: 24px;">
                                                <option value="请选择">请选择</option>
                                            </select>
                                        </div>
                                    </div>
                                </li>
                                <li class="item factors">
                                    <div class="spanel small">
                                        <div class="attr">城市</div>
                                        <div class="sval f-pr">
                                            <#--<select id="_icity" name="_icity" class="select"-->
                                                    <#--style="border:none;display:block;width:100%;height:24px;line-height: 24px;">-->
                                            <#--</select>-->
                                            <input type="text" id="_icity" name="_icity"  class="input" style="width:136px;padding: 2px 5px"  placeholder="请输入或者选择城市名"/>
                                        </div>
                                    </div>
                                    <div class="spanel small f-fr">
                                        <div class="attr">
                                            <button type="button" class="btn btn-xs btn-green" id="inquiryButton">询价
                                            </button>
                                        </div>
                                        <div class="sval f-pr f-tc"
                                             style=" line-height: 25px;font-size:14px; width: 180px;"
                                        ">
                                        <div id="inquiryResult" class="f-dn">
                                            单价<span class="f-im" id="priceObj"></span>
                                            总价<span class="f-im" id="totalPriceObj"></span>
                                        </div>
                                    </div>

                                    <div class="spanel small nature f-fr f-dn">
                                        <div class="attr">产权性质</div>
                                        <div class="sval f-pr select-border">
                                            <select id="ChanQuanXingZhi" class="select styled "
                                                    style="border:none;display:block;width:100%;height:24px;line-height: 24px;">
                                                <option value="请选择">请选择</option>
                                                <option value="商品房">商品房</option>
                                                <option value="经济适用房">经济适用房</option>
                                                <option value="标准价出售住宅">标准价出售住宅</option>
                                                <option value="成本价出售住宅">成本价出售住宅</option>
                                                <option value="限价商品房">限价商品房</option>
                                                <option value="成本价出售住房">成本价出售住房</option>
                                                <option value="房改房(成本价）">房改房(成本价）</option>
                                                <option value="优惠价出售住宅">优惠价出售住宅</option>
                                                <option value="经济适用住房">经济适用住房</option>
                                                <option value="按经济适用住房产权管理">按经济适用住房产权管理</option>
                                            </select>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="line f-be"></div>
<div class="p-5 inquiryWrap">
    <div class="item p-5">
        <p class="historyListType">
            <label>
                <input type="radio" name="inquiryType" value="0" checked="checked">按项目地址查询</label>
            <label>
                <input type="radio" name="inquiryType" value="1">按小区名称查询</label>
            <label>
                <input type="radio" name="inquiryType" value="2">查询网络报盘案例</label>
            <span class="f-dn" id="searchType">
                <input type="text" class="u-inpt u-inpt-lg" value="" placeholder="请输入小区名称" id="otherName"/> &nbsp; &nbsp;
                <button type="button" class="btn btn-xs btn-green" id="searchMore">查询</button>
            </span>
        </p>
        <div class="p-5">
            <table id="historyList" class="cell-border nowrap" cellspacing="0" width="100%"></table>
        </div>
    </div>
</div>
<script type="text/javascript" src="../../../resources/library/jquery-validation/jquery.validate.min.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-validation/validataboxextend.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery.customSelect/jquery.customSelect.min.js"></script>
<script type="text/javascript" src="../../../resources/library/help/inquiry.js"></script>
<script type="text/javascript">

    var _inquiryListTable, dialog, editInfo,inquiryObj = {};
    var recordColumns = [{
        title: "询价时间",
        data: "inquiryTime"
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
        width: "140px"
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
    }, {
        title: "竞品价格",
        render: _render5
    },{
        title: "基准价计算方法",
        data: "jiZhunJiaJiSuanFangFa"
    },
        {
            title: "最终价格采用方法",
            data: "zuiZhongJieGeCaiYongFangFa"
        },
        {
            title: "案例来源",
            data: "anLiLaiYuan"
        },
        {
            title: "间接法价格",
            data: "jianJieFaJiaGe"
        },
        {
            title: "直接法价格",
            data: "zhiJieFaJiaGe"
        }
        ,{
        title:"操作",
        data:"id",
        render:function(val,index,row){
            if(row.anLiIdJiHe && row.anLiIdJiHe!="None"){
                return '<a class="showAnLi"  href="javascript:void(0);">案例查看</a>';
            }
            return "";
        }
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
        render: _renderFloor
    }, {
        title: "朝向",
        data: "Toward"
    }, {
        title: "建成年代",
        data: "BuildingCompletedYear"
    }, {
        title: "总价(万元)",
        data: "TotalPrice",
        render: _renderTotalPrice
    }, {
        title: "户型",
        data: "UnitShape"
    }
        ];


    $(function () {

        if ($("select.styled").length) {
            $("select.styled").customSelect();
        }
        inquiryObj.city = _obj.city;
        inquiryObj.residentialName = _obj.residentialName;
        inquiryObj.residentialAddress = _obj.residentialAddress;
        inquiryObj.type = 0;

        //数据绑定
        _initData();

        //绑定价格参考信息
        _loadPriceMessage();


        //表单验证
        _validate();

        _fn.initfn();

        //小区模糊查询
        _fn.autofn();
        //粘贴小区模糊查询
        $("#xiaoquAddress").unbind("paste").bind("paste", function () {
            _fn.autofn();
        });
        $("#xiaoquAddress").bind({
            "click": function () {
                if ($(this).val() == "") {
                    _fn.keyWid();
                }
                $(this).focus();
            },
            "change": function () {
                _fn.searched($(this).val());
            },
            "keydown": function (event) {
                event.stopPropagation();
                if (13 == event.keyCode) {
                    _fn.searched($(this).val());
                }
            }
        });

        //估值回价单价总价联动
        $("#irpPrice").bind({
            keyup: function () {
                if ($(this).val() !== "") {
                    var flag = /(?:[0-9]\d*|0)(?:\.\d{1,2})?$/.test($(this).val());
                    if (flag) {
                        if ($(this).val() !== "") {
                            var price = Number($(this).val());
                            $("#irpTotalPrice").val(((price * Number(_obj.area)) / 10000).toFixed(2));
                        }
                    } else {
                        layer.msg("请输入正确的价格！", {
                            time: 1500
                        });
                        $(this).val("");
                        $("#irpTotalPrice").val("");
                    }
                } else {
                    $("#irpTotalPrice").val("");
                }
            },
            blur: function () {
                if ($("#irpPrice").val() !== "") {
                    var flag = /(?:[0-9]\d*|0)(?:\.\d{1,2})?$/.test($(this).val());
                    if (flag) {
                        if ($(this).val() !== "") {
                            var price = Number($(this).val());
                            $("#irpTotalPrice").val(((price * Number(_obj.area)) / 10000).toFixed(2));
                        }
                    } else {
                        layer.msg("请输入正确的价格！", {
                            time: 1500
                        });
                        $(this).val("");
                        $("#irpTotalPrice").val("");
                    }
                }
            }
        });

        //估值回价 价格类型
        $("input[name=returnPriceType]").change(function () {
            if ($(this).is(':checked') && $(this).val() == 1) {
                $("#manualInquiry").show();
            } else {
                $("#manualInquiry").hide();
            }
        });

        //不同类型查询
        $("input[name=inquiryType]").change(function () {
            _searchRecord(false);
        });

        $("#searchMore").click(function(){
            _initInquiryListTable("#historyList", dataSet, offerColumns, inquiryObj,false);
        });

        //询价城市选择
        $("#_icity").cityAutoComplete(function(event,item,data){
            $("#xiaoquAddress,#residentialName,#jutidizhi").val("");
            _fn.resetd();
            _fn.initHouseInfo();
            _fn.initfn();
        })
     /*   $("#_icity").autocomplete(cities, {
            width:146,
            max: cities.length,
            minChars: 0,
            scroll: true,
            scrollHeight: 180
        }).result(function(event,item,data) {
            $("#xiaoquAddress,#residentialName,#jutidizhi").val("");
            _fn.resetd();
            _fn.initHouseInfo();
            _fn.initfn();
        });
*/
        //估值回价 回价
        $("#FirstButton").click(function () {
            if ($("#inquiryForm").valid()) {
                $.ajax({
                    url: "/inquiry/updateInquiryForReturn",
                    type: "POST",
                    dataType: "json",
                    beforeSend: showLoading,
                    data: {
                        id: _obj.id,
                        price: $("#irpPrice").val(),
                        totalPrice: (parseFloat($("#irpTotalPrice").val()) * 10000).toFixed(0),
                        priceType: $('input:radio[name="returnPriceType"]:checked').val(),
                        artificialPriceFactors: $("#errorType").val(),
                        feedBack: $("#feedBack").val()
                    },
                    success: function (result) {
                        closeLoading(); 
                        if (result && result.success) {
                            layer.msg("回价成功", {icon: 1, time: 1000}, function () {
                                search();
                                _searchRecord(true);
                                $('#inquiryForm')[0].reset();
                                $("#manualInquiry").hide();
                            })
                        }
                        else{
                            layer.alert(result.msg);
                        }
                    }, error: function (response) {

                        closeLoading();
                        layer.alert(response.responseText);
                    }

                })
            }
        });


        //估值回价 修正价格
        $("#SecondButton").click(function () {
            if ($("#inquiryForm").valid()) {
                $.ajax({
                    url: "/inquiry/updateInquiryForFix",
                    type: "POST",
                    dataType: "json",
                    beforeSend: showLoading,
                    data: {
                        id: _obj.id,
                        fixedPrice: $("#irpPrice").val(),
                        fixedTotalPrice: parseFloat($("#irpTotalPrice").val()) * 10000,
                        priceType: $('input:radio[name="returnPriceType"]:checked').val(),
                        artificialPriceFactors: $("#errorType").val(),
                        feedBack: $("#feedBack").val()
                    },
                    success: function (result) {
                        closeLoading();
                        if (result) {
                            layer.msg("回价成功", {icon: 1, time: 1000}, function () {
                                search();
                                _searchRecord(true);
                                $('#inquiryForm')[0].reset();
                                $("#manualInquiry").hide();
                                initHeight();
                            })
                        }
                    }, error: function () {
                        closeLoading();
                    }

                })
            }
        });


        //计算估值表单提交
        $("#inquiryButton").click(function () {
            _fn.subit();
        });

        //修改房屋信息

        $("#editInfo").click(function () {
            editInfo = layer.open({
                type: 2,
                title: '修改房屋信息',
                shadeClose: false,
                closeBtn: 1,
                shade: 0.8,
                area: ['960px', '420px'],
                content: '/inquiry/editInfo'
            });
        });

        //获取列表信息
        _initInquiryListTable("#historyList", dataSet, recordColumns, inquiryObj);
        _inquiryListTable.on('click', '.showAnLi', function (event) {
            //event.cancelBubble();
            debugger;
            event.stopPropagation();
            var $$data = _inquiryListTable.row($(this).parents("tr")).data();
//                if($$type!=="2"){
                     layer.open({
                        type: 2,
                        title: "[ "+$$data.residentialName+' ]案例信息',
                        shadeClose: false,
                        closeBtn: 1,
                        shade: 0.8,
                        area: ['960px', '420px'],
                        content: '/inquiry/inquiryInfo?cityName='+$$data.city+"&caseIds=" +$$data.anLiIdJiHe
                    });
//                }
        });

    });


    //绑定价格参考信息
    function _loadPriceMessage() {
        //绑定"小区名称竞品价格"
        jsonP("#nameCompetePrice");
        //绑定"小区地址竞品价格"
        jsonP("#addressCompetePrice");
        //绑定"地址拆分后小区名称与云房价格"
        ajaxLoading("address");
        //绑定"小区名称拆分后小区名称与云房价格"
        ajaxLoading("name");
    }

    function _validate() {
        $("#inquiryForm").validate({
            onkeyup: false,
            rules: {
                irpPrice: {
                    required: true,
                    range: [0, 999999]
                },
                irpTotalPrice: {
                    required: true,
                    range: [0, 999999]
                },
                returnPriceType: {
                    required: true
                }
            },
            messages: {
                irpPrice: {
                    required: "请输入单价",
                    posint: "请输入正整数",
                    maxlength: "输入单价过高"
                },
                irpTotalPrice: {
                    required: "请输入总价",
                    posintdec: "最多保留两位小数",
                    maxlength: "总价过高"
                },
                returnPriceType: {
                    required: "请选择价格类型"
                }
            },
            errorPlacement: function (error, element) {
                if (error[0].innerHTML != "") {
                    if (element.is(':radio') || element.is(':checkbox')) {
                    } else {
                        $("#" + element[0].id).addClass("error");
                    }
                    dialog = layer.tips(error[0].innerHTML, "#" + element[0].id, {
                        tips: [1, '#F99228']
                    });

                }
            },
            success: function (label) {
                layer.close(dialog);
                if ($("#" + label[0].htmlFor).is(':radio') || $("#" + label[0].htmlFor).is(':checkbox')) {
                } else {
                    $("#" + label[0].htmlFor).removeClass("error");
                }
            }
        });
        $("#formData").validate({
            onkeyup: false,
            rules: {
                xiaoquAddress: {
                    required: true
                },
                key: {
                    notSpecial: true
                },
                MianJi: {
                    required: true,
                    posintdec: true
                },
                WuYeLeiXing: {
                    _selected: true
                },
                SuoZaiLouCeng: {
                    floor: true,
                    sz: true
                },
                ZongLouCeng: {
                    floors: true,
                    zs: true
                },
                JianChengNianDai: {
                    buildYear: true
                },
                _icity: {
                    required: true
                }
            },
            messages: {
                _icity: {
                    required: "请输入内容并且选择城市"
                },
                xiaoquAddress: {
                    required: "请输入内容并且选择小区"
                },
                key: {
                    notSpecial: "房屋坐落不能为特殊字符"
                },
                MianJi: {
                    required: "请输入具体的建筑面积",
                    posintdec: "最多保留两位小数"
                },
                WuYeLeiXing: {
                    _selected: "请选择物业类型"
                },
                JianChengNianDai: {
                    buildYear: "请输入1900~9999的整数"
                },
                SuoZaiLouCeng: {
                    floor: "所在楼层应该为-1或1~99",
                    sz: "所在楼层小于或等于总楼层"
                },
                ZongLouCeng: {
                    floors: "总楼层应该为1~99",
                    zs: "总楼层大于或等于所在楼层"
                }
            },
            errorPlacement: function (error, element) {
                if (error[0].innerHTML != "") {
                    if (element.is(':radio') || element.is(':checkbox')) {
                    } else {
                        if ($("#" + element[0].id)[0].tagName == "SELECT") {
                            $("#" + element[0].id).parents(".select-border").addClass("error");
                        }
                        $("#" + element[0].id).addClass("error");
                    }
                    dialog = layer.tips(error[0].innerHTML, "#" + element[0].id, {
                        tips: [1, '#F99228']
                    });

                }
            },
            success: function (label) {
                layer.close(dialog);
                if ($("#" + label[0].htmlFor).is(':radio') || $("#" + label[0].htmlFor).is(':checkbox')) {
                } else {
                    if ($("#" + label[0].htmlFor)[0].tagName == "SELECT") {
                        $("#" + label[0].htmlFor).parents(".select-border").removeClass("error");
                    }
                    $("#" + label[0].htmlFor).removeClass("error");
                }
            }
        });
    }

    function _searchRecord(isReload) {
        var type = $("input[name='inquiryType']:checked").val();
        inquiryObj.type = type;
        if (type == "2" && !isReload) {
            $("#searchType").removeClass("f-dn");
            _initInquiryListTable("#historyList", dataSet, offerColumns, inquiryObj,false);
        } else {
            $("#searchType").addClass("f-dn");
            _initInquiryListTable("#historyList", dataSet, recordColumns, inquiryObj,true);
        }
    }

    function _initData() {
        $("#irpPrice").val(_obj.fixedPrice > 0 ? _obj.fixedPrice : _obj.price);
        $("#irpTotalPrice").val(_obj.fixedTotalPrice > 0 ? (_obj.fixedTotalPrice / 10000).toFixed(2) : (_obj.totalPrice / 10000).toFixed(2));
        $("#remarkInfo").html(_obj.remark);
        $("#feedBack").html(_obj.feedBack);
        $("input[name='returnPriceType']:eq(0)").removeAttr("checked");
        $("input[name='returnPriceType']").get(_obj.priceType).checked = true;
        getDicDetail("#errorType","ArtificialPriceFactors",true,function(){
            if (_obj.priceType == 1) {
                $("#manualInquiry").show();
                $("#errorType").val(_obj.artificialPriceFactors);
            } else {
                $("#manualInquiry").hide();
            }
        });
        $("#MianJi").val(_obj.area);
        $("#xiaoquAddress").val(_obj.residentialName);
        $("#otherName").val(_obj.residentialName);
        $("#_icity").val(_obj.city);
        $("#irpPrice").focus();


    }

    function showLoading() {
        layer.load(1, {
            shade: [0.1, '#999'] //0.1透明度的白色背景
        });
    }
    function closeLoading() {
        layer.closeAll('loading');
    }

    function forrment(name) {
        if (name == "请选择") {
            name = ""
        }
        return name;
    }
</script>
