<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">

	dojo.require('dijit.form.Button');
	dojo.require("dijit.form.Form");
	dojo.require("dijit.form.ValidationTextBox");
	
	dojo.require("custom.TaxOnlineGrid");
	dojo.require("custom.CustomValidation");
	
	
	var exchangeRateUrl					= "<%=request.getContextPath()%>/personalinformation/exchangerate.html";
	var confirmationLetterInsuranceUrl	= "<%=request.getContextPath()%>/compulsoryContributionReport";
	var compulsUrl						= "<%=request.getContextPath()%>/compuls";
	var validation 						= custom.CustomValidation({"formId" : "compulsYearInputForm" });
	var employeeId						= "<%=request.getParameter("employeeId")%>" ;
	var currentYear						= new Date().getFullYear();
	
	function currencyAmountFormat(value, rowIdx){
		if(value!=0) {
			return taxUtils.getCurrencyValue(value, '');
		}
	}
	
	//http://localhost:8080/taxonline-webapp/personalinformation/exchangerate.html?employeeId=6
	
  	dojo.addOnLoad(function() {
  		
  		//Generate Report
	    dojo.connect(dijit.byId("pdfReportButton"), "onClick", function(event) {
	    	window.location = confirmationLetterInsuranceUrl+"?employeeId="+employeeId+"&year="+dijit.byId("compulsYear").value;
	    });
  		
	    dojo.connect(dijit.byId("compulsNextButton"), "onClick", function(event) {
	    	window.location = exchangeRateUrl+"?employeeId="+employeeId;
	    });
  		
	    
	  	//Create Compulsory
	    dojo.connect(dijit.byId("compulsAddButton"), "onClick", function(event) {
	    	var resourceData = {
	    		"employeeId"		: 	employeeId,
	    		"year"				: 	dijit.byId("compulsYear").value
	    	};

	        if(validation.check()) {
		    	taxUtils.doPost(compulsUrl+"/g", resourceData);
		    	compulsGrid.reloadGridPerUrl(compulsUrl + "/f?year="+dijit.byId("compulsYear").value+"&employeeId="+employeeId);
	        }
	    });
	    
		var compulsStructure = [{name : "Year", 	field : "year", 	'width': '20%', 	styles: 'text-align: right;'}, 
		                        {name : "Month", 	field : "month", 	'width': '20%', 	styles: 'text-align: right;'}, 
	        	 			    {name : "Amount",  	field : "amount",  	'width': '30%', 	styles: 'text-align: right;' , formatter: currencyAmountFormat, editable: true}]; 
		
		var compulsParam = {
				dataGridId 			: 	"compulsGrid",
				getUrl 				: 	compulsUrl,
				Structure			:	compulsStructure,
				actions				:	null
			};
		var compulsGrid = new custom.TaxOnlineGrid(compulsParam);
		
		//Apply Edit on the Grid
		dojo.connect(compulsGrid.dataGrid, 'doApplyEdit', function (inValue, inRowIndex) {
			dojo.byId('messageDiv').innerHTML = "";
			
			var item = compulsGrid.dataGrid.getItem(inValue);
					
			//Post Data Information
			var resourceData = {	"id"			: 	item.id[0], 
									"month"			: 	item.month[0], 
									"amount"		: 	item.amount[0], 
									"year"			: 	item.year[0],
									"currency"		: 	"USD",
									"employeeId"	:	employeeId
								};
			
			taxUtils.doPost(compulsUrl, resourceData);
			dojo.byId('messageDiv').innerHTML 	= 	"month: "+item.month[0]+" is updated";
		});
		
		
		//Update Grid with years
		var inputCompulsYear = dijit.byId("compulsYear");
		inputCompulsYear.attr('value', currentYear);
	    dojo.connect(inputCompulsYear, "onChange", function(event) {
            if(validation.check()) {
            	var url = compulsUrl + "/f?year="+inputCompulsYear.value+"&employeeId="+employeeId;
            	compulsGrid.reloadGridPerUrl(url);
            }
	    });
		
  	});
  	
  	
  
  	
</script>

<ul id="breadcrumb">
       <li><a href="<%=request.getContextPath()%>/home.html"><img src="<%=request.getContextPath()%>/static/jsp/layout/images/home.png" alt="Home" class="home" /></a></li>
       <li><a href="<%=request.getContextPath()%>/personalinformation.html">Personal Information</a></li>
       <li><a href="<%=request.getContextPath()%>/personalinformation/taxpay.html?employeeId=<%=request.getParameter("employeeId")%>">Tax Pay</a></li>
       <li>Compulsory Contribution</li>
</ul>
<br/>
<div dojoType="dijit.form.Form" id="compulsYearInputForm" jsId="compulsYearInputForm" encType="multipart/form-data" method="POST">
    <div id="tableform">
	    <table>
	        <tr>
	            <td>
	                <label for="taxYear"><spring:message code="label.Personalinformation.taxYear"/></label>
	            </td>
	            <td>
	                <input type="text" name="compulsYear" id="compulsYear" dojoType="dijit.form.ValidationTextBox" required="true"/>
	            </td>
	        </tr>
	        </tr>
	        	<td/>
	        	<td>
	    	        <button dojoType="dijit.form.Button" id="compulsAddButton" jsId="compulsAddButton"><spring:message code="label.Button.AddOrUpdate"/></button>
	    	        <button dojoType="dijit.form.Button" id="compulsNextButton" jsId="compulsNextButton">Next</button>
	            	<button dojoType="dijit.form.Button" id="pdfReportButton" jsId="pdfReportButton">PDF Report</button>
	            </td>
	        </tr>
	     </table>    
	</div>
</div>
<br/><br/>
<div id="guideDiv">
	* Please double click on the Amount field in the Grid to fill the Amount information
</div>
<table id="compulsGrid" dojoType="dojox.grid.DataGrid" style="width: 100%; height: 300px;" sortInfo="2"></table>
<div id="messageDiv"/>

