/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MisClases;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aitor
 */
public class Caso {
    public String numExp, estado;
    public Date fIni, fFin;
    
    public Cliente cliente;
    
    private ArrayList <Abogado> listaAbogados;

    public Caso(String numExp, String estado, Date fIni, Date fFin, Cliente cliente, ArrayList<Abogado> listaAbogados) {
        this.numExp = numExp;
        this.estado = estado;
        this.fIni = fIni;
        this.fFin = fFin;
        this.cliente = cliente;
        this.listaAbogados = listaAbogados;
    }

    public Caso() {
    }

    public String getNumExp() {
        return numExp;
    }

    public void setNumExp(String numExp) {
        this.numExp = numExp;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getfIni() {
        return fIni;
    }

    public void setfIni(Date fIni) {
        this.fIni = fIni;
    }

    public Date getfFin() {
        return fFin;
    }

    public void setfFin(Date fFin) {
        this.fFin = fFin;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Abogado> getListaAbogados() {
        return listaAbogados;
    }

    public void setListaAbogados(ArrayList<Abogado> listaAbogados) {
        this.listaAbogados = listaAbogados;
    }

    public Object getCliente(String dni) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
