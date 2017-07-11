/**
 * Created by Administrator on 2017/5/10.
 */
var cities=[];
(function($){
    $.fn.extend({
        _cityData:[],
        citySelect:function(callback){
            var obj=this;
            $.ajax({
                url:"/inquiry/getCities",
                type:"GET",
                success: function (cities) {
                    var opt=[];
                    opt.push("<option value=''>请选择</option>");
                    if(cities){
                        $.each(cities, function (index, city) {
                            opt.push("<option value='"+city.cityName+"'>"+city.cityName+"</option>");
                        });
                    }
                    obj.html(opt.join(""));
                    callback && callback();
                }
            })
        },
        cityAutoComplete:function(callback){
            if(!callback) callback=function(){};
            var obj =this;

            $.ajax({
                url:"/inquiry/getCities",
                type:"GET",
                success: function (result) {
                    cities=[];
                    $.each(result,function(index,city){
                        cities.push(city.cityName);
                    })
                    obj.autocomplete(cities, {
                        width:obj.width()+parseInt(obj.css("padding-left"))+parseInt(obj.css("padding-right")),
                        max: cities.length,
                        minChars: 0,
                        scroll: true,
                        scrollHeight: 180
                    }).result(callback);
                }
            })

        }
    });
})(jQuery);