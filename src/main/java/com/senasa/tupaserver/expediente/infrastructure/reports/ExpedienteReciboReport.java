package com.senasa.tupaserver.expediente.infrastructure.reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

public class ExpedienteReciboReport {
  public ExpedienteReciboReport(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  JdbcTemplate jdbcTemplate;

  @SuppressWarnings("null")
  public byte[] render(String id) throws FileNotFoundException, IOException, JRException, SQLException {
    ClassPathResource resource = new ClassPathResource("reports/reciboPago2.jasper");
    FileInputStream inputStream = new FileInputStream(resource.getFile());
    JasperReport jasperReport = (JasperReport) JRLoader.loadObject(inputStream);
    Connection connection = jdbcTemplate.getDataSource().getConnection();
    Map<String, Object> parameters = new HashMap<>();
    parameters.put("PCODRECIBO", id);
    parameters.put("REPORT_CONNECTION", connection);
    parameters.put("SUBREPORT_DIR", "/u01/reportesJasper/");
    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
    return JasperExportManager.exportReportToPdf(jasperPrint);
  }
}
