/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import gerais.Aplicativo;
import gerais.CanalCom;
import gerais.LeitorArquivo;
import gerais.MPSoC;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Lucas
 */
public class View extends Application {

    //<editor-fold defaultstate="collapsed" desc="Declaração Design">   
    Stage stage;
    Scene scene;
    Button buttonStart;
    Button buttonImport;
    ComboBox<String> comboBoxHeuristicas;
    Pane pane;
    Pane paneLegenda;
    Pane paneSettings;

    ScrollPane scrollCenter;
    ScrollPane scrollLegenda;
    TextField textFieldLinhas;
    TextField textFieldColunas;

    Label labelTask;
    Label labelTaskTotal;
    Label labelAplicativos;
    Label labelAplicativosTotal;
    Label labelGeral;

    VBox legendaBox;

    int windowWidth = 800;
    int windowHeight = 600;
    int hGap = 60;
    int vGap = 60;
    int width = 30;
    int height = 30;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Declaração Variavéis">
    ArrayList<Rectangle> list;
    List<Aplicativo> listaAplicativos;
    int contadorTasksTotal = 0;
    int contadorTasks = 0;
    int contadorApp = 0;
    int totalTasks = 0;
    int colunas = 6;
    int linhas = 6;
    List<Rectangle> listaRectangulos;
    List<Rectangle> listaConexoes;
    List<Color> listaCores;
    MPSoC mpsoc;
    //</editor-fold>

    @Override
    public void start(Stage stage) {

        this.stage = stage;
        listaRectangulos = new ArrayList();
        listaConexoes = new ArrayList();
        listaCores = new ArrayList();
        listaCores.add(Color.RED);
        listaCores.add(Color.BLUE);
        listaCores.add(Color.AQUA);
        listaCores.add(Color.BROWN);
        listaCores.add(Color.CHARTREUSE);

        definirLayout();
        eventHandlers();
        buttonStart.setDisable(true);

//        montarMatrizVisual();
    }

    private void eventHandlers() {

        if (buttonStart != null) {
            buttonStart.setOnAction(event -> {
                buttonStartClick();
            });
        }

        if (buttonImport != null) {
            buttonImport.setOnAction(event -> {
                buttonImportClick();
            });
        }

    }

    //<editor-fold defaultstate="collapsed" desc="Implementacao Ações botões">
    private void buttonStartClick() {

        contadorTasksTotal++;
        contadorTasks++;
        labelTask.setText(String.valueOf(contadorTasksTotal));
        contarApp();
        AtualizarLabel();
        montarMatrizVisual();
        criarMPSoC();

        if (contadorTasksTotal == totalTasks) {
            buttonStart.setDisable(true);
        }

    }

    private void buttonImportClick() {

        listaAplicativos = LeitorArquivo.montarLista(LeitorArquivo.carregarArquivo());

        if (listaAplicativos != null) {
            resetarLegenda();
            resetarContadores();
            calcularAplicativos();
            AtualizarLabel();
            criarMPSoC();
            buttonStart.setDisable(false);
        }

    }

    //</editor-fold>
    public static void main(String[] args) {
        launch(args);
    }

    private void definirLayout() {

        //<editor-fold defaultstate="collapsed" desc="Principal">
        BorderPane borderPane = new BorderPane();
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Menu Lateral">
        scrollLegenda = new ScrollPane();
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(15, 12, 15, 12));
        vBox.setSpacing(10);
        vBox.setStyle("-fx-background-color: #336699;");
        vBox.setMinSize(150, 500);

        paneLegenda = new Pane();
        paneLegenda.setMinSize(150, 250);
        legendaBox = new VBox();
        Label legendaTitle = new Label("Legenda");
        legendaBox.getChildren().add(legendaTitle);
        paneLegenda.getChildren().add(legendaBox);

        VBox vBoxSettings = new VBox();
        paneSettings = new Pane();
        paneSettings.setMinSize(150, 250);
        paneSettings.setStyle("-fx-border-color:black");
        Label settingsTitle = new Label("Settings");
        Label settingsLinhas = new Label("Linhas");
        Label settingsColunas = new Label("Colunas");
        Label settingsHeuristica = new Label("Heurística");
        settingsTitle.setStyle("-fx-text-fill: #FFF;-fx-font-weight: bold;");
        settingsLinhas.setStyle("-fx-text-fill: #FFF;-fx-font-weight: bold;");
        settingsColunas.setStyle("-fx-text-fill: #FFF;-fx-font-weight: bold;");
        settingsHeuristica.setStyle("-fx-text-fill: #FFF;-fx-font-weight: bold;");
        vBoxSettings.setPadding(new Insets(10, 10, 10, 10));
        vBoxSettings.getChildren().add(settingsTitle);
        textFieldLinhas = new TextField();
        textFieldColunas = new TextField();
        vBoxSettings.getChildren().add(settingsLinhas);
        vBoxSettings.getChildren().add(textFieldLinhas);
        vBoxSettings.getChildren().add(settingsColunas);
        vBoxSettings.getChildren().add(textFieldColunas);
        vBoxSettings.getChildren().add(settingsHeuristica);

        comboBoxHeuristicas = new ComboBox();
        comboBoxHeuristicas.getItems().add("FF");
        comboBoxHeuristicas.getItems().add("H1");
        comboBoxHeuristicas.getItems().add("H2");
        comboBoxHeuristicas.getSelectionModel().selectFirst();
        vBoxSettings.getChildren().add(comboBoxHeuristicas);
        paneSettings.getChildren().add(vBoxSettings);

        scrollLegenda.setContent(paneLegenda);

        scrollLegenda.setMinHeight(250);
        scrollLegenda.setMinWidth(150);
        scrollLegenda.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollLegenda.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        vBox.getChildren().add(scrollLegenda);
        vBox.getChildren().add(paneSettings);
        //</editor-fold>

        //<editor-fold defaultstate="collapsed" desc="Menu Bottom">
        HBox hBox = new HBox();
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBox.setSpacing(10);
        hBox.setStyle("-fx-background-color: #336699;");

        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(15, 12, 15, 12));
        hBox1.setSpacing(10);
        hBox1.setStyle("-fx-background-color: #336699;");

        labelAplicativos = new Label("0");
        labelAplicativosTotal = new Label("0");
        labelTask = new Label("0");
        labelTaskTotal = new Label("0");

        labelGeral = new Label("Nenhum Arquivo Carregado");
        labelGeral.setStyle("-fx-text-fill: #FFF;-fx-font-weight: bold;");

        hBox1.setAlignment(Pos.BASELINE_CENTER);
        hBox1.getChildren().add(labelGeral);
        hBox1.setMinWidth(300);

        buttonImport = new Button("Importar");
        buttonStart = new Button("Start");

        hBox.getChildren().add(hBox1);
        hBox.getChildren().add(buttonImport);
        hBox.getChildren().add(buttonStart);
        hBox.setAlignment(Pos.BASELINE_RIGHT);

        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Centro">
        pane = new Pane();
        pane.setMinHeight(500);
        pane.setMinWidth(650);

        scrollCenter = new ScrollPane();
        scrollCenter.setContent(pane);
        scrollCenter.setPannable(true);
        scrollCenter.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollCenter.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        //</editor-fold>

        borderPane.setRight(vBox);
        borderPane.setBottom(hBox);
        borderPane.setCenter(scrollCenter);

        scene = new Scene(borderPane);
        stage.setMinHeight(windowHeight);
        stage.setMinWidth(windowWidth);
        stage.setScene(scene);
        stage.setTitle("MPSoc");
        stage.show();

    }

    private void AtualizarLabel() {

        labelGeral.setText("Aplicativos: " + labelAplicativos.getText() + "/" + labelAplicativosTotal.getText() + " Tasks: " + labelTask.getText() + "/" + labelTaskTotal.getText());

    }

    private void calcularAplicativos() {

        labelAplicativosTotal.setText(String.valueOf(listaAplicativos.size()));

        int contCor = 0;

        for (Aplicativo app : listaAplicativos) {
            totalTasks += app.getTarefas().size();
            app.setCor(listaCores.get(contCor));
            criarLegenda(app.getNome(), listaCores.get(contCor));
            contCor++;
        }

        labelTaskTotal.setText(String.valueOf(totalTasks));

    }

    private void criarLegenda(String nome, Color cor) {

        HBox legendaItem = new HBox();
        Label labelNome = new Label(nome);

        Rectangle quadradoCor = new Rectangle(10, 10);
        quadradoCor.setFill(cor);

        legendaItem.setPadding(new Insets(5, 5, 5, 5));
        legendaItem.getChildren().add(quadradoCor);
        legendaItem.getChildren().add(labelNome);

        legendaBox.getChildren().add(legendaItem);

    }

    private void contarApp() {

        if (listaAplicativos.get(contadorApp).getTarefas().size() == contadorTasks) {
            contadorApp++;
            contadorTasks = 0;
        }

        labelAplicativos.setText(String.valueOf(contadorApp));

    }

    private void montarMatrizVisual() {

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {

                listaRectangulos.add(new Rectangle(i * hGap + width, j * vGap + height, width, height));
                listaRectangulos.get(i * linhas + j).setFill(Color.GRAY);

                if (i + 1 > 0 && i + 1 < linhas) {
                    listaConexoes.add(new Rectangle((i * hGap + width) + width, (j * vGap + (height / 2 - 5)) + height, width, 10));
                }
                if (j + 1 > 0 && j + 1 < linhas) {
                    listaConexoes.add(new Rectangle((i * hGap + (width / 2 - 5)) + width, (j * vGap + height) + height, 10, height));
                }

            }

        }

        pane.getChildren().setAll(listaRectangulos);
        pane.getChildren().addAll(listaConexoes);

    }

    private void resetarLegenda() {

        for (int i = legendaBox.getChildren().size() - 1; i > 0; i--) {
            legendaBox.getChildren().remove(i);
        }

    }

    private void resetarContadores() {
        contadorApp = 0;
        contadorTasks = 0;
        labelAplicativos.setText("0");
        labelTask.setText("0");

    }

    private void criarMPSoC() {
        int linhas = 6;
        int colunas = 6;        
        
        if (!textFieldLinhas.getText().isEmpty()) {
            linhas = Integer.valueOf(textFieldLinhas.getText());
        }

        if (!textFieldColunas.getText().isEmpty()) {
            colunas = Integer.valueOf(textFieldColunas.getText());
        }

        
        mpsoc = new MPSoC(linhas, colunas);
        
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                
                //Celulas que só possuem 1 na frente Horizontal
                if(i+1 < linhas ){
                    mpsoc.getCelulas()[i][j].addCanal(new CanalCom(i,j,i+1,j));
                }
                
                //pegar o canal que ja existe e colocar como canal de comunicação contrário Horizontal
                if(i-1 >= 0){                  
                    for(CanalCom canal : mpsoc.getCelulas()[i-1][j].getListaCanais()){
                       if (canal.equals(new CanalCom(i-1,j,i,j))) {
                            mpsoc.getCelulas()[i][j].addCanal(canal);
                        }
                    }              
                }
                
                //Celulas que só possuem 1 na frente Vertical
                if(j+1 < colunas ){
                    mpsoc.getCelulas()[i][j].addCanal(new CanalCom(i,j,i,j+1));
                }
                
                //pegar o canal que ja existe e colocar como canal de comunicação contrário Vertical
                if(j-1 >= 0){                    
                    for(CanalCom canal : mpsoc.getCelulas()[i][j-1].getListaCanais()){
                        if (canal.equals(new CanalCom(i,j-1,i,j))) {
                            mpsoc.getCelulas()[i][j].addCanal(canal);
                        }
                    }              
                }
                
                
            }
        }

    }

}
