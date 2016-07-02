
dojo.require("dojox.validate.check");

dojo.provide("custom.CustomValidation");
dojo.declare("custom.CustomValidation", null, {
	
	formId:			null,
	
	constructor : function(/* Object */args) {
		dojo.safeMixin(this, args);
		this.formId	 = args.formId;

	},
	
	check: function() {
		
		var validate = dijit.byId(this.formId).validate();
		return (validate);
	}
	
});