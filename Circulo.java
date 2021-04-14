public class Circulo {
    private double x;
    private double y;
    private double raio;

    public Circulo () {
        this.x = 0;
        this.y = 0;
        this.raio = 1;
    }

    public  Circulo (double cx, double cy, double nraio) {
        this.x = cx;
        this.y = cy;
        this.raio = nraio;
    }
    public Circulo (Circulo c) {
        this.x = c.getX();
        this.y = c.getY();
        this.raio = c.getRaio();
    }

    //a
    public double getX() {
        return  this.x;
    }

    //b
    public double getY() {
        return  this.y;
    }

    //c
    public double getRaio() {
        return  this.raio;
    }

    //d
    public void setX (double cx) {
        this.x = cx;
    }

    public void setY (double cy) {
        this.y = cy;
    }

    public void setRaio (double nraio) {
        this.raio = nraio;
    }

    //e
    public void alteraCentro (double newx, double newy) {
        this.setX (newx);
        this.setY (newy);
    }

    //f  area circulo = pi * r * r
    public double calculaArea () {
        return  Math.PI * this.getRaio () * this.getRaio ();
    }

    //g  perimetro circulo = 2 * pi * r
    public double calculaPerimetro () {
        return  Math.PI * this.getRaio () * 2;
    }

    public boolean equals (Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass () != o.getClass ())) return false;
        Circulo c = (Circulo) o;
        return (this.getX () == c.getX () && this.getY () == c.getY () && this.getRaio () == c.getRaio ());
    }

    public  Circulo clone () {
        return  new Circulo (this);
    }

    public String toString () {
        return ("X: " + this.getX () + " - Y " + y + " - Raio: " + this.raio);
    }
}

