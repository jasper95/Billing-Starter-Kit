require(['jquery', 'css!bootstrap-css', 'css!datatables.net-bs-css', 'datatables.net-bs'], function(){
    'use strict';
    $('#entrys_table').dataTable({
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
});
