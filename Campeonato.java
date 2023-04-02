
public class Campeonato {
    // Atributos:
    Clube clubes[];

    // Construtor da Classe Campeonato:
    public Campeonato(Clube clubes[]) {
        this.clubes = clubes;
    }

    // Métodos:

    // jogarCampeonato: 
    //      - Arranjo da coleção de clubes 2 a 2: Clube jogos[];
    //      - Jogos de ida e volta.
    public void jogarCampeonato() {
        int k = 0;
        // O número de jogos de ida e volta = qtd. times * (qtd. times - 1):
        int num_jogos = clubes.length * (clubes.length - 1);
        // Arranjo dos jogos 2 a 2 tem um tamanho igual ao num_jogos * 2
        Clube jogos[] = new Clube[num_jogos*2];

        for(int i = 0; i < clubes.length; i++) {
            for(int j = 0; j < clubes.length; j++) {
                if(i == j || k >= num_jogos*2) {
                    continue;
                }
                jogos[k] = clubes[i];
                jogos[k+1] = clubes[j];
                k += 2;
            }
        }
        k = 0;
        for(int i = 0; i < num_jogos;i++) {
            jogarPartida(jogos[k], jogos[k+1]);
            k += 2;
        }
    }

    // jogarPartida:
    // Sortear um placar como sendo dois inteiros variando de 0 à 5.
    public void jogarPartida(Clube m, Clube v) {
        // Math.random() retorna um número aleatório entre 0.0 e 1.0
        int gols_m = (int)((Math.random() * 10) % 6);
        int gols_v = (int)((Math.random() * 10) % 6);

        if(gols_m > gols_v) {
            m.ganhar(gols_m - gols_v);
            v.perder(gols_v - gols_m);
        }
        else if(gols_m == gols_v) {
            m.empatar();
            v.empatar();
        }
        else {
            m.perder(gols_m - gols_v);
            v.ganhar(gols_v - gols_m);
        }
    }

    // getClassificação: 
    // Ordena a coleção de clubes pela pontuação, utilizando o saldo de gols para desempate.
    // Retorna uma String;
    public String getClassificacao(int maior){
        Clube aux;
        int j;
        String placar = "";

        // Ordenando por pontos
        for(int i = 0; i < clubes.length; i++) {
            j = 0;
            while(j < clubes.length) {
                if(j+1 == clubes.length) {
                    break;
                }
                if(clubes[j].pontos < clubes[j+1].pontos) {
                    aux = clubes[j+1];
                    clubes[j+1] = clubes[j];
                    clubes[j] = aux;
                }
                j++;
            }

        }

        // Ordenando por saldo
        for(int i = 0; i < clubes.length; i++) {
            j = 0;
            while(j < clubes.length) {
                if(j+1 == clubes.length) {
                    break;
                }
                if(clubes[j].pontos == clubes[j+1].pontos && clubes[j].saldoGols < clubes[j+1].saldoGols) {
                    aux = clubes[j+1];
                    clubes[j+1] = clubes[j];
                    clubes[j] = aux;
                }
                j++;
            }

        }
        // Formando a String placar
        // tam: 6 pois é o tamanho do nome "Grupos";
        placar += "Grupos" + imprimirEspacos(6) + "| Jogos | Pontos |  SG  |  V  |  E  |  D  \n";
        placar += "--------------------------------------------------------\n";

        for(int i = 0; i < clubes.length; i++) {
            placar += clubes[i].nome + imprimirEspacos(maior - clubes[i].nome.length());
            placar += "|  0";
            if(isMinus10(clubes[i].jogos)) {
                placar += "0";
            }
            placar += clubes[i].jogos + "  |   ";

            if(isMinus10(clubes[i].pontos)) {
                placar += "0";
            }
            placar += clubes[i].pontos + "   |";
            placar += imprimirEspacos(checkSaldo(clubes[i].saldoGols)) + clubes[i].saldoGols + "  |  " + clubes[i].vitorias + "  |  " + clubes[i].empates + "  |  " + clubes[i].derrotas + "\n";
        }

        return placar;
    }

    //getCampeao:
    // Imprime uma mensagem parabenizando o campeão;
    public void getCampeao() {
        String campeao;
        campeao = "O " + clubes[0].nome + " ganhou o campeonato com uma pontuação de " + clubes[0].pontos + ".";
        System.out.println(campeao);
    }
    
    // imprimirEspacos:
    public String imprimirEspacos(int tam) {
        String placar = "";
        for(int k = 0; k <= tam; k++) {
            placar += " ";
        }
        return placar;
    }
    // imprimirPlacar:
    public void imprimirPlacar(String placar) {
        System.out.println(placar);
        System.out.println("--------------------------------------------------------");
    }

    // getLargestName:
    // Retorna a quantidade de letras do maior time cadastrado (int).
    public int getLargestName() {
        int maior = (clubes[0].nome).length();

        for(int i = 0; i < clubes.length; i++) {
            if((i+1) >= clubes.length) {
                break;
            }
            if(maior > (clubes[i+1].nome).length()) {
                continue;
            }
            else {
                maior = (clubes[i+1].nome).length();
            }
        }
        System.out.println(maior);
        return maior + 1;
    }

    // isMinus:
    // Checa se o número passado é menor do que 10.
    public boolean isMinus10(int numero) {
        if(numero < 10) {
            return true;
        }
        else {
            return false;
        }
    }

    // checkSaldo:
    // Faz checagens no saldo de gols
    public int checkSaldo(int saldo) {
        // Se o saldo de gols for um inteiro negativo menor do que -9, ele ocupara 3 espaços na tabela.
        // Assim, não precisamos adicionar espaços vazios.
        if(saldo < -9) {
            return 0;
        }
        // Se o saldo de gols for um inteiro negativo menor do que 0 ou um inteiro positivo maior do que 10.
        // Ele ocupa 2 espaços na tabela, assim, temos que adicionar 1 espaço vazio.
        else if(saldo < 0 || saldo > 9) {
            return 1;
        }
        // Caso contrário, se ele for um inteiro positivo maior do que 0 e menor do que 10.
        // Precisamos adicionar 2 espaços vazios, pois ele ocupa apenas 1 espaço na tabela.
        else {
            return 2;
        }
    }
}



