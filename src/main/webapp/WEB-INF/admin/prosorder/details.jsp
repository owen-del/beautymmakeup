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
                                    <label for="orderno">订单号</label>
                                    <input type="text" class="form-control" id="orderno" name="orderno" value="${prosorder.orderno}" placeholder="订单号" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="shopuname">卖方用户名</label>
                                    <input type="text" class="form-control" id="shopuname" name="shopuname" value="${prosorder.shopuname}" placeholder="卖方用户名" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="uname">买方用户名</label>
                                    <input type="text" class="form-control" id="uname" name="uname" value="${prosorder.uname}" placeholder="买方用户名" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="gno">商品编号</label>
                                    <input type="text" class="form-control" id="gno" name="uname" value="${prosorder.gno}" placeholder="商品编号" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="fgname">商品名称</label>
                                    <input type="text" class="form-control" id="fgname" name="fgname" value="${prosorder.gno}" placeholder="商品名称" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="cprice">成交单价</label>
                                    <input type="text" class="form-control" id="cprice" name="cprice" value="${prosorder.cprice}" placeholder="成交单价" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="snum">数量</label>
                                    <input type="text" class="form-control" id="snum" name="snum" value="${prosorder.snum}" placeholder="数量" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="totalamt">应付金额</label>
                                    <input type="text" class="form-control" id="totalamt" name="totalamt" value="${prosorder.totalamt}" placeholder="应付金额" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="fshstatus">订单状态</label>
                                    <input type="text" class="form-control" id="fshstatus" name="fshstatus" value="${prosorder.fshstatus}" placeholder="订单状态" />
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="savetime">申请时间</label>
                                    <input type="text" class="form-control" id="savetime" name="savetime" value="${prosorder.savetime}" placeholder="申请时间" />
                                </div>
                                <div class="form-group col-md-6">
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