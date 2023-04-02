public class Clube {
    // Atributos
    String nome;
    int jogos;
    int vitorias;
    int empates;
    int derrotas;
    int pontos;
    int saldoGols;

    // Métodos

    public Clube(String nome) {
        this.nome = nome;
        this.jogos = 0;
        this.vitorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.pontos = 0;
        this.saldoGols = 0;
    }

    // (Incrementar os pontos e os saldos de gols de acordo com as regras).
    public void ganhar(int saldoGols) {
        this.jogos += 1;
        this.vitorias += 1;
        this.pontos += 3;
        this.saldoGols += saldoGols;
    }

    public void empatar() {
        this.jogos += 1;
        this.empates += 1;
        this.pontos += 1;
    }

    public void perder(int saldoGols) {
        this.jogos += 1;
        this.derrotas += 1;
        this.saldoGols += saldoGols;
    }

}