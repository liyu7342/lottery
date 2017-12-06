
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>${user.account!''} - A28</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">
</head>
<body class="user2_create" >
<div id="doc3" class="yui-t2 fixh">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="u1create" class="module">

                        <form id="create" method="post" action="/member/save">
                            <div class="hd g-tm">
                                <ul>
                                    <li><h2 class="g-tit">新增小股東</h2></li>
                                    <li>&nbsp;&nbsp;<span>上级股東：${parentUser.userName!''}</span></li>
                                    <li><a class="btn1 cs" onclick="location.href='/user/index2';return false;" href="javascript:void(0);">返回</a></li>
                                </ul>
                            </div>
                            <div class="bd g-new" >
                                <div class="g-tif"><h3>基本資料設定</h3></div>

                                <table class="g-t1 g-t2 t1">
                                    <tbody nomovod><tr>
                                        <td>名稱</td>
                                        <td id="c_username"><input type="text" valid='name' maxlength="16" name="userName" value="${info.userName!''}" /></td>
                                        <td>賬號</td>
                                        <td><input type="text" valid='account' title="4-12個數字或字母字符" maxlength="12" <#if info.id!="">disabled="disabled"</#if>  name="account"  value="${info.account!''}"  class="gray"/> </td>
                                        <td>密碼</td>
                                        <td><input type="password" maxlength="12" title="6-12個字符，必須包含字母和數字!" name="password" value="" <#if info.id=="">valid="password"</#if> /></td>
                                        <td>確認密碼</td>
                                        <td><input type="password" maxlength="12" title="6-12個字符，必須包含字母和數字!" name="sys_user_repassword2" <#if info.id=="">valid="password"</#if> value="" /></td>
                                    </tr>
                                    <tr>
                                        <td>總信用額度</td>
                                        <td><input type="text" valid="credit" maxlength="9" name="credits"  title="0~1000000" value="${credits!''}" class="gray"/>
                                        </td>
                                        <td>盤口</td>
                                        <td><select class="w1" name="sys_user_oddsSet"  >
                                            <option value="C" <#if "C" ==info.sys_user_oddsSet>selected="selected"</#if> >C</option>
                                            <option value="B" <#if "B" == info.sys_user_oddsSet>selected="selected"</#if> >B</option>
                                            <option value="A" <#if "A" == info.sys_user_oddsSet>selected="selected"</#if> >A</option>
                                        </select></td>
                                        <td>補貨設定</td>
                                        <td><select class="w3" name="shortCovering" >
                                            <option value="0" <#if info.shortCovering==0>selected="selected"</#if> >不允許</option>
                                            <option value="1" <#if info.shortCovering==1>selected="selected"</#if>  >允許</option>
                                        </select></td>
                                        <td>狀態</td>
                                        <td><select class="w4" name="status">
                                            <option value="0" <#if info.status==0>selected="selected"</#if>  >停用</option>
                                            <option value="1" <#if info.status==1>selected="selected"</#if> >啟用</option>
                                            <option value="2" <#if info.status==2>selected="selected"</#if> >停押</option>
                                        </select></td>
                                    </tr>

                                    <tr>
                                        <td colspan="2">小股東及下級佔成和(<font color='red'>%</font>)
                                            <select class="w2" name="shareTotal" >
                                                <#list shareTotalList as share>
                                                    <option  value=${share} <#if info.shareTotal==share>selected="selected"</#if>>${share}</option>
                                                </#list>
                                            </select>
                                            <input type="hidden" name="shareParent" value="${parentUser.shareTotal!'0'}"/>
                                        </td>
                                        <td colspan="2">大股東佔成數(<font color='red'>%</font>)
                                            <select class="w2" name="shareUp" >
                                                <#list shareUpList as shareup>
                                                    <option  value=${shareup} <#if info.shareUp==shareup>selected="selected"</#if>>${shareup}</option>
                                                </#list>
                                            </select>
                                        </td>
                                        <td colspan="2"> 補貨是否佔成
                                            <select class="w1" name="shareFlag" >
                                                <option value="1" selected="selected">是</option>
                                                <option value="0" >否</option>
                                            </select>
                                        </td>
                                        <td colspan="2">
                                        </td>
                                    </tr>
                                    </tbody></table>
                                <table class="g-t1 g-t2 mt t2 hline" id='gudong_discount_body'>
                                    <tbody nomovod><tr class="hline">
                                        <td></td><td>特碼</td><td>正碼</td><td>正碼特</td><td>連碼二</td><td>連碼三</td><td>過關</td><td>生肖</td><td>尾數</td>
                                    </tr>
                                    <tr>
                                        <td>單注最低</td>
                                        <td><input type="text" valid="amount" name="ordermin0" value="${limitSets.gameType_A00.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin1" value="${limitSets.gameType_01.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin2" value="${limitSets.gameType_02.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin3" value="${limitSets.gameType_03.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin4" value="${limitSets.gameType_04.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin5" value="${limitSets.gameType_05.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin6" value="${limitSets.gameType_06.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin7" value="${limitSets.gameType_07.singlemin!''}"/></td>
                                    </tr>
                                    <tr>
                                        <td>單注最高</td>
                                        <td><input type="text" valid="amount" name="ordermax0" value="${limitSets.gameType_A00.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax1" value="${limitSets.gameType_01.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax2" value="${limitSets.gameType_02.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax3" value="${limitSets.gameType_03.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax4" value="${limitSets.gameType_04.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax5" value="${limitSets.gameType_05.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax6" value="${limitSets.gameType_06.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax7" value="${limitSets.gameType_07.singlemax!''}"/></td>

                                    </tr>
                                    <tr>
                                        <td>單項最高</td>
                                        <td><input type="text" valid="amount" name="itemmax0" value="${limitSets.gameType_A00.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax1" value="${limitSets.gameType_01.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax2" value="${limitSets.gameType_02.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax3" value="${limitSets.gameType_03.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax4" value="${limitSets.gameType_04.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax5" value="${limitSets.gameType_05.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax6" value="${limitSets.gameType_06.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax7" value="${limitSets.gameType_07.singlehighest!''}"/></td>                                    </tr>
                                    <tr class="discount_A">
                                        <td>A盤退水(<font color='red'>%</font>)</td>
                                        <td>
                                            <em class="oddset_em">特A</em><input type="text"  name="discountAA00" valid="dis" value="${limitSets.gameType_A00.aRetreat!''}" minval="0" maxval="${plimit.gameType_A00.aRetreat!''}" insval="0.1" alternateval="0.5"/>
                                            <em class="oddset_em">特B</em><input type="text"  name="discountAB00" valid="dis" value="${limitSets.gameType_B00.aRetreat!''}" minval="0" maxval="${plimit.gameType_B00.aRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA1" valid="dis" value="${limitSets.gameType_01.aRetreat!''}" minval="0" maxval="${plimit.gameType_01.aRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA2" valid="dis" value="${limitSets.gameType_02.aRetreat!''}" minval="0" maxval="${plimit.gameType_02.aRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA3" valid="dis" value="${limitSets.gameType_03.aRetreat!''}" minval="0" maxval="${plimit.gameType_03.aRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA4" valid="dis" value="${limitSets.gameType_04.aRetreat!''}" minval="0" maxval="${plimit.gameType_04.aRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA5" valid="dis" value="${limitSets.gameType_05.aRetreat!''}" minval="0" maxval="${plimit.gameType_05.aRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA6" valid="dis" value="${limitSets.gameType_06.aRetreat!''}" minval="0" maxval="${plimit.gameType_06.aRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA7" valid="dis" value="${limitSets.gameType_07.aRetreat!''}" minval="0" maxval="${plimit.gameType_07.aRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                    </tr>
                                    <tr class="discount_B">
                                        <td>B盤退水(<font color='red'>%</font>)</td>
                                        <td>
                                            <em class="oddset_em">特A</em><input type="text"  name="discountBA00" valid="dis" value="${limitSets.gameType_A00.bRetreat!''}" minval="0" maxval="${plimit.gameType_A00.bRetreat!''}" insval="0.1" alternateval="0.5"/>
                                            <em class="oddset_em">特B</em><input type="text"  name="discountBB00" valid="dis" value="${limitSets.gameType_B00.bRetreat!''}" minval="0" maxval="${plimit.gameType_B00.bRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB1" valid="dis" value="${limitSets.gameType_01.bRetreat!''}" minval="0" maxval="${plimit.gameType_01.bRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB2" valid="dis" value="${limitSets.gameType_02.bRetreat!''}" minval="0" maxval="${plimit.gameType_02.bRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB3" valid="dis" value="${limitSets.gameType_03.bRetreat!''}" minval="0" maxval="${plimit.gameType_03.bRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB4" valid="dis" value="${limitSets.gameType_04.bRetreat!''}" minval="0" maxval="${plimit.gameType_04.bRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB5" valid="dis" value="${limitSets.gameType_05.bRetreat!''}"minval="0" maxval="${plimit.gameType_05.bRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB6" valid="dis" value="${limitSets.gameType_06.bRetreat!''}" minval="0" maxval="${plimit.gameType_06.bRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB7" valid="dis" value="${limitSets.gameType_07.bRetreat!''}" minval="0" maxval="${plimit.gameType_07.bRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                    </tr>
                                    <tr class="discount_C">
                                        <td>C盤退水(<font color='red'>%</font>)</td>
                                        <td>
                                            <em class="oddset_em">特A</em><input type="text"  name="discountCA00" valid="dis" value="${limitSets.gameType_A00.cRetreat!''}"  minval="0" maxval="${plimit.gameType_A00.cRetreat!''}" insval="0.1" alternateval="0.5"/>
                                            <em class="oddset_em">特B</em><input type="text"  name="discountCB00" valid="dis" value="${limitSets.gameType_B00.cRetreat!''}" minval="0" maxval="${plimit.gameType_B00.cRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC1" valid="dis" value="${limitSets.gameType_01.cRetreat!''}" minval="0" maxval="${plimit.gameType_01.cRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC2" valid="dis" value="${limitSets.gameType_02.cRetreat!''}" minval="0" maxval="${plimit.gameType_02.cRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC3" valid="dis" value="${limitSets.gameType_03.cRetreat!''}" minval="0" maxval="${plimit.gameType_03.cRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC4" valid="dis" value="${limitSets.gameType_04.cRetreat!''}" minval="0" maxval="${plimit.gameType_04.cRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC5" valid="dis" value="${limitSets.gameType_05.cRetreat!''}" minval="0" maxval="${plimit.gameType_05.cRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC6" valid="dis" value="${limitSets.gameType_06.cRetreat!''}" minval="0" maxval="${plimit.gameType_06.cRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC7" valid="dis" value="${limitSets.gameType_07.cRetreat!''}" minval="0" maxval="${plimit.gameType_07.cRetreat!''}" insval="0.1" alternateval="0.5"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="9" style="font-size:1px;">&nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td></td><td>半波</td><td>六肖</td><td>兩面</td><td>色波</td><td>特肖</td><td>生肖連</td><td>尾數連</td><td>不中</td>
                                    </tr>
                                    <tr>
                                        <td>單注最低</td>
                                        <td><input type="text" valid="amount" name="ordermin8" value="${limitSets.gameType_08.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin9" value="${limitSets.gameType_09.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin10" value="${limitSets.gameType_10.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin11" value="${limitSets.gameType_11.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin12" value="${limitSets.gameType_12.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin13" value="${limitSets.gameType_13.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin14" value="${limitSets.gameType_14.singlemin!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermin15" value="${limitSets.gameType_15.singlemin!''}"/></td>
                                    </tr>
                                    <tr>
                                        <td>單注最高</td>
                                        <td><input type="text" valid="amount" name="ordermax8" value="${limitSets.gameType_08.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax9" value="${limitSets.gameType_09.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax10" value="${limitSets.gameType_10.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax11" value="${limitSets.gameType_11.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax12" value="${limitSets.gameType_12.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax13" value="${limitSets.gameType_13.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax14" value="${limitSets.gameType_14.singlemax!''}"/></td>
                                        <td><input type="text" valid="amount" name="ordermax15" value="${limitSets.gameType_15.singlemax!''}"/></td>
                                    </tr>
                                    <tr>
                                        <td>單項最高</td>
                                        <td><input type="text" valid="amount" name="itemmax8" value="${limitSets.gameType_08.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax9" value="${limitSets.gameType_09.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax10" value="${limitSets.gameType_10.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax11" value="${limitSets.gameType_11.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax12" value="${limitSets.gameType_12.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax13" value="${limitSets.gameType_13.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax14" value="${limitSets.gameType_14.singlehighest!''}"/></td>
                                        <td><input type="text" valid="amount" name="itemmax15" value="${limitSets.gameType_15.singlehighest!''}"/></td>
                                    </tr>
                                    <tr class="discount_A">
                                        <td>A盤退水(<font color='red'>%</font>)</td>
                                        <td><input type="text"  name="discountA8" valid="dis" value="${limitSets.gameType_08.aRetreat!''}" minval="0" maxval="${plimit.gameType_08.aRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA9" valid="dis" value="${limitSets.gameType_09.aRetreat!''}" minval="0" maxval="${plimit.gameType_09.aRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA10" valid="dis" value="${limitSets.gameType_10.aRetreat!''}" minval="0" maxval="${plimit.gameType_10.aRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA11" valid="dis" value="${limitSets.gameType_11.aRetreat!''}" minval="0" maxval="${plimit.gameType_11.aRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA12" valid="dis" value="${limitSets.gameType_12.aRetreat!''}" minval="0" maxval="${plimit.gameType_12.aRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA13" valid="dis" value="${limitSets.gameType_13.aRetreat!''}" minval="0" maxval="${plimit.gameType_13.aRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA14" valid="dis" value="${limitSets.gameType_14.aRetreat!''}" minval="0" maxval="${plimit.gameType_14.aRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA15" valid="dis" value="${limitSets.gameType_15.aRetreat!''}" minval="0" maxval="${plimit.gameType_15.aRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                    </tr>
                                    <tr class="discount_B">
                                        <td>B盤退水(<font color='red'>%</font>)</td>
                                        <td><input type="text"  name="discountB8" valid="dis" value="${limitSets.gameType_08.bRetreat!''}" minval="0" maxval="${plimit.gameType_08.bRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB9" valid="dis" value="${limitSets.gameType_09.bRetreat!''}" minval="0" maxval="${plimit.gameType_09.bRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB10" valid="dis" value="${limitSets.gameType_10.bRetreat!''}" minval="0" maxval="${plimit.gameType_10.bRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB11" valid="dis" value="${limitSets.gameType_11.bRetreat!''}" minval="0" maxval="${plimit.gameType_11.bRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB12" valid="dis" value="${limitSets.gameType_12.bRetreat!''}" minval="0" maxval="${plimit.gameType_12.bRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB13" valid="dis" value="${limitSets.gameType_13.bRetreat!''}" minval="0" maxval="${plimit.gameType_13.bRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB14" valid="dis" value="${limitSets.gameType_14.bRetreat!''}" minval="0" maxval="${plimit.gameType_14.bRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB15" valid="dis" value="${limitSets.gameType_15.bRetreat!''}" minval="0" maxval="${plimit.gameType_15.bRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                    </tr>
                                    <tr class="discount_C">
                                        <td>C盤退水(<font color='red'>%</font>)</td>
                                        <td><input type="text"  name="discountC8" valid="dis" value="${limitSets.gameType_08.cRetreat!''}" minval="0" maxval="${plimit.gameType_08.cRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC9" valid="dis" value="${limitSets.gameType_09.cRetreat!''}" minval="0" maxval="${plimit.gameType_09.cRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC10" valid="dis" value="${limitSets.gameType_10.cRetreat!''}" minval="0" maxval="${plimit.gameType_10.cRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC11" valid="dis" value="${limitSets.gameType_11.cRetreat!''}" minval="0" maxval="${plimit.gameType_11.cRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC12" valid="dis" value="${limitSets.gameType_12.cRetreat!''}" minval="0" maxval="${plimit.gameType_12.cRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC13" valid="dis" value="${limitSets.gameType_13.cRetreat!''}" minval="0" maxval="${plimit.gameType_13.cRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC14" valid="dis" value="${limitSets.gameType_14.cRetreat!''}" minval="0" maxval="${plimit.gameType_14.cRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC15" valid="dis" value="${limitSets.gameType_15.cRetreat!''}" minval="0" maxval="${plimit.gameType_15.cRetreat!''}" insval="0.1" alternateval="0.5"/></td>
                                    </tr>
                                    </tbody>
                                </table>
                                <div class="g-tn"><input type="submit" name="submit" class="btn2" value="確 定"/>
                                    <input value="取 消" class="btn2" type="reset" onclick="location.href='/user/index2'"/></div>

                                <input type="hidden" name="id" value="${(info.id)!''}"/>
                                <input type="hidden" name="parentid" value="${(parentUser.id)!''}"/>
                                <input type="hidden" name="usertype" value='2'/>
                                <input type="hidden" name="parentcredit" value='${parentUser.credits}'/>

                                <input type="hidden" name="childsumcredit" value='0'/>
                                <input type="hidden" name="pageId" value='1'/>
                                <input type="hidden" name="requestUrl" value='/user/index2'/>
                                <input type="hidden" name="historyNum" value='1'/>
                                <input type="hidden" name="op" value='udp'/>
                            </div>
                        </form>
                        <input type="hidden" name="childcount" id="childcount" value="0" />

                        <input type="hidden" name="parent_hkms_status" value="0" />
                        <div class="ft"></div>
                    </div>                </div>
            </div>
        </div>
        <div class="yui-b">
            <div id="userli" curl="3" class="module g-li">
                <div class="hd g-tif">
                    <h3>賬號管理<span>數量</span></h3>
                </div>
                <div class="bd">
                    <ul class="g-hover">
                        <#if user.usertype lt 1>
                            <li><a curl='0' href='/user/index1'>大股東</a><cite>0</cite></li>
                        </#if>
                        <#if user.usertype lt 2>
                            <li><a curl='5' class="red" href='/user/index2'>小股東</a><cite>0</cite></li>
                        </#if>
                        <#if user.usertype lt 3>
                            <li><a curl='0' href='/user/index3'>總代理</a><cite>0</cite></li>
                        </#if>
                        <#if user.usertype lt 4>
                            <li><a curl='0' href='/user/index4'>代理商</a><cite>0</cite></li>
                        </#if>
                        <#if user.usertype lt 5>
                            <li><a curl='0' href='/user/index'>會員</a><cite>0</cite></li>
                        </#if>
                    </ul>
                </div>
                <div class="ft">
                    <p>在線會員數：9</p>
                    <p>在線經銷商：2</p>
                    <div class="dotbg"></div>
                </div>
            </div>        </div>
    </div>
    <div id="ft">
        <div id="footer" class="module">
            <div class="hd rh"></div>
            <div class="bd rb">Copyright 2008-2017 ©SixPlay Online Casino. All rights reserved.</div>
            <div class="ft"></div>
        </div>    </div>
</div>
<script type="text/javascript">
    window.setting = {
        login_path: '/msdid6321379a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 20000, //設置開關盤刷新頻率
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

