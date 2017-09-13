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
    public boolean verificarVerticeIda(int verticeAtualIda,int verticeIdaAlocado){
        if(verticeIdaAlocado == 0){
            return true;
        }
        if(verticeAtualIda < verticeIdaAlocado){
            return true;
            }
        return false;
    }
    public boolean verificarVerticeVolta( int verticeAtualVolta,int verticeVoltaAlocado){
         if(verticeVoltaAlocado == 0){
             return true;
         }
         if(verticeAtualVolta < verticeVoltaAlocado){
            return true;
            }
        return false;
    }
    public int calcularComunicacaoIda(int verticeIdaAlocado, int verticeAtual){
        verticeIdaAlocado = verticeAtual + verticeIdaAlocado;
        return verticeIdaAlocado;
    }
    public int calcularComunicacaoVolta(int verticeVoltaAlocado, int verticeAtual){
        verticeVoltaAlocado = verticeAtual + verticeVoltaAlocado;
        return verticeVoltaAlocado;
    }
    public void preencheH1(){
        ArrayList<Aplicativo> listaAplicativos = LeitorArquivo.montarLista(LeitorArquivo.carregarArquivo());          
        List<Tarefa> listaTarefas;
        Tarefa tarefa;
        Tarefa tarefaM = null;
        int verticeAlocadoIda, verticeAlocadoVolta;
        verticeAlocadoIda = 0;
        verticeAlocadoVolta = 0;
        for(int a = 0; a<listaAplicativos.size(); a++){
            listaTarefas = listaAplicativos.get(a).getTarefas();
            for(int i = 0; i< ep.length; i++){
                   
                 for (int j = 0; j<ep.length-1; i++){
                     this.identificador = listaTarefas.get(i).getNumero();
                     this.verticeIda = listaTarefas.get(i).getLarguraIda();
                     this.verticeVolta = listaTarefas.get(i).getLarguraVolta();
                     int tarefaMestra = listaTarefas.get(i).getMestra();
                      
                     if(this.identificador == tarefaMestra){
                        tarefaM = listaTarefas.get(i);
                        ep[i][j] = tarefaM;
                        break;
                     }
                     
                     if(this.identificador != tarefaMestra){
                         int verticeAtualIda = this.verticeIda;
                         int verticeAtualVolta = this.verticeVolta;
                         if(!verificarVerticeIda(verticeAtualIda,verticeAlocadoIda) && !verificarVerticeVolta(verticeAtualVolta, verticeAlocadoVolta)){                     
                            for(int x = 0; x < ep.length-1; x++  ){//não consegui fazer o que eu queria fazer aqui, que seria verificar as posições vazias, calcular a comunicação delas com suas mestras
                                for(int y = 0; y<ep.length-1;y++){
                                    if(ep[x][y] == null){
                                       calcularComunicacaoIda(verticeAlocadoIda, verticeAtualIda); 
                                       calcularComunicacaoVolta(verticeAlocadoVolta,verticeAtualVolta);
                                       if(verificarVerticeIda(verticeAtualIda,verticeAlocadoIda) && verificarVerticeVolta(verticeAtualVolta, verticeAlocadoVolta)){
                                           ep [x][y] = listaTarefas.get(i);
                                           break;
                                       }
                                    }
                                }
                                break;
                            }
                             
                         }
                         ep [i][j] = listaTarefas.get(i);
                         verticeAlocadoIda = calcularComunicacaoIda(verticeAlocadoIda, verticeAtualIda);
                         verticeAlocadoVolta = calcularComunicacaoVolta(verticeAlocadoVolta,verticeAtualVolta);
                         break;
                    }
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

