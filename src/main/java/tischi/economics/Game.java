package tischi.economics;

import net.imglib2.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Game
{
	private final List< Player > players;
	private final int size;
	private final double stakeFraction;

	private Player playerA;
	private Player playerB;
	private Random random;

	public Game(List< Player > players, double stakeFraction)
	{
		this.players = players;
		this.size = players.size();
		this.stakeFraction = stakeFraction;
		random = new Random();
	}

	public void step()
	{
		setPlayers();
		play(getStake());
	}

	private void play(double stake) {
		if( random.nextBoolean() ){
			playerA.increaseCapital( stake );
			playerB.decreaseCapital( stake );
		}
		else
		{
			playerB.increaseCapital( stake );
			playerA.decreaseCapital( stake );
		}
		//log(stake);
	}

	private void log(double stake) {
		System.out.println("Stake: " + stake);
		System.out.println("PlayerA: " + playerA.getCapital());
		System.out.println("PlayerB: " + playerB.getCapital());
	}

	private double getStake() {
		final double stake;

		if ( playerA.getCapital() < playerB.getCapital() )
			stake = playerA.getCapital() * stakeFraction;
		else
			stake = playerB.getCapital() * stakeFraction;

		return stake;
	}

	private void setPlayers() {
		int index = random.nextInt(size);
		playerA = players.get(index);

		while( true ) {
			final int nextInt = random.nextInt(size);
			if (nextInt != index) {
				playerB = players.get(nextInt);
				break;
			}
		}
	}
}
