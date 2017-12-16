<!DOCTYPE html>
<html lang="en">
<head>

<!-- SITE TITTLE -->

<#include "../common/meta.ftl">
<title>${place.name} - Stores List</title>

<#include "../common/styles.ftl">

</head>

<body class="body-wrapper">
<div class="page-loader" style="background: url(/img/preloader.gif) center no-repeat #fff;"></div>
<div class="main-wrapper">

    <!-- HEADER -->
    <#include "../common/header.ftl">


    <!-- BREADCRUMBS-->
    <#include "../common/breadcrumbs.ftl">

    <!-- LISTINGS DETAILS TITLE SECTION -->
    <section class="clearfix paddingAdjustBottom">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="listingTitleArea">
                        <h2>${place.name}</h2>
                        <p>${place.address}</p>
                        <div class="listingReview">
                            <ul class="list-inline rating">
                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                            </ul>
                            <span>( ${place.reviews?size} Reviews )</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>




    <!-- LISTINGS DETAILS INFO SECTION -->
    <section class="clearfix paddingAdjustTop">
        <div class="container">
            <div class="row">
                <div class="col-sm-4 col-xs-12">
                    <div class="clearfix map-sidebar map-right">
                        <div id="map"
                             lat="${place.location.lat?string["0.######"]}"
                             lng="${place.location.lng?string["0.######"]}"
                             style="position:relative; margin: 0;padding: 0;height: 538px; max-width: none;"></div>
                    </div>
                    <div class="listSidebar">
                        <h3>Location</h3>
                        <div class="contactInfo">
                            <ul class="list-unstyled list-address">
                                <li>
                                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                                    ${place.address}
                                </li>
                                <li>
                                    <i class="fa fa-phone" aria-hidden="true"></i>
                                    ${place.phoneNumber}
                                </li>
                                <li>
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                    <a href="${place.websiteUrl}" target="_blank">${place.websiteUrl}</a>
                                </li>
                            </ul>
                        </div>
                    </div>

                    <#if place.openingHours?size gt 0>
                        <div class="listSidebar">
                            <h3>Opening Hours</h3>
                            <ul class="list-unstyled sidebarList">
                                <li>
                                    <span class="pull-left">Monday</span>
                                    <span class="pull-right">${place.openingHours["Monday"]}</span>
                                </li>
                                <li>
                                    <span class="pull-left">Tuesday</span>
                                    <span class="pull-right">${place.openingHours["Tuesday"]}</span>
                                </li>
                                <li>
                                    <span class="pull-left">Wednesday</span>
                                    <span class="pull-right">${place.openingHours["Wednesday"]}</span>
                                </li>
                                <li>
                                    <span class="pull-left">Thursday</span>
                                    <span class="pull-right">${place.openingHours["Thursday"]}</span>
                                </li>
                                <li>
                                    <span class="pull-left">Friday</span>
                                    <span class="pull-right">${place.openingHours["Friday"]}</span>
                                </li>
                                <li>
                                    <span class="pull-left">Saturday</span>
                                    <span class="pull-right">${place.openingHours["Saturday"]}</span>
                                </li>
                                <li>
                                    <span class="pull-left">Sunday</span>
                                    <span class="pull-right">${place.openingHours["Sunday"]}</span>
                                </li>
                            </ul>
                        </div>
                    </#if>

                </div>
                <div class="col-sm-8 col-xs-12">
                    <div class="listDetailsInfo">
                        <div class="detailsInfoBox">
                            <h3>About This Store</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed eiusmod tempor incididunt  labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident. sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam. </p>
                            <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est. </p>
                            <p>Qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui </p>
                        </div>

                        <div class="detailsInfoBox">
                            <h3>Reviews (${place.reviews?size})</h3>
                        <#list place.reviews as review>
                            <div class="media media-comment">
                                <div class="media-left">
                                    <img src="/img/listing/user-2.png" class="media-object img-circle" alt="Image User">
                                </div>
                                <div class="media-body">
                                    <h4 class="media-heading">${review.authorName}</h4>
                                    <ul class="list-inline rating">
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    </ul>
                                    <p>${review.text}</p>
                                </div>
                            </div>
                        </#list>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>

<#--Gallery-->

    <#if place.photoUrls?size gt 0>
        <section class="thingsArea" style="margin-top: -170px;">
            <div class="container">
                <div class="text-center">
                    <h2>Gallery</small></h2>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="carousel slide thumbnailCarousel">
                            <!-- Carousel items -->
                            <div id="images-carousel" class="owl-carousel">

                                <#list place.photoUrls as photo>
                                    <div class="thingsImage">
                                        <img src="${photo}" alt="Image things">
                                    </div>
                                </#list>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </section>
    </#if>


    <!-- FOOTER -->
    <#include "../common/footer.ftl">
</div>
    <#include "../common/scripts.ftl">

<script src="/plugins/owl-carousel/owl.carousel.min.js"></script>
<script src="/plugins/map/js/infobox_packed.js"></script>
<script src="/js/single-map.js"></script>
<script src="/js/map.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBEDfNcQRmKQEyulDN8nGWjLYPm8s4YB58"></script>
</body>

</html>

