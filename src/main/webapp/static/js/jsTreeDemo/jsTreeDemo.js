(function () {
        $(function () {
            jsTreeDemo.getJsTreeData();
            jsTreeDemo.jsTree();
            jsTreeDemo.buttonEvent();
            jsTreeDemo.formSubmit();
        });
        var treeList = [];
        var jsTreeDemo = {
            init: function () {
                var self = this;
                self.jsTree();
                self.addInfoWin()
            },
            getJsTreeData: function () {
                $.ajax({
                    url: '/jsTreeDemo/treeList',
                    type: 'post',
                    async: false,
                    dataType: 'json',
                    success: function (data) {
                        treeList = [];
                        var first = {};
                        first.id = 'qwe1';
                        first.parent = '#';
                        first.text = '父节点';
                        treeList.push(first);
                        for (var i = 0; i < data.length; i++) {
                            first = {};
                            first.id = data[i].ID;
                            first.parent = data[i].PARENT;
                            first.text = data[i].TEXT;
                            treeList.push(first);
                        }
                    }
                });
            },
            jsTree: function () {
                $('#jsTree').jstree({
                    'core': {
                        'data': treeList
                    },
                    'plugins': ['dnd', 'contextmenu', 'search'],
                    'contextmenu': {
                        'items': {
                            'item1': {
                                'label': '添加',
                                'action': function (data) {
                                    var inst = $.jstree.reference(data.reference);
                                    var obj = inst.get_node(data.reference);
                                    jsTreeDemo.addInfoWin();
                                }
                            },
                            'item2': {
                                'label': '修改',
                                'action': function () {
                                    jsTreeDemo.editInfoWin();
                                }
                            },
                            'item3': {
                                'label': '删除',
                                'action': function () {
                                    jsTreeDemo.delInfoWin();
                                }
                            }
                        }
                    }
                });
            },
            buttonEvent: function () {
                $('#btnAddCancel').click(function () {
                    layer.closeAll();
                })
            },

            formSubmit: function () {
                $("#form").validate({
                    rules: {
                        codeName: {
                            required: true
                        }
                    },
                    messages: {
                        codeName: {
                            required: "必填"
                        }
                    },
                    submitHandler: function (form) {
                        var formData = new FormData($(form)[0]);
                        formData.append("sPid", $('#codePId').val());
                        formData.append("sText", $('#codeName').val());
                        $.ajax({
                            url: "/jsTreeDemo/addTree",
                            type: "post",
                            processData: false,  //必须false才会避开jQuery对 formdata 的默认处理
                            contentType: false,  //必须false才会自动加上正确的Content-Type
                            data: formData,
                            async: false,
                            success: function (data) {
                                if (data.code == '0') {
                                    layer.open({
                                        content: data.msg,
                                        success: function () {
                                            layer.closeAll();
                                            jsTreeDemo.getJsTreeData();
                                            $('#jsTree').jstree(true).destroy().refresh();
                                        }
                                    });
                                }
                            }
                        });
                    }
                });
            },
            //添加
            addInfoWin: function () {
                layer.open({
                    type: 1,
                    area: ['420px', '240px'], //宽高
                    skin: 'layui-layer-demo', //样式类名
                    closeBtn: 1, //不显示关闭按钮
                    anim: 2,
                    shadeClose: true, //开启遮罩关闭
                    content: $('#addInfoWin'),
                    success: function () {
                        $('#codeName').val("");
                        $('#sId').val("");
                        var parentId = $('#jsTree').jstree(true).get_selected(true)[0].id;
                        var parentName = $('#jsTree').jstree(true).get_selected(true)[0].text;
                        $('#codePName').val(parentName);
                        $('#codePId').val(parentId);
                    }
                });
            },
            //修改
            editInfoWin: function () {
                layer.open({
                    type: 1,
                    area: ['420px', '240px'], //宽高
                    skin: 'layui-layer-demo', //样式类名
                    closeBtn: 1, //不显示关闭按钮
                    anim: 2,
                    shadeClose: true, //开启遮罩关闭
                    content: $('#addInfoWin'),
                    success: function () {
                        var node = $('#jsTree').jstree(true).get_selected(true)[0];
                        var parentId = node.parent;
                        var parentName = $('#jsTree').jstree(true).get_node(parentId).text;
                        $('#sId').val(node.id);
                        $('#codePName').val(parentName);
                        $('#codePId').val(parentId);
                        $('#codeName').val(node.text);
                    }
                });
            },
            //删除
            delInfoWin:function () {
                layer.confirm('确定要删除吗？', {
                    btn: ['确定','取消'] //按钮
                }, function(){
                    var nodeId = $('#jsTree').jstree(true).get_selected(true)[0].id;
                    $.ajax({
                        url:'/jsTreeDemo/delTree',
                        type:'post',
                        data:{
                            sId : nodeId
                        },
                        async:false,
                        dataType:'json',
                        success:function (data) {
                            if (data.code == '0') {
                                layer.msg('删除成功', {icon: 1});
                                jsTreeDemo.getJsTreeData();
                                $('#jsTree').jstree(true).destroy().refresh();
                            }
                        }
                    });
                }, function(){
                    layer.closeAll();
                });
            }
        }
    }
)();