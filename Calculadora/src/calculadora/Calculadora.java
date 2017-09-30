/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;



import java.util.Stack;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Elizandro
 */
public class Calculadora extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Calculadora de expressão");
      
        // Orquestrador
        VBox tela = new VBox ();
        tela.setStyle("-fx-background-color: #E1E1E1;");
       
        
        HBox titulo = new HBox();
        titulo.setAlignment(Pos.CENTER);
        //Label
        Label textoCentral = new Label ("Calculadora de expressão");
        textoCentral.setFont(new Font ("Arial", 28));
        textoCentral.setTextFill(Color.web("#8B0000"));

       titulo.getChildren().add(textoCentral);
       
       HBox expressao2 = new HBox ();
       
        // Label da expressao
        Label expressao = new Label();
        expressao.setAlignment(Pos.CENTER);
        expressao.setFont(new Font("Ariel", 30));
        expressao.setText("Insira uma expressão...");
        
        expressao2.setAlignment(Pos.CENTER);
        
        expressao2.getChildren().add(expressao);

        
//        for ( int i = 0; i < bt.length; i++) {
//            bt[i] = new Button();
//            bt[i].setGraphic(new ImageView(new Image(getClass().getResourceAsStream(i+".png"))));
//            if(i<10){
//                bt[i].setOnAction(new EventHandler<ActionEvent>() {
//                    @Override
//                    public void handle(ActionEvent event) {
//                        String exp = expressao.getText() + Integer.toString(i);
//                        expressao.setText(exp);
//                    }
//                });
//            }
//        }
         
        
        Label resultado = new Label();       
        resultado.setFont(new Font ("Arial", 28));
        resultado.setTextFill(Color.web("#8B0000"));
        
        HBox painelResult = new HBox();
        painelResult.setAlignment(Pos.CENTER);
        painelResult.getChildren().add(resultado);
       
        
        
        // Botões 
        Button mult = new Button();
        mult.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("12.png"))));
        mult.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "*";
                expressao.setText(exp);
            }else{
                expressao.setText("*");
            }
        });
        
        Button subt = new Button();
        subt.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("13.png"))));
        subt.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "-";
                expressao.setText(exp);
            }else{
                expressao.setText("-");
            }
        });
        
        Button soma = new Button();
        soma.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("10.png"))));
        soma.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "+";
                expressao.setText(exp);
            }else{
                expressao.setText("+");
            }
        });
        
        Button divi = new Button();
        divi.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("11.png"))));
        divi.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "/";
                expressao.setText(exp);
            }else{
                expressao.setText("/");
            }
        });
        
        // resolve a expressão
        Button igual = new Button();
        igual.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("14.png"))));
        igual.setOnAction((ActionEvent event) -> {
            ResultadoExpressao result = new ResultadoExpressao();
            Stack pilha = result.prefixa(expressao.getText());
            No arvore = new No();
            result.montar_arvore(pilha, arvore);
            float aux = result.resolver_arvore(arvore);
               
            resultado.setText(String.valueOf(aux ));
  
           
        });
        
        Button zero = new Button();
        zero.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("0.png"))));
        zero.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "0";
                expressao.setText(exp);
            }else{
                expressao.setText("0");
            }
        });
        
        Button um = new Button();
        um.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("1.png"))));
        um.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "1";
                expressao.setText(exp);
            }else{
                expressao.setText("1");
            }
        });
        
        Button dois = new Button();
        dois.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("2.png"))));
        dois.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "2";
                expressao.setText(exp);
            }else{
                expressao.setText("2");
            }
        });
        
        Button tres = new Button();
        tres.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("3.png"))));
        tres.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "3";
                expressao.setText(exp);
            }else{
                expressao.setText("3");
            }
        });
        
        Button quatro = new Button();
        quatro.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("4.png"))));
        quatro.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "4";
                expressao.setText(exp);
            }else{
                expressao.setText("4");
            }
        });
        
        Button cinco = new Button();
        cinco.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("5.png"))));
        cinco.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "5";
                expressao.setText(exp);
            }else{
                expressao.setText("5");
            }
        });
        
        Button seis = new Button();
        seis.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("6.png"))));
        seis.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "6";
                expressao.setText(exp);
            }else{
                expressao.setText("6");
            }
        });
        
        Button sete = new Button();
        sete.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("7.png"))));
        sete.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "7";
                expressao.setText(exp);
            }else{
                expressao.setText("7");
            }
        });
        
        Button oito = new Button();
        oito.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("8.png"))));
        oito.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "8";
                expressao.setText(exp);
            }else{
                expressao.setText("8");
            }
        });
        
        Button nove = new Button();
        nove.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("9.png"))));
        nove.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "9";
                expressao.setText(exp);
            }else{
                expressao.setText("9");
            }
        });
        
        Button abreP = new Button();
        abreP.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("16.png"))));
        abreP.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + "(";
                expressao.setText(exp);
            }else{
                expressao.setText("(");
            }
        });
        
        Button fechaP = new Button();
        fechaP.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("15.png"))));
        fechaP.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + ")";
                expressao.setText(exp);
            }else{
                expressao.setText(")");
            }
        });
        
        Button virgula = new Button();
        virgula.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("virgula.png"))));
        virgula.setOnAction((ActionEvent event) -> {
            if(!expressao.getText().equalsIgnoreCase("Insira uma expressão...")){
                String exp = expressao.getText() + ".";
                expressao.setText(exp);
            }else{
                expressao.setText(".");
            }
        });
        
        Button limpaExp = new Button();
        limpaExp.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("limpa.png"))));
        limpaExp.setOnAction((ActionEvent event) -> {            
            expressao.setText("Insira uma expressão...");
        });
        
        Button apaga = new Button();
        apaga.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("apaga.png"))));
        apaga.setOnAction((ActionEvent event) -> {
            String aux = expressao.getText();
            if(!"Insira uma expressão...".equals(aux)){
                if(aux.length() > 0){
                expressao.setText(expressao.getText().substring (0, expressao.getText().length() - 1));
                }
            }
        });
        
        HBox painel1 = new HBox();
        painel1.setSpacing(5);
        painel1.setAlignment(Pos.CENTER);
        painel1.getChildren().add(um);
        painel1.getChildren().add(dois);
        painel1.getChildren().add(tres);
        painel1.getChildren().add(soma);
        
        HBox painel2 = new HBox();
        painel2.setSpacing(5);
        painel2.setAlignment(Pos.CENTER);
        painel2.getChildren().add(quatro);
        painel2.getChildren().add(cinco);
        painel2.getChildren().add(seis);
        painel2.getChildren().add(subt);
        
        HBox painel3 = new HBox();
        painel3.setSpacing(5);
        painel3.setAlignment(Pos.CENTER);
        painel3.getChildren().add(sete);
        painel3.getChildren().add(oito);
        painel3.getChildren().add(nove);
        painel3.getChildren().add(divi);
        
        HBox painel4 = new HBox();
        painel4.setSpacing(5);
        painel4.setAlignment(Pos.CENTER);
        painel4.getChildren().add(zero);
        painel4.getChildren().add(virgula);
        painel4.getChildren().add(igual);
        painel4.getChildren().add(mult);
        
        
        HBox painelEdi = new HBox();
        painelEdi.setSpacing(5);
        painelEdi.setAlignment(Pos.CENTER);        
        painelEdi.getChildren().add(limpaExp);
        painelEdi.getChildren().add(apaga);
        painelEdi.getChildren().add(abreP);
        painelEdi.getChildren().add(fechaP);
        
        
        
       
        // Adicionando no orquestrador
        
        tela.getChildren().add(titulo);
        tela.getChildren().add(expressao2);
        tela.getChildren().add(painelEdi);
        tela.getChildren().add(painel1);
        tela.getChildren().add(painel2);
        tela.getChildren().add(painel3);
        tela.getChildren().add(painel4);
        tela.getChildren().add(painelResult);
       
        
        //Cena
        Scene cena = new Scene(tela, 350, 600);
        primaryStage.setScene(cena);
        primaryStage.setMaxWidth(360);
        primaryStage.setMinWidth(360);
        primaryStage.setMaxHeight(560);
        primaryStage.setMinHeight(560);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
