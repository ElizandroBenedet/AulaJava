/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author elizandro
 */
public class Avaliacao {
    
    private String nome;
    private String disciplina;
    private Double peso;
    private String media;
    private Double nota;
    
    
    public void salvar( ){
        try{
            File arquivo = new File ("notasSalvas.CSV");
            FileWriter escreveArq;
            
            if(arquivo.exists()){
                escreveArq = new FileWriter(arquivo, true);
            } else {
                escreveArq = new FileWriter(arquivo);
            }
            escreveArq.write(disciplina +","+media+","+nome+","+peso+"\n");              
            escreveArq.close();
            
        }catch(IOException e){
            System.err.print(e.getMessage());
        }
        
    }
    
    public void atualizar(){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("arquivo.tmp"));
            BufferedReader reader = new BufferedReader(new FileReader("notasSalvas.CSV"));

            String linha;
            while ((linha = reader.readLine()) != null) {
                String []aux = linha.split(",");
                if(aux[0].equals(disciplina) && aux[1].equals(media) 
                        && aux[2].equals(nome) && peso.equals(Double.parseDouble(aux[3]))){
                    linha = (disciplina +","+media+","+nome+","+peso+","+nota);
                    
                }
                writer.write(linha);
                writer.newLine();
            }

            writer.close();        
            reader.close();

            new File("notasSalvas.CSV").delete();
            new File("arquivo.tmp").renameTo(new File("notasSalvas.CSV"));
              
        }catch(IOException e){
            System.err.print(e.fillInStackTrace());
        }
    }
    
    static public ArrayList<Avaliacao> obterListaAvaliacoes(){
      
      ArrayList<Avaliacao> lista = new ArrayList<>();
      
      try{
            FileReader arquivo = new FileReader("notasSalvas.CSV");
            
            if(arquivo.ready()){
                try (BufferedReader lerArq = new BufferedReader(arquivo)) {
                    while(lerArq.ready()){
                        String linha = lerArq.readLine();
                        String[] atributos = linha.split(",");
                        
                        Avaliacao avaliacao = new Avaliacao();
                        avaliacao.setDisciplina(atributos[0]);
                        avaliacao.setMedia(atributos[1]);
                        avaliacao.setNome(atributos[2]);
                        avaliacao.setPeso(Double.parseDouble(atributos[3]));
                        if(atributos.length == 5)
                            avaliacao.setNota(Double.parseDouble(atributos[4]));
                        lista.add(avaliacao);            
                    }
                    lerArq.close();
                }catch(IOException e){
                    System.err.println(Arrays.toString(e.getStackTrace()));
                }
            }  
        }catch(IOException e){
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
      
        return lista;
      
    } 
    
    static public Double calculaMediaDaDisciplina(String disciplina, String media){
        
        Double notaMedia = 0.0;
        try{
            FileReader arquivo = new FileReader("notasSalvas.CSV");
            
            if(arquivo.ready()){
                try (BufferedReader lerArq = new BufferedReader(arquivo)) {
                    Double somaPeso = 0.0;
                    while(lerArq.ready()){
                        String linha = lerArq.readLine();
                        String[] atributos = linha.split(",");
                        if(atributos[0].equals(disciplina)){
                            if(atributos[1].equals(media) && atributos.length == 5){
                                 notaMedia += Double.parseDouble(atributos[3])*Double.parseDouble(atributos[4]);
                                 somaPeso+= Double.parseDouble(atributos[3])*1;
                            }
                        }
                    }
                    notaMedia /= somaPeso; 
                    lerArq.close();
                }catch(IOException e){
                    System.err.println(e.getMessage());
                }
            }  
        }catch(IOException e){
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
        
        if(notaMedia.isNaN())
            notaMedia= 0.0;
        
        return notaMedia;
    } 

    /**
     * @return the nome
     */
    public String getNome(){

        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the disciplina
     */
    public String getDisciplina() {
        return disciplina;
    }

    /**
     * @param disciplina the disciplina to set
     */
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    /**
     * @return the peso
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }

    /**
     * @return the media
     */
    public String getMedia() {
        return media;
    }

    /**
     * @param media the media to set
     */
    public void setMedia(String media) {
        this.media = media;
    }

    /**
     * @return the nota
     */
    public Double getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(Double nota) {
        this.nota = nota;
    }


    
    
}
