
package com.wll.classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author william
 */
public class Log {
    
    private static int qtdeLinhas = 10;

    /***************************************************************************************************************/
    
    public static void lerLog(String path, JComboBox combo){
        try{
            File arquivo = new File(path);
            
            if (arquivo.exists()){
                FileReader fr = new FileReader(path);
                BufferedReader br = new BufferedReader(fr);

                while(br.ready()){
                    String linha = br.readLine();
                    combo.addItem(linha);
                }

                br.close();
                fr.close();
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao carregar combo: " + ex.getMessage());
        }
    }
    
    /***************************************************************************************************************/
    
     public static void gravarLog(String path, String linha){
        try{
            File arquivo = new File(path);
            FileWriter fw = null;
            
            if (!arquivo.exists()){
                arquivo.createNewFile();
                fw = new FileWriter(arquivo, true);
                fw.write(linha + "\n");
            }else{
                fw = new FileWriter(arquivo, true);
                BufferedReader buffer = new BufferedReader(new FileReader(path));
                String texto = "";
                int contLinha = 1;
                Boolean isExiste = false;
                while ((texto = buffer.readLine()) != null) {  
                    if (texto.equals(linha) || contLinha >= qtdeLinhas) {  
                       isExiste = true;
                    } 
                    contLinha++;
                }

                if(!isExiste){
                    fw.write(linha + "\n");
                }
            }
            fw.flush();
            fw.close();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Erro ao gravar log: " + ex.getMessage());
        }
    }
    
    /***************************************************************************************************************/
    
}
