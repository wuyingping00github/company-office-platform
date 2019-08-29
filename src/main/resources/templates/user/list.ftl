<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <script src="${request.contextPath}/js/jquery.js"></script>
    <script>
        $(function(){
            //添加图片点击数据
            $("#carImg").click(function(){
                alert("你想买这部车吗？");
            });
        });
    </script>
</head>
<body>
ABC<br>
<img id="carImg" src="${request.contextPath}/imgs/1.jpg" width="300px" height="300px">
</body>
</html>