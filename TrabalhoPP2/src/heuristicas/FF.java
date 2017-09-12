/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristicas;

import gerais.LeitorArquivo;
import gerais.Aplicativo;
import gerais.Celula;
import gerais.MPSoC;
import gerais.Tarefa;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class FF {

    private MPSoC mat;
    private ArrayList<Aplicativo> listaApp;

    public FF(MPSoC mpsoc) {
        this.mat = mpsoc;
    }

    public void add() {
        int i = 0, j = 0;
        
        List<Tarefa> listaTar;
        
        for (int l = 0; l < listaApp.size(); l++) {
            listaTar = listaApp.get(l).getTarefas();
            for (int k = 0; k < listaTar.size(); k++) {
                mat.add(new Celula(i, j));
                j++;
                if (j == mat.length) {
                    i++;
                    j = 0;
                }
            }

        }
    }

}
