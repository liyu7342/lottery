<link href="../../../resources/css/index.css" rel="stylesheet" />
<link href="../../../resources/css/base.css" rel="stylesheet" />
<body class="f-oh"> <div class="p-5">
    <div class="form-tb">
        <form id="formData">
            <table>
                <tr>
                    <td class="fuild-width">名称</td>
                    <td>
                        <input type="text" name="name" class="inpt" id="txtname" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">编码</td>
                    <td>
                        <input type="text" name="code" class="inpt" id="code" />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">排序</td>
                    <td>
                        <input type="text" name="sortCode" class="inpt" id="sortCode"   />
                    </td>
                </tr>

            </table>
            <p class="f-tc p-5">
                <button type="button" class="btn btn-blue" id="btnSave">添加</button>
            </p>
        </form>
    </div>
    <script type="text/javascript" src="../../../resources/library/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="../../../resources/library/help/jquery.extends.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#btnSave").on("click",function(){
                var oData= $("#formData").serializeObject();
                oData.dataDictionaryId ="${itemid}"
                $.ajax({
                    url:"/datadictionary/save",
                    data:oData,
                    success:function(result){
                        if(result){
                            parent.layer.closeAll();
                            parent.search();
                        }
                    }
                })
            }) ;
        });
    </script>
</body>
