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

public class AbogadoBD extends GenericoBD {

    private static PreparedStatement pS;
    private static String plantilla;
    private static Statement sT;
    private static ResultSet rS;
    private static Abogado abog;

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

    public void borrarAbogado(String dni) throws SQLException, Exception {
        plantilla = "DELETE FROM abogados where dni = ?";

        pS = abrirConexion().prepareStatement(plantilla);

        pS.setString(1, dni);

        pS.executeUpdate();

        cerrarConexion();

    }

    public static void actualizarAbogado(Abogado abogado) throws SQLException, Exception {
        plantilla = "UPDATE abogados SET dni=?, nombre=?, ape1=?, ape2=?, dir=?  WHERE dni = ?";

        pS = abrirConexion().prepareStatement(plantilla);

        pS.setString(1, abogado.getDni());
        pS.setString(2, abogado.getNombre());
        pS.setString(3, abogado.getApe1());
        pS.setString(4, abogado.getApe2());
        pS.setString(5, abogado.getDir());

        pS.executeUpdate();

        cerrarConexion();
    }

    public static boolean sacarInfo(String dni) throws SQLException, Exception {

        boolean encontrado;

        plantilla = "SELECT * FROM abogados WHERE DNI = ?;";

        pS = abrirConexion().prepareStatement(plantilla);

        pS.setString(1, dni);

        rS = pS.executeQuery();

        if (!rS.next()) {
            return false;
        } 
        else {
            abog = new Abogado();

            abog.setDni(rS.getString("dni"));
            abog.setNombre(rS.getString("nombre"));
            abog.setApe1(rS.getString("ape1"));
            abog.setApe2(rS.getString("ape2"));
            abog.setDir(rS.getString("dir"));

            encontrado = true;

        }
        rS.close();
        sT.close();
        cerrarConexion();

        return encontrado;
    }
}
