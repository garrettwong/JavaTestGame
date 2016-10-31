package application;
	

import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;
import lib.Sprite;


public class Main extends Application {
	List<Building> buildings;
	List<Ship> ships;
	List<Missile> missiles;	
	
	Timeline gameloop;
	GraphicsContext graphicsContext;
	
	public void draw(GraphicsContext gc) 
	{
        //gc.clearRect(0, 0, 500, 500);
        
		for (Building b : buildings) {
			b.draw(gc);
		}
		for (Ship s : ships) {
			s.draw(gc);
		}
		for (Missile m : missiles) {
			m.draw(gc);
		}
	}
	
	public int getWidth() {
		return 500;
	}
	public int getHeight() {
		return 500;
	}

	public void setupApp() 
	{
		buildings = GameSeeder.getBuildings(getWidth(), getHeight());
		ships = GameSeeder.getShips(getWidth(), getHeight());
		missiles = new ArrayList<Missile>();
	}

    protected final void buildAndSetGameLoop() {
        final Duration oneFrameAmt = Duration.millis(1000 / (float) getFramesPerSecond());
        final KeyFrame oneFrame = new KeyFrame(oneFrameAmt,
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(javafx.event.ActionEvent event) {

                        // update actors
                        updateSprites();

                        // check for collision
                        checkCollisions();

                        // removed dead things
                        cleanupSprites();
                    }

					private void cleanupSprites() {
						for (int i = 0; i < buildings.size(); i++) {
							if (!buildings.get(i).isAlive()) {
								buildings.remove(i);
							}
						}
						for (int i = 0; i < ships.size(); i++) {
							if (!ships.get(i).isAlive()) {
								ships.remove(i);
							}
						}
						for (int i = 0; i < missiles.size(); i++) {
							if (!missiles.get(i).isAlive()) {
								missiles.remove(i);
							}
						}					
					}

					private void checkCollisions() {
						
					}
					
					private void updateSprites() {
						for (int i = 0; i < buildings.size(); i++) {
							Building b = buildings.get(i);
							
							b.setSize(b.getSize() + 1);
						}
						
						for (int i = 0; i < ships.size(); i++) {
							Ship s = ships.get(i);
							
							s.setSize(s.getSize() + 1);
						}
						
						draw(graphicsContext);
					}
                }); // oneFrame

        
        // sets the game world's game loop (Timeline)
        setGameLoop(TimelineBuilder.create()
                .cycleCount(Animation.INDEFINITE)
                .keyFrames(oneFrame)
                .build());
        
        
    }

    protected void setGameLoop(Timeline gameLoop) {
        this.gameloop = gameLoop;
    }

	private float getFramesPerSecond() {
		// TODO Auto-generated method stub
		return 30f;
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			setupApp();
			
	        primaryStage.setTitle("Canvas Game");
	        Group root = new Group();
	        Canvas canvas = new Canvas(getWidth(), getHeight());
	        this.graphicsContext = canvas.getGraphicsContext2D();
	        draw(graphicsContext);
	        
	        root.getChildren().add(canvas);
	        
	        Scene scene = new Scene(root);

	        scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
	        	switch(key.getCode()) {
	            case ENTER:
	                System.out.println("You pressed enter");
	            	break;
	            case W:
	            	ships.get(0).setY(ships.get(0).getY() - 20);
	            	break;
	            case A:
	            	ships.get(0).setX(ships.get(0).getX() - 20);
	            	break;
	            case D:
	            	ships.get(0).setX(ships.get(0).getX() + 20);
	            	break;
	            case S:
	            	ships.get(0).setY(ships.get(0).getY() + 20);
	            	break;
	            	
	            	default:
	            		System.out.println("You pressed key: " + key.getCode());
	            }
	        });
	        
	        primaryStage.setScene(scene);
	        primaryStage.show();
//	        
//	        final Keyboard keyboard = new Keyboard(new Key(KeyCode.A),
//                    new Key(KeyCode.S),
//                    new Key(KeyCode.D),
//                    new Key(KeyCode.F));
//
//final Scene scene = new Scene(new Group(keyboard.createNode()));
//stage.setScene(scene);
//stage.setTitle("Keyboard Example");
//stage.show();
	        buildAndSetGameLoop();
	        
	        gameloop.play();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
