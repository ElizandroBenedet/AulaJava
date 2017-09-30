/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisada;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author elizandro
 */
public class SisADA extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage)  {
        DashboardFXMLController dashboard = new DashboardFXMLController();
        
        primaryStage.setMaxWidth(630);
        primaryStage.setMaxHeight(430);
        primaryStage.setMinWidth(630);
        primaryStage.setMinHeight(430);
        primaryStage.setTitle("Minha Univali");
        GerenciadorJanela.obterInstancia().inicializaPalco(primaryStage, dashboard);
    }
    
}

