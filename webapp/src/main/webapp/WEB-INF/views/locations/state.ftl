<!DOCTYPE html>
<html lang="en">
<head>

    <!-- SITE TITTLE -->

    <#include "../common/meta.ftl">
    <title>Country - Stores List</title>

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
                        <h2>Cities in ${state}</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- BREADCRUMBS-->
    <#include "../common/breadcrumbs.ftl">

    <#include "../common/letters.ftl">

    <#---------- TOP PLACES SECTION ------------->

    <#---------- TOP PLACES SECTION ------------->

    <!-- CITIES LIST -->
    <section class="clearfix allBusiness central-block">
        <div class="container">

            <#if noQuery==true>

                <#--------- TOP CITIES SECTION ---------->
                <div class="row">
                    <div class="col-xs-12 text-center">
                        <h2 class="">Most Popular Cities in ${state}</h2>
                    </div>

                    <#list topCities as city>
                        <div class="col-xs-12 col-sm-6 col-md-4"
                             style="margin-bottom: 20px">
                            <div class="thumbnail-container">
                                <a href="/${state?lower_case}/${city?lower_case}/">
                                    <img src="/img/cities/${city}"
                                         class="img-responsive thumbnail-img"
                                         alt="${city}">
                                </a>
                            </div>
                            <div class="place-description ellipsize">
                                <h3><a href="/${state?lower_case}/${city?lower_case}/">${city}</a></h3>
                            </div>
                        </div>
                    </#list>
                </div>
                <#--------- TOP CITIES SECTION END ---------->

                <#--------- TOP PLACES SECTION ---------->
                <div class="row">
                    <div class="col-xs-12 text-center">
                        <h2 class="">Best Stores in ${state}</h2>
                    </div>

                    <#list topPlaces as place>
                        <div class="col-xs-12 col-sm-6 col-md-4"
                        style="margin-bottom: 20px">
                            <div class="thumbnail-container">
                                <a href="/place/${place.id}/">
                                    <img src="${place.thumbnailUrl}"
                                         class="img-responsive thumbnail-img"
                                         alt="${place.name}">
                                </a>
                            </div>
                            <div class="place-description ellipsize">
                                <h3><a href="/place/${place.id}/"
                                       style="color: #222222">${place.name}</a></h3>
                            </div>
                        </div>
                    </#list>
                </div>
                <#--------- TOP PLACES SECTION END ---------->

            <#else>

                <#-------- LISTING BY LETTER SECTION ----------->
                <div class="row">
                    <div class="col-sm-2">
                    </div>
                    <div class="col-sm-10">
                        <div class="businessLink">
                            <ul class="list-inline">
                                <#list cities as city>
                                    <li><a href="/${state?lower_case}/${city?lower_case}/">${city}</a></li>
                                </#list>
                            </ul>
                        </div>

                    </div>
                </div>
                <#-------- LISTING BY LETTER SECTION END----------->
            </#if>
        </div>
    </section>


    <!-- FOOTER -->
    <#include "../common/footer.ftl">
</div>

<#include "../common/scripts.ftl">

</body>

</html>
