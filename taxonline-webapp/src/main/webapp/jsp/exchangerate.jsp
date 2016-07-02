<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">

	dojo.require('dijit.form.Button');
	dojo.require("dijit.form.Form");
	dojo.require("dijit.form.ValidationTextBox");
	
	dojo.require("custom.TaxOnlineGrid");
	dojo.require("custom.CustomValidation");
	
	var exchangeRateUrl					= "<%=request.getContextPath()%>/exrate";
	var validation 						= custom.CustomValidation({"formId" : "exchangeRateInputForm" });
	var employeeId						= "<%=request.getParameter("employeeId")%>" ;
	var currentYear						= new Date().getFullYear();	
	
	function currencyAmountFormat(value, rowIdx){
		if(value!=0) {
			return taxUtils.getCurrencyValue(value, '');
		}
	}
	
  	dojo.addOnLoad(function() {
  		
  		dijit.byId('exchangeRateCY').attr('value', 'USD');
  		
		var exchangeRateStructure = [{name : "Year", 		field : "year", 	'width': '20%', 	styles: 'text-align: right;'}, 
		                          	 {name : "Month", 		field : "month", 	'width': '20%', 	styles: 'text-align: right;'}, 
	        	 			    	 {name : "Rate", 		field : "rate",  	'width': '30%', 	styles: 'text-align: right;' , formatter: currencyAmountFormat, editable: true}]; 

		var exchangeRateParam = {
				dataGridId 			: 	"exchangeRateGrid",
				getUrl 				: 	exchangeRateUrl,
				Structure			:	exchangeRateStructure,
				actions				:	null
			};
		
		var exchangeRateGrid = new custom.TaxOnlineGrid(exchangeRateParam);
		dojo.connect(exchangeRateGrid.dataGrid, 'doApplyEdit', function (inValue, inRowIndex) {
			dojo.byId('messageDiv').innerHTML = "";
			
			var item = exchangeRateGrid.dataGrid.getItem(inValue);
					
			//Post Data Information
			var resourceData = {	"id"			: 	item.id[0], 
									"month"			: 	item.month[0], 
									"rate"			: 	item.rate[0], 
									"year"			: 	item.year[0],
									"currency"		: 	dijit.byId("exchangeRateCY").value
								};
			
			taxUtils.doPost(exchangeRateUrl, resourceData);
			dojo.byId('messageDiv').innerHTML 	= 	"month: "+item.month[0]+" is updated";
		});
		
		
		//Create exchangeRateory
	    dojo.connect(dijit.byId("exchangeRateAddButton"), "onClick", function(event) {
	    	var resourceData = {
	    		"year"				: 	dijit.byId("exchangeRateYear").value,
	    		"currency"			: 	dijit.byId("exchangeRateCY").value
	    	};

	        if(validation.check()) {
		    	taxUtils.doPost(exchangeRateUrl+"/g", resourceData);
		    	exchangeRateGrid.reloadGridPerUrl(exchangeRateUrl + "/f?year="+dijit.byId("exchangeRateYear").value);
	        }
	    });
		
	  	//Update Grid with years
		var inputExchangeRateYear = dijit.byId("exchangeRateYear");
		inputExchangeRateYear.attr('value', currentYear);
	    dojo.connect(inputExchangeRateYear, "onChange", function(event) {
            if(validation.check()) {
            	var url = exchangeRateUrl + "/f?year="+inputExchangeRateYear.value;
            	exchangeRateGrid.reloadGridPerUrl(url);
            }
	    });
		
		
  	});
	
</script>

<ul id="breadcrumb">
       <li><a href="<%=request.getContextPath()%>/home.html"><img src="<%=request.getContextPath()%>/static/jsp/layout/images/home.png" alt="Home" class="home" /></a></li>
       <li><a href="<%=request.getContextPath()%>/personalinformation.html">Personal Information</a></li>
       <li><a href="<%=request.getContextPath()%>/personalinformation/taxpay.html?employeeId=<%=request.getParameter("employeeId")%>">Tax Pay</a></li>
       <li><a href="<%=request.getContextPath()%>/compulsorycontribution.html?employeeId=<%=request.getParameter("employeeId")%>">Compulsory Contribution</a></li>
       <li>Exchange Rate</li>
</ul>
<br/>
<div dojoType="dijit.form.Form" id="exchangeRateInputForm" jsId="exchangeRateInputForm" encType="multipart/form-data" method="POST">
    <div id="tableform">
	    <table>
	        <tr>
	            <td>
	                <label for="taxYear"><spring:message code="label.Personalinformation.taxYear"/></label>
	            </td>
	            <td>
	                <input type="text" name="exchangeRateYear" id="exchangeRateYear" dojoType="dijit.form.ValidationTextBox" required="true"/>
	            </td>
	        <tr/>
	        <tr>
	            <td>
	                <label for="taxYear"><spring:message code="label.Personalinformation.taxCurrency" text="Currency"/></label>
	            </td>
	            <td>
	                <input type="text" name="exchangeRateCY"   id="exchangeRateCY" dojoType="dijit.form.ValidationTextBox" required="true"/>
	            </td>
	        </tr>
	        <tr>
	            <td/>
	            <td colspan="2">
	            	<button dojoType="dijit.form.Button" id="exchangeRateAddButton" jsId="exchangeRateAddButton"><spring:message code="label.Button.AddOrUpdate"/></button>
	    	        <button dojoType="dijit.form.Button" id="exchangeRateNextButton" jsId="exchangeRateNextButton">Next</button>
	            </td>            
	        </tr>
	     </table>    
	</div>
</div>

<br/><br/>


<div id="guideDiv">
	* Please double click on the Amount field in the Grid to fill the Amount information
</div>
<table id="exchangeRateGrid" dojoType="dojox.grid.DataGrid" style="width: 100%; height: 300px;" sortInfo="2"></table>
<div id="messageDiv"/>


