package uml-dop.report.priorityreport.model;

import java.util.*;
import java.lang.*;
import id.ac.ui.cs.prices.winvmj.core.Route;
import id.ac.ui.cs.prices.winvmj.core.VMJExchange;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;

import uml-dop.report.core.model.ReportDecorator;
import uml-dop.report.core.model.Report;
import uml-dop.report.core.model.ReportComponent;

@Entity(name="report_priorityreport")
@Table(name="report_priorityreport")
public class ReportImpl extends ReportDecorator {

	public PriorityReport PriorityReport;
	public ReportImpl() {
        super();
		Random r = new Random();
		this. = Math.abs(r.nextInt());
        this.objectName = ReportImpl.class.getName();
    }

	public ReportImpl(ReportComponent record, PriorityReport PriorityReport) {
		super(record, ReportImpl.class.getName());
		this.PriorityReport = PriorityReport;
		this.objectName = ReportImpl.class.getName();
	}



	public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> map = record.toHashMap();
        map.put("reportId", reportId);
		map.put("PriorityReport", getPriorityReport());

        return map;
    }

}
