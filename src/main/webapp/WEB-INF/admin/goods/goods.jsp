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
                        <span class="navbar-page-title"> 商品管理 </span>
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
                                <form class="pull-right search-bar" method="get" action="/admin/goods/goods" role="form">
                                    <div class="input-group">
                                        <div class="input-group-btn">
                                            <input type="hidden" name="search_field" id="search-field" value="title">
                                            <button class="btn btn-default dropdown-toggle" id="search-btn"
                                                    data-toggle="dropdown" type="button" aria-haspopup="true"
                                                    aria-expanded="false">
                                                商品名称 <span class="caret"></span>
                                            </button>
                                        </div>
                                        <input type="text" class="form-control" value="" name="name" onchange="search()"
                                               placeholder="请输入名称">
                                    </div>
                                </form>
                                <div class="toolbar-btn-action">
                                    <a class="btn btn-danger" href="javascript:void(0);" onclick="deleteBatch()"><i class="mdi mdi-window-close"></i> 删除</a>
                                </div>
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
                                            <th>发布人</th>
                                            <th>商品编号</th>
                                            <th>商品名称</th>
                                            <th>大类</th>
                                            <th>单价</th>
                                            <th>上架状态</th>
                                            <th>评分</th>
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
                                                <td>${item.user.id} [${item.user.name}]</td>
                                                <td>${item.no}</td>
                                                <td>${item.name}</td>
                                                <td>${item.category.name}</td>
                                                <td>36</td>
                                                <td><font class="text-success">正常</font></td>
                                                <td><font class="text-success">正常</font></td>
                                                <td>
                                                    <div class="btn-group">
                                                        <a class="btn btn-xs btn-default" href="/admin/goods/details/${item.id}" title="查看"
                                                           data-toggle="tooltip"><i class="mdi mdi-eye"></i></a>
                                                        <a class="btn btn-xs btn-default" href="javascript:void(0);"
                                                           onclick="del(${item.id})" title="删除"
                                                           data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
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

    /**
     * 查询
     */
    function search() {
        $("#search-form").submit()
    }


    /**
     * 批量删除
     */
    function deleteBatch() {
        var checkboxValues = $("input[type='checkbox'][name='ids']:checked").map(function () {
            return $(this).val();
        }).get();
        if (checkboxValues.length > 0) {

            $.alert({
                title: '删除',
                content: "确定要这删除这" + checkboxValues.length + "条数据吗吗？",
                buttons: {
                    confirm: {
                        text: '确认',
                        btnClass: 'btn-primary',
                        action: function () {
                            $.ajax({
                                type: "POST",
                                url: "/admin/goods/deleteBatch",
                                data: {
                                    "ids": checkboxValues
                                },
                                async: false,
                                dataType: "json",
                                success: function (data) {
                                    if (data.success) {
                                        $.alert({
                                            title: '信息',
                                            content: data.message,
                                            buttons: {
                                                confirm: {
                                                    text: '确认',
                                                    btnClass: 'btn-primary',
                                                    action: function () {
                                                        window.location.href = "/admin/goods/goods";
                                                    }
                                                }
                                            }
                                        });

                                    }
                                },
                                error: function (e) {
                                    console.log(e)
                                }
                            });
                        }
                    },
                    cancel: {
                        text: '取消',
                        action: function () {

                        }
                    }
                }
            });

        }
    }

    function del(id) {
        $.alert({
            title: '删除',
            content: '确定要删除吗？',
            buttons: {
                confirm: {
                    text: '确认',
                    btnClass: 'btn-primary',
                    action: function () {
                        window.location.href = "/admin/goods/delete/" + id;
                    }
                },
                cancel: {
                    text: '取消'
                }
            }
        });
    }
</script>
</body>
</html>