package com.pgd.planilla.factory;

public class Proveedor {

    public static ProveedorMiembrosPlanilla createProveedor1() {
        return new ProveedorMiembrosPlanilla1();
    }

    public static ProveedorMiembrosPlanilla createProveedor2() {
        return new ProveedorMiembrosPlanilla2();
    }

}
