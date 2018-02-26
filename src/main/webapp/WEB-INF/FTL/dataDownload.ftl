<#--测试页面-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <#--<%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>-->
    <#include "template/head.html">
    <title>数据下载页面</title>
</head>
<style>

    body {
        margin: 0;
    }

    rect {
        stroke: #fff;
        stroke-width: .1px;
    }

</style>
<body>
<#include "template/navigationBar.html">
<div class="container">

    <h1 class="text-muted"><font face="微软雅黑"><strong>IASO知识图谱</strong></font></h1>
    <div class="panel">
        <div class="panel-body">
            <div class="container">
                <div class="row">
                    <div class="col-md-offset-1 col-md-10">
                        <div class="container" align="center">
                        <#--<h1 style="font-weight: 300;line-height: 1;letter-spacing: -1px;"><font face="微软雅黑"><strong>IASO知识图谱</strong></font></h1>-->
                            <br>
                            <div class="row">
                                <div class="col-md-10"  >
                                    <p class="lead">本系统公开的数据集仅为非商业性的科学研究或课堂教学目的使用，严禁用于临床诊断，并不得将数据集用于任何商业用途。<br>
                                        使用前请仔细阅读<a href="#contract">数据集下载协议</a>.
                                    </p>
                                        <a class="lead" href="antibioticKG?graph=antibiotic&amp;keywords=Flucloxacillin" role="button">查看知识图谱 <i class="icon-angle-right"></i></a> 
                                        <a class="lead" href="#dataSet" role="button">下载数据集<i class="icon-angle-right"></i></a>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <br>
                        <a name="contract"></a><h2><font face="微软雅黑"><strong>数据集下载协议</strong></font></h2>
                        <hr>
                        <p>您（以下称“研究者”）正在请求IASO开源系统授予您访问、下载并使用数据集（以下简称“数据集”）的权利（以下简称“授权”），作为获得该等授权的条件，您同意遵守以下条款：</p><br/>
                        <p>
                            1、研究者同意仅为非商业性的科学研究或课堂教学目的使用数据集，严禁用于临床诊断，并不得将数据集用于任何商业用途；<br/>
                            2、我们不享有数据集中使用的图片、音频、文字等内容的知识产权，对前述内容不作任何保证，包括但不限于不侵犯他人知识产权或可将前述内容用于任何特定目的；<br/>
                            3、我们不承担因数据集使用造成的任何形式的损失或伤害，不会对任何因使用数据集产生的法律后果承担任何责任；<br/>
                            4、与数据集使用有关的任何法律责任均由研究者承担，如研究者或其员工、代理人、分支机构使用数据集的行为给我们造成声誉或经济损失，研究者应当承担赔偿责任；<br/>
                            5、研究者可以授权其助手、同事或其他合作者访问和使用数据集，但应确保前述人员已经认真阅读并同意接受本协议约束；<br/>
                            6、如果研究者受雇于以盈利为目的的商业主体，应确保使用数据集仅用于非商业目的，且其雇主同样受本协议约束，研究者确认其签订本协议前已经取得雇主的充分授权。<br/>
                            7、我们有权随时取消或撤回对研究者使用数据集的授权，并有权要求研究者删除已下载数据集；<br/>
                        </p>

                        <br>
                        <a name="dataSet"></a><h2><font face="微软雅黑"><strong>数据集下载</strong></font></h2>
                        <hr>
                        <div class="container">
                            <div class="row">
                            <div class="col-md-10">
                            <h3>常用抗生素语义相似度标记数据集</h3>
                            <p>数据集中涵盖了临床上最常用的10大类共40种抗生素随机组合而成的共200对抗生素对儿。

                            多名医学生参与进行评定抗生素对儿的相似程度(毫无相似，0分；极其相似，10分)。每对抗生素对儿至少保证由三名医学生参与评定，最终评定结果取医学生评分的平均值。</p>
                            <p></p>
                            <p>
                            <a href="https://github.com/YuanKQ/MedSim-antibiotics-labeled-dataset">下载数据集</a>
                            </p>
                        </div>
                        </div>
                        </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


<#--网页footer部分-->
<#include "template/footer.ftl">

</body>
</html>