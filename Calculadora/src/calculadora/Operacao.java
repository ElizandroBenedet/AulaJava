/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import java.sql.Struct;

/**
 *
 * @author Elizandro
 */
public class Operacao {
    
    private int inf;
    private String op;
    private int neg;
    public Operacao(){
        
    }
    
    public Operacao(Operacao op){
        this.inf = op.inf;
        this.neg = op.neg;
        this.op = op.op;
    }
    
    
    /**
     * @return the inf
     */
    public int getInf() {
        return inf;
    }

    /**
     * @param inf the inf to set
     */
    public void setInf(int inf) {
        this.inf = inf;
    }

    /**
     * @return the op
     */
    public String getOp() {
        return op;
    }

    /**
     * @param op the op to set
     */
    public void setOp(String op) {
        this.op = op;
    }

    /**
     * @return the neg
     */
    public int getNeg() {
        return neg;
    }

    /**
     * @param neg the neg to set
     */
    public void setNeg(int neg) {
        this.neg = neg;
    }

    /**
     * @return the No
     */
}
