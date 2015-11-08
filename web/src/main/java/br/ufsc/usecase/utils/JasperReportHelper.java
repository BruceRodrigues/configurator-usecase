package br.ufsc.usecase.utils;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;

public class JasperReportHelper {

	public static byte[] buildReport(JasperReportBuilder report) {
		JasperReport jasperReport;
		try {
			jasperReport = report.toJasperReport();
			return JasperRunManager.runReportToPdf(jasperReport, report.getJasperParameters(), new JREmptyDataSource());
		} catch (DRException | JRException e) {
			e.printStackTrace();
		}
		return null;
	}

}