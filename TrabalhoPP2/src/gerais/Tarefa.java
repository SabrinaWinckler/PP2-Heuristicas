/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerais;

/**
 *
 * @author Lucas
 */
public class Tarefa {
   
    private int numero;
    private int larguraIda;
    private int larguraVolta;
    private int mestra;

    public Tarefa(int numero) {
        this.numero = numero;        
    }

    public Tarefa(int numero, int larguraIda, int larguraVolta,int mestra) {
        this(numero);
        this.larguraIda = larguraIda;
        this.larguraVolta = larguraVolta;
        this.mestra = mestra;
    }

    public int getMestra() {
        return mestra;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tarefa)) {
            return false;
        }
        Tarefa outraTarefa = (Tarefa) o;
        return (this.getNumero() == outraTarefa.getNumero());
    }

}
