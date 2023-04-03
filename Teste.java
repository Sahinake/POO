public class Teste {
    public static void main(String[] args) {
        Clube clubes[] = new Clube[7];

        clubes[0] = new Clube("Atlético-MG");
        clubes[1] = new Clube("Botafogo");
        clubes[2] = new Clube("Corinthians");
        clubes[3] = new Clube("Flamengo");
        clubes[4] = new Clube("Palmeiras");
        clubes[5] = new Clube("São Paulo");
        clubes[6] = new Clube("Vasco");
    
        Campeonato brasileirao = new Campeonato(clubes);
        brasileirao.jogarCampeonato();
        brasileirao.imprimirPlacar(brasileirao.getClassificacao(brasileirao.getLargestName()));
        brasileirao.getCampeao();
    }
}
