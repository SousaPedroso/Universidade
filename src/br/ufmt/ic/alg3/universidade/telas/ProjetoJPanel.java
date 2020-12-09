package br.ufmt.ic.alg3.universidade.telas;


import java.util.List;
import javax.swing.table.DefaultTableModel;

import br.ufmt.ic.alg3.universidade.persistencia.ProjetoDAO;
import br.ufmt.ic.alg3.universidade.entidades.Projeto;
import br.ufmt.ic.alg3.universidade.utils.DAOFactory;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jean
 */
public class ProjetoJPanel extends javax.swing.JPanel {

    private ProjetoDAO dao = DAOFactory.createProjetoDAO();

    /**
     * Creates new form ProjetoJPanel
     */
    public ProjetoJPanel() {
        initComponents();
        carregarTabela();
    }

    private void carregarTabela(){

        List<Projeto> projetos = dao.listar();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tabelaProjetos.getModel();
        int linhas = tabelaProjetos.getRowCount();
        for(int i=0; i< linhas; i++){
            defaultTableModel.removeRow(0);
        }

        for(Projeto projeto: projetos){
            Object[] linha = new Object[defaultTableModel.getColumnCount()];

            linha[0] = projeto.getNome();
            linha[1] = projeto.getId();

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
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProjetos = new javax.swing.JTable();

        jLabelNome.setText("Nome:");

        jLabelId.setText("Id:");

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

        tabelaProjetos.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Nome", "Id"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaProjetos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelNome)
                                                        .addComponent(jLabelId))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                                                        .addComponent(jTextFieldId)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(16, 16, 16)
                                                                .addComponent(jButtonSalvar)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jButtonLimpar)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jButtonEditar))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jButtonExcluir)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonSalvar)
                                        .addComponent(jButtonLimpar))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonEditar)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonExcluir))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Projeto projeto = new Projeto();
        projeto.setNome(jTextFieldNome.getText());
        int id = 0;

        try{
            id = Integer.parseInt(jTextFieldId.getText());
        } catch(NumberFormatException ex){
            id = 0;
        }
        projeto.setId(id);

        if (dao.getById(id) == null){
            dao.inserir(projeto);
        } else {
            dao.editar(projeto);
        }

        jButtonLimparActionPerformed(evt);
        carregarTabela();

    }

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jTextFieldId.setText("");
        jTextFieldNome.setText("");

    }

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int linha = tabelaProjetos.getSelectedRow();
        if (linha >= 0){
            int id = (int) tabelaProjetos.getValueAt(linha, 1);
            Projeto projeto = dao.getById(id);

            jTextFieldNome.setText(projeto.getNome());
            jTextFieldId.setText(projeto.getId()+"");
        }


    }

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int linhas[] = tabelaProjetos.getSelectedRows();
        for(int linha: linhas){
            int id = (int)  tabelaProjetos.getValueAt(linha, 1);
            dao.remover(id);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTable tabelaProjetos;
    // End of variables declaration
}

