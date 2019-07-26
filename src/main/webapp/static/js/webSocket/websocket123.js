var websocket = null;
var username = "";
//判断当前浏览器是否支持WebSocket
$.ajax({
    url: "/login/getSessionUser",
    type: "post",
    async: false,
    dataType: "text",
    success: function (data) {
        $('#username').val(data);
        username = data;
        console.log(data);
    }
});


//获取当前网址，如：
var curWwwPath = window.document.location.href;
//获取主机地址之后的目录如：/Tmall/index.jsp
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
//获取主机地址，如：//localhost:8080
var localhostPath = curWwwPath.substring(5, pos);
// var localhostPath = '//localhost:8081';
if ('WebSocket' in window) {
    websocket = new WebSocket("ws:" + localhostPath + "/webSocketServer/" + username);
}
else {
    alert('当前浏览器 Not support websocket')
}
//连接发生错误的回调方法
websocket.onerror = function () {
    setMessageInnerHTML("WebSocket连接发生错误");
};

//连接成功建立的回调方法
websocket.onopen = function () {
    setMessageInnerHTML("WebSocket连接成功");
};

//接收到消息的回调方法
websocket.onmessage = function (event) {
    setMessageInnerHTML(event.data);
};

//连接关闭的回调方法
websocket.onclose = function () {
    setMessageInnerHTML("WebSocket连接关闭");
};

//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function () {
    closeWebSocket();
};

//将消息显示在网页上
function setMessageInnerHTML(innerHTML) {
    document.getElementById('message').innerHTML += innerHTML + '<br/>';
    // console.log(innerHTML);
}

//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}

//发送消息
function send() {
    var message = $('#text').val();
    websocket.send(message);
}
