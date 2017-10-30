<div class="row">
    <div class="col-sm-4"></div>
    <div class="col-sm-6">
        <div class="paginationCommon blogPagination categoryPagination">
            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li>
                        <a href="?page=${currentPage-1}" aria-label="Previous">
                            <span aria-hidden="true"><i class="fa fa-angle-left" aria-hidden="true"></i></span>
                        </a>
                    </li>

                    <#if currentPage gt 3>
                        <li><a href="?page=1">1</a></li>
                        <li>...</li>
                    </#if>

                    <#if currentPage gt 2>
                        <li><a href="?page=${currentPage-2}">${currentPage - 2}</a></li>
                    </#if>

                    <#if currentPage gt 1>
                        <li><a href="?page=${currentPage-1}">${currentPage - 1}</a></li>
                    </#if>

                    <li class="active"><a href="?page=${currentPage}">${currentPage}</a></li>

                    <#if currentPage lt totalPages>
                        <li><a href="?page=${currentPage+1}">${currentPage + 1}</a></li>
                    </#if>

                    <#if currentPage lt totalPages-1>
                        <li><a href="?page=${currentPage+2}">${currentPage + 2}</a></li>
                    </#if>

                    <#if currentPage lt totalPages-2>
                        <li>...</li>
                        <li><a href="?page=${totalPages}">${totalPages}</a></li>
                    </#if>

                    <li>
                        <a href="?page=${currentPage+1}" aria-label="Next">
                            <span aria-hidden="true"><i class="fa fa-angle-right" aria-hidden="true"></i></span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</div>