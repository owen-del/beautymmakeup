<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <div class="header">
        <div class="header-top-area grocery__top-header">
            <div class="header-layout-4">
                <div class="header-to-main d-none d-sm-flex">
                    <div class="link-text">
                        <span><img src="/assets/imgs/icons/call.png" alt=""></span>
                        <a href="tel:+0123456789">+0123456789</a>
                    </div>
                    <div class="header-top-notice d-none d-lg-block">
                        <p>美妆二手交易系统</p>
                    </div>
                    <div class="tp-header-top-menu d-flex align-items-center justify-content-end">

                        <div class="header-lang-item tp-header-setting">
                            <span class="header-setting-toggle text-white"
                                  id="header-setting-toggle">${sessionScope.loginUser.name}</span>
                            <ul>
                                <li>
                                    <a class="furniture-clr-hover" href="#">去后台</a>
                                </li>
                                <li>
                                    <a class="furniture-clr-hover" href="wishlist.html">退出</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="header-layout-4 header-bottom">
            <div id="header-sticky" class="header-4">
                <div class="mega-menu-wrapper">
                    <div class="header-main-4">
                        <div class="header-left">
                            <div class="header-logo">
                                <a href="/assets/index">
                                    <img src="/assets/imgs/furniture/logo/logo.svg" alt="logo not found">
                                </a>
                            </div>
                            <div class="mean__menu-wrapper furniture__menu d-none d-lg-block">
                                <div class="main-menu">
                                    <nav id="mobile-menu">
                                        <ul>
                                            <li>
                                                <a href="/assets/index">首页</a>
                                            </li>
                                            <li class="has-dropdown">
                                                <a href="/assets/shopping">购物页面</a>
                                            </li>
                                            <li class="has-dropdown">
                                                <a href="/assets/zreSources">站内咨询</a>
                                            </li>
                                            <li class="has-dropdown">
                                                <a href="/assets/brief">网站简介</a>
                                            </li>
                                            <li class="has-dropdown">
                                                <a href="/assets/contact">联系我们</a>
                                            </li>
                                            <li class="has-dropdown">
                                                <a href="/assets/message">留言板</a>
                                            </li>
                                            <li class="has-dropdown">
                                                <a href="/admin/index">后台</a>
                                            </li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                        <div class="header-right d-inline-flex align-items-center justify-content-end">
                            <div class="header-search d-none d-xxl-block">
                                <form action="#">
                                    <input type="text" placeholder="Search...">
                                    <button type="submit">
                                        <svg width="18" height="18" viewBox="0 0 18 18" fill="none"
                                             xmlns="http://www.w3.org/2000/svg">
                                            <path d="M13.4443 13.4445L16.9999 17" stroke="white" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                                            <path d="M15.2222 8.11111C15.2222 12.0385 12.0385 15.2222 8.11111 15.2222C4.18375 15.2222 1 12.0385 1 8.11111C1 4.18375 4.18375 1 8.11111 1C12.0385 1 15.2222 4.18375 15.2222 8.11111Z" stroke="white" stroke-width="2"/>
                                        </svg>
                                    </button>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    </div>
</header>