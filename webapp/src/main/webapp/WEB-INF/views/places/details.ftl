<!DOCTYPE html>
<html lang="en">
<head>

    <!-- SITE TITTLE -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Listing Details - Listty</title>

    <!-- PLUGINS CSS STYLE -->
    <link href="/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">
    <link href="/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="/plugins/listtyicons/style.css" rel="stylesheet">
    <link href="/plugins/bootstrapthumbnail/bootstrap-thumbnail.css" rel="stylesheet">
    <link href="/plugins/datepicker/datepicker.min.css" rel="stylesheet">
    <link href="/plugins/selectbox/select_option1.css" rel="stylesheet">
    <link href="/plugins/owl-carousel/owl.carousel.min.css" rel="stylesheet">
    <link href="/plugins/fancybox/jquery.fancybox.pack.css" rel="stylesheet">
    <link href="/plugins/isotope/isotope.min.css" rel="stylesheet">
    <link href="/plugins/map/css/map.css" rel="stylesheet">

    <!-- GOOGLE FONT -->
    <link href="https://fonts.googleapis.com/css?family=Muli:200,300,400,600,700,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Herr+Von+Muellerhoff" rel="stylesheet">

    <!-- CUSTOM CSS -->
    <link href="/css/style.css" rel="stylesheet">

    <!-- FAVICON -->
    <link href="/img/favicon.png" rel="shortcut icon">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body class="body-wrapper">
<div class="page-loader" style="background: url(/img/preloader.gif) center no-repeat #fff;"></div>
<div class="main-wrapper">

    <!-- HEADER -->
    <#include "../common/header.ftl">


    <!-- LISTINGS DETAILS TITLE SECTION -->
    <section class="clearfix paddingAdjustBottom">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="listingTitleArea">
                        <h2>${place.name}</h2>
                        <p>${place.address}/p>
                        <div class="listingReview">
                            <ul class="list-inline rating">
                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                <li><i class="fa fa-star-o" aria-hidden="true"></i></li>
                            </ul>
                            <span>( 5 Reviews )</span>
                            <ul class="list-inline captionItem">
                                <li><i class="fa fa-heart-o" aria-hidden="true"></i> 10 k</li>
                            </ul>
                            <a href="#" class="btn btn-primary">Write a review</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- LISTINGS DETAILS IMAGE SECTION -->
    <section class="clearfix paddingAdjustTopBottom">
        <ul class="list-inline listingImage">
            <li><img src="/img/listing/listing-details-1.jpg" alt="Image Listing" class="img-responsive"></li>
            <li><img src="/img/listing/listing-details-2.jpg" alt="Image Listing" class="img-responsive"></li>
            <li><img src="/img/listing/listing-details-3.jpg" alt="Image Listing" class="img-responsive"></li>
            <li><img src="/img/listing/listing-details-4.jpg" alt="Image Listing" class="img-responsive"></li>
        </ul>
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
                                    16/14 Babor Road, Mohammad pur <br> Dhaka, Bangladesh
                                </li>
                                <li>
                                    <i class="fa fa-phone" aria-hidden="true"></i>
                                ${place.phoneNumber}
                                </li>
                                <li>
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                    <a href="#">${place.websiteUrl}</a>
                                    <a href="#">info@startravelbangladesh.com</a>
                                </li>
                            </ul>
                        </div>
                    </div>
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
                </div>
                <div class="col-sm-8 col-xs-12">
                    <div class="listDetailsInfo">
                        <div class="detailsInfoBox">
                            <h3>About This Casino</h3>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed eiusmod tempor incididunt  labore et dolore magna aliqua.Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident. sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam. </p>
                            <p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est. </p>
                            <p>Qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui </p>
                        </div>
                        <div class="detailsInfoBox">
                            <h3>Features</h3>
                            <ul class="list-inline featuresItems">
                                <li><i class="fa fa-check-circle-o" aria-hidden="true"></i>  Wi-Fi</li>
                                <li><i class="fa fa-check-circle-o" aria-hidden="true"></i>  Street Parking</li>
                                <li><i class="fa fa-check-circle-o" aria-hidden="true"></i>  Alcohol</li>
                                <li><i class="fa fa-check-circle-o" aria-hidden="true"></i>  Vegetarian</li>
                                <li><i class="fa fa-check-circle-o" aria-hidden="true"></i>  Reservations</li>
                                <li><i class="fa fa-check-circle-o" aria-hidden="true"></i>  Black Jack</li>
                                <li><i class="fa fa-check-circle-o" aria-hidden="true"></i>  Accept Credit Card</li>
                            </ul>
                        </div>
                        <div class="detailsInfoBox">
                            <h3>Reviews (3)</h3>
                        <#list place.reviews as review>
                            <div class="media media-comment">
                                <div class="media-left">
                                    <img src="/img/listing/list-user-1.jpg" class="media-object img-circle" alt="Image User">
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
                        <div class="detailsInfoBox">
                            <h3>Write A Review </h3>
                            <div class="listingReview">
                                <span>( 5 Reviews )</span>
                                <ul class="list-inline rating rating-review">
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                </ul>
                            </div>
                            <form action="#">
                                <div class="formSection formSpace">
                                    <div class="form-group">
                                        <textarea class="form-control" rows="3" placeholder="Comment"></textarea>
                                    </div>
                                    <div class="form-group mb0">
                                        <button type="submit" class="btn btn-primary">Send Review</button>
                                    </div>
                                </div>
                            </form>
                        </div>
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


<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBEDfNcQRmKQEyulDN8nGWjLYPm8s4YB58"></script>

</body>

</html>

