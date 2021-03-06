/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import opencv.ExtratorImagem;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.rules.JRip;
import weka.classifiers.rules.OneR;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author renansantos
 */
public class Preditor extends javax.swing.JFrame {

    private Instances instancias;

    /**
     * Creates new form Preditor
     */
    public Preditor() {
        initComponents();
    }

    public void classificaNaiveBayes() throws Exception {
        NaiveBayes nb = new NaiveBayes();
        //criação da tabela de probabilidade
        nb.buildClassifier(instancias);

        //criação de novo registro
        Instance novo = new DenseInstance(instancias.numAttributes());
        novo.setDataset(instancias);//faz uma referencia para a base de dados
        novo.setValue(0, Float.parseFloat(lblLaranjaBart.getText()));
        novo.setValue(1, Float.parseFloat(lblAzulCalcao.getText()));
        novo.setValue(2, Float.parseFloat(lblAzulSapato.getText()));
        novo.setValue(3, Float.parseFloat(lblMarronHomer.getText()));
        novo.setValue(4, Float.parseFloat(lblAzulHomer.getText()));
        novo.setValue(5, Float.parseFloat(lblSapatoHomer.getText()));

        //previsão
        double resultado[] = nb.distributionForInstance(novo);
        DecimalFormat df = new DecimalFormat("#,###.0000");

        lblNaiveBart.setText("Bart: " + df.format(resultado[0]));
        lblNaiveHomer.setText("Homer: " + df.format(resultado[1]));
//        System.out.println("Bart: " + df.format(resultado[0]));
//        System.out.println("Homer: " + df.format(resultado[1]));
    }

    public void classificaJ48() throws Exception {
        J48 arvore = new J48();

        arvore.buildClassifier(instancias);

        //criação de novo registro
        Instance novo = new DenseInstance(instancias.numAttributes());
        novo.setDataset(instancias);//faz uma referencia para a base de dados
        novo.setValue(0, Float.parseFloat(lblLaranjaBart.getText()));
        novo.setValue(1, Float.parseFloat(lblAzulCalcao.getText()));
        novo.setValue(2, Float.parseFloat(lblAzulSapato.getText()));
        novo.setValue(3, Float.parseFloat(lblMarronHomer.getText()));
        novo.setValue(4, Float.parseFloat(lblAzulHomer.getText()));
        novo.setValue(5, Float.parseFloat(lblSapatoHomer.getText()));

        //previsão
        double resultado[] = arvore.distributionForInstance(novo);
        DecimalFormat df = new DecimalFormat("#,###.0000");

        lblJ48Bart.setText("Bart: " + df.format(resultado[0]));
        lblJ48Homer.setText("Homer: " + df.format(resultado[1]));
    }
    
    public void classificaRegras() throws Exception {
        OneR oner = new OneR();
        JRip jrip = new JRip();

        oner.buildClassifier(instancias);
        jrip.buildClassifier(instancias);

        //criação de novo registro
        Instance novo = new DenseInstance(instancias.numAttributes());
        novo.setDataset(instancias);//faz uma referencia para a base de dados
        novo.setValue(0, Float.parseFloat(lblLaranjaBart.getText()));
        novo.setValue(1, Float.parseFloat(lblAzulCalcao.getText()));
        novo.setValue(2, Float.parseFloat(lblAzulSapato.getText()));
        novo.setValue(3, Float.parseFloat(lblMarronHomer.getText()));
        novo.setValue(4, Float.parseFloat(lblAzulHomer.getText()));
        novo.setValue(5, Float.parseFloat(lblSapatoHomer.getText()));

        //previsão
        double resultadoOneR[] = oner.distributionForInstance(novo);
        double resultadoJRip[] = jrip.distributionForInstance(novo);
        DecimalFormat df = new DecimalFormat("#,###.0000");

        lblOneRBart.setText("Bart: " + df.format(resultadoOneR[0]));
        lblOneRHomer.setText("Homer: " + df.format(resultadoOneR[1]));
        lblJRipBart.setText("Bart: " + df.format(resultadoJRip[0]));
        lblJRipHomer.setText("Homer: " + df.format(resultadoJRip[1]));
    }
    
    

    public void carregaBaseWeka() throws Exception {
        DataSource ds = new DataSource("src//opencv//caracteristicas.arff");
        instancias = ds.getDataSet();
        instancias.setClassIndex(instancias.numAttributes() - 1);
        //System.out.println(instancias.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        btnSelecionarImagem = new javax.swing.JButton();
        txtCaminhoImagem = new javax.swing.JTextField();
        lblImagem = new javax.swing.JLabel();
        btnExtrairCaracteristicas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblLaranjaBart = new javax.swing.JLabel();
        lblAzulCalcao = new javax.swing.JLabel();
        lblAzulSapato = new javax.swing.JLabel();
        lblAzulHomer = new javax.swing.JLabel();
        lblMarronHomer = new javax.swing.JLabel();
        lblSapatoHomer = new javax.swing.JLabel();
        btnClassificar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblNaiveHomer = new javax.swing.JLabel();
        lblNaiveBart = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblJ48Bart = new javax.swing.JLabel();
        lblJ48Homer = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblOneRBart = new javax.swing.JLabel();
        lblOneRHomer = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblJRipBart = new javax.swing.JLabel();
        lblJRipHomer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSelecionarImagem.setText("Selecionar Imagem");
        btnSelecionarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarImagemActionPerformed(evt);
            }
        });

        txtCaminhoImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCaminhoImagemActionPerformed(evt);
            }
        });

        lblImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnExtrairCaracteristicas.setText("Extrair Características");
        btnExtrairCaracteristicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtrairCaracteristicasActionPerformed(evt);
            }
        });

        jLabel1.setText("Características do  Bart");

        jLabel2.setText("Características do Homer");

        btnClassificar.setText("Classificar");
        btnClassificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClassificarActionPerformed(evt);
            }
        });

        jLabel3.setText("Naive-Bayes");

        jLabel5.setText("J48");

        lblJ48Bart.setText("Bart:");

        lblJ48Homer.setText("Homer:");

        jLabel6.setText("OneR");

        lblOneRBart.setText("Bart: ");

        lblOneRHomer.setText("Homer:");

        jLabel7.setText("JRip");

        lblJRipBart.setText("Bart:");

        lblJRipHomer.setText("Homer:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSelecionarImagem)
                .addGap(18, 18, 18)
                .addComponent(txtCaminhoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNaiveHomer)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnExtrairCaracteristicas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClassificar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNaiveBart)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4)))
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblJ48Bart)
                                    .addComponent(jLabel5)
                                    .addComponent(lblJ48Homer))
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblOneRHomer)
                                        .addGap(92, 92, 92)
                                        .addComponent(lblJRipHomer))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblOneRBart)
                                            .addComponent(jLabel6))
                                        .addGap(106, 106, 106)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(lblJRipBart))))
                                .addGap(0, 50, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lblLaranjaBart)
                                    .addComponent(lblAzulCalcao)
                                    .addComponent(lblAzulSapato))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAzulHomer)
                                    .addComponent(jLabel2)
                                    .addComponent(lblMarronHomer)
                                    .addComponent(lblSapatoHomer))))
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelecionarImagem)
                    .addComponent(txtCaminhoImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExtrairCaracteristicas)
                            .addComponent(btnClassificar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLaranjaBart)
                            .addComponent(lblAzulHomer))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAzulCalcao)
                            .addComponent(lblMarronHomer))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAzulSapato)
                            .addComponent(lblSapatoHomer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblNaiveBart)
                                .addGap(18, 18, 18)))
                        .addComponent(lblNaiveHomer))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJ48Bart)
                            .addComponent(lblOneRBart)
                            .addComponent(lblJRipBart))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJ48Homer)
                            .addComponent(lblOneRHomer)
                            .addComponent(lblJRipHomer))))
                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecionarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarImagemActionPerformed
        JFileChooser fc = new JFileChooser();
        int retorno = fc.showDialog(this, "Selecione a Imagem");

        if (retorno == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();
            txtCaminhoImagem.setText(arquivo.getAbsolutePath());

            BufferedImage imagemBmp = null;
            try {
                imagemBmp = ImageIO.read(arquivo);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            ImageIcon imagemLabel = new ImageIcon(imagemBmp);
            lblImagem.setIcon(new ImageIcon(
                    imagemLabel.getImage().getScaledInstance(lblImagem.getWidth(),
                            lblImagem.getHeight(), Image.SCALE_DEFAULT)));
        }
    }//GEN-LAST:event_btnSelecionarImagemActionPerformed

    private void txtCaminhoImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCaminhoImagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCaminhoImagemActionPerformed

    private void btnExtrairCaracteristicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtrairCaracteristicasActionPerformed
        ExtratorImagem extrator = new ExtratorImagem();
        float[] caracteristicas = extrator.extrairCaracteristicasImagem(txtCaminhoImagem.getText());
        lblLaranjaBart.setText(String.valueOf(caracteristicas[0]));
        lblAzulCalcao.setText(String.valueOf(caracteristicas[1]));
        lblAzulSapato.setText(String.valueOf(caracteristicas[2]));
        lblAzulHomer.setText(String.valueOf(caracteristicas[3]));
        lblMarronHomer.setText(String.valueOf(caracteristicas[4]));
        lblSapatoHomer.setText(String.valueOf(caracteristicas[5]));
    }//GEN-LAST:event_btnExtrairCaracteristicasActionPerformed

    private void btnClassificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClassificarActionPerformed
        try {
            this.carregaBaseWeka();
            classificaNaiveBayes();
            classificaJ48();
            classificaRegras();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnClassificarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Preditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Preditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Preditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Preditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Preditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClassificar;
    private javax.swing.JButton btnExtrairCaracteristicas;
    private javax.swing.JButton btnSelecionarImagem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAzulCalcao;
    private javax.swing.JLabel lblAzulHomer;
    private javax.swing.JLabel lblAzulSapato;
    private javax.swing.JLabel lblImagem;
    private javax.swing.JLabel lblJ48Bart;
    private javax.swing.JLabel lblJ48Homer;
    private javax.swing.JLabel lblJRipBart;
    private javax.swing.JLabel lblJRipHomer;
    private javax.swing.JLabel lblLaranjaBart;
    private javax.swing.JLabel lblMarronHomer;
    private javax.swing.JLabel lblNaiveBart;
    private javax.swing.JLabel lblNaiveHomer;
    private javax.swing.JLabel lblOneRBart;
    private javax.swing.JLabel lblOneRHomer;
    private javax.swing.JLabel lblSapatoHomer;
    private javax.swing.JTextField txtCaminhoImagem;
    // End of variables declaration//GEN-END:variables
}
