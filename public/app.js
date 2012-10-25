/* Module */
var App = {
    Models : {},
    Collections : {},
    Views : {},
    start : function() { start(); }

}

App.Models.Client = Backbone.Model.extend({
    urlRoot  : "/client"
});

App.Collections.Clients = Backbone.Collection.extend({
    url : "/clients",
    model : App.Models.Client

});

App.Views.ClientsListView = Backbone.View.extend({
    el : $("#clients_list"),
    initialize : function () {
        this.template = $("#clients_list_template").html();

        //dès que la collection "change" j'actualise le rendu de la vue
        _.bindAll(this, 'render');
        this.collection.bind('reset', this.render);
        this.collection.bind('change', this.render);
        this.collection.bind('add', this.render);
        this.collection.bind('remove', this.render);

    },
    render : function () {
        var renderedContent = Mustache.to_html(this.template, {clients : this.collection.toJSON()} );
        this.$el.html(renderedContent);
    }
});

function start() {

    console.log("Démarrage de l'application Backbone");

    window.clientsCollection = new App.Collections.Clients();

	window.clientsListView = new App.Views.ClientsListView({collection : clientsCollection});
	
    clientsCollection.fetch({
        success : function(data) { console.log(data); },
        error : function(err) { throw err; }
    });

		
}