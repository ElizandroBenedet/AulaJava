/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.util.Stack;


/**
 *
 * @author Elizandro
 */
public class ResultadoExpressao {
    
    private float resultado;
    
    private int precedencia(char caracter){           
        int caracteres= 0;
        if('(' == caracter){
            caracteres = 1;
        }else if(caracter == '+' || caracter == '-') {
            caracteres = 2;
        }else if(caracter == '*' || caracter == '/'){
            caracteres = 3;
        }
        return caracteres;
    }
    
    // verifica se é numero ou nao. Verifica com base no codigo ASCII
    private boolean operando(char caracter){
        if(caracter > 47 && caracter < 58)
            return true;
        else
            return false;
    } 
    
    // verifica se é operador ou nao
     boolean operador(char caracter){
        String operadores = "+-*/";       
        for(int i=0; i<4; i++){
            if(caracter == operadores.charAt(i)){
                return true;
            }
        }
        return false;
    }
   
    
     Stack prefixa(String expressao){
        Stack pilhaOP = new Stack();
        Stack pilhaPrefixa = new Stack();
        Stack pilhaExp = new Stack();
        int a = expressao.length();
        String auxString;
        auxString = "";
        String exp = "";

        for(int i = 0; i<a;i++){                    // retirando espaços da expressao
            if(expressao.charAt(i) != ' '){
                exp += expressao.charAt(i);
            }
        }

        a = exp.length();
        for(int i =0; i<a;i++){
            if(operador(exp.charAt(i))){
                if(operando(exp.charAt(i+1)) || exp.charAt(i+1) == '.' ){
                    if(operador(exp.charAt(i-1)) || i == 0 || exp.charAt(i-1) == '('){   // condição para o operador ser apenas o sinal do operando
                        auxString = "";

                        if(exp.charAt(i+1) == '.'){
                            auxString += exp.charAt(i);
                            auxString += '0';               // caso for orimeiro o ponto, inserir o 0 na frente : .3 -> 0.3
                             i++;
                        }
                        while(operando(exp.charAt(i+1)) || exp.charAt(i+1)=='.'){    // concatenar todos os caracteres do operando
                            auxString+=exp.charAt(i);
                            i++;
                        }
                        auxString+=exp.charAt(i);
                        if(exp.charAt(i) == '.'){              // caso o ponto ser ultimo, colocar um zero: 3. -> 3.0
                            auxString+= '0';
                        }
                        Operacao dado = new Operacao();                     // cria o dado a ser inserido na pilha
                        dado.setInf(1);                   // notar que foi definido o valor 1 para operando
                        dado.setOp(auxString);
                        pilhaExp.add(dado);
                    }else{                          // caso nao for operando, é um operador.
                        auxString = ""+exp.charAt(i);
                        Operacao dado = new Operacao();
                        dado.setInf(2);
                        dado.setOp(auxString);
                        pilhaExp.add(dado);
                    }
                }else if(precedencia(exp.charAt(i)) == 2 && (operador(exp.charAt(i-1)) || i == 0 || (exp.charAt(i+1) == '(' && operador(exp.charAt(i-1) )))){
                    auxString = "*" ;
                    Operacao dado = new Operacao();                       // verifica se nao é um sinal mltiplicador. Ex: - (5+2)
                    dado.setInf(2);
                    dado.setOp (auxString);            // se sim, insere primeiro o sinal de multi e depois...
                    pilhaExp.add(dado);
                    if(exp.charAt(i) == '-'){
                        auxString = "-1" ;          // ... -1 para sinal negativo, ou...
                        dado.setInf(1);
                        dado.setOp(auxString);
                        pilhaExp.add(dado);
                    }else{
                        auxString = "1" ;           // 1 para sinal positivo
                        dado.setInf (1);
                        dado.setOp( auxString);
                        pilhaExp.add(dado);
                    }
                } else{                     // caso nao for sinal de multi, é um operador.
                    auxString = "" + exp.charAt(i) ;
                    Operacao dado = new Operacao();
                    dado.setInf( 2);           // notar que foi adotado o valor 2 para operador
                    dado.setOp( auxString);
                    pilhaExp.add(dado);
                }
            }else if(exp.charAt(i) == '('){
                auxString = "" +exp.charAt(i);
                Operacao dado = new Operacao();
                dado.setInf( 3);
                dado.setOp( auxString);
                pilhaExp.add(dado);
            }else if(exp.charAt(i) == ')'){
                auxString = ""+exp.charAt(i);
                Operacao dado = new Operacao();
                dado.setInf( 4);
                dado.setOp( auxString);
                pilhaExp.add(dado);
            }else if(operando(exp.charAt(i))){
                auxString = "";
                if(i != a - 1){
                while(operando(exp.charAt(i+1)) || exp.charAt(i+1)== '.'){    // concatena todos os caracteres
                    auxString+=exp.charAt(i);
                    i++;
                    if(i == a -1){
                    break;
                    }
                }
                }
                auxString+=exp.charAt(i);
                if(exp.charAt(i) == '.'){
                    auxString+= '0';
                }
                Operacao dado = new Operacao();
                dado.setInf( 1);
                dado.setOp( auxString);
                pilhaExp.add(dado);                   // e insere na pilha
            }else if(exp.charAt(i) == '.'){
                auxString = "0";
                if(i != a -1){
                while(operando(exp.charAt(i+1))){
                    auxString+= exp.charAt(i);
                    i++;
                    if(i == a -1)
                        break;
                }}
                auxString+= exp.charAt(i);
                Operacao dado = new Operacao();
                dado.setInf( 1);
                dado.setOp( auxString);
                pilhaExp.add(dado);
            }
        }
        Operacao str;
        Operacao auxTop;
        while(pilhaExp.empty() != true){
            auxTop = (Operacao) pilhaExp.pop();
            auxString = auxTop.getOp();

            if(auxTop.getInf() == 2){                        // se for operador
                if(pilhaOP.isEmpty()!= true){
                    str = (Operacao) pilhaOP.firstElement();
                    if(precedencia(str.getOp().charAt(0)) <= precedencia(auxTop.getOp().charAt(0))){  // e a procedencia  dele for maior que o topo da pilha de operandos
                        pilhaOP.add(auxTop);    // insere na mesma pilha
                    }else{
                        while(str.getInf() == 2 && precedencia(str.getOp().charAt(0)) > precedencia(auxTop.getOp().charAt(0)) && pilhaOP.isEmpty() != true){ //se nao,
                            pilhaPrefixa.add(pilhaOP.pop());// insere direto na pilha da expressao prefixa
                            if(!pilhaOP.isEmpty())
                                str = (Operacao) pilhaOP.firstElement();     // faz isso ate que encontrar outro de precedencia diferente
                        }
                        pilhaOP.add(auxTop);
                    }
                }else{
                    pilhaOP.add(auxTop);   // se a pilha de operando estiver vazia, insere direto nela.
                }
            }else if(auxTop.getInf() == 3){          // se for uma abertura de parentes, retira todos da pilha de operando, e
                str = (Operacao) pilhaOP.pop();             // insere direto na pilha prefixa.
                while(str.getInf() != 4){
                    pilhaPrefixa.add(str);    // ate encontrar um fechar parenteses
                    str = (Operacao) pilhaOP.pop();
                }
            }else if(auxTop.getInf() == 1){               // operando insre direto na pilha prefixa
                pilhaPrefixa.add(auxTop);
            }else if(auxTop.getInf() == 4){              // fecha parentes insere na pilha
                pilhaOP.add(auxTop);
            }
        }
        while(pilhaOP.isEmpty() != true){            // se ainda houver algum termo na pilha de operando,
            pilhaPrefixa.add(pilhaOP.pop());         // insere direto na pilha prefixa
        }
        return pilhaPrefixa;
    }
    
    public void montar_arvore(Stack pilha, No no){
        if(pilha.isEmpty() != true){
            Operacao str = new Operacao ((Operacao) pilha.pop());               // retira da pilha
            if(2 == str.getInf()){
                no.valor = str;
                no.esquerda = new No();
                montar_arvore(pilha, no.esquerda);
                no.direita = new No();
                montar_arvore(pilha, no.direita);
            }else{ 
                no.valor = str;
            }
            
        }
    }
    
    float resolver_arvore(No no){
        float aux1 = 0, aux2 = 0;
       
        if(no.valor.getInf() == 1){                      // se for operando, retorna seu valor ja convertido
             return Float.parseFloat(no.valor.getOp());
        }else if(no.valor.getInf() == 2){                // se for operador, recebe os termos de cada folha
            aux1 = resolver_arvore(no.esquerda);
            aux2 = resolver_arvore(no.direita);
        }

        if("+".equals(no.valor.getOp())){             // e resolve com base na operação.
            aux1 += aux2;
        }else if("-".equals(no.valor.getOp())){
            aux1 -= aux2;
        }else if ("*".equals(no.valor.getOp())) {
            aux1 *= aux2;
        }else if ("/".equals(no.valor.getOp())) {
            aux1 /= aux2;
        }
        return aux1;                    // retorna o valor calculado
}

    /**
     * @return the resultado
     */
    public float getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(float resultado) {
        this.resultado = resultado;
    }
    
    
    
}
