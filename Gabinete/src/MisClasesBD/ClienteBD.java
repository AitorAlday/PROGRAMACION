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
    private static Cliente cli;

    public static void actualizarCliente(Cliente c) throws SQLException, Exception {
        plantilla = "UPDATE abogados SET dni=?, nombre=?, ape1=?, ape2=?, dir=?, tel=?  WHERE dni = ?";

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

    public static boolean sacarInfo(String dni) throws SQLException, Exception {
         boolean encontrado;

        plantilla = "SELECT * FROM clientes WHERE DNI = ?;";

        pS = abrirConexion().prepareStatement(dni);

        pS.setString(1, dni);

        rS = pS.executeQuery();

        if (!rS.next()) {
            return false;
        } 
        else {
            cli = new Cliente();

            cli.setDni(rS.getString("dni"));
            cli.setNombre(rS.getString("nombre"));
            cli.setApe1(rS.getString("ape1"));
            cli.setApe2(rS.getString("ape2"));
            cli.setDir(rS.getString("dir"));

            encontrado = true;

        }
        rS.close();
        sT.close();
        cerrarConexion();

        return encontrado;
    }

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

    public void borrarCliente(String dni) throws SQLException, Exception {
        plantilla = "DELETE FROM clientes where dni = ?";

        pS = abrirConexion().prepareStatement(plantilla);

        pS.setString(1, dni);

        pS.executeUpdate();

        cerrarConexion();
    }
}
