package view.professor;

import control.ProfessorControl;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import view.JTableUtilities;
import view.Mensagem;


public class TelaGerenciarProfessor extends javax.swing.JFrame {

    
    private ProfessorControl controlador;
    
    public TelaGerenciarProfessor() {
        initComponents();
        this.controlador = new ProfessorControl();
        this.carregaTabela();
        JTableUtilities.setCellsAlignment(tabelaProfessor, SwingConstants.CENTER);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent we) {
                carregaTabela();
            }
        });
    }
    
    
    public void carregaTabela() {
        String[][] linhasMatriz = controlador.getMinhaMatrizTexto();
        carregaTabela(linhasMatriz);
    }
    
    //@SuppressWarnings("uncheced")
    public void carregaTabela(String[][] linhasMatriz) {
        
        DefaultTableModel modelo = (DefaultTableModel) this.tabelaProfessor.getModel();
        modelo.setNumRows(0);
        
        for (int i = 0; i < linhasMatriz.length; i++) {
            modelo.addRow(new Object[]{
            linhasMatriz[i][0],
            linhasMatriz[i][1],
            linhasMatriz[i][2],
            linhasMatriz[i][3],
            linhasMatriz[i][4]
            });
        }
    }
    
    
    public boolean validaInput(String input, String inputComboBoxString) {
        switch (inputComboBoxString) {
            case "Nome":
            case "Titulação":
                if (input.equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Informe um texto válido");
                     return false;
                }
                return true;

            case "Idade":
                try {
                Integer.parseInt(input);
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Informe um número válido");    
                return false;
            }
            case "Salário":
                try {
                Double.parseDouble(input);
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Informe um número válido");    
                return false;
            }
            default:
                return true;
         }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        inputIdade = new javax.swing.JTextField();
        comboBoxPesquisa = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboBoxTitulacao = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        inputSalario = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProfessor = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        inputNome = new javax.swing.JTextField();
        inputPesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaptionBorder);

        jPanel2.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Idade");

        btnLimpar.setBackground(java.awt.SystemColor.scrollbar);
        btnLimpar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        inputIdade.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        comboBoxPesquisa.setBackground(java.awt.SystemColor.scrollbar);
        comboBoxPesquisa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comboBoxPesquisa.setForeground(new java.awt.Color(51, 51, 51));
        comboBoxPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Idade", "Titulação", "Salário" }));
        comboBoxPesquisa.setSelectedIndex(-1);

        jLabel3.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Titulação");

        comboBoxTitulacao.setBackground(java.awt.SystemColor.scrollbar);
        comboBoxTitulacao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        comboBoxTitulacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Graduação", "Especialização", "Mestrado", "Doutorado" }));
        comboBoxTitulacao.setSelectedIndex(-1);

        jLabel5.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Salário");

        inputSalario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btnCancelar.setBackground(java.awt.SystemColor.scrollbar);
        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        tabelaProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Idade", "Titulação", "Salário"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaProfessor.getTableHeader().setReorderingAllowed(false);
        tabelaProfessor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProfessorMouseClicked(evt);
            }
        });
        tabelaProfessor.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabelaProfessorComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaProfessor);

        btnEditar.setBackground(java.awt.SystemColor.scrollbar);
        btnEditar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnApagar.setBackground(java.awt.SystemColor.scrollbar);
        btnApagar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnApagar.setText("Apagar");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        inputNome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        inputPesquisa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nome");

        btnPesquisar.setBackground(java.awt.SystemColor.scrollbar);
        btnPesquisar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel5)
                        .addGap(72, 72, 72)
                        .addComponent(inputSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(inputPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboBoxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnPesquisar)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(192, 192, 192)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(111, 111, 111)
                                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboBoxTitulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(inputIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(67, 67, 67)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBoxPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxTitulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApagar)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar))
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        carregaTabela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String input = this.inputPesquisa.getText();

        Object inputComboBox = this.comboBoxPesquisa.getSelectedItem();
        String inputComboBoxString = (String) inputComboBox;

        boolean valido = validaInput(input, inputComboBoxString);
        if (valido != true) {
            return;
        }

        String[][] linhasMatriz = controlador.getMinhaMatrizTexto(input, inputComboBoxString);

        carregaTabela(linhasMatriz);
        this.inputPesquisa.setText("");
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        try {
            int id = 0;
            if (this.tabelaProfessor.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro selecione um Professor para APAGAR");
            } else {
                id = Integer.parseInt(this.tabelaProfessor.getValueAt(this.tabelaProfessor.getSelectedRow(), 0).toString());
            }

            //retorna 0 -> primeiro botão | 1 -> segundo botão | 2 -> terceiro botão
            int resposta_usuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja APAGAR este Professor?");
            if (resposta_usuario == 0) { //cliclou em SIM

            }
            if (this.controlador.apagar(id)) {
                //limpa os campos
                this.inputNome.setText("");
                this.inputIdade.setText("");
                this.comboBoxTitulacao.setSelectedIndex(-1);
                this.inputSalario.setText("");
                JOptionPane.showMessageDialog(rootPane, "Professor apagado com sucesso");
            }
            System.out.println(this.controlador.getMinhaLista().toString());

        }catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());

        }finally {
            carregaTabela();//atualiza a tabela
        }
    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        try{
            int id = 0;
            String nome = "";
            int idade = 0;
            String titulacao = "";
            double salario = 0;

            if (this.inputNome.getText().length() < 2) {
                throw new Mensagem ("Nome deve conter ao menos 2 caracteres.");
            } else {
                nome = this.inputNome.getText();
            }

            if (this.inputIdade.getText().length() <= 0) {
                throw new Mensagem ("Idade deve ser um número e ser maior que zero.");
            } else {
                idade = Integer.parseInt(this.inputIdade.getText());
            }

            if (this.comboBoxTitulacao.getSelectedIndex() == -1) {
                throw new Mensagem ("Selecione a Titulacão correspondente.");
            } else {
                titulacao = (String) this.comboBoxTitulacao.getSelectedItem();
            }

            if (this.inputSalario.getText().length() <= 0) {
                throw new Mensagem ("O valor do salário deve ser um número e ser maior que zero.");
            }else {
                salario = Double.parseDouble(this.inputSalario.getText());
            }

            if (this.tabelaProfessor.getSelectedRow() == -1) {
                throw new Mensagem ("Primeiro selecione um aluno para ALTERAR");
            }else {
                id = Integer.parseInt(this.tabelaProfessor.getValueAt(this.tabelaProfessor.getSelectedRow(),0).toString());
            }

            // envia os dados para o Controlador cadastrar
            if (this.controlador.editar(salario, titulacao, id, nome, idade)){
                JOptionPane.showMessageDialog(rootPane, "Professor alterado com sucesso!");

                this.inputNome.setText("");
                this.inputIdade.setText("");
                this.comboBoxTitulacao.setSelectedIndex(-1);
                this.inputSalario.setText("");
            }

            System.out.println(this.controlador.getMinhaLista().toString());

        }catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null,erro.getMessage());

        }catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null,"Informe um número");

        }finally {
            carregaTabela();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tabelaProfessorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProfessorMouseClicked
        if (this.tabelaProfessor.getSelectedRow() != -1) {
            String nome = this.tabelaProfessor.getValueAt(this.tabelaProfessor.getSelectedRow(),1).toString();
            String idade = this.tabelaProfessor.getValueAt(this.tabelaProfessor.getSelectedRow(),2).toString();
            String titulacao = this.tabelaProfessor.getValueAt(this.tabelaProfessor.getSelectedRow(),3).toString();
            String salario = this.tabelaProfessor.getValueAt(this.tabelaProfessor.getSelectedRow(),4).toString();

            this.inputNome.setText(nome);
            this.inputIdade.setText(idade);
            this.comboBoxTitulacao.setSelectedItem(titulacao);
            this.inputSalario.setText(salario);
        }
    }//GEN-LAST:event_tabelaProfessorMouseClicked

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        carregaTabela();
    }//GEN-LAST:event_jPanel2ComponentShown

    private void tabelaProfessorComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabelaProfessorComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaProfessorComponentShown
    

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
            java.util.logging.Logger.getLogger(TelaGerenciarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarProfessor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciarProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<String> comboBoxPesquisa;
    private javax.swing.JComboBox<String> comboBoxTitulacao;
    private javax.swing.JTextField inputIdade;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputPesquisa;
    private javax.swing.JTextField inputSalario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaProfessor;
    // End of variables declaration//GEN-END:variables
}
