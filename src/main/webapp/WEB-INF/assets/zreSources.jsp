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
            <c:forEach var="zre" items="${zreSources}">
              <div class="col-xxl-3 col-lg-3 col-md-4 col-sm-6 col-6">
                <div class="product-item furniture__product">
                  <div class="product-thumb theme-bg-2">
                    <a href="/assets/zreSourcesDetails/${zre.id}"><img src="${zre.filename}" alt=""></a>
                  </div>
                  <div class="product-content">
                    <h4 class="product-title"><a href="/assets/zreSourcesDetails/${zre.id}">${zre.title}</a>
                    </h4>
                    <div class="user-rating mb-1">
                      <i class="far fa-star"></i>
                      <i class="far fa-star"></i>
                      <i class="far fa-star"></i>
                      <i class="far fa-star"></i>
                      <i class="far fa-star"></i>
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

</body>

</html>