/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristicas;

import gerais.Aplicativo;
import gerais.Tarefa;
import java.util.ArrayList;

/**
 *
 * @author Gustavo Bittencourt Satheler
 * <gustavo.satheler@alunos.unipampa.edu.br>
 */
public class H2 {

    Tarefa[][] matriz;
    ArrayList<Aplicativo> aplicativos;

    ArrayList<Aplicativo> aplicativosConcluidos;
    ArrayList<Tarefa> TarefasConcluidas;

    public H2(int qntLinhas, int qntColunas, ArrayList lista) {
        this.matriz = new Tarefa[qntLinhas][qntColunas];
        this.aplicativos = new ArrayList();
        this.aplicativos = lista;

        this.aplicativosConcluidos = new ArrayList();
        this.TarefasConcluidas = new ArrayList();
    }

    public Tarefa[][] executar() {
        if (this.aplicativos.size() > 0) {
            while (this.aplicativos.size() > 0) {
                while (this.aplicativos.get(0).getTarefas().size() > 0) {
                    alocarTarefa(this.aplicativos.get(0).getTarefas().get(0));
                }
//                    this.aplicativos.get(aplicativoAtual).getTarefas().remove(0);
                aplicativosConcluidos.add(this.aplicativos.remove(0));
            }
        }
        //Lista de aplicativos vazia
        return null;
    }

    private boolean alocarTarefa(Tarefa tarefa) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                //Tarefa raiz
                if (tarefa.getNumero() == tarefa.getMestra()) {
                    matriz[i][j] = tarefa;
                    TarefasConcluidas.add(this.aplicativos.get(0).getTarefas().remove(0));
                    return true;
                } else {
                    int linha = buscarPosicaoMestre(tarefa, 0);
                    int coluna = buscarPosicaoMestre(tarefa, 1);

                    if ((coluna + 1) < matriz.length && linha >= 0 && matriz[linha][coluna + 1] == null) {
                        //Alocar a direita da tarefa mestre
                        //Se o mestre não for o ultimo elemento da coluna
                        //Se for nulo
                        
                        matriz[linha][coluna + 1] = tarefa;
                        TarefasConcluidas.add(this.aplicativos.get(0).getTarefas().remove(0));
                        return true;
                    } else if ((coluna - 1) >= 0 && linha >= 0 && matriz[linha][coluna - 1] == null) {
                        //Alocar a esquerda da tarefa mestre
                        //Se o mestre não for o primeiro elemento da coluna
                        //Se for nulo

                        matriz[linha][coluna - 1] = tarefa;
                        TarefasConcluidas.add(this.aplicativos.get(0).getTarefas().remove(0));
                        return true;
                    } else if ((linha + 1) < matriz.length && coluna >= 0 && matriz[linha + 1][coluna] == null) {
                        //Alocar em baixo da tarefa mestre
                        //Se o mestre não pertencer a ultima linha da matriz
                        //Se for nulo
                        
                        matriz[linha + 1][coluna] = tarefa;
                        TarefasConcluidas.add(this.aplicativos.get(0).getTarefas().remove(0));
                        return true;
                    } else if ((linha - 1) >= 0 && coluna >= 0 && matriz[linha - 1][coluna] == null) {
                        //Alocar acima da tarefa mestre
                        //Se o mestre não pertencer a primeira linha da matriz
                        //Se for nulo
                        
                        matriz[linha - 1][coluna] = tarefa;
                        TarefasConcluidas.add(this.aplicativos.get(0).getTarefas().remove(0));
                        return true;
                    } else if (matriz[i][j] == null){
                        matriz[i][j] = tarefa;
                        TarefasConcluidas.add(this.aplicativos.get(0).getTarefas().remove(0));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void exibir() {
        for (Tarefa[] matriz1 : matriz) {
            for (int i = 0; i < matriz.length; i++) {
                if (matriz1[i] != null) {
                    System.out.print("|" + "APP-" + matriz1[i].getNumero());
                } else {
                    System.out.print("|" + "APP--");
                }
            }
            System.out.println("|");
        }
    }

    private int buscarPosicaoMestre(Tarefa tarefa, int tipo) {
        int numero = tarefa.getNumero();
        int meuMestre = tarefa.getMestra();
        //TIPO 0 = LINHA, TIPO 1 = COLUNA

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (matriz[i][j] != null && matriz[i][j].getNumero() == meuMestre) {
                    if (tipo == 0) {
                        return i;
                    } else {
                        return j;
                    }
                }
            }
        }
        return -1;
    }

}
