(function () {
    $(function () {
        gridView.test1();
    });
    var gridView = {
        test1: function () {
            $('#test1').on('click', function () {
                layer.alert('内容');
            });
            //自定义弹出框
            $('#test2').on('click', function () {
                layer.open({
                    type: 1,
                    area: ['420px', '240px'], //宽高
                    skin: 'layui-layer-demo', //样式类名
                    closeBtn: 0, //不显示关闭按钮
                    anim: 2,
                    shadeClose: true, //开启遮罩关闭
                    content: '内容'
                });
            });
            var tipG = d3.select('svg')
                .append('g');
            tipG.append('rect')
                .attr('width',"300px")
                .attr('height',"200px")
                .attr('fill',"#d0ee22")

            $('#test3').on('click',function () {

            })
        }
    }
})();