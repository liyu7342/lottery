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
    <link href="../../../resources/css/index.css" rel="stylesheet" type="text/css" />
</head>
<body class="f-oh">
<div class="p-5">
    <div class="picList" id="picList">
    </div>
</div>
<script type="text/javascript" src="../../../resources/library/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../../resources/library/layer/layer.js"></script>
<script type="text/javascript" src="../../../resources/library/help/help.js"></script>
<script type="text/javascript">
    var dialog;
    $(function() {
        if('${id!""}'){
            drawHtml();
            $.ajax({
                url:"/document/getDocuments",
                data:{"reftable":"inquiry","refrecordId":'${id!""}'},
                success:function(result){
                    var quedata=[];
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
    });

    function  drawHtml(data){
        var drawStr='';
        if(data&&data.length>=1){
            drawStr='<ul class="f-cf">';
            $.each(data,function(i,key){
                drawStr+='<li><img title="'+key.fileName+'" alt="'+key.fileName+'" src="/document/download?resourceId='+key.resourceId+'&fileName='+key.fileName+'"/><p>'+key.fileName+'</p></li>';
            });
            drawStr+='</ul>';
        }else{
            drawStr='<p class="f-tc">暂无数据</p>';
        }
        $("#picList").html(drawStr);
    }

</script>
</body>

</html>
