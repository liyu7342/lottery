<div class="yui-b">
    <div id="userli" curl="5" class="module g-li">
        <div class="hd g-tif">
            <h3>賬號管理<span>數量</span></h3>
        </div>
        <div class="bd">
            <ul class="g-hover">
                <#if user.usertype lt 1>
                    <li><a curl='0' href='/user/index1'>大股東</a><cite>0</cite></li>
                </#if>
                <#if user.usertype lt 2>
                    <li><a curl='0' href='/user/index2'>小股東</a><cite>${gudongNumber!'0'}</cite></li>
                </#if>
                <#if user.usertype lt 3>
                    <li><a curl='0' href='/user/index3'>總代理</a><cite>${zongdaiNumber!'0'}</cite></li>
                </#if>
                <#if user.usertype lt 4>
                    <li><a curl='0' href='/user/index4'>代理商</a><cite>${dailiNumber!'0'}</cite></li>
                </#if>
                <#if user.usertype lt 5>
                    <li><a curl='5' href='/user/index'>會員</a><cite>${memberNumber!'0'}</cite></li>
                </#if>
            </ul>
        </div>
        <div class="ft">
            <div class="dotbg"></div>
        </div>
    </div>
</div>