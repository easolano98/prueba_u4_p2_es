package com.uce.edu.demo.repository.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.ReporteSencillo;
import com.uce.edu.demo.service.IVentaService;
@Controller
@RequestMapping("/reportes")
public class ReporteController {
	
	@Autowired
	private IVentaService ventaService;
	@GetMapping("/buscar")
	public String buscarReportes( Model modelo) {
		List<ReporteSencillo> lista = this.ventaService.GenerarReporteVentas(LocalDateTime.of(2022, 8, 26, 0, 0), "Granos", 4 );
		modelo.addAttribute("reportes", lista);
		return "vistaListaReportes";
	}
}
