package service;

import java.util.ArrayList;
import java.util.List;

import model.Producto;

public class ProductosService {

	//Listado de productos static pq todas las acciones comparten la misma lista
	private static List<Producto> productos = new ArrayList<>();
	//Métodos
	public void nuevo(Producto producto) {
		productos.add(producto);
	}
	
	public List<Producto> buscarPorCategoria(String categoria){
		//Convencional
		/*List<Producto> aux = new ArrayList<>();
		for(Producto producto : productos) {
			if(producto.getCategoria().equals(categoria)) {
				aux.add(producto);
			}
		}
		return aux;*/
		//Funcional
		return productos.stream()
				.filter(p -> p.getCategoria().equals(categoria))
				.toList();
	}
	
	public void eliminar(String nombre) {
		productos.removeIf(p -> p.getNombre().equals(nombre));
	}
}
