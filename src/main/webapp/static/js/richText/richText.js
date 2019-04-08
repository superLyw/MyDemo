(function () {
    $(function () {
        var self = this;
        // initEditor();
        Ueditor.initEditor();
    });
    // initEditor = function(){
    //     var ue = UE.getEditor('editor');
    //
    // }
})();
var Ueditor = {
    id: "editor",	//divId
    ue: ""
};
Ueditor.initEditor = function(){
    Ueditor.ue = UE.getEditor('editor', {
        toolbars: [[
            'undo', //撤销
            'redo', //重做
            'bold', //加粗
            'italic', //斜体
            'underline', //下划线
            'fontborder', //字符边框
            'strikethrough', //删除线
            // 'superscript', //上标
            // 'subscript', //下标
            'removeformat', //清除格式
            'formatmatch', //格式刷
            // 'autotypeset', //自动排版
            // 'source', //源代码
            // 'blockquote', //引用
            // 'pasteplain', //纯文本粘贴模式
            'forecolor', //字体颜色
            'backcolor', //背景色
            // 'insertorderedlist', //有序列表
            // 'insertunorderedlist', //无序列表
            'selectall', //全选
            'cleardoc', //清空文档
            // 'rowspacingtop', //段前距
            'rowspacingbottom', //段后距
            // 'lineheight', //行间距
            // 'customstyle', //自定义标题
            // 'paragraph', //段落格式
            'fontfamily', //字体
            'fontsize', //字号
            // 'directionalityltr', //从左向右输入
            // 'directionalityrtl', //从右向左输入
            'indent', //首行缩进
            'justifyleft', //居左对齐
            'justifyright', //居右对齐
            'justifycenter', //居中对齐
            'justifyjustify', //两端对齐
            'touppercase', //字母大写
            'tolowercase', //字母小写
            // 'link', //超链接
            // 'unlink', //取消链接
            // 'anchor', //锚点
            'imagenone', //默认
            'imageleft', //左浮动
            'imageright', //右浮动
            'imagecenter', //居中
            'simpleupload', //单图上传
            'insertimage', //多图上传
            'emotion', //表情
            'scrawl', //涂鸦
            // 'insertvideo', //视频
            // 'music', //音乐
            // 'attachment', //附件
            // 'map', //Baidu地图
            // 'gmap', //Google地图
            // 'insertframe', //插入Iframe
            // 'insertcode', //代码语言
            // 'webapp', //百度应用
            'pagebreak', //分页
            'template', //模板
            'background', //背景
            'horizontal', //分隔线
            'date', //日期
            'time', //时间
            'spechars', //特殊字符
            // 'snapscreen', //截图
            'wordimage', //图片转存
            'inserttable', //插入表格
            'deletetable', //删除表格
            'edittable', //表格属性
            'edittd', //单元格属性
            'insertparagraphbeforetable', //"表格前插入行"
            'insertrow', //前插入行
            'deleterow', //删除行
            'insertcol', //前插入列
            'deletecol', //删除列
            'mergecells', //合并多个单元格
            'mergeright', //右合并单元格
            'mergedown', //下合并单元格
            'splittocells', //完全拆分单元格
            'splittorows', //拆分成行
            'splittocols', //拆分成列
            // 'charts',// 图表
            // 'print', //打印
            // 'preview', //预览
            // 'searchreplace', //查询替换
            'drafts', // 从草稿箱加载
            // 'help', //帮助
            //'fullscreen',//全屏
            //other
            'deletecaption', //删除表格标题
            'inserttitle', //插入标题
            'edittip ' //编辑提示
        ]],
        autoHeightEnabled: false,
        autoFloatEnabled: false
    });
    UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;
    UE.Editor.prototype.getActionUrl = function(action) {
        debugger;
        if (action == 'uploadimage' || action == 'uploadscrawl') {
            return "/ueditor/upload";
        } else {
            return this._bkGetActionUrl.call(this, action);
        }
    };
};