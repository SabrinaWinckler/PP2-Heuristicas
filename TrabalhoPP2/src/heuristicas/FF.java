/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heuristicas;

import gerais.Aplicativo;
import gerais.CanalCom;
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
    private int i = 0;
    private int j = 0;

    public FF(MPSoC mpsoc) {
        this.mat = mpsoc;
    }

    public void executar() {
       
        
        List<Tarefa> listaTar;
        
        for (int l = 0; l < listaApp.size(); l++) {
            listaTar = listaApp.get(l).getTarefas();
            for (int k = 0; k < listaTar.size(); k++) {
                
                if(listaTar.get(k).getNumero() == 0){
                     mat.getCelulas()[i][j].setTarefa(listaTar.get(k));
                }else{
                     mat.getCelulas()[i][j].setTarefa(listaTar.get(k));
                     preencherCanais(listaTar.get(k));
                }
               
                                
                
                j++;
                if (j == mat.getNColunas()) {
                    i++;
                    j = 0;
                }
            }

        }
    }

    private void preencherCanais(Tarefa tarefa) {
        
        int[] posicaoMestra;
        
        posicaoMestra = mat.getIndexTarefa(new Tarefa(tarefa.getMestra(),tarefa.getAplicativo()));
        
        if(posicaoMestra[1] == j){
            for(int l = 0; l<=i; l++){
                for(CanalCom canal :mat.getCelulas()[l][j].getListaCanais()){
                    
                    if(canal.equals(new CanalCom(l,j,l+1,j))){
                        canal.addCargaIda(tarefa.getLarguraIda());
                        canal.addCargaVolta(tarefa.getLarguraVolta());
                    }
                    
                }
            }
        }
        
    }

}
