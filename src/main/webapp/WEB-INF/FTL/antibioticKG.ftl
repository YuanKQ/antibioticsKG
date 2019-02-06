<#--抗生素知识图谱【英文】 知识地图展示部分-->
<@override name='baseTile'>antibioticKG</@override>
<@override name="searchMention">
<input type="text" id="keywords" name="keywords" class="form-control input-lg" placeholder="搜索......"
       value="Amoxycillin" onkeydown="enterSearch()">
</@override>

<@override name="baseDomain">
<input type="hidden" id="graph" name="graph" value="antibioticKG">
</@override>


<@override name='recommendation'>
<a onclick="getResultAndRedraw('AmBisome','antibiotic')">AmBisome</a> 
<a onclick="getResultAndRedraw('Amoxycillin','antibiotic')">Amoxycillin</a> 
<a onclick="getResultAndRedraw('Flucloxacillin','antibiotic')">Flucloxacillin</a>
</@override>




<@override name="baseBody">
<div class="row">
    <div class="col-md-8">
        <#--<div class="panel panel-primary">-->
        <div class="panel panel-default">
            <div class="panel-heading">
                Graph
            </div>
            <div class="panel-body">
                <div id="knowledgeGraph" style="height:600px">
                    <svg id="shownSVG" width="100%" height="100%"></svg>

                </div>
            </div>
        </div>
    </div>
    <div class="col-md-4">
        <#--<div class="panel panel-danger">-->
        <div class="panel panel-info">
            <div class="panel-heading">
                Description
            </div>
            <div class="panel-body" >
                <div id="description" style="height:600px; overflow-y:auto;">
                    <p>&lt;&lt;You can check the node's corresponding message by stopping the mouse on the node.</p>
                    <#--<p>&lt;&lt;将鼠标停留在节点上,可查看节点相应消息。</p>-->
                </div>
            </div>
        </div>
    </div>
</div>



<script type="text/javascript">
    function getResultAndRedraw(kw, graph) {
        var qs = "keywords=" + kw + "&graph=" + graph;
        console.log(qs);
        getResult(qs, redraw);
    }

    function clickButton() {

        var kw = $("#keywords").val();
        var graph = $("#graph").val();

        var qs = 'keywords=' + kw + '&graph=' + graph;
        console.log(qs)
        getResult(qs, redraw)
    }

    function updateSearchForm(kw) {
        var kwArray = kw.split(/[&, =]/);
        document.getElementById('keywords').value = kwArray[1];
    }

    function getResult(kw, callback) {
        updateSearchForm(kw);

        $.ajax({
            type: "GET",
            url: "antibioticKG/search",
            data: kw,
            datatype: "application/json",
            error: function (error) {
                console.log(error.toString());
            },
            success: function (graph) {
                console.log("Successfully accept.");
//                console.log(graph.toString());
                callback(graph);
            }
        });
    }

    function redraw(graph) {
        $("#shownSVG").empty();
        $("#description").empty();

        if (graph.status == 404) {
            alert(graph.msg + "\n 抱歉， 该名词暂时没有收录入库。\n数据将持续更新, 敬请期待。");

            return;
        }

        var svg = d3.select("#shownSVG");
        var width = $("#shownSVG").width();
        var height = $("#shownSVG").height();
        var min = width > height ? height : width
        var linkDistance = min / 9 > 15 ? min / 9 : 15;
        var radius = min / 30 > 25 ? min / 30 : 25;


        var color = d3.scaleOrdinal(d3.schemeCategory20);

        var groupNum = graph.totalGroup;
        var simulation = d3.forceSimulation()
                .force("link", d3.forceLink().id(function (d) {
                    return d.id;
                }).distance(function (d, i) {
                    if (i < 15)  // 最内层 15
                        return linkDistance * 2 + 5;
                    if (i >= 15 && i < 41) // 第二层 25
                        return linkDistance * 3;
                    if (i >= 41 && i < 86) //第三层 45
                        return linkDistance * 4;
                    if (i >= 86)
                        return linkDistance * 4.5;
                    /*if (groupNum == 1)
                        return linkDistance * 3;
                    if (groupNum == 2)
                        return linkDistance * 1.2 * d.value;
                    if (groupNum > 4)
                        return linkDistance * 0.7 * d.value;
                    return linkDistance * d.value;*/
                        }))
                .force("charge", d3.forceManyBody())
                .force("center", d3.forceCenter(width / 2, height / 2));

        var link = svg.append("g")
                .attr("class", "links")
                .selectAll("line")
                .data(graph.links)
                .enter().append("line")
                .attr("class", "link");
//                .attr("stroke-width", function (d) {
//                    return Math.sqrt(d.value);
//                });

        // 给link添加名称 ref: http://bl.ocks.org/fancellu/2c782394602a93921faff74e594d1bb1
        edgePaths = svg.selectAll(".edgePath")
                .data(graph.links)
                .enter().append('path')
                .attrs({
                    'class': 'edgePath',
                    'fill-opacity': 0,
                    'stroke-opacity': 0,
                    'id': function (d, i) {
                        return 'edgePath_' + i;
                    }
                })
                .style('pointer-events', 'none');

//        edgepaths = svg.selectAll(".edgepath")
//                .data(graph.links)
//                .enter()
//                .append('path')
//                .attrs({
//                    'class': 'edgepath',
//                    'fill-opacity': 0,
//                    'stroke-opacity': 0,
//                    'id': function (d, i) {return 'edgepath' + i}
//                })
//                .style("pointer-events", "none");


        edgeLabels = svg.selectAll(".edgeLabel")
                .data(graph.links)
                .enter().append('text')
                .style("pointer-events", "none")
                .attrs({
                    'class': 'edgeLabel',
                    'id': function (d, i) {
                        return 'edgeLabel_' + i;
                    },
                    'font-size': 12,
                    'fill': '#aaa'
                });

        edgeLabels.append('textPath')
                .attr('xlink:href', function (d, i) {
                    return '#edgePath_' + i;
                })
                .style("text-anchor", "middle")
                .style('pointer-events', 'none')
                .attr('startOffset', "50%")
                .text(function (d, i) {
                    return d.linkType;
                });

        /*var node = svg.append("g")
                .attr("class", "nodes")
                .selectAll("circle")
                .data(graph.nodes)
                .enter().append("circle")
                .attr("r", radius)
                .attr("fill", function(d) { return color(d.group); })
                .call(d3.drag()
                        .on("start", dragstarted)
                        .on("drag", dragged)
                        .on("end", dragended));*/

        var gnodes = svg.selectAll('g.gnode')
                .data(graph.nodes)
                .enter()
                .append('g')
                .classed('gnode', true);

        var node = gnodes.append("circle")
                .attr("class", "node")
                .attr("r", radius)
                .attr("fill", function (d) {
                    return color(d.group);
                })
                .on("click", function (d) {
                    //解决node中drag事件和click事件的冲突(node同时监听drag和click事件, 当拖动时,会同时触发click事件)
                    if (d3.event.defaultPrevented) //检查是否为drag事件
                        return;
                    getResultAndRedraw(d.id, d.type);
                })
                .on("mouseover", showDescription)
                .call(d3.drag()
                        .on("start", dragstarted)
                        .on("drag", dragged)
                        .on("end", dragended));

        var labels = gnodes.append("text")
                .attr("dx", function (d) {
                    return -25;
                })
                .text(function (d) {
                    return d.id;
                });

//                node.append("title")
//                        .text(function(d) { return d.id; });

        simulation
                .nodes(graph.nodes)
                .on("tick", ticked);

        simulation.force("link")
                .links(graph.links);

        function ticked() {
            link
                    .attr("x1", function (d) {
                        return d.source.x;
                    })
                    .attr("y1", function (d) {
                        return d.source.y;
                    })
                    .attr("x2", function (d) {
                        return d.target.x;
                    })
                    .attr("y2", function (d) {
                        return d.target.y;
                    });

            /*node
                    .attr("cx", function(d) { return d.x; })
                    .attr("cy", function(d) { return d.y; });*/
            gnodes.attr("transform", function (d) {
                return 'translate(' + [d.x, d.y] + ')';
            });

            edgePaths.attr('d', function (d) {
                return 'M ' + d.source.x + ' ' + d.source.y + ' L ' + d.target.x + ' ' + d.target.y;
            });

            edgeLabels.attr('transform', function (d) {
                if (d.target.x < d.source.x) {
                    var bbox = this.getBBox();  // adjust rect to text size
                    rx = bbox.x + bbox.width / 2;
                    ry = bbox.y + bbox.height / 2;
                    return 'rotate(180 ' + rx + ' ' + ry + ')';
                } else {
                    return 'rotate(0)';
                }
            })
        }

        function dragstarted(d) {
            if (!d3.event.active) simulation.alphaTarget(0.3).restart();
            d.fx = d.x;
            d.fy = d.y;
        }

        function dragged(d) {
            d.fx = d3.event.x;
            d.fy = d3.event.y;
        }

        function dragended(d) {
            if (!d3.event.active) simulation.alphaTarget(0);
            d.fx = null;
            d.fy = null;
        }

        function showDescription(d) {

            document.getElementById("description").innerHTML = d.infos;
        }
    }

    function enterSearch() {
        var event = window.event || arguments.callee.caller.arguments[0];
        if (event.keyCode == 13) {
            var kw = $("#keywords").val();
            var graph = $("#graph").val();
            var qs = "keywords=" + kw + "&graph=" + graph;
            console.log(qs);
            getResult(qs, redraw);
        }
    }

</script>
</@override>

<@override name="pageDescription">
<p class="lead">About English Antibiotic Knowledge Graph</p>
<p>
    The English Antibiotics Knowledge Graph includes common antibiotics, diseases, pathogens, infection sites, complications, symptoms, symptoms, types of symptoms and their relationships, which comes to more than 450,000 entities and nearly 6,000 relationships.

    <a href="introduction">Learn More <i class="icon-angle-right"></i></a>
</p>
<#--<p class="lead">关于“英文抗生素知识图谱（AntibioticKG）</p>-->
<#--<p>-->
    <#--“英文抗生素知识图谱”包括常见抗生素，疾病，病菌，感染部位，并发症，症状，症状类型及其关系组成，共计45余万实体和近6千条关系。 -->
    <#--<a href="introduction">了解更多 <i class="icon-angle-right"></i></a>-->
<#--</p>-->
<br>
</@override>

<@extends name='base.ftl'/>