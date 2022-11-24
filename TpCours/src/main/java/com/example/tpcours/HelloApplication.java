package com.example.tpcours;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    //declaration de objects
    TextField text1,text2,text3;
    Button button1,button2,button3,button;
    Label lbN;
    Label lbP;
    Label lbCode;
    ToggleGroup toggleGroup;
    RadioButton on;
    RadioButton off;
    TreeView<String> treeView;
    TreeItem<String> root,marque,couleur;
    MenuBar menuBar=new MenuBar();
    Menu menu=new Menu("FILE");
    @Override
    public void start(Stage stage) throws IOException {
        //instanciation des objects
        treeView=new TreeView<>();
        toggleGroup=new ToggleGroup();
        on=new RadioButton();
        off=new RadioButton();
        text1=new TextField();
        text2=new TextField();
        text3=new TextField();
        button=new Button();
        button1=new Button();
        button2=new Button();
        button3=new Button();
        //Ajout des objects
        text1.setMaxSize(80,75);
        text2.setMaxSize(80,75);
        text3.setMaxSize(80,75);
        button.setText("Confirmer");
        button1.setText("Effacer");
        button2.setText("Afficher");
        button3.setText("Calculer");
        lbN=new Label("nom");
        lbN.setText("Nom");
        lbP=new Label();
        lbCode=new Label();
        lbCode.setText("code             ");
        lbP.setText("Prenom");
        on.setText("ON");
        off.setText("OFF");
        on.setToggleGroup(toggleGroup);
        off.setToggleGroup(toggleGroup);
//        button.setText("Ma premiere application javaFx");
        StackPane stackPane=new StackPane();
        root=new TreeItem<>();
        root.setExpanded(true);
        marque=makeBranch("Marque",root);
        makeBranch("Ford",marque);
        makeBranch("Golf",marque);
        makeBranch("Rav4",marque);
        makeBranch("RL9",marque);
        couleur=makeBranch("Couleur",root);
        makeBranch("Noire",couleur);
        makeBranch("Grise",couleur);
        makeBranch("Verte",couleur);
        makeBranch("Bleu",couleur);
        treeView = new TreeView<String>(root);
        treeView.setShowRoot(false);
      //  stackPane.getChildren().add(treeView);
        stackPane.setPadding(new Insets(10));
        BorderPane borderPane=new BorderPane();
        GridPane gridPane=new GridPane();
        HBox hBox=new HBox();
        VBox vBox=new VBox();
        vBox.getChildren().add(on);
        vBox.getChildren().add(off);
        gridPane.add(lbN,0,0);
        gridPane.add(lbP,0,2);
        gridPane.add(lbCode,0,4);
        gridPane.add(text2,2,0);
        gridPane.add(text1,2,2);
        gridPane.add(text3,2,4);
        hBox.getChildren().add(button);
        hBox.getChildren().add(button1);
        hBox.getChildren().add(button2);
        hBox.getChildren().add(button3);

        menu.getItems().add(new MenuItem("save as ..."));
        menu.getItems().add(new MenuItem("Open File"));
        menu.getItems().add(new SeparatorMenuItem());
        menu.getItems().add(new MenuItem("Import"));
        menu.getItems().add(new SeparatorMenuItem());
        menu.getItems().add(new MenuItem("Export"));
        MenuItem minew=new MenuItem("NEW");
        menu.getItems().add(minew);
        menuBar.getMenus().add(menu);
       // stackPane.getChildren().add(menuBar);
        borderPane.setTop(menuBar);
        borderPane.setBottom(hBox);
        borderPane.setLeft(vBox);
        Scene scene = new Scene(borderPane, 420, 340,Color.GREEN);
        button.setOnAction(actionEvent ->  new Alert(Alert.AlertType.valueOf("Boite d'Alert")));
        stage.setTitle("TP COURS!");
       stage.setScene(scene);
        stage.show();

    }

    private TreeItem<String> makeBranch(String titre,TreeItem<String> root2) {
        TreeItem<String> tItem=new TreeItem<>(titre);
        tItem.setExpanded(true);
        root2.getChildren().add(tItem);
        return tItem;
    }

    public static void main(String[] args) {
        launch();
    }
}