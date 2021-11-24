/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Views.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Gabri
 */
public class Log {
    
     public static void criarLog(String diretorioDoArquivo, String dadosLog) {
        
        try (
                FileWriter criadorDeArquivos = new FileWriter(diretorioDoArquivo, true);
                BufferedWriter buffer = new BufferedWriter(criadorDeArquivos);
                PrintWriter escritorDeArquivos = new PrintWriter(buffer);) {
            
            escritorDeArquivos.append(dadosLog);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
