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

    public H2(int qntLinhas, int qntColunas) {
        this.matriz = new Tarefa[qntLinhas][qntColunas];
        this.aplicativos = new ArrayList();
    }
    
    public void adicionarAplicativos(ArrayList lista){
        this.aplicativos = lista;
    }
    
    public Tarefa[][] executar(){
        if(this.aplicativos.size() > 0){
            
        }
        return null;
    }
    
    
}
