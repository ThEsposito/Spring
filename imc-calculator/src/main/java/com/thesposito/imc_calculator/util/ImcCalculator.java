package com.thesposito.imc_calculator.util;

// Estamos criando essa classe pra não bagunçar o service. Faremos a chamada desses
// métodos por lá.

public class ImcCalculator {
    public static double calcularAlturaCm(double alturaM){
        return alturaM * 100;
    }

    public static double calcularPesoIdeal(double alturaCm, double pesoKg){
        return (alturaCm - 100) - ((alturaCm-pesoKg)/4)*(5.0/100);
    }

    public static double calcularImc(double alturaM, double pesoKg){
        return pesoKg / (alturaM * alturaM);
    }

    public static String interpretarImc(double imc){
        if(imc < 20.0) return "Baixo Peso";
        if(imc < 25.0) return "Normal";
        if(imc <= 30.0) return "Acima do Peso";
        return "Obeso";
    }
}
