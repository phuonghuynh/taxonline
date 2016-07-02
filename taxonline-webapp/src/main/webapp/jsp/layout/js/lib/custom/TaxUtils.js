dojo.require("dojo.currency");

dojo.provide("custom.TaxUtils");
dojo.declare("custom.TaxUtils", null, {

	DATE_JACKSION_FORMAT_PATTERN : "yyyy-MM-dd",

	constructor : function(/* Object */args) {
		dojo.safeMixin(this, args);
	},

	doGet : function(url) {
		_this = this;

		dojo.xhrGet({
			// The URL of the request
			url : url,
			handleAs : "json",
			sync : true,
			// The success callback with result from server
			load : function(newContent) {
				_this.result = newContent;
			},
			// The error handler
			error : function() {
				// Do nothing -- keep old content there
			}
		});
		return _this.result;
	},

	doPost : function(url, resourceData) {
		var xhrArgs = {
			url : url,
			postData : dojo.toJson(resourceData),
			handleAs : "json",
			sync : true,
			headers : {
				"Content-Type" : "application/json"
			},
			load : function(data) {
				_this.result = data;
			},
			error : function(error) {
			}
		};
		var deferred = dojo.xhrPost(xhrArgs);
		return _this.result;
	},

	doDelete : function(url) {
		var xhrArgs = {
			url : url,
			handleAs : "text",
			sync : true,
			load : function(data) {
				_this.result = data;
			},
			error : function(error) {
			}
		};
		var deferred = dojo.xhrDelete(xhrArgs);
		return _this.result;
	},

	clearForm : function(formId) {
		dojo.forEach(dijit.byId(formId).getDescendants(), function(widget) {
			widget.attr('value', '');
		});
	},

	dateFormat : function(dateObjId) {
		return dojo.date.locale.format(dijit.byId(dateObjId).value, {
			datePattern : this.DATE_JACKSION_FORMAT_PATTERN,
			selector : "date"
		});
	},
	
	getMonth: function(dateObjId) {
		return dijit.byId(dateObjId).getValue().getMonth();
	},
	
	getValue: function(objId) {
		return dijit.byId(objId).getValue();
	},
	
	getCurrencyValue: function(value, symbol){
		return dojo.currency.format(value, {currency: symbol});
	},
	
	reloadGrid: function(gridId, reloadUrl) {
		
		var grid = dijit.byId(gridId);
		
		var items 	= taxUtils.doGet(reloadUrl);
		var data 	= {
					    identifier: "id",
					    label: "label",
					    items: [{
					    			id: "Y1",
					          		label: "Years 2012",
					          		months: items
			                  }]
					  };
	    var store = new dojo.data.ItemFileWriteStore({
	        data: data
	    });
	    
	    while(grid.store._getItemsArray().length!=0)
	    {
	       grid.store.deleteItem(grid.store._getItemsArray()[0]);	
	    }
	    
	    grid.setStore(store);		
    },

	pushActionsToGrid : function(obj) {
		
		obj.Structure.push({
			name : "Actions",
			field : "_item",
			formatter : function(item) {
				
				//Buttons Select
				var buttonSelect = new dijit.form.Button({
					label : "Select"
				});
				dojo.connect(buttonSelect, "onClick", function(event) {
					obj.actions.doSelect(item);
				});
				
				//Buttons Edit
				var buttonEdit = new dijit.form.Button({
					label : "Edit"
				});
				dojo.connect(buttonEdit, "onClick", function(event) {
					obj.actions.doEdit(item);
				});
				
				//Buttons Remove
				var buttonRemove = new dijit.form.Button({
					label : "Remove"
				});
				dojo.connect(buttonRemove, "onClick", function(event) {
					obj.actions.doDelete(item);
				});
				
				//Content Pane
				var content = new dijit.layout.ContentPane({
		            style: ""
		        });
				
				
				dojo.forEach(obj.actions.names, function(entry, i) {
					if(entry === 'Select'){
						buttonSelect.placeAt(content.containerNode);
					}
					if(entry === 'Edit'){
						buttonEdit.placeAt(content.containerNode);
					}
					if(entry === 'Delete'){
						buttonRemove.placeAt(content.containerNode);
					}
				});
				return content;
			},
			'width' : '30%'
		});
	},
	
	autotab: function(destination) {
		dijit.byId(destination).focus();
	}
});