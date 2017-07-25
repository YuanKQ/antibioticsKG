<#--父模板-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/html">
<style>

    .links line {
        stroke: #999;
        stroke-opacity: 0.6;
    }

    .nodes circle {
        stroke: #fff;
        stroke-width: 3px;
    }

</style>
<head>
<#--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">-->
<#include "/template/head.html">
    <title><@block name="baseTile">系统简介</@block></title>
</head>

<body>
<#include "/template/navigationBar.html">
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
                                <div class="col-md-10">
                                    <p class="lead">IASO知识图谱是由北京大学互联网信息工程研发中心（CIRE）<a href="http://netlab.pkusz.edu.cn/wordpress/wp-content/uploads/2017/05/致2018报考互联网中心学生招生信.pdf/">雷凯和沈颖课题组</a>花费近两年时间构建的一个涵盖了药物，疾病，症状，治疗等类型实体及其关系的相对全面而完备的全科医学知识图谱。
                                        IASO知识图谱基于现有的医学本体，在线百科，权威医学文献等高质量医学数据资源构建而成的，未来还将不断添加更多的医学实体及其层次化类别信息，继续迭代更新完善知识图谱。
                                    </p>
                                    <p>
                                        <a class="lead" href="/antibioticKG?graph=antibiotic&amp;keywords=Flucloxacillin" role="button">查看知识图谱 <i class="icon-angle-right"></i></a> 
<#--锚点-->
                                        <a class="lead" href="#Paper" role="button">相关论文 <i class="icon-angle-right"></i></a>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <br>
                        <h2><font face="微软雅黑"><strong>系统介绍</strong></font></h2>
                        <hr>
                        <p>系统将IASO知识图谱部分内容公开，旨在实现领域内的共享，支持其他后续的研究开展。</p>
                        <p>目前，系统以有向图的形式展现医学实体的层次类别及关系，支持用户查询医学实体。</p>
                        <p>
                            在未来，系统还将陆续推出以下功能：<br>
                            1. 【目录索引模块】以树状结构展现整个知识图谱规模，供用户浏览整个知识库。<br>
                            2. 【使用说明模块】将分别以文件下载和接口调用两种方式将IASO知识图谱部分开源出来，实现领域内的共享，支持其他后续的研究开展。
                        </p>
                        <p>系统目前公开了的“英文抗生素知识图谱（AntibioticKG）”，以抗生素为中心，由常见抗生素，疾病，病菌，感染部位，并发症，症状，症状类型及其关系组成，共计45余万实体和近6千条关系。
                            系统还将陆续公布IASO知识图谱的其他部分。敬请期待</p>
<#--此处应插入图片-->
                        <br>
                        <a name="Paper"></a> <h2><font face="微软雅黑"><strong>相关论文</strong></font></h2>
                        <hr>
                        <ol>
                            <li><p>Lei K, Si S C, Li Y L,  Du N, Yuan K Q, Shen Y, Fan W. Discovering Medical Entity Relations from Texts using Dependency Information, 2017 8th International Joint Conference on Natural Language Processing (IJCNLP 2017), November 27- December 1, Taipei, Taiwan.</p></li>
                            <li><p>Lei K, Deng Y, Zhang B, Chen D Y, Shen Y. Open Domain Question Answering with Character-level Deep Learning Models, The 6th Conference on Natural Language Processing and Chinese Computing (NLPCC 2017), November 8-12, 2017, Dalian, China.</p></li>
                            <li><p>Wen D S, Shen Y, Li Y L, Du N, Zhong E H, Lei K, Fan W. Attention-aware Path-based Relation Extraction for Medical Knowledge Graph, 2017 6th International Conference on Innovation, Knowledge, and Management (ICIKM 2017), November 6-10, 2017, Singapore.</p></li>
                            <li><p>Colloc J, Yameogo R, Summons P, Shen Y, Park M, Aronson J E. EPICE an Emotion Fuzzy Vectorial Space for Time Modeling in Medical Decision, 2017 International Conference on Internet of Things and Machine Learning (IML 2017), October 17-18, 2017, Liverpool John Moores University. Liverpool city, United Kingdom.</p></li>
                            <li><p>Shen Y, Wen D S, Yuan K Q, Zhang L Z, Colloc J, Lei K. An Ontology-Driven Clinical Decision Support System (IDDAP) for Infectious Disease Diagnosis and Antibiotics Prescription. Artificial Intelligence in Medicine, 2017.</p></li>
                            <li><p>Lei K, Yuan K Q, Zhang Q, Shen Y*. MedSim: A Novel Semantic Similarity Measure in Bio-medical Knowledge Graphs, Transaction on Bid Data, Special issue: Knowledge Graphs: Techniques and Applications, 2017.</p></li>
                            <li><p>Shen Y, Zhang L Z, Wen D S, Zhang Q, Si S C, Yuan K Q, Deng Y, Lei K. IASO: A Medical Decision Support System based on Ontologies and the Improved Naïve Bayes to Aid in Gastroenterology Diagnoses. Artificial Intelligence in Medicine, 2017.</p></li>
                            <li><p>Lei K, Zhang L Z, Shen Y*, Wu J C. Syndromes Diagnostic Model for Coronary artery disease (CAD): an improved Naïve Bayesian Classification Model Based on Attribute Relevancy, 2017 IEEE 2nd International Conference on Big Data Analysis (ICBDA 2017), March 10-12, 2017, Beijing, China.</p></li>
                            <li><p>Lei K, Si S C, Wen D S, Shen Y*. An Enhanced Computational Feature Selection Method for Medical Synonym Identification via Bilingualism and Multi-Corpus Training, 2017 IEEE 2nd International Conference on Big Data Analysis (ICBDA 2017), March 10-12, 2017, Beijing, China. (Best paper)</p></li>
                            <li><p>Shen Y, Colloc J, Jacquet-Andrieu A, Lei K. Emerging Medical Informatics with Case-Based Reasoning for Aiding Clinical Decision in Multi-Agent System. Journal of Biomedical Informatics, 2015, 56: 307–317.</p></li>
                            <li><p>Wei Chen, Tengjiao Wang, Dongqing Yang, Kai LEI and Yueqin Liu,” Massively Parallel Learning of Bayesian Networks with MapReduce for Factor Relationship Analysis”, IJCNN 2013, Dallas，USA, 4-9 Aug，2013.</p></li>
                            <li><p>Kai LEI, Guangyu Sun, Lian’en Huang, “Template-based Delta Compression of Large Scale Web Pages”, ICCIP2013, Applied Mechanics and Materials (ISSN: 1662-7482), Volumes 347-350, Pages: 2666-2672, Aug, 2013. (20133616698923)</p></li>
                            <li><p>Yin Zeng, Wu Lin, Kai Lei*, Lian’en Huang, “Improving retrieval performance with Wikipedia's category knowledge”, ICCIS 2012, P449-452 (20124615657930).</p></li>
                            <li><p>Chunyang Wei，Hongyan Li，Kai LEI，Tengjiao Wang，“Efficient Cube Computing on An Extended Multidimensional Model over Uncertain Data”. 9th International Conference on Fuzzy Systems and Knowledge Discovery (FSKD 2012).</p></li>
                            <li><p>Yonggang Zhang, Kai LEI* and Lian’en Huang,“Using Anchor Text Refined by Page Importance to Improve Web Retrieval”, ICCSE2012, July, 2012, P1200-1203，Melbourne. (20124515635824).</p></li>
                            <li><p>袁凯琦, 邓扬, 陈道源，张冰, 沈颖*, 雷凯.医学知识图谱构建技术与研究进展[J].计算机应用研究.</p></li>
                        </ol>

                        <br>
                        <h2><font face="微软雅黑"><strong>项目支持</strong></font></h2>
                        <hr>
                        <ol>
                            <li><p>2016-2018：医学诊治过程中知识推理的关键技术研究，国家自然科学基金青年科学基金。</p></li>
                            <li><p>2016-2019：全科医学决策知识图谱构建方法和技术研究，深圳市基础研究重点项目。</p></li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </div>


<#--网页footer部分-->
<#include "/template/footer.ftl">

</body>
</html>