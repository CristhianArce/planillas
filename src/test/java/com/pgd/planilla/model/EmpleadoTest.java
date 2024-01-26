package com.pgd.planilla.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void validateBlankEmployeeNameThrowsAnException() {
        assertThrows(RuntimeException.class, () -> new Empleado(10, "", BigDecimal.valueOf(5000), true));
    }
}