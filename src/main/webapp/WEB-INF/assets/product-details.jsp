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
                        <h2 class="breadcrumb__title">${goods.name}</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb area start  -->

    <!-- Portfolio area start -->
    <section class="pt-120 pb-120">
        <div class="container">
            <h3 class="mb-30">${goods.name}</h3>
            <p>${goods.remo}</p>

            <img class="w-100" src="${goods.filename}" alt="image">

            <h3 class="mb-30">RMD ${goods.price}</h3>

            <a href="javascript:void(0);" onclick="addCat(${goods.id})">加入购物车</a>

        </div>
    </section>

</main>
<!-- Body main wrapper end -->
<jsp:include page="public/footer.jsp"/>

<!-- JS here -->

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