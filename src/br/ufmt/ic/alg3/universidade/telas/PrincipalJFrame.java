package br.ufmt.ic.alg3.universidade.telas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *@author  Gabriel
 * @author George
 * @author jean
 */
public class PrincipalJFrame extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalJFrame
     */
    public PrincipalJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        conteudoJPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuItemAluno = new javax.swing.JMenuItem();
        jMenuItemCurso = new javax.swing.JMenuItem();
        jMenuItemDepartamento = new javax.swing.JMenuItem();
        jMenuItemDisciplina = new javax.swing.JMenuItem();
        jMenuItemProfessor = new javax.swing.JMenuItem();
        jMenuItemProjeto = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        conteudoJPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        conteudoJPanel.setPreferredSize(new java.awt.Dimension(1280, 720));
        conteudoJPanel.setLayout(new javax.swing.BoxLayout(conteudoJPanel, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(conteudoJPanel);

        jMenu.setText("Menu");

        jMenuItemAluno.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAluno.setText("Aluno");
        jMenuItemAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAlunoActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemAluno);

        jMenuItemCurso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCurso.setText("Curso");
        jMenuItemCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCursoActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemCurso);

        jMenuItemDepartamento.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemDepartamento.setText("Departamento");
        jMenuItemDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDepartamentoActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemDepartamento);

        jMenuItemDisciplina.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemDisciplina.setText("Disciplina");
        jMenuItemDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDisciplinaActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemDisciplina);

        jMenuItemProfessor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemProfessor.setText("Professor");
        jMenuItemProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProfessorActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemProfessor);

        jMenuItemProjeto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemProjeto.setText("Projeto");
        jMenuItemProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProjetoActionPerformed(evt);
            }
        });
        jMenu.add(jMenuItemProjeto);

        jMenuBar1.add(jMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>

    private void jMenuItemDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new DepartamentoJPanel());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
    }

    private void jMenuItemProfessorActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new ProfessorJPanel());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
    }

    private void jMenuItemCursoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new CursoJPanel());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
    }

    private void jMenuItemAlunoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new AlunoJPanel());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
    }

    private void jMenuItemDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new DisciplinaJPanel());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
    }

    private void jMenuItemProjetoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        conteudoJPanel.removeAll();
        conteudoJPanel.add(new ProjetoJPanel());
        conteudoJPanel.setVisible(false);
        conteudoJPanel.setVisible(true);
    }

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
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel conteudoJPanel;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemAluno;
    private javax.swing.JMenuItem jMenuItemCurso;
    private javax.swing.JMenuItem jMenuItemDepartamento;
    private javax.swing.JMenuItem jMenuItemDisciplina;
    private javax.swing.JMenuItem jMenuItemProfessor;
    private javax.swing.JMenuItem jMenuItemProjeto;
    // End of variables declaration
}

