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
                        <span class="navbar-page-title"> 交易明细管理 </span>
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
                            <div class="card-toolbar clearfix">
                                <form class="pull-right search-bar" method="get" action="/admin/prosorder/sellAcceptance" id="search-form" role="form">
                                    <div class="input-group">
                                        <div class="input-group-btn">
                                            <button class="btn btn-default dropdown-toggle" id="search-btn"
                                                    data-toggle="dropdown" type="button" aria-haspopup="true"
                                                    aria-expanded="false">
                                                订单号 <span class="caret"></span>
                                            </button>
                                        </div>
                                        <input type="text" class="form-control" value="" name="orderno" onchange="search()"
                                               placeholder="请输入名称">
                                    </div>
                                </form>
                            </div>
                            <div class="card-body">

                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>
                                                <label class="lyear-checkbox checkbox-primary">
                                                    <input type="checkbox" id="check-all"><span></span>
                                                </label>
                                            </th>
                                            <th>订单号</th>
                                            <th>卖方用户名</th>
                                            <th>买家用户名</th>
                                            <th>商品编号</th>
                                            <th>商品名称</th>
                                            <th>成交单价</th>
                                            <th>数量</th>
                                            <th>应付金额</th>
                                            <th>订单状态</th>
                                            <th>申请时间</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${list}">
                                            <tr>
                                                <td>
                                                    <label class="lyear-checkbox checkbox-primary">
                                                        <input type="checkbox" name="ids"
                                                               value="${item.id}"><span></span>
                                                    </label>
                                                </td>
                                                <td>${item.orderno}</td>
                                                <td>${item.shopuname}</td>
                                                <td>${item.uname}</td>
                                                <td>${item.gno}</td>
                                                <td>${item.fgname}</td>
                                                <td>${item.cprice}</td>
                                                <td>${item.snum}</td>
                                                <td>${item.totalamt}</td>
                                                <td>${item.fshstatus}</td>
                                                <td>${item.savetime}</td>
                                                <td>
                                                    <div class="btn-group">
                                                        <a class="btn btn-xs btn-default" href="/admin/prosorder/sellCancel/${item.id}"  title="取消订单" data-toggle="tooltip"><i class="mdi mdi-cancel"></i></a>
                                                        <a class="btn btn-xs btn-default" href="/admin/prosorder/sellAcceptanceDetails/${item.id}" title="查看" data-toggle="tooltip"><i class="mdi mdi-eye"></i></a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

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

    function search() {
        $("#search-form").submit()
    }


</script>
</body>
</html>