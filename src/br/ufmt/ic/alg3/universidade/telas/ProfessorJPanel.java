package br.ufmt.ic.alg3.universidade.telas;



import br.ufmt.ic.alg3.universidade.entidades.Professor;
import br.ufmt.ic.alg3.universidade.persistencia.ProfessorDAO;
import br.ufmt.ic.alg3.universidade.persistencia.arquivo.ProfessorDAOImplArq;
import javax.swing.table.DefaultTableModel;
import java.util.List;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jean
 */
public class ProfessorJPanel extends javax.swing.JPanel {

    private ProfessorDAO dao = new ProfessorDAOImplArq();
    /**
     * Creates new form ProfessorJPanel
     */
    public ProfessorJPanel() {
        initComponents();
        carregarTabela();
    }

    private void carregarTabela(){

        List<Professor> professores = dao.listar();
        DefaultTableModel defaultTableModel = (DefaultTableModel) tabelaProfessores.getModel();
        int linhas = defaultTableModel.getRowCount();
        // A tabela começa vazia com n linhas, é necessário
        // deixá-la em branco
        for(int i=0; i<linhas; i++){
            defaultTableModel.removeRow(0);
        }

        for(Professor professor: professores){
            Object[] linha = new Object[defaultTableModel.getColumnCount()];
            linha[0] = professor.getNome();
            linha[1] = professor.getIdentificacaoCPF();
            linha[2] = professor.getEmail();
            linha[3] = professor.getTitulo();
            linha[4] = professor.getSalario();

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
        jTextFieldCPF = new javax.swing.JTextField();
        jLabelNome = new javax.swing.JLabel();
        jLabelCPF = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelSalario = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldSalario = new javax.swing.JTextField();
        jTextFieldTitulo = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProfessores = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        jLabelNome.setText("Nome:");

        jLabelCPF.setText("CPF:");

        jLabelEmail.setText("E-mail:");

        jLabelSalario.setText("Salário:");

        jLabelTitulo.setText("Título:");

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

        tabelaProfessores.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Nome", "CPF", "E-mail", "Título", "Salário"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaProfessores);

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
                                                        .addComponent(jLabelCPF)
                                                        .addComponent(jLabelEmail)
                                                        .addComponent(jLabelSalario)
                                                        .addComponent(jLabelTitulo))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextFieldTitulo)
                                                        .addComponent(jTextFieldSalario)
                                                        .addComponent(jTextFieldEmail)
                                                        .addComponent(jTextFieldCPF)
                                                        .addComponent(jTextFieldNome)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                                        .addComponent(jButtonEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButtonSalvar)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jButtonLimpar)
                                                                .addGap(0, 333, Short.MAX_VALUE))
                                                        .addComponent(jScrollPane1))))
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
                                        .addComponent(jLabelCPF)
                                        .addComponent(jTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelEmail)
                                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelSalario)
                                        .addComponent(jTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTitulo)
                                        .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonSalvar)
                                        .addComponent(jButtonLimpar))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                .addGap(54, 54, 54))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(jButtonEditar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonExcluir)
                                                .addContainerGap(102, Short.MAX_VALUE))))
        );
    }// </editor-fold>

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jTextFieldNome.setText("");
        jTextFieldCPF.setText("");
        jTextFieldEmail.setText("");
        jTextFieldSalario.setText("");
        jTextFieldTitulo.setText("");

    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Professor professor = new Professor();
        String cpf = jTextFieldCPF.getText();

        professor.setIdentificacaoCPF(cpf);
        professor.setNome(jTextFieldNome.getText());
        professor.setEmail(jTextFieldEmail.getText());
        professor.setTitulo(jTextFieldTitulo.getText());
        professor.setSalario(Double.parseDouble(jTextFieldSalario.getText()));
        if (dao.getById(cpf) == null){
            dao.inserir(professor);
        } else {
            dao.editar(professor);
        }
        jButtonLimparActionPerformed(evt);
        carregarTabela();

    }

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int linha = tabelaProfessores.getSelectedRow();
        if (linha >= 0){
            String cpf = (String) tabelaProfessores.getValueAt(linha, 1);
            Professor professor = dao.getById(cpf);
            jTextFieldCPF.setText(professor.getIdentificacaoCPF());
            jTextFieldNome.setText(professor.getNome());
            jTextFieldEmail.setText(professor.getEmail());
            jTextFieldTitulo.setText(professor.getTitulo());
            jTextFieldSalario.setText(professor.getSalario() +"");
        }

    }

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        int linhas[] = tabelaProfessores.getSelectedRows();
        for (int linha: linhas){
            String cpf = (String) tabelaProfessores.getValueAt(linha, 1);
            dao.remover(cpf);
        }
        carregarTabela();
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelCPF;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelSalario;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldCPF;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldSalario;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JTable tabelaProfessores;
    // End of variables declaration
}