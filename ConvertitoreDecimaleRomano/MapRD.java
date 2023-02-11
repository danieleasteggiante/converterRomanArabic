package com.example.ConvertitoreDecimaleRomano;

public class MapRD {
    String roman;
    Integer decimal;

    public MapRD(String roman, Integer decimal) {
        this.roman = roman;
        this.decimal = decimal;
    }

    public String getRoman() {
        return roman;
    }

    public void setRoman(String roman) {
        this.roman = roman;
    }

    public Integer getDecimal() {
        return decimal;
    }

    public void setDecimal(Integer decimal) {
        this.decimal = decimal;
    }
}
