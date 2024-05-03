<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <title>登录页面</title>
    <link rel="icon" href="favicon.ico" type="image/ico">
    <meta name="keywords" content="美妆二手交易系统">
    <meta name="description" content="美妆二手交易系统。">
    <meta name="author" content="yinqi">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/materialdesignicons.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet">
    <link rel="stylesheet" href="js/jconfirm/jquery-confirm.min.css">
    <style>
        body {
            display: -webkit-box;
            display: flex;
            -webkit-box-pack: center;
            justify-content: center;
            -webkit-box-align: center;
            align-items: center;
            height: 100%;
        }
        .login-box {
            display: table;
            table-layout: fixed;
            overflow: hidden;
            max-width: 700px;
        }
        .login-left {
            display: table-cell;
            position: relative;
            margin-bottom: 0;
            border-width: 0;
            padding: 45px;
        }
        .login-left .form-group:last-child {
            margin-bottom: 0px;
        }
        .login-right {
            display: table-cell;
            position: relative;
            margin-bottom: 0;
            border-width: 0;
            padding: 45px;
            width: 50%;
            max-width: 50%;
            background: #67b26f!important;
            background: -moz-linear-gradient(45deg,#67b26f 0,#4ca2cd 100%)!important;
            background: -webkit-linear-gradient(45deg,#67b26f 0,#4ca2cd 100%)!important;
            background: linear-gradient(45deg,#67b26f 0,#4ca2cd 100%)!important;
            filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#67b26f', endColorstr='#4ca2cd', GradientType=1 )!important;
        }
        .login-box .has-feedback.feedback-left .form-control {
            padding-left: 38px;
            padding-right: 12px;
        }
        .login-box .has-feedback.feedback-left .form-control-feedback {
            left: 0;
            right: auto;
            width: 38px;
            height: 38px;
            line-height: 38px;
            z-index: 4;
            color: #dcdcdc;
        }
        .login-box .has-feedback.feedback-left.row .form-control-feedback {
            left: 15px;
        }
        @media (max-width: 576px) {
            .login-right {
                display: none;
            }
        }
    </style>
</head>

<body style="background-image: url(images/login-bg-2.jpg); background-size: cover;">
<div class="bg-translucent p-10">
    <div class="login-box bg-white clearfix">
        <div class="login-left">
            <form action="#!" method="post">
                <div class="form-group has-feedback feedback-left">
                    <input type="text" placeholder="请输入账号" class="form-control" name="account" id="account" />
                    <span class="mdi mdi-account form-control-feedback" aria-hidden="true"></span>
                </div>
                <div class="form-group has-feedback feedback-left">
                    <input type="password" placeholder="请输入密码" class="form-control" id="password" name="password" />
                    <span class="mdi mdi-lock form-control-feedback" aria-hidden="true"></span>
                </div>
                <div class="form-group has-feedback feedback-left row">
                    <div class="col-xs-7">
                        <input type="text" name="captcha" class="form-control" placeholder="验证码">
                        <span class="mdi mdi-check-all form-control-feedback" aria-hidden="true"></span>
                    </div>
                    <div class="col-xs-5">
                        <img src="public/verifyCode" class="pull-right" id="captcha" style="cursor: pointer;" onclick="this.src=this.src+'?d='+Math.random();" title="点击刷新" alt="captcha">
                    </div>
                </div>
                <div class="form-group">
                    <button class="btn btn-block btn-primary" type="button" onclick="login()">立即登录</button>
                </div>
            </form>
        </div>
        <div class="login-right">
            <p>美妆二手交易系统</p>
            <p class="text-white m-tb-15">“探索美丽的世界，尽在我们的美妆交易平台！发现无尽的化妆品选择，满足您的每一个美丽需求。从时尚潮流到经典款式，我们汇聚了最受欢迎的品牌和产品，为您打造独一无二的妆容。点击访问，开启您的美妆之旅！。</p>
            <p class="text-white"><a href="/register">注册账号</a></p>
            <p class="text-white">Copyright © 2024 <a href="http://localhost:8080">美妆二手交易系统</a>. All right reserved</p>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script src="js/jconfirm/jquery-confirm.min.js"></script>
<script type="text/javascript">
    function login() {
        var account = $("#account").val();
        var password = $("#password").val();
        var captcha = $("input[name='captcha']").val();

        if (account == "" || password == "" || captcha == "") {
            $.confirm({
                title: '警告',
                content: '请输入完整登录信息。',
                type: 'orange',
                typeAnimated: false,
                buttons: {
                    close: {
                        text: '关闭',
                    }
                }
            });
            return;
        }

        $.ajax({
            type:"POST",
            url:"login",
            data:{
                "account": account,
                "password": password,
                "captcha": captcha
            },
            async:false,
            dataType:"json",
            success:function(data){
                if (data.success) {
                    window.location.href="/admin/index";
                }else {
                    $.confirm({
                        title: '警告',
                        content: data.message,
                        type: 'orange',
                        typeAnimated: false,
                        buttons: {
                            close: {
                                text: '关闭',
                            }
                        }
                    });
                }
            },
            error:function(w, e, q){
                console.log(q)
            }

        });
    }
</script>
</body>
</html>