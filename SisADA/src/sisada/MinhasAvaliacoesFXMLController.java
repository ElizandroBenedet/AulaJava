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
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static sisada.Avaliacao.obterListaAvaliacoes;

/**
 * FXML Controller class
 *
 * @author elizandro
 */
public class MinhasAvaliacoesFXMLController extends InterfaceUsuario {

    public MinhasAvaliacoesFXMLController() {
        super("MinhasAvaliacoesFXML.fxml");
    }
    
    ArrayList<Avaliacao> lista = obterListaAvaliacoes();

    /**
     * Initializes the controller class.
     */
    
    @FXML
    TableView <Avaliacao>tabela = new TableView<>();
    
    @FXML
    TableColumn<Avaliacao, String> colunaNome = new TableColumn<>();
    
    @FXML
    TableColumn<Avaliacao, String> colunaDisciplina = new TableColumn<>();
        
    @FXML
    TableColumn<Avaliacao, char[]> colunaMedia = new TableColumn<>();
    
    @FXML
    TableColumn<Avaliacao, Double> colunaPeso = new TableColumn<>();
    
    @FXML
    TableColumn<Avaliacao, Double> colunaNota = new TableColumn<>();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaDisciplina.setCellValueFactory(new PropertyValueFactory<>("disciplina"));
        colunaMedia.setCellValueFactory(new PropertyValueFactory<>("media"));
        colunaPeso.setCellValueFactory(new PropertyValueFactory<>("peso"));
        colunaNota.setCellValueFactory(new PropertyValueFactory<>("nota"));
                
        tabela.setItems(FXCollections.observableArrayList(obterListaAvaliacoes()));
    }    
    
    @FXML
    public void voltar(){
        GerenciadorJanela.obterInstancia().voltar();
    }
    
    
    
    @FXML
    public void informarNota(){
        
        InformarNotaFXMLController telaInformarNota = new InformarNotaFXMLController();
        telaInformarNota.setDisciplina(tabela.getSelectionModel().getSelectedItem().getDisciplina());
        telaInformarNota.setPeso(tabela.getSelectionModel().getSelectedItem().getPeso());
        telaInformarNota.setMedia(tabela.getSelectionModel().getSelectedItem().getMedia());
        telaInformarNota.setNome(tabela.getSelectionModel().getSelectedItem().getNome());
        
        System.out.println(tabela.getSelectionModel().getSelectedItem().getMedia());
        GerenciadorJanela.obterInstancia().abreJanela(telaInformarNota);
    }
    
    @FXML
    public void novaAvaliacao(){
        NovaAvaliacaoFXMLController telaNovaAvaliacao = new NovaAvaliacaoFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(telaNovaAvaliacao);
    }
    
}
