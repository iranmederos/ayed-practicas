package tp.practica2.ejercicio9;

public class NodoInfo {
    int suma;
    int dif;

    public NodoInfo(int suma, int dif){
        this.suma = suma;
        this.dif = dif;
    }

    public int getSuma(){
        return suma;
    }

    public void setSum(int suma) {
        this.suma = suma;
    }

    public int getDif(){
        return dif;
    }

    public void setDif(int dif) {
        this.dif = dif;
    }

    @Override
    public String toString(){
        return "Suma: " + suma + ", Diferencia: " + dif;
    }
}
