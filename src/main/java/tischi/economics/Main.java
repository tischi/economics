package tischi.economics;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main( String[] args )
	{
		final List<Player> players = initPlayers();

		playGame(players);

		displayResults(players);
	}

	public static List<Player> initPlayers() {
		final List< Player > players = new ArrayList<>();
		players.add( new Player( 100, "Bob" ));
		players.add( new Player( 100, "Alice"));
		players.add( new Player( 100, "Fred"));
		players.add( new Player( 100, "Hans"));
		return players;
	}

	public static void playGame(List<Player> players) {
		final Game game = new Game( players, 0.2 );

		for (int i = 1; i < 1000; i++) {
			game.step();
		}
	}

	public static void displayResults(List<Player> players) {
		// Create Chart
		XYChart chart = new XYChartBuilder().width(1200).height(500).title("Captial").xAxisTitle("T").yAxisTitle("C").build();

		// Customize Chart
		chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
		chart.getStyler().setChartTitleVisible(true);
		chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
		//chart.getStyler().setMarkerSize(16);

		for ( Player player : players ) {
			chart.addSeries(player.getName(), getTime(player), player.getHistory());
		}

		new SwingWrapper(chart).displayChart();
	}

	public static ArrayList<Integer> getTime(Player player) {
		final ArrayList<Integer> time = new ArrayList<>();
		final int size = player.getHistory().size();
		for (int i = 0; i < size; i++) {
			time.add( i );
		}
		return time;
	}

}
