/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author HUY
 */
public class Equation1 {
    //field// attribute
    private double a;
    private double b;

    public Equation1() {//(parameter)
        this.a = 0;
        this.b = 0;
    }

    public Equation1(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
    
    //property: là những thuộc tính của hàm 
    public String getResult(){
        String result = "";
        if(a == 0){
            if(b == 0){
                result = "The equation is underfind";
            }else{
                result = "The equation has no solution.";
            }
        }else{
            result = String.format("x = %f", -b/a);
        }
        return result;
    }
    
}
