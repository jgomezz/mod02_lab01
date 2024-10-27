package pe.edu.tecsup.app.lab2.servicios;

import java.util.List;

import pe.edu.tecsup.app.lab2.entidades.Categoria;
import pe.edu.tecsup.app.lab2.repositorios.CategoriaRepositorio;

public class CategoriaServicio {
	
	public static void main(String[] args) {
		
		CategoriaRepositorio c = new CategoriaRepositorio();
		
		List<Categoria> categorias = c.obtenerCategorias();
		
		for (Categoria categoria : categorias) {
			System.out.println(categoria);
		}
		
	}

}
