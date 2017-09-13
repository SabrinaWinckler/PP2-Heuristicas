/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristicas;

import gerais.LeitorArquivo;
import gerais.Tarefa;
import java.util.ArrayList;
import gerais.Aplicativo;
import java.util.List;

/**
 *
 * @author Sabrina
 */
public class H1 {
    private Tarefa ep [][];
    private int verticeIda;
    private int verticeVolta;
    private int identificador;

    public H1(int tamanho) {
        this.ep = new Tarefa [tamanho][tamanho];
    }
    
    public void preencheH1(){//Não está pronto.
        ArrayList<Aplicativo> listaAplicativos = LeitorArquivo.montarLista(LeitorArquivo.carregarArquivo());          
        List<Tarefa> listaTarefas;
        Tarefa tarefa;
        for(int a = 0; a<listaAplicativos.size(); a++){
            listaTarefas = listaAplicativos.get(a).getTarefas();
            tarefa = new Tarefa(a);
            for(int i = 0; i< ep.length; i++){
                this.identificador = listaTarefas.get(i).getNumero();
                this.verticeIda = listaTarefas.get(i).getLarguraIda();
                this.verticeVolta = listaTarefas.get(i).getLarguraVolta();
                int tarefaMestra = listaTarefas.get(i).getMestra();
                for (int j = 0; j<ep.length; i++){
                    if(this.identificador == tarefaMestra && ep [i][j]== null){
                     ep [i][j] = tarefa;
                     break;
                    }                                             
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
//                if(ep [i+1][j] == null){
                
      //             ep [i+1][j] = tarefa;
    //                break;
  //              }
            }
       }
        }
    }
    public void mostrar(){
        for (int i=0; i<6;i++){
                System.out.println(this.ep[i][0]+ "  " +this.ep[i][1] + "  " + this.ep[i][2]+ "  " +this.ep[i][3]+ "  " +this.ep[i][4] + "  " +this.ep[i][5] + "  ");
 
        }
   }
}

