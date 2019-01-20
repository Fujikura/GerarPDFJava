package br.com.marcio.app;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static GeraPdf geraPdf;
    private static Document document;
    private static PdfPTable table;
    private static final String arquivoPdf = "Relatório de Produtos";




    public static void main(String[] args) {

        Document document = new Document();
        table = new PdfPTable(5);
        GeraPdf geraPdf = new GeraPdf(document, table, criaListaProdutos());


        geraPdf.gerar(arquivoPdf);
    }
    
    
    public static List<Produto> criaListaProdutos(){
        
        List<Produto> produtos = new ArrayList<Produto>();

        Produto produto = new Produto(1, "Coca-Cola", 4.50, 9.00, 50);
        Produto produto2 = new Produto(2, "Calça Jean Masculina", 40.00, 80.00, 10);

        produtos.add(produto);
        produtos.add(produto2);

        return produtos;
        
        
        
    }
}
