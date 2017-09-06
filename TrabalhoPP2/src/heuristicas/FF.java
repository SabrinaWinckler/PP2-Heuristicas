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
    
    
    
    public void add(Tarefa task) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++){
                if (mat[i][j] == null) {
                mat[i][j] = task;
                }
            }
        }
    }
    
    
}
