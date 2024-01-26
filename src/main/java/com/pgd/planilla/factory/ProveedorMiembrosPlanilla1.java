package com.pgd.planilla.factory;

import com.pgd.planilla.model.Empleado;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProveedorMiembrosPlanilla1 implements ProveedorMiembrosPlanilla {

    private static final Random random = new Random();
    Logger logger = LoggerFactory.getLogger(ProveedorMiembrosPlanilla1.class);


    @Override
    public List<Empleado> getEmpleadosByPlantilla(String id) {
        var empleados = generateRandomEmpleados();
        logger.info("lista de empleados proveedor 1: " + empleados);
        return empleados;
    }

    private static List<Empleado> generateRandomEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            empleados.add(generateRandomEmpleado());
        }
        return empleados;
    }

    private static Empleado generateRandomEmpleado() {
        int id = random.nextInt(1000); // Asumiendo que los ID's de los empleados van del 1 al 999
        String nombre = "Employee From Provider 1: " + id;
        BigDecimal montoMensual = BigDecimal.valueOf(random.nextDouble() * 5000 + 1000); // Número random entre 1000 y 6000
        boolean activo = random.nextBoolean();
        return new Empleado(id, nombre, montoMensual.setScale(2, RoundingMode.CEILING), activo);
    }
}
