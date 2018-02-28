<!DOCTYPE HTML >
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = '';
        try{if(domain){document.domain = domain;}}catch(x){domainOK = 0;}
    </script>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>f2211 - A28</title>
    <link rel="stylesheet" href="../../resources/css/new/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/new/mike.chen.css?ms2.4.7_3106" type="text/css">
    <script type="text/javascript" src="../../../resources/library/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" src="../../../resources/library/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" src="../../../resources/library/ueditor/lang/zh-cn/zh-cn.js"></script>
</head>
<body class="rule">
<div id="doc3" class="yui-t7">
    <div id="bd">
        <div class="yui-g">
            <div id="rule" class="module">
                <div class="hd"></div>
                <div class="bd" style="text-align: center;">
                    <div class="g-tn">
                        <select id="noticetype" name="noticetype">
                            <option value="0" selected>系统公告</option>
                            <option value="1">特殊公告</option>
                        </select>
                    </div>
                    <script id="editor" type="text/plain" style="width:99%;height:500px; margin:0 auto;"></script>
                    <div class="g-tn"><input type="button" class="btn2" id="btn2"  onclick="b_click()" value="確 定"/>
                    </div>
                </div>
                <div class="ft"></div>
            </div>
        </div>
    </div>
    <div id="ft">
        <div id="footer" class="module" style="display:none">
            <div class="hd rh"></div>
            <div class="bd rb">Copyright 2008-2017 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>    </div>
</div>
</body>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
<script type="text/javascript">
    var ue = UE.getEditor('editor');

    function b_click(){
        var t= ue.getPlainTxt();
        $.ajax({
            url:'/notice/save',
            data:{"content":t,"type":$("#noticetype").val()},
            type:'POST',
            dataType:'json',
            success:function (result) {
                if(result==1){
                    alert("保存成功！");
                    location.href="/notice/index";
                }
                else{
                    alert("保存失败！")
                }

            }
        })
    }

</script>
</html>
