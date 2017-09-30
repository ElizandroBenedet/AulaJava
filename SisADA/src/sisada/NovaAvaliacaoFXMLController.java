/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author elizandro
 */
public class NovaAvaliacaoFXMLController extends InterfaceUsuario {

    public NovaAvaliacaoFXMLController() {
        super("NovaAvaliacaoFXML.fxml");
    }

    ObservableList<String> listaBotaoMedia = FXCollections.observableArrayList("M1", "M2", "M3");
    ObservableList<String> listaBotaoDisciplina = FXCollections.observableArrayList(
            "ADMINISTRAÇÃO DE NEGÓCIOS DE BASE TECNOLÓGICA",
            "ÁLGEBRA I",
            "ÁLGEBRA II",
            "ALGORITMOS E PROGRAMAÇÃO I",
            "ALGORITMOS E PROGRAMAÇÃO II",
            "ANÁLISE DE CIRCUITOS ELÉTRICOS",
            "ANÁLISE E CONTROLE DE PROCESSOS",
            "ARQUITETURA DE COMPUTADORES I",
            "ARQUITETURA DE COMPUTADORES  II",
            "BANCO DE DADOS",
            "CIRCUITOS DIGITAIS",
            "COMUNICAÇÃO DIGITAL",
            "CONTROLE LÓGICO DE SISTEMAS",
            "CÁLCULO I",
            "CÁLCULO II",
            "CÁLCULO III",
            "CÁLCULO NUMERICO",
            "DESENHO TÉCNICO",
            "ELETRÔNICA APLICADA",
            "ELETRÔNICA BÁSICA",
            "ENGENHARIA DE SOFTWARE I",
            "ENGENHARIA DE SOFTWARE II",
            "ENGENHARIA ECONÔMICA",
            "ESTRUTURAS DE DADOS",
            "ÉTICA EM INFORMÁTICA",
            "FÍSICA GERAL",
            "FÍSICA III",
            "GERÊNCIA DE PROJETOS",
            "GRAFOS",
            "INICIAÇÃO TÉCNICO-CIENTÍFICA",
            "INTELIGÊNCIA ARTIFICIAL",
            "INTERFACE HUMANO - COMPUTADOR",
            "INTRODUÇÃO A ENGENHARIA DE COMPUTAÇÃO",
            "INTRODUÇÃO AO CÁLCULO",
            "INTRODUÇÃO À FÍSICA",
            "LINGUAGENS FORMAIS",
            "MATEMÁTICA APLICADA À ENGENHARIA",
            "MATEMÁTICA COMPUTACIONAL",
            "MICROCONTROLADORES",
            "ÓTICA E FÍSICA PARA SEMICONDUTORES",
            "PROBABILIDADE E ESTATÍSTICA",
            "PROCESSADOR DIGITAL DE SINAIS",
            "PROGRAMAÇÃO ORIENTADA A OBJETOS I",
            "PROGRAMAÇÃO ORIENTADA A OBJETOS II",
            "PROJETO DE SISTEMAS DIGITAIS",
            "PROJETO DE SISTEMAS EMBARCADOS",
            "QUÍMICA I",
            "QUÍMICA II",
            "REDES DE COMPUTADORES I",
            "REDES DE COMPUTADORES II",
            "RESISTÊNCIA DOS MATERIAIS",
            "SIMULAÇÃO DISCRETA",
            "SISTEMAS DISTRIBUÍDOS",
            "SISTEMAS EM TEMPO REAL",
            "SISTEMAS OPERACIONAIS",
            "SISTEMAS ROBÓTICOS",
            "TCC I",
            "TCC II",
            "TCC III",
            "TÓP. ESPECIAIS EM INTEGRAÇÃO SOFTWARE HARDWARE",
            "TÓPICOS ESPECIAIS EM ENGENHARIA DE COMPUTAÇÃO", 
            "TÓPICOS ESPECIAIS EM HARDWARE");


    
    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoPeso;

    @FXML
    private ComboBox botaoDisciplina;

    @FXML
    private ComboBox botaoMedia;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botaoDisciplina.setVisibleRowCount(5);
        botaoMedia.setValue("M1");
        botaoMedia.setItems(listaBotaoMedia);
        botaoDisciplina.setItems(listaBotaoDisciplina);
    }

    @FXML
    public void voltar() {
        GerenciadorJanela.obterInstancia().voltar();
    }

    @FXML
    public void salvar() {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setDisciplina(botaoDisciplina.getValue().toString());
        avaliacao.setMedia(botaoMedia.getValue().toString());
        avaliacao.setNome(campoNome.getText());
        avaliacao.setPeso(Double.parseDouble(campoPeso.getText()));
        avaliacao.salvar();
        GerenciadorJanela.obterInstancia().voltar();

    }

}
