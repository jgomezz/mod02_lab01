package pe.edu.tecsup.app.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EliminarRegistros extends JDBCBase {

	public static void main(String[] args) {
		
		try {
			// Conectarme a la BD
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// Define la sentencia SQL
			String sql = 
					"""
						DELETE FROM categorias 
						WHERE id = ?
						
					""";	
			int idBorrar = 14; // 14 es el ID de Lentes            
			PreparedStatement stmt = con.prepareStatement(sql);              
			stmt.setInt(1, idBorrar); 
		
			// Ejecutar el borrado
			int estado = stmt.executeUpdate(); 
		
			if (estado != 1)
				throw new SQLException("No se pudo eliminar");

			System.out.printf("Se elimino la categoria con id = %d \n", idBorrar);
			
						
			stmt.close();
			
			// Cerrar conexion a la BD
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
