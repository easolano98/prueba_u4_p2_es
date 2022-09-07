package com.uce.edu.demo.repository.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.ProductoSencilloStock;
import com.uce.edu.demo.service.IProductoService;
@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/nuevoProducto")
	public String paginaNuevoProducto(Producto producto) {
		return "vistaNuevoProducto";
	}
	
	@PostMapping("/insertar")
	public String insertarProducto(Producto producto) {
		
		this.productoService.ingresarProducto(producto);
		return "redirect:/productos/nuevoProducto";
		
	}
	
	@GetMapping("/buscar")
	public String buscarProducto(@PathVariable("codProd") String codigo, Model modelo) {
		ProductoSencilloStock prod= this.productoService.consultarStock(codigo);
		modelo.addAttribute("producto", prod);
		return "vistaProducto";
	}
	
	
}
