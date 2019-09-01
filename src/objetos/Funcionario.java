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
public class Funcionario {
    int id;
    String nome;
    String endereco;
    int id_remuneracao;
    int id_sindicato;
    ArrayList<Funcionario> Funcionarios = new ArrayList<>();

    public Funcionario() {
    }
  
    public Funcionario(String nome, String endereco, int id_remuneracao) {
        this.nome = nome;
        this.endereco = endereco;
        this.id_remuneracao = id_remuneracao;
    }

    public Funcionario(String nome, String endereco, int id_remuneracao,int id_sindicato) {
        this.nome = nome;
        this.endereco = endereco;
        this.id_remuneracao = id_remuneracao;
        this.id_sindicato = id_sindicato;
    }
    
        public Funcionario(int id, String nome, String endereco, int id_remuneracao,int id_sindicato) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.id_remuneracao = id_remuneracao;
        this.id_sindicato = id_sindicato;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId_remuneracao() {
        return id_remuneracao;
    }

    public void setId_remuneracao(int id_remuneracao) {
        this.id_remuneracao = id_remuneracao;
    }
    
    public void set_all(ArrayList<Funcionario> f) {
        Funcionarios = f;
    }
    
    public ArrayList<Funcionario> all() {
        return Funcionarios;
    }
    
    public void add(Funcionario f) {
        f.setId(Funcionarios.size());
        Funcionarios.add(f.id, f);    
    }
    
    public void remove(int id) {
        Funcionarios.remove(id);
    }
    
    public void set(int id, Funcionario f) {
        Funcionarios.set(f.id, f);    
    }
    
}
