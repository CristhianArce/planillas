package com.pgd.planilla.controller;

import com.pgd.planilla.dto.SpreadsheetTotal;
import com.pgd.planilla.service.ProcesadorPlanillas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class SpreadsheetController {

    private ProcesadorPlanillas procesadorPlanillas;

    SpreadsheetController(ProcesadorPlanillas procesadorPlanillas) {
        this.procesadorPlanillas = procesadorPlanillas;
    }

    @GetMapping("/planilla/{id}")
    public SpreadsheetTotal getTotalByPlanilla(@PathVariable("id") String id) {

        return procesadorPlanillas.total(id);
    }
}
