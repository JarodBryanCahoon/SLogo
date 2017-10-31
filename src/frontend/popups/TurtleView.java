package frontend.popups;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import backend.board.RenderSprite;
import exceptions.ErrorMessage;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class TurtleView {
	public enum METHODS {
		ID("setId"),
		X("setX"),
		Y("setY"),
		PEN("setPenDown"),
		VISIBLE("setVisible"),
		ANGLE("setAngle");
		
		private String myName;
		METHODS(String name) {
			myName = name;
		}
		
		public String getMethod() {
			return myName;
		}
	}
	
	private static final Map<String, String> headers = new HashMap<String, String>() {{
		put(METHODS.ID.getMethod(), "ID");
		put(METHODS.X.getMethod(), "X Position");
		put(METHODS.Y.getMethod(), "Y Position");
		put(METHODS.PEN.getMethod(), "Pen Down");
		put(METHODS.VISIBLE.getMethod(), "Turtle Visibility");
		put(METHODS.ANGLE.getMethod(), "Angle");
	}};
	
	private static final Map<String, Class<?>> ARG_TYPE = new HashMap<String, Class<?>>() {{
		put(METHODS.X.getMethod(), double.class);
		put(METHODS.Y.getMethod(), double.class);
		put(METHODS.PEN.getMethod(), boolean.class);
		put(METHODS.VISIBLE.getMethod(), boolean.class);
		put(METHODS.ANGLE.getMethod(), double.class);
	}};
	
	public TurtleView(RenderSprite rs) {
		PopUp myPop = new PopUp(createViewBox(rs), "Turtle View");
	}
	
	private VBox createViewBox(RenderSprite rs) {
		VBox parent = new VBox();
		
		parent.getChildren().add(createSubBox(METHODS.ID.getMethod(), Integer.toString(rs.getId()), rs));
		parent.getChildren().add(createSubBox(METHODS.X.getMethod(), Double.toString(rs.getX()), rs));
		parent.getChildren().add(createSubBox(METHODS.Y.getMethod(), Double.toString(rs.getY()), rs));
		parent.getChildren().add(createSubBox(METHODS.PEN.getMethod(), Boolean.toString(rs.isPenDown()), rs));
		parent.getChildren().add(createSubBox(METHODS.VISIBLE.getMethod(), Boolean.toString(rs.isVisible()), rs));
		parent.getChildren().add(createSubBox(METHODS.ANGLE.getMethod(), Double.toString(rs.getAngle()), rs));
		return parent;
	}
	
	private HBox createSubBox(String method, String value, RenderSprite rs) {
		HBox hBox = new HBox();
		TextField head = new TextField(headers.get(method));
		head.setDisable(true);
		TextField paramValue = new TextField(value);
		if(method.equals(METHODS.ID.getMethod())) {
			paramValue.setDisable(true);
		} else {
			paramValue.setOnKeyPressed(e -> readValue(method, paramValue, rs, e.getCode()));
		}
		
		hBox.getChildren().addAll(head, paramValue);
		return hBox;
	}
	
	private void readValue(String method, TextField paramValue, RenderSprite rs, KeyCode code) {
		if(code.equals(KeyCode.ENTER)) {
			Method setMethod = null;
			try {
				setMethod = rs.getClass().getDeclaredMethod(method, ARG_TYPE.get(method));
			} catch (NoSuchMethodException | SecurityException e) {
				ErrorMessage eMessage = new ErrorMessage("No such method found");
				eMessage.show();
				return;
			}
			
			try {
				if(ARG_TYPE.get(method).equals(double.class)) {
					double value = Double.parseDouble(paramValue.getText());
					setMethod.invoke(rs, value);
				} else {
					boolean value = Boolean.parseBoolean(paramValue.getText());
					setMethod.invoke(rs, value);
				}
			} catch (Exception e) {
				ErrorMessage eMessage = new ErrorMessage("That value is invalid");
				eMessage.show();
			}
		}
	}
}
