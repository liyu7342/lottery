(function ($) {
    $.prototype.serializeObject = function () {
        var a, o, h, i, e;
        a = this.serializeArray();
        o = {};
        h = o.hasOwnProperty;
        for (i = 0; i < a.length; i++) {
            e = a[i];
            if (!h.call(o, e.name)) {
                o[e.name] = e.value;
            }
        }
        return o;
    };
    //排除为空的节点
    $.prototype.serializeObjectExceptNull = function () {
        var a, o, h, i, e;
        a = this.serializeArray();
        o = {};
        h = o.hasOwnProperty;
        for (i = 0; i < a.length; i++) {
            e = a[i];
            if (!h.call(o, e.name)) {
                if(e.value)
                    o[e.name] = e.value;
            }
        }
        return o;
    };
    $.prototype.setForm = function (jsonValue) {
            var obj = this;
            $.each(jsonValue, function (name, ival) {
                var $oinput = obj.find("input[name=" + name + "]");
                if ($oinput.attr("type") == "checkbox") {
                    if(ival == true){
                        $("[name=" + name + "]").attr("checked","checked");
                    }
                    else if (ival !== null) {
                        var checkboxObj = $("[name=" + name + "]");
                        var checkArray = ival.split(";");
                        for (var i = 0; i < checkboxObj.length; i++) {
                            for (var j = 0; j < checkArray.length; j++) {
                                if (checkboxObj[i].value == checkArray[j]) {
                                    checkboxObj[i].click();
                                }
                            }
                        }
                    }
                }
                else if ($oinput.attr("type") == "radio") {
                    $oinput.each(function () {
                        var radioObj = $("[name=" + name + "]");
                        for (var i = 0; i < radioObj.length; i++) {
                            if (radioObj[i].value == ival) {
                                radioObj[i].click();
                            }
                        }
                    });
                }
                else if ($oinput.attr("type") == "textarea") {
                    obj.find("[name=" + name + "]").html(ival);
                }
                else {
                    obj.find("[name=" + name + "]").val(ival);
                }
            })

        } ;
})(jQuery);