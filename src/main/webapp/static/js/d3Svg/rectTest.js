(function () {
    $(function () {
        var rectSvg = d3.select("svg")
            .attr("width", '100%')
            .attr("height", '520');

        var marge = {top: 60, bottom: 60, left: 60, right: 60};//设置边距
        var dataset = [250, 210, 170, 130, 90];
        var data2 = [2.5, 2.1, 1.7, 1.3, 0.9];

        var rectHeight = 30;

        var g = rectSvg.append('g')
            .attr("transform", "translate(" + marge.top + "," + marge.left + ")");

        g.selectAll('rect')
            .data(dataset)
            .enter()
            .append("rect")
            .attr('x', 20)
            .attr('y', function (temp, i) {
                return i * 20;
            })
            .attr('width', 0)
            .attr('height', 15)
            .attr("fill", "blue")//颜
            .transition()//添加过渡
            .duration(1000)//持续时间
            .delay(function (d, i) { //指定延迟的时间，表示一定时间后才开始转变，单位同样为毫秒
                return 300 * i;
            })
            .attr("width", function (d) {//回到最终状态
                return d;
            })
        var texts = rectSvg.selectAll(".MyText")//添加文字
            .data(data2)
            .enter()
            .append("text")
            .attr("class", "MyText")
            .transition()
            .duration(1000)
            .delay(function (d, i) {
                return 300 * i;
            })
            .attr("x", function (d, i) {
                return dataset[i] - -20;
            })
            .attr("y", function (d, i) {
                return i * 20;
            })
            .attr("dx", 25)
            .attr("dy", 73)
            .text(function (d) {
                return d;
            });

        // 监听rect点击事件
        $('svg rect').on('click', function () {
            if ($("svg rect").attr("width") !== "0") {    //如果矩形宽部位0的话，执行下面语句

                rectSvg.selectAll('rect')
                    .transition()  //开启过渡动画
                    // .duration(1000)
                    .delay(function (d, i) {
                        return 200 * i;
                    })
                    .attr("width", 0); //宽度变为0

                rectSvg.selectAll(".MyText")//添加文字
                    .transition()
                    .duration(1000)
                    .delay(function (d, i) {
                        return 200 * i;
                    })
                    .style("opacity", "0");  //文字变透明
            } else {
                rectSvg.selectAll(".rect")
                    .transition()
                    .duration(1000)
                    .delay(function (d, i) {
                        return 200 * i;
                    })
                    .attr("width", function (d) {
                        return d;
                    });


                rectSvg.selectAll(".MyText")//添加文字
                    .transition()
                    .duration(1000)
                    .delay(function (d, i) {
                        return 200 * i;
                    })
                    .style("opacity", "1");
            }
        })
    })
})();