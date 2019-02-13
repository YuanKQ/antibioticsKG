<div class="panel">
    <#--<script type="text/javascript">-->
        <#--//添加用户-->
        <#--function clickButton() {-->
            <#--var form = document.forms[0];-->
            <#--form.action = "/search";-->
            <#--form.method = "get";-->
            <#--form.submit();-->
        <#--}-->
    <#--</script>-->

    <div class="panel-body">
        <div class="container">
            <div id="searchForm">
                <div class="row">
                    <div class="col-md-2">
                        <h1><font face="微软雅黑">IASO</font></h1>
                        <p><strong>Knowledge Graph</strong></p>
                    </div>
                    <div class="col-md-10">
                        <br>
                        <div class="input-group">
                        <@block name="searchMention">
                            <input type="text" id="keywords" name="keywords" class="form-control input-lg"
                                   placeholder="搜索......" value="AmBisome" ">

                        </@block>

                            <!--<input type="button" class="btn btn-default  btn-lg" onclick="clickButton()" value="search">-->
                            <span class="input-group-btn">
                                <!--<button type="submit" class="btn btn-default  btn-lg" ><span class="glyphicon glyphicon-search"></span></button>-->
                                <input type="button" class="btn btn-default  btn-lg" onclick="clickButton()" value="search">
                            </span>
                        </div>

                    <#--为了确定搜索的领域：抗生素知识图谱【英文】，抗感染药物知识图谱【中文】，索引-->
                        <div >
                        <@block name="baseDomain">
                            <input type="hidden" id="graph" name="graph" value="IASO">
                        </@block>
                        </div>
                        <p>hot：
                            <@block name="recommendation">
                            <a href="search?keywords=中药&amp;graph=IASO">IASO1</a> 
                            <a href="search?keywords=气&amp;graph=IASO">IASO2</a> 
                            <a href="search?keywords=五行&amp;graph=IASO">IASO3</a>
                            </@block>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>