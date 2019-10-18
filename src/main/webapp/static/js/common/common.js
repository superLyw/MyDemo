(function () {
    /**
     * 添加模板
     * @param title 题目
     * @param content 内容
     */
    $.fn.addTemplate = function (title, content) {
        this.append("<br/><div class=\"testTemplate\">" +
            "    <p class=\"title\">" + title + "</p>" +
            "    <p class=\"content\">" +
            "        " + content + "</p>" +
            "    <div class=\"footer\">" +
            "        <span>" +
            "            <img src=\"/static/images/u4398.png\">&nbsp;联调计划&nbsp;<img src=\"/static/images/u8090.png\">" +
            "        </span>" +
            "        <span>" +
            "            <img src=\"/static/images/u4398.png\">&nbsp;联调报告&nbsp;<img src=\"/static/images/u8090.png\">" +
            "        </span>" +
            "    </div>" +
            "</div>");
    };
    $.fn.initInfoWin = function () {
        var svg = d3.select(this.selector);
        var defs = svg.append('defs');
        var g = defs.append('g')
            .attr('id','popInfoWin');
        g.append('rect')
            .attr('class','bigRect')
            .attr('width',200)
            .attr('height',100)
            .attr('fill','rgba(8,80,122,0.5)');
        g.append('rect')
            .attr('class','bigRect')
            .attr('width',200)
            .attr('height',100)
            .attr('fill','rgba(10,54,88,0.5)');
    };
    $.showInfoWin = function () {
        svg.append('use')
            .attr('x', 100)
            .attr('y', 80)
            .attr('href', '#popInfoWin')
    }
})();