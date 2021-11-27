package Views;

import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.discos.Disco;
import com.github.britooo.looca.api.group.discos.DiscosGroup;
import com.github.britooo.looca.api.group.memoria.Memoria;
import com.github.britooo.looca.api.group.processador.Processador;
import com.github.britooo.looca.api.group.sistema.Sistema;
import com.github.britooo.looca.api.group.temperatura.Temperatura;
import com.github.britooo.looca.api.util.Conversor;
import com.profesorfalken.jsensors.JSensors;
import com.profesorfalken.jsensors.model.components.Components;
import com.profesorfalken.jsensors.model.components.Gpu;
import com.profesorfalken.jsensors.model.sensors.Temperature;
import controller.ViewController;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.JSONObject;

public class Horus extends javax.swing.JFrame {

    private final ViewController vc = new ViewController();
    JSONObject json = new JSONObject();

    /**
     * Creates new form Horus
     */
    List<Object> listaMap = new ArrayList<>();

    public Horus(Map map) {
        initComponents();
        listaMap.add(map.get("idMaquina"));
        Color cor = new Color(255, 255, 255);
        getContentPane().setBackground(cor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        btnIniciar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        checkSO = new javax.swing.JCheckBox();
        checkCPU = new javax.swing.JCheckBox();
        checkRAM = new javax.swing.JCheckBox();
        checkGPU = new javax.swing.JCheckBox();
        checkDisco = new javax.swing.JCheckBox();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtSO = new javax.swing.JLabel();
        lblSO = new javax.swing.JLabel();
        txtCPU = new javax.swing.JLabel();
        lblProcessador = new javax.swing.JLabel();
        txtRAM = new javax.swing.JLabel();
        lblRAM = new javax.swing.JLabel();
        txtGPU = new javax.swing.JLabel();
        lblGPU = new javax.swing.JLabel();
        txtDisco = new javax.swing.JLabel();
        lblDisco = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1200, 520));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel13.setText("Selecione uma opção");

        btnIniciar.setBackground(new java.awt.Color(0, 204, 51));
        btnIniciar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnIniciar.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciar.setText("Iniciar Horus");
        btnIniciar.setBorder(null);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Horus.png"))); // NOI18N

        checkSO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        checkSO.setText("Sistema Operacional");
        checkSO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSOActionPerformed(evt);
            }
        });

        checkCPU.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        checkCPU.setText("Processador");
        checkCPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCPUActionPerformed(evt);
            }
        });

        checkRAM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        checkRAM.setText("Memória RAM");
        checkRAM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkRAMActionPerformed(evt);
            }
        });

        checkGPU.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        checkGPU.setText("Placa de Vídeo");
        checkGPU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkGPUActionPerformed(evt);
            }
        });

        checkDisco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        checkDisco.setText("Disco");
        checkDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDiscoActionPerformed(evt);
            }
        });

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkCPU)
                            .addComponent(checkSO)
                            .addComponent(checkRAM)
                            .addComponent(checkGPU)
                            .addComponent(checkDisco)
                            .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator6)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(32, 32, 32)
                .addComponent(checkSO)
                .addGap(18, 18, 18)
                .addComponent(checkCPU)
                .addGap(18, 18, 18)
                .addComponent(checkRAM)
                .addGap(18, 18, 18)
                .addComponent(checkGPU)
                .addGap(18, 18, 18)
                .addComponent(checkDisco)
                .addGap(39, 39, 39)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("INFORMAÇÕES DO COMPUTADOR");

        txtSO.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtSO.setForeground(new java.awt.Color(204, 204, 204));
        txtSO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/operating-system.png"))); // NOI18N
        txtSO.setText("Sistema Operacional");

        lblSO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSO.setText("Não selecionado");

        txtCPU.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtCPU.setForeground(new java.awt.Color(204, 204, 204));
        txtCPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cpu.png"))); // NOI18N
        txtCPU.setText("Processador");

        lblProcessador.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblProcessador.setText("Não selecionado");

        txtRAM.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtRAM.setForeground(new java.awt.Color(204, 204, 204));
        txtRAM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ram.png"))); // NOI18N
        txtRAM.setText("Memória RAM");

        lblRAM.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRAM.setText("Não selecionado");

        txtGPU.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtGPU.setForeground(new java.awt.Color(204, 204, 204));
        txtGPU.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gpu.png"))); // NOI18N
        txtGPU.setText("Placa de Vídeo");

        lblGPU.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblGPU.setText("Não selecionado");

        txtDisco.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtDisco.setForeground(new java.awt.Color(204, 204, 204));
        txtDisco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/harddisk.png"))); // NOI18N
        txtDisco.setText("Disco");

        lblDisco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDisco.setText("Não selecionado");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator4)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSO, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                        .addGap(139, 139, 139))
                    .addComponent(lblProcessador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtRAM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(lblGPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtGPU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(232, 232, 232))
                    .addComponent(lblDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtDisco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(274, 274, 274))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(txtSO, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSO, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPU, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblProcessador, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRAM, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRAM, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGPU, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGPU, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDisco, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDisco, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        // TODO add your handling code here:
        Looca looca = new Looca();
        Sistema sistema = looca.getSistema();
        Memoria memRam = looca.getMemoria();
        DiscosGroup grupoDeDiscos = looca.getGrupoDeDiscos();
        Processador processador = looca.getProcessador();
        Components components = JSensors.get.components();
        List<Gpu> gpus = components.gpus;

        String modGpu = null;

        if (checkSO.isSelected()) {
            //Pegando informações do sistema
            lblSO.setText(sistema.getSistemaOperacional());
            //checkSO.setEnabled(false);
        } else {
            lblSO.setText("Não selecionado");
        }

        if (checkCPU.isSelected()) {
            //Pegando informações do processador
            lblProcessador.setText(processador.getNome());
        } else {
            lblProcessador.setText("Não selecionado");
        }

        if (checkRAM.isSelected()) {
            //Pegando informações da memória ram e convertendo de long para string
            memRam.getTotal();
            Conversor.formatarBytes(memRam.getTotal());
            lblRAM.setText(Conversor.formatarBytes(memRam.getTotal()));
        } else {
            lblRAM.setText("Não selecionado");
        }

        if (checkDisco.isSelected()) {
            //Pegando informações do hard disk
            List<Disco> discos = grupoDeDiscos.getDiscos();

            for (Disco disco : discos) {
                String teste = Conversor.formatarBytes(disco.getTamanho());
                lblDisco.setText(teste);
            }
        } else {
            lblDisco.setText("Não selecionado");
        }

        if (checkGPU.isSelected()) {
            //Pegando informações da placa de vídeo

            if (gpus != null) {
                for (final Gpu gpu : gpus) {
                    lblGPU.setText(gpu.name);
                    modGpu = gpu.name;
                }
            }
        } else {
            lblGPU.setText("Não selecionado");
        }
        vc.init();
        String qntMem = Conversor.formatarBytes(memRam.getTotal());
        String nova = qntMem.replace(" GiB", "");
        String nova2 = nova.replace(",", ".");
        String modCPU = processador.getNome();
        qntMem = nova2;
        String idMaquina = listaMap.get(0).toString();
        vc.Insere(modCPU, modGpu, qntMem, idMaquina);
        vc.startInsert(idMaquina);

        // Area do log
        Temperatura temperatura = looca.getTemperatura();
        Double cpuTemp = temperatura.getTemperatura();
        Timer timer = new Timer();
        final TimerTask task = new TimerTask() {

            @Override
            public void run() {
                String hostname = listaMap.get(1).toString();
                Double gpuTemp = 0.0;
                if (gpus.size() > 0) {
                    for (final Gpu gpu : gpus) {
                        List<Temperature> temps = gpu.sensors.temperatures;
                        for (final Temperature temp : temps) {
                            gpuTemp = temp.value;

                            json.put("text", "Temperatura 1: " + gpuTemp);
                            try {
                                Slack.sendMessage(json);
                            } catch (IOException ex) {
                                Logger.getLogger(Horus.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Horus.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                Double teste = 5.7;               

                    if (teste < 30.5) {

                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        String dataHora = dtf.format(LocalDateTime.now()).toString();
                        String usoRam = Conversor.formatarBytes(memRam.getEmUso());
                        String freqCPU = Conversor.formatarBytes(processador.getFrequencia());
                        String dadosLog = String.format("Data e Hora: %s\nHostname: %s\nMensagem: Temperatura muito alta\nTemperatura da GPU: %sºC\nUso da RAM: %s\nFrequência CPU: %s\n\n", dataHora, hostname, gpuTemp, usoRam, freqCPU);
                        Log.criarLog("LOG.txt", dadosLog);
                        json.put("text", "Uso RAM: " + usoRam + "\n Temperatura GPU: " + gpuTemp);
                        json.put("text", "Alerta de temperatura muito alta, por favor realizar contenções! "
                                + "\nTemperatura: " + gpuTemp);
                        try {
                            Slack.sendMessage(json);
                        } catch (IOException ex) {
                            Logger.getLogger(Horus.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Horus.class.getName()).log(Level.SEVERE, null, ex);
                        }                    
                }
            }
        };
        timer.schedule(task, 0, 60 * 1000L);
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void checkSOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSOActionPerformed

        if (checkSO.isSelected()) {
            txtSO.setForeground(Color.black);
            lblSO.setText("Esperando iniciar...");
        } else {
            Color cinza = new Color(204, 204, 204);
            txtSO.setForeground(cinza);
            lblSO.setText("Não selecionado");
        }
    }//GEN-LAST:event_checkSOActionPerformed

    private void checkCPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkCPUActionPerformed
        if (checkCPU.isSelected()) {
            txtCPU.setForeground(Color.black);
            lblProcessador.setText("Esperando iniciar...");
        } else {
            Color cinza = new Color(204, 204, 204);
            txtCPU.setForeground(cinza);
            lblProcessador.setText("Não selecionado");
        }
    }//GEN-LAST:event_checkCPUActionPerformed

    private void checkRAMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkRAMActionPerformed
        if (checkRAM.isSelected()) {
            txtRAM.setForeground(Color.black);
            lblRAM.setText("Esperando iniciar...");
        } else {
            Color cinza = new Color(204, 204, 204);
            txtRAM.setForeground(cinza);
            lblRAM.setText("Não selecionado");
        }
    }//GEN-LAST:event_checkRAMActionPerformed

    private void checkGPUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkGPUActionPerformed
        if (checkGPU.isSelected()) {
            txtGPU.setForeground(Color.black);
            lblGPU.setText("Esperando iniciar...");
        } else {
            Color cinza = new Color(204, 204, 204);
            txtGPU.setForeground(cinza);
            lblGPU.setText("Não selecionado");
        }
    }//GEN-LAST:event_checkGPUActionPerformed

    private void checkDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkDiscoActionPerformed
        if (checkDisco.isSelected()) {
            txtDisco.setForeground(Color.black);
            lblDisco.setText("Esperando iniciar...");
        } else {
            Color cinza = new Color(204, 204, 204);
            txtDisco.setForeground(cinza);
            lblDisco.setText("Não selecionado");
        }
    }//GEN-LAST:event_checkDiscoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JCheckBox checkCPU;
    private javax.swing.JCheckBox checkDisco;
    private javax.swing.JCheckBox checkGPU;
    private javax.swing.JCheckBox checkRAM;
    private javax.swing.JCheckBox checkSO;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JLabel lblDisco;
    private javax.swing.JLabel lblGPU;
    private javax.swing.JLabel lblProcessador;
    private javax.swing.JLabel lblRAM;
    private javax.swing.JLabel lblSO;
    private javax.swing.JLabel txtCPU;
    private javax.swing.JLabel txtDisco;
    private javax.swing.JLabel txtGPU;
    private javax.swing.JLabel txtRAM;
    private javax.swing.JLabel txtSO;
    // End of variables declaration//GEN-END:variables
}
