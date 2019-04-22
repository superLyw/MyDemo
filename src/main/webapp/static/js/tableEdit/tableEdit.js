(function () {
    var rowNum = 0;
    $(function () {
        tableEdit.init();
    });
    var tableEdit = {
        gridColumn1:[
            {
                title:"用户名",
                field:"S_ID",
                width:'12%'
            },
            {
                title:"姓名",
                field:"S_NAME",
                align:"center",
                width:'12%'
            },
            {
                title:"密码",
                field:"S_PASSWORD",
                align:"center",
                width:'12%'
            },
            {
                title:"邮箱",
                field:"S_EMAIL",
                align:"center",
                width:'12%'
            },
            {
                title:"是否管理员",
                field:"S_ISADMIN",
                align:"center",
                width:'8%',
                formatter:function (value,row,index) {
                    if(value=='1'){
                        return '是';
                    }else{
                        return '否';
                    }
                }
            },
            {
                title:"是否可用",
                field:"S_STATUS",
                align:"center",
                width:'8%',
                formatter:function (value,row,index) {
                    if(value=='1'){
                        return '是';
                    }else{
                        return '否';
                    }
                }
            },
            {
                title:"更新时间",
                field:"D_UPDATETIME",
                align:"center",
                width:'18%'
            },
            {
                title:"创建时间",
                field:"D_CREATETIME",
                align:"center",
                width:'18%'
            }
        ],
        init: function () {
            var self = this;
            self.initButton();
            self.initTable();
            self.initTable1();
        },
        initButton: function () {
            $('#addBtn').click(function () {
                var count = $('#testTable').bootstrapTable('getData').length;
                // newFlag == 1的数据为新规的数据
                $('#testTable').bootstrapTable('insertRow', {
                    index: count,
                    row: {
                        id:count,
                        qwe1: '<input type="text"/>',
                        qwe2: "2",
                        qwe3: "3"
                    }
                });

            });
            $('#addBtn1').click(function () {
                tableEdit.addFunction();
                rowNum++;
                $('#testTable').bootstrapTable('refresh');
            });
            $('#getData').click(function () {
                alert($('#testTable').bootstrapTable('getData'));
            });
            $('#delInfo').click(function () {
                $('#testTable').bootstrapTable('removeByUniqueId', 2);
            });
            $('#getData1').click(function () {
                var html = "";
                debugger;
                for(var i=0;i<rowNum+1;i++){
                    html+=$('#ttt'+rowNum).val()+"--------";
                }
                alert(html);
            })
        },
        addFunction:function () {
            $('#testTable tbody').append("    <tr>\n" +
                "        <td><input type='text' id='ttt"+rowNum+"' /></td>\n" +
                "        <td>Item 1</td>\n" +
                "        <td>$1</td>\n" +
                "    </tr>")
        },
        initTable:function () {
            $("#testTable").bootstrapTable("destroy").bootstrapTable({
                height:400,
                uniqueId:"id",
                columns:[
                    {
                        title:"id",
                        field:"id",
                        align:"center"
                    },
                    {
                        title:"创建时间1",
                        field:"qwe1",
                        align:"center",
                        editable: {
                            type: 'date',
                            title: 'qwe111',
                            validate: function (v) {
                                if (!v) return '不能为空';
                            }
                        }
                    },{
                        title:"创建时间2",
                        field:"qwe2",
                        align:"center"
                    },{
                        title:"创建时间3",
                        field:"qwe3",
                        align:"center"
                    }
                ]
            });
        },
        initTable1:function () {
            var self = this;
            $("#testTable1").bootstrapTable("destroy").bootstrapTable({
                method: 'post',
                url: "/sysUser/queryList",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                queryParams: self.queryParams,//传递参数（*）
                sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 15,                       //每页的记录行数（*）
                pageList: [5, 10, 15, 20, 50, 100],        //可供选择的每页的行数（*）
                search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: false,
                showColumns: false,                  //是否显示所有的列
                showRefresh: false,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                uniqueId: "S_ID", //每一行的唯一标识，一般为主键列
                showExport: false,
                height: 300,
                columns: self.gridColumn1
            });
        },
        queryParams: function () {
            var self = this;
            var temp = {
                pageSize:self.pageSize,
                pageNumber:self.pageNumber
            };
            return temp;
        }
    }
})();