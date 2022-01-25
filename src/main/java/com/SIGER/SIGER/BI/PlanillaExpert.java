package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.model.entities.Boleta;
import com.SIGER.SIGER.model.entities.Empleado;
import com.SIGER.SIGER.model.entities.Licencia;
import com.SIGER.SIGER.model.entities.Planilla;
import com.SIGER.SIGER.services.BoletaService;
import com.SIGER.SIGER.services.EmpleadoService;
import com.SIGER.SIGER.services.LicenciaService;
import com.SIGER.SIGER.services.PlanillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PlanillaExpert {
    @Autowired
    BoletaService _Boleta;
    @Autowired
    LicenciaService _Licencia;
    @Autowired
    EmpleadoService _Employees;
    @Autowired
    PlanillaService _Sheets;

    public void processingSheets() throws Exception{

        List<Planilla> sheets = new ArrayList<Planilla>();
        List<Empleado> employees = _Employees.findAll();

        for (Empleado employee: employees) {

            processingBallots(sheets, employee);
            processingLicenses(sheets, employee);

        }

        this.saveAll(sheets);
    }

    public void processingBallots(List<Planilla> sheets, Empleado employee){
        List<Boleta> boletas = _Boleta.getByDateFrom_DateTo_Employees(new Date(), new Date(), employee.getId());
        Planilla sheet = new Planilla();

        int totalGabinete = 0;
        int totalGabineteDesarraigo = 0;
        int totalGabineteParcial = 0;
        int totalGabineteCompleto = 0;
        int totalGabineteCompletoEstadia = 0;
        int totalGabineteSereno = 0;

        for (Boleta boleta : boletas) {

            switch (boleta.getTipoBoleta().getCodigo()) {
                case "razones particulares":
                    totalGabineteDesarraigo += 1;
                    break;
                case "comisión por día":
                    totalGabineteParcial += 1;
                    break;
                case "Sereno":
                    totalGabineteSereno += 1;
                    break;
                case "viático gabinete":
                    totalGabinete += 1;
                    break;
                case "franquicia":
                    totalGabineteCompleto += 1;
                    break;
                default:
                    totalGabinete += 0;
                    totalGabineteDesarraigo += 0;
                    totalGabineteParcial += 0;
                    totalGabineteCompleto += 0;
                    totalGabineteCompletoEstadia = +0;
                    totalGabineteSereno += 0;
                    break;
            }

            sheet.setEmpleado(employee);
            sheet.setFechaDesde(new Date());
            sheet.setFechaHasta(new Date());
            sheet.setBoletas(boletas);
            sheet.setTotalGabinete(totalGabinete);
            sheet.setTotalGabineteDesarraigo(totalGabineteDesarraigo);
            sheet.setTotalGabineteParcial(totalGabineteParcial);
            sheet.setTotalGabinetesCompletos(totalGabineteCompleto);
            sheet.setTotalGabinetesCompletosEstadia(totalGabineteCompletoEstadia);
            sheet.setTotalGabineteSereno(totalGabineteSereno);
        }
        sheets.add(sheet);
    }

    public void processingLicenses(List<Planilla> sheets, Empleado employee){

        List<Licencia> licencias = _Licencia.getByDateFrom_DateTo_Employee(new Date(), new Date(), employee.getId());
        Planilla sheet = new Planilla();

        int totalGabinete = 0;
        int totalGabineteDesarraigo = 0;
        int totalGabineteParcial = 0;
        int totalGabineteCompleto = 0;
        int totalGabineteCompletoEstadia = 0;
        int totalGabineteSereno = 0;

        for (Licencia licencia : licencias) {

            switch (licencia.getTipoLicencia().getCodigo()) {
                case "razones particulares":
                    totalGabineteDesarraigo += 1;
                    break;
                case "comisión por día":
                    totalGabineteParcial += 1;
                    break;
                case "Sereno":
                    totalGabineteSereno += 1;
                    break;
                case "viático gabinete":
                    totalGabinete += 1;
                    break;
                case "franquicia":
                    totalGabineteCompleto += 1;
                    break;
                default:
                    totalGabinete += 0;
                    totalGabineteDesarraigo += 0;
                    totalGabineteParcial += 0;
                    totalGabineteCompleto += 0;
                    totalGabineteCompletoEstadia = +0;
                    totalGabineteSereno += 0;
                    break;
            }

            sheet.setEmpleado(employee);
            sheet.setFechaDesde(new Date());
            sheet.setFechaHasta(new Date());
            sheet.setLicencias(licencias);
            sheet.setTotalGabinete(totalGabinete);
            sheet.setTotalGabineteDesarraigo(totalGabineteDesarraigo);
            sheet.setTotalGabineteParcial(totalGabineteParcial);
            sheet.setTotalGabinetesCompletos(totalGabineteCompleto);
            sheet.setTotalGabinetesCompletosEstadia(totalGabineteCompletoEstadia);
            sheet.setTotalGabineteSereno(totalGabineteSereno);
        }
        sheets.add(sheet);
    }

    public void saveAll(List<Planilla> sheets) throws Exception{
        for (Planilla sheet: sheets){
            _Sheets.save(sheet);
        }
    }

    public void save(Planilla sheet) throws Exception{
            _Sheets.save(sheet);
    }
}
