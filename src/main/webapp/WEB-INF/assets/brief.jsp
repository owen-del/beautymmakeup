<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <h2 class="breadcrumb__title">${mixInfo.title}</h2>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Breadcrumb area start  -->

  <!-- Portfolio area start -->
  <section class="pt-120 pb-120">
    <div class="container">
      <h3 class="mb-30">${mixInfo.title}</h3>
      <p>${mixInfo.content}</p>


    </div>
  </section>

</main>
<!-- Body main wrapper end -->
<jsp:include page="public/footer.jsp"/>

<!-- JS here -->

<jsp:include page="public/jsHere.jsp"/>

</script>
</body>

</html>