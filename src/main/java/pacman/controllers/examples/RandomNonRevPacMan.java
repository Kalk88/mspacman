package main.java.pacman.controllers.examples;

import java.util.Random;
import main.java.pacman.controllers.Controller;
import main.java.pacman.game.Game;

import static main.java.pacman.game.Constants.*;

/*
 * The Class RandomNonRevPacMan.
 */
public final class RandomNonRevPacMan extends Controller<MOVE>
{	
	Random rnd=new Random();
	
	/* (non-Javadoc)
	 * @see pacman.controllers.Controller#getMove(pacman.game.Game, long)
	 */
	public MOVE getMove(Game game,long timeDue)
	{			
		MOVE[] possibleMoves=game.getPossibleMoves(game.getPacmanCurrentNodeIndex(),game.getPacmanLastMoveMade());		//set flag as false to prevent reversals	
		
		return possibleMoves[rnd.nextInt(possibleMoves.length)];
	}
}