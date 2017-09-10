/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristicas;

import gerais.LeitorArquivo;
import gerais.Aplicativo;
import gerais.Tarefa;

/**
 *
 * @author Lucas
 */
public class FF {
    private Tarefa[][] mat;

    public FF(Tarefa[][] mat) {
        this.mat = mat;
    }
    
    public FF(int tamanho) {
        mat = new Tarefa[tamanho][tamanho];
    }        
        
     public void add() { 
        int i = 0, j = 0; 
        ArrayList<Aplicativo> listaApp = LeitorArquivo.montarLista(LeitorArquivo.carregarArquivo()); 
        List<Tarefa> listaTar; 
        for (int l = 0; l < listaApp.size(); l++) { 
            listaTar = listaApp.get(l).getTarefas(); 
            for (int k = 0; k < listaTar.size(); k++) { 
                mat[i][j] = listaTar.get(k); 
                j++; 
                if (j == mat.length) { 
                    i++; 
                    j = 0; 
                } 
            } 
             
        } 
    } 
    
    
}
