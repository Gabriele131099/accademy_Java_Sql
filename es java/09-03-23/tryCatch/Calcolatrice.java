package tryCatch;
// Creare una classe menu e una classe calcolatrice che permetta 3 operazioni, 
// e che salvi in un array fino a 4 risultati e gestire su i suoi input l'errore di 
// creazione e il limite array
public class Calcolatrice {
    int num1;
    int num2;
    double tot;
    Calcolatrice(int a, int b){
        this.num1 = a;
        this.num2 = b;
    }
    
    public int getNum1() {
        return num1;
    }
    public void setNum1(int num1) {
        this.num1 = num1;
    }
    public int getNum2() {
        return num2;
    }
    public void setNum2(int num2) {
        this.num2 = num2;
    }
    public double getTot() {
        return tot;
    }
    public void setTot(double tot) {
        this.tot = tot;
    }
    public int somma() {
        int somma = this.num1 + this.num2;
        return somma;
    }
    public Double divisione() {
        Double division = (double) (this.num1 / this.num2);
        return division;
    }
    public int moltiplicazione() {
        int moltiplicazione = this.num1 * this.num2;
        return moltiplicazione;
    }
    public int sottrazione() {
        int sottrazione = this.num1 - this.num2;
        return sottrazione;
    }
    
}
