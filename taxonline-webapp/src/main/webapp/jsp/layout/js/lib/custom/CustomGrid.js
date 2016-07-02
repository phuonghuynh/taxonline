dojo.require('dojox.grid.DataGrid');
dojo.require('dojox.grid.TreeGrid');

dojo.require('dojo.data.ItemFileWriteStore');
dojo.require('dijit.form.Button');

dojo.provide("custom.CustomGrid");
dojo.declare("custom.CustomGrid", null, {
	
	containterObj: null,
	store: null,
	
	constructor : function(/* Object */args) {
		dojo.safeMixin(this, args);
		this.containterId = args.containterId;
	},
	
	loadGrid : function(store, structure) {

		var grid = dijit.byId(this.containterId);
	    var store = new dojo.data.ItemFileWriteStore({
	        data: {
	            identifier : 'id',
	            items: store
	        }
	    });
	    grid.setStructure(structure);
	    grid.setStore(store);
	},
	
	loadGridNoStructure : function(store) {

		var grid = dijit.byId(this.containterId);
	    var store = new dojo.data.ItemFileWriteStore({
	        data: {
	            identifier : 'id',
	            items: store
	        }
	    });
	    grid.setStore(store);
	}
	
});