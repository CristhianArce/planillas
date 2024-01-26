package com.pgd.planilla.dto;

import java.math.BigDecimal;

public class SpreadsheetTotal {
    private BigDecimal total;

    public SpreadsheetTotal(BigDecimal total) {
        if (total.signum() == -1) throw new RuntimeException("El monto a pagar no puede ser menor a 0.");
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
