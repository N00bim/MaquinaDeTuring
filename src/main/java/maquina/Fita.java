package maquina;

import java.util.ArrayList;

public class Fita {
    private ArrayList<Character> fita;
    private int possicaoAtual;
    private char white;

    public Fita(char branco, String fita){
        this.white = branco;
        this.fita = new ArrayList<>();
        initFita(fita);
        possicaoAtual = 1;
    }

    private void initFita(String fita) {
        this.fita.add(white);
        for (char c: fita.toCharArray()){
            this.fita.add(c);
        }
        this.fita.add(white);
    }

    public boolean fazerTransicao(Transicao transicao){
        escreverSimboloAtual(transicao.getWrite());
        return moverFita(transicao.getDir());
    }

    private boolean moverFita(char dir){
        if(dir == 'R'){
            possicaoAtual++;
            return true;
        }
        if(dir == 'L'){
            if(possicaoAtual > 0){
                possicaoAtual--;
                return true;
            }
        }
        return false;
    }

    public char getSimboloAtual(){
        return fita.get(possicaoAtual);
    }

    private void escreverSimboloAtual(char c){
        fita.set(possicaoAtual, c);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fita.size(); i++) {
            sb.append(fita.get(i));
        }
        return sb.toString();
    }

}

