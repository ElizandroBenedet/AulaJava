/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ComboBox;
import static sisada.Avaliacao.obterListaAvaliacoes;

/**
 * FXML Controller class
 *
 * @author elizandro
 */
public class MeuDesempenhoFXMLController extends InterfaceUsuario {

    public MeuDesempenhoFXMLController() {
        super("MeuDesempenhoFXML.fxml");
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    BarChart grafico = new BarChart(new CategoryAxis(), new NumberAxis());
    
    @FXML
    private ComboBox botaoDisciplina;
    
    XYChart.Series media1 = new XYChart.Series();
    XYChart.Series media2 = new XYChart.Series();
    XYChart.Series media3 = new XYChart.Series();
    XYChart.Series mediaF = new XYChart.Series();

    

    ObservableList<String> listaBotaoDisciplina = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Seta as confs do ComboBox Disciplina
        ArrayList<Avaliacao> listaAvaliacao = obterListaAvaliacoes();
        for (int i = 0; i < listaAvaliacao.size(); i++) {
            String aux = listaAvaliacao.get(i).getDisciplina();
            if (!listaBotaoDisciplina.contains(aux)) {
                listaBotaoDisciplina.add(aux);
            }
        }
        botaoDisciplina.setItems(listaBotaoDisciplina);
        botaoDisciplina.setVisibleRowCount(5);
         
       
        
        mostraTabela(null);
        botaoDisciplina.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostraTabela(newValue));
        ObservableList<Series> listaTabela = FXCollections.observableArrayList(media1, media2, media3, mediaF);
        
        grafico.setData(listaTabela);
                
    }

    private void mostraTabela(Object avaliacao) {

        if (avaliacao != null) {
            
            
           
            

            media1.setName("M1");
            Double m1 = Avaliacao.calculaMediaDaDisciplina(botaoDisciplina.getValue().toString(), "M1");
            Double m2 = Avaliacao.calculaMediaDaDisciplina(botaoDisciplina.getValue().toString(), "M2");
            Double m3 = Avaliacao.calculaMediaDaDisciplina(botaoDisciplina.getValue().toString(), "M3");
            media1.getData().add(new XYChart.Data("", m1));

            media2.setName("M2");
            media2.getData().add(new XYChart.Data("", m2));

            media3.setName("M3");
            media3.getData().add(new XYChart.Data("", m3));
            mediaF.setName("Média Final");
            mediaF.getData().add(new XYChart.Data("",(m1+m2+m3)/3));
        }else{
            
            media1.setName("M1");
            media2.setName("M2");
            media3.setName("M3");
            mediaF.setName("Média Final");
        }
    }

    @FXML
    public void voltar() {
        GerenciadorJanela.obterInstancia().voltar();
    }

}
