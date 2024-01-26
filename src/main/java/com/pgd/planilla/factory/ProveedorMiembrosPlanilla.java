package com.pgd.planilla.factory;

import com.pgd.planilla.model.Empleado;

import java.math.BigDecimal;
import java.util.List;

public interface ProveedorMiembrosPlanilla {
    List<Empleado> getEmpleadosByPlantilla(String id);
}
