<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <link href="../../../resources/css/base.css" rel="stylesheet" type="text/css"/>
    <link href="../../../resources/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    <!--[if IE 7]>
    <link href="../../../resources/css/font-awesome-ie7.min.css" rel="stylesheet" type="text/css">
    <![endif]-->
    <link href="../../../resources/library/jquery-autocomplete/jquery.autocomplete.css" rel="stylesheet"
          type="text/css"/>
    <link rel="stylesheet" href="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.css"/>
    <link href="../../../resources/css/index.css" rel="stylesheet" type="text/css"/>
    <link href="../../../resources/library/jquery-autocomplete/jquery.autocomplete.css" rel="stylesheet" />
</head>
<body class="f-oh">
<div class="p-5">
    <div class="f-cf autoprefixed">
        <div class="autoprefixed-fl xxl">
            <div class="autoprefixed-fl-wrap">
                <form id="formData" class="form-tb">
                    <table>
                        <tr>
                            <td class="fuild-width">房屋坐落<font style="color:red;">(房本地址)</font></td>
                            <td colspan="3">
                                <textarea rows="2" name="HouseAddress" class="inpt" id="HouseAddress"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td class="fuild-width">城市</td>
                            <td>
                                <input type="text" name="CityName" class="inpt" id="CityName"/>
                            </td>
                            <td class="fuild-width">行政区</td>
                            <td>
                                <input type="text" name="DistrictFullName" class="inpt" id="DistrictFullName"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="fuild-width " style="color: red">小区名称</td>
                            <td id="residentialName1">
                                <input type="text" class="inpt" name="ResidentialName" id="residentialName" value=""/>
                                <input type="hidden" class="inpt" name="ResidentialareaID" id="residentialNameid" value=""/>
                            </td>
                            <td class="fuild-width" style="color: red">楼幢名称</td>
                            <td id="bulidHouse1">
                                <input type="text" name="HouseBuildingName" class="inpt" id="houseBuildings"
                                       value=""/><input
                                    type="hidden" name="HouseBuildingID" class="inpt" id="houseBuildingsid" value=""/>
                            </td>
                        </tr>
                        <tr>
                            <td class="fuild-width" style="color: red">单元名称</td>
                            <td id="units1">
                                <input type="text" name="UnitName" class="inpt" id="units" value=""/>
                                <input type="hidden" name="UnitID" class="inpt" id="unitsid" value=""/>
                            </td>
                            <td class="fuild-width" style="color: red">户名</td>
                            <td id="houses1">
                                <input type="text" name="HouseName" class="inpt" id="houses" value=""/>
                                <input type="hidden" name="" class="inpt" id="housesid" value=""/>
                            </td>
                        </tr>
                        <tr>
                            <td class="fuild-width">所在楼层</td>
                            <td>
                                <input type="text" name="Floor" class="inpt" id="Floor" value=""/>
                            </td>
                            <td class="fuild-width">总楼层</td>
                            <td>
                                <input type="text" name="Floors" class="inpt" id="Floors" value=""/>
                            </td>
                        </tr>
                        <tr>
                            <td class="fuild-width">建筑面积</td>
                            <td>
                                <input type="text" name="BuildingArea" class="inpt" id="BuildingArea" value=""/>
                            </td>
                            <td class="fuild-width">套内建筑面积</td>
                            <td>
                                <input type="text" name="InsideOfBuildingArea" class="inpt" id="InsideOfBuildingArea "
                                       value=""/>
                            </td>
                        </tr>
                        <tr>
                            <td class="fuild-width">房屋性质</td>
                            <td colspan="3">
                                <input type="text" name="HouseNature" class="inpt" id="HouseNature" value=""/>
                            </td>

                        </tr>
                        <tr>
                            <td class="fuild-width">规划用途</td>
                            <td colspan="3">
                                <input type="text" name="RecordUseType" class="inpt" id="RecordUseType" value=""/>
                            </td>

                        </tr>
                        <tr>
                            <td class="fuild-width">地图坐标X</td>
                            <td colspan="3">
                                <input type="text" class="inpt" id="XLongitude" name="XLongitude"/>
                            </td>

                        </tr>
                        <tr>
                            <td class="fuild-width">地图坐标y</td>
                            <td colspan="3">
                                <input type="text" class="inpt" id="YLatitude" name="YLatitude"/>
                            </td>

                        </tr>
                    </table>
                </form>
            </div>
        </div>
        <div class="autoprefixed-fr">
            <div class="autoprefixed-fr-wrap xxl">
                <div class="toolbar" style="border-bottom:1px solid #ccc">
                    <table class="toolbar-form">
                        <tr>
                            <td>
                                <input type="text" name="filterName" id="filterName" placeholder="小区名称/房屋地址"
                                       class="form-input auto"/>
                            </td>
                            <td class="col-width xsm">
                                <button type="button" class="btn btn-xs btn-green" id="btnSearch">查询</button>
                            </td>
                        </tr>
                    </table>
                </div>
                <div class="wrap" style="height:280px" id="map"></div>
            </div>
        </div>
    </div>
</div>
<p class="f-tc">
    <button type="button" class="btn btn-blue" id="fixInfo">修正房屋信息</button>
</p>
<script type="text/javascript" src="../../../resources/library/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-placeholder/jquery.placeholder.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-autocomplete/jquery.autocomplete.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=605a2a5c838d8346cbc00aeab168908b"></script>
<script type="text/javascript"
        src="http://api.map.baidu.com/library/DrawingManager/1.4/src/DrawingManager_min.js"></script>
<script type="text/javascript" src="../../../resources/library/layer/layer.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-validation/jquery.validate.min.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-validation/validataboxextend.js"></script>
<script type="text/javascript" src="../../../resources/library/help/jquery.extends.js"></script>
<script type="text/javascript" src="../../../resources/library/help/help.js"></script>
<script type="text/javascript" src="../../../resources/library/help/city.js"></script>
<script type="text/javascript" src="../../../resources/library/help/array.extends.js"></script>
<script type="text/javascript" src="../../../resources/library/jquery-autocomplete/jquery.autocomplete.js"></script>
<script type="text/javascript">
    var $arry = [], dialog;
    //    var _city = "昆明市";
    //    var _residentialAddress = "昆明市官渡区龙泉镇金殿青龙山2-2幢501号";
    var _city = parent._obj.city;
    var _residentialAddress = parent._obj.residentialAddress;
    var _residentialName = parent._obj.residentialName;
    var _area = parent._obj.area;
    var map, local, drawingManager, marker, points = [];
    $(function () {
        $("#CityName").val(_city);
        $("#BuildingArea").val(_area);

        $("#filterName,#HouseAddress").val(_residentialAddress);
        $("#HouseAddress").change(function () {
            setTimeout(function () {
                _residentialAddress = $("#HouseAddress").val();
                $("#filterName").val(_residentialAddress);
                search(_residentialAddress);
                bindData();
            }, 200);

        });
        bindData();
        initMap(_city);
        search(_residentialAddress);
        /*切换城市重新初始化地图*/
        $("#CityName").cityAutoComplete(function (event, item, data) {
            initMap(data);
        });

        validForm();


        $("#fixInfo").click(function () {
            if ($("#formData").valid()) {
                if (cities.indexOf( $("#CityName").val())==-1) {
                    dialog = layer.tips("请选择下拉列表数据", "#CityName", {
                        tips: [1, '#F99228']
                    });
                    return false;
                }

                if ($("#residentialName").val() == ""){
                    dialog = layer.tips("请输入小区名称", "#residentialName", {
                        tips: [1, '#F99228']
                    });
                    return false;
                }
                var oData = $("#formData").serializeObject();
                if ($("#residentialName").is( "input")) {
                    oData.ResidentialName = $("#residentialName").val();
                }
                $.ajax({
                    url: "/inquiry/estimateHouse",
                    data: oData,
                    cache: false,
                    success: function (result) {
                        if (result && result.Success) {
                            layer.alert("保存成功！");
                        }
                        else {
                            layer.alert(result.message);
                        }
                        console.log(result);
                    }
                })
            }
        });
        $("#btnSearch").click(function(){
            search($("#filterName").val());
        });
    });

    /*初始化地图包括城市*/
    function initMap(name) {
        map = new BMap.Map("map", {
            minZoom: 6,
            maxZoom: 19
        });
        map.addControl(new BMap.NavigationControl());
        map.centerAndZoom(name, 14);

        map.enableScrollWheelZoom(true);

        initdrawingManager();

        local = new BMap.LocalSearch("广州市", {
            renderOptions: {
                map: map
            },
            onSearchComplete: function (results) {
                if (local.getStatus() == BMAP_STATUS_SUCCESS) {
                    for (var i = 0; i < results.getCurrentNumPois(); i++) {
                        var poi = results.getPoi(i);

                        if (i == 0) {
                            $("#XLongitude").val(poi.point.lng)
                            $("#YLatitude").val(poi.point.lat)
                        }
                        console.log("名称:" + poi.title + ";X:" + poi.point.lng + ";Y:" + poi.point.lat);

                    }
                }
            }
        });
    }


    /*查询*/
    function search(name) {
        if (name!== "") {
            console.clear();
            local.search($.trim($("#filterName").val()));
        }

    }

    function initdrawingManager() {
        drawingManager = new BMapLib.DrawingManager(map, {
            isOpen: true,
            enableDrawingTool: false,
            drawingToolOptions: {
                anchor: BMAP_ANCHOR_TOP_RIGHT,
                offset: new BMap.Size(5, 5),
                scale: 0.8
            }
        });

        drawingManager.open(BMAP_DRAWING_MARKER);

        drawingManager.addEventListener('overlaycomplete', function (e) {
            if (e.drawingMode == "marker") {
                points.push(e.overlay);
                $("#XLongitude").val(e.overlay.point.lng);
                $("#YLatitude").val(e.overlay.point.lat);
            }
        });

        drawingManager.addEventListener("markercomplete", function (e, overlay) {
            clearAllMapInfo();
        });
    }

    /*清空标注*/
    function clearAllMapInfo() {
        for (var i = 0; i < points.length; i++) {
            map.removeOverlay(points[i]);
        }
        points = [];
    }

    function validForm() {
        $("#formData").validate({
            onkeyup: false,
            rules: {
                HouseAddress: {
                    required: true
                },
                CityName: {
                    required: true
                },
                BuildingArea: {
                    posintdec: true
                },

                InsideOfBuildingArea: {
                    posintdec: true
                },
                Floor: {
                    floor: true,
                    formsz: true
                },
                Floors: {
                    posint: true,
                    formzs: true
                },
                XLongitude: {
//                    required: true,
                    num: true
                },
                YLatitude: {
//                    required: true,
                    num: true
                }
            },
            messages: {
                HouseAddress: {
                    required: "请输入房屋坐落"
                },
                CityName: {
                    required: "请输入城市名称"
                },
                BuildingArea: {
                    posintdec: "请最多输入两位小数的数字"
                },
                InsideOfBuildingArea: {
                    posintdec: "请最多输入两位小数的数字"
                },
                Floor: {
                    floor: "请输入正确所在楼层",
                    formsz: "所在楼层小于或等于总楼层"
                },
                Floors: {
                    posint: "请输入正确总楼层",
                    formzs: "总楼层大于或等于所在楼层"
                },
                XLongitude: {
//                    required: "请输入地图X坐标",
                    isDigits: "请输入数字"
                },
                YLatitude: {
//                    required: "请输入地图Y坐标",
                    isDigits: "请输入数字"
                }
            },
            errorPlacement: function (error, element) {
                if (error[0].innerHTML != "") {
                    dialog = layer.tips(error[0].innerHTML, "#" + element[0].id, {
                        tips: [1, '#F99228']
                    });
                    $("#" + element[0].id).addClass("error");
                }
            },
            success: function (label) {
                layer.close(dialog);
                $("#" + label[0].htmlFor).removeClass("error");
            }
        });
    }


    function bindData() {
        $.ajax({
            type: "get",
            url: "/inquiry/getSegmentationResult",
            async: true,
            beforeSend: loadTips.showLoading(),
            data: {
                filter: _residentialAddress,
                city: $("#CityName").val()
            },
            cache: false,
            dataType: "json",
            success: function (result) {
                loadTips.hideLoadind();
                if (result) {
                    if (result.code == 0 && result.data) {
                        var $obj;
                        residentialNameArry = [], houseBuildingArry = [], unitArry = [], huArry = [], str = '<option value="">请选择</option>', innerStr = "", _flag = false, _id = "";
                        $obj = result.data,
                                $("#DistrictFullName ").val($obj.districtName);
                        $("#houseBuildings").val($obj.houseBuildingName);
                        $("#units").val($obj.unitName);
                        $("#houses").val($obj.houseName);
                        debugger;
                        residentialNameArry = removeNullIDArray($obj.baseInfo.residentials, "residentialName");
                        if (residentialNameArry.length > 1) {
                            return outLayer("匹配结果有多个小区,请联系数据部门同事进行数据核实！");
                        } else {

                            if (residentialNameArry.length !== 0) {
                                $("#residentialNameid").val(residentialNameArry[0].id);
                                houseBuildingArry = residentialNameArry[0].houseBuildings;
                                houseBuildingArry = removeNullIDArray(houseBuildingArry, "houseBuildings");
                                if (houseBuildingArry.length > 1) {
                                    return outLayer("匹配结果有多个楼幢,请联系数据部门同事进行数据核实！");
                                } else {
                                    if (houseBuildingArry.length !== 0) {
                                        getLiandong("xiaoqu",residentialNameArry[0].id,function(data){
                                            var index = data.indexOfById(houseBuildingArry[0].id);
                                            if(index>-1)
                                                $("#houseBuildings").val(data[index].name);
                                        });
                                        $("#houseBuildingsid").val(houseBuildingArry[0].id);
                                        unitArry = houseBuildingArry[0].units;
                                        unitArry = removeNullIDArray(unitArry, "units");
                                        if (unitArry.length > 1) {
                                            return outLayer("匹配结果有多个单元,请联系数据部门同事进行数据核实！");
                                        } else {
                                            if (unitArry.length !== 0) {

                                                getLiandong("louzhuang",houseBuildingArry[0].id,function(data){
                                                    var index = data.indexOfById(unitArry[0].id);
                                                    if(index>-1)
                                                        $("#units").val(data[index].name);
                                                });
                                                $("#unitsid").val(unitArry[0].id);
                                                huArry = unitArry[0].houses;
                                                huArry = removeNullIDArray(huArry, "houses");
                                                if (huArry.length > 1) {
                                                    return outLayer("匹配结果有多个户,请联系数据部门同事进行数据核实！");
                                                } else {
                                                    if (huArry.length !== 0) {
                                                        getLiandong("danyuan",unitArry[0].id,function(data){
                                                            var index = data.indexOfById(huArry[0].id);
                                                            if(index>-1)
                                                                $("#houses").val(data[index].name);
                                                        });
                                                        $("#housesid").val(huArry[0].id);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        //拆分的数据是否存在于模糊匹配数组
                        if (_residentialName && residentialNameArry.indexOfByAttr("residentialName", _residentialName) < 0) {
                            residentialNameArry.push({residentialName: _residentialName, id: ""});
                        }
                        //列表中小区是否存在于模糊匹配数组
                        if ($obj.residentialName && residentialNameArry.indexOfByAttr("residentialName", $obj.residentialName) < 0) {
                            residentialNameArry.push({residentialName: $obj.residentialName, id: ""});
                        }

                        //只有一条记录且不存在id
                        if (residentialNameArry.length > 1 && !residentialNameArry[0].id) {

                            $("#residentialName").autocomplete(residentialNameArry, {
                                width: $("#residentialName").width() + parseInt($("#residentialName").css("padding-left")) + parseInt($("#residentialName").css("padding-right")),
                                max: residentialNameArry.length,
                                minChars: 0,
                                autoFill:true,
                                matchContains: false,
                                scroll: true,
                                scrollHeight: 180,
                                showAll:true,
                                formatItem: function (row) {
                                    return row.residentialName;
                                }
                            });
                        }
                        if (residentialNameArry.length > 0){
                            $("#residentialName").val(residentialNameArry[0].residentialName);
                        }


                    }
                }
            },
            error: function () {
                loadTips.hideLoadind();
            }
        });
    }


    function selectObj(obj) {
        var text = $("#" + obj.target.id).find("option:selected").text();
        if (text == "请选择") {
            $("#residentialNameid").val("");
            layer.msg("请勿选择空数据源", {}, function () {
                return false;
            });
            return false;
        } else {
            var residentialNameid =$("#" + obj.target.id).val();
            if(residentialNameid)
                $("#residentialNameid").val(residentialNameid);
        }

    }



    function removeNullIDArray(arry, type) {
        var _arry = [];
        $.each(arry, function (i, n) {
            if (n.id !== "") {
                _arry.push(n);
            }
        });
        return _arry;
    }

    function removeNullArray(arry, type) {
        var _arry = [];
        $.each(arry, function (i, n) {
            if (n.id !== "" && n["" + type] !== "") {
                _arry.push(n);
            }
        });
        return _arry;
    }

    function outLayer(msg) {
        parent.layer.alert(msg);
        parent.layer.close(parent.editInfo);
        return false;
    }


    function getLiandong(_type,_id,fn){
        $.ajax({
            type: 'post',
            url: '/inquiry/getLiandong',
            data: {
                'city': $("#CityName").val(),
                'id': _id,
                'type': _type
            },
            dataType: 'json',
            success: function (data) {
                if (data.success) {
                    if (data.list != null) {
                       fn&& fn(data.list);
                       /* list = data.list;
                        temp = '';
                        for (var i = 0; i < list.length; i++) {
                            len = list[i].id;
                            name = list[i].name;
                            reqType = list[i].type;
                            resTempType = list[0].type;
                            temp += '<li data-id="' + len + '" data-type="' + reqType + '" data-index="' + i + '">' + name + '</li>';
                        }
                        _fn.insertElem(resTempType, temp);*/
                    }
                }
            }
        });
    }

</script>
</body>

</html>
