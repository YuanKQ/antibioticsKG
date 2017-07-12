<#--抗生素知识图谱【英文】 知识地图展示部分-->
<@override name='baseTile'>antibioticKG</@override>
<@override name="searchMention">
<input type="text" id="keywords" name="keywords" class="form-control input-lg" placeholder="搜索......"
       value="Amoxycillin" onkeydown="enterSearch()">
</@override>

<@override name="baseDomain">
<input type="hidden" id="graph" name="graph" value="antibiotic">
</@override>


<@override name='recommendation'>
<a onclick="getResultAndRedraw('AmBisome','antibiotic')">AmBisome</a> 
<a onclick="getResultAndRedraw('Amoxycillin','antibiotic')">Amoxycillin</a> 
<a onclick="getResultAndRedraw('Flucloxacillin','antibiotic')">Flucloxacillin</a>
</@override>




<@override name="baseBody">
<h2>搜索关键词为： ${test!"null"}</h2>
<div class="row">
    <div class="col-md-8">
        <div class="panel panel-primary">
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
        <div class="panel panel-danger">
            <div class="panel-heading">
                Description
            </div>
            <div class="panel-body" >
                <div id="description" style="height:600px; overflow-y:auto;">
                    <p>&lt;&lt;将鼠标停留在节点上,可查看节点相应消息。</p>
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
                console.log(graph.toString());
                callback(graph);
            }
        });
    }

    function redraw(graph) {
        $("#shownSVG").empty();

        var svg = d3.select("#shownSVG");
        var width = $("#shownSVG").width();
        var height = $("#shownSVG").height();
        var min = width > height ? height : width
//        var linkDistance = min/2.5 > 30? min/2.5: 30;
        var linkDistance = min / 8 > 15 ? min / 8 : 15;
        var radius = min / 30 > 25 ? min / 30 : 25;


        var color = d3.scaleOrdinal(d3.schemeCategory20);

        var groupNum = graph.totalGroup;
        var simulation = d3.forceSimulation()
                .force("link", d3.forceLink().id(function (d) {
                    return d.id;
                })
                        .distance(function (d) {
                            if (groupNum == 1)
                                return linkDistance * 3;
                            if (groupNum == 2)
                                return linkDistance * 1.2 * d.value;
                            if (groupNum > 4)
                                return linkDistance * 0.7 * d.value;
                            return linkDistance * d.value;
                        }))
                .force("charge", d3.forceManyBody())
                .force("center", d3.forceCenter(width / 2, height / 2));

        var link = svg.append("g")
                .attr("class", "links")
                .selectAll("line")
                .data(graph.links)
                .enter().append("line")
                .attr("stroke-width", function (d) {
                    return Math.sqrt(d.value);
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

<@extends name='base.ftl'/>