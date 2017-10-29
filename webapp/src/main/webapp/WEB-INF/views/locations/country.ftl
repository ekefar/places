<!DOCTYPE html>
<html lang="en">
<head>

    <!-- SITE TITTLE -->

    <#include "../common/meta.ftl">
    <title>Country - Casinos List</title>

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
                        <h2>Cities in ${country}</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- BREADCRUMBS-->
    <#include "../common/breadcrumbs.ftl">


    <!-- CITIES LIST -->
    <section class="clearfix allBusiness central-block">
        <div class="container">
            <div class="row">
                <div class="col-sm-2">
                </div>
                <div class="col-sm-10">
                    <div class="businessLink">

                        <ul class="list-inline">
                            <#list cities as city>
                                <li><a href="/${country?lower_case}/${city?lower_case}/">${city}</a></li>
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

<#include "../common/scripts.ftl">

</body>

</html>
