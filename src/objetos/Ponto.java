/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import java.util.ArrayList;

/**
 *
 * @author valdi
 */
public class Ponto {
    int id;
    String data;
    int hrs;
    ArrayList<Ponto> Pontos = new ArrayList<>() ;
    
    public void set_all(ArrayList<Ponto> p) {
        Pontos = p;
    }
    
    public ArrayList<Ponto> all() {
        return Pontos;
    }
    
    public void add(Ponto p) {
        Pontos.add(p.id, p);
    }
}
