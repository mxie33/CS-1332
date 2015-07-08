import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class dNode extends Group{
    private Text data;
    private int raduis = 20;
		   
		   
    public dNode(String data) {
    	this.data = new Text(data);
    	Circle c = new Circle(raduis,Color.IVORY);
    	c.setStroke(Color.RED);
    	
    	Label element = new Label(data);
	    element.setTextFill(Color.BLACK);
	    element.setPrefSize(raduis*2, raduis*2);
	    element.setTranslateX(-raduis);
	    element.setTranslateY(-raduis);
	    element.setTextAlignment(TextAlignment.CENTER);
	    element.setAlignment(Pos.CENTER);
	    getChildren().addAll(c,	element);
	 }
	       
	public void setData(String text) {
		this.data = new Text(text);
	}
	       
	       
	
