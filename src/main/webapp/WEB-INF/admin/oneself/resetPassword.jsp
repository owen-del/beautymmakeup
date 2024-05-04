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

                <form action="/admin/user/resetPassword" method="post" id="reset-password-form" class="row">
                  <input type="hidden" value="${user.id}" name="id" id="id">
                  <div class="form-group col-md-12">
                    <label for="password">请输入新密码</label>
                    <input type="text" class="form-control" id="password" name="password" value="" placeholder="请输入新密码" />
                  </div>
                  <div class="form-group col-md-12">
                    <label for="repassword">请再次输入新密码</label>
                    <input type="text" class="form-control" id="repassword" name="repassword" value="" placeholder="请再次输入新密码" />
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
  $("#reset-password-form").submit(function (){
    var password = $("#password").val();
    var repassword = $("#repassword").val();
    if (password == "" || repassword == "" || password == undefined || repassword == undefined) {
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
      return false;
    }else if (password !== repassword) {
      $.confirm({
        title: '警告',
        content: '两次密码输入不一致。',
        type: 'orange',
        typeAnimated: false,
        buttons: {
          close: {
            text: '关闭',
          }
        }
      });
      return false;
    }
    $.ajax({
      type:"POST",
      url:"/admin/user/resetPassword",
      data:{
        "password": password,
        "repassword": repassword,
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
              },
              action: function (){
                window.location.href = "/admin/index";
              }
            }
          });

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
    return false;
  });
</script>
</body>
</html>