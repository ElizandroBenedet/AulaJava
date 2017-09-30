/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

/**
 *
 * @author Elizandro
 */
public class No {
    No esquerda;
    No direita;
    Operacao valor;    
    public static No raiz;
    
    public No(){
        
    }
    
    
    public static void inserir(Operacao valor){
        inserir(raiz, valor);
    }
    
    public static void inserir(No node, Operacao valor){
        if(node == null){
            raiz = new No(valor);
        }else{
            
            
        }
    }

//    public No(No node){
//        this.valor = node.valor;            
//    }
    public No(Operacao node){
        this.valor = node;   
        this.direita = new No();
        this.esquerda = new No();
    }
}
