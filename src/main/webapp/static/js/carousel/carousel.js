(function () {
    $(function () {
        gridView.init();
    });
    var gridView = {
        gridColumn1 : [
            {
                title:"线路名称",
                field:"field1"
            },
            {
                title:"行别",
                field:"field2"
            },
            {
                title:"偏差类型",
                field:"field3"
            },
            {
                title:"偏差级别",
                field:"field4"
            },
            {
                title:"检测专业",
                field:"field5"
            },
            {
                title:"检测车号",
                field:"field6"
            },
            {
                title:"检测日期",
                field:"field7"
            },
            {
                title:"铁路局名",
                field:"field8"
            }
        ],
        init:function () {
            var self = this;

            self.initTable1();
            self.initTable2();
            // 初始化轮播
            self.initCarousel();
        },
        initTable1:function () {
            var self = this;
            $('#slideTable1').bootstrapTable("destroy").bootstrapTable({
                method: 'get',
                url: "/static/json/carouselTable1.json",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: false,                   //是否显示分页（*）
                sortable: true,                     //是否启用排序
                sortOrder: "desc",                   //排序方式
                sortName: "S_NAME",
                // queryParams: self.queryParams,//传递参数（*）
                sidePagination: "server",       //分页方式：client客户端分页，server服务端分页（*）
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
                height: 250,
                columns: self.gridColumn1
            });
        },
        initTable2:function () {
            var self = this;
            $('#slideTable2').bootstrapTable("destroy").bootstrapTable({
                method: 'get',
                url: "/static/json/carouselTable1.json",
                contentType: "application/x-www-form-urlencoded; charset=UTF-8",
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: false,                   //是否显示分页（*）
                sortable: true,                     //是否启用排序
                sortOrder: "desc",                   //排序方式
                sortName: "",
                // queryParams: self.queryParams,//传递参数（*）
                sidePagination: "server",       //分页方式：client客户端分页，server服务端分页（*）
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
                height: 250,
                columns: self.gridColumn1
            });
        },
        initCarousel:function () {
            var self = this ;
            $('#myCarousel').carousel({
                interval:2000,
                pause:"hover"
            });
            // 监听换页动作
            $('#myCarousel').on('slide.bs.carousel', function (data) {
                // 执行一些动作...

            })
        }
    }
})();