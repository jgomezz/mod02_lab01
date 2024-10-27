package pe.edu.tecsup.app.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ActualizarRegistros extends JDBCBase {

	public static void main(String[] args) {

		try {
			// Conectarme a la BD
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// Define la sentencia SQL
			String sql =
					"""
						UPDATE categorias 
						SET nombre = ? 
						WHERE id = ?
						
					""";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "Lentes Cambiados");
			stmt.setInt(2, 14); // 14 es el ID de Lentes

			// Ejecutar la actualizacion
			int estado = stmt.executeUpdate();

			// Analizar el resultado
			if (estado != 1)
				throw new SQLException("No se pudo insertar");


			stmt.close();

			// Cerrar conexion a la BD
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
