/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisClasesBD;

import MisClases.Abogado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AbogadoBD extends GenericoBD{
    
    private static PreparedStatement pS;
    private static String plantilla;
    private static Statement sT;
    private static ResultSet rS;

    public void insertarBD(Abogado a) throws SQLException, Exception {

        plantilla = "INSERT INTO  abogados (dni, nombre, ape1, ape2, dir) VALUES (?,?,?,?,?)";

        pS = abrirConexion().prepareStatement(plantilla);
        pS.setString(1, a.getDni());
        pS.setString(2, a.getNombre());
        pS.setString(3, a.getApe1());
        pS.setString(4, a.getApe2());
        pS.setString(5, a.getDir());
        
        pS.executeUpdate();
        
        cerrarConexion();
    }
    public static void borrarAbogado(Abogado dni) throws SQLException, Exception {
        plantilla = "DELETE FROM abogados where dni = ?";
        
        pS = abrirConexion().prepareStatement(plantilla);
        
        pS.setString(1, dni.getDni());

        pS.executeUpdate();
        
        cerrarConexion();
        
    }
}
