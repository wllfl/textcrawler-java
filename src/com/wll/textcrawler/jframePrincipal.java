
package com.wll.textcrawler;

import com.wll.classes.Arquivo;
import com.wll.classes.Crawler;
import com.wll.classes.Log;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author william
 */
public class jframePrincipal extends javax.swing.JFrame {

    private Crawler crawler;  
    private ArrayList<Arquivo> listaArquivo = null;
    DefaultListModel model = new DefaultListModel(); 
    
    /***************************************************************************************************************/

    public jframePrincipal() {
        initComponents();
        lblTotalArquivos.setVisible(false);
        lblTotalPastas.setVisible(false);
        JComboLocalPasta.addItem("");
        jComboFind.addItem("");
        Log.lerLog("LogLocalPasta", JComboLocalPasta);
        Log.lerLog("LogFind", jComboFind);
    }
    
     /***************************************************************************************************************/
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpanelFolder = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edtExtAceita = new javax.swing.JTextField();
        edtExtRejeitada = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ckbSubFolders = new javax.swing.JCheckBox();
        btnFindFolder = new javax.swing.JButton();
        JComboLocalPasta = new javax.swing.JComboBox();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        edtReplace = new javax.swing.JTextField();
        ckbCaseSensitive = new javax.swing.JCheckBox();
        ckbPalavraInteira = new javax.swing.JCheckBox();
        jComboFind = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistFile = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTextArea = new javax.swing.JTextArea();
        JProgress = new javax.swing.JProgressBar();
        lblTotalPastas = new javax.swing.JLabel();
        lblTotalArquivos = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ferramenta JTextCrawler");

        jpanelFolder.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Extensão Aceita");

        jLabel2.setText("Extensão Rejeitada");

        edtExtAceita.setText("*.*");

        edtExtRejeitada.setText("*.*");

        jLabel3.setText("Local da Pasta");

        ckbSubFolders.setSelected(true);
        ckbSubFolders.setText("Escanear Sub Pastas");
        ckbSubFolders.setToolTipText("Pesquisar dentro de sub pastas");
        ckbSubFolders.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnFindFolder.setText("...");
        btnFindFolder.setToolTipText("Selecione a pasta");
        btnFindFolder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFindFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindFolderActionPerformed(evt);
            }
        });

        JComboLocalPasta.setBackground(new java.awt.Color(255, 153, 153));
        JComboLocalPasta.setEditable(true);
        JComboLocalPasta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jpanelFolderLayout = new javax.swing.GroupLayout(jpanelFolder);
        jpanelFolder.setLayout(jpanelFolderLayout);
        jpanelFolderLayout.setHorizontalGroup(
            jpanelFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelFolderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanelFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanelFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelFolderLayout.createSequentialGroup()
                        .addComponent(JComboLocalPasta, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFindFolder))
                    .addGroup(jpanelFolderLayout.createSequentialGroup()
                        .addGroup(jpanelFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edtExtAceita, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edtExtRejeitada, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(ckbSubFolders)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jpanelFolderLayout.setVerticalGroup(
            jpanelFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelFolderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpanelFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnFindFolder)
                    .addComponent(JComboLocalPasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtExtAceita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(ckbSubFolders))
                .addGap(18, 18, 18)
                .addGroup(jpanelFolderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtExtRejeitada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Pesquisar em Pasta", jpanelFolder);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setText("Procurar por");

        jLabel5.setText("Substituir por");

        ckbCaseSensitive.setText("Case Sensitive ");
        ckbCaseSensitive.setToolTipText("Pesquisa deferenciando letras Maiúsculas de Minúsculas");
        ckbCaseSensitive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ckbPalavraInteira.setText("Palavra inteira");
        ckbPalavraInteira.setToolTipText("Pesquisa somente por combinação em palavras");
        ckbPalavraInteira.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jComboFind.setEditable(true);
        jComboFind.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(edtReplace, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                    .addComponent(jComboFind, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(ckbCaseSensitive)
                .addGap(18, 18, 18)
                .addComponent(ckbPalavraInteira)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ckbCaseSensitive)
                    .addComponent(ckbPalavraInteira)
                    .addComponent(jComboFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edtReplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(13, 13, 13))
        );

        jTabbedPane2.addTab("Padrão", jPanel1);

        jButton1.setText("Procurar");
        jButton1.setToolTipText("Procurar expressão");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Substituir");
        jButton2.setToolTipText("Substituir expressão por valor informado");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jlistFile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlistFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlistFileMouseClicked(evt);
            }
        });
        jlistFile.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jlistFileValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jlistFile);
        jlistFile.getAccessibleContext().setAccessibleParent(this);

        JTextArea.setEditable(false);
        JTextArea.setColumns(20);
        JTextArea.setRows(5);
        jScrollPane2.setViewportView(JTextArea);

        lblTotalPastas.setText("Total de Pastas");

        lblTotalArquivos.setText("Total de Arquivos");

        jMenu1.setText("Arquivo");

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Sobre");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jTabbedPane2)
                    .addComponent(jScrollPane2)
                    .addComponent(JProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(50, 50, 50)
                        .addComponent(lblTotalPastas, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(lblTotalArquivos, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(lblTotalPastas)
                        .addComponent(lblTotalArquivos))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Pesquisar na Pasta");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("Pesquisar em Pasta");

        getAccessibleContext().setAccessibleParent(JProgress);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /***************************************************************************************************************/
    
    private void btnFindFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindFolderActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){ 
            JComboLocalPasta.removeAllItems();
            JComboLocalPasta.addItem(fileChooser.getSelectedFile().getPath()); 
            Log.lerLog("LogLocalPasta", JComboLocalPasta);
        } 
    }//GEN-LAST:event_btnFindFolderActionPerformed

    /***************************************************************************************************************/
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(this.validaCampos()){              
            lblTotalPastas.setVisible(true);
            lblTotalArquivos.setVisible(true);
            this.model.removeAllElements();
            this.limpaLista();
            Log.gravarLog("LogLocalPasta", JComboLocalPasta.getSelectedItem().toString());
            Log.gravarLog("LogFind", jComboFind.getSelectedItem().toString());
            
            String extAceita = (edtExtAceita.getText().equals("")) ? "*.*" : edtExtAceita.getText();
            String extRejeitada = (edtExtRejeitada.getText().equals("")) ? "*.*" : edtExtRejeitada.getText() ;
            crawler = new Crawler(JComboLocalPasta.getSelectedItem().toString(), ckbSubFolders.isSelected(), extAceita, extRejeitada);
            crawler.contaArquivos(JComboLocalPasta.getSelectedItem().toString());
            crawler.contaPastas(JComboLocalPasta.getSelectedItem().toString());
            crawler.setExpressao(jComboFind.getSelectedItem().toString());
            crawler.setCombinacaoPalavra(ckbPalavraInteira.isSelected());

            JProgress.setMaximum(this.crawler.getFTotalArquivos());
            lblTotalPastas.setText("Total de Pastas -> " + String.valueOf(this.crawler.getFTotalPastas()));
            lblTotalArquivos.setText("Total de Arquivos -> " + String.valueOf(this.crawler.getFTotalArquivos()));
            this.listaArquivo = crawler.procuraExpressao();
            
            if(this.listaArquivo.size() > 0){
                String cabecalho = String.format("%-30s%-60s%-20s\n","Nome do Arquivo","Caminho", "Data de Alteração");
                model.addElement(cabecalho);
                for (Arquivo arquivo : listaArquivo) { 
                    String dados = String.format("%-30s%-70s%-20s\n",arquivo.getNome(), arquivo.getCaminho(), arquivo.getDataFinalAlteracao() + "\n");
                    model.addElement(dados);
                }
                jlistFile.setModel(this.model);
            }else{
                JOptionPane.showMessageDialog(this, "Não foi encontrado nenhuma combinação!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private Boolean validaCampos(){
        if ("".equals(JComboLocalPasta.getSelectedItem().toString())){
            JOptionPane.showMessageDialog(this, "Infome o local da pasta para pesquisa!");
            JComboLocalPasta.requestFocus();
            return false;
        }else{
            if ("".equals(jComboFind.getSelectedItem().toString())){
                JOptionPane.showMessageDialog(this, "Infome o texto de pesquisa!");
                jComboFind.requestFocus();
                return false;
            }else{
                return true;
            }
        }
    }
    
    private void jlistFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistFileMouseClicked
        if (this.listaArquivo.size() > 0){
            this.alteraConteudo();
        }
    }//GEN-LAST:event_jlistFileMouseClicked

    private void jlistFileValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jlistFileValueChanged
        if (this.listaArquivo.size() > 0){
            this.alteraConteudo();
        }
    }//GEN-LAST:event_jlistFileValueChanged

    private void limpaLista(){
        if(this.listaArquivo != null && this.listaArquivo.size() > 0){
            this.listaArquivo.clear();
        }
    }
    
    private void alteraConteudo(){
        int indice = this.jlistFile.getSelectedIndex();
        String conteudo = this.listaArquivo.get(indice-1).getConteudo();
        JTextArea.setText(conteudo);
    }
    
    /***************************************************************************************************************/
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jframePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jframePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jframePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jframePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jframePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox JComboLocalPasta;
    private javax.swing.JProgressBar JProgress;
    private javax.swing.JTextArea JTextArea;
    private javax.swing.JButton btnFindFolder;
    private javax.swing.JCheckBox ckbCaseSensitive;
    private javax.swing.JCheckBox ckbPalavraInteira;
    private javax.swing.JCheckBox ckbSubFolders;
    private javax.swing.JTextField edtExtAceita;
    private javax.swing.JTextField edtExtRejeitada;
    private javax.swing.JTextField edtReplace;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JList jlistFile;
    private javax.swing.JPanel jpanelFolder;
    private javax.swing.JLabel lblTotalArquivos;
    private javax.swing.JLabel lblTotalPastas;
    // End of variables declaration//GEN-END:variables
}
