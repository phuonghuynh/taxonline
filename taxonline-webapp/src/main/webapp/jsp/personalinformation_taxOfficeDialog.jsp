
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table id="taxOfficeDataGrid" dojoType="dojox.grid.DataGrid" style="width: 100%; height: 220px;"></table>

<div dojoType="dijit.form.Form" id="taxOfficeInputForm" jsId="taxOfficeInputForm" encType="multipart/form-data" action="" method="POST">
	<input type="text" name="taxOfficeId" id="taxOfficeId" hidden="true" type="hidden" />
	<table style="border: 1px solid #9f9f9f;" cellspacing="10">
		<tr>
			<td><label for="nameVn"><spring:message code="label.Personalinformation.NameVN"/>:</td>
			<td><input type="text" name="taxOfficeNameVn" id="taxOfficeNameVn" dojoType="dijit.form.ValidationTextBox" />
			</td>
		</tr>
		<tr>
			<td><label for="nameEn"><spring:message code="label.Personalinformation.NameEN"/>:</td>
			<td><input type="text" name="taxOfficeNameEn" id="taxOfficeNameEn" dojoType="dijit.form.ValidationTextBox" /></td>
		</tr>	
	</table>
	<button dojoType="dijit.form.Button" id="taxOfficeAddButton" jsId="taxOfficeAddButton"><spring:message code="label.Button.AddOrUpdate"/></button>
</div>

<script type="text/javascript">

	dojo.require("custom.PopupDialog");
	
	var taxOfficeGetUrl = "<%=request.getContextPath()%>/national";
	var taxOfficePopupDialog = {};
	var taxOfficeStructure = [{name : "NameVn", field : "nameVn", 'width': '30%'}, 
	        	 			  {name : "NameEn", field : "nameEn", 'width': '30%'}];
	
	var taxOfficeActions = {};
	taxOfficeActions.names = ["Select", "Edit" , "Delete"];
	taxOfficeActions.doSelect = function(item) {
        dojo.byId("personalTaxOfficeId").value = item.id[0];
        dojo.byId("personalTaxOfficeNameVn").value = item.nameVn[0];
        taxOfficePopupDialog.dialog.hideDialog();
	};
	taxOfficeActions.doEdit = function(item) {
    	dojo.byId("taxOfficeNameEn").value = item.nameVn[0];
        dojo.byId("taxOfficeNameVn").value = item.nameEn[0];
        dojo.byId("taxOfficeId").value = item.id[0];    	
    };
    taxOfficeActions.doDelete = function(item) {
        taxUtils.doDelete(taxOfficeGetUrl +'/'+item.id[0]);
        taxOfficePopupDialog.customGrid.loadGrid(taxUtils.doGet(taxOfficeGetUrl));
    },
	
	
	dojo.addOnLoad(function() {
		
		var taxOfficeResourceData = [	
		                             	{postId: "id", 		postFieldValue: "taxOfficeId"}, 
		                              	{postId: "nameVn", 	postFieldValue: "taxOfficeNameVn"},
		                              	{postId: "nameEn", 	postFieldValue: "taxOfficeNameEn"}
		                           	];
		
		var taxOfficeParam = {
				dataGridId 			: 	"taxOfficeDataGrid",
				formId 				: 	"taxOfficeInputForm",
				addButtonId			:   "taxOfficeAddButton",
				formTitle 			: 	"<spring:message code="label.Personalinformation.AddYourNational"/>",
			    getUrl 				: 	taxOfficeGetUrl,
			    parentFieldId		: 	"personalTaxOfficeId",
			    parentFieldNameVn	: 	"personalTaxOfficeNameVn",
			    fieldNameId			: 	"taxOfficeId",
			    fieldNameVn			: 	"taxOfficeNameVn",
			    fieldNameEn			: 	"taxOfficeNameEn",
			    Structure			:	taxOfficeStructure,
			    resourcePost		:	taxOfficeResourceData,
			    actions				: 	taxOfficeActions
			    
			};		
		taxOfficePopupDialog = new custom.PopupDialog(taxOfficeParam);
		
	});
	
		
	function openTaxOfficeGrid(){
		taxOfficePopupDialog.doOpenDialog();
	}
	
</script>