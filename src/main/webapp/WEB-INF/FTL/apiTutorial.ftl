<#--测试页面-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<head>
<#--<%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>-->
<#include "template/head.html">
    <title>API tutorial</title>
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

    <h1 class="text-muted"><font face="微软雅黑"><strong>IASO Knowledge Graph</strong></font></h1>
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
                                    <p class="lead" align="left"><font face="Times New Roman"> The Antibiotic KG, which is currently published in the system, centers on antibiotics and consists of common antibiotics, diseases, pathogens, infection sites, complications, symptoms, types of symptoms and their relationships, totaling more than 450,000 entities and nearly 6,000 relationships. Researchers can now obtain entities, relationships and query entity-centered micro-knowledge maps in the "Antibiotic KG" by calling API provided by the system.
                                    <br>
                                        Read carefully before using<a href="#contract"> Dataset download protocol</a>.
                                    </p>
                                    <p align="left">
                                    <a class="lead" href="antibioticKG?graph=antibiotic&amp;keywords=Flucloxacillin" role="button">View Knowledge Graph <i class="icon-angle-right"></i></a> 
                                    <a class="lead" href="#tutorial" role="button">View tutorial<i class="icon-angle-right"></i></a>
                                    </font>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <br>
                        <a name="contract"></a><h2><font face="Times New Roman"><strong>Data Set Usage Protocol</strong></font></h2>
                        <hr>
                        <p><font face="Times New Roman">You (hereinafter referred to as "Researcher") are requesting the IASO Open Source System to grant you the right to access, download and use data sets (hereinafter referred to as "data sets"). As a condition for obtaining such authorization, you agree to abide by the following terms:</font></p><br/>
                        <p><font face="Times New Roman">
                            1. Researchers agree to use data sets only for non-commercial scientific research or classroom teaching purposes. It is strictly forbidden to use data sets for clinical diagnosis and not for any commercial purposes.<br/>

                            2. We do not enjoy the intellectual property rights of pictures, audio, text and other contents used in data sets, and do not guarantee the aforementioned contents, including, but not limited to, infringement of the intellectual property rights of others or the use of the aforementioned contents for any specific purpose;<br/>

                            3. We are not liable for any form of loss or damage caused by the use of data sets, and will not be liable for any legal consequences arising from the use of data sets.<br/>

                            4. Any legal liability related to the use of data sets shall be borne by researchers. If the use of data sets by researchers or their employees, agents or branches causes reputation or economic losses to us, researchers shall be liable for compensation.<br/>

                            5. Researchers may authorize their assistants, colleagues or other partners to access and use data sets, but they shall ensure that the aforementioned persons have carefully read and agree to be bound by this Agreement.<br/>

                            6. If a researcher is employed by a profit-making business entity, he or she shall ensure that data sets are used only for non-commercial purposes and that his or her employer is also bound by this Agreement. The researcher confirms that he or she has obtained sufficient authorization from the employer before signing this Agreement.<br/>

                            7. We have the right to revoke or withdraw the authorization of researchers to use datasets at any time, and to request researchers to delete downloaded datasets.
                        </font></p>

                        <br>
                        <a name="tutorial"></a><h2><font face="Times New Roman"><strong>Tutorial</strong></font></h2>
                        <hr>
                        <p><font face="Times New Roman">The system API design refers to RESTful API design principles, and now completes the query (read resources) operation.<br>
                            A KG is composed of several elements. Through RESTful API, IASO displays the KG components that the user could discern the information effortlessly, and are the following:
                        </font></p>
                        <div class="container">
                            <div class="row">
                                <div class="col-md-10">
                                    <font face="Times New Roman">

                                    <h2>Taxonomy Query</h2>
                                    <p>The presentation of the taxonomy on which the knowledge graph is based is significant for understanding the inheritance relations between classes. Our system provides a holistic view of this taxonomy, in a hierarchical representation. The partial views that allow the user to focus on a portion of other relationships, are achieved through the aspects shown below.
                                    </p>

                                    <h2>Entity Facts Query</h2>
                                        <p>
                                            The visualization system displays all the knowledge graph classes, at the request of the user, providing the name and other information, in an intelligible manner. As shown in Figure 1, our aim is to extract knowledge related to Amoxicillin from the KG. The corresponding information, such as an ID, a name, a drug type, a description, as well as the drug indication information, are the actual data and in most cases what the user is actually interested in. This disambiguated information can aid the user to look up known information.
                                        </p>
                                    <p>At present, antibiotic, bacteria, complication, disease, infection_site, symptom and symptom_type are provided for seven types of entity queries. The query results are returned in JSON format.
                                    </p>

                                    <p >API calls: <code class="json">[GET]  /api/{entity_type}/{entity_name}</code><br>
                                        {entity_type} the optional values are: antibiotics, bacterias, complications, diseases, infection_sites, symptoms, symptom_types<br>
                                        {entiry_name} is entity name for user query
                                    </p>
                                    <h3>Example</h3>
                                    <p> Query antibiotic Amoxycillin <code class="json">[GET]  /api/antibiotics/Amoxycillin</code><br>The results are as follows,
                                    </p>
                                    <pre id="entityJSON"></pre>
                                    <br>


                                    <h2>Entity Relation Query</h2>
                                    <p>The extraction process starts with a set of triples for a given relation. For example, (diphtheria, disease_bacteria, corynebacterium) would be a valid triple for the disease_bacteria relation. The input entity is processed to recognize and match with the KG concept (see Figure 2). When an entity matches a KG concept, a subgraph will be returned to present all its connected entities, the relation type and the relation direction from head entity to tail entity. Any other entity which does not appear in the KG has no relationship with the input entity. There may be a variety of relationships when an entity belongs to different entity types.
                                    </p>
                                    <p>At present, there are seven types of entity relationship queries for antibiotics, pathogens, complications, diseases, infection sites, symptoms and symptom types. The results of the query are returned in JSON format. The content of the query covers entity relationship types and the direction of the relationship. There may be phenomena that the same name entity belongs to different types of entity, and the returned results cover multiple relationships.</p>
                                    <p >API calls:  <code class="json">[GET]  /api/relations/{entity1}/{entity2}</code><br>
                                        {entity1}, {entiry2}are entity names for user query.
                                    </p>
                                    <h3>Example</h3>
                                    <p> Query the relationship of Diphtheria and Corynebacterium  <code class="json">[GET]  /api/relations/Corynebacterium/Diphtheria</code><br>The results are as follows,
                                    </p>
                                    <pre><code id="relationJSON"></code></pre>

                                    <br>
                                    <h2>Subgraph Query</h2>
                                    <p>Taxonomy and entity relations are two types of links that transform the knowledge graph from a hierarchy to a graph. When receiving an entity queried by user, IASO returns a subgraph composed of this entity and the entities that it is directly related to (see Figure 3). For example, “ear” is considered as an infectious site in infectious disease diagnosis. Its pathogenic bacteria include enterobacteriaceae, Haemophilus influenzae, moraexlla, proteus, etc. Apart from the link that should be visible, a label with the link name (effectively, the relation type) is also displayed.

                                    </p>
                                        <p>
                                            At present, sub-graph (micro knowledge map) query is provided. The sub-graph is composed of Central entity (query entity provided by caller) and its relationship and entity directly associated with the central entity. There may be the phenomenon that the same-name entity belongs to different types of entity, and the returned result covers multiple sub-graphs.
                                        </p>

                                    <p >API calls:<code class="json">[GET]  /api/subgraphs/{entity_name}</code><br>
                                        {entiry_name} is entity name for user query
                                    </p>
                                    <h3>Example</h3>
                                    <p> Query the subgraph of the entity ear <code class="json">[GET]  /api/subgraphs/Ear</code><br>The results are as follows,
                                    </p>
                                    <pre id="subgraphJSON"></pre>
                                    </font>
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