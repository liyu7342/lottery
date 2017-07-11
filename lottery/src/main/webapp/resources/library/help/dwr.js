/**
 * Created by Administrator on 2017/6/13.
 */
(function(w,$){
    //这个方法用来启动该页面的ReverseAjax功能
    dwr.engine.setActiveReverseAjax( true);
    //设置在页面关闭时，通知服务端销毁会话
    dwr.engine.setNotifyServerOnPageUnload( true);
    setTimeout(function(){
        serverPush.publish("我了个操");
    },5000);


})(window,jQuery);

//这个函数是提供给后台推送的时候 调用的
function sayHellow(content){
    console.log(content)
    //layer.alert(content);
}
