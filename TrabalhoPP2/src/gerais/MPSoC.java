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
    int linhas;
    int colunas;

    public MPSoC(int nLinhas, int nColunas) {
        celulas = new Celula[nLinhas][nColunas];
        this.linhas = nLinhas;
        this.colunas = nColunas;

        for (int i = 0; i < nLinhas; i++) {
            for (int j = 0; j < nColunas; j++) {
                celulas[i][j] = new Celula();
            }
        }

    }

    public void addCelula(Celula celula, int linha, int coluna) {
        this.celulas[linha][coluna] = celula;
    }

    public Celula getCelula(int linha, int coluna) {
        return this.celulas[linha][coluna];
    }

    public Celula[][] getCelulas() {
        return this.celulas;
    }

    public int getNLinhas(){
        return this.linhas;
    }
    
    public int getNColunas(){
        return this.colunas;
    }
    
    public int[] getIndexTarefa(Tarefa tarefa){
        
        for(int i = 0; i < linhas; i++){
            for (int j = 0; j < colunas; j++) {
                
                if(celulas[i][j].getTarefa().equals(tarefa)){
                    return new int[]{i,j};
                }
                
            }
        }
        return null;        
    }
    
}
