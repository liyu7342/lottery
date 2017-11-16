
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript">
        var domainOK = 1, domain = 'pm10.x.mmm33.us';
        window.gms_fcorp = parseInt("0",10);
        try{if(domain){document.domain = domain;}}catch(x){domainOK = 0;}
    </script>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>f2213 - A28</title>
    <link rel="stylesheet" href="../../resources/css/gray/common.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="../../resources/css/gray/mike.chen.css?ms2.4.7_3106" type="text/css">
    <link rel="stylesheet" href="/chat/webchat/css/kefu.css?ms2.4.7_3106" type="text/css">


</head>
<body class="member_create" >
<div id="doc3" class="yui-t2 fixh">
    <div id="bd">
        <div id="yui-main">
            <div class="yui-b">
                <div class="yui-g">
                    <div id="memcreate" class="module">
                        <form id="create" method="post" action="/member/save">
                            <div class="hd g-tm">
                                <ul>
                                    <li><h2 class="g-tit">新增代理</h2></li>
                                    <li>&nbsp<span>上級总代理：${user.parentName!''}</span></li>
                                    <li><a class="btn1 cs"  onclick="location.href='/user/index';return false;" href="javascript:void(0)">返回</a></li>
                                </ul>
                            </div>
                            <div class="bd g-new">
                                <div class="g-tif"><h3>基本資料設定</h3></div>
                                <table class="g-t1 g-t2 t1">
                                    <tbody nomovod><tr>
                                        <td>名稱</td>
                                        <td id="c_username"><input type="text" valid='name' maxlength="16" name="name" value="${(user.name)!''}" /></td>
                                        <td>賬號</td>
                                        <td> <input type="text" valid='account' title="1-12個數字或字母字符" maxlength="12" name="account" placeholder="1-12個數字/字母" value="${(user.account)!''}" class="gray"/> </td>
                                        <td> 密碼</td>
                                        <td><input type="password" title="6-12個字符，必須包含字母和數字!" maxlength="12" name="password" value="" valid="password"/></td>
                                        <td>確認密碼</td>
                                        <td><input type="password" title="6-12個字符，必須包含字母和數字!" maxlength="12" size="15" name="member_repassword2" value="" valid="password"/> </td>
                                        <input type="hidden" name="pwd"/>   </tr>
                                    <tr>
                                        <td>總信用額度</td>
                                        <td><input type="text" valid="credit" title="0~0" maxlength="9" size="8" name="credits" placeholder="0~0" value="${(user.credits)!''}" class="gray"/>
                                        </td>
                                        <td colspan="2">對此會員佔成比例(<font color='red'>%</font>)
                                            <select class="w2" name="member_shareUp" >
                                                <option selected="selected" value="0">0</option>      </select><input type="hidden" name="sharecorp" value=""/>
                                        </td>

                                        <td>盤口</td>
                                        <td><select class="w1" name="handicap"  >
                                            <option value="A" selected="selected">A</option>
                                            <option value="B" >B</option>
                                            <option value="C" >C</option>
                                        </select></td>
                                        <td> 狀態</td>
                                        <td><select class="w4" name="status">
                                            <option value="0" >停用</option>
                                            <option value="1" selected="selected">啟用</option>
                                            <option value="2" >停押</option>
                                        </select></td>
                                    </tr>
                                    <tr>
                                        <td>倍數投注</td>
                                        <td>
                                            <select class="w4" name="orderStatus">
                                                <option value="0" selected="selected" />不允許</option>
                                                <option value="1"  />允許</option>
                                            </select>
                                        </td>
                                        <td colspan="10">
                                        </td>
                                    </tr>
                                    </tbody></table>
                                <table class="g-t1 g-t2 mt t2 hline">
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
                                        <td><input type="text" valid="amount" name="itemmax7" value="${limitSets.gameType_07.singlehighest!''}"/></td>
                                    </tr>
                                    <tr class="discount_A">
                                        <td>A盤退水(<font color='red'>%</font>)</td>
                                        <td>
                                            <em class="oddset_em">特A</em><input type="text"  name="discountAA00" valid="dis" value="${limitSets.gameType_A00.aRetreat!''}" minval="0" maxval="13.3" insval="0.1" alternateval="0.5"/>
                                            <em class="oddset_em">特B</em><input type="text"  name="discountAB00" valid="dis" value="${limitSets.gameType_B00.aRetreat!''}" minval="0" maxval="3.3" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA01" valid="dis" value="${limitSets.gameType_01.aRetreat!''}" minval="0" maxval="11.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA02" valid="dis" value="${limitSets.gameType_02.aRetreat!''}" minval="0" maxval="13.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA03" valid="dis" value="${limitSets.gameType_03.aRetreat!''}" minval="0" maxval="15.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA04" valid="dis" value="${limitSets.gameType_04.aRetreat!''}" minval="0" maxval="15.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA05" valid="dis" value="${limitSets.gameType_05.aRetreat!''}" minval="0" maxval="0.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA06" valid="dis" value="${limitSets.gameType_06.aRetreat!''}" minval="0" maxval="0.3" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountA07" valid="dis" value="${limitSets.gameType_07.aRetreat!''}" minval="0" maxval="0.3" insval="0.1" alternateval="0.5"/>
                                        </td>
                                    </tr>
                                    <tr class="discount_B">
                                        <td>B盤退水(<font color='red'>%</font>)</td>
                                        <td>
                                            <em class="oddset_em">特A</em><input type="text"  name="discountBA00" valid="dis" value="${limitSets.gameType_A00.bRetreat!''}" minval="0" maxval="13.3" insval="0.1" alternateval="0.5"/>
                                            <em class="oddset_em">特B</em><input type="text"  name="discountBB00" valid="dis" value="${limitSets.gameType_B00.bRetreat!''}" minval="0" maxval="3.3" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB01" valid="dis" value="${limitSets.gameType_01.bRetreat!''}" minval="0" maxval="11.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB02" valid="dis" value="${limitSets.gameType_02.bRetreat!''}" minval="0" maxval="13.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB03" valid="dis" value="${limitSets.gameType_03.bRetreat!''}" minval="0" maxval="15.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB04" valid="dis" value="${limitSets.gameType_04.bRetreat!''}" minval="0" maxval="15.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB05" valid="dis" value="${limitSets.gameType_05.bRetreat!''}"minval="0" maxval="1.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB06" valid="dis" value="${limitSets.gameType_06.bRetreat!''}" minval="0" maxval="1.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountB07" valid="dis" value="${limitSets.gameType_07.bRetreat!''}" minval="0" maxval="0.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                    </tr>
                                    <tr class="discount_C">
                                        <td>C盤退水(<font color='red'>%</font>)</td>
                                        <td>
                                            <em class="oddset_em">特A</em><input type="text"  name="discountCA00" valid="dis" value="${limitSets.gameType_A00.cRetreat!''}"  minval="0" maxval="13.5" insval="0.1" alternateval="0.5"/>
                                            <em class="oddset_em">特B</em><input type="text"  name="discountCB00" valid="dis" value="${limitSets.gameType_B00.cRetreat!''}" minval="0" maxval="3.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC01" valid="dis" value="${limitSets.gameType_01.cRetreat!''}" minval="0" maxval="11.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC02" valid="dis" value="${limitSets.gameType_02.cRetreat!''}" minval="0" maxval="13.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC03" valid="dis" value="${limitSets.gameType_03.cRetreat!''}" minval="0" maxval="15.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC04" valid="dis" value="${limitSets.gameType_04.cRetreat!''}" minval="0" maxval="15.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC05" valid="dis" value="${limitSets.gameType_05.cRetreat!''}" minval="0" maxval="2.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC06" valid="dis" value="${limitSets.gameType_06.cRetreat!''}" minval="0" maxval="2.5" insval="0.1" alternateval="0.5"/>
                                        </td>
                                        <td>
                                            <input type="text"  name="discountC07" valid="dis" value="${limitSets.gameType_07.cRetreat!''}" minval="0" maxval="2.5" insval="0.1" alternateval="0.5"/>
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
                                        <td><input type="text"  name="discountA08" valid="dis" value="${limitSets.gameType_08.aRetreat!''}" minval="0" maxval="0.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA09" valid="dis" value="${limitSets.gameType_09.aRetreat!''}" minval="0" maxval="0.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA10" valid="dis" value="${limitSets.gameType_10.aRetreat!''}" minval="0" maxval="0.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA11" valid="dis" value="${limitSets.gameType_11.aRetreat!''}" minval="0" maxval="0.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA12" valid="dis" value="${limitSets.gameType_12.aRetreat!''}" minval="0" maxval="0.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA13" valid="dis" value="${limitSets.gameType_13.aRetreat!''}" minval="0" maxval="0.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA14" valid="dis" value="${limitSets.gameType_14.aRetreat!''}" minval="0" maxval="0.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountA15" valid="dis" value="${limitSets.gameType_15.aRetreat!''}" minval="0" maxval="0.5" insval="0.1" alternateval="0.5"/></td>
                                    </tr>
                                    <tr class="discount_B">
                                        <td>B盤退水(<font color='red'>%</font>)</td>
                                        <td><input type="text"  name="discountB08" valid="dis" value="${limitSets.gameType_08.bRetreat!''}" minval="0" maxval="1.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB09" valid="dis" value="${limitSets.gameType_09.bRetreat!''}" minval="0" maxval="1.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB10" valid="dis" value="${limitSets.gameType_10.bRetreat!''}" minval="0" maxval="1.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB11" valid="dis" value="${limitSets.gameType_11.bRetreat!''}" minval="0" maxval="1.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB12" valid="dis" value="${limitSets.gameType_12.bRetreat!''}" minval="0" maxval="1.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB13" valid="dis" value="${limitSets.gameType_13.bRetreat!''}" minval="0" maxval="1.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB14" valid="dis" value="${limitSets.gameType_14.bRetreat!''}" minval="0" maxval="1.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountB15" valid="dis" value="${limitSets.gameType_15.bRetreat!''}" minval="0" maxval="1.5" insval="0.1" alternateval="0.5"/></td>
                                    </tr>
                                    <tr class="discount_C">
                                        <td>C盤退水(<font color='red'>%</font>)</td>
                                        <td><input type="text"  name="discountC08" valid="dis" value="${limitSets.gameType_08.cRetreat!''}" minval="0" maxval="2.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC09" valid="dis" value="${limitSets.gameType_09.cRetreat!''}" minval="0" maxval="2.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC10" valid="dis" value="${limitSets.gameType_10.cRetreat!''}" minval="0" maxval="2.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC11" valid="dis" value="${limitSets.gameType_11.cRetreat!''}" minval="0" maxval="2.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC12" valid="dis" value="${limitSets.gameType_12.cRetreat!''}" minval="0" maxval="2.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC13" valid="dis" value="${limitSets.gameType_13.cRetreat!''}" minval="0" maxval="2.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC14" valid="dis" value="${limitSets.gameType_14.cRetreat!''}" minval="0" maxval="2.5" insval="0.1" alternateval="0.5"/></td>
                                        <td><input type="text"  name="discountC15" valid="dis" value="${limitSets.gameType_15.cRetreat!''}" minval="0" maxval="2.5" insval="0.1" alternateval="0.5"/></td>
                                    </tr>
                                    </tbody>
                                </table>

                                <div class="g-tn"><input type="submit" name="submit" class="btn2" value="確 定"/>
                                    <input value="取 消" class="btn2" type="reset" onclick="location.href='/user/index'"/></div>
                                <input type="hidden" name="op" value='create'/>
                                <input type="hidden" name="id" value="${(user.id)!''}"/>
                                <input type="hidden" name="parentid" value="${(parentUser.id)!''}"/>

                                <input type="hidden" name="parentcredit" value="${(parentUser.credits)!''}"/>
                                <input type="hidden" name="betting" value='0' />
                                <input type="hidden" name="parentstatus" value="${(parentUser.status)!''}"/>
                                <input type="hidden" name="requestUrl" value='member/index'/>
                                <input type="hidden" name="historyNum" value='1'/>
                                <#list limitSets as limit>
                                <input type="hidden" name="pordermin${limit.limitType}" value="${limit.singlemin}" />
                                <input type="hidden" name="pordermax${limit.limitType}" value="${limit.singlemax}" />
                                <input type="hidden" name="pitemmax${limit.limitType}" value="${limit.singlehighest}" />
                                </#list>
                            </div>
                        </form>
                        <input type="hidden" name="childcount" id="childcount" value="0" />
                        <input type="hidden" name="parent_hkms_status" value="0" />
                        <div class="ft"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="yui-b">
            <div id="userli" curl="5" class="module g-li">
                <div class="hd g-tif">
                    <h3>賬號管理<span>數量</span></h3>
                </div>
                <div class="bd">
                    <ul class="g-hover">
                        <li><a curl='0' href='admin_list.htm'>管理員</a><cite>0</cite></li><li><a curl='5' href='/user/index'>會員</a><cite>1</cite></li>        </ul>
                </div>
                <div class="ft">
                    <p>在線會員數：0</p>
                    <p>在線經銷商：1</p>
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
        login_path: '/msdid63242a/account/login.html', //登錄路徑
        password_need: false, //是否開啟密碼登陸加密
        draw_refersh: 200000, //設置開關盤刷新頻率
        log4js_type:  0, //設置log4javascript的類型
        log4js_level: 'INFO', //設置log4javascript的級別
        isStrongPwd: true //是否啟用複雜密碼
    };
</script>
<script type="text/javascript" src="../../resources/library/backend/all.js?ms2.4.7_3106" defer="defer"></script>
</body>
</html>

