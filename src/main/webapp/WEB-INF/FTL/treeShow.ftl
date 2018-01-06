<#--抗生素知识目录，树形展示部分-->
<@override name="baseDomain">
<input type="hidden" id="graph" name="graph" value="TreeShow">
</@override>

<html>
<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/default.css">
        <link href="https://cdn.bootcss.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <#--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">-->
    <#include "template/head.html">
        <title><@block name="baseTile">抗生素目标索引</@block></title>


<body>
    <#include "template/navigationBar.html">
    <#include "template/TreeIndex.html">
<script type="text/javascript"></script>

</body>
</head>
</html>
