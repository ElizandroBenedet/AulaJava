/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author elizandro
 */
public class InformarNotaFXMLController extends InterfaceUsuario {

    /**
     * @return the nome
     */
    public String getNome() {
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
    
        
    public InformarNotaFXMLController() {
        super("InformarNotaFXML.fxml");
    }
    
    private String nome;
    private String disciplina;
    private String media;
    private Double peso;

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private Label lbMedia;
            
    @FXML 
    private Label lbNome;
    
    @FXML 
    private Label lbPeso;
    
    @FXML
    private Label lbDisciplina;
    
    @FXML
    private TextField campoNota;
    
    @FXML
    public void voltar(){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @FXML
    public void salvar(){
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setDisciplina(disciplina);
        avaliacao.setMedia(media);
        avaliacao.setNome(nome);
        avaliacao.setPeso(peso);
        
        avaliacao.setNota(Double.parseDouble(campoNota.getText()));
        avaliacao.atualizar();
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lbDisciplina.setText(disciplina);
        lbMedia.setText(media);
        lbNome.setText(nome);
        lbPeso.setText(peso.toString());
        
        
    }    
    
    
   
    
    
}
