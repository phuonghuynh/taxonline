
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table id="ciNationalDataGrid" dojoType="dojox.grid.DataGrid" style="width: 100%; height: 220px;"></table>

<div dojoType="dijit.form.Form" id="ciNationalInputForm" jsId="ciNationalInputForm" encType="multipart/form-data" action="" method="POST">
	<input type="text" name="ciNationalId" id="ciNationalId" hidden="true" type="hidden" />
	<table style="border: 1px solid #9f9f9f;" cellspacing="10">
		<tr>
			<td><label for="nameVn"><spring:message code="label.Personalinformation.NameVN"/>:</td>
			<td><input type="text" name="ciNationalNameVn" id="ciNationalNameVn" dojoType="dijit.form.ValidationTextBox" />
			</td>
		</tr>
		<tr>
			<td><label for="nameEn"><spring:message code="label.Personalinformation.NameEN"/>:</td>
			<td><input type="text" name="ciNationalNameEn" id="ciNationalNameEn" dojoType="dijit.form.ValidationTextBox" /></td>
		</tr>	
	</table>
	<button dojoType="dijit.form.Button" id="ciNationalAddButton" jsId="ciNationalAddButton"><spring:message code="label.Button.AddOrUpdate"/></button>
</div>

<script type="text/javascript">

	dojo.require("custom.PopupDialog");
	
	
	
	var ciNationalGetUrl = "<%=request.getContextPath()%>/national";
	var ciNationalPopupDialog = {};
	var ciNationalActions = {};
	var ciNationalStructure = [{name : "NameVn", field : "nameVn", 'width': '30%'}, 
	        	 			   {name : "NameEn", field : "nameEn", 'width': '30%'}];
	
	
	ciNationalActions.doSelect = function(item) {
        dojo.byId("personalCiNationalId").value = item.id[0];
        dojo.byId("personalCiNationalNameVn").value = item.nameVn[0];
        ciNationalPopupDialog.dialog.hideDialog();
	};
	
	ciNationalActions.names = ["Select", "Edit" , "Delete"];
	ciNationalActions.doEdit = function(item) {
    	dojo.byId("ciNationalNameEn").value = item.nameVn[0];
        dojo.byId("ciNationalNameVn").value = item.nameEn[0];
        dojo.byId("ciNationalId").value = item.id[0];    	
    };
    
    ciNationalActions.doDelete = function(item) {
        taxUtils.doDelete(ciNationalGetUrl +'/'+item.id[0]);
        ciNationalPopupDialog.customGrid.loadGrid(taxUtils.doGet(ciNationalGetUrl));
    },	
	
	dojo.addOnLoad(function() {
		var ciNationalResourceData = [{postId: "id", 		postFieldValue: "ciNationalId"}, 
		                              {postId: "nameVn", 	postFieldValue: "ciNationalNameVn"},
		                              {postId: "nameEn", 	postFieldValue: "ciNationalNameEn"}
		                           ];
		
		var ciNationalParam = {
				dataGridId 			: 	"ciNationalDataGrid",
				formId 				: 	"ciNationalInputForm",
				addButtonId			:   "ciNationalAddButton",
				formTitle 			: 	"<spring:message code="label.Personalinformation.AddYourNational"/>",
			    getUrl 				: 	ciNationalGetUrl,
			    parentFieldId		: 	"personalCiNationalId",
			    parentFieldNameVn	: 	"personalCiNationalNameVn",
			    fieldNameId			: 	"ciNationalId",
			    fieldNameVn			: 	"ciNationalNameVn",
			    fieldNameEn			: 	"ciNationalNameEn",
			    Structure			:	ciNationalStructure,
			    resourcePost		:	ciNationalResourceData,
			    actions				:	ciNationalActions
			};		
		ciNationalPopupDialog = new custom.PopupDialog(ciNationalParam);
		
	});
	
		
	function openCINationalGrid(){
		ciNationalPopupDialog.doOpenDialog();
	}
	
</script>