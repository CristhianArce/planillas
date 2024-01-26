package com.pgd.planilla.service;

import com.pgd.planilla.factory.ProveedorMiembrosPlanilla;
import com.pgd.planilla.dto.SpreadsheetTotal;
import com.pgd.planilla.factory.Proveedor;
import com.pgd.planilla.model.Empleado;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ProcesadorPlanillas {

    private ProveedorMiembrosPlanilla proveedor;

    ProcesadorPlanillas (@Value("${proveedor}") String eleccionProveedor) {
        if (eleccionProveedor.equals("2"))
            this.proveedor = Proveedor.createProveedor2();
        else
            this.proveedor = Proveedor.createProveedor1();
    }

    public SpreadsheetTotal total(String id){
        var total = proveedor.getEmpleadosByPlantilla(id).stream()
                .filter(Empleado::isActivo)
                .map(Empleado::getMontoMensual)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new SpreadsheetTotal(total.setScale(2, RoundingMode.CEILING));
    }
}
