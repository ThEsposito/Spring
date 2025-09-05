package com.esposito.theo.first_spring_app;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static int fatorialRecursivo(int n){
        if(n==0)return 1;
        return n*fatorialRecursivo(n-1);
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fatorialRecursivo(n));
    }
}
