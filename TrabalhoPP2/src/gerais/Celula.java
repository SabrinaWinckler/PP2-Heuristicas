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
public class Celula {

    Tarefa tarefa;
    List<CanalCom> listaCanais;

    public Celula() {
        listaCanais = new ArrayList();
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<CanalCom> getListaCanais() {
        return listaCanais;
    }

    public void addCanal(CanalCom canal) {
        this.listaCanais.add(canal);
    }

}
