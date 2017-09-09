
package geradordeprova;

import java.awt.Desktop;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Elizandro
 */

    public class GeradorDeProva{
    
        public static void main(String[] args){
            Scanner s=new Scanner(System.in);

            
            System.out.print("Por favor, entre com o nome da disciplina: ");
            Prova p= new Prova(s.nextLine());
            
            System.out.print("Entre com a data da prova: ");
            p.setData(s.nextLine());
            System.out.print("Entre com a sala da prova: ");
            p.setLocal(s.nextLine());
            System.out.print("Entre com o peso da prova: ");
            p.setPeso(s.nextInt());
            s.nextLine();
            
            System.out.print("Deseja inserir uma questão ?");
            String aux = s.nextLine();
            
            
            
            while(aux.equalsIgnoreCase("s")){
                System.out.print("Que tipo de questao deseja inserir ? Objetiva (o) ou Descritiva (d): ");
                        
                String tipoQuetao=s.nextLine();
                
                if(tipoQuetao.equalsIgnoreCase("o")){
                    // criar uma questão objetiva
                    Objetiva objetivas=new Objetiva();
                    String[] troca=new String[5];

                    System.out.print("Entre com a pergunta da questão: ");
                    objetivas.setPergunta(s.nextLine());


                    for (int j = 0; j < 5; j++) {
                         System.out.print("Entre com a "+(j+1)+"ª alternativa da questão: ");
                         troca[j]=s.nextLine();
                    }
                    objetivas.setOpcoes(troca);
                    System.out.print("Entre com a resposta correta da questão: ");
                    objetivas.setRespostaCorreta(s.nextInt()-1);
                    s.nextLine();
                    System.out.print("Entre com o peso da questão: ");
                    objetivas.setPeso(s.nextInt());
                    s.nextLine();
                    p.getListaQuestoes().add(objetivas);
                    
                }else if(tipoQuetao.equalsIgnoreCase("d")){
                    // criar discursiva
                    Discursiva disc;
                    disc=new Discursiva();
                    System.out.print("Digite a pergunta da questão: ");

                    disc.setPergunta(s.nextLine());
                    System.out.print("Digite o peso da questão: ");
                    disc.setPeso(s.nextDouble());
                    s.nextLine();
                    System.out.print("Digite o critério de avaliação da questão: ");
                    disc.setCriterioCorrecao(s.nextLine());
                    p.getListaQuestoes().add(disc);
                }else{
                    System.out.println("Opção inválida!!");
                }
                System.out.print("Deseja inserir uma questão ?");
                aux = s.nextLine();
            }
            String prova=p.obtemProvaImpressao();

            System.out.println("\n Impressao Prova:\n"+prova);
            System.out.print("Salvar em arquivo?(Sim/Nao)");
            String resposta=s.next();
            System.out.println(resposta);
            if(resposta.toLowerCase().equals("sim")){
                try{
                    System.out.print("Nome do arquivo com extensão: ");
                    String arquivoAbrir=s.next();
                    File aqrv=new File(arquivoAbrir);
                    try (FileWriter out = new FileWriter(aqrv)) {
                        out.write(prova);
                        Desktop.getDesktop().open(aqrv);
                    }
	  	}catch(Exception e){}   
            }
            JOptionPane.showMessageDialog(null, prova);
        }
       
        
    }
    
