<%--
  Created by IntelliJ IDEA.
  User: 13218
  Date: 2021/9/19
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>div布局</title>
    <style type="text/css">
        body{
            margin:0;
            padding:0;
        }
        #container{
            width:100%;
            height:650px;
            background-color: aqua;
        }
        #heading{
            width:100%;
            height:10%;
            background-color: red;
        }
        #content-menu{
            width:30%;
            height:80%;
            background-color: yellow;
            float:left;
        }
        #content-body{
            width:70%;
            height:80%;
            background-color: darkgreen;
            float:left;
        }
        #footer{
            width:100%;
            height:10%;
            background-color: red;
            clear: both;
        }
    </style>
</head>
<script>
    function showName(){
        alert("布局名称")
    }
    function dis(){
        var color = document.getElementById("content-menu")
        color.style.display = "none";
    }
    function appear(){

        var color = document.getElementById("content-menu")
        color.style.display = "block";

    }
</script>
<body>
<div id="container">
    <div id="heading" onclick="appear()">网页的头部</div>
    <div id="content-menu" onclick="dis()" >网页的左部</div>
    <div id="content-body" onclick="showName()">网页的右部</div>
    <div id="footer">网页的底部</div>
</div>
</body>
</html>
