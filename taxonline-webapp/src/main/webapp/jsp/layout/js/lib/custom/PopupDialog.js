dojo.provide("custom.PopupDialog");

dojo.require('dojox.grid.DataGrid');
dojo.require('dojo.data.ItemFileWriteStore');

dojo.require('dijit.form.Button');
dojo.require("dijit.form.Form");
dojo.require("dijit.form.Button");
dojo.require("dijit.form.ValidationTextBox");
dojo.require("dijit.form.DateTextBox");	

dojo.require("custom.CustomGrid");
dojo.require("custom.CustomDialog");

dojo.declare("custom.PopupDialog", null, {
	
	customGrid 			: 	null,
	dialog 				: 	null,
	
	dataGridId 			: 	"",
	formId 				: 	"",
	addButtonId			:	"",
	formTitle 			: 	"",
    getUrl 				: 	"",
    
    parentFieldId		: 	"",
    parentFieldNameVn	: 	"",
    
    fieldNameId			: 	"",
    fieldNameVn			: 	"",
    fieldNameEn			: 	"",
    Structure			:	null,
    resourcePost		:	null,
    jsonResource		:	{},
    actions				:	null,
    
	constructor : function(/* Object */args) {
		
		dojo.safeMixin(this, args);
		
		this.dataGridId 		= args.dataGridId;
		this.formId 			= args.formId;
		this.addButtonId		= args.addButtonId;
		this.formId				= args.formId;
		this.addButtonId		= args.addButtonId;
		this.formTitle			= args.formTitle;
		this.getUrl				= args.getUrl;
		this.parentFieldId		= args.parentFieldId;
		this.parentFieldNameVn	= args.parentFieldNameVn;
		this.fieldNameId		= args.fieldNameId;
		this.fieldNameVn		= args.fieldNameVn;
		this.fieldNameEn		= args.fieldNameEn;
		this.Structure			= args.Structure;
		this.resourcePost		= args.resourcePost;
		this.actions			= args.actions;
		
		var dataGrid 	= dijit.byId(this.dataGridId);
		taxUtils.pushActionsToGrid(this);
		dataGrid.setStructure(this.Structure);
		
	    var form 		= dijit.byId(this.formId);

		//Custom Grid
		this.customGrid = new custom.CustomGrid({containterId: this.dataGridId});
		this.customGrid.loadGrid(taxUtils.doGet(this.getUrl));
		
		//Custom nationalDialog
		this.dialog = new custom.CustomDialog({title: this.formTitle});
		this.dialog.addToContentPane(form);
		this.dialog.addToContentPane(dataGrid);
		this.dialog.loadDialog();
		
		//Post Data Information
		var _this = this;
        var button = dijit.byId(this.addButtonId);
        dojo.connect(button, "onClick", function(event) {
        	
        	_this.generateResource();
        	
            taxUtils.doPost(_this.getUrl, _this.jsonResource);
            _this.customGrid.loadGrid(taxUtils.doGet(_this.getUrl));
            
            dojo.byId(_this.fieldNameId).value = '';
            taxUtils.clearForm(_this.formId);
        });
		
	},
	
	generateResource: function(){
		var _this = this;
		var str = '{';
		dojo.forEach(_this.resourcePost, function(entry, i) {
		    str = str + '"'+entry.postId+'":"'+dojo.byId(entry.postFieldValue).value+'"';
		    if (i < _this.resourcePost.length-1) {
		      str = str + ',';
		    }
		});
		str = str + '}';
		_this.jsonResource = dojo.fromJson(str);
	},
    
    doOpenDialog: function() {
    	this.customGrid.loadGrid(taxUtils.doGet(this.getUrl));
    	this.dialog.showDialog();
    }
    
});