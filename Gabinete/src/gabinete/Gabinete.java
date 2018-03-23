/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gabinete;

import MisClases.*;
import MisClasesBD.*;
import MisVentanas.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author aitor
 */
public class Gabinete {
    public static V1 vP;
    public static VAbogado vA;
    public static VCliente vC;
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
    
    //ABOGADO
    public static void abrirAbogado(String dato) {        
        vA = new VAbogado(dato);
        vA.setVisible(true);
        vA.setLocationRelativeTo(null);
    }

    public static void generarAbogado(String dni, String nombre, String ape1, String ape2, String dir) throws Exception {
        Abogado a = new Abogado(dni, nombre, ape1, ape2, dir);

        aBD.insertarBD(a);
    }

    public static void borrarAbogadoPorDni(String dni) throws Exception{
        AbogadoBD aBd = new AbogadoBD();
        
        aBd.borrarAbogado(dni);
    }

    public static void actualizarAbogado(String dni, String nombre, String ape1, String ape2, String dir) throws Exception{
        Abogado aBd = new Abogado(dni, nombre, ape1, ape2, dir);
        
        AbogadoBD.actualizarAbogado(aBd);
    }
    
    public static boolean buscarAbogadoPorDni(String dni) throws Exception{
        return AbogadoBD.sacarInfo(dni);
    }
    
    //CLIENTE
     public static void abrirCliente(String dato) {        
        vC = new VCliente(dato);
        vC.setVisible(true);
        vC.setLocationRelativeTo(null);
    }

    public static void generarCliente(String dni, String nombre, String ape1, String ape2, String dir, String tlf) throws Exception {
        Cliente c = new Cliente(dni, nombre, ape1, ape2, dir, tlf);

        clBD.insertarBD(c);
    }

    public static void borrarClientePorDni(String dni) throws Exception{
        ClienteBD cBd = new ClienteBD();
        
        cBd.borrarCliente(dni);
    }

    public static void actualizarCliente(String dni, String nombre, String ape1, String ape2, String dir, String tlf) throws Exception{
        Cliente c = new Cliente(dni, nombre, ape1, ape2, dir, tlf);
        
        ClienteBD.actualizarCliente(c);
    }
    
    public static boolean buscarClientePorDni(String dni) throws Exception{
        return ClienteBD.sacarInfo(dni);
    }
    //CASO
}
    
    

    

