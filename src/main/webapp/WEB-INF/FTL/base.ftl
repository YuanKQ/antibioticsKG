<#--父模板-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
    <title><@block name="baseTile">base</@block></title>
</head>

<body>
    <#include "/template/navigationBar.html">
    <div class="container">
        <#--搜索栏-->
        <#include "/template/searchForm.ftl">

        <#--网页主要内容-->
        <div class=row">
        <@block name="baseBody">body content from base.ftl</@block>
        </div>

        <#--页面简介-->
        <#include "template/pageDescription.ftl">
    </div>

    <#--网页footer部分-->
    <#include "/template/footer.ftl">



</body>
</html>