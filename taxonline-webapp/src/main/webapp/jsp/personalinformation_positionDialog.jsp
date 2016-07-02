
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table id="positionDataGrid" dojoType="dojox.grid.DataGrid" style="width: 100%; height: 220px;"></table>

<div dojoType="dijit.form.Form" id="positionInputForm" jsId="positionInputForm" encType="multipart/form-data" action="<%=request.getContextPath()%>/json/position/addPos/" method="POST">
	<input type="text" name="positionId" id="positionId" hidden="true" type="hidden" />
	<table style="border: 1px solid #9f9f9f;" cellspacing="10">
		<tr>
			<td><label for="nameVn"><spring:message code="label.Personalinformation.NameVN"/>:</td>
			<td><input type="text" name="positionNameVn" id="positionNameVn" dojoType="dijit.form.ValidationTextBox" />
			</td>
		</tr>
		<tr>
			<td><label for="nameEn"><spring:message code="label.Personalinformation.NameEN"/>:</td>
			<td><input type="text" name="positionNameEn" id="positionNameEn" dojoType="dijit.form.ValidationTextBox" /></td>
		</tr>	
	</table>
	<button dojoType="dijit.form.Button" id="positionAddButton" jsId="positionAddButton"><spring:message code="label.Button.AddOrUpdate"/></button>
</div>

<script type="text/javascript">

	dojo.require("custom.PopupDialog");
	
	var positionGetUrl = "<%=request.getContextPath()%>/position";
	var positionPopupDialog = {};
	var positionStructure = 	[
	                        	 {name : "NameVn", field : "nameVn", 'width': '30%'}, 
	        	 			  	 {name : "NameEn", field : "nameEn", 'width': '30%'}
	                        	];
	positionActions = {};
	
	positionActions.names = ["Select", "Edit" , "Delete"];
	positionActions.doSelect = function(item) {
        dojo.byId("personalPositionId").value = item.id[0];
        dojo.byId("personalPositionNameVn").value = item.nameVn[0];
        positionPopupDialog.dialog.hideDialog();
	};
	positionActions.doEdit = function(item) {
    	dojo.byId("positionNameEn").value = item.nameVn[0];
        dojo.byId("positionNameVn").value = item.nameEn[0];
        dojo.byId("positionId").value = item.id[0];    	
    };
    positionActions.doDelete = function(item) {
        taxUtils.doDelete(positionGetUrl +'/'+item.id[0]);
        positionPopupDialog.customGrid.loadGrid(taxUtils.doGet(positionGetUrl));
    };
	
	dojo.addOnLoad(function() {
		var positionResourceData = [	 
		                            {postId: "id", 		postFieldValue: "positionId"}, 
		                            {postId: "nameVn", 	postFieldValue: "positionNameVn"},
		                            {postId: "nameEn", 	postFieldValue: "positionNameEn"}
		                           ];
		
		var positionParam = {
				dataGridId 			: 	"positionDataGrid",
				formId 				: 	"positionInputForm",
				addButtonId			:   "positionAddButton",
				formTitle 			: 	"<spring:message code="label.Personalinformation.Addyourosition"/>",
			    getUrl 				: 	positionGetUrl,
			    parentFieldId		: 	"personalPositionId",
			    parentFieldNameVn	: 	"personalPositionNameVn",
			    fieldNameId			: 	"positionId",
			    fieldNameVn			: 	"positionNameVn",
			    fieldNameEn			: 	"positionNameEn",
			    Structure			:	positionStructure,
			    resourcePost		:	positionResourceData,
			    actions				:   positionActions
			};		
		positionPopupDialog = new custom.PopupDialog(positionParam);
		
	});
	
	function openPositionGrid(){
		positionPopupDialog.doOpenDialog();
	}
	
</script>