package backend.board;

import java.util.ArrayList;
import java.util.List;

import backend.Utilities.vectors.Vector;
import backend.Utilities.vectors.VectorMath;
import backend.board.interfacemovement.MoveInterface;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.ImageView;

/**
 * 
 * @author Jarod Cahoon
 *
 */
public class Turtle extends ConcreteObject {
		public static final double STARTING_ANGLE = 90;
		public static final double[] STARTING_POSITION = {0,0};
		private String myImagePath;
		private DoubleProperty myXPos;
		private DoubleProperty myYPos;
		private DoubleProperty myAngle;
		private BooleanProperty myPenDown;
		private BooleanProperty myOpacity;
		private IntegerProperty myTurtleId;
		private RenderSprite myObserver;

		// https://stackoverflow.com/questions/23335522/how-do-i-write-a-new-listchangelisteneritem-with-lambda
		public Turtle(String imagePath, int id, RenderSprite ob) {
			myObserver = ob;
			myXPos.set(STARTING_POSITION[0]);
			myYPos.set(STARTING_POSITION[1]);
			myAngle.set(STARTING_ANGLE);
			myTurtleId.set(id);
			myPenDown.set(true);
			myOpacity.set(true);

			myXPos.addListener( (obs, oldVal, newVal) -> myObserver.changeX(obs, oldVal, newVal));
			myYPos.addListener( (obs, oldVal, newVal) -> myObserver.changeY(obs, oldVal, newVal));
			myAngle.addListener( (obs, oldVal, newVal) -> myObserver.changeAngle(obs, oldVal, newVal) );
			myTurtleId.addListener((obs, oldVal, newVal) -> myObserver.changeId(obs, oldVal, newVal) );
			myPenDown.addListener((obs, oldVal, newVal) -> myObserver.changePen(obs, oldVal, newVal) );
			myOpacity.addListener((obs, oldVal, newVal) -> myObserver.changeOpacity(obs, oldVal, newVal) );
		}
		
		public double Act(MoveInterface m){
			return m.act(this);
		}
		
		/////Keeep this stuff below, get rid of the stuff above
		@Override
		public RenderSprite getRenderSprite() {
			return new RenderSprite(myTurtleId.get(), myImagePath, 0.0, 0.0);
		}
		
		@Override
		public int getId() {
			return myTurtleId.get();
		}
		
		public DoubleProperty getMyX() {
			return this.myXPos;
		}
		
		public DoubleProperty getMyY() {
			return this.myYPos;
		}
		
		public DoubleProperty getAngle() {
			return this.myAngle;
		}
		
		public BooleanProperty getPen() {
			return myPenDown;
		}
		
		public BooleanProperty getOpacity() {
			return myOpacity;
		}
		
		public IntegerProperty getID() {
			return myTurtleId;
		}

}
