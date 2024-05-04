<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="lyear-layout-sidebar">

  <!-- logo -->
  <div id="logo" class="sidebar-header">
    <a href="/admin/index">美妆二手交易系统</a>
  </div>
  <div class="lyear-layout-sidebar-scroll">

    <nav class="sidebar-main">
      <ul class="nav nav-drawer">
        <li class="nav-item active"> <a href="/admin/index"><i class="mdi mdi-home"></i> 后台首页</a> </li>
        <li class="nav-item nav-item-has-subnav">
          <a href="javascript:void(0)"><i class="mdi mdi-palette"></i>管理员菜单</a>
          <ul class="nav nav-subnav">
            <li> <a href="/admin/goods/goods">商品管理</a> </li>
            <li> <a href="/admin/category/category">商品类别管理</a> </li>
            <li><a href="/admin/prosorder/prosorder">交易明细管理</a></li>
          </ul>
        </li>
        <li class="nav-item nav-item-has-subnav">
          <a href="javascript:void(0)"><i class="mdi mdi-format-align-justify"></i> 网站信息</a>
          <ul class="nav nav-subnav">
            <li> <a href="/admin/zreSources/zreSources">站内咨询管理</a> </li>
            <li> <a href="/admin/ZrType/ZrType">信息类别管理</a> </li>
            <li> <a href="/admin/messages/messages">留言板</a> </li>
            <li> <a href="/admin/mixInfo/rollingImg">滚动图片</a> </li>
            <li> <a href="/admin/friendshipLink/friendshipLink">友情链接</a> </li>
            <li> <a href="lyear_forms_switch.html">网站基础信息</a> </li>
          </ul>
        </li>
        <li class="nav-item nav-item-has-subnav">
          <a href="javascript:void(0)"><i class="mdi mdi-file-outline"></i> 系统用户管理</a>
          <ul class="nav nav-subnav">
            <li> <a href="lyear_pages_doc.html">管理员</a> </li>
            <li> <a href="lyear_pages_gallery.html">用户</a> </li>
          </ul>
        </li>
        <li class="nav-item nav-item-has-subnav">
          <a href="javascript:void(0)"><i class="mdi mdi-language-javascript"></i> 个人信息管理</a>
          <ul class="nav nav-subnav">
            <li> <a href="lyear_js_datepicker.html">修改个人资料</a> </li>
            <li> <a href="lyear_js_sliders.html">修改登录密码</a> </li>
          </ul>
        </li>
      </ul>
    </nav>


  </div>

</aside>