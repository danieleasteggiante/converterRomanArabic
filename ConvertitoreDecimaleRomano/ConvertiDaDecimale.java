package com.example.ConvertitoreDecimaleRomano;

import java.util.*;

public class ConvertiDaDecimale {

    List<MapRD> decimalRoman = new ArrayList<>();
    String input;

    List<String> posizionali;
    List<Double> daConvertire;

    String convertito="";

    int posizioneNuova;




    public ConvertiDaDecimale(String input) {
        this.input = input;

        decimalRoman.add(new MapRD("I", 1));
        decimalRoman.add(new MapRD("V", 5));
        decimalRoman.add(new MapRD("X", 10));
        decimalRoman.add(new MapRD("L", 50));
        decimalRoman.add(new MapRD("C", 100));
        decimalRoman.add(new MapRD("D", 500));
        decimalRoman.add(new MapRD("M", 1000));

        parseInput();
        convertitor();
    }

    public void parseInput(){
        posizionali = new ArrayList<>(Arrays.asList(input.split("")));
        daConvertire = new ArrayList<>(getMagnitude());
    }

    public void convertitor(){
        for (Double aDouble : daConvertire) {
            for (int j = decimalRoman.size() - 1; j >= 0; j--) {
                if (aDouble >= decimalRoman.get(j).getDecimal()) {
                    convertito += controller(aDouble, j, decimalRoman);
                    break;
                }
            }
        }
    }


    public  List<Double> getMagnitude(){
        daConvertire = new ArrayList<>();
        int j = posizionali.size()-1;
        for (int i = 0; i <= posizionali.size()-1 ; i++) {
            daConvertire.add(Double.parseDouble(posizionali.get(i))* Math.pow(10,j));
            j--;
        }

        return daConvertire;
    }


    public int getRightPosition(int posizione){

        boolean startUno = Objects.equals(String.valueOf(decimalRoman.get(posizione)), "1");
        posizioneNuova = posizione;
        if (!startUno) posizioneNuova--;
        return posizioneNuova;
    }

    public String convertiNumeroConResto(Double rest, int posizione, List<MapRD> listMap){
        String result = "";
        int posizioneNuova = getRightPosition(posizione);
        int treshold = 3 * decimalRoman.get(posizioneNuova).getDecimal();
        int repeater = (int) (rest / listMap.get(posizioneNuova).getDecimal());
        if (rest <= treshold) result = listMap.get(posizione).getRoman() + listMap.get(posizione-1).getRoman().repeat(repeater);
        if (rest > treshold) result = listMap.get(posizioneNuova).getRoman() + listMap.get(posizione+1).getRoman();
        return result;
    }

    public  String convertiNumeroSenzaResto(Double division, int posizione, List<MapRD> listMap){
        String result = "";
        if (division <=3) result = listMap.get(posizione).getRoman().repeat(division.intValue());
        if (division > 3) result = listMap.get(posizione).getRoman() + listMap.get(posizione+1).getRoman();
        return result;
    }

    public  String controller(Double decimal, int posizione, List<MapRD> listMap){
        String result;

        double division = decimal / listMap.get(posizione).getDecimal();
        double rest = decimal % listMap.get(posizione).getDecimal();


        if(rest > 1){
            result = convertiNumeroConResto(rest,posizione, listMap);
            return result;
        }

        if(division > 1){
            result = convertiNumeroSenzaResto(division,posizione, listMap);
            return result;
        }

        result = listMap.get(posizione).getRoman();
        return result;

    }

    public String getResult(){
        return convertito;
    }


}
