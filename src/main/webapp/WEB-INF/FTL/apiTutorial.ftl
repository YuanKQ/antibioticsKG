<#--测试页面-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<#--<%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>-->
<#include "template/head.html">
    <title>API使用说明</title>
</head>
<style>

    /*body {
        margin: 0;
    }

    rect {
        stroke: #fff;
        stroke-width: .1px;
    }*/

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
                                <div class="col-md-10" >
                                    <p class="lead">系统目前公开了的“英文抗生素知识图谱（AntibioticKG）”，以抗生素为中心，由常见抗生素，疾病，病菌，感染部位，并发症，症状，症状类型及其关系组成，共计45余万实体和近6千条关系。

                                        研究者现可以通过调用系统提供的API，获取“英文抗生素知识图谱（AntibioticKG）”中的实体，关系，以查询实体为中心的微型知识图谱。
                                    <br>
                                        使用前请仔细阅读<a href="#contract">数据集使用协议</a>.
                                    </p>
                                    <a class="lead" href="antibioticKG?graph=antibiotic&amp;keywords=Flucloxacillin" role="button">查看知识图谱 <i class="icon-angle-right"></i></a> 
                                    <a class="lead" href="#tutorial" role="button">查看教程<i class="icon-angle-right"></i></a>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <br>
                        <a name="contract"></a><h2><font face="微软雅黑"><strong>数据集使用协议</strong></font></h2>
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
                        <a name="tutorial"></a><h2><font face="微软雅黑"><strong>使用说明</strong></font></h2>
                        <hr>
                        <p>本系统API设计参照RESTful API设计原则, 目前完成查询(读取资源)操作.</p>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-10">
                                    <h2>医学实体查询</h2>
                                    <p>目前提供antibiotic(抗生素), bacteria(病菌), complication(并发症), disease(疾病), infection_site(感染部位), symptom(症状), symptom_type(症状类型)共七种类型实体的查询, 查询结果以json格式返回.
                                    </p>

                                    <p >API调用方式: <code class="json">[GET]  /api/{entity_type}/{entity_name}</code><br>
                                        {entity_type}可选值为: antibiotics, bacterias, complications, diseases, infection_sites, symptoms, symptom_types<br>
                                        {entiry_name}为用户查询的实体名称
                                    </p>
                                    <h3>实例</h3>
                                    <p> 查询抗生素Amoxycillin <code class="json">[GET]  /api/antibiotics/Amoxycillin</code><br>返回结果如下,
                                    </p>
                                    <pre id="entityJSON"></pre>
                                    <br>
                                    <h2>实体关系查询</h2>
                                    <p>目前提供抗生素, 病菌, 并发症, 疾病, 感染部位, 症状, 症状类型共七种类型实体之间的关系查询, 查询结果以json格式返回, 返回内容涵盖实体关系类型, 关系的方向. 可能存在同名实体分别属于不同的类型实体, 返回结果涵盖多种关系的现象.
                                    </p>

                                    <p >API调用方式:  <code class="json">[GET]  /api/relations/{entity1}/{entity2}</code><br>
                                        {entity1}, {entiry2}均为用户查询的实体名称.
                                    </p>
                                    <h3>实例</h3>
                                    <p> 查询Diphtheria与Corynebacterium之间的关系:  <code class="json">[GET]  /api/relations/Corynebacterium/Diphtheria</code><br>返回结果如下,
                                    </p>
                                    <pre><code id="relationJSON"></code></pre>

                                    <br>
                                    <h2>子图查询</h2>
                                    <p>目前提供子图(微型知识图谱)查询, 该子图由中心实体(调用者提供的查询实体)及其与该中心实体直接关联的关系和实体组成. 可能存在同名实体分别属于不同的类型实体, 返回结果涵盖多个子图的现象.


                                    </p>

                                    <p >API调用方式: <code class="json">[GET]  /api/subgraphs/{entity_name}</code><br>
                                        {entiry_name}为用户查询的实体名称
                                    </p>
                                    <h3>实例</h3>
                                    <p> 查询实体ear的子图 <code class="json">[GET]  /api/subgraphs/Ear</code><br>返回结果如下,
                                    </p>
                                    <pre id="subgraphJSON"></pre>
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
<script type="text/javascript" name="displayCode">
    function output(inp, preId) {
        document.getElementById(preId).innerHTML = inp;
//        document.body.appendChild(document.createElement('pre')).innerHTML = inp;
    }

    function syntaxHighlight(json) {
        json = json.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
        return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function (match) {
            var cls = 'number';
            if (/^"/.test(match)) {
                if (/:$/.test(match)) {
                    cls = 'key';
                } else {
                    cls = 'string';
                }
            } else if (/true|false/.test(match)) {
                cls = 'boolean';
            } else if (/null/.test(match)) {
                cls = 'null';
            }
            return '<span class="' + cls + '">' + match + '</span>';
        });
    }

    var entityObj = {
        code: 0,
        msg: "success",
        data:{
            id: "31e197a0-d685-11e6-82b5-3497f68b8eda",
            name: "Amoxycillin",
            type: "unrestricted",
            description: "Amoxicillin is susceptible to degradation by 汕-lactamase-producing bacteria, which are resistant to a narrow spectrum of 汕-lactam antibiotics, such as penicillin. For this reason, it may be combined with clavulanic acid, a 汕-lactamase inhibitor. This drug combination is commonly called co-amoxiclav.",
            drug_indication: null
        }
    };
    str = JSON.stringify(entityObj, undefined, 4);
    output(str, "entityJSON");

    var relationObj = {
                code: 0,
                msg: "success",
                relations:[
                   {
                        id: null,
                        head: null,
                        tail: null,
                        relationType: "No relations"
                    },
                   {
                        id: "2c0e7ec6-d7d7-11e6-b14e-3497f68b8eda",
                        head: "Diphtheria",
                        tail: "Corynebacterium",
                        relationType: "disease-bacteria"
                    }
                ]
            };
    output(syntaxHighlight(JSON.stringify(relationObj, undefined, 4)), "relationJSON");

    var subgraohObj = {
                code: 0,
                msg: "success",
                subgraphs:[
                   {
                        center: "ear",
                        linksWith:[
                           {
                                name: "Enterobacteriaceae",
                                relation: "BacteriaToInfectionSite"
                            },
                           {
                                name: "Haemophilus influenzae",
                                relation: "BacteriaToInfectionSite"
                            },
                           {
                                name: "Moraxella",
                                relation: "BacteriaToInfectionSite"
                            },
                           {
                                name: "Proteus",
                                relation: "BacteriaToInfectionSite"
                            },
                           {
                                name: "Pseudomonas",
                                relation: "BacteriaToInfectionSite"
                            },
                           {
                                name: "Staph. epidermidis",
                                relation: "BacteriaToInfectionSite"
                            },
                           {
                                name: "Strep. pneumoniae",
                                relation: "BacteriaToInfectionSite"
                            }
                        ]
                    },
                    {
                        center: "ear",
                        linksWith:[
                           {
                                name: "Local",
                                relation: "SymptomTypeToSymptomType"
                            }
                        ]
                    }
                ]
            };
    output(syntaxHighlight(JSON.stringify(subgraohObj, undefined, 4)), "subgraphJSON");

</script>
</html>