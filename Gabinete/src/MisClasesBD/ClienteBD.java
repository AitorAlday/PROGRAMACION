/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisClasesBD;

import MisClases.Cliente;
import static MisClasesBD.GenericoBD.abrirConexion;
import static MisClasesBD.GenericoBD.cerrarConexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author aitor
 */
public class ClienteBD extends GenericoBD{
    private static PreparedStatement pS;
    private static String plantilla;
    private static Statement sT;
    private static ResultSet rS;

    public void insertarBD(Cliente c) throws SQLException, Exception {

        plantilla = "INSERT INTO  clientes (dni, nombre, ape1, ape2, dir, tel) VALUES (?,?,?,?,?,?)";

        pS = abrirConexion().prepareStatement(plantilla);
        pS.setString(1, c.getDni());
        pS.setString(2, c.getNombre());
        pS.setString(3, c.getApe1());
        pS.setString(4, c.getApe2());
        pS.setString(5, c.getDir());
        pS.setString(6, c.getTlf());
        
        pS.executeUpdate();
        
        cerrarConexion();
    }
}
