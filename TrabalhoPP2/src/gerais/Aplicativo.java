/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerais;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 */
public class Aplicativo {
    
    private ArrayList<Tarefa> tarefas;
    private String nome;
    
    public Aplicativo(String nome){
        this.nome = nome;
        this.tarefas = new ArrayList();
    }
    
    public void addTarefa(Tarefa tarefa){
        this.tarefas.add(tarefa);
    }
    
    public List<Tarefa> getTarefas(){
        return this.tarefas;
    }
    
    public String getNome(){
        return this.nome;
    }
    
}
