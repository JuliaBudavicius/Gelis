package Views;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.Processo;
import com.github.britooo.looca.api.group.processos.ProcessosGroup;
import java.awt.Color;
import java.awt.PopupMenu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class Processos extends javax.swing.JFrame {

    public Processos() {
        initComponents();

        Color cor = new Color(255, 255, 255);
        getContentPane().setBackground(cor);

        tableProcessos.setEnabled(false);

        Looca looca = new Looca();
        ProcessosGroup grupoDeProcessos = looca.getGrupoDeProcessos();
        Processo maior = null;
        Processo SegMaior = null;
        Processo TerMaior = null;
        List<Processo> processos = grupoDeProcessos.getProcessos();

        String colunas[] = {"Nome", "CPU", "PID"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Processo p : processos) {
            if (maior == null) {
                maior = processos.get(12);
                SegMaior = processos.get(12);
                TerMaior = processos.get(12);
            }
            if (p.getUsoCpu() > maior.getUsoCpu()) {
                maior = p;
            } else if (p.getUsoCpu() > SegMaior.getUsoCpu()) {
                SegMaior = p;
            } else if (p.getUsoCpu() > TerMaior.getUsoCpu()) {
                TerMaior = p;
            }
            String cpu = String.format("%.2f", p.getUsoCpu());
            String pid = String.format("%d", p.getPid());
            String nome = p.getNome();
            modelo.addRow(new String[]{nome, cpu, pid});
            tableProcessos.setModel(modelo);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableProcessos = new javax.swing.JTable();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableProcessos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tableProcessos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "CPU", "PID"
            }
        ));
        tableProcessos.setAlignmentX(1.0F);
        tableProcessos.setName("Processos"); // NOI18N
        jScrollPane3.setViewportView(tableProcessos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableProcessos;
    // End of variables declaration//GEN-END:variables
}
