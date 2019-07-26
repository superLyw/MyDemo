(function () {
    var onoff = true;//根据此布尔值判断当前为注册状态还是登录状态
    var confirm = document.getElementsByClassName("confirm")[0];

    $(document).ready(function () {
        loginView.init();
    });
    var loginView = {
        init: function () {
            var self = this;
            self.initView();
            self.initButton();
        },
        initView: function () {
            //自动居中title
            var name_c = document.getElementById("title");
            name = name_c.innerHTML.split("");
            name_c.innerHTML = "";
            for (i = 0; i < name.length; i++)
                if (name[i] != ",")
                    name_c.innerHTML += "<i>" + name[i] + "</i>"
        },
        initButton: function () {
            $('#signinBtn').click(function () {
                let status = document.getElementById("status").getElementsByTagName("i");
                let hit = document.getElementById("hint").getElementsByTagName("p")[0];
                if (onoff) {
                    confirm.style.height = 51 + "px";
                    status[0].style.top = 35 + "px";
                    status[1].style.top = 0;
                    onoff = !onoff
                } else {
                    var username = $('#userN').val();
                    var password = $('#passWd').val();
                    var confirmPassWd = $('#confirmPassWd').val();

                    if (!/^[A-Za-z0-9]+$/.test(username))
                        layer.open({
                            content: "账号只能为英文和数字"
                        });
                    else if (password != confirmPassWd)
                        layer.open({
                            content: "两次密码不相等"
                        });
                    else if (password = confirmPassWd) {
                        $.ajax({
                            type: "post",
                            url: "/login/register",
                            data: {
                                username: username,
                                password: password
                            },
                            dataType: "json",
                            async: false,
                            success: function (data) {
                                if (data.code == "0") {
                                    layer.open({
                                        content: "注册成功，请登录",
                                        success: function () {
                                            $('#loginBtn').click();
                                            $('#userN').val(username);
                                            $('#passWd').val(password);
                                        }
                                    });
                                } else {
                                    layer.open({
                                        content: data.msg
                                    });
                                }
                            }
                        })
                    }
                }
            });
            $('#loginBtn').click(function () {
                if (onoff) {
                    /*let request = new XMLHttpRequest()
                    let url = ""
                    request.open("post", url, true)
                    let data = new FormData()
                    data.append("user", user.value)
                    data.append("passwd", passwd.value)
                    request.onreadystatechange = function() {
                        if (this.readyState == 4) {
                            if (this.responseText == false)
                                hint()
                            else
                                window.location.href = this.responseText;
                        }
                    }
                    request.send(data)*/
                    var username = $('#userN').val();
                    var password = $('#passWd').val();

                    $.ajax({
                        type: "post",
                        url: "/login/isUser",
                        data: {
                            username: username,
                            password: password
                        },
                        dataType: "json",
                        async: false,
                        success: function (data) {
                            if (data.code == "0") {
                                window.location.href = "/";
                            } else if (data.code == "200") {
                                alert(data.msg);
                            } else {
                                alert("登录失败");
                            }
                        }
                    })
                } else {
                    let status = document.getElementById("status").getElementsByTagName("i");
                    confirm.style.height = 0;
                    status[0].style.top = 0;
                    status[1].style.top = 35 + "px";
                    onoff = !onoff
                }
            })
        }
    }
})()