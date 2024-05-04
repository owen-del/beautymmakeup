<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>美妆二手交易系统</title>
    <link rel="icon" href="favicon.ico" type="image/ico">
    <meta name="keywords" content="美妆二手交易系统">
    <meta name="description" content="美妆二手交易系统">
    <meta name="author" content="yinqi">
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/materialdesignicons.min.css" rel="stylesheet">
    <link href="/css/style.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/js/jconfirm/jquery-confirm.min.css">
</head>

<body>
<div class="lyear-layout-web">
    <div class="lyear-layout-container">
        <!--左侧导航-->
        <jsp:include page="../leftMenu.jsp"/>
        <!--End 左侧导航-->

        <!--头部信息-->
        <header class="lyear-layout-header">

            <nav class="navbar navbar-default">
                <div class="topbar">

                    <div class="topbar-left">
                        <div class="lyear-aside-toggler">
                            <span class="lyear-toggler-bar"></span>
                            <span class="lyear-toggler-bar"></span>
                            <span class="lyear-toggler-bar"></span>
                        </div>
                        <span class="navbar-page-title"> ${op} </span>
                    </div>

                    <jsp:include page="../topRight.jsp"/>

                </div>
            </nav>

        </header>
        <!--End 头部信息-->

        <!--页面主要内容-->
        <main class="lyear-layout-content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">

                                <form action="/admin/user/saveOrUpdate" method="post" class="row">
                                    <input type="hidden" value="${user.id}" name="id" id="id">
                                    <div class="form-group col-md-6">
                                        <label for="account">账号</label>
                                        <input type="text" class="form-control" id="account" name="account" value="${user.account}" placeholder="账号" />
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="password">密码</label>
                                        <input type="text" class="form-control" id="password" name="password" value="${user.password}" placeholder="密码" />
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="name">用户名</label>
                                        <input type="text" class="form-control" id="name" name="name" value="${user.name}" placeholder="用户名" />
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="sex">类别</label>
                                        <label class="lyear-radio radio-inline radio-primary">
                                            <input type="radio" id="sex" name="sex" <c:if test="${user.sex== '男' }">checked="checked"</c:if> value="男"><span>男</span>
                                        </label>
                                        <label class="lyear-radio radio-inline radio-primary">
                                            <input type="radio" name="sex" <c:if test="${user.sex== '女' }">checked="checked"</c:if> value="女"><span>女</span>
                                        </label>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="tel">联系电话</label>
                                        <input type="text" class="form-control" id="tel" name="tel" value="${user.tel}" placeholder="联系电话" />
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="address">地址</label>
                                        <input type="text" class="form-control" id="address" name="address" value="${user.address}" placeholder="地址" />
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="remo">介绍</label>
                                        <textarea class="form-control" id="remo" name="remo" rows="10" placeholder="介绍">${user.remo}</textarea>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="passques">密保问题</label>
                                        <input type="text" class="form-control" id="passques" name="passques" value="${user.passques}" placeholder="密保问题" />
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="passans">密保答案</label>
                                        <input type="text" class="form-control" id="passans" name="passans" value="${user.passans}" placeholder="密保答案" />
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="avatar">头像</label>
                                        <input type="text" class="form-control" id="avatar" name="avatar" value="${user.avatar}" placeholder="头像" />
                                    </div>
                                    <div class="form-group col-md-12">
                                        <button type="submit" class="btn btn-primary ajax-post" target-form="add-form">确 定</button>
                                        <button type="button" class="btn btn-default" onclick="javascript:history.back(-1);return false;">返 回</button>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </main>
        <!--End 页面主要内容-->
    </div>
</div>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="/js/main.min.js"></script>
<script src="/js/jconfirm/jquery-confirm.min.js"></script>
<script type="text/javascript">
</script>
</body>
</html>