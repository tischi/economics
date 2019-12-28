package tischi.economics;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main( String[] args )
	{
		final List< Player > players = new ArrayList<>();
		players.add( new Player( 100, "Bob" ));
		players.add( new Player( 100, "Alice"));

		final Game game = new Game( players, 0.2 );

		final ArrayList<Integer> steps = Util.makeSteps(100);

		for (int i = 1; i < steps.size(); i++) {
			game.step();
		}

		// Create Chart
		XYChart chart = new XYChartBuilder().width(600).height(500).title("Captial").xAxisTitle("T").yAxisTitle("C").build();

		// Customize Chart
		chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
		chart.getStyler().setChartTitleVisible(true);
		chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
		//chart.getStyler().setMarkerSize(16);

		for ( Player player : players ) {
			chart.addSeries(player.getName(), steps, player.getHistory());
		}

		new SwingWrapper(chart).displayChart();
	}

}
