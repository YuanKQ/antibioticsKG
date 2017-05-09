
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
    <#include "/template/head.html">
    <title>*Test*</title>
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
<#include "/template/navigationBar.html">
hello你好${name}

<script>

    var w = 960,
            h = 500,
            z = 20,
            x = w / z,
            y = h / z;
    var svg=d3.select("body").append("svg");
    svg.attr("width",w)
            .attr("height",h);
    svg.selectAll("rect")
            .data(d3.range(x*y))
            .enter()
            .append("rect")
            .attr("width",z)
            .attr("height",z)
            .attr("transform",trans)
            .attr("fill",beautiful)
            .on("mouseover",mouseover);
    function beautiful(d){
        return d3.hsl(Math.floor(360*(d/x)/y),1,0.5);
    }
    function trans(d){
        return "translate("+(d%x)*z+","+Math.floor(d/x)*z+")";
    }
    function mouseover(d) {
        this.parentNode.appendChild(this);

        d3.select(this)
                .style("pointer-events", "none")
                .transition()
                .duration(750)
                .attr("transform", "translate(480,480)scale(23)rotate(180)")
                .transition()
                .delay(1500)
                .attr("transform", "translate(0,0)scale(100)")
                .style("fill-opacity", 0)
                .remove();
    }

</script>
</body>
</html>