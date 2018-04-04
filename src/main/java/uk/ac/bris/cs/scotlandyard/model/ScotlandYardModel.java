package uk.ac.bris.cs.scotlandyard.model;

import static java.util.Arrays.asList;
import static java.util.Collections.emptySet;
import static java.util.Collections.singletonList;
import static java.util.Collections.unmodifiableCollection;
import static java.util.Collections.unmodifiableList;
import static java.util.Collections.unmodifiableSet;
import static java.util.Objects.requireNonNull;
import static uk.ac.bris.cs.scotlandyard.model.Colour.BLACK;
import static uk.ac.bris.cs.scotlandyard.model.Ticket.DOUBLE;
import static uk.ac.bris.cs.scotlandyard.model.Ticket.SECRET;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import uk.ac.bris.cs.gamekit.graph.Edge;
import uk.ac.bris.cs.gamekit.graph.Graph;
import uk.ac.bris.cs.gamekit.graph.ImmutableGraph;


// TODO implement all methods and pass all tests
public class ScotlandYardModel implements ScotlandYardGame {

	List<Boolean> rounds;
	Graph<Integer, Transport> graph;
	List<ScotlandYardPlayer> players = new ArrayList<>();



	public ScotlandYardModel(List<Boolean> rounds, Graph<Integer, Transport> graph,
			PlayerConfiguration mrX, PlayerConfiguration firstDetective,
			PlayerConfiguration... restOfTheDetectives) {

		this.rounds = requireNonNull(rounds);
		if (rounds.isEmpty()) {
    throw new IllegalArgumentException("Empty rounds");
	}

		this.graph = requireNonNull(graph);
		if (graph.isEmpty()) {
		throw new IllegalArgumentException("Empty Graph");
	}

	if (mrX.colour != BLACK) { // or mr.colour.isDetective()
    throw new IllegalArgumentException("MrX should be Black");
	}

	ArrayList<PlayerConfiguration> configurations = new ArrayList<>();
	for (PlayerConfiguration configuration : restOfTheDetectives){
    configurations.add(requireNonNull(configuration));
		configurations.add(0, firstDetective);
		configurations.add(0, mrX);
	}

	Set<Integer> set = new HashSet<>();
		for (PlayerConfiguration configuration : configurations) {
			if (set.contains(configuration.location))
					throw new IllegalArgumentException("Duplicate location");
			set.add(configuration.location);
			}


//checking duplicate colours
	Set<Colour> setC = new HashSet<>();
		for (PlayerConfiguration configuration : configurations){
			if (setC.contains(configuration.colour))
					throw new IllegalArgumentException("Duplicate colour");
		setC.add(configuration.colour);
	}


	//check for all players having maps to valid tickets
					 for (PlayerConfiguration configuration : configurations) {

							 if(!configuration.tickets.containsKey(Double))
									 throw new IllegalArgumentException("Player missing Double ticket");
							 if(!configuration.tickets.containsKey(Secret))
									 throw new IllegalArgumentException("Player missing Secret ticket");
							 if(!configuration.tickets.containsKey(Bus))
									 throw new IllegalArgumentException("Player missing Bus ticket");
							 if(!configuration.tickets.containsKey(Taxi))
									 throw new IllegalArgumentException("Player missing Taxi ticket");
							 if(!configuration.tickets.containsKey(Underground))
									 throw new IllegalArgumentException("Player missing Underground ticket");
					 }

					 //test that detectives dont have secret or double tickets
					 for (PlayerConfiguration configuration : restOfTheDetectives) {

							 if(!(configuration.tickets.get(Double)==0))
									 throw new IllegalArgumentException("Detective has Double ticket");
							 if(!(configuration.tickets.get(Secret)==0))
									 throw new IllegalArgumentException("Detective has Secret ticket");

					 }

					 if(!(firstDetective.tickets.get(Double)==0))
							 throw new IllegalArgumentException("First Detective has Double ticket");
					 if(!(firstDetective.tickets.get(Secret)==0))
							 throw new IllegalArgumentException("First Detective has Secret ticket");


					 //adding players to the players list
					 for (PlayerConfiguration configuration : configurations){
							 players.add( new ScotlandYardPlayer(configuration.player, configuration.colour, configuration.location, configuration.tickets));
					 }

					 currentPlayer = Black;
					 currentRound = 0;
					 mrXlocation = 0;




	}


	@Override
	public void registerSpectator(Spectator spectator) {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public void unregisterSpectator(Spectator spectator) {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public void startRotate() {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public Collection<Spectator> getSpectators() {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public List<Colour> getPlayers() {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public Set<Colour> getWinningPlayers() {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public Optional<Integer> getPlayerLocation(Colour colour) {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public Optional<Integer> getPlayerTickets(Colour colour, Ticket ticket) {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public boolean isGameOver() {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public Colour getCurrentPlayer() {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public int getCurrentRound() {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public List<Boolean> getRounds() {
		// TODO
		throw new RuntimeException("Implement me");
	}

	@Override
	public Graph<Integer, Transport> getGraph() {
		// TODO
		throw new RuntimeException("Implement me");
	}

}
