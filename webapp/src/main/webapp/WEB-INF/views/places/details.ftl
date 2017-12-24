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
                <div class="col-xs-9">
                    <div class="listingTitleArea">
                        <h2>${place.name}</h2>
                        <p>${place.address}</p>
                    </div>
                </div>

                <div class="col-xs-3">
                    <div class="listingTitleArea" style="text-align: center">
                        <h2>${place.rating?string["0.0"]}</h2>
                    <#--<span>(based on ${place.reviews?size} review<#if place.reviews?size gt 1>s</#if>)</span>-->
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
                </div>
                <div class="col-sm-4 col-xs-12">
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
                </div>
                <div class="col-sm-4 col-xs-12">
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
            </div>

        <#-------- GALLERY SECTION --------------->
        <#if place.photoUrls?size gt 0>
            <hr>
            <div class="row">
                <div class="text-center">
                    <h2>Gallery</small></h2>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="carousel slide thumbnailCarousel">
                            <!-- Carousel items -->
                            <div id="images-carousel" class="owl-carousel details">

                                <#list place.photoUrls as photo>
                                    <div class="thingsImage thumbnail-container">
                                        <a href="${photo}?image=${photo?index}"
                                           data-toggle="lightbox"
                                           data-gallery="store-images-gallery">
                                            <img src="${photo}" class="thumbnail-img" alt="Image things">
                                        </a>
                                    </div>
                                </#list>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </#if>
        <#-------- END OF GALLERY SECTION --------------->


            <#--------- ABOUT SECTION ---------->
            <div class="row">
                <div class="col-sm-12 col-xs-12">
                    <div class="listDetailsInfo">
                        <div class="detailsInfoBox">
                            <hr>
                            <h3>About This Store</h3>
                            <p>${description}</p>
                        </div>


                    <#--==== REVIEWS SECTION ========-->
                    <#-- <div class="detailsInfoBox">
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
                     </div>-->
                    <#--==== END OF REVIEWS SECTION ========-->

                    </div>
                </div>
            </div>
            <#--------- END OF ABOUT SECTION ---------->

        </div>
    </section>

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

