(function () {
    $(document).ready(function () {
        gridView.init();
    });
    var gridView = {
        init: function () {
            var self = this;
            self.getUser();
            self.initButtonEvent();
            self.initMenu();
        },
        getUser:function(){
            $.ajax({
                url:"/login/getSessionUser",
                type:"post",
                async:"false",
                dataType:"text",
                success:function (data) {
                    $('#username').val(data);
                }
            })
        },
        initButtonEvent: function () {
        },
        initMenu: function () {
            var li = $('.nav-sidebar li');
            li.click(function () {
                $(this).siblings('li').removeClass('active');
                $(this).addClass('active');
            })
        },
        initWebSocket:function () {

        }
    };
})(this);