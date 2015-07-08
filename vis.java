import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/**
 * This is a visualization part for Red-Black Tree
 * @author Mengyi Peng, Mingjun Xie, Ziyu Liu
 *
 */
public class vis extends Application {
	private Button add, remove, find;
	private Label data = new Label("Node:");
	
	private TextField textField = new TextField ();

	private Group root = new Group();
	
	private RBT<String> rbt = new RBT<>();
	
	VBox vb = new VBox();
	ToolBar tb= new ToolBar();
	
	private StackPane nodePane = new StackPane();
	
	private TreeVisualizer tv;
	ScrollPane scroll = new ScrollPane();
	
	private HBox hbox = new HBox();	
	
	/**
	 * Javafx application GUI
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		setUpButtons();

		BorderPane pane = new BorderPane();
		stage.setTitle("Red_Black Tree Vis");

		data.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
		data.setTextFill(Color.LIGHTPINK);

        pane.setTop(hbox);
        pane.setCenter(vb);
        vb.setAlignment(Pos.CENTER);
        root.getChildren().addAll(pane);

        Scene scene = new Scene(root, 800, 600);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
	}

	private void setUpButtons() {
        add = new Button("add");
        add.setId("addBtn");
        add.setPrefSize(80, 20);

        remove = new Button("remove");
        remove.setId("removeBtn");
        remove.setPrefSize(80, 20);
      
        find = new Button("find");
        find.setId("findBtn");
        find.setPrefSize(80, 20);
        
        hbox.setPadding(new Insets(15, 600, 15, 12));
        hbox.setSpacing(20);
        hbox.getChildren().addAll(data,textField, add, remove, find);
        hbox.setStyle("-fx-background-color: #336699;");     
        
        add.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent e){
        		if (textField.getText() != null) {
        			String tf = textField.getText();
        			try {
        			    rbt.add(tf);
        			    reDraw();
        			} catch (Exception a) {
        				System.out.println("VIS:" + a.getMessage());
        			}
        		}    		
        	}
        });
        
        remove.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
        });
        
        find.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
        }); 
        vb.getChildren().add(scroll);
	}
	
	/**
	 * after add/remove, use this function to reset the screen
	 */
	private void reDraw() {
		tv = new TreeVisualizer(rbt);
		
		if (! nodePane.getChildren().isEmpty()) {
		    nodePane.getChildren().remove(0);
		}
		System.out.println("Nodepane is empty");
		nodePane.getChildren().add(tv);
		scroll.setContent(nodePane);

	}


}
