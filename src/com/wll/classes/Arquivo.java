
package com.wll.classes;

/**
 *
 * @author william
 */
public class Arquivo {
    
    private String nome;
    private String dataAlteracao;
    private String caminho;
    private String tamanho;
    private int qtdeExpEncontrada;
    
    /***************************************************************************************************************/
    
    public Arquivo(String nome, String dataAlteracao, String caminho, String tamanho, int qtdeExpEcontrada){
        this.nome = nome;
        this.dataAlteracao = dataAlteracao;
        this.caminho = caminho;
        this.tamanho = tamanho;
        this.qtdeExpEncontrada = qtdeExpEcontrada;
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

    public String getDataAlteracao() {
        return dataAlteracao;
    }
    
    /***************************************************************************************************************/

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
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
    

}
