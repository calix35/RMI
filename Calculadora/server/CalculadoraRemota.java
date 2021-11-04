package server;

import common.Calculadora;

public class CalculadoraRemota implements Calculadora {
    public float suma (float a, float b){
        return a + b;
    }

    public float resta(float a, float b){
        return a - b;
    }

    public float multiplicacion (float a, float b){
        return a * b;
    }

    public float division (float a, float b){
        return a / b;
    }
}