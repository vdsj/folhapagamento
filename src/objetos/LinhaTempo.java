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
public class LinhaTempo {
    private int id;
    private ArrayList<Funcionario> funcionario;
    private ArrayList<Ponto> ponto;
    private ArrayList<Remuneracao> remuneracao;
    private ArrayList<Sindicato> sindicato;
    private ArrayList<LinhaTempo> Historico = new ArrayList<>();
    
    public LinhaTempo(ArrayList<Funcionario> f, ArrayList<Ponto> p, ArrayList<Remuneracao> r, ArrayList<Sindicato> s) {
        this.funcionario = f;
        this.ponto = p;
        this.remuneracao = r;
        this.sindicato = s;
    }
    
    public void set_all(ArrayList<LinhaTempo> h) {
        Historico = h;
    }
    
    public ArrayList<LinhaTempo> all() {
        return Historico;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public void add(LinhaTempo h ) {
        h.setId(Historico.size());
        Historico.add(h.id, h);    

    }
    
    public void set(int id, LinhaTempo h) {
        h.set(h.getId(), h);    
    }
    
}
