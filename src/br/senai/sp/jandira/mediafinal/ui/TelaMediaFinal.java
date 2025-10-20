package br.senai.sp.jandira.mediafinal.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaMediaFinal extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(600); // Mudando a largura
        //stage.setHeight(500); // Mudando a altura
        stage.setResizable(false); // Dizendo se é ou não possivel aumentar o tamanho dela
        stage.setTitle("Média Final"); // Titulo do aplicativo

        // Criar o painel principal(root)
        BorderPane root = new BorderPane();

        // Criar o label com o titulo da tela
        Label titulo = new Label();
        titulo.setText("Escola SENAI \"Prof. Vicente Amato\"");
        titulo.setStyle("-fx-font-size: 22; -fx-text-fill: white"); // Mudando o tamanho e a cor do titulo
        titulo.setPadding(new Insets(10, 0, 10, 10)); //Mudando o padding do titulo

        HBox painelSuperior = new HBox();
        painelSuperior.setStyle("-fx-background-color: #4169E1");// Mudando a cor da caixa do titulo
        painelSuperior.getChildren().addAll(titulo); // Colocando o titulo no aplicativo

        // Criação de formulario
        VBox painelFormulario = new VBox();
        painelFormulario.setStyle("-fx-background-color: #6495ED");
        painelFormulario.setPadding(new Insets(20));
        painelFormulario.setSpacing(10);
        Label lblNomeAluno = new Label("Nome Do Aluno:"); //Criando nome do usuario utilizando Label
        Label lblNota1 = new Label("Nota 1:"); //Criando Notas do aluno utilizando Label
        Label lblNota2 = new Label("Nota 2:");
        Label lblNota3 = new Label("Nota 3:");
        Label lblNota4 = new Label("Nota 4:");

        TextField tfNomeAluno = new TextField(); // Criando barra para escrever o nome do aluno, utilizando TextField
        TextField tfNota1 = new TextField(); // Criando barra para escrever as Notas do aluno
        TextField tfNota2 = new TextField();
        TextField tfNota3 = new TextField();
        TextField tfNota4 = new TextField();

        painelFormulario.getChildren().addAll(
                lblNomeAluno, tfNomeAluno,
                lblNota1, tfNota1,
                lblNota2, tfNota2,
                lblNota3,tfNota3,
                lblNota4,tfNota4
        );


        // Criando os botões
        VBox painelBotoes = new VBox();
        painelBotoes.setPadding(new Insets(0, 15, 0 ,0));
        painelBotoes.setSpacing(15); // Colocando um espaço de 15 px entre os botões
        painelBotoes.setAlignment(Pos.CENTER); // Colocando os botões no centro
        painelBotoes.setStyle("-fx-background-color: #6495ED");
        Button btCalularMedia = new Button("Calcular Média");

        // Mudando o tamanho de todos os botões
        btCalularMedia.setPrefWidth(150);
        btCalularMedia.setPrefHeight(100);

        Button btLimpar = new Button("Limpar");
        btLimpar.setPrefWidth(150);
        btLimpar.setPrefHeight(70);

        Button btSair = new Button("SAIR");
        btSair.setPrefWidth(150);
        btSair.setPrefHeight(70);

        painelBotoes.getChildren().addAll(
                btCalularMedia,
                btLimpar,
                btSair
        );

        // Criando resultados
        VBox painelResultado = new VBox();
        painelResultado.setStyle("-fx-background-color: #4169E1");
        Label lblResultados = new Label("Resultados:");
        Label lblNomeResultado = new Label("Nome do Aluno:");
        Label lblMediaFinal = new Label("Média Final:");
        Label lblSituacao = new Label("Situação:");

        painelResultado.getChildren().addAll(
                lblResultados, lblNomeResultado,
                lblMediaFinal, lblSituacao
        );

       // Adicionando conteúdo ao root
        root.setTop(painelSuperior);
        root.setCenter(painelFormulario);
        root.setRight(painelBotoes);
        root.setBottom(painelResultado);


        // Criar o objeto da scene
        Scene scene = new Scene(root);



        // Colocar a scene no stage
        stage.setScene(scene);

        // Mostrar a scene
        stage.show();
    }
}
