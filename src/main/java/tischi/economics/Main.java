package tischi.economics;

import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main( String[] args )
	{
		final List< Player > players = new ArrayList<>();
		players.add( new Player( 100 ) );

		final Game game = new Game( players );

	}
}
