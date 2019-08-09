(function () {
    $(function () {
        var rectWidth = 30;
        var width = 1000;
        var height = 520;

        var marge = {top: 60, bottom: 60, left: 60, right: 60};
        var svg = d3.select('svg')
            .attr('width', width + 'px')
            .attr('height', height + 'px');

        var g = svg.append('g')
            .attr("transform", "translate(" + marge.top + "," + marge.left + ")");

        var dataList = [250, 147, 562, 621, 333, 299, 382];

        // 比例尺
        var xScale = d3.scaleBand()
            .domain(d3.range(dataList.length))
            .rangeRound([0, width - marge.left - marge.right]);
        var yScale = d3.scaleLinear()
            .domain([0, d3.max(dataList)])
            .rangeRound([height - marge.top - marge.bottom, 0]);
        // 坐标
        var xAxis = d3.axisBottom(xScale)
            .ticks(dataList.length);

        var yAxis = d3.axisLeft(yScale)
            .ticks(5);
        //放入g中
        g.append('g')
            .attr('transform', "translate(" + 40 + "," + 400 + ")")
            .call(xAxis);
        g.append('g')
            .attr('transform', "translate(" + 40 + "," + 0 + ")")
            .call(yAxis);

        //为每个柱形和文字创建一个g
        var gs = g.selectAll('.rect')
            .data(dataList)
            .enter()
            .append('g')
            .attr('class', 'zhuG');
        // 柱形
        gs.append('rect')
            .attr("x", function (d, i) {
                return 40 + xScale(i) + rectWidth / 2;
            })
            .attr("y", function (d) {
                return yScale(d);
            })
            .attr("width", function () {
                return xScale.step() - rectWidth;
            })
            .attr("height", function (d, i) {
                return height - marge.top - marge.bottom - yScale(d);
            })
            .attr("fill", function (d, i) {
                return d3.schemePaired[i];
            });


        gs.append('text')
            .text(function (d) {
                return d;
            })
            .attr('x', function (d, i) {
                return 40 + xScale(i) + rectWidth / 2;
            })
            .attr('y', function (d, i) {
                return yScale(d);
            })
            .attr("dy", 20);
        // 生成提示框
        var gTip = g
            .append('g')
            .attr('class', 'rectTip')
            .attr('visibility', 'hidden');

        var rTip = gTip.append('rect')
            .attr('width', 200)
            .attr('height', 200)
            .attr('fill', "#f8efc3");

        // .attr('visibility', 'hidden')
        // .style("opacity", 0);
        var tTip = gTip.append('text');
        d3.selectAll('.zhuG')
            .on('click', function (d, i) {
                tTip
                    .attr('dy',20)
                    .text(d);
                gTip
                    .attr("transform", "translate(" + (d3.event.x - 64) + "," + (d3.event.y - 64) + ")")
                    .attr('visibility', 'hidden')
                    .style("opacity", 0)
                    .transition()
                    .duration(300)
                    .attr('visibility', 'visible')
                    .style("opacity", 1);

            });


    })
})();