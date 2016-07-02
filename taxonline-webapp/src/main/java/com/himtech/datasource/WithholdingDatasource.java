package com.himtech.datasource;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSourceProvider;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import com.taxonline.core.domain.CompulsoryContribution;

public class WithholdingDatasource extends JRAbstractBeanDataSourceProvider {
	
	public WithholdingDatasource() {
		super(Withholding.class);
	}
	
	public JRDataSource create(List<CompulsoryContribution> list) throws JRException {

		List<Withholding> listWithholding = new ArrayList<Withholding>();
		
		for(CompulsoryContribution cc:list){
			String monthYear = cc.getMonth()+"/"+cc.getYear();
			String amount    = "";
			if(cc.getAmount()!=null) {
				amount = cc.getAmount().toString();
			}
			Withholding wh = new Withholding(monthYear, amount, cc.getCurrency().name(), amount);
			listWithholding.add(wh);
		}
		return new JRBeanCollectionDataSource(listWithholding);
	}

	@Override
	public JRDataSource create(JasperReport paramJasperReport)
			throws JRException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dispose(JRDataSource paramJRDataSource) throws JRException {
		// TODO Auto-generated method stub
		
	}

}
