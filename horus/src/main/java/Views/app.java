/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author leo5d
 */
public class app {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        JSONObject json = new JSONObject();
        
        json.put("text", "salve salve");
        
        Slack.sendMessage(json);
        
    }
}
