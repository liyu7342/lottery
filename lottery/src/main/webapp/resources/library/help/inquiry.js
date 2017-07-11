$(function () {
    ;
    (function ($inquiry) {
        $inquiry._fn = {
            resultUnitShape: "",
            unitShape_enum: {
                "请选择": "0",
                "一居室": "1",
                "二居室": "2",
                "三居室": "3",
                "四居室": "4",
                "五居室": "5",
                "五室以上": "9"
            },
            houseType_enum: {
                "0101": "普通住宅",
                "0102": "公寓",
                "010201": "酒店式公寓",
                "010202": "商务公寓",
                "010203": "普通公寓",
                "0103": " 花园洋房",
                "0104": "别墅",
                "010401": "独栋",
                "010402": "联排",
                "010403": "双拼",
                "010404": "叠拼",
                "02": "商业用房",
                "03": "办公用房",
                "04": "工业用房",
                "05": "仓储用房",
                "06": "其他",
                "0601": "车库"
            },
            houseTypeInduce_enum: {
                "0101": "住宅",
                "0102": "住宅",
                "010201": "住宅",
                "010202": "住宅",
                "010203": "住宅",
                "0103": " 别墅",
                "0104": "别墅",
                "010401": "别墅",
                "010402": "别墅",
                "010403": "别墅",
                "010404": "别墅",
                "住宅": "住宅",
                "普通住宅": "住宅",
                "公寓": "住宅",
                "普通公寓": "住宅",
                "酒店式公寓": "住宅",
                "商务公寓": "住宅",
                "别墅": "别墅",
                "花园洋房": "别墅",
                "独栋": "别墅",
                "联排": "别墅",
                "双拼": "别墅",
                "叠拼": "别墅",
                "02": "请选择",
                "03": "请选择",
                "04": "请选择",
                "05": "请选择",
                "06": "请选择",
                "0601": "请选择",
                "请选择": "请选择"
            },
            residentialTypeCache: {},
            //检索状态
            jiansuoType: "普通检索",
            //楼栋单元户点击状态
            cCont: 0,
            //初始化楼幢单元户
            initfn: function () {
                this.oBox = $('#js_analog');
                this.oMain = this.oBox.find(".analog-box");
                this.tmplate();
                this.keyWid();
                this.resultItemFn();
                this.anewEvaluate();
            },
            //房屋坐落输入框初始化
            tmplate: function () {
                this.resMain = this.oBox.find(".result-main");
                this.keyBody = $('<div class="keybody"><input type="text" placeholder="请输入房屋坐落" id="key"  name="key" class="input pa key" style="width:399px;"></div>');
                this.resMain.html(this.keyBody);
                this.itemChild = this.resMain.children(".result-item");
                this.aMresult = this.oMain.find(".menu-result");
                this.keybody = this.oBox.find(".keybody");
                this.oKeyIpt = this.oBox.find("#key");
            },
            //计算房屋坐落输入框宽度
            keyWid: function () {
                this.itemChild = this.resMain.children(".result-item");
                if (this.itemChild.length == 0) return false;
                for (var _padding = 0, _width = 0, n = 0; n < this.itemChild.length; n++) $(this.itemChild[n]).is(":visible") && (_padding += $(this.itemChild[n]).innerWidth() + 5);
                _width = this.resMain.width() - _padding - 1, this.keybody.show().css("width", _width), $('.v-content').length ? this.oKeyIpt.css("width", (_width - 11) + "px") : this.oKeyIpt.css("width", (_width - 13) + "px");
            },
            //房屋坐落坐落点击事件
            resultItemFn: function () {
                $(this.resMain).unbind('click').bind('click', function (e) {
                    e.stopPropagation();
                    _fn.cCont = 1;
                    _fn.hideMenuResult(_fn.cCont);
                    var target = $(e.target), $id = "", $type = "", parentObj = {}, menuId = "", oPrev = {}, shtml = "";
                    /*
                     * 对象对象是文字区域，则进行修改操作，并且出现下拉数据
                     * */
                    if (target.is('span')) {
                        parentObj = target.parent();
                        menuId = parentObj.attr('data-menu-id');
                        shtml = target.html();

                        //检测当menuId不存在的时候，就根据target的data-type与data-id执行查询数据功能
                        if ($('#' + menuId).length == 0) {
                            oPrev = target.parent().prev('.result-item:visible');
                            $type = oPrev.find('span').attr('data-type');
                            $id = oPrev.find('span').attr('data-id');
                            if (oPrev.length == 0) {
                                $id = $('#xiaoquID').val();
                                $type = 'xiaoqu';
                            }
                            _fn.showDataFn($type, $id);
                            _fn.opType = menuId;
                        }
                        parentObj.hide().nextAll('.result-item').hide();
                        // 显示对应的下拉菜单,移除对应的兄弟节点
                        $('#' + menuId).show().siblings('.menu-result').hide();
                        $('#' + menuId).find('ul').find('li').show();

                        // 计算宽度
                        _fn.keyWid();
                        _fn.itemId = parentObj.attr('id');
                        $id = $('#' + _fn.itemId).find('span').attr('data-id');
                        $type = $('#' + _fn.itemId).find('span').attr('data-type');
                        _fn.oKeyIpt.focus().val(shtml).attr('data-type', $type).attr('data-id', $id);

                        var sInputval = _fn.oKeyIpt.val();
                        _fn.oKeyIpt.unbind('blur').on('blur', function () {
                            if ($(this).val() == sInputval) {
                                _fn.oKeyIpt.val('');
                                $('#' + _fn.itemId).show().nextAll('.result-item').show();
                            } else if ($(this).val() == '') {
                                _fn.resMain.find('.result-item:hidden').remove();
                            } else {
                                _fn.resMain.find('.result-item:hidden').remove();
                            }
                            _fn.keyWid();
                        });
                    } else if (target.is('a')) {
                        parentObj = target.parent();
                        menuId = parentObj.attr('data-menu-id');
                        if ($('#' + menuId).length == 0) {
                            oPrev = target.parent().prev('.result-item:visible');
                            $type = oPrev.find('span').attr('data-type');
                            $id = oPrev.find('span').attr('data-id');
                            if (oPrev.length == 0) {
                                $type = 'xiaoqu';
                                $id = $('#xiaoquID').val();
                            }
                            _fn.showDataFn($type, $id);
                            _fn.opType = menuId;
                        }
                        $('#' + menuId).toggle().siblings('.menu-result').hide();
                        $('#' + menuId).find('ul').find('li').show();

                    } else if (target.is('input')) {
                        _fn.itemChild = _fn.resMain.children('.result-item');
                        if (_fn.itemChild.length == 0 || $('#result_louzhuang').is(':hidden')) {
                            $type = 'xiaoqu';
                            $id = $('#xiaoquID').val();
                        } else {
                            $type = target.parent().prev('.result-item:visible').find('span').attr('data-type');
                            $id = target.parent().prev('.result-item:visible').find('span').attr('data-id');
                        }
                        _fn.showDataFn($type, $id);
                    }
                    _fn.keyWid();
                });
                //防止事件冒泡
                $(document).on('click', function () {
                    _fn.aMresult = _fn.oMain.find('.menu-result');
                    $(_fn.aMresult).each(function () {
                        if ($(_fn.aMresult).is(':visible')) {
                            $(_fn.aMresult).hide();
                            _fn.oKeyIpt.removeAttr('data-type').removeAttr('data-id');
                        }
                    });
                });
            },
            //根据楼幢单元户隐藏域绘制下拉
            anewEvaluate: function () {
                var reHtml = '';
                _fn.cCont = 0;
                var $lzStr = $('#louzhuangStr');
                var $dyStr = $('#danyuanStr');
                var $huStr = $('#huhaoStr');
                if ($lzStr.attr('data-id') != '') {
                    reHtml = $('<div class="result-item" id="result_louzhuang" data-menu-id="menu_louzhuang" data-index="0"><span data-type="louzhuang" data-id=' + $lzStr.attr('data-id') + '>' + $lzStr.val() + '</span><a href="javascript:;"></a></div>');
                    reHtml.insertBefore(_fn.keybody);
                    _fn.showDataFn("louzhuang", $lzStr.attr("data-id"));
                }
                if ($dyStr.attr('data-id') != '') {
                    reHtml = $('<div class="result-item" id="result_danyuan" data-menu-id="menu_danyuan" data-index="1"><span data-type="danyuan" data-id=' + $dyStr.attr('data-id') + '>' + $dyStr.val() + '</span><a href="javascript:;"></a></div>');
                    reHtml.insertBefore(_fn.keybody);
                    _fn.showDataFn("danyuan", $dyStr.attr("data-id"));
                }
                if ($huStr.attr('data-id') != '') {
                    reHtml = $('<div class="result-item" id="result_hu" data-menu-id="menu_hu" data-index="2"><span data-type="hu" data-id=' + $huStr.attr('data-id') + '>' + $huStr.val() + '</span><a href="javascript:;"></a></div>');
                    reHtml.insertBefore(_fn.keybody);
                    _fn.showDataFn("hu", $huStr.attr("data-id"));
                }
                _fn.keyWid();
                _fn.hideMenuResult(_fn.cCont);
            },
            //选中物业类型
            setHouseType: function (houseType) {
                $('#WuYeLeiXing').val(houseType).trigger("render");
            },
            //根据状态显示不同数据
            showDataFn: function (type, id) {
                if (type == 'hu') {
                    _fn.gethouseInfo(id);
                    _fn.oMain.find('.menu-result').hide();
                } else {
                    _fn.reqDataFn(type, id);
                    if (type == 'louzhuang') {
                        _fn.gethousingInfo(id);
                    }
                }
                if (type == 'hu' || type == 'louzhuang') {
                    _fn.gethousingTypeMatching(type, id);
                }
            },
            //楼幢单元户下拉绘制
            insertElem: function (resTempType, temp) {
                var meHtml = '', dataIndex = '';
                if (resTempType == 'louzhuang') {
                    dataIndex = 0;
                } else if (resTempType == 'danyuan') {
                    dataIndex = 1;
                } else if (resTempType == 'hu') {
                    dataIndex = 2;
                }
                if ($('#menu_' + resTempType).length > 0) {
                    $('#menu_' + resTempType).remove();
                }
                meHtml = '<div data-result-id="result_' + resTempType + '" class="menu-result" id="menu_' + resTempType + '" data-index="' + dataIndex + '"><ul>' + temp + '</ul></div>';
                _fn.oMain.append(meHtml);

                setTimeout(function () {
                    if ($('#' + _fn.menuId).length != 0) {
                        $('#' + _fn.menuId).show().siblings('.menu-result').hide();
                        $('#' + _fn.menuId).find('ul').find('li').show();
                    }
                    _fn.menuChildFn();
                    _fn.hideMenuResult(_fn.cCont);
                }, 10);
            },
            //楼幢单元户下拉点击事件
            menuChildFn: function () {
                var oMresult = _fn.oMain.find('.menu-result');
                var aChildLi = oMresult.find('li');
                aChildLi.each(function (idx, elm) {
                    var $elm = $(elm);
                    $elm.unbind('click').bind('click', function (e) {
                        e.stopPropagation();
                        $(this).addClass('active').siblings('li').removeClass('active');
                        $(this).parents('.menu-result').hide();
                        var type = $(this).attr('data-type');
                        var id = $(this).attr('data-id');
                        var sText = $(this).text();
                        var elmId = "";
                        var resultId = $(this).parents('.menu-result').attr('data-result-id');
                        _fn.showDataFn(type, id);
                        _fn.oKeyIpt.focus().removeAttr('data-type').removeAttr('data-id');

                        if (type == 'louzhuang') {
                            dataIndex = 0;
                        } else if (type == 'danyuan') {
                            dataIndex = 1;
                        } else if (type == 'hu') {
                            dataIndex = 2;
                        }
                        elmId = 'result_' + type;

                        /*
                         * 存在result-item对象
                         **/
                        if ($('#' + resultId).length > 0) {
                            $('#' + resultId).find('span').html(sText).attr('data-type', type).attr('data-id', id);
                            if (sText != _fn.defaultHtml) {
                                $('#' + resultId).nextAll('.result-item').remove();
                                _fn.aMresult = _fn.oMain.find('.menu-result');
                            }
                        } else {
                            // 不存在对应的元素，添加新元素
                            var reHtml = $('<div class="result-item" id=' + elmId + ' data-menu-id=menu' + elmId.substring(elmId.indexOf('_')) + ' data-index=' + dataIndex + '><span data-type=' + type + ' data-id=' + id + '>' + sText + '</span><a href="javascript:;"></a></div>');
                            reHtml.insertBefore(_fn.keybody);
                            _fn.oKeyIpt.val('');
                        }
                        /*
                         * 重新计算keybody宽度
                         * */
                        _fn.keyWid();
                        var vue = $('#result_louzhuang span').text() + $('#result_danyuan span').text() + $('#result_hu span').text();
                        $('#xiaoquAddress').val(vue);
                        layer.tips("根据您的选择,我们已改变输入项!", "#xiaoquAddress", {
                            tips: [1, '#F99228'],
                            time: 2000
                        });
                    });
                });
            },
            //点击楼幢单元户后隐藏
            hideMenuResult: function (isClick) {
                if (isClick) return;
                var $lzStr = $('#louzhuangStr');
                var $dyStr = $('#danyuanStr');
                var $huStr = $('#huhaoStr');
                setTimeout(function () {
                    if ($lzStr.val() != '' || $dyStr.val() != '' || $huStr.val() != '') {
                        _fn.oMain.find('.menu-result').hide();
                    }
                }, 30);
            },
            //楼栋单元户联动
            reqDataFn: function (_type, _id) {
                if (_fn.getNull(_type) == "" ||_fn.getNull(_id) == "") return;
                if(!_fn.getErrorCity()) return ;
                var len = '', temp = '', reqType = '', resTempType = '', dType = '', list = null, name = "";
                $.ajax({
                    type: 'post',
                    url: '/inquiry/getLiandong',
                    data: {
                        'city': $("#_icity").val(),
                        'id': _id,
                        'type': _type
                    },
                    dataType: 'json',
                    beforeSend: showLoading(),
                    success: function (data) {
                        closeLoading();
                        if (data.success) {
                            if (data.list != null) {
                                list = data.list;
                                temp = '';
                                for (var i = 0; i < list.length; i++) {
                                    len = list[i].id;
                                    name = list[i].name;
                                    reqType = list[i].type;
                                    resTempType = list[0].type;
                                    temp += '<li data-id="' + len + '" data-type="' + reqType + '" data-index="' + i + '">' + name + '</li>';
                                }
                                _fn.insertElem(resTempType, temp);
                            }
                        }
                        _fn.oKeyIpt.unbind('keyup').bind('keyup', function () {
                            dType = $(this).attr('data-type');
                            temp = '';
                            if (dType == 'louzhuang' || dType == 'danyuan' || dType == 'hu') {
                                $('#menu_' + dType).find('ul').find('li').hide().filter('li:contains(' + $(this).val() + ')').show();
                                if ($(this).val() == '') {
                                    $('#menu_' + dType).find('ul').find('li').removeAttr('style');
                                }
                            } else {
                                // 查找最后一个menu-result进行显示并回显数据
                                _fn.oMain.last('.menu-result').show();
                                _fn.oMain.last('.menu-result').find('ul').find('li').hide().filter('li:contains(' + $(this).val() + ')').show();
                                if ($(this).val() == '') {
                                    _fn.oMain.last('.menu-result').find('ul').find('li').removeAttr('style');
                                }
                            }
                        });
                    },
                    error: function () {
                        closeLoading();
                    }
                });
            },
            //物业类型匹配
            gethousingTypeMatching: function (matchingType, id) {
                if(!_fn.getErrorCity()) return;
                var self = this;
                var tKey = '"' + matchingType + '_' + id + '"';
                var houseTypeCache = _fn.residentialTypeCache[tKey];
                if (_fn.getNull(houseTypeCache) !== "") {
                    self.setHouseType(houseTypeCache);
                } else {
                    self.setHouseType("住宅");
                }
                $.ajax({
                    url: '/inquiry/housingTypeMatching',
                    dataType: "json",
                    type: "POST",
                    async: false,
                    data: {
                        city:$("#_icity").val(),
                        matching_type: matchingType,
                        info_id: id
                    },
                    success: function (result) {
                        if (result["success"]) {
                            var houseType = _fn.houseTypeInduce_enum[result["data"]];
                            if (_fn.getNull(houseType) == "") {
                                _fn.residentialTypeCache[tKey] = "住宅";
                            } else {
                                _fn.residentialTypeCache[tKey] = houseType;
                            }
                        } else {
                            _fn.residentialTypeCache[tKey] = "住宅";
                        }
                        self.setHouseType(_fn.residentialTypeCache[tKey]);
                    }
                });
            },
            //获取楼幢信息(总楼层/建成年代)
            gethousingInfo: function (_id) {
                setTimeout(function () {
                    if(!_fn.getErrorCity()) return;
                    $.ajax({
                        type: "POST", //用POST方式传输
                        dataType: "json", //数据格式:JSON
                        url: '/inquiry/getXiaoQuLouDongXinXi', //目标地址
                        data: {
                            "CityName":$("#_icity").val(),
                            "houseBuildingId": _id
                        },
                        beforeSend: showLoading(),
                        success: function (data) {
                            closeLoading();
                            if (data != null && data != "") {
                                //总楼层
                                var map = "";
                                if (data.natureOfPropertyRightAndFloorsMap != null) {
                                    map = data.natureOfPropertyRightAndFloorsMap;
                                }
                                var floors = map.floors;
                                $('#ZongLouCeng').val(floors);
                                //建成年代
                                var Year = data.buildDataRecordMap;
                                var jcnd = $('#JianChengNianDai');
                                jcnd.val("");
                                if (Year != null && Year != '' && Year.Year != null && Year.Year != '') {
                                    jcnd.val(Year.Year.substring(0, 4));
                                }
                            }
                        },
                        error: function () {
                            closeLoading();
                        }
                    });
                }, 30);
            },
            //获取楼幢信息(面积/物业类型/朝向/居室类型/所在楼层)
            gethouseInfo: function (_id) {
                //朝向
                $('#ChaoXiang').val("请选择").trigger("render");
                //所在楼层
                $("#SuoZaiLouCeng").val('');

                $.ajax({
                    type: 'post',
                    url: '/inquiry/getHouseInfo',
                    data: {
                        houseId: _id,
                        city:$("#_icity").val()
                    },
                    dataType: 'json',
                    success: function (data) {
                        if (data.success) {
                            var mianji = data.json.buildingArea;
                            if (_fn.getNull(mianji) !== "") {
                               // $('#MianJi').val(mianji.toFixed(2));
                            }
                            var type = data.json.houseType;
                            var toward = data.json.toward;
                            var unit_shape = data.json.unitShape;
                            var floor = data.json.floor;

                            if ('其他' == unit_shape || '其它' == unit_shape) {
                                unit_shape = '请选择';
                            }
                            if ('多室多厅' == unit_shape) {
                                unit_shape = '五室以上';
                            }
                            //居室类型
                            if (_fn.getNull(_fn.unitShape_enum[unit_shape]) == "") {
                                _fn.getJushileixing();
                            } else {
                                _fn.resultUnitShape = _fn.unitShape_enum[unit_shape];
                                $('#JuShiLeiXing').val(_fn.resultUnitShape).trigger('render');
                            }
                            //物业类型
                            if (_fn.getNull(_fn.houseType_enum[type]) == "") {
                                _fn.setHouseType("住宅");
                            } else {
                                _fn.setHouseType(_fn.houseTypeInduce_enum[type]);
                            }
                            //朝向
                            $('#ChaoXiang').val(toward).trigger('render');
                            //所在楼层
                            $('#SuoZaiLouCeng').val(floor);
                            var _szvalue = $('#SuoZaiLouCeng').val(), zlvalue = $('#ZongLouCeng').val();
                            if (_szvalue !== "" && zlvalue !== "") {
                                if (parseInt(_szvalue) > parseInt(zlvalue)) {
                                    $('#SuoZaiLouCeng').val('');
                                }
                            }
                        }
                    }
                });
            },
            //获取居室类型
            getJushileixing: function () {
                if ("" != $("#MianJi").val() && "" != $("#xiaoquAddress").val() && $("#xiaoquName").val() != "" && "" == _fn.resultUnitShape) {
                    if(!_fn.getErrorCity()) return ;
                    $.ajax({
                        type: "GET",
                        url: "/inquiry/piPeiJuShi",
                        data: {
                            cityName:$("#_icity").val(),
                            mianji: $('#MianJi').val(),
                            xiaoqumingcheng: $('#xiaoquName').val()
                        },
                        dataType: "json",
                        beforeSend: showLoading(),
                        async: !1,
                        success: function (msg) {
                            if (null != msg) {
                                var data = eval(msg);
                                if (data.Data.length) {
                                    var _val;
                                    if (_fn.getNull(_fn.unitShape_enum[data.Data[0].Value]) == "") {
                                        _val = "0";
                                    } else {
                                        _val = _fn.unitShape_enum[data.Data[0].Value];
                                    }
                                } else {
                                    _val = "0";
                                }
                                $('#JuShiLeiXing').val(_val).trigger("render");
                            }
                            closeLoading();
                        },
                        error: function (a) {
                            closeLoading();
                        }
                    });
                }
            },
            //获取特殊因数
            getTeshuyinsu: function (name) {
                if(!_fn.getErrorCity()) return ;
                var _str = '<option value="请选择">' + '请选择' + '</option>';
                $.ajax({
                    type: "GET",
                    url: "/inquiry/getTeshuyinsu",
                    data: {
                        "CityName":$("#_icity").val(),
                        "cname": name
                    },
                    dataType: "json",
                    beforeSend: showLoading,
                    success: function (msg) {
                        var data = eval(msg);
                        if (data.Data != null && data.Data != "") {
                            for (var v in data.Data) {
                                _str = +("<option value='" + data.Data[v] + "'>" + data.Data[v] + "</option>");
                            }
                        }
                        _str = _str + '<option value="无">' + '无' + '</option>';
                        $('#TeShuYinSu').html(_str);
                        $('#TeShuYinSu').val("请选择").trigger("render");
                        closeLoading();
                    },
                    error: function () {
                        _str = _str + '<option value="无">' + '无' + '</option>';
                        $('#TeShuYinSu').html(_str);
                        $('#TeShuYinSu').val("请选择").trigger("render");
                        closeLoading();
                    }
                });
            },
            //重置表单数据
            initHouseInfo: function () {
               // $('#MianJi').val('');
                //物业类型
                _fn.setHouseType("住宅");
                //居室类型
                $('#JuShiLeiXing').val("请选择").trigger("render");
                //特殊因素
                $('#TeShuYinSu').val("请选择").trigger("render");
                //朝向
                $('#ChaoXiang').val("请选择").trigger("render");
                //所在楼层,总楼层,建成年代
                $('#SuoZaiLouCeng,#ZongLouCeng,#JianChengNianDai').val('');
            },
            //小区重新选择重置部分关键数据
            resetd: function () {
                $('#JianChengNianDai').val('');
                $('#louzhuangStr').attr('data-id', '').val('');
                $('#danyuanStr').attr('data-id', '').val('');
                $('#huhaoStr').attr('data-id', '').val('');
                $('#xiaoquID').val(''); //在自动补全中获取小区ID
                $('#xingzhengqu').val(''); //小区所属行政区
                $('#xiaoqudizhi').val(''); //小区地址
                $('#xiaoquName').val(''); //小区名称
                $('#ZongLouCeng,#SuoZaiLouCeng,#JianChengNianDai').val('');
            },
            //小区名称和地址模糊查询
            autofn: function () {
                $('#xiaoquAddress').autocomplete("/inquiry/splitAddress", {
                    width: 411,
                    minChars: 0,
                    scroll: true,
                    matchCase: false,
                    scrollHeight: 300,
                    delay: 400,
                    selectFirst: false,
                    matchSubset: false,
                    dataType: "json",
                    extraParams: {
                        v: function () {
                            var xiaoquAddressstr =  $('#xiaoquAddress').val();
                            return xiaoquAddressstr;
                        },
                        city: function () {
                            var _icitystr=$('#_icity').val();
                            return _icitystr;
                        },
                        accurateType: 1,
                        matchType: 1
                    },
                    parse: function (result) {
                        if (result != null && result.code) {
                            if (result.data.length !== 0) {
                                var obj = result.data[0];
                                $('#xiaoquID').val(obj.residentialareaId); //在自动补全中获取小区ID
                                $('#xingzhengqu').val(obj.districtFullName); //小区所属行政区
                                $('#xiaoquName').val(obj.residentialareaName); //小区名称
                                $('#jutidizhi').val(obj.similarAddress); //小区地址
                                $('#quyu').val(obj.districtFullName);
                                $('#residentialName').val(void 0 == obj.residentialareaName ? "" : obj.residentialareaName);
                                _fn.jiansuoType = result.retrievalMethod;
                                if (result.retrievalMethod == "房本检索") {
                                    $('#louzhuangStr').attr('data-id', obj.buildingID).val(obj.residentialareaName + obj.buildingName);
                                    $('#danyuanStr').attr('data-id', obj.unitID).val(obj.unitName);
                                    $('#huhaoStr').attr('data-id', obj.houseID).val(obj.houseName);
                                }
                                return $.map(result.data, function (row) {
                                    if (row == null) {
                                        return;
                                    }
                                    return {
                                        data: row,
                                        value: row.SearchFlag == "小区名称" ? row.residentialareaName : row.residentialareaName,
                                        result: row.SearchFlag == "小区地址" ? row.similarAddress : row.similarAddress
                                    }
                                });
                            } else {
                                return {
                                    data: [],
                                    value: "",
                                    result: ""
                                }
                            }
                        } else {
                            return {
                                data: [],
                                value: "",
                                result: ""
                            }
                        }
                    },
                    formatItem: function (row) {
                        if (row.SearchFlag == "小区地址") {
                            return row.similarAddress;
                        }
                        return row.residentialareaName + "&nbsp;&nbsp;(" + row.similarAddress + ")";
                    },
                    formatResult: function (row) {
                        if (row.SearchFlag == "小区地址") {
                            return row.similarAddress;
                        }
                        return row.similarAddress;
                    },
                    formatMatch: function (row) {
                        if (row.SearchFlag == "小区地址") {
                            return row.similarAddress;
                        }
                        return row.similarAddress;
                    }
                }).result(function (event, data) {
                    $('#xiaoquAddress').val(data.similarAddress);//小区地址
                    $('#xiaoquID').val(data.residentialareaId); //在自动补全中获取小区ID
                    $('#xingzhengqu').val(data.districtFullName); //小区所属行政区
                    $('#xiaoquName').val(data.residentialareaName); //小区名称
                    $('#residentialName').val(void 0 == data.residentialareaName ? "" : data.residentialareaName);//小区名称
                    $('#jutidizhi').val(data.similarAddress); //小区地址
                    $('#quyu').val(data.districtFullName);//行政区
                    $('#jiansuoType').val(data.retrievalMethod);//检索方式
                    $('#louzhuangStr').attr('data-id', _fn.getNull(data.buildingID)).val(typeof (data.buildingID) == "undefined" ? "" : data.residentialareaName + data.buildingName);
                    $('#danyuanStr').attr('data-id', _fn.getNull(data.unitID)).val(_fn.getNull(data.unitName));
                    $('#huhaoStr').attr('data-id', _fn.getNull(data.houseID)).val(_fn.getNull(data.houseName));
                    _fn.initHouseInfo();
                    _fn.getTeshuyinsu($('#xiaoquName').val());
                    _fn.initfn();
                    $("#inquiryResult").hide();
                });
            },
            //小区名称和地址拆分查询
            searched: function (name) {
                if ("" == name)
                    return void layer.tips("输点内容再搜索吧！", "#xiaoquAddress", {
                        tips: [2, "#F99228"]
                    });
                if(!_fn.getErrorCity()) return ;
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "/inquiry/splitAddress",
                    async: !1,
                    data: {
                        v: function () {
                            var xiaoquAddressstr = $('#xiaoquAddress').val();
                            return xiaoquAddressstr;
                        },
                        city: function () {
                            var _icitystr =   $('#_icity').val();
                            return _icitystr;
                        },
                        accurateType: 1,
                        matchType: 1
                    },
                    success: function (result) {
                        if (result != null && result.code) {
                            if (result.data.length !== 0) {
                                var e = result.data;
                                _fn.jiansuoType = result.retrievalMethod;
                                if (e) {
                                    var obj = e[0];
                                    $('#quyu').val(obj.districtFullName);
                                    $('#xiaoqudizhi').val(obj.similarAddress); //小区地址
                                    $('#xiaoquID').val(obj.residentialareaId); //在自动补全中获取小区ID
                                    $('#xingzhengqu').val(obj.districtFullName); //小区所属行政区
                                    $('#xiaoquName').val(obj.residentialareaName); //小区名称
                                    $('#residentialName').val(void 0 == obj.residentialareaName ? "" : obj.residentialareaName);
                                    if (result.retrievalMethod == "房本检索") {
                                        $('#louzhuangStr').attr('data-id', obj.buildingID).val(obj.residentialareaName + obj.buildingName);
                                        $('#danyuanStr').attr('data-id', obj.unitID).val(obj.unitName);
                                        $('#huhaoStr').attr('data-id', obj.houseID).val(obj.houseName);
                                    }
                                    _fn.initHouseInfo();
                                    _fn.getTeshuyinsu($('#xiaoquName').val());
                                    _fn.initfn();
                                    $("#inquiryResult").hide();
                                }
                            }
                        }
                    }
                })
            },
            //提交询价表单
            subit: function () {
                if ($('#formData').valid()) {
                    var $$price = "暂无数据", $$totalPrice = "暂无数据", priceObj = $('#priceObj'), totalPriceObj = $('#totalPriceObj');
                    if(!_fn.getErrorCity()) return;
                    if ($('#xiaoquID').val() == "") {
                        return dialog = layer.tips("抱歉！没找到相关小区，请换个条件试试！", "#xiaoquAddress", {
                            tips: [1, '#F99228']
                        });
                    }
                    var wylx = $('#WuYeLeiXing').val();
                    var cqxz = $('#ChanQuanXingZhi').val();
                    if (wylx == "" || wylx == "请选择" || wylx == "普通住宅") {
                        wylx = "住宅";
                    }
                    else {
                        if ("独栋" == wylx || "联排" == wylx || "双拼" == wylx || "叠拼" == wylx) {
                            wylx = "别墅";
                        } else {
                            wylx = "住宅";
                        }
                    }
                    cqxz = forrment(cqxz);
                    if (cqxz != "") {
                        cqxz = "产权性质：" + cqxz;
                    }
                    $.ajax({
                        type: "POST",
                        dataType: "json",
                        url: "/inquiry/getXunJiaXinXi",
                        beforeSend: showLoading(),
                        data: {
                            city_name:$("#_icity").val(),
                            pianqu: $('#quyu').val(),
                            house_type: wylx,
                            area: $('#MianJi').val(),
                            filter: $('#xiaoquName').val(),
                            room_type: '',
                            danyuan: $('span[data-type=danyuan]').attr("data-id"),
                            residentialName: $('#xiaoquName').val(),
                            address: $('#xiaoquName').val(),
                            floor_building: $('span[data-type=louzhuang]').attr("data-id"),
                            hu: "",
                            builted_time: $('#JianChengNianDai').val(),
                            floor: $('#SuoZaiLouCeng').val(),
                            totalfloor: $('#ZongLouCeng').val(),
                            toward: forrment($('#ChaoXiang').val()),
                            special_factors: forrment($('#TeShuYinSu').val()),
                            house_number: $('span[data-type=hu]').attr("data-id"),
                            position: $('#xiaoquName').val(),
                            others: cqxz,
                            HuanXian: '',
                            xiaoquID: $('#xiaoquID').val(),
                            xingzhengqu: $('#xingzhengqu').val(),
                            xiaoqujunjia: '',
                            louzhuangStr: $('#result_louzhuang').find("span").text(),
                            danyuanStr: $('#result_danyuan').find("span").text(),
                            huhaoStr: $('#result_hu').find("span").text(),
                            retrievalMethod: _fn.jiansuoType
                        },
                        success: function (result) {
                            if (result) {
                                if (result.vcmIsThere) {
                                    $$price = result.shichangdanjia + "元";
                                    $$totalPrice = result.zongjia + "万元";
                                }
                            }
                            priceObj.text($$price);
                            totalPriceObj.text($$totalPrice);
                            $('#inquiryResult').show();
                            closeLoading();
                        },
                        error: function () {
                            priceObj.text("获取失败");
                            totalPriceObj.text("获取失败");
                            $('#inquiryResult').show();
                            closeLoading();
                        }
                    });
                }
            },
            //工具(undefined转变为空字符串)
            getNull: function (str) {
                if (typeof(str) === "undefined") {
                    str = "";
                }
                return str;
            },
            //工具(获取索引)
            getIndex:function($$arry,$$obj){
                for (var i = 0; i < $$arry.length; i++) {
                    if ($$obj == $$arry[i]) {
                        return i;
                    }
                }
                return -1;
            },
            //工具(城市提示)
            getErrorCity:function(){
                if(!_fn.getFlag()){
                     dialog = layer.tips("抱歉！没匹配城市，请输入下拉选择值或者选择下拉选项！", "#_icity", {
                        tips: [1, '#F99228'],time:0
                    },function(){ return false;});
                    return false;
                }else{
                    return true;
                }
            },
            getFlag:function(){
                var $$val =$("#_icity").val();
                if($$val==""||_fn.getIndex(cities,$$val)==-1){
                    return false;
                }else{
                    return true
                }
            }
        };
    })(window);
});