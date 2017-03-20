(function(config){
    if(window.hasOwnProperty('require')){
        require.config(config);
    } else {
        window.require = config;
    }
})({
    paths: {
        'jquery': "../vendor/jquery/dist/jquery.min",
        'bootstrap': "../vendor/bootstrap/dist/js/bootstrap.min",
        'bootstrap-css': "../vendor/bootstrap/dist/css/bootstrap.min",
        "datatables.net": "../vendor/datatables.net/js/jquery.dataTables.min",
        "datatables.net-bs": "../vendor/datatables.net-bs/js/dataTables.bootstrap.min",
        'datatables.net-bs-css' : "../vendor/datatables.net-bs/css/dataTables.bootstrap.min"
        /*'yadcf': "../vendor/yadcf/jquery.dataTables.yadcf"*/
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