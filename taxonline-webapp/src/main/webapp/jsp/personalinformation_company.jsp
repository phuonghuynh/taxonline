
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table id="companyDataGrid" dojoType="dojox.grid.DataGrid" style="width: 100%; height: 220px;"></table>

<div dojoType="dijit.form.Form" id="companyInputForm" jsId="companyInputForm" encType="multipart/form-data" action="" method="POST">
	<input type="text" name="companyId" id="companyId" hidden="true" type="hidden" />
	<table style="border: 1px solid #9f9f9f;" cellspacing="10">
		<tr>
			<td><label for="nameVn"><spring:message code="label.Personalinformation.NameVN"/>:</td>
			<td><input type="text" name="companyNameVn" id="companyNameVn" dojoType="dijit.form.ValidationTextBox" />
			</td>
		</tr>
		<tr>
			<td><label for="nameEn"><spring:message code="label.Personalinformation.NameEN"/>:</td>
			<td><input type="text" name="companyNameEn" id="companyNameEn" dojoType="dijit.form.ValidationTextBox" /></td>
		</tr>	
	</table>
	<button dojoType="dijit.form.Button" id="companyAddButton" jsId="companyAddButton"><spring:message code="label.Button.AddOrUpdate"/></button>
</div>

<script type="text/javascript">

	dojo.require("custom.PopupDialog");
	
	var companyGetUrl = "<%=request.getContextPath()%>/company";
	var companyPopupDialog = {};
	var companyStructure = [{name : "NameVn", field : "nameVn", 'width': '30%'}, 
	        	 			{name : "NameEn", field : "nameEn", 'width': '30%'}];
	
	var companyActions = {};
	companyActions.names = ["Select", "Edit" , "Delete"];
	companyActions.doSelect = function(item) {
        dojo.byId("personalCompanyId").value = item.id[0];
        dojo.byId("personalCompanyNameVn").value = item.nameVn[0];
        companyPopupDialog.dialog.hideDialog();
	};
	companyActions.doEdit = function(item) {
    	dojo.byId("companyNameEn").value = item.nameVn[0];
        dojo.byId("companyNameVn").value = item.nameEn[0];
        dojo.byId("companyId").value = item.id[0];    	
    };
    companyActions.doDelete = function(item) {
        taxUtils.doDelete(companyGetUrl +'/'+item.id[0]);
        companyPopupDialog.customGrid.loadGrid(taxUtils.doGet(companyGetUrl));
    },
	
	
	dojo.addOnLoad(function() {
		var companyResourceData = [	  {postId: "id", 		postFieldValue: "companyId"}, 
		                              {postId: "nameVn", 	postFieldValue: "companyNameVn"},
		                              {postId: "nameEn", 	postFieldValue: "companyNameEn"}
		                           ];
		
		var companyParam = {
				dataGridId 			: 	"companyDataGrid",
				formId 				: 	"companyInputForm",
				addButtonId			:   "companyAddButton",
				formTitle 			: 	"<spring:message code="label.Personalinformation.AddYourCompany"/>",
			    getUrl 				: 	companyGetUrl,
			    parentFieldId		: 	"personalCompanyId",
			    parentFieldNameVn	: 	"personalCompanyNameVn",
			    fieldNameId			: 	"companyId",
			    fieldNameVn			: 	"companyNameVn",
			    fieldNameEn			: 	"companyNameEn",
			    Structure			:	companyStructure,
			    resourcePost		:	companyResourceData,
			    actions				:	companyActions
			    
			};		
		companyPopupDialog = new custom.PopupDialog(companyParam);
	});
	
		
	function openCompanyGrid(){
		companyPopupDialog.doOpenDialog();
	}
	
</script>