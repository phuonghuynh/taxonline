<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<script type="text/javascript">

	dojo.require('dijit.form.Button');
	dojo.require("dijit.form.Form");
	dojo.require("dijit.form.Button");
	dojo.require("dijit.form.ValidationTextBox");
	dojo.require("dijit.form.DateTextBox");	
	dojo.require("dijit.form.TextBox");
	dojo.require("dijit.form.NumberTextBox");
	dojo.require("custom.CustomValidation");
		

	var validation 					= 	custom.CustomValidation({"formId" : "personalInputForm" });

	var personalGetUrl 				= 	"<%=request.getContextPath()%>/employee";
	var personalAddButtonId 		= 	"personalAddButton";
	var personalNextStepButtonId 	= 	"personalNextStepButton";
	var personalInputFormId 		= 	"personalInputForm";
	
	dojo.addOnLoad(function() {
	    
	    //Post Data Information
        var button = dijit.byId(personalAddButtonId);
        dojo.connect(button, "onClick", function(event) {
        	
        	var dobVal = taxUtils.dateFormat('dob');
        	var arrivalDateVal = taxUtils.dateFormat('arrivalDate');
        	var terminationDateVal = taxUtils.dateFormat('terminationDate');
            
            var resourceData = {
                    "firstName" 		: dojo.byId('firstName').value,
                    "lastName"  		: dojo.byId('lastName').value,
                    "taxcode"   		: dojo.byId('taxCode').value,
                    "dob"				: dobVal,
                    "nod"				: dojo.byId('numberOfDependant').value,
                    "pwdno"				: dojo.byId('passportNumber').value,
                    "arrivalDate"		: arrivalDateVal,
                    "terminationDate"	: terminationDateVal,
                    "positionId"		: dojo.byId('personalPositionId').value,
                    "nationalId"		: dojo.byId('personalNationalId').value,
    				"compulsoryInsuranceNationalId"	: dojo.byId('personalCiNationalId').value,
    				"taxOfficeId"		: dojo.byId('personalTaxOfficeId').value
            };
            
            var resultValidate = validation.check();
            if(resultValidate) {
            	taxUtils.doPost(personalGetUrl, resourceData);            
                taxUtils.clearForm(personalInputFormId);	
                
                //Update Employee Grid
                employeeGrid.reloadGrid();
            }
            
        });
	    
	});
	
	
</script>

<!-- FORM SUBMIT -->


<ul id="breadcrumb">
       <li><a href="<%=request.getContextPath()%>/home.html"><img src="<%=request.getContextPath()%>/static/jsp/layout/images/home.png" alt="Home" class="home" /></a></li>
       <li>Personal Information</li>
</ul>

<br/>

<div dojoType="dijit.form.Form" id="personalInputForm" jsId="personalInputForm" encType="multipart/form-data" method="POST">
    
    <div id="tableform">
	    <table>
	        <tr>
	            <td>
	                <label for="firstName"><spring:message code="label.Personalinformation.FirstName"/></label>
	            </td>
	            <td>
	                <input type="text" name="firstName" id="firstName" dojoType="dijit.form.ValidationTextBox" required="true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <label for="lastName"><spring:message code="label.Personalinformation.LastName"/></label>
	            </td>
	            <td>
	                <input type="text" name="lastName" id="lastName" dojoType="dijit.form.ValidationTextBox" required="true"/>
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <label for="position"><spring:message code="label.Personalinformation.Position"/></label>
	            </td>
	            <td>
	            	<input type="hidden" id="personalPositionId" name="personalPositionId"/>
	            	<input type="text"   id="personalPositionNameVn" name="personalPositionVn" 
	               		dojoType="dijit.form.TextBox" onfocus="openPositionGrid()"
	            		placeHolder="<spring:message code="label.Personalinformation.clickToEditPosition"/>" />
	            </td>
	        </tr>   
	        <tr>
	            <td>
	                <label for="taxCode"><spring:message code="label.Personalinformation.TaxCode"/></label>
	            </td>
	            <td>
	                <input type="text" name="taxCode" id="taxCode" dojoType="dijit.form.NumberTextBox" required="true" 
	                	maxlength="10" constraints="{pattern: '0000000000' }" invalidMessage="<spring:message code="label.invalid.TaxCodeMustBe10Digits"/>" />
	            </td>
	        </tr>
	        <tr>
	            <td>
	                <label for="dob"><spring:message code="label.Personalinformation.DayOfBirth"/></label>
	            </td>
	            <td>
	                <input type="text" name="dob" id="dob" dojoType="dijit.form.DateTextBox" required="true"/>
	            </td>
	        </tr> 
	        <tr>
	            <td>
	                <label for="numberOfDependant"><spring:message code="label.Personalinformation.NumberOfDependant"/></label>
	            </td>
	            <td>
	                <input type="text" name="numberOfDependant" id="numberOfDependant" dojoType="dijit.form.NumberTextBox" 
	                maxlength="10" constraints="{pattern: '00', mmin:0, max:99}" invalidMessage="<spring:message code="label.invalid.DependentMustBe2Digits"/>" />
	            </td>
	        </tr> 
	        <tr>
	            <td>
	                <label for="passportNumber"><spring:message code="label.Personalinformation.passportNumber"/></label>
	            </td>
	            <td>
	                <input type="text" name="passportNumber" id="passportNumber" dojoType="dijit.form.ValidationTextBox"/>
	            </td>
	        </tr>        
	        <tr>
	            <td>
	                <label for="arrivalDate"><spring:message code="label.Personalinformation.arrivalDate"/></label>
	            </td>
	            <td>
	                <input type="text" name="arrivalDate" id="arrivalDate" dojoType="dijit.form.DateTextBox" required="true"/>
	            </td>
	        </tr>         
	        <tr>
	            <td>
	                <label for="terminationDate"><spring:message code="label.Personalinformation.terminationDate"/></label>
	            </td>
	            <td>
	                <input type="text" name="terminationDate" id="terminationDate" dojoType="dijit.form.DateTextBox" required="true"/>
	            </td>
	        </tr>
	        
	        <tr>
	            <td>
	                <label for="national"><spring:message code="label.Personalinformation.National"/></label>
	            </td>
	            <td>
	            	<input type="hidden" id="personalNationalId" name="personalNationalId"/>
	            	<input type="text"   id="personalNationalNameVn" name="personalNationalNameVn" 
	            		dojoType="dijit.form.TextBox" onclick="openNationalGrid();" 
	            		placeHolder="<spring:message code="label.Personalinformation.clickToEditNational"/>" />
	                
	            </td>
	        </tr>
	        
	        <tr>
	            <td>
	                <label for="national"><spring:message code="label.Personalinformation.CINational"/></label>
	            </td>
	            <td>
	            	<input type="hidden" id="personalCiNationalId" name="personalCiNationalId"/>
	            	<input type="text"   id="personalCiNationalNameVn" name="personalCiNationalNameVn"
	            		dojoType="dijit.form.TextBox" onclick="openCINationalGrid();"
	            		placeHolder="<spring:message code="label.Personalinformation.clickToEditNational"/>" />
	            </td>
	        </tr>                          
	
	        <tr>
	            <td>
	                <label for="personalTaxOfficeId"><spring:message code="label.Personalinformation.TaxOffice"/></label>
	            </td>
	            <td>
	            	<input type="hidden" id="personalTaxOfficeId" name="personalTaxOfficeId"/>
	            	<input type="text"   id="personalTaxOfficeNameVn" name="personalTaxOfficeNameVn"
	            		dojoType="dijit.form.TextBox" onclick="openTaxOfficeGrid();"
	            		placeHolder="<spring:message code="label.Personalinformation.clickToEditNational"/>" />
	            </td>
	        </tr>
	        
	        <tr>
	            <td>
	                <label for="company"><spring:message code="label.Personalinformation.Company"/></label>
	            </td>
	            <td>
	            	<input type="hidden" id="personalCompanyId" name="personalCompanyId"/>
	            	<input type="text"   id="personalCompanyNameVn" name="personalCompanyNameVn" 
	            		dojoType="dijit.form.TextBox" onclick="openCompanyGrid();"
	            		placeHolder="<spring:message code="label.Personalinformation.clickToEditCompany"/>" /> 
	            </td>
	        </tr>         
	    </table>
	    
	    <div align="right">
	    	<button dojoType="dijit.form.Button" id="personalAddButton" jsId="personalAddButton"><spring:message code="label.Button.AddOrUpdate"/></button>
	    </div>
	</div>
</div>

<br/>

<c:import url="../personalinformation_list.jsp"/>
<c:import url="../personalinformation_positionDialog.jsp"/>
<c:import url="../personalinformation_cinationalDialog.jsp"/>
<c:import url="../personalinformation_nationalDialog.jsp"/>
<c:import url="../personalinformation_taxOfficeDialog.jsp"/>
<c:import url="../personalinformation_company.jsp"/>