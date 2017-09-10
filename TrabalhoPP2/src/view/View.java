/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import gerais.Aplicativo;
import gerais.LeitorArquivo;
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
    //</editor-fold>

    @Override
    public void start(Stage stage) {

        this.stage = stage;
        listaRectangulos = new ArrayList();
        listaConexoes = new ArrayList();

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
        
        if(contadorTasksTotal == totalTasks){
            buttonStart.setDisable(true);
        }

    }

    private void buttonImportClick() {

        listaAplicativos = LeitorArquivo.montarLista(LeitorArquivo.carregarArquivo());
        
        if(listaAplicativos != null){
            calcularAplicativos();
            AtualizarLabel();
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

        paneSettings = new Pane();
        paneSettings.setMinSize(150, 250);

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

        

        for (Aplicativo app : listaAplicativos) {
            totalTasks += app.getTarefas().size();
        }

        labelTaskTotal.setText(String.valueOf(totalTasks));

    }

    private void contarApp() {
        
        if(listaAplicativos.get(contadorApp).getTarefas().size() == contadorTasks){
            contadorApp++;
            contadorTasks=0;
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

    
}
