
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<ul id="breadcrumb">
       <li><a href="<%=request.getContextPath()%>/home.html"><img src="<%=request.getContextPath()%>/static/jsp/layout/images/home.png" alt="Home" class="home" /></a></li>
       <li><a href="<%=request.getContextPath()%>/personalinformation.html">Personal Information</a></li>
       <li>Tax Pay</li>
</ul>

<br/>

<h3><div id="employeeIdDiv"/> </h3>

<div dojoType="dijit.form.Form" id="taxPayYearInputForm" jsId="taxPayYearInputForm" encType="multipart/form-data" method="POST">
    
    <div id="tableform">
	    <table>
	        <tr>
	            <td>
	                <label for="taxYear"><spring:message code="label.Personalinformation.taxYear"/></label>
	            </td>
	            <td>
	                <input type="text" name="taxYear" id="taxYear" dojoType="dijit.form.ValidationTextBox" required="true"/>
	            </td>
	            <td>
	    	        <button dojoType="dijit.form.Button" id="taxPayAddButton" jsId="taxPayAddButton"><spring:message code="label.Button.AddOrUpdate"/></button>
	            </td>
	            <td>
	    	        <button dojoType="dijit.form.Button" id="taxPayNextButton" jsId="taxPayNextButton">Next</button>
	            </td>	            
	        </tr>
	     </table>    
	</div>
</div>

<br/><br/>
<div id="guideDiv">
	* Please double click on the Amount field in the Grid to fill the Amount information
</div>

<table id="taxPayDataGrid" dojoType="dojox.grid.DataGrid" style="width: 100%; height: 300px;" sortInfo="2"></table>

<div id="messageDiv"/>

<script type="text/javascript">

	dojo.require('dijit.form.Button');
	dojo.require("dijit.form.Form");
	dojo.require("dijit.form.ValidationTextBox");
	dojo.require("dijit.form.DateTextBox");	
	dojo.require("dijit.form.NumberTextBox");
	dojo.require("custom.CustomValidation");
	dojo.require("custom.TaxOnlineGrid");
	dojo.require("dijit.form.Select");
	
	var taxPayGetUrl 						= 	"<%=request.getContextPath()%>/taxpaid";
	var employeeGetUrl 						= 	"<%=request.getContextPath()%>/employee";
	var compulsoryContributionUrl 			= 	"<%=request.getContextPath()%>/compulsorycontribution.html";
	
	var taxPayAddButtonId 					= 	"taxPayAddButton";
	var taxPayNextStepButtonId 				= 	"taxPayNextStepButton";
	var taxPayInputFormId					=	"taxPayYearInputForm";
	var taxPayNextButtonId					=	"taxPayNextButton";
	
	var validation 							= 	custom.CustomValidation({"formId" : taxPayInputFormId });
	var taxPayGrid							=   {};
	var employeeId							= 	"<%=request.getParameter("employeeId")%>";
	var employeeInfo						= 	taxUtils.doGet(employeeGetUrl +'/'+employeeId);
	
	function currencyAmountFormat(value, rowIdx){
		if(value!=0) {
			return taxUtils.getCurrencyValue(value, '');
		}
	}

	
	var taxPayStructure = [{name : "Year", 			field : "year", 		'width': '20%', styles: 'text-align: right;'}, 
	                       {name : "Month", 		field : "month", 		'width': '20%', styles: 'text-align: right;'}, 
        	 			   {name : "Amount",  		field : "amount",  		'width': '30%', styles: 'text-align: right;', formatter: currencyAmountFormat, editable: true},
	                       {name : "Reference",  	field : "reference",  	'width': '30%', styles: 'text-align: left;', editable: true}
	                      ];        
		
	dojo.addOnLoad(function() {
	
		
		dojo.byId('employeeIdDiv').innerHTML 	= 	'Employee: '+ employeeInfo.firstName +" "+ employeeInfo.lastName;
		var inputTaxYear 						= 	dijit.byId("taxYear");
        var currentYear							= 	new Date().getFullYear();
        inputTaxYear.value						=	currentYear;
        
        
		var taxPayParam = {
				dataGridId 			: 	"taxPayDataGrid",
				getUrl 				: 	taxPayGetUrl + "/f?year="+currentYear+"&employeeId="+employeeId,
				Structure			:	taxPayStructure,
				actions				:	null
			};
		var taxPayGrid = new custom.TaxOnlineGrid(taxPayParam);	
		
		//Apply Edit on the Grid
		dojo.connect(taxPayGrid.dataGrid, 'doApplyEdit', function (inValue, inRowIndex) {
			dojo.byId('messageDiv').innerHTML = "";
			
			var item = taxPayGrid.dataGrid.getItem(inValue);
					
			//Post Data Information
			var resourceData = {	"id"			: 	item.id[0], 
									"month"			: 	item.month[0], 
									"amount"		: 	item.amount[0], 
									"reference"		:	item.reference[0],
									"year"			: 	inputTaxYear.value,
									"employeeId"	:	employeeId
								};
			
			taxUtils.doPost(taxPayGetUrl, resourceData);
			dojo.byId('messageDiv').innerHTML 	= 	"month: "+item.month[0]+" is updated";
		});
		
		
		
	    //Create Tax Paid
	    var buttonTaxPay = dijit.byId("taxPayAddButton");
	    dojo.connect(buttonTaxPay, "onClick", function(event) {
	    	var resourceData = {
	    		"year"			:	inputTaxYear.value,
	    		"employeeId"	:	employeeId
	    	};

            var resultValidate = validation.check();
            if(resultValidate) {
    	    	taxUtils.doPost(taxPayGetUrl+"/g", resourceData);
    	    	
            	var url = taxPayGetUrl + "/f?year="+inputTaxYear.value+"&employeeId="+employeeId;
            	taxPayGrid.reloadGridPerUrl(url);
            }
	    });
	    
	    
	  	//Get Next
	    var buttonTaxPayNext = dijit.byId("taxPayNextButton");
	    dojo.connect(buttonTaxPayNext, "onClick", function(event) {
	    	var url = compulsoryContributionUrl + "?employeeId="+employeeId;
	    	window.location = url;
	    });
	    
	    //Update Grid with years
	    inputTaxYear.attr('value', currentYear);
	    dojo.connect(inputTaxYear, "onChange", function(event) {
            var resultValidate = validation.check();
            if(resultValidate) {
            	var url = taxPayGetUrl + "/f?year="+inputTaxYear.value+"&employeeId="+employeeId;
            	taxPayGrid.reloadGridPerUrl(url);
            }
	    });
		
	});
	    
</script>