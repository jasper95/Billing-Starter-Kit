(function(config){
    if(window.hasOwnProperty('require')){
        require.config(config);
    } else {
        window.require = config;
    }
})({
    deps: ['bootstrap'],
    paths: {
        'jquery': "../vendor/jquery/dist/jquery.min",
        'bootstrap': "../vendor/bootstrap/dist/js/bootstrap.min",
        'bootstrap-css': "../vendor/bootstrap/dist/css/bootstrap.min",
        "datatables.net": "../vendor/datatables.net/js/jquery.dataTables.min",
        'datatables.net-css' : "../vendor/datatables.net-dt/css/jquery.dataTables.min",
        "datatables.net-responsive": "../vendor/datatables.net-responsive/js/dataTables.responsive.min",
        "datatables.net-responsive-css": "../vendor/datatables.net-responsive-dt/css/responsive.dataTables.min",
        'yadcf-css': "../vendor/yadcf/jquery.dataTables.yadcf",
        'yadcf': "../vendor/yadcf/jquery.dataTables.yadcf",
        'stapes': '../vendor/stapes/stapes.min',
        'mustache': '../vendor/mustache.js/mustache.min'
    },
    map: {
        '*': {
            'css': '../vendor/require-css/css.min'
        }
    },
    shim: {
        bootstrap : {
            deps : ['jquery']
        }
    }
});