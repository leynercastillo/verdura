package general;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;

public class GenericReport {

	private File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	private Connection getConnection() {
		Properties dbProperties = new Properties();
		try {
			dbProperties.load(this.getClass().getClassLoader().getResourceAsStream("/configuration/database.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Class.forName(dbProperties.getProperty("db.driverClass"));
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Connection connection;
		try {
			connection = DriverManager.getConnection(dbProperties.getProperty("db.jdbcUrl"), dbProperties.getProperty("db.user"), dbProperties.getProperty("db.password"));
		} catch (SQLException e) {
			connection = null;
			e.printStackTrace();
		}
		return connection;
	}

	public void createPdf(String reportPath, String reportName, Map<String, Object> parameters, String pdfName) {
		Connection connection = getConnection();
		String path = Sessions.getCurrent().getWebApp().getRealPath(reportPath);
		JasperReport jasperReport;
		try {
			jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path + "/" + reportName);
		} catch (JRException e1) {
			jasperReport = null;
			e1.printStackTrace();
		}
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
		} catch (JRException e1) {
			jasperPrint = null;
			e1.printStackTrace();
		}
		JRExporter jrExporter = new JRPdfExporter();
		jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		jrExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, path + "/" + pdfName);
		// Buscamos un archivo con el mismo nombre en el mismo directorio.
		File file = new File(path + "/" + pdfName);
		// Eliminamos el pdf si ya existia, puesto que no se sobreescribe.
		if (file.isFile())
			file.delete();
		try {
			jrExporter.exportReport();
		} catch (JRException e) {
			System.out.println("Report wasn't export." + pdfName);
		}
		// Guardamos el archivo en la variable global para que este disponible.
		this.file = new File(path + "/" + pdfName);
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewPdf(String pdfFullPath, String reportTitle) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reportPath", pdfFullPath);
		map.put("reportTitle", reportTitle);
		map.put("absolutePath", Sessions.getCurrent().getWebApp().getRealPath(pdfFullPath));
		Executions.createComponents("system/frmReport.zul", null, map);
	}
}