/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

public abstract class Figura implements IFigura {
    
    protected final float base;
    protected final float altura;
    
    public Figura(float base, float altura){
        this.base = base;
        this.altura = altura;
    }

    public float getBase() {
        return base;
    }

    public float getAltura() {
        return altura;
    }

    @Override
    public float calcularArea() {
        return base * altura;
    }

    @Override
    public float calcularPerimetro() {
        return (base * 2) + (altura * 2);
    }
    
    
    
}
