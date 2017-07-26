<div class="breadcrumb-container">
    <div class="row">
        <div class="col-xs-12">
            <ol class="breadcrumb">
                <#list breadcrumbs as crumb>
                    <li>
                        <a href="/${crumb.getValue()}"
                           <#if !crumb?has_next>class="active"</#if>>
                            ${crumb.getKey()}
                        </a>
                    </li>
                </#list>
            </ol>

        </div>
    </div>
</div>
