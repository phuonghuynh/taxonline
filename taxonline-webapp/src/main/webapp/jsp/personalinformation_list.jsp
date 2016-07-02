
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<table id="employeeDataGrid" dojoType="dojox.grid.DataGrid" style="width: 100%; height: 220px;"></table>

<script type="text/javascript">

	dojo.require("custom.TaxOnlineGrid");
	
	var employeeGetUrl 						= "<%=request.getContextPath()%>/employee";
	var taxpayPageUrl 						= "<%=request.getContextPath()%>/personalinformation/taxpay.html";
	var confirmationLetterInsurancePageUrl 	= "<%=request.getContextPath()%>/personalinformation/confirmationLetterInsurancePage.html";
	
	var employeePopupDialog = {};
	var employeeStructure = [  {name : "First Name", field : "firstName", 'width': '30%'}, 
	        	 			   {name : "Last Name",  field : "lastName",  'width': '30%'}];
	
	var employeeActions = {};
	employeeActions.names = ["Select", "Edit"];
	employeeActions.doSelect = function(item) {
		window.location = taxpayPageUrl + "?employeeId="+item.id[0];
	};
	employeeActions.doEdit = function(item) {  	
    };
    
	dojo.addOnLoad(function() {
		var employeeResourceData = [  {postId: "id", 		postFieldValue: "employeeId"}, 
		                              {postId: "nameVn", 	postFieldValue: "employeeNameVn"},
		                              {postId: "nameEn", 	postFieldValue: "employeeNameEn"}
		                           ];
		
		var employeeParam = {
				dataGridId 			: 	"employeeDataGrid",
				getUrl 				: 	employeeGetUrl,
				Structure			:	employeeStructure,
				actions				:	employeeActions
			};
		
		employeeGrid = new custom.TaxOnlineGrid(employeeParam);
		
	});
	
</script>