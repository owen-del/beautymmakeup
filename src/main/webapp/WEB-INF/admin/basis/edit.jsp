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

                <form action="/admin/mixInfo/basis/saveOrUpdate" method="post" class="row">
                  <input type="hidden" value="${mixInfo.id}" name="id" id="id">
                  <input type="hidden" value="${mixInfo.infoType}" name="infoType" id="infoType">
                  <input type="hidden" value="${mixInfo.cotitle}" name="cotitle" id="cotitle">
                  <input type="hidden" value="${mixInfo.remo}" name="remo" id="remo">
                  <input type="hidden" value="${mixInfo.filename}" name="filename" id="filename">
                  <div class="form-group col-md-12">
                    <label for="title">标题</label>
                    <input type="text" class="form-control" id="title" name="title" value="${mixInfo.title}" placeholder="标题" />
                  </div>
                  <div class="form-group col-md-12">
                    <label for="content">内容</label>
                    <textarea class="form-control" id="content" name="content" rows="10" placeholder="内容">${mixInfo.content}</textarea>
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