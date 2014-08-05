package controllers;

import java.io.File;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;

public class FrmReport {

	private String report;
	private String reportTitle;
	private File file;

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	@Init
	public void init(@ExecutionArgParam("reportPath") String reportPath, @ExecutionArgParam("reportTitle") String title, @ExecutionArgParam("absolutePath") String absolutePath, @ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		report = new String(reportPath);
		reportTitle = new String(title);
		file = new File(absolutePath);
	}

	@Command
	public void close() {
		if (!file.delete())
			System.out.println("No se pudo eliminar el archivo.");
	}
}