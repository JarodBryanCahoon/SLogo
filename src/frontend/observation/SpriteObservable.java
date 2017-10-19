package frontend.observation;

import java.util.Observable;

public abstract class SpriteObservable extends Observable{
	public void clearChanged() {
		super.clearChanged();
	}
}
