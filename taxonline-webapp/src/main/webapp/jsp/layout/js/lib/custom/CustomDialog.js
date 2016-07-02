dojo.require("dijit.form.Button");
dojo.require("dijit.Dialog");
dojo.require("dijit.form.TextBox");
dojo.require("dijit.form.Button");
dojo.require("dijit.form.DateTextBox");
dojo.require("dijit.form.TimeTextBox");
dojo.require("dijit.layout.BorderContainer");
dojo.require("dijit.layout.ContentPane");

dojo.provide("custom.CustomDialog");
dojo.declare("custom.CustomDialog", null, {

    formDlg : null,
    title : null,
    button_OK : null,
    button_CANCEL : null,
    layout: null,
    centerPane: null,

    constructor : function(/* Object */args) {
        dojo.safeMixin(this, args);
        this.title = args.title;
        
        this.layout = new dijit.layout.BorderContainer({
            design : "headline",
            style : "width: 600px; height: 600px;"
        });
        
        this.centerPane = new dijit.layout.ContentPane({
            region : "center",
            style : "align: center;",
            content : this.title
        });
        
        this.actionPane = new dijit.layout.ContentPane({
            region : "bottom",
            style : ""
        });
    },

    loadDialog : function() {
        var _this = this;
        
        button_OK = new dijit.form.Button({
            label : "OK"
        });
        dojo.connect(button_OK, "onClick", function(event) {
            _this.hideDialog();
        });

        // Add Butons to action Pane
        button_OK.placeAt(this.actionPane.containerNode);

        this.layout.addChild(this.centerPane);
        this.layout.addChild(this.actionPane);
        this.layout.startup();

        this.formDlg = new dijit.Dialog({
            title : _this.title,
            content : this.layout
        });
    },
    
    addToContentPane: function(element) {
        element.placeAt(this.centerPane.containerNode);
    },

    showDialog : function() {
        this.formDlg.show();
    },
    
    hideDialog : function() {
        this.formDlg.hide();
    }

});