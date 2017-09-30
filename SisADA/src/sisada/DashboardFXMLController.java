/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author elizandro
 */
public class DashboardFXMLController extends InterfaceUsuario {

    public DashboardFXMLController() {
        super("DashboardFXML.fxml");
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    ImageView grafico = new ImageView(new Image(getClass().getResourceAsStream("grafico.png")));
   
    
    @FXML
    ImageView formando = new ImageView(new Image(getClass().getResourceAsStream("formando.png")));

    @FXML
    public void minhasAvaliacoes(){
        MinhasAvaliacoesFXMLController telaMinhasAvaliacoes = new MinhasAvaliacoesFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(telaMinhasAvaliacoes);
        
    }
    
    @FXML
    public void meuDesempenho(){
        MeuDesempenhoFXMLController telaMeuDesempenho = new MeuDesempenhoFXMLController();
        GerenciadorJanela.obterInstancia().abreJanela(telaMeuDesempenho);
    }
    
}
