/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerais;

import java.util.List;

/**
 *
 * @author Lucas
 */
public class Tarefa {

    private List<Tarefa> Escravas;
    private int numero;
    private int larguraIda;
    private int larguraVolta;

    public Tarefa(int numero) {
        this.numero = numero;
    }

    public Tarefa(int numero, int larguraIda, int larguraVolta) {
        this(numero);
        this.larguraIda = larguraIda;
        this.larguraVolta = larguraVolta;
    }

    public List<Tarefa> getEscravas() {
        return Escravas;
    }

    public int getNumero() {
        return numero;
    }

    public int getLarguraIda() {
        return larguraIda;
    }

    public int getLarguraVolta() {
        return larguraVolta;
    }

    public void addEscrava(Tarefa tarefa) {
        this.Escravas.add(tarefa);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tarefa)) {
            return false;
        }
        Tarefa outraTarefa = (Tarefa) o;
        return (this.getNumero() == outraTarefa.getNumero());
    }

}
