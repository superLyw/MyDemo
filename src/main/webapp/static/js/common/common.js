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
    }
})();