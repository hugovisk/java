/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;


public class Triangulo extends Figura {
    
    public Triangulo(float base, float altura) {
        super(base, altura);
    }
    
    @Override
    public float calcularArea() {
        return super.base * super.altura / 2;
    }

    @Override
    public float calcularPerimetro() {
        return super.base * 3;
    }
}
