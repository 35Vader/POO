import java.util.ArrayList;
import java.time.LocalDateTime;

public class EncomendaEficiente {

    private String nomeCliente;
    private int NIF;
    private String morada;
    private int codEncomenda;
    private LocalDateTime data;
    private ArrayList<LinhaEncomenda> linhas;

    public EncomendaEficiente() {
        this.nomeCliente = "";
        this.NIF = 0;
        this.morada = "";
        this.codEncomenda = 0;
        this.data = LocalDateTime.now();
        this.linhas = new ArrayList<>();
    }

    public EncomendaEficiente (String nomeCliente, int nif, String morada, int cogEncomenda, ArrayList<LinhaEncomenda> linhas) {
        this.nomeCliente = nomeCliente;
        this.NIF = nif;
        this.morada = morada;
        this.codEncomenda = codEncomenda;
        this.data = LocalDateTime.now();
        this.setLinhas(linhas);
    }

    public EncomendaEficiente(EncomendaEficiente e) {
        this.nomeCliente = e.getNome();
        this.NIF = e.getNif();
        this.morada = e.getMorada();
        this.codEncomenda = e.getCodEncomenda();
        this.data = LocalDateTime.now();
        this.setLinhas(e.getLinhas());
    }

    public String getNome() {
        return this.nomeCliente;
    }

    public int getNif() {
        return this.NIF;
    }

    public String getMorada() {
        return this.morada;
    }

    public int getCodEncomenda() {
        return this.codEncomenda;
    }

    public LocalDateTime getData() {
        return this.data;
    }

    public ArrayList<LinhaEncomenda> getLinhas() {
        ArrayList<LinhaEncomenda> aux = new ArrayList<>();

        for (LinhaEncomenda i : this.linhas) {
            aux.add(i);
        }
        return aux;
    }

    public void setNome(String nome) {
        this.nomeCliente = nome;
    }

    public void setNif(int nif) {
        this.NIF = nif;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public void setID(int codEncomenda) {
        this.codEncomenda = codEncomenda;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public void setLinhas(ArrayList<LinhaEncomenda> linhas) {
        this.linhas = new ArrayList<>();

        for (LinhaEncomenda l : linhas)
            this.linhas.add(l);
    }

    public EncomendaEficiente clone(){
        return new EncomendaEficiente(this);
    }

    public boolean equals(Object o){
        if(o == this) return true;
        if(o == null || o.getClass() != this.getClass()) return false;

        EncomendaEficiente aux = (EncomendaEficiente) o;
        if (aux.linhas.size() != this.linhas.size())
            return false;

        for(int i = 0; i < this.linhas.size(); i++){
            if (!(this.linhas.get(i).equals(aux.linhas.get(i))))
                return false;
        }
        return (this.nomeCliente.equals(aux.getNome())) &&
                (this.morada.equals(aux.getMorada())) &&
                (this.NIF == aux.getNif()) &&
                (this.codEncomenda == aux.getCodEncomenda());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ");
        sb.append(this.nomeCliente + "\n");
        sb.append("N fiscal: ");
        sb.append(this.NIF + "\n");
        sb.append("Morada: ");
        sb.append(this.morada + "\n");
        sb.append("ID: ");
        sb.append(this.codEncomenda + "\n");
        sb.append("Data: ");
        sb.append(this.data + "\n");
        this.linhas.forEach(a -> sb.append(a.toString() + "\n"));

        return sb.toString();
    }

    public double calculaValorTotal() {
        double total = 0;
        for (LinhaEncomenda l : this.linhas) {
            total += l.calculaValorLinhaEnc();
        }
        return total;
    }

    public double valorTotalDesconto() {
        double total = 0.0;
        for (LinhaEncomenda l : this.linhas) {
            total += l.calculaValorDesconto();
        }
        return total;
    }

    public int numeroTotalProdutos() {
        int total = 0;
        for (LinhaEncomenda l : this.linhas) {
            total += l.getQuantidade();
        }
        return total;
    }


    public boolean existeProdutoEncomenda(String refProduto) {
        boolean f = false;
        for (LinhaEncomenda l : this.linhas) {
            if (l.getReferencia().equals(refProduto)){
                f = true;
                break;
            }
        }
        return f;
    }

    public void adicionaLinha(LinhaEncomenda linha) {
        this.linhas.add(linha);
    }

    public void removeProduto(String codProd) {
        int i = 0;
        for (LinhaEncomenda l : this.linhas) {
            if (l.getReferencia().equals(codProd)) {
                this.linhas.remove(i);
                break;
            }
            i++;
        }
    }

}

