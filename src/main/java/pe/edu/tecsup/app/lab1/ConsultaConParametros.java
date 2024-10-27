package pe.edu.tecsup.app.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaConParametros extends JDBCBase {


	
	public static void main(String[] args) {
		

		try {
			// Conectarme a la BD
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// Realizar una consulta
			//                                                                     1
			String sql = 
					"""
						SELECT id, nombre, descripcion 
						FROM productos 
						WHERE id = ? AND nombre LIKE ?
					""";
					
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, 100);               // posicion del 1er signo de interrogacion
			stmt.setString(2, "%port%");               // posicion del 1er signo de interrogacion
			
			ResultSet rs = stmt.executeQuery();
			
			
			// Procesar la respuesta
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String descripcion = rs.getString("descripcion");
				System.out.printf(">>> id = %d , nombre=%s, descripcion=%s \n", id, nombre, descripcion);
				
			}
			
			rs.close(); 
			
			stmt.close();
			
			// Cerrar conexion a la BD
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
