/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gabinete;

import MisClases.*;
import MisClasesBD.*;
import MisVentanas.*;

/**
 *
 * @author aitor
 */
public class Gabinete {
    public static V1 vP;
    public static VAbogado vA;
    public static AbogadoBD aBD;
    public static ClienteBD clBD;
    public static CasoBD caBD;

    public static void main(String[] args) {
        aBD = new AbogadoBD();
        clBD = new ClienteBD();
        caBD = new CasoBD();
        
        vP = new V1();
        vP.setVisible(true);
        vP.setLocationRelativeTo(null);

    }

    public static void abrirAbogado(String dato) {        
        vA = new VAbogado(dato);
        vA.setVisible(true);
        vA.setLocationRelativeTo(null);
    }

    public static void generarAbogado(String dni, String nombre, String ape1, String ape2, String dir) throws Exception {
        Abogado a = new Abogado(dni, nombre, ape1, ape2, dir);

        aBD.insertarBD(a);
    }

    
}
