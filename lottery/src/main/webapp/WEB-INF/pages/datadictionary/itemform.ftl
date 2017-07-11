<link href="../../../resources/css/index.css" rel="stylesheet" />
<link href="../../../resources/css/base.css" rel="stylesheet" />
<body class="f-oh"> <div class="p-5">
    <div class="form-tb">
        <form id="formData">
            <table>
               <#-- <tr>
                    <td class="fuild-width">上级</td>
                    <td>
                        <select id="source" name="parentId" class="inpt">
                            <option value="">请选择</option>
                        </select>
                    </td>

                </tr>-->
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
                        <input type="text" name="sortCode" class="inpt" id="sortOrder"   />
                    </td>
                </tr>
                <tr>
                    <td class="fuild-width">备注</td>
                    <td colspan="3">
                        <textarea type="text" name="remark" class="inpt" id="remark" ></textarea>
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
               $.ajax({
                   url:"/datadictionary/saveSortManage",
                   data:oData,
                   success:function(result){
                        if(result){
                            parent.refresh();
                            parent.layer.closeAll();
                        }
                   }
               })
           }) ;
        });
    </script>
</body>
