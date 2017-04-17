require(['stapes', 'mustache', 'jquery'], function(Stapes, Mustache, $){
    var listTemplate = $("#template").html();
    Mustache.parse(listTemplate);

    var TodosModel = Stapes.subclass();

    var InputView = Stapes.subclass({
        constructor : function( model ) {
            this.model = model;
            this.$el = $("#inputform");
            this.$input = this.$el.find("input");
            this.bindEventHandlers();
        },

        bindEventHandlers : function() {
            this.$el.on('submit', function(e) {
                e.preventDefault();

                this.model.push({
                    "text" : this.$input.val()
                });

                this.$input.val('');
            }.bind(this));
        }
    });

    var ListView = Stapes.subclass({
        constructor : function( model ) {
            this.model = model;
            this.$el = $("#todos");
            this.template = listTemplate;
            this.bindEventHandlers();
        },

        bindEventHandlers : function() {
            this.$el.on('click', '.remove', function(e) {
                var id = $(e.target).parents("li").data('id');
                this.model.remove(id);
            }.bind(this));
        },

        render : function() {
            var html = Mustache.render(this.template,{
                size : this.model.size(),
                todos : this.model.getAllAsArray()
            });

            this.$el.html( html );
        }
    });

    var TodosController = Stapes.subclass({
        constructor : function() {
            this.model = new TodosModel();
            this.listView = new ListView( this.model )
            this.inputView = new InputView( this.model );

            this.model.on('change', function() {
                this.listView.render();
            }, this);
        }
    });
    var controller = new TodosController();
});