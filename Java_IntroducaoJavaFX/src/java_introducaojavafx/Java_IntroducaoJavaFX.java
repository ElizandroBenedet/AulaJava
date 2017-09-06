/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_introducaojavafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 2008777
 */
public class Java_IntroducaoJavaFX extends Application{


    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        System.out.print("O palco está pronto");

        //viewgroup
        VBox orquestrador = new VBox();
        orquestrador.setSpacing(10);
        orquestrador.setStyle("-fx-background-color: #babaca;");
        
        TextField num1 = new TextField();
        TextField num2 = new TextField();
        Label resultado = new Label("Resultado");
                
        Button botao = new Button("Somar");
        botao.setOnAction( new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                String valorNum1 = num1.getText();
                String valorNum2 = num2.getText();
                double num1EmDouble = Double.parseDouble(valorNum1);
                double num2EmDouble = Double.parseDouble(valorNum2);
                double numResultado = num1EmDouble + num2EmDouble;
                resultado.setText( "A soma é: "+numResultado);
            }
        } );
        
        //adicionando os views
        orquestrador.getChildren().add(num1);
        orquestrador.getChildren().add(num2);
        orquestrador.getChildren().add(botao);
        orquestrador.getChildren().add(resultado);
        
        Scene cena = new Scene(orquestrador, 500, 300);
        
        stage.setScene(cena);
        stage.setTitle("Meu primeiro programa");
        stage.show();
        
    }

    
}
