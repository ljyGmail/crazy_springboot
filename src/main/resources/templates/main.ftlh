<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录成功</title>
    <!-- 引用WarJar中的静态资源 -->
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.3/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/webjars/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<div class="container">
    <img src="/logo.png" class="rounded mx-auto d-block">
    <h4>登录成功</h4>
    欢迎您， <span>${Session['name']}</span>，登录成功<br>
    您的角色是：<#switch Session['role']>
        <#case 'admin'>
            <span>系统管理员</span>
            <#break>
        <#case 'manager'>
            <span>经理</span>
            <#break>
        <#default>
            <span>普通员工</span>
    </#switch>
    <a href="/viewBooks">查看图书</a>
</div>
</body>
</html>