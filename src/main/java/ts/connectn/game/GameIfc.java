package ts.connectn.game;

import ts.connectn.Chip;
import ts.connectn.GameResult;

/**
 * 
 * DESCRIPCIÓN
 *  
 * Conecta 4 (Tambien conocido como "4 en raya") es un juego en el que el objetivo es ser el primero en hacer una línea de cuatro fichas consecutivas. 
 * 
 * En nuestro caso hemos modificado el juego pasando a ser "Conecta N", consistente en conectar N fichas consecutivas en vez de cuatro. El resto de las reglas se mantienen igual.
 * 
 * 
 * REGLAS
 * 
 * El juego se desarrolla en un tablero de X filas por Y columnas en posición vertical.
 * Los jugadores se turnan para echar sus fichas en las columnas que no esten completas. 
 * Las fichas ocuparán la posición mas baja de la columna cada vez. 
 * El jugador gana cuando consigue colocar N de sus fichas en linea (Horizontal, vertical o diagonal), con lo que acaba el juego. 
 * Hay empate si las columnas se llenan de fichas, pero ninguno ha conseguido ganar. 
 *
 */
public interface GameIfc {
	
	/**
	 * 
	 * @param chip type of chip
	 * @param column the column where the player introduces the chip
	 */
	public void putChip(Chip chip, int column);
	
	/**
	 * Checks the result of the game, basically if we have a winner or not 
	 * 
	 * @return GameResult including all the parameters that describe the result
	 */
	public GameResult checkGameResult();
	
}
