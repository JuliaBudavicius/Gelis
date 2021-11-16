/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Slack;
import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author leo5d
 */
public class MensagemSlack {

    public void startService() throws IOException, InterruptedException {
        // Avisando para o usuario que a máquina está sendo monitorada
        JSONObject msgBoasVindas = new JSONObject();
        msgBoasVindas.put("text", "Seja bem-vindo(a) :slightly_smiling_face:\nSuas máquinas estão sendo monitoradas.");
        Slack.sendMessage(msgBoasVindas);
    }

    public void stopService() throws IOException, InterruptedException {
        // Avisando para o usuario que o serviço de monitoramento está sendo encerrado
        JSONObject msgAdeus = new JSONObject();
        msgAdeus.put("text", "Encerrando o serviço de monitoramento.\nAté breve!");
        Slack.sendMessage(msgAdeus);
    }
}

