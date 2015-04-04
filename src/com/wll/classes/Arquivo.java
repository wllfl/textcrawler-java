
package com.wll.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author william
 */
public class Arquivo {
    
    private String nome;
    private long dataAlteracao;
    private String caminho;
    private String tamanho;
    private int qtdeExpEncontrada;
    private String conteudo;
    private String dataFinalAlteracao;
    
    /***************************************************************************************************************/
    
    public Arquivo(String nome, String caminho, long dataAlteracao, String tamanho, int qtdeExpEncontrada, String conteudo){
        this.setNome(nome);
        this.setDataAlteracao(dataAlteracao);
        this.setCaminho(caminho);
        this.setTamanho(tamanho);
        this.setQtdeExpEncontrada(qtdeExpEncontrada);
        this.setConteudo(conteudo);
    }
    
    /***************************************************************************************************************/
    
    public Arquivo(String nome, String caminho, long dataAlteracao, String tamanho){
        this.setNome(nome);
        this.setDataAlteracao(dataAlteracao);
        this.setCaminho(caminho);
        this.setTamanho(tamanho);
    }
    
    /***************************************************************************************************************/

    public String getNome() {
        return nome;
    }
    
    /***************************************************************************************************************/

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /***************************************************************************************************************/

    public long getDataAlteracao() {
        return dataAlteracao;
    }
    
    /***************************************************************************************************************/

    public void setDataAlteracao(long dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
        DateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");     
        this.setDataFinalAlteracao(formatData.format(new Date(dataAlteracao))); 
    }
    
    /***************************************************************************************************************/

    public String getCaminho() {
        return caminho;
    }

    /***************************************************************************************************************/
    
    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }
    
    /***************************************************************************************************************/

    public String getTamanho() {
        return tamanho;
    }

    /***************************************************************************************************************/

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    
    /***************************************************************************************************************/

    public int getQtdeExpEncontrada() {
        return qtdeExpEncontrada;
    }
    
    /***************************************************************************************************************/

    public void setQtdeExpEncontrada(int qtdeExpEncontrada) {
        this.qtdeExpEncontrada = qtdeExpEncontrada;
    }
    
    /***************************************************************************************************************/

    public String getConteudo() {
        return conteudo;
    }
    
    /***************************************************************************************************************/

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
    
    /***************************************************************************************************************/

    public String getDataFinalAlteracao() {
        return dataFinalAlteracao;
    }
    
    /***************************************************************************************************************/

    public void setDataFinalAlteracao(String dataFinalAlteracao) {
        this.dataFinalAlteracao = dataFinalAlteracao;
    }
    

}
