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
public class CanalCom {

    int cargaIda =0;
    int cargaVolta = 0;
    int[] posicaoInicial;
    int[] posicaoFinal;

    public CanalCom(int xInicial, int yInicial, int xFinal, int yFinal) {

        posicaoInicial = new int[2];
        posicaoInicial[0] = xInicial;
        posicaoInicial[1] = yInicial;

        posicaoFinal = new int[2];
        posicaoFinal[0] = xFinal;
        posicaoFinal[1] = yFinal;

    }

    public int getCargaIda() {
        return cargaIda;
    }

    public void addCargaIda(int cargaIda) {
        this.cargaIda += cargaIda;
    }

    public int getCargaVolta() {
        return cargaVolta;
    }

    public void addCargaVolta(int cargaVolta) {
        this.cargaVolta += cargaVolta;
    }

    public int[] getPosicaoInicial() {
        return posicaoInicial;
    }

    public int[] getPosicaoFinal() {
        return posicaoFinal;
    }

    @Override
    public boolean equals(Object o) {

        CanalCom outroCanal = (CanalCom) o;

        return (this.getPosicaoInicial()[0] == outroCanal.getPosicaoInicial()[0] && this.getPosicaoInicial()[1] == outroCanal.getPosicaoInicial()[1]
                && this.getPosicaoFinal()[0] == outroCanal.getPosicaoFinal()[0] && this.getPosicaoFinal()[1] == outroCanal.getPosicaoFinal()[1]);

    }

}
