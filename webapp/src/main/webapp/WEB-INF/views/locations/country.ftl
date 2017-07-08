<!DOCTYPE html>
<html lang="en">
<head>

    <!-- SITE TITTLE -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>All business - Listty</title>

    <#include "../common/styles.ftl">

</head>

<body class="body-wrapper">
<div class="page-loader" style="background: url(img/preloader.gif) center no-repeat #fff;"></div>
<div class="main-wrapper">

    <!-- HEADER -->
    <#include "../common/header.ftl">


    <!-- PAGE TITLE SECTION -->
    <section class="clearfix pageTitleSection" style="background-image: url();">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="pageTitle">
                        <h2>Cities in ${country}</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- ALL BUSINESS -->
    <section class="clearfix allBusiness">
        <div class="container">
            <div class="row">
                <div class="col-sm-2">
                </div>
                <div class="col-sm-10">
                    <div class="businessLink">

                        <ul class="list-inline">
                            <#list cities as city>
                                <li><a href="/${country}/${city}/">${city}</a></li>
                            </#list>
                        </ul>
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
<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBEDfNcQRmKQEyulDN8nGWjLYPm8s4YB58"></script> -->
<script src="/plugins/map/js/rich-marker.js"></script>
<script src="/plugins/map/js/infobox_packed.js"></script>
<script src="/js/single-map.js"></script>
<script src="/js/map.js"></script>
<script src="/js/custom.js"></script>

</body>

</html>
