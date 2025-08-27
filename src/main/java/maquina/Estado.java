package maquina;

import java.util.ArrayList;

public class Estado {
    private int numEstado;
    private ArrayList<Transicao> transicoes;
    private boolean estadoFinal;

    public Estado(int id) {   // recebe o id do JSON
        this.numEstado = id;
        this.transicoes = new ArrayList<>();
        this.estadoFinal = false;
    }

    public void addTansicao(int from, int to, char read, char write, char dir){
        transicoes.add(new Transicao(from, to, read, write, dir));
    }

    public void addTansicao(Transicao t){
        transicoes.add(t);
    }

    public Transicao buscarTransicao(char read){
        for(Transicao t: transicoes){
            if(t.getRead() == read){
                return t;
            }
        }
        return null;
    }

    public void setEstadoFinal(boolean estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public boolean isEstadoFinal() {
        return estadoFinal;
    }

    public int getNumEstado() {
        return numEstado;
    }
}
