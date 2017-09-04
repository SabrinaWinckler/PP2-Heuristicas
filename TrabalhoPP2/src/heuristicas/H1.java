/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristicas;

import gerais.LeitorArquivo;
import gerais.Tarefa;
import java.util.ArrayList;

/**
 *
 * @author Sabrina
 */
public class H1 {
    private Tarefa ep [][];
    private int vertice;

    public H1(int tamanho) {
        this.ep = new Tarefa [tamanho][tamanho];
    }
    
    public void preencheH1(){//Não está pronto.
        ArrayList<Tarefa> listaTarefas = LeitorArquivo.montarLista(LeitorArquivo.carregarArquivo());          
        Tarefa tarefaM = listaTarefas.get(0);
        Tarefa tarefa = new Tarefa(0);
        boolean mestra = false;

        for(int i = 0; i< ep.length; i++){
            for (int j = 0; j<ep.length; i++){
                if(tarefa.getNumero() == tarefaM.getMestra()){
                    mestra = true;
                }
                if(ep [i][j]== null && mestra == true){
                    ep [i][j] = tarefaM;
                    mestra = false;      
                }
                while(ep[i][j] == tarefaM){
                    if(ep [i][j+1] == null){
                         ep [i][j+1] = tarefa;
                         break;
                    }
                    if(j > 0){
                        if(ep [i][j-1] == null){
                            ep [i][j-1] = tarefa;
                            break;
                        }
                    }
                    if(i>0){
                        if(ep [i-1][j] == null){
                            ep [i-1][j] = tarefa;
                            break;
                        }
                    }
                    if(ep [i+1][j] == null){
                          ep [i+1][j] = tarefa;
                          break;
                    }
                }
            }
        }
    }
}
