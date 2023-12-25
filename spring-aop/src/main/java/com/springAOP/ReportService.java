package com.springAOP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReportService {
	
	@Autowired
	@Qualifier("htmlGenerator")
	private ReportGenerator master;
	
	@Value("100")
	private int recordsPerPage;
	
	public void generateReport() {
		System.out.println("In Report Service generate method");
		if (recordsPerPage <= 0) {
            throw new ArithmeticException("No records to update");
        }
		String ret = master.generateReport(recordsPerPage);
		System.out.println("Value return by report:" + ret);
	}

}
