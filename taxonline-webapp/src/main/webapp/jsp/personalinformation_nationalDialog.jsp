
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table id="nationalDataGrid" dojoType="dojox.grid.DataGrid" style="width: 100%; height: 220px;"></table>

<div dojoType="dijit.form.Form" id="nationalInputForm" jsId="nationalInputForm" encType="multipart/form-data" action="" method="POST">
	<input type="text" name="nationalId" id="nationalId" hidden="true" type="hidden" />
	<table style="border: 1px solid #9f9f9f;" cellspacing="10">
		<tr>
			<td><label for="nameVn"><spring:message code="label.Personalinformation.NameVN"/>:</td>
			<td><input type="text" name="nationalNameVn" id="nationalNameVn" dojoType="dijit.form.ValidationTextBox" />
			</td>
		</tr>
		<tr>
			<td><label for="nameEn"><spring:message code="label.Personalinformation.NameEN"/>:</td>
			<td><input type="text" name="nationalNameEn" id="nationalNameEn" dojoType="dijit.form.ValidationTextBox" /></td>
		</tr>	
	</table>
	<button dojoType="dijit.form.Button" id="nationalAddButton" jsId="nationalAddButton"><spring:message code="label.Button.AddOrUpdate"/></button>
</div>

<script type="text/javascript">

	dojo.require("custom.PopupDialog");
	
	var nationalGetUrl = "<%=request.getContextPath()%>/national";
	var nationalPopupDialog = {};
	var nationalStructure = [{name : "NameVn", field : "nameVn", 'width': '30%'}, 
	        	 			 {name : "NameEn", field : "nameEn", 'width': '30%'}];
	
	var nationalActions = {};
	nationalActions.names = ["Select", "Edit" , "Delete"];
	nationalActions.doSelect = function(item) {
        dojo.byId("personalNationalId").value = item.id[0];
        dojo.byId("personalNationalNameVn").value = item.nameVn[0];
        nationalPopupDialog.dialog.hideDialog();
	};
	nationalActions.doEdit = function(item) {
    	dojo.byId("nationalNameEn").value = item.nameVn[0];
        dojo.byId("nationalNameVn").value = item.nameEn[0];
        dojo.byId("nationalId").value = item.id[0];    	
    };
    nationalActions.doDelete = function(item) {
        taxUtils.doDelete(nationalGetUrl +'/'+item.id[0]);
        nationalPopupDialog.customGrid.loadGrid(taxUtils.doGet(nationalGetUrl));
    },
	
	
	dojo.addOnLoad(function() {
		
		var nationalResourceData = [{postId: "id", 		postFieldValue: "nationalId"}, 
		                            {postId: "nameVn", 	postFieldValue: "nationalNameVn"},
		                            {postId: "nameEn", 	postFieldValue: "nationalNameEn"}
		                           ];
				
		var nationalParam = {
				dataGridId 			: 	"nationalDataGrid",
				formId 				: 	"nationalInputForm",
				addButtonId			:   "nationalAddButton",
				formTitle 			: 	"<spring:message code="label.Personalinformation.AddYourNational"/>",
			    getUrl 				: 	nationalGetUrl,
			    parentFieldId		: 	"personalNationalId",
			    parentFieldNameVn	: 	"personalNationalNameVn",
			    fieldNameId			: 	"nationalId",
			    fieldNameVn			: 	"nationalNameVn",
			    fieldNameEn			: 	"nationalNameEn",
			    Structure			:	nationalStructure,
			    resourcePost		:	nationalResourceData,
			    actions				:	nationalActions
			};		
		nationalPopupDialog = new custom.PopupDialog(nationalParam);
		
	});
	
		
	function openNationalGrid(){
		nationalPopupDialog.doOpenDialog();
	}
	
</script>