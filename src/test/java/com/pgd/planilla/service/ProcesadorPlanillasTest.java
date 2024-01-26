package com.pgd.planilla.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.pgd.planilla.dto.SpreadsheetTotal;
import com.pgd.planilla.factory.ProveedorMiembrosPlanilla;
import com.pgd.planilla.model.Empleado;
import org.junit.jupiter.api.BeforeEach;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class ProcesadorPlanillasTest {

    @Mock
    private ProveedorMiembrosPlanilla proveedor;
    private ProcesadorPlanillas procesadorPlanillas;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        MockitoAnnotations.openMocks(this);
        procesadorPlanillas = new ProcesadorPlanillas("2");
        Field proveedorField = ProcesadorPlanillas.class.getDeclaredField("proveedor");
        proveedorField.setAccessible(true);
        proveedorField.set(procesadorPlanillas, proveedor);
    }

    @Test
    void testTotalWithValidData() {
        when(proveedor.getEmpleadosByPlantilla("1")).thenReturn(Arrays.asList(
                new Empleado(1, "John", new BigDecimal("1000.50"), true),
                new Empleado(2, "Jane", new BigDecimal("1500.75"), true)
        ));
        SpreadsheetTotal result = procesadorPlanillas.total("1");
        assertEquals(new BigDecimal("2501.25"), result.getTotal());
    }

    @Test
    void testTotalWithNoActiveEmployees() {
        when(proveedor.getEmpleadosByPlantilla("1")).thenReturn(List.of(
                new Empleado(1, "John", new BigDecimal("1000.50"), false)
        ));

        SpreadsheetTotal result = procesadorPlanillas.total("1");
        var expectedResult = new BigDecimal("0.00");
        assertEquals(expectedResult, result.getTotal());
    }

    @Test
    void testTotalWithNegativeMontoMensual() {
        when(proveedor.getEmpleadosByPlantilla("1")).thenReturn(List.of(
                new Empleado(1, "John", new BigDecimal("-1000.50"), true)
        ));
        assertThrows(RuntimeException.class, () -> procesadorPlanillas.total("1"));
    }
}
