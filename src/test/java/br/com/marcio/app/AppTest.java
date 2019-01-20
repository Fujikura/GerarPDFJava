package br.com.marcio.app;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AppTest {
    private ListaProdutos listaProdutos;
    private List<Produto> produtos;
    private GeraPdf geraPdf;
    private Document document;
    private PdfPTable table;
    private static final String ARQUIVO_PDF = "Documento1.pdf";


    //INSTANCIA AS PROPRIEDADES ANTES DA EXECUÇÃO DE CADA TESTE
    @Before
    public void init(){

        produtos = new ArrayList<Produto>();
        ListaProdutos listaProdutos = new ListaProdutos();
        document = new Document();
        table = new PdfPTable(5);
        produtos = listaProdutos.retornaLista();
        geraPdf = new GeraPdf(document, table, produtos);
    }

    //TESTA A CRIAÇÃO DO METODO QUE RETORNA A LISTA DE PRODUTOS
    @Test
    public void deve_criar_lista_de_produtos_e_retornar_lista(){

        assertNotNull(produtos);
        assertTrue(produtos.size() > 0);
    }


    //verifica se o pdf foi criado no diretorio informado C:\PDF|Documento1.pdf
    @Test
    public void deve_criar_pdf() throws IOException {

        System.out.println(produtos.size());

        geraPdf.gerar("C:\\PDF\\" + ARQUIVO_PDF);

        File file = new File("C:\\PDF\\" + ARQUIVO_PDF);
        assertTrue(file.exists());

    }
}
