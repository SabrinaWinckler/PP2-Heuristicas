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
public class MPSoC {
    Celula[][] celulas;

    public MPSoC(int nLinhas, int nColunas) {
        celulas = new Celula[nLinhas][nColunas];
    }
    
    public void addCelula(Celula celula, int linha, int coluna){
        this.celulas[linha][coluna] = celula;
    }
    
    public Celula getCelula(int linha, int coluna){
        return this.celulas[linha][coluna];
    }
    
    public Celula[][] getCelulas(){
        return this.celulas;
    }
    
}