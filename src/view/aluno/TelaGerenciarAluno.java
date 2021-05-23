package view.aluno;

import control.AlunoControl;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import view.JTableUtilities;
import view.Mensagem;

public class TelaGerenciarAluno extends javax.swing.JFrame {

    private AlunoControl controlador;
    
    public TelaGerenciarAluno() {
        initComponents();
        this.controlador = new AlunoControl();
        this.carregaTabela();
        JTableUtilities.setCellsAlignment(tabelaAlunos, SwingConstants.CENTER);    
    }
    
     public void carregaTabela() {
        String[][] linhasMatriz = controlador.getMinhaMatrizTexto();
        carregaTabela(linhasMatriz);
     }
     
    //@SuppressWarnings("uncheced")
    public void carregaTabela(String[][] linhasMatriz) {
        
        DefaultTableModel modelo = (DefaultTableModel) this.tabelaAlunos.getModel();
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
            case "Curso":
                if (input.equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Informe um texto válido");
                     return false;
                }
                return true;

            case "Idade":
            case "Fase":
                try {
                Integer.parseInt(input);
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
        btnCancelar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        inputFase = new javax.swing.JTextField();
        txtFase = new javax.swing.JLabel();
        txtCurso = new javax.swing.JLabel();
        inputCurso = new javax.swing.JTextField();
        inputIdade = new javax.swing.JTextField();
        txtIdade = new javax.swing.JLabel();
        inputNome = new javax.swing.JTextField();
        txtNome = new javax.swing.JLabel();
        inputPesquisa = new javax.swing.JTextField();
        btnPesquisa = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        comboBoxTipoPesquisa = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaAlunos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciamento de Alunos");
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaptionBorder);

        btnCancelar.setBackground(java.awt.SystemColor.scrollbar);
        btnCancelar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

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

        inputFase.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtFase.setFont(new java.awt.Font("Bell MT", 1, 24)); // NOI18N
        txtFase.setForeground(new java.awt.Color(51, 51, 51));
        txtFase.setText("Fase");

        txtCurso.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        txtCurso.setForeground(new java.awt.Color(51, 51, 51));
        txtCurso.setText("Curso");

        inputCurso.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        inputIdade.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtIdade.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        txtIdade.setForeground(new java.awt.Color(51, 51, 51));
        txtIdade.setText("Idade");

        inputNome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        txtNome.setFont(new java.awt.Font("Bell MT", 1, 22)); // NOI18N
        txtNome.setForeground(new java.awt.Color(51, 51, 51));
        txtNome.setText("Nome");

        inputPesquisa.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        btnPesquisa.setBackground(java.awt.SystemColor.scrollbar);
        btnPesquisa.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnPesquisa.setText("Pesquisar");
        btnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaActionPerformed(evt);
            }
        });

        btnLimpar.setBackground(java.awt.SystemColor.scrollbar);
        btnLimpar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        comboBoxTipoPesquisa.setBackground(java.awt.SystemColor.scrollbar);
        comboBoxTipoPesquisa.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        comboBoxTipoPesquisa.setForeground(new java.awt.Color(51, 51, 51));
        comboBoxTipoPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome", "Idade", "Curso", "Fase" }));

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentShown(evt);
            }
        });

        tabelaAlunos.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        tabelaAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Idade", "Curso", "Fase"
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
        tabelaAlunos.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tabelaAlunos.getTableHeader().setReorderingAllowed(false);
        tabelaAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAlunosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaAlunos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1076, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(inputPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome)
                            .addComponent(txtIdade)
                            .addComponent(txtCurso)
                            .addComponent(txtFase))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputFase, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(158, 158, 158)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisa)
                    .addComponent(btnLimpar)
                    .addComponent(comboBoxTipoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdade))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCurso)
                    .addComponent(inputCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFase)
                    .addComponent(inputFase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnApagar)
                    .addComponent(btnEditar)
                    .addComponent(btnCancelar))
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        carregaTabela();
    }//GEN-LAST:event_formComponentShown

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        carregaTabela();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaActionPerformed
        String input = this.inputPesquisa.getText();

        Object inputComboBox = this.comboBoxTipoPesquisa.getSelectedItem();
        String inputComboBoxString = (String) inputComboBox;

        boolean valido = validaInput(input, inputComboBoxString);
        if (valido != true) {
            return;
        }

        String[][] linhasMatriz = controlador.getMinhaMatrizTexto(input, inputComboBoxString);
        carregaTabela(linhasMatriz);
        this.inputPesquisa.setText("");

    }//GEN-LAST:event_btnPesquisaActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        try {
            int id = 0;
            if (this.tabelaAlunos.getSelectedRow() == -1) {
                throw new Mensagem("Primeiro selecione um aluno para APAGAR");
            } else {
                id = Integer.parseInt(this.tabelaAlunos.getValueAt(this.tabelaAlunos.getSelectedRow(), 0).toString());
            }

            //retorna 0 -> primeiro botão | 1 -> segundo botão | 2 -> terceiro botão
            int resposta_usuario = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja APAGAR este Aluno?");
            if (resposta_usuario == 0) { //cliclou em SIM
                if (this.controlador.apagar(id)) {
                    //limpa os campos
                    this.inputNome.setText("");
                    this.inputIdade.setText("");
                    this.inputCurso.setText("");
                    this.inputFase.setText("");
                    JOptionPane.showMessageDialog(rootPane, "Aluno apagado com sucesso");
                }
                System.out.println(this.controlador.getMinhaLista().toString());
            }


        }catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }finally {
            carregaTabela();//atualiza a tabela
        }

    }//GEN-LAST:event_btnApagarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        try {
            int id = 0;
            String nome = "";
            int idade = 0;
            String curso = "";
            int fase = 0;

            if (this.inputNome.getText().length() < 2) {
                throw new Mensagem ("Nome deve conter ao menos 2 caracteres.");
            }else {
                nome = this.inputNome.getText();
            }

            if (this.inputIdade.getText().length() <= 0) {
                throw new Mensagem ("Idade deve ser um número e ser maior que zero.");
            }else {
                idade = Integer.parseInt(this.inputIdade.getText());
            }

            if (this.inputCurso.getText().length() < 2) {
                throw new Mensagem ("Curso deve conter ao menos 2 caracteres.");
            }else {
                curso = this.inputCurso.getText();
            }

            if (this.inputFase.getText().length() <= 0) {
                throw new Mensagem ("Fase deve ser um número e ser maior que zero.");
            }else {
                fase = Integer.parseInt(this.inputFase.getText());
            }

            if (this.tabelaAlunos.getSelectedRow() == -1) {
                throw new Mensagem ("Primeiro selecione um aluno para ALTERAR");
            }else {
                id = Integer.parseInt(this.tabelaAlunos.getValueAt(this.tabelaAlunos.getSelectedRow(),0).toString());
            }

            //envia os dados para o controlado processar
            if (this.controlador.editar(curso, fase, id, nome, idade)) {
                JOptionPane.showMessageDialog(rootPane, "Aluno alterado com sucesso!");
                //limpa os campos
                this.inputNome.setText("");
                this.inputIdade.setText("");
                this.inputCurso.setText("");
                this.inputFase.setText("");
            }
            System.out.println(this.controlador.getMinhaLista().toString());
        }catch (Mensagem erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }catch (NumberFormatException erro2) {
            JOptionPane.showMessageDialog(null, "Informe um número.");
        }finally {
            carregaTabela(); //atualiza a tabela
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tabelaAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAlunosMouseClicked
        if (this.tabelaAlunos.getSelectedRow() != -1){

            String nome = this.tabelaAlunos.getValueAt(this.tabelaAlunos.getSelectedRow(),1).toString();
            String idade = this.tabelaAlunos.getValueAt(this.tabelaAlunos.getSelectedRow(),2).toString();
            String curso = this.tabelaAlunos.getValueAt(this.tabelaAlunos.getSelectedRow(),3).toString();
            String fase = this.tabelaAlunos.getValueAt(this.tabelaAlunos.getSelectedRow(),4).toString();

            this.inputNome.setText(nome);
            this.inputIdade.setText(idade);
            this.inputCurso.setText(curso);
            this.inputFase.setText(fase);
        }
    }//GEN-LAST:event_tabelaAlunosMouseClicked

    private void jPanel2ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentShown
        // TODO add your handling code here:
        carregaTabela();
    }//GEN-LAST:event_jPanel2ComponentShown

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
            java.util.logging.Logger.getLogger(TelaGerenciarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGerenciarAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGerenciarAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JComboBox<String> comboBoxTipoPesquisa;
    private javax.swing.JTextField inputCurso;
    private javax.swing.JTextField inputFase;
    private javax.swing.JTextField inputIdade;
    private javax.swing.JTextField inputNome;
    private javax.swing.JTextField inputPesquisa;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaAlunos;
    private javax.swing.JLabel txtCurso;
    private javax.swing.JLabel txtFase;
    private javax.swing.JLabel txtIdade;
    private javax.swing.JLabel txtNome;
    // End of variables declaration//GEN-END:variables
}
