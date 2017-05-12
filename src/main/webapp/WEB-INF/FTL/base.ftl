<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

</div>

</body>
</html>