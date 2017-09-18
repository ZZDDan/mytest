<%@ page language="java"  pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = "://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WebSocket Demo</title>
</head>
<body>
    <h1>Test Websocket</h1>


    <script type="text/javascript" src="js/websocket.js"></script>
    <script type="text/javascript">
        var BASE_PATH = "<%=basePath %>";
        startConnect("ws" + BASE_PATH + "/websocket");
    </script>
</body>
</html>