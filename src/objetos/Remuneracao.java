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
public class Remuneracao {
    int id;
    String tipo_remuneracao;
    Double valor;
    String data;
    ArrayList<Remuneracao> Remuneracoes = new ArrayList<>();

    public Remuneracao() {}
    
    public Remuneracao(String tipo_remuneracao, Double valor, String data) {
        this.tipo_remuneracao = tipo_remuneracao;
        this.valor = valor;
        this.data = data;
    }
    
    public Remuneracao(int id, String tipo_remuneracao, Double valor, String data) {
        this.id = id;
        this.tipo_remuneracao = tipo_remuneracao;
        this.valor = valor;
        this.data = data;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_remuneracao() {
        return tipo_remuneracao;
    }

    public void setTipo_remuneracao(String tipo_remuneracao) {
        this.tipo_remuneracao = tipo_remuneracao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public void set_all(ArrayList<Remuneracao> r) {
        Remuneracoes = r;
    }
    
    public ArrayList<Remuneracao> all() {
        return Remuneracoes;
    }
    
    public void add(Remuneracao r) {
        r.setId(Remuneracoes.size());
        Remuneracoes.add(r.id, r);    

    }
    
    public void set(int id, Remuneracao r) {
        Remuneracoes.set(r.getId(), r);    
    }
}
