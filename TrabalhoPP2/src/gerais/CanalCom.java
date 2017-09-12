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
    
    int cargaIda;
    int cargaVolta;
    int[] posicaoInicial;
    int[] posicaoFinal;
    
    public CanalCom(int xInicial, int yInicial, int xFinal, int yFinal){
        
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

    public void setCargaIda(int cargaIda) {
        this.cargaIda = cargaIda;
    }

    public int getCargaVolta() {
        return cargaVolta;
    }

    public void setCargaVolta(int cargaVolta) {
        this.cargaVolta = cargaVolta;
    }

    public int[] getPosicaoInicial() {
        return posicaoInicial;
    }

    public int[] getPosicaoFinal() {
        return posicaoFinal;
    }

}
