package br.com.marcio.app;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class GeraPdf {

    private Document document;
    private PdfPTable table;
    private List<Produto> lista;


    public GeraPdf(Document document, PdfPTable table, List<Produto> lista) {
        this.document = document;
        this.table = table;
        this.lista = lista;
    }

    public void gerar(String nomeArquivoPdf){

        try {

            PdfWriter.getInstance(document, new FileOutputStream(nomeArquivoPdf));
            document.open();

            Paragraph paragrafo = new Paragraph(nomeArquivoPdf + "\n" + "\n");
            paragrafo.setAlignment(1);
            document.add(paragrafo);

            paragrafo = new Paragraph("");
            document.add(paragrafo);

            table = new PdfPTable(5);

            PdfPCell codigo = new PdfPCell(new Paragraph("Código"));
            PdfPCell descricao = new PdfPCell(new Paragraph("Descrição"));
            PdfPCell valorCompra = new PdfPCell(new Paragraph("Valor de Compra"));
            PdfPCell valorVenda = new PdfPCell(new Paragraph("Valor de Venda"));
            PdfPCell qtdEStoque = new PdfPCell(new Paragraph("Qtd. em Estoque"));

            table.addCell(codigo);
            table.addCell(descricao);
            table.addCell(valorCompra);
            table.addCell(valorVenda);
            table.addCell(qtdEStoque);


            preenchePdf();


            document.add(table);

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }finally{
            document.close();
        }

        try {
            Desktop.getDesktop().open(new File(nomeArquivoPdf));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void preenchePdf() {

        PdfPCell celula6;
        PdfPCell celula7;
        PdfPCell celula8;
        PdfPCell celula9;
        PdfPCell celula10;

        for(Produto p : lista){
            celula6 = new PdfPCell(new Paragraph(p.getIdProduto()));
            celula7 = new PdfPCell(new Paragraph(p.getDescricao()+""));
            celula8 = new PdfPCell(new Paragraph(p.getValorCompra()+""));
            celula9 = new PdfPCell(new Paragraph(p.getValorVenda()+""));
            celula10 = new PdfPCell(new Paragraph(p.getQtdEstoque()));

            table.addCell(celula6);
            table.addCell(celula7);
            table.addCell(celula8);
            table.addCell(celula9);
            table.addCell(celula10);
        }
    }
}
