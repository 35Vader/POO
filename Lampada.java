public class Lampada {

    public enum Modo {
        ON,
        OFF,
        ECO
    }
    private Modo modo;
    // private int modo; <- maneira mais fácil
    private double cpSEco; //consumo por segundo Eco
    private double cpSOn; // consumo por segundo On
    private double consumoTotal;
    private double periodoConsumo;

    public Lampada() {
        modo = Modo.OFF;
        cpSEco = 1;
        cpSOn = 2;
        consumoTotal = 0;
        periodoConsumo = 0;
    }
    public Lampada(Modo x, double cpsE, double cpsO, double cT, double pC) {
        /*switch(x) {
            case ON: modo = Modo.ON;
                break;
            case OFF: modo = Modo.OFF;
                break;
            case ECO: modo = Modo.ECO;
                break;
        }*/
        cpSEco = cpsE;
        cpSOn = cpsO;
        modo = x;
        consumoTotal = cT;
        periodoConsumo = pC;
    }

    public Lampada(Lampada l) {
        modo = l.getModo();
        cpSEco = l.getCpSEco;
        cpSOn = l.getCpSOn;
        consumoTotal = l.getConsumoTotal;
        periodoConsumo = l.getPeriodoConsumo;
    }

    public Modo getModo() {
        return this.modo;
    }

    public void setModo(Modo m) {
        this.modo = m;
    }

    public double  getCpSEco() {
        return this.cpSEco;
    }

    public void setCpSEco(double x) {
        this.cpSEco = x;
    }

    public double  getCpSOn() {
        return this.cpSOn;
    }

    public void setCpSOn(double y) {
        this.cpSOn = y;
    }

    public double getConsumoTotal() {
        return this.consumoTotal;
    }

    public void setConsumoTotal(double cT) {
        this.consumoTotal = cT;
    }

    public double getPeriodoConsumo() {
        return this.periodoConsumo;
    }

    public void setPeriodoConsumo(double pC) {
        this.periodoConsumo = pC;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if((o == null) || (this.getClass() != o.getClass())) return false;

        Lampada l = (Lampada) o;
        return l.getModo() == this.modo &&
                l.getCpSEco() == this.cpSEco &&
                l.getCpSOn() == this.cpSOn &&
                l.getConsumoTotal() ==  this.consumoTotal &&
                l.getPeriodoConsumo() == this.periodoConsumo;
    }

    public Lampada clone() {
        return new Lampada(this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lampada: ").append(this.modo)
                .append("\nConsumoTotal:").append(this.consumoTotal)
                .append("\nInicio do ultimo consumo:").append(this.periodoConsumo);
        return sb.toString();
    }

    public void calculaEco() {
        this.consumoTotal += (System.currentTimeMillis() - this.periodoConsumo) * this.cpSEco;
        this.periodoConsumo = System.currentTimeMillis();
    }

    public void calculaON() {
        this.consumoTotal += (System.currentTimeMillis() - this.periodoConsumo) * this.cpSEco;
    }

    //a
    public void lampON() {
        if(this.modo == Modo.ECO) {
            calculaEco();
        }
        this.periodoConsumo = System.currentTimeMillis();
        this.modo = Modo.ON;
    }

    //b
    public void  lampOFF() {
        if(this.modo == Modo.ECO) {
            calculaEco();
        }
        if(this.modo == Modo.ON) {
            calculaON();
        }
        this.periodoConsumo = System.currentTimeMillis();
        this.modo = Modo.OFF;
    }

    //c
    public void lampECO() {
        if(this.modo == Modo.ON) {
            calculaON();
        }
        this.periodoConsumo = System.currentTimeMillis();
        this.modo = Modo.ECO;
    }

    //d
    public double totalCOnsumo() {
        return periodoConsumo() + consumoTotal;
    }

    //e
    public double periodoConsumo() {
        double atual = 0;
        if(modo == Modo.ON) atual = (System.currentTimeMillis() - this.periodoConsumo) * this.cpSOn;
        else if(modo == Modo.ECO) atual = (System.currentTimeMillis() - this.periodoConsumo) * this.cpSEco;
        return atual;
    }
}
