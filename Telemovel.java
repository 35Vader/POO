import java.util.Arrays;
public class Telemovel {
    private String Marca;
    private String Modelo;
    private int DisplayX;
    private int DisplayY;

    private String [] Mensagens;
    private int NumMensagens;

    private int DimTotal;
    //private int DimFotos;
    //private int DimApps;
    private int DimOcupada;
    private int NumFotos;

    private int NumApps;
    private String [] NomeApps;

    public Telemovel () {
        this.Marca = "Pingo Doce";
        this.Modelo = "XPTO3000";
        this.DisplayX = 800;
        this.DisplayY = 600;

        this.Mensagens = new String [100];
        this.NumMensagens = 0;

        this.DimTotal = 300;
        //this.DimFotos = 0;
        //this.DimApps = 0;
        this.DimOcupada = 0;

        this.NumFotos = 0;

        this.NumApps = 0;
        this.NomeApps = new String [10];
    }

    public  Telemovel (String nmarca, String  nmodelo, int nDisplayX, int nDisplayY, String [] nmensagens,
                       int nNumMensagens, int nDimTotal, int nDimOcupada, int nNumFotos, int nNumApps,
                       String [] nNomeApps) {
        this.Marca = nmarca;
        this.Modelo = nmodelo;
        this.DisplayX = nDisplayX;
        this.DisplayY = nDisplayY;

        //composiçao = clones
        //Agregaçao = no clones

        this.setMensagens (nmensagens);
        this.NumMensagens = nNumMensagens;

        this.DimTotal = nDimTotal;
        //this.DimFotos = 0;
        //this.DimApps = 0;
        this.DimOcupada = nDimOcupada;

        this.NumFotos = nNumFotos;

        this.NumApps = nNumApps;
        this.NomeApps = nNomeApps;
    }

    public Telemovel (Telemovel x) {
        setMarca(x.getMarca());
        setModelo(x.getModelo());

        setDisplayX(x.getDisplayX());
        setDisplayY(x.getDisplayY());

        setMensagens(x.getMensagens());
        setNumMensagens(x.getNumMensagens());

        setDimTotal(x.getDimTotal());
        //this.DimFotos = 0;
        //this.DimApps = 0;
        setDimOcupada (x.getDimOcupada());

        setNumFotos (x.getNumFotos());

        setNumApps (x.getNumApps());
        setNomeApps (x.getNomeApps());
    }

    public String getMarca () {
        return this.Marca;
    }

    public void setMarca (String s) {
        this.Marca = s;
    }

    public String getModelo () {
        return this.Modelo;
    }

    public void setModelo (String m) {
        this.Modelo = m;
    }

    public int getDisplayX () {
        return this.DisplayX;
    }

    public void setDisplayX (int nDisplayX) {
        this.DisplayX = nDisplayX;
    }

    public int getDisplayY () {
        return this.DisplayY;
    }

    public void setDisplayY (int nDisplayY) {
        this.DisplayY = nDisplayY;
    }

    public String [] getMensagens () {
        String [] r = new String [this.Mensagens.length];
        r = Arrays.copyOf (this.Mensagens, this.Mensagens.length);
        return r;
    }

    public void setMensagens (String [] newMensagens) {
        this.Mensagens = Arrays.copyOf (newMensagens, newMensagens.length);
    }

    public int getNumMensagens () {
        return this.NumMensagens;
    }

    public void setNumMensagens (int nNumMensagens) {
        this.NumMensagens = nNumMensagens;
    }

    public int getDimTotal () {
        return this.DimTotal;
    }

    public void setDimTotal (int nDimTotal) {
        this.DimTotal = nDimTotal;
    }

    public int getDimOcupada () {
        return this.DimOcupada;
    }

    public void setDimOcupada (int nDimOcupada) {
        this.DimOcupada = nDimOcupada;
    }

    public int getNumFotos () {
        return this.NumFotos;
    }

    public void setNumFotos (int nNumFotos) {
        this.NumFotos = nNumFotos;
    }

    public int getNumApps () {
        return this.NumApps;
    }

    public void setNumApps (int nNumApps) {
        this.NumApps = nNumApps;
    }

    public boolean existeEspaco (int numeroBytes) {
        return DimTotal >= (DimOcupada + numeroBytes);
    }

    public String [] getNomeApps () {
        String [] r = new String [this.NomeApps.length];
        r = Arrays.copyOf (this.NomeApps, this.Mensagens.length);
        return r;
    }

    public void setNomeApps (String [] newNomeApps) {
        this.NomeApps = Arrays.copyOf (newNomeApps, newNomeApps.length);
    }

    void instalaApp (String nome, int tamanho) {
        if (!existeEspaco (tamanho)) return;
        else {
            //inserir app
            if (NumApps == NomeApps.length) NomeApps = Arrays.copyOf (NomeApps, NomeApps.length * 2);
            NomeApps [NumApps++] = nome;
            //adicionar bytes
            DimOcupada += tamanho;
        }
    }

}
