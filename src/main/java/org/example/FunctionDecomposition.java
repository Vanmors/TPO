package org.example;

public class FunctionDecomposition {
    public static double decompose(int precision, double value){
        if (precision <= 0) throw new RuntimeException();
        if (precision == 1){
            return value;
        }
        if (precision == 2){
            return value + Math.pow(value, 3) / 6d;
        }

        double result = value + Math.pow(value, 3) / 6d;
        long lastOdd = 1;
        double lastCoefficient = 1d / 2d;
        for (int i = 2; i < precision; i++){
            lastOdd += 2;
            result += lastCoefficient * (lastOdd) * Math.pow(value, (lastOdd + 2)) / ((lastOdd + 1) * (lastOdd + 2));
        }
        return result;
    }
}