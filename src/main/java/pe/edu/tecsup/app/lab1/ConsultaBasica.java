package pe.edu.tecsup.app.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaBasica extends JDBCBase {

	
	public static void main(String[] args) {
		

		try {
			// Conectarme a la BD
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// Realizar una consulta
			String sql = 
					"""
						SELECT id, nombre, descripcion 
						FROM productos 
					""";			
			PreparedStatement stmt = con.prepareStatement(sql);
			
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
