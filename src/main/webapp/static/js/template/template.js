(function () {
    $(function () {
        gridView.init();
    });
    var gridView = {
        gridColumn1 : [
            {
                field: '',
                title: '序号',
                align: 'center',
                formatter: function (value, row, index) {
                    var page = $('#addPlaceTable').bootstrapTable("getPage");
                    return page.pageSize * (page.pageNumber - 1) + index + 1;
                },
                visible:false
            }
        ],
        init: function () {
            var self = this;
            self.initButton();
            self.initTableView();
        },
        initButton: function () {
            $('#addButton').click(function () {
                $('#addPlace').addTemplate("京沈高铁沈阳段","CRH2A-2010车，2018年9月~12月参与联调联试检测。第一个步骤就是“静态验收”，只对路基、轨道、接触网等等各个专业门类进行检查、验收，接下来是”动态验收“，即“冷滑试验”，由验收单位组织内燃机车牵引轨道检测车、接触网检测车上线“试跑”，目的是检查各系统设备安装和性能是否符合设计要求等（冷滑试验已于1月完成");
            });

        },
        initTableView:function () {
            var self = this;
            $("#addPlaceTable").bootstrapTable("destroy").bootstrapTable({
                method: 'post',
                url: "/sysUser/queryList",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: true,                     //是否启用排序
                sortOrder: "desc",                   //排序方式
                sortName: "S_NAME",
                queryParams: self.queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 5,                       //每页的记录行数（*）
                pageList: [5, 10, 15, 20, 50, 100],        //可供选择的每页的行数（*）
                search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: false,
                showColumns: false,                  //是否显示所有的列
                showRefresh: false,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                uniqueId: "S_ID", //每一行的唯一标识，一般为主键列
                showExport: false,
                columns: self.gridColumn1
            });
        }
    }
})();