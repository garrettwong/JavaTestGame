package application.testRenderers;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

public class ShapeRenderer {
	
	/* graphicsContext passed in as a parameter to the constructor */
	private GraphicsContext graphicsContext;
	
	public ShapeRenderer(GraphicsContext graphicsContext) {
		this.graphicsContext = graphicsContext;
	}

    public void drawShapes() {
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.setStroke(Color.BLUE);
        graphicsContext.setLineWidth(5);
        graphicsContext.strokeLine(40, 10, 10, 40);
        graphicsContext.fillOval(10, 60, 30, 30);
        graphicsContext.strokeOval(60, 60, 30, 30);
        graphicsContext.fillRoundRect(110, 60, 30, 30, 10, 10);
        graphicsContext.strokeRoundRect(160, 60, 30, 30, 10, 10);
        graphicsContext.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        graphicsContext.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        graphicsContext.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        graphicsContext.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        graphicsContext.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        graphicsContext.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        graphicsContext.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
        graphicsContext.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
        graphicsContext.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4);
    }
}
