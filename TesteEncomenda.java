import java.time.LocalDate;
import java.util.ArrayList;

public class TesteEncomenda {

    public static void main(String[] args){
        LinhaEncomenda e1 = new LinhaEncomenda("abc", "Teste1", 20.0, 14, 0.23, 0.4);
        LinhaEncomenda e2 = new LinhaEncomenda("def", "Teste2", 10.0, 10, 0.23, 0.5);
        LinhaEncomenda e3 = new LinhaEncomenda("ghi", "Teste3", 30.0, 24, 0.23, 0.1);
        LinhaEncomenda e4 = new LinhaEncomenda("xyz", "Teste4", 150.0, 2, 0.23, 0.1);

        ArrayList<LinhaEncomenda> encomendas = new ArrayList<>(3);
        encomendas.add(e1);
        encomendas.add(e2);
        encomendas.add(e3);

        EncomendaEficiente e = new EncomendaEficiente("Andre", 1234, "Braga", 14, encomendas);

        System.out.println("Valor total vendido: " + e.calculaValorTotal() + "\n");
        System.out.println("Valor total desconto: " + e.valorTotalDesconto() + "\n");
        System.out.println("Numero total produtos: " + e.numeroTotalProdutos() + "\n");
        System.out.println(e.existeProdutoEncomenda("abc") + "\n");
        System.out.println(e.existeProdutoEncomenda("a") + "\n");

        e.adicionaLinha(e4);
        System.out.println("Numero total produtos: " + e.numeroTotalProdutos() + "\n");
        String s = e.toString();
        System.out.println(s);
        e.removeProduto("def");
        String p = e.toString();
        System.out.println(p);
        EncomendaEficiente j = e.clone();
        System.out.println(e.equals(j));
    }
}
