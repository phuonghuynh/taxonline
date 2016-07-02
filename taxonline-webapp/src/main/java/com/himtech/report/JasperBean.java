package com.himtech.report;

import java.util.List;

import javax.annotation.Resource;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.himtech.datasource.WithholdingDatasource;
import com.kdtax.utils.DateUtils;
import com.taxonline.core.domain.CompulsoryContribution;
import com.taxonline.core.domain.Employee;
import com.taxonline.core.repo.CurrencyEntityRepo;

@Controller
public class JasperBean {
	
	private JRDataSource jrDatasource;
	
	@Resource
	private CurrencyEntityRepo currencyEntityRepo;

	public JasperBean() throws JRException {
	}

	@RequestMapping(value = "/compulsoryContributionReport", method = RequestMethod.GET)
	public String printCompulsoryContributionReport(ModelMap model, @RequestParam("employeeId") Long employeeId,
	         @RequestParam("year") Integer year) throws JRException {
		
		WithholdingDatasource withholding = new WithholdingDatasource();
		
		List<CompulsoryContribution> list = (List<CompulsoryContribution>) currencyEntityRepo.findInPeriod(
	            CompulsoryContribution.class, 1, 12, year, employeeId, null);
		
		Employee employee = new Employee();
		if(list!=null && list.size() > 0){
			CompulsoryContribution compulsoryContri = list.get(0);
			employee = compulsoryContri.getEmployee();
		}
		
		
		jrDatasource = withholding.create(list);
		
		model.addAttribute("datasource", jrDatasource);
		model.addAttribute("format", "pdf");
		
		model.addAttribute("countryName", "VietName/Viet Nam");
		model.addAttribute("taxOfficer_vn", "TP Ho Chi Minh");
		model.addAttribute("taxOfficer_en", "Ho Chi Minh City");
		
		model.addAttribute("fullName", employee.getLastName() +" "+employee.getFirstName() );
		model.addAttribute("national", employee.getNational().getNameVn());
		model.addAttribute("taxCode", employee.getTaxcode());
		model.addAttribute("period", DateUtils.getMonthYear(employee.getArrivalDate())+" - "+DateUtils.getMonthYear(employee.getTerminationDate()));
		
		return "compulsoryContributionReport";
	}
}
