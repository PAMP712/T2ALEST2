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
        long startTime = System.nanoTime();
        app.start(arquivo);
        long endTime = System.nanoTime();
        
        long duracaoNS = endTime - startTime;
        double duracaoMS = duracaoNS / 1000000;
        System.out.printf("Tempo: %.2f ms%n", duracaoMS);
    }
}
