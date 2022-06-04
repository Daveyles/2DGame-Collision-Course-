package com.example.game2d;

import javafx.animation.SequentialTransition;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {

    Scene over; // scene for game over
    VBox vBox = new VBox(); //layout

    //labels for points and instructions
    Label labelScore;
    Label instructions;

    //Setting durations for points
    Duration duration_1 = Duration.millis(15000);
    Duration duration_2 = Duration.millis(17000);
    Duration duration_3 = Duration.millis(12000);
    Duration duration_4 = Duration.millis(20000);

    //durations for clouds
    Duration duration1 = Duration.millis(5000);
    Duration duration2 = Duration.millis(7000);
    Duration duration3 = Duration.millis(8000);
    Duration duration4 = Duration.millis(10000);
    Duration duration5 = Duration.millis(12000);


    //Translate transitions for points
    TranslateTransition point_1 = new TranslateTransition(duration_1);
    TranslateTransition point_2 = new TranslateTransition(duration_2);
    TranslateTransition point_3 = new TranslateTransition(duration_3);
    TranslateTransition point_4 = new TranslateTransition(duration_4);

    //Translate Transitions for clouds
    TranslateTransition translate1 = new TranslateTransition(duration1);
    TranslateTransition translate2 = new TranslateTransition(duration2);
    TranslateTransition translate3 = new TranslateTransition(duration3);
    TranslateTransition translate4 = new TranslateTransition(duration4);
    TranslateTransition translate5 = new TranslateTransition(duration5);

    //Sequence transition for points
    SequentialTransition sequentialTransition1;
    SequentialTransition sequentialTransition2;
    SequentialTransition sequentialTransition3;
    SequentialTransition sequentialTransition4;

    //Sequence transition for points
    SequentialTransition sequentialTransition_1;
    SequentialTransition sequentialTransition_2;
    SequentialTransition sequentialTransition_3;
    SequentialTransition sequentialTransition_4;
    SequentialTransition sequentialTransition_5;

    //Create Plane
    Rectangle shape1 = new Rectangle (180,100);
    String source = getClass().getResource("/plane.png").toExternalForm();
    Image image = new Image(source);
    ImageView imageView = new ImageView(image);


    //creating images for the coins
    Image point1 = new Image("/coin.png");
    ImageView shape2 = new ImageView(point1);

    Image point2 = new Image("/coin.png");
    ImageView shape3 = new ImageView(point2);

    Image point3 = new Image("/coin.png");
    ImageView shape4 = new ImageView(point3);

    Image point4 = new Image("/coin.png");
    ImageView shape5 = new ImageView(point4);

    //Creating clouds
    Rectangle shape_1 = new Rectangle(150,90);
    String source_1 = getClass().getResource("/cloud.png").toExternalForm();
    Image image1 = new Image(source_1);


    Rectangle shape_2 = new Rectangle(150,90);
    String source_2 = getClass().getResource("/cloud.png").toExternalForm();
    Image image2 = new Image(source_2);


    Rectangle shape_3 = new Rectangle(200,100);
    String source_3 = getClass().getResource("/cloud.png").toExternalForm();
    Image image3 = new Image(source_3);


    Rectangle shape_4 = new Rectangle(200,100);
    String source_4 = getClass().getResource("/cloud.png").toExternalForm();
    Image image4 = new Image(source_4);


    Rectangle shape_5 = new Rectangle(150,90);
    String source_5 = getClass().getResource("/cloud.png").toExternalForm();
    Image image5 = new Image(source_5);

    int score; //score variable
    Text text = new Text(); //texts used for labels and prompts

    @Override
    public void start(Stage stage) {
        //creating root layout
        Pane root = new Pane();

        //Set cloud images
        shape_1.setFill(new ImagePattern(image1));
        shape_2.setFill(new ImagePattern(image2));
        shape_3.setFill(new ImagePattern(image3));
        shape_4.setFill(new ImagePattern(image4));
        shape_5.setFill(new ImagePattern(image5));

        // Resize imageViews for points
        shape2.setFitWidth(40);
        shape2.setFitHeight(35);
        shape3.setFitWidth(40);
        shape3.setFitHeight(35);
        shape4.setFitWidth(40);
        shape4.setFitHeight(35);
        shape5.setFitWidth(40);
        shape5.setFitHeight(35);

        //Setting Point 1 position and adding sequential transition
        point_1.setToY(1950f);
        point_1.setCycleCount(200);
        point_1.setAutoReverse(false);

        sequentialTransition1 = new SequentialTransition (shape2, point_1);

        //Setting Point 2 position and adding sequential transition
        point_2.setToY(1950f);
        point_2.setCycleCount(200);
        point_2.setAutoReverse(false);

        sequentialTransition2 = new SequentialTransition (shape3, point_2);

        //Setting Point 3 position and adding sequential transition
        point_3.setToY(1950f);
        point_3.setCycleCount(200);
        point_3.setAutoReverse(false);

        sequentialTransition3 = new SequentialTransition (shape4, point_3);

        //Setting Point 4 position and adding sequential transition
        point_4.setToY(1950f);
        point_4.setCycleCount(200);
        point_4.setAutoReverse(false);

        sequentialTransition4 = new SequentialTransition (shape5, point_4);

        //set translate transition for shape 1
        translate1.setToX(-1950f);
        translate1.setCycleCount(200);
        translate1.setAutoReverse(false);

        sequentialTransition_1 = new SequentialTransition (shape_1, translate1);

        //set translate transition for shape 2
        translate2.setToX(-1950f);
        translate2.setCycleCount(200);
        translate2.setAutoReverse(false);

        sequentialTransition_2 = new SequentialTransition (shape_2, translate2);

        //set translate transition for shape 3
        translate3.setToX(-1950f);
        translate3.setCycleCount(200);
        translate3.setAutoReverse(false);

        sequentialTransition_3 = new SequentialTransition (shape_3, translate3);

        //set translate transition for shape 4
        translate4.setToX(-1950f);
        translate4.setCycleCount(200);
        translate4.setAutoReverse(false);

        sequentialTransition_4 = new SequentialTransition (shape_4, translate4);

        //set translate transition for shape 5
        translate5.setToX(-1950f);
        translate5.setCycleCount(200);
        translate5.setAutoReverse(false);

        sequentialTransition_5 = new SequentialTransition (shape_5, translate5);

        //group labels with images
        final Group group = new Group(createGuide(),createScore(),vBox,shape_2,shape_3,shape_4,shape2,shape3,shape4,shape5,root);

        //setting clouds images layouts
        shape_1.setX(1400);
        shape_1.setY(50);
        shape_2.setX(1400);
        shape_2.setY(400);
        shape_3.setX(1400);
        shape_3.setY(800);
        shape_4.setX(1400);
        shape_4.setY(500);
        shape_5.setX(1400);
        shape_5.setY(100);

        //setting clouds images layouts
        shape2.setX(400);
        shape2.setY(-50);
        shape3.setX(600);
        shape3.setY(-50);
        shape4.setX(700);
        shape4.setY(-50);
        shape5.setX(850);
        shape5.setY(-50);

        //create main scene
        final Scene scene = new Scene(group,1350, 680);
        group.setId("group");
        ImageView plane = CreatePlane(scene);
        root.getChildren().addAll(shape1,shape_1,shape_2,shape_3,shape_4,shape_5,labelScore);
        scene.getStylesheets().addAll(this.getClass().getResource("/style.css").toExternalForm());

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            double x = shape1.getX();
            double y = shape1.getY();

            //assign keys to mve the plane
            switch (event.getCode()){
                case RIGHT -> shape1.setX(x + 10);
                case LEFT -> shape1.setX(x - 10);
                case UP -> shape1.setY(y - 10);
                case DOWN -> shape1.setY(y + 10);
                case ENTER -> Play();
            }
            // pause game when space bar is pressed
            if(event.getCode() == KeyCode.SPACE){
                sequentialTransition1.pause();
                sequentialTransition2.pause();
                sequentialTransition3.pause();
                sequentialTransition4.pause();
                sequentialTransition_1.pause();
                sequentialTransition_2.pause();
                sequentialTransition_3.pause();
                sequentialTransition_4.pause();
                sequentialTransition_5.pause();
            }
        });

        stage.setTitle("2D Game - Collision Course");
        stage.setScene(scene);
        stage.setMaximized(true); //open scene maximized
        stage.show();
    }


    //function for play
    public void Play(){
        sequentialTransition1.play();
        sequentialTransition2.play();
        sequentialTransition3.play();
        sequentialTransition4.play();
        sequentialTransition_1.play();
        sequentialTransition_2.play();
        sequentialTransition_3.play();
        sequentialTransition_4.play();
        sequentialTransition_5.play();

    }
    //function for pause
    public void Pause(){
        sequentialTransition1.pause();
        sequentialTransition2.pause();
        sequentialTransition3.pause();
        sequentialTransition4.pause();
        sequentialTransition_1.pause();
        sequentialTransition_2.pause();
        sequentialTransition_3.pause();
        sequentialTransition_4.pause();
        sequentialTransition_5.pause();

    }
    //function for game over
    public void gameOver(){
        Button cancel = new Button("Exit");
        cancel.setId("cancel");
        BorderPane pane = new BorderPane();
        VBox order = new VBox();
        order.setSpacing(5);
        order.setAlignment(Pos.CENTER);
        Image image = new Image("/gameover.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(250);
        imageView.setFitWidth(350);
        cancel.setOnMouseClicked(e->{
            Platform.exit();
        });

        order.getChildren().addAll(pane,text,imageView,cancel);
        over = new Scene(order,500,400);
        Stage stage = new Stage();
        stage.setScene(over);
        stage.show();
    }

    //create plate method for imageView
    private ImageView CreatePlane(Scene scene) {

        shape1.setFill(new ImagePattern(image));
        shape1.setX(100);
        shape1.setY(200);
        imageView.setFitWidth(130);
        imageView.setFitHeight(80);
        imageView.setY(scene.getHeight() - imageView.getFitHeight());

        return imageView;
    }

    //instructions label function
    private Label createGuide() {
        instructions = new Label(
                "\n\tPress ENTER to play Collision Course!\n\tScore:"
        );

        instructions.setTextFill(Color.FORESTGREEN);
        instructions.setFont(Font.font("Arial", FontWeight.BOLD,20));
        return instructions;
    }

    //score label function
    private Label createScore() {
        score=0;

        labelScore = new Label();
        labelScore.setText(score+"");
        labelScore.setLayoutX(200);
        labelScore.setLayoutY(47);
        vBox.getChildren().add(labelScore);

        labelScore.setTextFill(Color.FORESTGREEN);
        labelScore.setFont(Font.font("Arial", FontWeight.BOLD,20));
        shape1.translateXProperty().addListener(observable -> {

        });

        //collision detection and increment score
        shape_1.translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1)
            {
                if (shape1.getBoundsInParent().intersects(shape_1.getBoundsInParent())){
                    String icon= getClass().getResource("/explode.png").toExternalForm();
                    Image imageB= new Image(icon);
                    shape1.setFill(new ImagePattern(imageB));
                    Pause();
                    gameOver();
                    shape_1.setOpacity(0.5);
                } else if (shape1.getBoundsInParent().intersects(shape_2.getBoundsInParent())) {
                    String icon= getClass().getResource("/explode.png").toExternalForm();
                    Image imageJet= new Image(icon);
                    shape1.setFill(new ImagePattern(imageJet));
                    Pause();
                    gameOver();
                    shape_2.setOpacity(0.5);
                } else if (shape1.getBoundsInParent().intersects(shape_3.getBoundsInParent())) {
                    String icon= getClass().getResource("/explode.png").toExternalForm();
                    Image imageB= new Image(icon);
                    shape1.setFill(new ImagePattern(imageB));
                    Pause();
                    gameOver();
                    shape_3.setOpacity(0.5);
                } else if (shape1.getBoundsInParent().intersects(shape_4.getBoundsInParent())) {
                    String icon= getClass().getResource("/explode.png").toExternalForm();
                    Image imageB= new Image(icon);
                    shape1.setFill(new ImagePattern(imageB));
                    Pause();
                    gameOver();
                    shape_4.setOpacity(0.5);
                }
                else if (shape1.getBoundsInParent().intersects(shape_5.getBoundsInParent())) {
                    String icon= getClass().getResource("/explode.png").toExternalForm();
                    Image imageB= new Image(icon);
                    shape1.setFill(new ImagePattern(imageB));
                    Pause();
                    gameOver();
                    shape_5.setOpacity(0.5);
                }
                else if (shape1.getBoundsInParent().intersects(shape2.getBoundsInParent())) {
                    score+=10;
                    labelScore.setText(score+" ");
                }
                else if (shape1.getBoundsInParent().intersects(shape3.getBoundsInParent())) {
                    score+=10;
                    labelScore.setText(score+" ");
                }
                else if (shape1.getBoundsInParent().intersects(shape4.getBoundsInParent())) {
                    score+=10;
                    labelScore.setText(score+" ");
                }
                else if (shape1.getBoundsInParent().intersects(shape5.getBoundsInParent())) {
                    score+=10;
                    labelScore.setText(score+" ");
                }
            }
        });
        return labelScore;
    }
    public static void main(String[] args) {
        launch();
    }
}