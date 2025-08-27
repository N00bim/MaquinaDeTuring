package maquina;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LeitorJson {
    int initial;
    @SerializedName("final")
    List<Integer> finall;
    char white;
    List<Transicao> transitions;

    public int getInitial() {
        return initial;
    }

    public List<Integer> getFinall() {
        return finall;
    }

    public char getWhite() {
        return white;
    }

    public List<Transicao> getTransitions() {
        return transitions;
    }
}
