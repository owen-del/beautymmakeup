<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="zxx">
<jsp:include page="public/head.jsp"/>
<body>
<!-- Header area start -->
<jsp:include page="public/header.jsp"/>
<main>

    <!-- Breadcrumb area start  -->
    <div class="breadcrumb__area theme-bg-1 p-relative z-index-11 pt-95 pb-95">
        <div class="breadcrumb__thumb" data-background="/assets/imgs/bg/breadcrumb-bg.jpg"></div>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-xxl-12">
                    <div class="breadcrumb__wrapper text-center">

                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb area start  -->

    <!-- Portfolio area start -->
    <section class="pt-120 pb-120">
        <div class="container">

            <div class="col-xxl-12">
                <div class="breadcrumb__wrapper text-center">
                    <ul>
                        <c:forEach items="${messages}" var="message">
                            <li>
                                <p>
                                    <img src="${message.user.avatar}"/>
                                    <label>${message.createTime}<br>${message.cont}
                                        <br>管理员回复：${message.recont}</label>
                                </p>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
        </div>
        <form method="post" action="/assets/saveMessave">
            <textarea class="form-control" id="cont" name="cont" rows="6" placeholder="留言内容"></textarea>
            <button type="submit" class="btn btn-primary ajax-post" target-form="add-form">确 定</button>
        </form>
    </section>

</main>
<!-- Body main wrapper end -->
<jsp:include page="public/footer.jsp"/>

<!-- JS here -->

<jsp:include page="public/jsHere.jsp"/>

</script>
</body>

</html>