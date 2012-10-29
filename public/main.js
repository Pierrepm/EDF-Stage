yepnope({
    load: {
        jquery              : 'assets/javascripts/jquery-1.8.2.js',	
		underscore          : 'assets/javascripts/underscore.js',
        backbone            : 'assets/javascripts/backbone.js',
        mustache            : 'assets/javascripts/mustache.js',
		dataTables          : 'assets/javascripts/jquery.dataTables.js',
		DTBootstrap			: 'assets/javascripts/dataTables.bootstrap.js',
		application         : 'assets/app.js'
    },
    complete : function () {
        $(function (){
            console.log("Application chargée ...");
			App.start(); 
        });  
    }
});