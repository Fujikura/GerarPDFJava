package br.com.marcio.app;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutos{


    public List<Produto> retornaLista() {

        List<Produto> produtos = new ArrayList<Produto>();

        Produto produto1 = new Produto(1, "Coca-Cola", 4.50, 9.00, 10);
        Produto produto2 = new Produto(2, "Bolacha Salgada", 2.30, 4.60, 20);

        produtos.add(produto1);
        produtos.add(produto2);

        return produtos;

    }
}
