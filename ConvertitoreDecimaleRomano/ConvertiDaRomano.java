package com.example.ConvertitoreDecimaleRomano;

import java.util.ArrayList;
import java.util.List;

public class ConvertiDaRomano {

    String input;

    List<MapRD> decimalRoman;

    List<Integer> parsedInput;

    List<Integer> subtracted;

    int risultato;

    public ConvertiDaRomano(String input) {
        this.input = input;

        decimalRoman = new ArrayList<>();

        decimalRoman.add(new MapRD("I", 1));
        decimalRoman.add(new MapRD("V", 5));
        decimalRoman.add(new MapRD("X", 10));
        decimalRoman.add(new MapRD("L", 50));
        decimalRoman.add(new MapRD("C", 100));
        decimalRoman.add(new MapRD("D", 500));
        decimalRoman.add(new MapRD("M", 1000));

        parseInput();
        subtract();
    }

    public Integer trovaCorrispettivoDecimale(String nrRoman, List<MapRD> lista){
        Integer result = lista.get(0).getDecimal();
        for (MapRD el : lista) {
            if (nrRoman.equals(el.getRoman())) {
                result = el.getDecimal();
            }
        }
        return result;
    }

    public void parseInput(){
        parsedInput = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            parsedInput.add(trovaCorrispettivoDecimale(input.substring(i,i+1), decimalRoman));
        }
    }

    public void subtract(){

        subtracted = new ArrayList<>();

        for (int i = 0; i < parsedInput.size(); i++) {

            if(i+1 >= parsedInput.size()){
                subtracted.add(parsedInput.get(i));
                break;
            }

            if(parsedInput.get(i) < parsedInput.get(i+1)) {
                subtracted.add(parsedInput.get(i+1) - parsedInput.get(i));
                i++;
                continue;
            }
            subtracted.add(parsedInput.get(i));
        }
    }

    public int getResult(){
        for (int i = 0; i < subtracted.size(); i++) {
            risultato+=subtracted.get(i);
        }
        return risultato;
    }
}
