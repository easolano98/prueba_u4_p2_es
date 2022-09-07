package com.uce.edu.demo.repository.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.ProductoSencillo;
import com.uce.edu.demo.repository.modelo.Venta;
import com.uce.edu.demo.service.IVentaService;

@Controller
@RequestMapping("/ventas")
public class VentaController {
	
	@Autowired
	private IVentaService ventaService;
	
	@GetMapping("/nuevaVenta")
	public String paginaNuevaVenta(Venta venta) {
		return "vistaNuevaVenta";
	}
	
	@PostMapping("/insertar")
	public String insertarVenta(Venta venta) {
		List<ProductoSencillo> carrito = new ArrayList<ProductoSencillo>();
		ProductoSencillo productoCarrito=new ProductoSencillo();
		productoCarrito.setCodigo("0103");
		productoCarrito.setCantidad(4);
		carrito.add(productoCarrito);
		this.ventaService.realizarVenta(carrito, venta.getCedulaCliente(), venta.getNumero());
		return "redirect:/ventas/nuevaVenta";
	}
	


}
