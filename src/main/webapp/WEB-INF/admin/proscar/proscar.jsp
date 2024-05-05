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
                        <span class="navbar-page-title"> 购物车 </span>
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

                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>商品图片</th>
                                            <th>商品名称</th>
                                            <th>卖家用户名</th>
                                            <th>数量</th>
                                            <th>单价</th>
                                            <th>总价</th>
                                            <th>操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${list}">
                                            <tr>
                                                <td><img src="${item.goods.filename}" width="120px"/></td>
                                                <td>${item.goods.name}</td>
                                                <td>${item.goods.user.name}</td>
                                                <td>${item.num}</td>
                                                <td>${item.goods.price}</td>
                                                <td>${item.goods.price * item.num}</td>
                                                <td>
                                                    <div class="btn-group">
                                                        <a class="btn btn-xs btn-default"
                                                           href="javascript:void(0);"
                                                           onclick="numeric(${item.id})" title="修改数量"
                                                           data-toggle="tooltip"><i class="mdi mdi-numeric"></i></a>
                                                        <a class="btn btn-xs btn-default"
                                                           href="javascript:void(0);"
                                                           onclick="diamond(${item.id})" title="购买"
                                                           data-toggle="tooltip"><i class="mdi mdi-diamond"></i></a>

                                                        <a class="btn btn-xs btn-default" href="javascript:void(0);"
                                                           onclick="del(${item.id})" title="删除"
                                                           data-toggle="tooltip"><i
                                                                class="mdi mdi-window-close"></i></a>
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
     * 购买
     * @param id
     */
    function diamond(id) {
        $.confirm({
            title: '提示',
            content: '' +
                '<form action="" class="formName">' +
                '<div class="form-group">' +
                '<label>地址</label>' +
                '<select name="address" class="address">' +
                '<c:forEach var="item" items="${receiveInfos}"> <option value="${item.id}">${item.address}</option> </c:forEach>'+
                '</select>' +
                '<div class="row">' +
                '<div class="form-group col-md-4"><input type="radio" value="微信" name="paytype" checked class="sshscore form-control" required />微信</div>' +
                '<div class="form-group col-md-4"><input type="radio" value="支付宝" name="paytype" class="sshscore form-control" required />支付宝</div>' +
                '<div class="form-group col-md-4"><input type="radio" value="银行卡" name="paytype" class="sshscore form-control" required />银行卡</div>' +
                '</div>' +
                '</div>' +
                '</form>',
            buttons: {
                formSubmit: {
                    text: '提交',
                    btnClass: 'btn-blue',
                    action: function () {
                        var addressId = this.$content.find('.address').val();
                        var paytype =  this.$content.find("input[name='paytype'][type='radio']:checked").val();
                        if(!addressId){
                            $.alert('请选择地址');
                            return false;
                        }

                        $.ajax({
                            type:"POST",
                            url:"/admin/proscar/diamond",
                            data:{
                                "id": id,
                                "addressId": addressId,
                                "paytype": paytype
                            },
                            async:false,
                            dataType:"json",
                            success:function(data){
                                if (data.success) {
                                    $.confirm({
                                        title: '成功',
                                        content: data.message,
                                        type: 'green',
                                        buttons: {
                                            close: {
                                                text: '关闭',
                                            }
                                        }
                                    });
                                    window.location.href = "/admin/proscar/proscar";
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
                },
                cancel: {
                    text: '取消'
                },
            },
            onContentReady: function () {
                var jc = this;
                this.$content.find('form').on('submit', function (e) {
                    e.preventDefault();
                    jc.$$formSubmit.trigger('click');
                });
            }
        });
    }

    function numeric(id) {
        $.confirm({
            title: '提示',
            content: '' +
                '<form action="" class="formName">' +
                '<div class="form-group">' +
                '<label>请填写数量</label>' +
                '<input type="number" name="number" class="number form-control" required />' +
                '</div>' +
                '</form>',
            buttons: {
                formSubmit: {
                    text: '提交',
                    btnClass: 'btn-blue',
                    action: function () {
                        var number = this.$content.find('.number').val();
                        if(!number){
                            $.alert('请您录入数量');
                            return false;
                        }

                        $.ajax({
                            type:"POST",
                            url:"/admin/proscar/numeric",
                            data:{
                                "id": id,
                                "num": number
                            },
                            async:false,
                            dataType:"json",
                            success:function(data){
                                if (data.success) {
                                    $.confirm({
                                        title: '成功',
                                        content: data.message,
                                        type: 'green',
                                        buttons: {
                                            close: {
                                                text: '关闭',
                                            }
                                        }
                                    });
                                    window.location.href = "/admin/proscar/proscar";
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
                },
                cancel: {
                    text: '取消'
                },
            },
            onContentReady: function () {
                var jc = this;
                this.$content.find('form').on('submit', function (e) {
                    e.preventDefault();
                    jc.$$formSubmit.trigger('click');
                });
            }
        });
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
                        window.location.href = "/admin/proscar/delete/" + id;
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
</script>
</body>
</html>