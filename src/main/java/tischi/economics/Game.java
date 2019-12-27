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

	public Game(List< Player > players, double stakeFraction)
	{
		this.players = players;
		this.size = players.size();
		this.stakeFraction = stakeFraction;
	}

	public void step()
	{
		setPlayers();

		final double stake;

		if ( playerA.getCapital() > playerB.getCapital() )
		{
			stake = playerB.getCapital() * stakeFraction;
		}
		else
		{
			stake = playerA.getCapital() * stakeFraction;
		}

		final Random random = new Random();

		random.nextBoolean();

	}

	private void setPlayers() {
		final Random random = new Random();
		int index = random.nextInt(size);
		playerA = players.get(index);

		while( true ) {
			final int nextInt = random.nextInt(size);
			if (nextInt != index)
				playerB = players.get(nextInt);
		}
	}
}
