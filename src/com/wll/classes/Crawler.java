
package com.wll.classes;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author william
 */
public class Crawler {
    
    private String caminho;
    private Boolean subPastas;
    private String extAceita;
    private String extRejeitada;
    private int FTotalArquivos = 0;
    private int FTotalPastas = 0;
    private Arquivo arquivoTemp = null;
    private Arquivo arquivoFinal = null;
    private ArrayList<Arquivo> listaTemp = new ArrayList();
    private ArrayList<Arquivo> listaTFinal = new ArrayList();
    private DefaultListModel listaFile = new DefaultListModel(); 
    
    /***************************************************************************************************************/
    
    public Crawler(String caminho, Boolean subPastas, String extAceita, String extRejeitada){
        this.caminho = caminho;
        this.subPastas = subPastas;
        this.extAceita = extAceita;
        this.extRejeitada = extRejeitada;
    }
    
    /***************************************************************************************************************/
    
    public ArrayList<Arquivo> procuraExpressao(String expressao){
        try{
            for (Arquivo arquivo : listaTemp) {
                BufferedReader buffer = new BufferedReader(new FileReader(arquivo.getCaminho()));
                String linha = "";
                String conteudo = "";
                int contRepeticao = 0;
                
                while ((linha = buffer.readLine()) != null) {  
                    if (linha.contains(expressao)) {  
                        contRepeticao++;
                        conteudo += linha + "\n";
                    }  
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
                    retorno = (arrayFile[0].equals(arrayFilter[0]) && arrayFile[1].equals(arrayFilter[1]));
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
                    retorno = arrayFile[1].equals(arrayFilter[1]);

                      // Compara por nome e extensão do arquivo
                }else if(!arrayFilter[0].equals("*") && !arrayFilter[1].equals("*")){
                    retorno = (arrayFile[0].equals(arrayFilter[0]) && arrayFile[1].equals(arrayFilter[1]));
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

    public void procuraExpressao(JTextField edtFind) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /***************************************************************************************************************/
}
