package pe.edu.tecsup.app.lab2.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.app.lab2.entidades.Categoria;

public class CategoriaRepositorio extends JDBCBase {

	
	public List<Categoria>  obtenerCategorias() {
		
		
		List<Categoria> categorias = new ArrayList<Categoria>();

		try {
			// Conectarme a la BD
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// Realizar una consulta
			String sql = 
					"""
						SELECT id, nombre, descripcion 
						FROM categorias 
					""";			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			
			// Procesar la respuesta
			while (rs.next()) {
				
				Categoria cat = new Categoria();
				cat.setId(rs.getInt("id"));
				cat.setNombre(rs.getString("nombre"));
				cat.setDescripcion(rs.getString("descripcion"));
				
				categorias.add(cat);
								
			}
			
			rs.close(); 
			
			stmt.close();
			
			// Cerrar conexion a la BD
			con.close();
			
			//System.out.println(categorias);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return categorias;

	}

}
