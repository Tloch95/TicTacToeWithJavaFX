import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("restriction")
public class Drawing extends Application{

	GraphicsContext gc = null;
	Boolean[] isFilled = new Boolean[9];

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Tic-Tac-Toe");
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 960, 900);
		Button button = new Button("RESET");
		MyActionEvent actionEvent = new MyActionEvent();
		button.setOnAction(actionEvent);
		root.setLeft(button);
		final Canvas ticTacToe = new Canvas(900, 900);
		MyMouseEvent mouseEvent = new MyMouseEvent();
		ticTacToe.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent);
		root.setRight(ticTacToe);
		gc = ticTacToe.getGraphicsContext2D();
		divideBoard(gc);
		for (int i = 0;i < 9; i++) {
			isFilled[i] = false;
		} // end of for loop
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void divideBoard(GraphicsContext gc) {
		gc.strokeLine(300, 0, 300, 900);
		gc.strokeLine(600, 0, 600, 900);
		gc.strokeLine(0, 300, 900, 300);
		gc.strokeLine(0, 600, 900, 600);
		gc.strokeLine(0, 0, 0, 900);

	}

	private class MyMouseEvent implements EventHandler<MouseEvent>{
		private int timesClicked = 0;

		@Override
		public void handle (MouseEvent e) {
			Boolean tookATurn = false;
			if (timesClicked % 2 == 1) {
				if (e.getX() <= 300 && e.getY() <= 300 && isFilled[0] == false) {
					gc.strokeLine(10, 10, 290, 290);
					gc.strokeLine(290, 10, 10, 290);
					isFilled[0] = true;
					tookATurn = true;
				} else if (e.getX() > 300 && e.getX() <= 600 && e.getY() <= 300 && isFilled[1] == false) {
					gc.strokeLine(310, 10, 590, 290);
					gc.strokeLine(590, 10, 310, 290);
					isFilled[1] = true;
					tookATurn = true;
				} else if (e.getX() > 600 && e.getX() <= 900 && e.getY() <= 300 && isFilled[2] == false) {
					gc.strokeLine(610, 10, 890, 290);
					gc.strokeLine(890, 10, 610, 290);
					isFilled[2] = true;
					tookATurn = true;
				} else if (e.getX() <= 300 && e.getY() > 300 && e.getY() <= 600 && isFilled[3] == false) {
					gc.strokeLine(10, 310, 290, 590);
					gc.strokeLine(10, 590, 290, 310);
					isFilled[3] = true;
					tookATurn = true;
				} else if (e.getX() > 300 && e.getX() <= 600 && e.getY() > 300 && e.getY() <= 600 && isFilled[4] == false) {
					gc.strokeLine(310, 310, 590, 590);
					gc.strokeLine(590, 310, 310, 590);
					isFilled[4] = true;
					tookATurn = true;
				} else if (e.getX() > 600 && e.getX() <= 900 && e.getY() > 300 && e.getY() <= 600 && isFilled[5] == false){
					gc.strokeLine(610, 310, 890, 590);
					gc.strokeLine(890, 310, 610, 590);
					isFilled[5] = true;
					tookATurn = true;
				} else if (e.getX() <= 300 && e.getY() > 600 && e.getY() <= 900 && isFilled[6] == false) {
					gc.strokeLine(10, 610, 290, 890);
					gc.strokeLine(290, 610, 10, 890);
					isFilled[6] = true;
					tookATurn = true;
				} else if (e.getX() > 300 && e.getX() <= 600 && e.getY() > 600 && e.getY() <= 900 && isFilled[7] == false) {
					gc.strokeLine(310, 610, 590, 890);
					gc.strokeLine(590, 610, 310, 890);
					isFilled[7] = true;
					tookATurn = true;
				} else if (e.getX() > 600 && e.getX() <= 900 && e.getY() > 600 && e.getY() <= 900 && isFilled[8] == false) {
					gc.strokeLine(610, 610, 890, 890);
					gc.strokeLine(890, 610, 610, 890);
					isFilled[8] = true;
					tookATurn = true;
				}
			} else {
				if (e.getX() <= 300 && e.getY() <= 300 && isFilled[0] == false) {
					gc.strokeOval(10, 10, 280, 280);
					isFilled[0] = true;
					tookATurn = true;
				} else if (e.getX() > 300 && e.getX() <= 600 && e.getY() <= 300 && isFilled[1] == false) {
					gc.strokeOval(310, 10, 280, 280);
					isFilled[1] = true;
					tookATurn = true;
				} else if (e.getX() > 600 && e.getX() <= 900 && e.getY() <= 300 && isFilled[2] == false) {
					gc.strokeOval(610, 10, 280, 280);
					isFilled[2] = true;
					tookATurn = true;
				} else if (e.getX() <= 300 && e.getY() > 300 && e.getY() <= 600 && isFilled[3] == false) {
					gc.strokeOval(10, 310, 280, 280);
					isFilled[3] = true;
					tookATurn = true;
				} else if (e.getX() > 300 && e.getX() <= 600 && e.getY() > 300 && e.getY() <= 600 && isFilled[4] == false) {
					gc.strokeOval(310, 310, 280, 280);
					isFilled[4] = true;
					tookATurn = true;
				} else if (e.getX() > 600 && e.getX() <= 900 && e.getY() > 300 && e.getY() <= 600 && isFilled[5] == false){
					gc.strokeOval(610, 310, 280, 280);
					isFilled[5] = true;
					tookATurn = true;
				} else if (e.getX() <= 300 && e.getY() > 600 && e.getY() <= 900 && isFilled[6] == false) {
					gc.strokeOval(10, 610, 280, 280);
					isFilled[6] = true;
					tookATurn = true;
				} else if (e.getX() > 300 && e.getX() <= 600 && e.getY() > 600 && e.getY() <= 900 && isFilled[7] == false) {
					gc.strokeOval(310, 610, 280, 280);
					isFilled[7] = true;
					tookATurn = true;
				} else if (e.getX() > 600 && e.getX() <= 900 && e.getY() > 600 && e.getY() <= 900 && isFilled[8] == false) {
					gc.strokeOval(610, 610, 280, 280);
					isFilled[8] = true;
					tookATurn = true;
				} // end of inner if
			} // end of outer if
			if (tookATurn = true) {
				timesClicked++;
			} // end of if
		} // end of handle
	} // end of MyMouseEvent class

	public class MyActionEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			gc.clearRect(10, 10, 285, 285);
			gc.clearRect(310, 10, 285, 285);
			gc.clearRect(610, 10, 285, 285);
			gc.clearRect(10, 310, 285, 285);
			gc.clearRect(310, 310, 285, 285);
			gc.clearRect(610, 310, 285, 285);
			gc.clearRect(10, 610, 285, 285);
			gc.clearRect(310, 610, 285, 285);
			gc.clearRect(610, 610, 285, 285);
			for (int i = 0;i < 9; i++) {
				isFilled[i] = false;
			} // end of for loop
		} // end of handle method
	} // end of MyActionEvent class
} // end of Drawing class
