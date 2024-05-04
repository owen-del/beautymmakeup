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

                                <form action="/admin/goods/saveOrUpdate" method="post" class="row">
                                    <input type="hidden" class="form-control" id="id" name="id" value="${goods.id}" placeholder="id" />
                                <div class="form-group col-md-6">
                                    <label for="no">商品编号</label>
                                    <input type="text" class="form-control" id="no" name="no" value="${goods.no}" placeholder="商品编号" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="name">商品名称</label>
                                    <input type="text" class="form-control" id="name" name="name" value="${goods.name}" placeholder="商品名称" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="categoryId">大类</label>
                                    <select name="categoryId" id="categoryId">
                                        <c:forEach var="item" items="${categories}">
                                            <option <c:if test="${item.id == goods.category.id }">selected="selected"</c:if> value="${item.id}" >${item.name}</option>
                                        </c:forEach>
                                    </select>
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
                                    <div class="form-group col-md-6">
                                        <label for="remo">简介</label>
                                        <textarea class="form-control" id="remo" name="remo" rows="6" placeholder="简介">${goods.remo}</textarea>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="clicknums">点击量</label>
                                        <input type="text" class="form-control" id="clicknums" name="clicknums" value="${goods.clicknums}" placeholder="点击量" />
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="praisenums">点赞量</label>
                                        <input type="text" class="form-control" id="praisenums" name="praisenums" value="${goods.praisenums}" placeholder="点赞量" />
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="filename">图片</label>
                                        <input type="text" class="form-control" id="filename" name="filename" value="${goods.filename}" placeholder="图片" />
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