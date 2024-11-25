public class Main {
    public static void main(String[] args) {
        App app = new App();
        
        medirTempo(app, "caso40_5a.txt");
        medirTempo(app, "caso80_5a.txt");
        medirTempo(app, "caso100_5a.txt");
        medirTempo(app, "caso120_5a.txt");
        medirTempo(app, "caso150_5a.txt");
        medirTempo(app, "caso180_5a.txt");
        medirTempo(app, "caso200_5a.txt");
        medirTempo(app, "caso250_5a.txt");
    }

    private static void medirTempo(App app, String arquivo) {
        long startTime = System.nanoTime(); // Início da medição
        app.start(arquivo);                 // Chamada do método
        long endTime = System.nanoTime();   // Fim da medição
        
        // Calculando e exibindo o tempo de execução
        long durationInNano = endTime - startTime;
        double durationInMillis = durationInNano / 1_000_000.0; // Convertendo para milissegundos
        System.out.printf("Tempo: %.2f ms%n", durationInMillis);
    }
}
