package com.springAOP;

import org.springframework.stereotype.Component;

@Component(value = "pdfGenerator")
public class PDFReportGenerator implements ReportGenerator {

	@Override
	public String generateReport(int recordsPerPage) {
		// TODO Auto-generated method stub
		return "Generated PDF Report with " + recordsPerPage + " records";
	}

}
