require(['jquery', 'css!bootstrap-css', 'css!datatables.net-bs-css', 'datatables.net-bs', 'yadcf'], function(){
    'use strict';
    var table = $('#entrys_table').DataTable({
        "serverSide": true,
        "processing": true,
        "paging": true,
        "ajax": "/api/data-tables/users",
        "columns": [{
            "data": "fullName"
        }, {
            "data": "username"
        }, {
            "data": "type"
        }]
    });
    var type_filters = [{
        value : "SUPERUSER",
        label : "Superuser"
    }, {
        value : "ENCODER",
        label : "Encoder"
    }, {
        value : "TREASURER",
        label : "Treasurer"
    }, {
        value : "REPORTS_VIEWER",
        label : "Reports Viewer"
    }
    ]
    yadcf.init(table,[{
        "externally_triggered": true,
        column_number: 0,
        "filter_type": "text",
        filter_container_id: 'f_full_name',
        'filter_default_label': 'Type full name'
    }, {
        "externally_triggered": true,
        column_number: "1",
        "filter_type": "text",
        filter_container_id: 'f_username',
        'filter_default_label': 'Type username'
    }, {
        "externally_triggered": true,
        column_number: 2,
        "filter_type": "select",
        filter_container_id: 'f_type',
        'filter_default_label': 'Select type',
        data: type_filters
    }], 'none');
    $('#filterButton').click(function() {
        yadcf.exFilterExternallyTriggered(table);
    });
    $('#filterClearButton').click(function() {
        yadcf.exResetAllFilters(table);
    });
});
