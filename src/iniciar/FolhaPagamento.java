/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iniciar;

import objetos.*;
import util.Util;

/**
 *
 * @author valdi
 */
public class FolhaPagamento {
  
    
    public static void main(String[] args) {
        
        Util u = new Util();
        Funcionario f = new Funcionario();
        Remuneracao r = new Remuneracao();
        LinhaTempo hist = new LinhaTempo(null, null, null, null);
        
        Boolean stop = false;

        while (stop == false) {
            u.confMsg(1, 0, 1);
            u.msgo("Digite qual operação deseja fazer:");
            u.msgo("| 00 para sair.");
            u.msgo("| 1 para adicionar empregado.");
            u.msgo("| 2 para remover empregado.");
            u.msgo("| 3 para lançar um cartão de ponto.");
            u.msgo("| 4 para lançar um resultado de venda.");
            u.msgo("| 5 para lançar uma taxa de serviço.");
            u.msgo("| 6 para alterar detalhes de um empregado.");
            u.msgo("| 7 para rodar a folha de pagamento para hoje.");
            u.msgo("| 8 Undo/redo.");
            u.msgo("| 9 para agenda de pagamento.");
            System.out.println("---------------------------------------------------------");

            switch(u.msgi(">>",2, 2, 0)){
                case "1": 
                    u.confMsg(2, 2, 1);

                    u.msgo("Adicionar funcionario");
                    u.msgo("Digite o nome do funcionario");
                    String nome = u.msgi(">>",2,2);   
                    
                    u.msgo("Digite o enderço do funcionario");
                    String endereco = u.msgi(">>",2,2);
                    
                    u.msgo("Referentes a remuneração informe;"); 
                    u.msgo("O tipo de remuneração do funcionario",4,2,1);
                    String tipo = u.msgi(">>",4,2); 

                    u.msgo("Quantia",4,2,1);
                    String quantia = u.msgi(">>",4,2); 

                    u.msgo("e a Data de pagamento",4,2,1);
                    String data = u.msgi(">>",4,2); 
                    
                    r = new Remuneracao(tipo, Double.parseDouble(quantia), data);
                    r.add(r);
                    u.msgo(String.valueOf(r.getId()));
                    f = new Funcionario(nome, endereco, r.getId());
                    f.add(f);

                    hist = new LinhaTempo(f.all(), null , r.all(), null);
                    System.out.println("---------------------------------------------------------------------------------");

                    u.msgo("Adicionado:");
                    u.setShowVerticalLines(true);
                    u.setHeaders("Id", "Nome", "Endereco", "Quantia", "Data");
                    u.addRow(String.valueOf(f.getId()), nome, endereco, quantia, data );
                    u.showTable();
                    
                break;
                    
                case "2": 
                    u.msgo("remover empregado");
                    u.msgo("Qual Funcionario deseja remover?");
                    
                    if (f.all().size() > 0) {
                        u.setShowVerticalLines(true);
                        u.setHeaders("Id", "Nome", "Endereco", "Quantia", "Data");
                        for (int id = 0; id < f.all().size(); id++) {
                            Double valor = r.all().get(f.all().get(id).getId_remuneracao()).getValor();
                            data = r.all().get(f.all().get(id).getId_remuneracao()).getData();

                            u.addRow(String.valueOf(f.all().get(id).getId()),
                                    f.all().get(id).getNome(),
                                    f.all().get(id).getEndereco(), String.valueOf(valor), data);
                        }
                    } else {
                        u.msgo("Nenhum empregado encontrado.");
                    }
            }
            
            u.confMsg(1, 0, 1);            
            u.msgo("Deseja fazer alguma outra operação? (Sim)");
            if (!u.msgi(">>").toLowerCase().equals("sim")) {
                stop = true;
            }
        }
    }
}
