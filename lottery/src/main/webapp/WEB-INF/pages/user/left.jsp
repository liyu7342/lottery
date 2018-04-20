<div class="yui-b">
    <div id="userli" curl="5" class="module g-li">
        <div class="hd g-tif">
            <h3>賬號管理<span>數量</span></h3>
        </div>
        <div class="bd">
            <ul class="g-hover">
                <#if user.usertype gt 0 && user.usertype lt 5>
                    <li>curl='0' href='/user/admin_list'>管理員</a><cite>0</cite></li>
                </#if>
                <#if user.usertype lt 1>
                    <li><a <#if currentPage==1 >curl='5' <#else>curl='0'</#if>  href='/user/index1'>大股東</a><cite>0</cite></li>
                </#if>
                <#if user.usertype lt 2>
                    <li><a <#if currentPage==2 >curl='5' <#else>curl='0'</#if> href='/user/index2'>小股東</a><cite>${gudongNumber!'0'}</cite></li>
                </#if>
                <#if user.usertype lt 3>
                    <li><a <#if currentPage==3 >curl='5' <#else>curl='0'</#if> href='/user/index3'>總代理</a><cite>${zongdaiNumber!'0'}</cite></li>
                </#if>
                <#if user.usertype lt 4>
                    <li><a <#if currentPage==4 >curl='5' <#else>curl='0'</#if> href='/user/index4'>代理商</a><cite>${dailiNumber!'0'}</cite></li>
                </#if>
                <#if user.usertype lt 5>
                    <li><a <#if currentPage==0 >curl='5' <#else>curl='0'</#if> href='/user/index'>會員</a><cite>${memberNumber!'0'}</cite></li>
                </#if>
            </ul>
        </div>
        <div class="ft">
            <div class="dotbg"></div>
        </div>
    </div>
</div>