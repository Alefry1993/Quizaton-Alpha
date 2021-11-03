package com.example.quizaton_alpha.Activities;

public class Spørsmål {
    private String spørsmålet;
    private String svaret;


    public Spørsmål(String spørsmålet, String svaret) {
        this.spørsmålet = spørsmålet;
        this.svaret = svaret;
    }

    public String getSpørsmålet() {
        return spørsmålet;
    }

    public void setSpørsmålet(String spørsmålet) {
        this.spørsmålet = spørsmålet;
    }

    public String getSvaret() {
        return svaret;
    }

    public void setSvaret(String svaret) {
        this.svaret = svaret;
    }
}
