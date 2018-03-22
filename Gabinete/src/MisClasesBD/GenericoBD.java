/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisClasesBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericoBD {

    private static String nombreBD = "gabinete";
    private static String url = "jdbc:mysql://localhost:3307/" + nombreBD;
    private static String user = "root";
    private static String pass = "usbw";
    private static Connection con;

    // ESTABLECER CONEXION
    public static Connection abrirConexion() throws ClassNotFoundException, SQLException, Exception {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);

        return con;
    }

    //CERRAR CONEXION
    public static void cerrarConexion() throws SQLException, Exception {
        con.close();
    }
}
