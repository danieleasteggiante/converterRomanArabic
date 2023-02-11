package com.example.ConvertitoreDecimaleRomano;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ApplicationConverInRoman {

    public static void main(String[] ars) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        if (input.matches("-?(0|[1-9]\\d*)")) {
            ConvertiDaDecimale converter =  new ConvertiDaDecimale(input);
            String romano = converter.getResult();
            System.out.println(romano);
        } else {

            ConvertiDaRomano converter =  new ConvertiDaRomano(input);
            int decimale = converter.getResult();
            System.out.println(decimale);

        }
    }
}
