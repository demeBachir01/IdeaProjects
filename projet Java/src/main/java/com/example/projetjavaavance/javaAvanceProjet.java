package com.example.projetjavaavance;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class javaAvanceProjet extends Application {
    // ============================= Declaration =================================
    Label titre;
    Label pied;
    Label alcane;
    TextField nombre;
    Button Alcane,Alcene,Alcyne,effacer;
    HBox hb2,hb3,hb4,hb5;

    @Override
    public void start(Stage stage)  {
        // ======================instanciation des objets ==============================
        BorderPane root=new BorderPane();
        GridPane gird=new GridPane();
        Scene scene = new Scene(root, 800, 800);
        titre =new Label(" ◉◎◉◎◉◉◎◉◎◉ Hydrocarbures ◉◎◉◎◉◉◎◉◎◉");
        titre.setStyle("-fx-text-fill: navy");
        titre.setFont(Font.font(30));
        pied = new Label("◉◎◉◎◉◉◎◉◎◉  Universite Aliou Diop (UAD) 2020-2021  ◉◎◉◎◉◉◎◉◎◉");
        pied.setStyle("-fx-text-fill: navy");
        alcane =new Label("Donner un entier :");
        alcane.setFont(Font.font(15));
        alcane.setStyle("-fx-text-fill: navy");
        nombre =new TextField();
        Alcane =new Button("Alcane");
        Alcene =new Button("Alcéne");
        Alcyne =new Button("Alcyne");
        effacer =new Button("Effacer");
        Alcane.setMaxSize(170,100);
        Alcene.setMaxSize(170,100);
        Alcyne.setMaxSize(170,100);
        effacer.setMaxSize(170,100);
        Alcane.setStyle("-fx-text-fill: navy");
        Alcene.setStyle("-fx-text-fill: navy");
        Alcyne.setStyle("-fx-text-fill: navy");
        effacer.setStyle("-fx-background-color: red");

        //=================image logo=================================
       // Image image = new Image("img.jpg");
//        ImageView imageView = new ImageView(image);
//        HBox box = new HBox();
//        box.getChildren().add(imageView);

        hb2=new HBox();
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setStyle("-fx-background-color: dodgerblue");
        gird.addRow(0,titre);
        gird.addRow(1,alcane,nombre,Alcene,Alcyne,effacer);

        //========================= allignement en Haut ============================
        HBox hb=new HBox();
        hb.setStyle("-fx-border-color: navy");
        hb.setSpacing(10);
        hb.setAlignment(Pos.TOP_CENTER);
        hb.getChildren().add(titre);

        //========================= allignement a gauche ============================
        VBox v= new VBox();
        //v.setStyle("-fx-background-color: navy");
        v.setStyle("-fx-border-color : navy");
        v.setSpacing(10);
        v.setPadding(new Insets(15));
        v.setAlignment(Pos.CENTER_LEFT);

        //Image img=new Image("../image/Chime.png");
        //v.getChildren().add(new ImageView(img));
        v.getChildren().addAll(alcane,nombre,Alcane,Alcene,Alcyne,effacer);

        //===================Centre ===================================
        HBox h1=new HBox();
        h1.setAlignment(Pos.CENTER);
        gird.add(h1,2,5);
        h1.setMaxSize(1000,1000);
        // h1.setStyle("-fx-border-color: navy");
        // ImageView img=new ImageView();
        //img=new ImageView("");


        // =========================== allignement en bat  ======================
        HBox h=new HBox();
        h.setStyle("-fx-border-color: navy");
        h.setAlignment(Pos.BOTTOM_CENTER);
        h.getChildren().add(pied);
        gird.add(h,2,5);





        //==================================== l'action alcane ================================================================ ==============================
        //============ Alcanes===============
        Alcane.setOnAction(e-> {
            String enter = nombre.getText();
            int n = Integer.parseInt(enter);

            hb2 = ligneVerticales(n);

            hb3 = ligneVerticales(n);
            hb4 = hVerticales(n);
            hb5 = hVerticales(n);
            hb2.setAlignment(Pos.CENTER);
          //  hb2.setMaxSize(700, 700);
            hb3.setAlignment(Pos.CENTER);
         //   hb3.setMaxSize(700, 700);
            hb4.setAlignment(Pos.CENTER);
          //  hb4.setMaxSize(700, 700);
            hb5.setAlignment(Pos.CENTER);
          //  hb5.setMaxSize(700, 700);
            hb2.setSpacing(5);
            hb3.setSpacing(5);
            hb4.setSpacing(0.2);
            hb5.setSpacing(0.2);
            Label lbh = new Label();
            lbh.setText("H");
            lbh.setStyle("-fx-text-fill: white");
            lbh.setFont(Font.font(40));
            Line lin = new Line();
            lin.getStartX();
            lin.setEndX(50);
           // lin.setStyle("-fx-font: 10");
            h1.getChildren().addAll(lbh, lin);

            for (int i = 1; i <= n; i++) {

                Label lb = new Label();
                Line line = new Line();
                line.getStartX();
                line.setEndX(55);
                lb.setText("C");
                lb.setStyle("-fx-text-fill: white");
                lb.setFont(Font.font(40));
                h1.getChildren().addAll(lb);
            //    h1.setSpacing(5);
                h1.getChildren().add(line);
            }

            Label lbhf = new Label();
            lbhf.setText("H");
            lbhf.setStyle("-fx-text-fill: white");
            lbhf.setFont(Font.font(40));
            h1.getChildren().add(lbhf);
            vBox.getChildren().addAll(hb4,hb2,h1,hb3,hb5);


        });
        //=========================l'action effacer================================

        effacer.setOnAction(e-> {
            //vBox.getChildren().clear();
            vBox.getChildren().removeAll(vBox.getChildren());
            hb4.getChildren().clear();
            hb3.getChildren().clear();
            hb2.getChildren().clear();
            hb5.getChildren().clear();
            h1.getChildren().clear();
           // nombre.clear();
          //  nombre.setText("");

        });

//=========================================================

        //=========================l'action alcene ================================

        VBox v10=new VBox();
        Line linecene1=new Line();
        Line linecene2=new Line();
        linecene1.getStartX();
        linecene1.setEndX(80);
        linecene2.getStartX();
        linecene2.setEndX(80);
        v10.getChildren().addAll(linecene1,linecene2);
        v10.setSpacing(20);
        v10.setAlignment(Pos.CENTER);

        Alcene.setOnAction(e-> {

            String enter = nombre.getText();
            int n = Integer.parseInt(enter);

            hb2 = ligneVerticalesAlcene(n);
            hb3 = ligneVerticales(n);
            hb3.setSpacing(10);
            hb4 = hVerticalesAlcene(n);
            hb5 = hVerticales(n);
            hb5.setSpacing(5);
            hb2.setAlignment(Pos.CENTER);
          //  hb2.setMaxSize(700, 700);
            hb3.setAlignment(Pos.CENTER);
            hb4.setAlignment(Pos.CENTER);
           // hb4.setMaxSize(700, 700);
            hb5.setAlignment(Pos.CENTER);
           // hb5.setMaxSize(700, 700);

            for (int i = 1; i <= n; i++) {
                Label lb = new Label();

                if(i == 1){
                    lb.setText("C");
                    lb.setStyle("-fx-text-fill: white");
                    lb.setFont(Font.font(50));
                    h1.getChildren().addAll(lb,v10);
                }
                else {


                    Line line = new Line();
                    line.getStartX();
                    line.setEndX(50);
                    lb.setText("C");
                    lb.setStyle("-fx-text-fill: white");
                    lb.setFont(Font.font(50));
                    h1.getChildren().addAll(lb, line);
                }
            }

            Label lbhf = new Label();
            lbhf.setText("H");
            lbhf.setStyle("-fx-text-fill: white");
            lbhf.setFont(Font.font(50));
            h1.getChildren().add(lbhf);

            vBox.getChildren().addAll(hb4,hb2,h1,hb3,hb5);

        });
        //==============================================================

        //==========================l'action alcyne =================================================
        VBox v11=new VBox();
        Line linecene3=new Line();
        Line linecene4=new Line();
        Line linecene5=new Line();
        linecene3.getStartX();
        linecene3.setEndX(50);
        linecene4.getStartX();
        linecene4.setEndX(50);
        linecene5.getStartX();
        linecene5.setEndX(50);
        v11.getChildren().addAll(linecene3,linecene4,linecene5);
        v11.setSpacing(20);
        v11.setAlignment(Pos.CENTER);

        Alcyne.setOnAction(e-> {

            String enter = nombre.getText();
            int n = Integer.parseInt(enter);

            hb2 = ligneVerticalesAlcyne(n);
            hb3 = ligneVerticalesAlcyne(n);
            hb4 = hVerticalesAlcyne(n);
            hb5 = hVerticalesAlcyne(n);
            hb2.setAlignment(Pos.CENTER);
           // hb2.setMaxSize(700, 700);
            hb3.setAlignment(Pos.CENTER);
            //hb3.setMaxSize(700, 700);
            hb4.setAlignment(Pos.CENTER);
           // hb4.setMaxSize(700, 700);
            hb5.setAlignment(Pos.CENTER);
           // hb5.setMaxSize(700, 700);
            Label lbh = new Label();
            lbh.setText("H");
            lbh.setStyle("-fx-text-fill: white");
            lbh.setFont(Font.font(50));
            Line lin = new Line();
            lin.getStartX();
            lin.setEndX(50);
            h1.getChildren().addAll(lbh, lin);

            for (int i = 1; i <= n; i++) {
                Label lb = new Label();

                if(i == 1 ){
                    lb.setText("C");
                    lb.setStyle("-fx-text-fill: white");
                    lb.setFont(Font.font(50));
                    h1.getChildren().addAll(lb,v11);
                }
                else {


                    Line line = new Line();
                    line.getStartX();
                    line.setEndX(50);
                    lb.setText("C");
                    lb.setStyle("-fx-text-fill: white");
                    lb.setFont(Font.font(50));
                    h1.getChildren().addAll(lb, line);
                }
            }

            Label lbhf = new Label();
            lbhf.setText("H");
            lbhf.setStyle("-fx-text-fill: white");
            lbhf.setFont(Font.font(50));
            h1.getChildren().add(lbhf);

            vBox.getChildren().addAll(hb4,hb2,h1,hb3,hb5);

        });

        //==================================================================================







        root.setCenter(vBox);
        root.setTop(hb);
        root.setLeft(v);
        root.setBottom(h);
        stage.setTitle("Projet JAVA avance");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();


    }


    //====================methode alcane ========================
    HBox hVerticales(int n){
        HBox h2=new HBox();


        Line lin = new Line();
        lin.getStartX();
        lin.setEndX(50);
        lin.setVisible(false);
        h2.getChildren().addAll(lin);
        for (int i=1; i<=n;i++){
            Label lbh=new Label();
            lbh.setText("H");
            lbh.setStyle("-fx-text-fill: white");
            lbh.setFont(Font.font(40));
            Label lb = new Label();
            lb.setText("C");
            lb.setStyle("-fx-text-fill: white");
            lb.setFont(Font.font(10));
            lb.setVisible(false);
            Line lineh=new Line();
            lineh.getStartX();
            lineh.setEndX(50);
            lineh.setVisible(false);
            h2.getChildren().addAll(lbh,lb,lineh);

        }
        return h2;

    }

    HBox ligneVerticales(int n){
        HBox h2=new HBox();
        Line lin = new Line();
        lin.getStartX();
        lin.setEndX(50);
        lin.setVisible(false);
        h2.getChildren().addAll(lin);
        for (int i=1; i<=n;i++){
            Line line=new Line();
            line.getStartY();
            line.setEndY(50);
            Label lb = new Label();
            lb.setText("C");
            lb.setStyle("-fx-text-fill: white");
            lb.setFont(Font.font(50));
            lb.setVisible(false);
            Line lineh=new Line();
            lineh.getStartX();
            lineh.setEndX(30);
            lineh.setVisible(false);
            h2.getChildren().addAll(line,lb,lineh);

        }
        return h2;

    }



    //====================methode alcene ========================

    HBox ligneVerticalesAlcene(int n){
        HBox h2=new HBox();
        Line lin = new Line();
        lin.getStartX();
        lin.setEndX(50);
        lin.setVisible(false);
        h2.getChildren().addAll(lin);

        for (int i=1; i<n;i++){
            if (i==2 ){
                Line line=new Line();
                line.getStartY();
                line.setEndY(50);
                Label lb = new Label();
                lb.setText("C");
                lb.setStyle("-fx-text-fill: white");
                lb.setFont(Font.font(50));
                lb.setVisible(false);
                Line lineh=new Line();
                lineh.getStartX();
                lineh.setEndX(25);
                lineh.setVisible(false);
                line.setVisible(false);
                h2.getChildren().addAll(line,lb,lineh);
                h2.setSpacing(5);
            }

            // line.setVisible(false);
            Line line=new Line();
            line.getStartY();
            line.setEndY(50);
            Label lb = new Label();
            lb.setText("C");
            lb.setStyle("-fx-text-fill: white");
            lb.setFont(Font.font(50));
            lb.setVisible(false);
            Line lineh=new Line();
            lineh.getStartX();
            lineh.setEndX(50);
            lineh.setVisible(false);
            h2.getChildren().addAll(line,lb,lineh);

        }
        return h2;

    }

    HBox hVerticalesAlcene(int n){
        HBox h2=new HBox();
        Line lin = new Line();
        lin.getStartX();
        lin.setEndX(50);
        lin.setVisible(false);
        h2.getChildren().addAll(lin);
        for (int i=1; i<=n;i++){
            if(i==2){
                continue;
            }
            Label lbh=new Label();
            lbh.setText("H");
            lbh.setStyle("-fx-text-fill: white");
            lbh.setFont(Font.font(50));
            Label lb = new Label();
            lb.setText("C");
            lb.setStyle("-fx-text-fill: white");
            lb.setFont(Font.font(50));
            lb.setVisible(false);
            Line lineh=new Line();
            lineh.getStartX();
            lineh.setEndX(50);
            lineh.setVisible(false);
            h2.getChildren().addAll(lbh,lb,lineh);

        }
        return h2;

    }

    //====================methode alcyne ========================

    HBox ligneVerticalesAlcyne(int n){
        HBox h2=new HBox();
        Line lin = new Line();
        lin.getStartX();
        lin.setEndX(250);
        lin.setVisible(false);
        h2.getChildren().addAll(lin);

        for (int i=1; i<=n;i++){
            if (i==1 || i == 2 ) {
                continue;

            }

            Line line=new Line();
            line.getStartY();
            line.setEndY(50);
            Label lb = new Label();
            lb.setText("C");
            lb.setStyle("-fx-text-fill: white");
            lb.setFont(Font.font(50));
            lb.setVisible(false);
            Line lineh=new Line();
            lineh.getStartX();
            lineh.setEndX(50);
            lineh.setVisible(false);
            h2.getChildren().addAll(line,lb,lineh);

        }
        return h2;

    }

    HBox hVerticalesAlcyne(int n){
        HBox h2=new HBox();
        Line lin = new Line();
        lin.getStartX();
        lin.setEndX(200);
        lin.setVisible(false);
        h2.getChildren().addAll(lin);
        h2.setSpacing(6);
        for (int i=1; i<=n;i++){
            if(i==1 || i==2){
                continue;
            }
            Label lbh=new Label();
            lbh.setText("H");
            lbh.setStyle("-fx-text-fill: white");
            lbh.setFont(Font.font(50));
            Label lb = new Label();
            lb.setText("C");
            lb.setStyle("-fx-text-fill: white");
            lb.setFont(Font.font(50));
            lb.setVisible(false);
            Line lineh=new Line();
            lineh.getStartX();
            lineh.setEndX(1);
            lineh.setVisible(false);
            h2.getChildren().addAll(lbh,lb,lineh);

        }
        return h2;

    }
}



