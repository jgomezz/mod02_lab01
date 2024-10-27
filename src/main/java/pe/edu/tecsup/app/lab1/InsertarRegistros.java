package pe.edu.tecsup.app.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarRegistros extends JDBCBase {

	public static void main(String[] args) {

		try {
			// Conectarme a la BD
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

			// Realizar la insercion
			String sql =
					"""
						INSERT INTO categorias (nombre, descripcion) 
						VALUES (?, ?);
					""";

			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, "Lentes");
			stmt.setString(2, "Lentes de realidad virtual");

			// Ejecutar la insercion
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
