package maquina;

public class Transicao {
    private int from;
    private int to;
    private char read;
    private char write;
    private char dir;

    public Transicao(int from, int to, char read, char write, char dir) {
        this.from = from;
        this.to = to;
        this.read = read;
        this.write = write;
        this.dir = dir;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public char getRead() {
        return read;
    }

    public void setRead(char read) {
        this.read = read;
    }

    public char getDir() {
        return dir;
    }

    public void setDir(char dir) {
        this.dir = dir;
    }

    public char getWrite() {
        return write;
    }

    public void setWrite(char write) {
        this.write = write;
    }
}
