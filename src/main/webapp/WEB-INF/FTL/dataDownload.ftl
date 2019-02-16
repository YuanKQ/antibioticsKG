<#--测试页面-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <#--<%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>-->
    <#include "template/head.html">
    <title>Data download page</title>
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
                                <div class="col-md-10"  >
                                    <p class="lead" align="left" style="text-align:justify"><font face="Times New Roman" >The data set published in this system is only used for non-commercial scientific research or classroom teaching purposes. It is strictly forbidden to be used for clinical diagnosis, and data set should not be used for any commercial purposes.<br>
                                        Read carefully before using<a href="#contract"> Dataset download protocol</a>.
                                    </p>
                                    <p align="left">
                                        <a class="lead" href="antibioticKG?graph=antibiotic&amp;keywords=Flucloxacillin" role="button">View Knowledge Graph <i class="icon-angle-right"></i></a> 
                                        <a class="lead" href="#dataSet" role="button">Download Data Set<i class="icon-angle-right"></i></a></font>
                                    </p>
                                </div>
                            </div>
                        </div>
                        <br>
                        <a name="contract"></a><h2><font face="Times New Roman"><strong>Data Set Download Protocol</strong></font></h2>
                        <hr>
                        <p style="text-align:justify"><font face="Times New Roman" size="4">You (hereinafter referred to as "Researcher") are requesting the IASO Open Source System to grant you the right to access, download and use data sets (hereinafter referred to as "data sets"). As a condition for obtaining such authorization, you agree to abide by the following terms:</font></p><br/>
                        <p style="text-align:justify"><font face="Times New Roman" size="4">
                            1. Researchers agree to use data sets only for non-commercial scientific research or classroom teaching purposes. It is strictly forbidden to use data sets for clinical diagnosis and not for any commercial purposes.<br/>

                            2. We do not enjoy the intellectual property rights of pictures, audio, text and other contents used in data sets, and do not guarantee the aforementioned contents, including, but not limited to, infringement of the intellectual property rights of others or the use of the aforementioned contents for any specific purpose;<br/>

                            3. We are not liable for any form of loss or damage caused by the use of data sets, and will not be liable for any legal consequences arising from the use of data sets.<br/>

                            4. Any legal liability related to the use of data sets shall be borne by researchers. If the use of data sets by researchers or their employees, agents or branches causes reputation or economic losses to us, researchers shall be liable for compensation.<br/>

                            5. Researchers may authorize their assistants, colleagues or other partners to access and use data sets, but they shall ensure that the aforementioned persons have carefully read and agree to be bound by this Agreement.<br/>

                            6. If a researcher is employed by a profit-making business entity, he or she shall ensure that data sets are used only for non-commercial purposes and that his or her employer is also bound by this Agreement. The researcher confirms that he or she has obtained sufficient authorization from the employer before signing this Agreement.<br/>

                            7. We have the right to revoke or withdraw the authorization of researchers to use datasets at any time, and to request researchers to delete downloaded datasets.
                        </font></p>

                        <br>
                        <a name="dataSet"></a><h2><font face="Times New Roman"><strong>Data Set Download</strong></font></h2>
                        <hr>
                        <div class="container"><font face="Times New Roman">
                            <div class="row">
                            <div class="col-md-10">
                                <font face="Times New Roman" size="4">
                            <h3>Semantic Similarity Marker Data Set of Common Antibiotics</h3>
                            <p style="text-align:justify">The data set covers a total of 200 antibiotic pairs randomly assembled from 40 antibiotics in 10 most commonly used clinical categories. Several medical students participated in evaluating the similarity of antibiotic counterparts (no similarity, 0 points; extremely similar, 10 points). Each pair of antibiotic pairs is guaranteed to be evaluated by at least three medical students. The final evaluation results are based on the average score of medical students.</p>
                                    </font>
                            <p>
                            <a href="antibioticSim.txt">Download Data Set</a>
                            </p>

                        </div>
                        </div>
                        </div>

                        <div class="container"><font face="Times New Roman">
                            <div class="row">
                                <div class="col-md-10">
                                    <font face="Times New Roman" size="4">
                                        <h3>The dataset of IASO Knowledge Graph</h3>
                                        <p style="text-align:justify">The displayed antibiotics KG was constructed based on the DO, IDO, NCBI, HPO and DrugBank databases. Here, 507 infectious diseases and their therapy methods, in combination with 332 different infection sites, 936 relevant symptoms of the digestive, reproductive, neurological and other systems, 371 types of complications, 838,407 types of bacteria, 341 types of antibiotics and their introductions, 1,504 pairs of reaction rates (antibacterial spectrum) between antibiotics and bacteria, 431 pairs of drug interaction relationships, and 86 pairs of antibiotic-specific population contraindicated relationships, were studied.</p>
                                    </font>
                                    <p>
                                        <a href="antibiotic_change_IRI.zip">Download Data Set</a>
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