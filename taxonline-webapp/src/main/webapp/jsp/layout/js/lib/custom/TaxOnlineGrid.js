dojo.provide("custom.TaxOnlineGrid");

dojo.require('dojox.grid.DataGrid');
dojo.require('dojo.data.ItemFileWriteStore');	

dojo.require("custom.CustomGrid");

dojo.declare("custom.TaxOnlineGrid", null, {
	
	dataGridId			:	null,
	customGrid 			: 	null,
	getUrl				:	null,
	Structure			:	null,
	actions				:	null,
	dataGrid			:	null,
	store				:	null,
	
	constructor : function(/* Object */args) {
		dojo.safeMixin(this, args);
		this.dataGridId = args.dataGridId;
		this.getUrl		= args.getUrl;
		this.Structure	= args.Structure;
		this.actions	= args.actions;
		
		//Set actions for Grid
		if(this.actions) {
			taxUtils.pushActionsToGrid(this);
		}
		this.dataGrid 	= dijit.byId(this.dataGridId);
		this.dataGrid.setStructure(this.Structure);
		
		this.customGrid = new custom.CustomGrid({containterId: this.dataGridId});
		this.customGrid.loadGrid(taxUtils.doGet(this.getUrl));
	},
	
    reloadGrid: function() {
    	this.customGrid.loadGrid(taxUtils.doGet(this.getUrl));
    },
    
    reloadGridPerUrl: function(url) {
    	this.customGrid.loadGrid(taxUtils.doGet(url));
    }
	
});