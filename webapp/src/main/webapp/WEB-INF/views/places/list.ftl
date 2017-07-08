<!DOCTYPE html>
<html lang="en">
<head>

    <!-- SITE TITTLE -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Category list 2 - Listty</title>

<#include "../common/styles.ftl">

</head>

<body class="body-wrapper">
<div class="page-loader" style="background: url(/img/preloader.gif) center no-repeat #fff;"></div>
<div class="main-wrapper">
    <!-- HEADER -->

    <#include "../common/header.ftl">

    <!-- PAGE TITLE SECTION -->
    <section class="clearfix pageTitleSection" style="background-image: url();">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="pageTitle">
                        <h2>Casinos in ${city}</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- BREADCRUMBS-->

    <div class="container breadcrumb-container">
        <div class="row">
            <div class="col-xs-12">
                <#list breadcrumbs as crumb>
                    <a href="#" class="btn-link breadcrumb">${crumb}</a> /
                </#list>
            </div>
        </div>
    </div>


    <!-- CATEGORY LIST SECTION -->
    <section class="clerfix">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-xs-12">
                    <div class="resultBar barSpaceAdjust">
                        <h2>We found <span>8</span> Results for you</h2>

                    </div>

                <#list places as place>
                    <div class="listContent">
                        <div class="row">
                            <div class="col-sm-5 col-xs-12">
                                <div class="categoryImage">
                                    <img src="/img/things/things-1.jpg" alt="Image category"
                                         class="img-responsive img-rounded">
                                    <!--<span class="label label-primary">Verified</span>-->
                                </div>
                            </div>
                            <div class="col-sm-7 col-xs-12">
                                <div class="categoryDetails">
                                    <ul class="list-inline rating">
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    </ul>
                                    <h2><a href="/${country}/${city}/${place.id}/" style="color: #222222">${place.name}</a></h2>
                                    <p>${place.address} <span class="placeName">${place.city}</span></p>

                                </div>
                            </div>
                        </div>
                    </div>
                </#list>


                </div>

            </div>
            <div class="row">
                <div class="col-sm-4"></div>
                <div class="col-sm-6">
                    <div class="paginationCommon blogPagination categoryPagination">
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <li>
                                    <a href="#" aria-label="Previous">
                                        <span aria-hidden="true"><i class="fa fa-angle-left" aria-hidden="true"></i></span>
                                    </a>
                                </li>
                                <li class="active"><a href="#">1</a></li>
                                <li><a href="#">2</a></li>
                                <li><a href="#">3</a></li>
                                <li><a href="#">4</a></li>
                                <li><a href="#">5</a></li>
                                <li>
                                    <a href="#" aria-label="Next">
                                        <span aria-hidden="true"><i class="fa fa-angle-right" aria-hidden="true"></i></span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <!-- FOOTER -->
    <#include "../common/footer.ftl">
</div>


<!-- JAVASCRIPTS -->
<script src="/plugins/jquery/jquery.min.js"></script>
<script src="/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="/plugins/smoothscroll/SmoothScroll.min.js"></script>
<script src="/plugins/waypoints/waypoints.min.js"></script>
<script src="/plugins/counter-up/jquery.counterup.min.js"></script>
<script src="/plugins/datepicker/bootstrap-datepicker.min.js"></script>
<script src="/plugins/selectbox/jquery.selectbox-0.1.3.min.js"></script>
<script src="/plugins/owl-carousel/owl.carousel.min.js"></script>
<script src="/plugins/isotope/isotope.min.js"></script>
<script src="/plugins/fancybox/jquery.fancybox.pack.js"></script>
<script src="/plugins/isotope/isotope-triger.min.js"></script>
<script src="/plugins/map/js/rich-marker.js"></script>
<script src="/plugins/map/js/infobox_packed.js"></script>
<script src="/js/single-map.js"></script>
<script src="/js/map.js"></script>
<script src="/js/custom.js"></script>


<#--<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBUesV2KgJPKO1vWczzp3uglksfrRLXNds"></script>-->

</body>

</html>

