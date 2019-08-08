(function () {
    const svgWidth = '100%';
    const svgHeight = '570px';
    $(function () {
        d3Svg.init();
    });
    var d3Svg = {
        init: function () {
            var self = this;
            self.initSvg();
        },
        initSvg: function () {
            var mySvg = d3.select("svg")
                .attr("width", svgWidth)
                .attr("height", svgHeight)
                .attr('fill', 'blue');

            var myG = mySvg.append("g");


            $.getJSON("/static/json/d3Svg/path.json", function (data) {
                $.each(data, function (i, item) {
                    var pathName = item.railroad;
                    var line = d3.line()
                        .x(function (d) {
                            return d.x;
                        })
                        .y(function (d) {
                            return d.y;
                        });
                    // 路线
                    myG.append('path')
                        .attr('id', 'path' + item.pathId)
                        .attr("class", "trainLine")
                        .attr('d', line(pathName))
                        .attr("stroke", "blue")
                        .attr("fill", "none");
                    // 按钮
                    myG.append('rect')
                        .attr('data-id', 'path' + item.pathId)
                        .attr('width', 60)
                        .attr('height', 30)
                        .attr('x', 75 * (i + 1) - 24)
                        .attr('y', 530)
                        .attr("class", "button")
                        .style("stroke", "#126BBF")
                        .style("fill", "rgba(18,107,191,.6)");
                    // 按钮文字生成
                    myG.append("text")
                        .attr('data-id', 'path' + item.pathId)
                        .attr("class", "buttonName")
                        .attr("x", 75 * (i + 1) - 22)
                        .attr("y", 550)
                        .text(item.pathName);
                });

                // 生成火车
                var train = myG.append("rect")
                    .attr("class", "train")
                    .attr("x", 0)
                    .attr("y", -8)
                    .attr("width", 40)
                    .attr("height", 16)
                    .attr("rx", 5)
                    .style("stroke", "#126BBF")
                    .style("fill", "rgba(18,107,191,.6)");

                var idfir = "#path" + data[0].pathId;
                var time = "10s";
                getPath(idfir, time);

                d3.selectAll('.button,.buttonName').on('click', function () {
                    var id = '#' + d3.select(this).attr('data-id');
                    // myG.selectAll(".trainLine").style("stroke","transparent");
                    getPath(id, '10s');
                })
            });

            function getPath(id, time) {
                var pathList = myG.select(id).attr("d");
                d3.selectAll('.train')
                    .append("animateMotion")
                    .attr('dur', time)
                    .attr('repeatCount', 'indefinite')
                    .attr('rotate', 'auto')
                    .attr('path', pathList)
            }

            $.getJSON('/static/json/d3Svg/demo.json', function (data) {
                var station = myG.selectAll(".station")
                    .data(data)
                    .enter()
                    .append("line")
                    .attr("x1", function (d) {
                        return d.value.x
                    })
                    .attr("y1", function (d) {
                        return d.value.y - 5
                    })
                    .attr("x2", function (d) {
                        return d.value.x
                    })
                    .attr("y2", function (d) {
                        return d.value.y - -5
                    })
                    .attr("class", "station");
                $.each(data, function (i, item) {
                    if (item.circle.show) {
                        myG.append('circle')
                            .attr('class', 'tool1_circle')
                            .attr('cx', item.value.x)
                            .attr('cy', item.value.y)
                            .attr("r", 5)
                            .on('click', function () {
                                d3.selectAll(".active").classed("active", false);
                                d3.select(this).attr("class", "circle active");
                            });
                    }
                    if (item.d_circle.show) {
                        myG.append('circle')
                            .attr('class', 'tool1_circle')
                            .attr('cx', item.value.x)
                            .attr('cy', item.value.y)
                            .attr('r', 5);
                        myG.append('circle')
                            .attr('class', 'tool1_circle')
                            .attr('cx', item.value.x - 10)
                            .attr('cy', item.value.y)
                            .attr('r', 5);
                    }
                    if(item.b_circle.show){
                        myG.append('circle')
                            .attr('class', 'tool2_circle')
                            .attr('cx', item.value.x)
                            .attr('cy', item.value.y)
                            .attr('r', 5);
                        myG.append('text')
                            .attr("class","tool2_circle")
                            .attr("x",data[i].value.x)
                            .attr("y",data[i].value.y)
                            .attr(item.b_circle.name);
                    }
                    if(item.triangle.show){
                        var position= [item.value.x - -8,item.value.y- - 15,item.value.x- - 3,item.value.y- - 5,item.value.x-2,item.value.y- - 15];
                        myG.append("polygon")
                            .attr("points",position)
                            .attr("class","tool4_polygon");
                    }
                    if(data[i].linkRight.length!=0){
                        for(var j= 0;j<data[i].linkRight.length;j++){
                            var linkId = data[i].linkRight[j].linkId;
                            var color = data[i].linkRight[j].color;
                            var arr = getData(linkId);
                            if(j==0){
                                myG.append("line")
                                    .attr("x1",arr.value.x)
                                    .attr("y1",arr.value.y)
                                    .attr("x2",data[i].value.x)
                                    .attr("y2",data[i].value.y)
                                    .style("stroke",color);
                            }
                            else{
                                myG.append("text")
                                    .attr("class","pointname")
                                    .attr("x",data[i].value.x )
                                    .attr("y",data[i].value.y)
                                    .text(data[i].name);
                                myG.append("line")
                                    .attr("x1",data[i].value.x)
                                    .attr("y1",arr.value.y)
                                    .attr("x2",data[i].value.x)
                                    .attr("y2",data[i].value.y)
                                    .style("stroke",color);
                                myG.append("line")
                                    .attr("x1",data[i].value.x)
                                    .attr("y1",arr.value.y)
                                    .attr("x2",arr.value.x)
                                    .attr("y2",arr.value.y)
                                    .style("stroke","#fff");
                                myG.append("line")
                                    .attr("x1",data[i].value.x)
                                    .attr("y1",data[i].value.y)
                                    .attr("x2",data[i].value.x)
                                    .attr("y2",data[i].value.y)
                                    .style("stroke","#fff");
                            }
                            d3.selectAll("line").attr("cursor","pointer").style("stroke-width","1.5").on("click",function(){
                                if(d3.select(this).style("stroke")=="rgb(0, 0, 255)"){
                                    d3.select(this).style("stroke","#50bee6");
                                }
                                else if(d3.select(this).style("stroke")=="rgb(255, 0, 0)"){
                                    d3.select(this).style("stroke","green");
                                } else if(d3.select(this).style("stroke")=="rgb(0, 128, 0)"){
                                    d3.select(this).style("stroke","red");
                                } else if(d3.select(this).style("stroke")=="rgb(80, 190, 230)"){
                                    d3.select(this).style("stroke","red");
                                } else if(d3.select(this).style("stroke")=="rgb(255, 255, 0)"){
                                    d3.select(this).style("stroke","yellow");
                                } else if(d3.select(this).style("stroke")=="rgb(255, 255, 255)"){
                                    d3.select(this).style("stroke","green");
                                }

                            })
                        }
                    }
                    function getData(id) {
                        for(var i = 0;i<data.length;i++){
                            if(data[i].id == id){
                                return data[i];
                            }
                        }
                    }
                })
            })
        }
    }
})();