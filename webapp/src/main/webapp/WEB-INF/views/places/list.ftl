<!DOCTYPE html>
<html lang="en">
<head>

    <!-- SITE TITTLE -->

<#include "../common/meta.ftl">
    <title>Stores in ${city} - Stores List</title>

<#include "../common/styles.ftl">

</head>

<body class="body-wrapper">
<div class="page-loader" style="background: url(/img/preloader.gif) center no-repeat #fff;"></div>
<div class="main-wrapper">

    <!-- HEADER -->
<#include "../common/header.ftl">


    <!-- PAGE TITLE SECTION -->
    <section class="clearfix pageTitleSection">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <div class="pageTitle">
                        <h2>
                            Stores in ${city}
                            <#if district??> - ${district}</#if>

                        </h2>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- BREADCRUMBS-->
<#include "../common/breadcrumbs.ftl">


    <!-- PLACES LIST SECTION -->
    <section class="clerfix central-block">
        <div class="container">
            <div class="row">

            <#--RESULTS LIST-->
                <div class="col-sm-9 col-xs-12">
                    <div class="resultBar barSpaceAdjust">
                        <h2>We found <span>${totalItems}</span> Results for you</h2>

                    </div>

                <#list places as place>
                    <div class="listContent">
                        <div class="row">
                            <div class="col-sm-6 col-xs-12">
                                <div class="categoryImage"
                                     style="width: 400px; height: 250px;">
                                    <#if place.thumbnailUrl != "" >
                                        <img src="${place.thumbnailUrl}" a
                                             alt="Image category"
                                             class="img-responsive img-rounded"
                                             style="height: 100%; "
                                        >
                                    <#else>
                                        <img src="/img/things/things-1.jpg" alt="Image category"
                                             class="img-responsive img-rounded">
                                    </#if>
                                    <!--<span class="label label-primary">Verified</span>-->
                                </div>
                            </div>
                            <div class="col-sm-6 col-xs-12">
                                <div class="categoryDetails">
                                    <ul class="list-inline rating">
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                        <li><i class="fa fa-star" aria-hidden="true"></i></li>
                                    </ul>
                                    <h2><a href="/place/${place.id}/"
                                           style="color: #222222">${place.name}</a></h2>
                                    <p>${place.address} <span class="placeName">${place.city}</span></p>

                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
                </div>

            <#--RESULTS LIST END-->


            <#-- Districts panel -->
               <div class="col-sm-3 col-xs-12">
                    <div class="listSidebar">
                        <h3>Districts</h3>
                        <ul class="list-unstyled sidebarList">
                        <#list districts as district>
                            <li>
                                <span class="pull-right">
                                    <a href="/${country}/${city}/${district}/">${district}</a>
                                </span>
                            </li>
                        </#list>
                        </ul>
                    </div>
                </div>

            <#-- Districts panel END-->

            </div>
        <#include "../common/pagination.ftl">
        </div>
    </section>


    <!-- FOOTER -->
<#include "../common/footer.ftl">
</div>

<#include "../common/scripts.ftl">
</body>

</html>

