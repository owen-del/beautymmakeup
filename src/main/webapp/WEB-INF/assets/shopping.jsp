<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html class="no-js" lang="zxx">
<jsp:include page="public/head.jsp"/>
<body>
<jsp:include page="public/header.jsp"/>

    <!-- Trendy collection area start -->
    <section class="fruniture-trendy section-space">
        <div class="container">
            <div class="furniture-trendy__header">
                <div class="section-title-wrapper-4 mb-40">
                    <span class="section-subtitle-4 mb-10">THIS MONTH</span>
                    <h2 class="section-title-4">时尚系列</h2>
                </div>
                <div class="bd-product__filter-style furniture-trendy__tab nav nav-tabs" role="tablist">
                    <button class="nav-link active" id="collection-tab" data-bs-toggle="tab" data-bs-target="#collection"
                            type="button" role="tab" aria-selected="false">All Collection</button>

                </div>
            </div>
            <div class="product__filter-tab">
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade active show" id="collection" role="tabpanel" aria-labelledby="collection-tab">
                        <div class="row g-4">
                            <c:forEach var="good" items="${goods}">
                            <div class="col-xxl-3 col-lg-3 col-md-4 col-sm-6 col-6">
                                <div class="product-item furniture__product">
                                    <div class="product-thumb theme-bg-2">
                                        <a href="/assets/goodsDetails/${good.id}"><img src="${good.filename}" alt=""></a>
                                        <div class="product-action-item">
                                            <button type="button" onclick="addCat(${good.id})" class="product-action-btn">
                                                <svg width="20" height="22" viewBox="0 0 20 22" fill="none"
                                                     xmlns="http://www.w3.org/2000/svg">
                                                    <path d="M13.0768 10.1416C13.0768 11.9228 11.648 13.3666 9.88542 13.3666C8.1228 13.3666 6.69401 11.9228 6.69401 10.1416M1.375 5.84163H18.3958M1.375 5.84163V12.2916C1.375 19.1359 2.57494 20.3541 9.88542 20.3541C17.1959 20.3541 18.3958 19.1359 18.3958 12.2916V5.84163M1.375 5.84163L2.91454 2.73011C3.27495 2.00173 4.01165 1.54163 4.81754 1.54163H14.9533C15.7592 1.54163 16.4959 2.00173 16.8563 2.73011L18.3958 5.84163" stroke="white" stroke-width="2" stroke-linecap="round" troke-linejoin="round"/>
                                                </svg>
                                                <span class="product-tooltip">添加购物车</span>
                                            </button>
                                        </div>
                                    </div>
                                    <div class="product-content">
                                        <h4 class="product-title"><a href="/assets/goodsDetails/${good.id}">${good.name}</a>
                                        </h4>
                                        <div class="user-rating mb-1">
                                            <i class="far fa-star"></i>
                                            <i class="far fa-star"></i>
                                            <i class="far fa-star"></i>
                                            <i class="far fa-star"></i>
                                            <i class="far fa-star"></i>
                                        </div>
                                        <div class="product-price">
                                            <span class="product-new-price">RMB ${good.price}</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </section>


    <jsp:include page="public/footer.jsp"/>


    <jsp:include page="public/jsHere.jsp"/>

    <script>
        function addCat(id) {
            $.ajax({
                type:"POST",
                url:"/assets/addCat/"+id,
                async:false,
                dataType:"json",
                success:function(data){
                    if (data.success) {
                        $.alert("添加成功")
                    }else {
                        $.alert("添加失败")
                    }
                },
                error:function(w, e, q){
                    console.log(q)
                }
            });
        }
    </script>
</body>

</html>