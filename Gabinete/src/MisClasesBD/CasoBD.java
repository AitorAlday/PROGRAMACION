/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisClasesBD;

import MisClases.Caso;
import MisClases.Cliente;
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
}
