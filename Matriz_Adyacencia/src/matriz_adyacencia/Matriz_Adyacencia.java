/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matriz_adyacencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Robert Hernandez>
 */
public class Matriz_Adyacencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int matriz[][] = new int[8][8];
        matriz[2][1] = 1;
        matriz[4][1] = 1;
        matriz[1][4] = 1;
        
        matriz[1][2] = 1;
        /*matriz[3][2] = 1;
        matriz[2][3] = 1;
        matriz[3][2] = 1;
        matriz[2][3] = 1;
        matriz[3][3] = 1;
        matriz[3][4] = 1;
        matriz[4][3] = 1;*/
        
        
        String texto ="digraph G {\n";
        texto += allNodes(matriz)+"\n}";
        
        try {
        String ruta = "texto_graphviz.txt";
         File file = new File(ruta);
         
         if (!file.exists()) {
                file.createNewFile();
                
                
            }
         FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(texto);
            bw.close();
        }catch(Exception e){
            
        }
        
        crearGrafo();
       
    }

    /**
     *
     * @param matriz matriz de la cual se tomaran los datos
     * @return retorna un String con todos los nodos creados para graphviz node
     * del tipo: nodex_y[label="x,y"]; para cada espacio en la matriz con un 1
     */
    static String printAllNodes(int matriz[][]) {
        String texto = "";
        for (int i = 0; i <= matriz.length - 1; i++) {
            
                    texto += "node" + i +"[label = \""+i +"\"];\n";
                    
        }
        return texto;
    }
    
    

    /**
     * 
     * @param matriz: matriz de la cual se tomaran los datos
     * @return String con las conexion de todos los nodos adyacentes a cada 
     * nodo con un 1
     */
    static String allNodes(int matriz[][]) {
        String texto = "";
        try {
            for (int i = 0; i <= matriz.length-1; i++) {
                for (int j = 0; j <=matriz[i].length-1; j++) {
                    if (matriz[i][j]==1){
                        texto += "nodo"+i+"->"+"nodo"+j+";\n";
                    }
                    
                }
            }
        } catch (Exception e) {

        }

        return texto;
    }
 
static void crearGrafo () {
    try {
    String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
    String fileInputPath ="texto_graphviz.txt";
    String fileOutputPath ="grafo.jpg";
    
    String tParam = "-Tjpg";
      String tOParam = "-o";
      
      String[] cmd = new String[5];
      cmd[0] = dotPath;
      cmd[1] = tParam;
      cmd[2] = fileInputPath;
      cmd[3] = tOParam;
      cmd[4] = fileOutputPath;
      
      Runtime rt = Runtime.getRuntime();
      
      rt.exec( cmd );
    }catch(Exception e){
        
    }
}
}
