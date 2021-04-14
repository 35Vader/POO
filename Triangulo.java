public class Triangulo {
    private Ponto p1;
    private Ponto p2;
    private Ponto p3;

    public Triangulo() {
        p1 = new Ponto (0,0);
        p2 = new Ponto (1,0);
        p3 = new Ponto (0,1);
    }

    public Triangulo(Ponto np1, Ponto np2, Ponto np3) {
        p1 = np1.clone();
        p2 = np2.clone();
        p3 = np3.clone();
    }

    public Triangulo(Triangulo t) {
        p1 = t.getP1();
        p2 = t.getP2();
        p3 = t.getP3();
    }

    public Ponto getP1() {
        return p1.clone();
    }

    public Ponto getP2() {
        return p2.clone();
    }

    public Ponto getP3() {
        return p3.clone();
    }

    public void setP1(Ponto np1) {
        this.p1 = np1.clone();
    }

    public void setP2(Ponto np2) {
        this.p2 = np2.clone();
    }

    public void setP3(Ponto np3) {
        this.p3 = np3.clone();
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;

        Triangulo t = (Triangulo) o;
        //importa que pl seja exatamente igual a t.getP1(), ou seria possivel trocar os
        //pontos de ordem e ainda serem triangulos iguais?
        return (p1.equals(t.getP1()) && p2.equals(t.getP2()) && p3.equals(t.getP3()));
    }

    public Triangulo clone() {
        return new Triangulo(this);
    }

    public String toString() {
        return "Triangulo: \nP1: " + p1.toString() + "\nP2: " + p2.toString() + "\nP3: " + p3.toString();
    }

    public double calculaAreaTriangulo() { //herons formula
        double a = p1.distancia(p2);
        double b = p2.distancia(p3);
        double c = p3.distancia(p1);
        double s = (a + b + c) /2;
        double res = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return res;
    }

    public int altura() {
        int miny = Math.min(p1.getY(), Math.min(p2.getY(), p3.getY()));
        int maxy = Math.max(p1.getY(), Math.max(p2.getY(), p3.getY()));
        return maxy - miny;
    }
}