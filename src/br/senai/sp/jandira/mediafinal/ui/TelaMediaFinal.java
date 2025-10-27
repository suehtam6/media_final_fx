package br.senai.sp.jandira.mediafinal.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class TelaMediaFinal extends Application {


    VBox painelResultado;

    TextField tfNomeAluno;
    TextField tfNota1;
    TextField tfNota2;
    TextField tfNota3;
    TextField tfNota4;



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

        tfNomeAluno = new TextField(); // Criando barra para escrever o nome do aluno, utilizando TextField
        tfNota1 = new TextField(); // Criando barra para escrever as Notas do aluno
        tfNota2 = new TextField();
        tfNota3 = new TextField();
        tfNota4 = new TextField();

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
        painelResultado = new VBox();
        painelResultado.setPadding(new Insets(15));
        painelResultado.setStyle("-fx-background-color: #4169E1");
        Label lblResultados = new Label("Resultados");
        lblResultados.setStyle("-fx-font-size: 22px ;-fx-text-fill: white; -fx-font-weight: bold;");

        Label lblNomeResultado = new Label("Nome do Aluno: ");
        lblNomeResultado.setStyle("-fx-text-fill: white");

        Label lblMediaFinal = new Label("Média Final: ");
        lblMediaFinal.setStyle("-fx-text-fill: white");

        Label lblSituacao = new Label("Situação: ");
        lblSituacao.setStyle("-fx-text-fill: white");

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




        // ***** Interceptar cliques dos botões *****
        btCalularMedia.setOnAction(e -> {

            // Colocando uma mensagem de erro caso o usuario não digite alguma informação
            if (validarEntrada()) {
                String nomeAluno = tfNomeAluno.getText();
                lblNomeResultado.setText("Nome do Aluno: " + nomeAluno);

                String nota1 = tfNota1.getText();
                String nota2 = tfNota2.getText();
                String nota3 = tfNota3.getText();
                String nota4 = tfNota4.getText();

                double media = calcularMedia(nota1, nota2, nota3, nota4);
                String mediaformatada = String.format("%.2f", media);
                lblMediaFinal.setText("Media Final: " + mediaformatada);

                String situacao = definirSituacao(media);
                lblSituacao.setText("Situação: " + situacao);
            }
        });

        // Botão de limpar
        btLimpar.setOnAction(e -> {
            tfNomeAluno.setText("");
            tfNota1.setText("");
            tfNota2.setText("");
            tfNota3.setText("");
            tfNota4.setText("");
            lblNomeResultado.setText("nome do aluno: ");
            lblMediaFinal.setText("media final: ");
            lblSituacao.setText("situacao: ");
            tfNomeAluno.requestFocus();

        });

        // Botão de sair
        btSair.setOnAction(e -> {
            // Criando o botão de alerta e colocando uma mensagem diferente
            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION, "Deseja sair do aplicativo?", ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> resposta = alerta.showAndWait();
            if (resposta.get() == ButtonType.YES) {
                System.exit(0);
            }

            System.out.println(resposta.get().getText());
        });

    }




    // criando uma variavel privada
    private double calcularMedia(String n1, String n2, String n3, String n4) {


        double nota1 = Double.parseDouble(n1);
        double nota2 = Double.parseDouble(n2);
        double nota3 = Double.parseDouble(n3);
        double nota4 = Double.parseDouble(n4);
        double media = (nota1 + nota2 + nota3 + nota4) / 4;
        return media;

    }

    private String definirSituacao(double media){

        if (media < 4.0){
            painelResultado.setStyle("-fx-background-color: #f60d0d;");
            return  "REPROVADO!";
        } else if (media >= 6.0) {
            painelResultado.setStyle("-fx-background-color: #27b816;");
            return "APROVADO!";
        }else {
            painelResultado.setStyle("-fx-background-color: #ff8000;");
            return "RECUPERAÇÃO!";
        }



    }

    private boolean validarEntrada(){

        if (tfNomeAluno.getText().isEmpty()){
            mostrarMensagem(Alert.AlertType.ERROR, "Preencha o nome do aluno!!");
            tfNomeAluno.requestFocus();
            return false;

        }else if (tfNota1.getText().isEmpty()){
            mostrarMensagem(Alert.AlertType.ERROR, "Preencha a primeira nota aluno!!");
            tfNota1.requestFocus();
            return false;

        }else if (tfNota2.getText().isEmpty()){
            mostrarMensagem(Alert.AlertType.ERROR, "Preencha a segunda nota aluno!!");
            tfNota2.requestFocus();
            return false;

        }else if (tfNota3.getText().isEmpty()){
            mostrarMensagem(Alert.AlertType.ERROR, "Preencha a terceira nota aluno!!");
            tfNota3.requestFocus();
            return false;

        } else if (tfNota4.getText().isEmpty()) {
            mostrarMensagem(Alert.AlertType.ERROR , "Preencha a quarta nota aluno!!");
            tfNota4.requestFocus();
            return false;
        }else {
            return true;
        }

    }

    private void mostrarMensagem (Alert.AlertType tipo , String mensagem){
        Alert alerta = new Alert(tipo, mensagem);
        alerta.showAndWait();
    }
}
