
package com.wll.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author william
 */
public class Crawler{
    
    private String caminho;
    private Boolean subPastas;
    private String extAceita;
    private String extRejeitada;
    private String expressao;
    private Boolean combinacaoPalavra;
    private int FTotalArquivos = 0;
    private int FTotalPastas = 0;
    private Arquivo arquivoTemp = null;
    private Arquivo arquivoFinal = null;
    private ArrayList<Arquivo> listaTemp = new ArrayList();
    public ArrayList<Arquivo> listaTFinal = new ArrayList();
    private DefaultListModel listaFile = new DefaultListModel(); 
    
    /***************************************************************************************************************/
    
    public Crawler(String caminho, Boolean subPastas, String extAceita, String extRejeitada){
        this.caminho = caminho;
        this.subPastas = subPastas;
        this.extAceita = extAceita;
        this.extRejeitada = extRejeitada;
    }
    
    /***************************************************************************************************************/
    
    public ArrayList<Arquivo> procuraExpressao(){
        try{
            for (Arquivo arquivo : listaTemp) {
                BufferedReader buffer = new BufferedReader(new FileReader(arquivo.getCaminho()));
                String linha = "";
                String conteudo = "";
                int contRepeticao = 0;
                int contLinha = 1;
                
                while ((linha = buffer.readLine()) != null) {  
                    if(this.combinacaoPalavra){
                        Pattern pattern = Pattern.compile(".* "+this.expressao+" .*");
                        Matcher matcher = pattern.matcher(linha);
                        if(matcher.matches()){
                            contRepeticao++;
                            conteudo += String.format("%-10s%-60s\n",contLinha, linha + "\n");
                        }
                    }else{
                        if (linha.contains(this.expressao)) {  
                            contRepeticao++;
                            conteudo += String.format("%-10s%-60s\n",contLinha, linha + "\n");
                        }  
                    }
                    contLinha++;
                }
                
                if (contRepeticao > 0){
                    this.arquivoFinal = new Arquivo(arquivo.getNome(), 
                                                           arquivo.getCaminho(), 
                                                           arquivo.getDataAlteracao(),
                                                           arquivo.getTamanho(),
                                                           contRepeticao,
                                                           conteudo);
                    this.listaTFinal.add(arquivoFinal);
                }
            }
            
            return this.listaTFinal;
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar expressão: " + ex.getMessage());
            return this.listaTFinal;
        }
    }
    
    /***************************************************************************************************************/
    
    public void contaPastas(String caminho){
        try{
            File file = new File(caminho);  
            File afile[] = file.listFiles();  
            int i = 0;
            for (int j = afile.length; i < j; i++) {   
                if(afile[i].isDirectory()){
                    this.FTotalPastas++;

                    if(this.subPastas){
                        this.contaPastas(afile[i].getCanonicalPath()); 
                        this.contaArquivos(afile[i].getCanonicalPath());
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao contar pastas: " + ex.getMessage());
        }
    }
    
    /***************************************************************************************************************/
    
    public void contaArquivos(String caminho){
        try{
            File file = new File(caminho);  
            File afile[] = file.listFiles();  
            int i = 0;
            for (int j = afile.length; i < j; i++) {          
                if(afile[i].isFile()){
                    if(this.isArquivoAceito(this.extAceita, afile[i]) && 
                       !this.isArquivoRejeitado(this.extRejeitada, afile[i]) && 
                       !this.isArquivoRejeitadoFiltro(this.extAceita, this.extRejeitada, afile[i])){
                        
                        this.FTotalArquivos++;
                        arquivoTemp = new Arquivo(afile[i].getName(), afile[i].getCanonicalPath(), afile[i].lastModified(), String.valueOf(afile[i].length()));
                        listaTemp.add(arquivoTemp);
                    }
                }
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao contar arquivos: " + ex.getMessage());
        }
    }
    
    /***************************************************************************************************************/
    
    private Boolean isArquivoAceito(String filtroAceito, File file){
        try{
            Boolean retorno = false;
            if(filtroAceito.equals("*.*")){
                retorno = true;
            }else if (!filtroAceito.equals("*.*")){
                
                String[] arrayFilter = filtroAceito.split("\\.");
                String[] arrayFile = file.getName().split("\\.");

                //Compara pelo nome do arquivo
                if(!arrayFilter[0].equals("*") && arrayFilter[1].equals("*")){
                    retorno = arrayFile[0].equals(arrayFilter[0]);

                      //Compara pela extensão do arquivo
                }else if(arrayFilter[0].equals("*") && !arrayFilter[1].equals("*")){
                    retorno = (arrayFile.length > 1) ? arrayFile[1].equals(arrayFilter[1]) : false;

                      // Compara por nome e extensão do arquivo
                }else if(!arrayFilter[0].equals("*") && !arrayFilter[1].equals("*")){
                    retorno = (arrayFile[0].equals(arrayFilter[0]) && 
                               (arrayFile.length > 1) ? arrayFile[1].equals(arrayFilter[1]) : false);
                }
            }
            
            return retorno;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro filtro de aceitação: " + ex.toString());
            return false;
        }
    }
    
    /***************************************************************************************************************/
    
    private Boolean isArquivoRejeitado(String filtroRejeitado, File file){
        try{
            Boolean retorno = false;
                
             if(filtroRejeitado.equals("*.*")){
                retorno = false;
            }else if (!filtroRejeitado.equals("*.*")){
                String[] arrayFilter = filtroRejeitado.split("\\.");
                String[] arrayFile = file.getName().split("\\.");

                //Compara pelo nome do arquivo
                if(!arrayFilter[0].equals("*") && arrayFilter[1].equals("*")){
                    retorno = arrayFile[0].equals(arrayFilter[0]);

                      //Compara pela extensão do arquivo
                }else if(arrayFilter[0].equals("*") && !arrayFilter[1].equals("*")){
                    retorno = (arrayFile.length > 1) ? arrayFile[1].equals(arrayFilter[1]) : false;

                      // Compara por nome e extensão do arquivo
                }else if(!arrayFilter[0].equals("*") && !arrayFilter[1].equals("*")){
                    retorno = (arrayFile[0].equals(arrayFilter[0]) && 
                               (arrayFile.length > 1) ? arrayFile[1].equals(arrayFilter[1]) : false);
                }
            }
            
            return retorno;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro filtro de rejeição: " + ex.getMessage());
            return false;
        }
    }
    
    /***************************************************************************************************************/
    
    private Boolean isArquivoRejeitadoFiltro(String filtroAceito, String filtroRejeitado, File file){
        try{
            return (this.isArquivoAceito(filtroAceito, file) && this.isArquivoRejeitado(filtroRejeitado, file));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro filtro rejeição específica: " + ex.getMessage());
            return false;
        }
    }

    /***************************************************************************************************************/
    
    public int getFTotalArquivos() {
        return FTotalArquivos;
    }

    /***************************************************************************************************************/
    
    public int getFTotalPastas() {
        return FTotalPastas;
    }
    
    /***************************************************************************************************************/

    public String getExpressao() {
        return expressao;
    }
    
    /***************************************************************************************************************/

    public void setExpressao(String expressao) {
        this.expressao = expressao;
    }
    
    /***************************************************************************************************************/

    public Boolean getCombinacaoPalavra() {
        return combinacaoPalavra;
    }
    
    /***************************************************************************************************************/

    public void setCombinacaoPalavra(Boolean combinacaoPalavra) {
        this.combinacaoPalavra = combinacaoPalavra;
    }
}
