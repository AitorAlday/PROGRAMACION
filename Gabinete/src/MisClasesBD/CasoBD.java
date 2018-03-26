/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisClasesBD;

import MisClases.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aitor
 */
public class CasoBD extends GenericoBD{
    private static PreparedStatement pS;
    private static String plantilla;
    private static Statement sT;
    private static ResultSet rS;
    private static Caso ca;
    private static Abogado abogado;

    public void insertarBD(Caso ca, Cliente cli) throws SQLException, Exception {

        plantilla = "INSERT INTO casos (dni, nombre, ape1, ape2, dir) VALUES (?,?,?,?,?)";

        pS = abrirConexion().prepareStatement(plantilla);
        pS.setObject(1, ca.getCliente(cli.getDni()));
        pS.setDate(2, (Date) ca.getfIni());
        pS.setDate(3, (Date) ca.getfFin());
        pS.setString(4, ca.getEstado());
        pS.setString(5, ca.getNumExp());
        
        pS.executeUpdate();
        
        cerrarConexion();
    }
    public static boolean sacarInfoAbogado(String dni) throws SQLException, Exception {
         boolean encontrado;

        plantilla = "SELECT nombre FROM abogados WHERE DNI = ?;";

        pS = abrirConexion().prepareStatement(dni);

        pS.setString(1, dni);

        rS = pS.executeQuery();

        if (!rS.next()) {
            return false;
        } 
        else {
            abogado = new Abogado();
            
            abogado.setNombre(rS.getString("nombre"));
            
            encontrado = true;

        }
        rS.close();
        sT.close();
        cerrarConexion();

        return encontrado;
    }

    public void borrarCaso(String cod) throws SQLException, Exception {
        plantilla = "DELETE FROM caso WHERE num_exp = ?";

        pS = abrirConexion().prepareStatement(plantilla);

        pS.setString(1, cod);

        pS.executeUpdate();

        cerrarConexion();
    }
}
