package br.ufmt.ic.alg3.universidade.telas;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import br.ufmt.ic.alg3.universidade.persistencia.DisciplinaDAO;
import br.ufmt.ic.alg3.universidade.entidades.Disciplina;
import br.ufmt.ic.alg3.universidade.utils.DAOFactory;

import javax.swing.table.DefaultTableModel;
import java.util.List;


public class DisciplinaJPanel extends javax.swing.JPanel {

    private DisciplinaDAO dao =  DAOFactory.createDisciplinaDAO();

    /**
     * Creates new form DisciplinaJPanel
     */
    public DisciplinaJPanel() {
        initComponents();
        carregarTabela();
    }
    private void carregarTabela(){

        List<Disciplina> disciplinas = dao.listar();
        DefaultTableModel defaultTableModel = (DefaultTableModel) jTable1.getModel();
        int linhas = defaultTableModel.getRowCount();
        // A tabela começa vazia com n linhas, é necessário
        // deixá-la em branco
        for(int i=0; i<linhas; i++){
            defaultTableModel.removeRow(0);
        }

        for(Disciplina disciplina: disciplinas){
            Object[] linha = new Object[defaultTableModel.getColumnCount()];
            linha[0] = disciplina.getNome();
            linha[1] = disciplina.getIdentificacao();

            defaultTableModel.addRow(linha);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldId = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        jLabelPreRequisitos = new javax.swing.JLabel();
        jTextFieldPreRequisitos = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jLabelNome.setText("Nome:");

        jLabelId.setText("Id:");

        jLabelPreRequisitos.setText("Pré Requisitos:");

        jTextFieldPreRequisitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPreRequisitosActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Nome", "id", "Pré Requisitos"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButtonSalvar)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButtonLimpar)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButtonExcluir)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButtonEditar))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelPreRequisitos)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jTextFieldPreRequisitos))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelId)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jTextFieldId))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelNome)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelNome)
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelId)
                                        .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelPreRequisitos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldPreRequisitos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonSalvar)
                                        .addComponent(jButtonLimpar)
                                        .addComponent(jButtonEditar)
                                        .addComponent(jButtonExcluir))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jTextFieldPreRequisitosActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jTextFieldNome.setText("");
        jTextFieldId.setText("");
        jTextFieldPreRequisitos.setText("");
    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(jTextFieldNome.getText());
        int identificacao = 0;
        try {
            identificacao = Integer.parseInt(jTextFieldId.getText());
        } catch (NumberFormatException ex){
            identificacao = 0;
        }
        disciplina.setIdentificacao(identificacao);

        if (dao.getIdentificacao(identificacao) == null){
            dao.inserir(disciplina);
        } else {
            dao.editar(disciplina);
        }
        jButtonLimparActionPerformed(evt);
        carregarTabela();
    }

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int linha = jTable1.getSelectedRow();
        if(linha >= 0){
            int id = (int) jTable1.getValueAt(linha,1);
            Disciplina disciplina = dao.getIdentificacao(id);

            jTextFieldNome.setText(disciplina.getNome());
            jTextFieldId.setText(disciplina.getIdentificacao()+"");
        }
    }

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int[] linhas = jTable1.getSelectedRows();
        for (int linha : linhas){
            int identificacao = (int) jTable1.getValueAt(linha, 1);
            dao.remover(identificacao);
        }
        carregarTabela();
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelPreRequisitos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreRequisitos;
    // End of variables declaration
}
