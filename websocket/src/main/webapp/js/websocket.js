/**
 * 创建 websocket 连接
 */
function startConnect(url){
	if(!window.WebSocket){
        $("body").append("<h1>你的浏览器不支持WebSocket</h1>");
        return;
    }

	var webSocket = createWebsocket(url);
    
	// 设置监听器，如果连接处于不可用状态则重新建立连接，监听周期为 12小时。
    var time = 1000 * 60 * 60 * 12;
    var webSocketInterval = setInterval(function(){
    	/*
    	 ocket.readyState	
    	 readyState的代表的ReadOnly属性的连接状态。它可以有以下值：
			一个0值表示该连接尚未建立。
			值为1表示连接建立和沟通是可能的。
			值为2表示连接是通过将结束握手。
			值为3表示连接已关闭或无法打开。
    	 */
    	var readyState = webSocket.readyState;
    	if(readyState == 0 || readyState == 3){
    		webSocket = createWebsocket(url);
    	}
    	
    },time);
    
    window.onbeforeunload = function(event) {
    	sendMessage(webSocket, "close");
    	clearInterval(webSocketInterval);
    };
}

/**
 * 创建 websocket 连接
 * @param url
 */
function createWebsocket(url) {
	var webSocket = new WebSocket(url);
    
    webSocket.onerror = function(event) {
        onError(event)
    };
    webSocket.onclose = function(event) {
    	onClose(event)
    };
    webSocket.onopen = function(event) {
        onOpen(event)
    };
    webSocket.onmessage = function(event) {
        onMessage(webSocket, event)
    };
    
    return webSocket;
}

/**
 * 接收服务器发送给客户端消息的回调函数
 * @param event
 */
function onMessage(webSocket, event) {
    console.log(event.data);
}

/**
 * 连接服务端成功的回调函数
 * @param event
 */
function onOpen(event) {
	console.log("onOpen");
}

/**
 * 连接服务端失败的回调函数
 * @param event
 */
function onError(event) {
	console.log("onError");
}

/**
 * 连接服务端关闭的回调函数
 * @param event
 */
function onClose(event) {
	console.log("onClose");
}

/**
 * 向服务端发送消息
 */
function sendMessage(webSocket, msg){
    webSocket.send(msg);//向服务器发送消息
}