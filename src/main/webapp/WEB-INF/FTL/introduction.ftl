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
<#include "template/head.html">
    <title><@block name="baseTile">System Introduction</@block></title>
</head>

<body>
<#include "template/navigationBar.html">
<div class="container">

    <h1 class="text-muted" ><font face="微软雅黑" size="6"><strong>IASO: A System for Medical Knowledge Graph Visualization and Curation</strong></font></h1>
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
                                    <p class="lead" align="left" style="text-align:justify"> <font face="Times New Roman" size="5"> We present a system for node-linkbased medical knowledge graph (KG) visualization, allowing visual inspection of knowledge subgraph based on probabilistic graph layout. Specifically, we reuse existing knowledge bases to alleviate the difficulties in building a high-quality knowledge graph, ranging in size up to 7 million edges. Then we provide insights into probability distributions for the subgraph consisted of individual nodes and edges. The visualization is created by transforming probability distributions into a two-dimensional embedding using graph layout techniques. Splatting and edge bundling are used to visualize point clouds and graph topology.</font>
                                    </p>
                                    <p class="lead" align="left" style="text-align:justify"> <font face="Times New Roman" size="5">In IASO, <b>Graph Module</b> demonstrates the detailed information of the input entity including its KG subgraph, the connected entities and their corresponding relationships. <b>Contents Index Module</b> presents the complete hierarchy taxonomy of the KG to make the inheritance relationship more understandable. The labeled datasets about the antibiotic drug similarity measure can be downloaded from  <a href="http://netlab.pkusz.edu.cn/wordpress/wp-content/uploads/2017/05/致2018报考互联网中心学生招生信.pdf/"><b>Data Download Module</b></a>. <b>The RESTful API</b> allows users to obtain the query results in json format.</font>
                                    </p>
                                    <p class="lead" align="left"> <font face="Times New Roman" size="5"><b>Paper for introducing IASO system:</b></b></font>
                                    </p>
                                    <p class="lead" align="left" style="text-align:justify"> <font face="Times New Roman" size="5">Shen Y, Yuan K, Dai J, Tang B, Yang M, Lei K. KGDDS: A System for Drug-Drug Similarity Measure in Therapeutic Substitution based on Knowledge Graph Curation. <b>Journal of Medical Systems</b>, 2019. (SCI, IF: 2.098)</font>
                                    </p>
                                    <p align="left " ><font face="Times New Roman" size="5">
                                        <a class="lead" href="antibioticKG?graph=antibiotic&amp;keywords=Flucloxacillin" role="button">View Knowledge Graph <i class="icon-angle-right"></i></a> 
<#--锚点-->
                                        <a class="lead" href="#Paper" role="button">Selected publication <i class="icon-angle-right"></i></a></font>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <br>



                        <h2><font face="Times New Roman"><strong>IASO Knowledge Graph</strong></font></h2>
                        <hr>
                        <p align="left" style="text-align:justify"> <font face="Times New Roman" size="4">The displayed antibiotics KG was constructed based on the DO, IDO, NCBI, HPO and DrugBank databases. Here, 507 infectious diseases and their therapy methods, in combination with 332 different infection sites, 936 relevant symptoms of the digestive, reproductive, neurological and other systems, 371 types of complications, 838,407 types of bacteria, 341 types of antibiotics and their introductions, 1,504 pairs of reaction rates (antibacterial spectrum) between antibiotics and bacteria, 431 pairs of drug interaction relationships, and 86 pairs of antibiotic-specific population contraindicated relationships, were studied.</p>
                        <img src="http://www.iasokg.com/KG1.png" alt="KG1" />
                        <p>   </p>
                        <p align="left"> <font face="Times New Roman">Our antibiotics KG is available for unload :   <a href="http://netlab.pkusz.edu.cn/wordpress/wp-content/uploads/2017/05/致2018报考互联网中心学生招生信.pdf/">Download</a></font></p>
<#--此处应插入图片-->
                        <p align="left"> <font face="Times New Roman"><b>Paper about the antibiotics KG construction and Diagnosis reasoning:</b></font></p>
                        <p align="left" style="text-align:justify"> <font face="Times New Roman">&nbsp&nbsp&nbsp&nbsp&nbsp&nbspShen Y, Yuan K, Chen D, Colloc J, Yang M, Li Y, Lei K. An ontology-driven clinical decision support system (IDDAP) for infectious disease diagnosis and antibiotic prescription. <b>Artificial intelligence in medicine</b>, 2018, 86, 20-32. (JCR 1, IF: 2.879)</font></p>
                        <p align="left"> <font face="Times New Roman"><b>Drug-drug similarity measure</b></font></p>
                        <p align="left" style="text-align:justify"> <font face="Times New Roman">Measuring drug-drug similarity is important but challenging. Significant progresses have been made in drugs whose labeled training data is sufficient and available. However, handling data skewness and incompleteness with domain-specific knowledge graph, is still a relatively new territory and an under-explored prospect. In this context, we adopt our built IASO Knowledge Graph to aid Drug-Drug Similarity measure.</font></p>
                        <p align="left"style="text-align:justify"> <font face="Times New Roman"><b><i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbspData Collection.</i></b> IASO conducts the drug similarity evaluation mainly based on the antibiotic-relevant information in DrugBank . We study the relationships between antibiotics and their corresponding side effects from SIDER , explore the mechanism of essential pharmacologic properties of medications from NDF-RT  and extract textual feature from more than 500,000 papers about medicine provided by PubMed .</font></p>
                        <p align="left"style="text-align:justify"> <font face="Times New Roman"><b><i>&nbsp&nbsp&nbsp&nbsp&nbsp&nbspAntibiotic Pairs Labeling.</i></b>To verify the effectiveness of IASO, we conduct experiments on 1326 pairs most commonly used antibiotics. Doctors score the similarity between two antibiotics, which ranges in [0, 1], according to both antibacteria spectrum and efficacies of medicine (see www.iasokg.com). 0 indicates that there is no similarity between two antibiotics, while 1 implies that the two antibiotics are extremely similar. To make antibiotic pairs labeling more accurate, each pair is labeled by at least 3 doctors and the average is taken as the final result. The Pearson coefficient between the scores issued by each doctor and the average score ranges from 0.827 to 0.864 while Spearman coefficient ranges from 0.792 to 0.888, both proving the reliability of doctors' assessment. The labeled antibiotic pairs are divided into training set and test set.</font></p>

                        <p align="left"> <font face="Times New Roman"><b>Paper about the Drug-drug similarity measure:</b></font></p>
                        <p align="left"style="text-align:justify"> <font face="Times New Roman"> &nbsp&nbsp&nbsp&nbsp&nbsp&nbspLei K, Yuan K, Zhang Q, <b>Shen Y*</b>. MedSim: A Novel Semantic Similarity Measure in Bio-medical Knowledge Graphs. In <i>The 11th International Conference on Knowledge Science, Engineering and Management <b>(KSEM 2018)</b></i>. Changchun, China, August 17-19, 2018. pp. 479-490.</font></p>

                        <p align="left"> <font face="Times New Roman"><b>Paper about the Drug representation learning:</b></font></p>
                        <p align="left"style="text-align:justify"> <font face="Times New Roman"> &nbsp&nbsp&nbsp&nbsp&nbsp&nbspShen Y, Yuan K, Li Y, Tang B, Yang M, Du N, Lei K. Drug2Vec: Knowledge-aware Feature-driven Method for Drug Representation Learning. In <i>The IEEE International Conference on Bioinformatics and Biomedicine <b>(BIBM 2018)</b></i>. Madrid, Spain, December 3-6 2018.</font></p>


                        <h2><font face="Times New Roman"><strong>Group Introduction</strong></font></h2>
                        <hr>


                        <#--<style>-->
                            <#--#content:after{-->
                                <#--content: '';-->
                                <#--display: block;-->
                                <#--clear: both;-->
                            <#--}-->
                            <#--.aside{-->
                                <#--width: 450px;-->
                                <#--float: left;-->
                            <#--}-->
                            <#--.main{-->
                                <#--margin-left: 470px;-->
                            <#--}-->

                            <#--#footer{-->

                            <#--}-->

                        <#--</style>-->
                        <div id="content">
                            <div class="col-md-6" >
                                <img src="http://www.iasokg.com/lei.png" hspace="5" style="float:left;" alt="lei"  height="105" width="75" />
                                <p align="left" style="text-align:justify"> <font face="Times New Roman"><b>Kai Lei</b> received the Ph.D. in C.S. from Peking University, China, in 2015, M.Sc in C.S. from Columbia University in 1999 and B.Sc in C.S. from Peking University in 1998. He had worked for companies including IBM T.J Waston Research Center, Citigroup, Oracle, Google from 1999 to 2004. He currently is an associate professor in the School of Electonic and Computer Engineering (SECE), Peking University, Shenzhen, and participates in the CENI project supported by National Development and Reform Commission since 2016. His research interests include social networks, knowledge graph, big data technologies and named data networking.</font></p>
                                <br>
                            </div>

                            <div class="col-md-6">
                                <img src="http://www.iasokg.com/shen.png" hspace="5" style="float:left;" alt="shen" height="105" width="75" />
                                <p align="left" style="text-align:justify"> <font face="Times New Roman"><b>Ying Shen</b> is now an Assistant Researcher Professor in School of Electronics and Computer Engineering (SECE) at Peking University, leading the Artificial Intelligence - Knowledge Graph team for Medical research. She received her Ph.D. degree from the University of Paris Ouest Nanterre La Défense (France), specialized in Medical & Biomedical Information Science. She received her Erasmus Mundus Master degree in Natural Language Processing from the University of Franche-Comté (France) and University of Wolverhampton (England). Her research interest is mainly focused in the area of Medical Informatics, Natural Language Processing and Machine Learning.</font></p>
                                <br>
                            </div>

                            <div class="col-md-6" >
                                <img src="http://www.iasokg.com/yuan.png" hspace="5" style="float:left;" alt="yuan" height="105" width="75" />
                                <p align="left" style="text-align:justify"> <font face="Times New Roman"><b>Kaiqi Yuan</b> received the BS degree in computer science from Beijing University of Posts and Telecommunications, in 2016. She is working toward the MS degree in computer science at Peking University. Her research interest is mainly focused in the area of biomedical informatics, deep learning and knowledge graph.</font></p>
                                <br>
                            </div>

                            <div class="col-md-6" >
                                <img src="http://www.iasokg.com/wen.png" hspace="5" style="float:left;" alt="yuan" height="105" width="75" />
                                <p align="left" style="text-align:justify"> <font face="Times New Roman"><b>Desi Wen</b>  received his B.S. and M.S. degree in Computer Science from Peking University, China, in 2015 and 2018 respectively. He is currently an algorithmic engineer at Microsoft Corporation. His research interest mainly focuses on construction and completion of medical knowledge graph.</font></p>
                                <br>
                                <br>
                            </div>

                            <div class="col-md-6" >
                                <img src="http://www.iasokg.com/zhang.png" hspace="5" style="float:left;" alt="zhang" height="105" width="75" />
                                <p align="left" style="text-align:justify"> <font face="Times New Roman"><b>Lizhu Zhang</b> received her BS degree in software engineering from Wuhan University, China, in 2015. She is working toward her MS degree in computer science at Peking University. Her research interest is mainly focused in the area of knowledge graph and data mining.</font></p>
                                <br>
                            </div>

                            <div class="col-md-6">

                                <img src="http://www.iasokg.com/chen.png" hspace="5" style="float:left;" alt="chen" height="105" width="75" />
                                <p align="left" style="text-align:justify"> <font face="Times New Roman"><b>Daoyuan Chen</b> received the BS degree in computer science from University of Electronic Science and Technology of China, in 2016. He is working toward the MS degree in computer science at Peking University. His research interest is mainly focused in the area of deep learning and knowledge graph.</font></p>
                                <br>
                            </div>


                            <div class="col-md-6" >
                                <img src="http://www.iasokg.com/deng.png" hspace="5" style="float:left;" alt="deng" height="105" width="75" />
                                <p align="right" style="text-align:justify"> <font face="Times New Roman"><b>Yang Deng</b> received the BS degree in computer science from Beijing University of Posts and Telecommunications, in 2016. He is working toward the MS degree in computer science at Peking University. His research interest is mainly focused in the area of deep learning and question answering.</font></p>
                                <br>
                            </div>

                            <div class="col-md-6" >
                            <img src="http://www.iasokg.com/dai.png" hspace="5" style="float:left;" alt="dai" height="105" width="75" />
                                <p align="left" style="text-align:justify"> <font face="Times New Roman"><b>Jingchao Dai</b> received the BS degree in computer science from Beijing University of Posts and Telecommunications, in 2018. She is working toward the MS degree in computer science at Peking University. Her research interest is mainly focused in the area of biomedical informatics, deep learning and knowledge graph.</font></p>
                            <br>
                            </div>
                        </div>


                        <img src="http://www.iasokg.com/all.jpg"  alt="all"  />
                        <br>
                        <p align="left"> <font face="Times New Roman" size="5"><b>Contact information</b>:</font></p>
                        <p align="left"> <font face="Times New Roman"><b>Kai Lei,Ying Shen: </b><br>Email: {leik, shenying}{AT}pkusz.edu.cn<br>
                            Address: 114, Building A, School of Electronics and Computer Engineering, Peking University Shenzhen Graduate School, &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspShenzhen 518055, P.R. China<br>
                            Academic website:<a href="https://netlab.pkusz.edu.cn">&nbsphttps://netlab.pkusz.edu.cn</a><br> <a href="https://www.researchgate.net/profile/Kai_Lei8">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsphttps://www.researchgate.net/profile/Kai_Lei8</a><br><a href="https://www.researchgate.net/profile/Ying_Shen21">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsphttps://www.researchgate.net/profile/Ying_Shen21</a><br>
                        </font></p>



                        <a name="Paper"></a> <h2><font face="Times New Roman"><strong>Selected publication</strong></font></h2>
                        <hr>
                        <ol>
                            <li><p style="text-align:justify">Shen Y, Colloc J, Jacquet-Andrieu A, Lei K. Emerging Medical Informatics with Case-Based Reasoning for Aiding Clinical Decision in Multi-Agent System.
                                <b><i>Journal of Biomedical Informatics</b></i>, 2015, 56: 307–317. (JCR 1, IF: 2.882)</p></li>
                            <li><p style="text-align:justify">Shen Y, Yuan K, Chen D, Colloc J, Yang M, Li Y, Lei K. An ontology-driven clinical decision support system (IDDAP) for infectious disease diagnosis and antibiotic prescription.
                                <b><i>Artificial intelligence in medicine</b></i>, 2018, 86, 20-32. (JCR 1, IF: 2.879)</p></li>
                            <li><p>Shen Y, Li Y, Si S, Zhang J, Yang M, Lei K. Gastroenterology Ontology Construction using Synonym Identification and Relation Extraction.
                                <b><i>IEEE Access. </b></i>,2018, 6(1), 52095-52104. (JCR 1, IF: 3.557).)</p></li>
                            <li><p style="text-align:justify">Shen Y, Zhang L, Zhang J, Yang M, Tang B, Li Y, Lei K. CBN: Constructing a Clinical Bayesian Network based on Data from the Electronic Medical Record.
                                <b><i>Journal of Biomedical Informatics </b></i>,2018, 88: 1–10. (JCR 1, IF: 2.882)</p></li>
                            <li><p style="text-align:justify">Shen Y, Chen D, Tang B, Yang M, Lei K. EAPB: Entropy-Aware Path-Based Metric for Ontology Quality.
                                <b><i>Journal of Biomedical Semantics </b></i>, 2018, 9(1), 20. (JCR 2, IF: 1.883)</p></li>
                            <li><p style="text-align:justify">Shen Y, Yuan K, Dai J, Tang B, Yang M, Lei K. KGDDS: A System for Drug-Drug Similarity Measure in Therapeutic Substitution based on Knowledge Graph Curation.
                                <b><i>Journal of Medical Systems </b></i> ,2019. (JCR 4, IF: 2.098)</p></li>
                            <li><p style="text-align:justify">Shen Y, Li Y, Huang J, Zhang J, Si S, Yang M, Lei K. Discovering Medical Entity Relations from Texts using Dependency Information.
                                <b><i>Natural Language Engineering </b></i>, 2018, 1–21. Cambridge University Press. (JCR 4, IF: 0.8)</p></li>
                            <li><p style="text-align:justify">Lei K, Liu Y, Zhong S, Liu Y, Xu K, Shen Y, Yang M. Understanding User Behavior in Sina Weibo Online Social Network: A Community Approach.
                                <b><i>IEEE Access. </b></i>, 6(2018), 13302-13316. (JCR 1, IF: 3.557)</p></li>
                            <li><p style="text-align:justify">Lei K, Zhang LZ, Liu Y, Shen Y, Liu CW. An event summarizing algorithm based on the timeline relevance model in Sina Weibo.
                                <b><i>IScience China Information Sciences </b></i>(SCIS), 61(12), 129101. (JCR 1, IF: 2.188)</p></li>
                            <li><p style="text-align:justify">Shen Y, Chen D, Yang M, Li Y, Du N, Lei K. Ontology Evaluation with Path-based Text-aware Entropy Computation. In The 41st International ACM SIGIR Conference on Research & Development in Information Retrieval
                                <b><i>(SIGIR 2018). </b></i>SIGIR: Ann Arbor, Michigan, USA, July 8-12. pp. 881-884. ACM. (CCF A)</p></li>
                            <li><p style="text-align:justify">Shen Y, Deng Y, Yang M, Li Y, Du N, Fan W, Lei K. Knowledge-aware Attentive Neural Network for Ranking Question Answer Pairs. In The 41st International ACM SIGIR Conference on Research & Development in Information Retrieval
                                <b><i>(SIGIR 2018). </b></i>SIGIR: Ann Arbor, Michigan, USA, July 8-12. pp. 901-904. ACM. (CCF A)</p></li>
                            <li><p style="text-align:justify">Deng Y, Xie Yu, Li Y, Yang M, Du N, Fan W, Lei K, Shen Y. Multi-Task Learning with Multi-View Attention for Answer Selection and Knowledge Base Question Answering. In The Thirty-Third AAAI Conference on Artificial Intelligence
                                <b><i>(AAAI-19). </b></i>Honolulu, Hawaii, USA, January 27 – February 1, 2019. ACM (CCF A)</p></li>
                            <li><p style="text-align:justify">Shen Y, Deng Y, Zhang J, Li Y, Du N, Fan W, Lei K. IDDAT: An Ontology-Driven Decision Support System for Infectious Disease Diagnosis and Therapy. In The 18th IEEE International Conference on Data Mining
                                <b><i>(ICDM 2018）. </b></i>Singapore, November 17-20, 2018. (CCF B)</p></li>
                            <li><p style="text-align:justify">Shen Y, Yuan K, Li Y, Tang B, Yang M, Du N, Lei K. Drug2Vec: Knowledge-aware Feature-driven Method for Drug Representation Learning. In The IEEE International Conference on Bioinformatics and Biomedicine
                                <b><i> (BIBM 2018). </b></i>Madrid, Spain, December 3-6 2018. (CCF B)</p></li>
                            <li><p style="text-align:justify">Deng Y, Shen Y, Yang M, Li Y, Du N, Fan W, Lei K. Knowledge as A Bridge: Improving Cross-domain Answer Selection with External Knowledge. In The 27th International Conference on Computational Linguistics
                                <b><i>(COLING 2018). </b></i>Santa Fe, New-Mexico, USA, August 20-26, 2018. pp. 3295-3305. (CCF B)</p></li>
                            <li><p style="text-align:justify">Lei K, Chen D, Li Y, Yang M, Du N, Fan W, Shen Y. Cooperative Denoising for Distantly Supervised Relation Extraction. In The 27th International Conference on Computational Linguistics
                                <b><i>(COLING 2018). </b></i>Santa Fe, New-Mexico, USA, August 20-26, 2018. pp. 426-436. (CCF B)</p></li>
                            <li><p style="text-align:justify">Lei K, Yuan K, Zhang Q, Shen Y. MedSim: A Novel Semantic Similarity Measure in Bio-medical Knowledge Graphs. In The 11th International Conference on Knowledge Science, Engineering and Management
                                <b><i> (KSEM 2018). </b></i>Changchun, China, August 17-19, 2018. pp. 479-490. (CCF C)</p></li>
                            <li><p style="text-align:justify">Lei K, Huang J, Si S, Shen Y. Semantic Similarity Measures to Disambiguate Terms in Medical Text. In The 25th International Conference on Neural Information Processing
                                <b><i> (ICONIP2018). </b></i>Siem Reap, Cambodia, December 13-16, 2018. pp. 398-409. (CCF C)</p></li>
                            <li><p style="text-align:justify">Shen Y, Zhang Q, Zhang J, Huang J, Lu Y, Lei K. Improving Medical Short Text Classification with Semantic Expansion using Word-Cluster Embedding. In The 9th iCatse Conference on Information Science and Applications
                                <b><i> (ICISA2018). </b></i>Hong Kong, June 25-27, 2018. pp. 401-412.</p></li>
                            <li><p style="text-align:justify">Colloc J, Yameogo R, Summons P, Shen Y, Park M, Aronson J E. EPICE an Emotion Fuzzy Vectorial Space for Time Modeling in Medical Decision, In The International Conference on Internet of Things and Machine Learning
                                <b><i> (IML 2017) </b></i>Liverpool, United Kingdom, October 17-18, 2017. pp. 29-38.</p></li>
                        </ol>

                        <br>
                        <h2><font face="Times New Roman"><strong>Project support</strong></font></h2>
                        <hr>
                        <ol>
                            <li><p style="text-align:justify">2016-2018: Research on Key Technologies of Knowledge Reasoning in Medical Diagnosis and Treatment, National Natural Science Foundation of China Youth Science Foundation.
                            </p></li>
                            <li><p style="text-align:justify">2016-2019: Research on methods and techniques of knowledge mapping for general practice decision-making, Shenzhen Key Basic Research Project.</p></li>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </div>


<#--网页footer部分-->
<#include "template/footer.ftl">

</body>
</html>