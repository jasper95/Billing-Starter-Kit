require(['jquery', 'css!bootstrap-css', 'css!datatables.net-bs-css', 'datatables.net-bs', 'yadcf'], function(){
    'use strict';
    var table = $('#entrys_table').DataTable({
        "processing": true,
        "paging": true,
        "ajax": "/api/data-tables/test",
        "columns": [{
            "data": "fullName"
        }, {
            "data": "username"
        }, {
            "data": "type"
        }]
    });
    yadcf.init(table,[{
        "externally_triggered": true,
        column_number: 0,
        "filter_type": "text",
        filter_container_id: 'f_full_name',
    }, {
        "externally_triggered": true,
        column_number: "1",
        "filter_type": "text",
        filter_container_id: 'f_username'
    }, {
        "externally_triggered": true,
        column_number: 2,
        "filter_type": "select",
        filter_container_id: 'f_type'
    }], 'none');
    $('#filterButton').click(function() {
        yadcf.exFilterExternallyTriggered(table);
    });
    $('#filterClearButton').click(function() {
        yadcf.exResetAllFilters(table);
    });
});
