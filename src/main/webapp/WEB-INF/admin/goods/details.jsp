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
        <jsp:include page="../LeftMenu.jsp"/>
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
                                <div class="form-group col-md-6">
                                    <label for="user.name">发布人</label>
                                    <input type="text" class="form-control" id="user.name" name="user.name" value="${goods.user.name}" placeholder="发布人" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="no">商品编号</label>
                                    <input type="text" class="form-control" id="no" name="no" value="${goods.no}" placeholder="商品编号" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="name">商品名称</label>
                                    <input type="text" class="form-control" id="name" name="name" value="${goods.name}" placeholder="商品名称" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="category.name">大类</label>
                                    <input type="text" class="form-control" id="category.name" name="category.name" value="${goods.category.name}" placeholder="大类" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="price">单价</label>
                                    <input type="text" class="form-control" id="price" name="price" value="${goods.price}" placeholder="单价" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="status">上架状态</label>
                                    <input type="text" class="form-control" id="status" name="status" value="${goods.status}" placeholder="上架状态" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="stars">评分</label>
                                    <input type="text" class="form-control" id="stars" name="stars" value="${goods.stars}" placeholder="评分" />
                                </div>
                                <div class="form-group col-md-12">
                                    <button type="button" class="btn btn-default" onclick="javascript:history.back(-1);return false;">返 回</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </main>
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