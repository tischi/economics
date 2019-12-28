package tischi.economics;

import java.util.ArrayList;

public class Player
{
	private double capital;
	private final String name;
	private ArrayList< Double > history;

	public Player( double capital, String name )
	{
		this.capital = capital;
		this.name = name;
		history = new ArrayList<>();
		history.add( capital );
	}

	public double getCapital()
	{
		return capital;
	}

	public void increaseCapital(double stake) {
		capital += stake;
		history.add( capital );
	}

	public void decreaseCapital(double stake) {
		capital -= stake;
		history.add( capital );
	}

	public ArrayList<Double> getHistory() {
		return history;
	}

	public String getName() {
		return name;
	}
}
