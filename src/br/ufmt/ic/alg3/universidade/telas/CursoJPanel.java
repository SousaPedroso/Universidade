package br.ufmt.ic.alg3.universidade.telas;

import br.ufmt.ic.alg3.universidade.persistencia.CursoDAO;
import br.ufmt.ic.alg3.universidade.entidades.Curso;
import br.ufmt.ic.alg3.universidade.utils.DAOFactory;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CursoJPanel extends javax.swing.JPanel {

    private CursoDAO dao = DAOFactory.createCursoDAO();
    /**
     * Creates new form CursoJPanel
     */
    public CursoJPanel() {
        initComponents();
        atualizarTabela();
    }
    private void atualizarTabela(){
        List<Curso> lista = dao.listar();
        DefaultTableModel dfm = (DefaultTableModel) tabela.getModel();
        int linhas = dfm.getRowCount();
        for (int i = 0; i < linhas; i++){
            dfm.removeRow(0);
        }
        for (Curso curso : lista){
            Object[] linha = new Object[2];
            linha[0] = curso.getNome();
            linha[1] = curso.getIdentificacao();

            dfm.addRow(linha);
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jLabelNome = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldId = new javax.swing.JTextField();
        jButtonSalvar = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("jMenu3");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("jMenu6");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jLabelNome.setText("Nome:");

        jLabelId.setText("Identificacão:");

        jTextFieldNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeActionPerformed(evt);
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

        tabela.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Nome", "Identificação"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabela);

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
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelId)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextFieldId))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabelNome)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jTextFieldNome))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jButtonSalvar)
                                                                .addGap(27, 27, 27)
                                                                .addComponent(jButtonLimpar)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jButtonExcluir)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jButtonEditar)))))
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelId, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(3, 3, 3))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButtonLimpar)
                                                        .addComponent(jButtonEditar)
                                                        .addComponent(jButtonExcluir))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButtonSalvar))
                                .addContainerGap(23, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void jTextFieldNomeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        jTextFieldNome.setText("");
        jTextFieldId.setText("");
    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        Curso c = new Curso();
        c.setNome(jTextFieldNome.getText());
        int identificacao = Integer.parseInt(jTextFieldId.getText());
        c.setIdentificacao(identificacao);
        if(dao.getIdentificacao(identificacao) == null){
            dao.inserir(c);
        }else{
            dao.editar(c);
        }
        jButtonLimparActionPerformed(evt);
        atualizarTabela();
    }

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int[] linhas = tabela.getSelectedRows();
        for (int linha : linhas){
            int identificacao = (int) tabela.getValueAt(linha, 1);//prestar atencão
            dao.remover(identificacao);
        }
        atualizarTabela();
    }

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int linha = tabela.getSelectedRow();
        if(linha >= 0){
            int identificacao = (int) tabela.getValueAt(linha, 1);
            Curso c = dao.getIdentificacao(identificacao);
            jTextFieldNome.setText(c.getNome());
            jTextFieldId.setText(c.getIdentificacao()+"");
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTable tabela;
    // End of variables declaration
}