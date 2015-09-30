package controle.calorias.view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginView extends Application implements Viewable, EventHandler<ActionEvent> {

	private StackPane root;
	private Button btnNovo;
	private Text actiontarget;
	private TextField fieldLogin;
	private PasswordField fieldSenha;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Controle de Calorias - Identificação");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Faça o Login:");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		grid.add(new Label("Login:"), 0, 1);

		fieldLogin = new TextField();
		grid.add(fieldLogin, 1, 1);

		grid.add(new Label("Senha:"), 0, 2);

		fieldSenha = new PasswordField();
		grid.add(fieldSenha, 1, 2);

		Button btn = new Button("Entrar");
		btn.setOnAction(this);

		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);

		actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		Scene scene = new Scene(grid, 300, 250);
		scene.getStylesheets().add(LoginView.class.getResource("../../../resources/Login.css").toExternalForm());
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	@Override
	public void handle(ActionEvent event) {
		System.out.println(fieldLogin.getText() + " " + fieldSenha.getText());
		if (event.getTarget().toString().contains("Entrar")) {
			if (fieldLogin.getText().equals("user") && fieldSenha.getText().equals("pass")) {
				actiontarget.setText("Login Válido");
				actiontarget.setFill(Color.DARKGREEN);
			} else {
				actiontarget.setText("Login Inválido");
				actiontarget.setFill(Color.FIREBRICK);
			}
		}
	}

	@Override
	public void fromModel(Object objeto) {
	}

	@Override
	public Object toModel() {
		return null;
	}

}
