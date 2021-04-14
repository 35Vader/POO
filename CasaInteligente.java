import javax.swing.plaf.basic.BasicTreeUI;
import java.util.ArrayList;
import java.util.Iterator;

public class CasaInteligente {
    private ArrayList<Lampada> lampadas;

    public CasaInteligente() {
        lampadas = new ArrayList<>();
    }

    public CasaInteligente(ArrayList<Lampada> l) {
        this.setLampadas(l);
    }

    public CasaInteligente(CasaInteligente ci) {
        this.setLampadas(ci.getLampadas());
    }

    public void setLampadas(ArrayList<Lampada> l) {
        lampadas = new ArrayList<>()     ;
        for(Lampada lamp : l) {
            lampadas.add(lamp.clone());
        }
    }

    public ArrayList<Lampada> getLampadas() {
        ArrayList<Lampada> l = new ArrayList<>();
        for(Lampada lamp : this.lampadas) {
            l.add(lamp.clone());
        }
    }

    //a
    public void addLampada(Lampada l) {
        lampadas.add(l.clone());
    }

    public void ligaLampadaNormal(int index) {
        lampadas.get(index).lampON();
    }

    public void ligaLampadaEco(int index) {
        lampadas.get(index).lampECO();
    }

    public int qtEmEco() {
        int r = 0;
        for(Lampada l : lampadas) {
            if(l.getModo() == Lampada.Modo.ECO) r++;
        }
        return r;
    }

    public int qtEmIterators() {
        int r = 0;
        Iterator<Lampada> it = lampadas.iterator();
        while(it.hasNext()) {
            Lampada l = it.next();
            if(l.getModo() == Lampada.Modo.ECO) r++;
        }
        return r;
    }

    public int qtEmStream() {
        int r = (int) lampadas.stream().filter(l -> l.getModo() == Lampada.Modo.ECO).count();
        return r;
    }

    public void removeLampada(int index) {
        lampadas.remove(index);
    }

    public void ligaTodasEco() {
        for (Lampada l : lampadas) {
            l.lampECO();
        }
    }

    public void ligaTodasMax() {
        lampadas.forEach(l -> l.lampON()); // nao e um stream
    }

    public double consumoTotal() {
        lampadas.stream().mapToDouble(l -> l.totalCOnsumo().sum());
    }
}
