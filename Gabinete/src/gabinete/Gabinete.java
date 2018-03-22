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
    private static V1 vP;
    private static AbogadoBD vABD;

    public static void main(String[] args) {

// INICIO MAIN
        vABD = new AbogadoBD();

        abrirVentanaPrincipal(vP = new V1());

    }

    private static void abrirVentanaPrincipal(V1 vPrincipal) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void generarAbogado(String dni, String nombre, String ape1, String ape2, String dir) throws Exception {
        Abogado a = new Abogado(dni, nombre, ape1, ape2, dir);

        vABD.insertarBD(a);
    }

    
}
