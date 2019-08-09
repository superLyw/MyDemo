(function () {
    $(function () {
        var dataList = [
            [
                {x: 40, y: 200},
                {x: 120, y: 250},
                {x: 200, y: 220},
                {x: 280, y: 280},
                {x: 360, y: 350},
                {x: 440, y: 230},
                {x: 520, y: 320}
            ],
            [
                {x: 40, y: 100},
                {x: 120, y: 120},
                {x: 200, y: 180},
                {x: 280, y: 320},
                {x: 360, y: 400},
                {x: 440, y: 120},
                {x: 520, y: 200}
            ]
        ];
        var svg = d3.select('svg')
            .attr('width', 900)
            .attr('height', 500)
            .attr('fill', 'none');

        var g = svg.append('g');

        var lineFunction = d3.line()
            .x(function (d) {
                return d.x;
            })
            .y(function (d) {
                return d.y;
            });

        for (var i = 0; i < dataList.length; i++) {
            g.append("path")
                .attr('stroke', 'yellow')
                .attr('data-id', 'line' + i)
                .attr('class', 'trainLine')
                .attr('stroke-width', '2')
                .attr('d', lineFunction(dataList[i]));
        }

        var train = g.append("rect")
            .attr('width', 40)
            .attr('height', 20)
            .attr('y', -10)
            .attr('ry', 20)
            .attr('fill', '#85f911')
            .attr('opacity', '0.8');

        d3.selectAll('.trainLine')
            .on('click', function () {
                var d = d3.select(this).attr('d');
                train.append('animateMotion')
                    .attr('dur', '5s')
                    .attr("repeatCount", "indefinite")
                    .attr("rotate", "auto")
                    .attr('path', d);
            })

    })
})();