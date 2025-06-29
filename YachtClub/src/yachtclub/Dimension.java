
package yachtclub;

public class Dimension {
    private double manga; //ancho
    private double eslora; //largo

    public Dimension(double manga, double eslora) {
        this.manga = manga;
        this.eslora = eslora;
    }

    public void setManga(double manga) {
        this.manga = manga;
    }

    public void setEslora(double eslora) {
        this.eslora = eslora;
    }

    public double getManga() {
        return manga;
    }

    public double getEslora() {
        return eslora;
    }

    @Override
    public String toString() {
        return "Manga: " + manga + "m, Eslora: " + eslora + "m";
    }
    
    
    
}
