package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double a;
    private double b;
    private boolean pocetakIntervala;
    private boolean krajIntervala;
    public Interval(double a, double b, boolean pocetakIntervala,
                    boolean krajIntervala) {

        if(a>b){
            throw new IllegalArgumentException("Danas je lijep dan");
        }

        this.a = a;
        this.b = b;
        this.pocetakIntervala = pocetakIntervala;
        this.krajIntervala = krajIntervala;
    }

    public Interval(){
        a = 0;
        b = 0;
        this.pocetakIntervala = false;
        this.krajIntervala = false;
    }

    public Interval intersect(Interval i){


        double min, max;
        boolean pocetak = false;
        boolean kraj = false;
        if(this.a > i.a){
            min = this.a;
            pocetak = this.pocetakIntervala;
        }
        else{
            min = i.a;
            pocetak = i.pocetakIntervala;
        }

        if(this.b > i.b){
            max = i.b;
            kraj = i.krajIntervala;
        }
        else{
            max = this.b;
            kraj = this.krajIntervala;
        }

        if(min >= max){
            return new Interval();
        }
        else{
            return new Interval(min,max,pocetak, kraj);
        }
    }
    public static Interval intersect(Interval i1, Interval i2){

        double min, max;
        boolean pocetak = false;
        boolean kraj = false;
        if(i1.a > i2.a){
            min = i1.a;
            pocetak = i1.pocetakIntervala;
        }
        else{
            min = i2.a;
            pocetak = i2.pocetakIntervala;
        }

        if(i1.b > i2.b){
            max = i2.b;
            kraj = i2.krajIntervala;
        }
        else{
            max = i1.b;
            kraj = i1.krajIntervala;
        }

        if(min >= max){
            return new Interval();
        }
        else{
            return new Interval(min,max,pocetak, kraj);
        }


    }
    public boolean isNull(){
        if(a == b){
            return true;
        }
        else{
            return false;
        }

    }
    public boolean isIn(double x){
        if(this.pocetakIntervala == true && x == a){
            return true;
        }
        else if(this.krajIntervala == true && x == b){
            return true;
        }
        else if(x>a && x < b){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        String prvaZagrada, drugaZagrada;
        if(this.pocetakIntervala == true){
            prvaZagrada = "[";
        }
        else{
            prvaZagrada = "(";
        }

        if(this.krajIntervala == true){
            drugaZagrada = "]";
        }
        else{
            drugaZagrada = ")";

        }
        return prvaZagrada + this.a + "," + this.b + drugaZagrada;
    }

    public boolean equals(Interval i){
        if(this.a == i.a && this.b == i.b && this.pocetakIntervala == i.pocetakIntervala
                && this.krajIntervala == i.krajIntervala){
            return true;
        }
        else {
            return false;
        }
    }




}
