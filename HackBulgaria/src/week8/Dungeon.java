package week8;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 * implementing the movement and the 
 * interaction of the hero with the dungeon 
 * and with the enemies.
 * The dungeon is a String[][] and every symbol 
 * stands for a specific action.
 * @author yavor
 *
 */
public class Dungeon {
	//keeps the symbol occupied by the hero
	private String currentSymbol;
	
	//keeps the map
	private String[][] playMap;
	
	//keeps the row occupied by the hero
	private int currentRow;
	
	//keeps the column occupied by the hero
	private int currentCol;
	
	//keeps the hero of the game
	private Hero hero;
	
	//keeps an enemy that fights the hero
	private Enemy enemy;
	
	//keeps the set of the symbols of the dungeon
	private static Set<String> tokens;
	
	//keeps the set of the possible directions in the game 
	private static Set<String> directions;
	
	//keeps the set of the possible treasures in the game
	private static final String[] treasures = {"mana potion",
		                                       "health potion",
		                                       "weapon",
		                                       "spell"};
	
	
	static {
		tokens = new HashSet<String>();
		tokens.addAll(Arrays.asList("S", "G", "T", "E", "#", "."));
		
		directions = new HashSet<String>();
		directions.addAll(Arrays.asList("up", "down", "right", "left"));
	}
	
	public void setCurrentSymbol(String symbol) {
		if (symbol == null) {
			throw new IllegalArgumentException("Illegal map");
		}
		
		this.currentSymbol = symbol;
	}
	
	public void setPlayMap(String[][] map) {
		if (map == null) {
			throw new IllegalArgumentException("Illegal map");
		}
		
		this.playMap = map;
	}
	
	public void setCurrentRow(int row) {
		if (row < 0) {
			throw new IllegalArgumentException("Row cannot be negative");
		}
		
		this.currentRow = row;
	}
	
	public void setCurrentCol(int col) {
		if (col < 0) {
			throw new IllegalArgumentException("Row cannot be negative");
		}
		
		this.currentCol = col;
	}
	
	public void setHero(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Illegal hero");
		}
		
		this.hero = hero;
	}
	
	public void setEnemy(Enemy enemy) {
		if (enemy == null) {
			throw new IllegalArgumentException("Enemy cannot be null.");
		}
		
		this.enemy = enemy;
	}
	
	public String getCurrentSymbol() {
		if (this.currentSymbol == null) {
			throw new NullPointerException();
		}
		
		return this.currentSymbol;
	}
	
	public String[][] getPlayMap() {
		if (this.playMap == null) {
			throw new NullPointerException();
		}
		
		return this.playMap;
	}
	
	public int getCurrentRow() {
		return this.currentRow;
	}
	
	public int getCurrentCol() {
		return this.currentCol;
	}
	
	public Hero getHero() {
		if (this.hero == null) {
			throw new NullPointerException("Set hero");
		}
		
		return this.hero;
	}
	
	public Enemy getEnemy() {
		if (this.enemy == null) {
			throw new NullPointerException("Initilize enemy.");
		}
		
		return this.enemy;
	}
		
	public Dungeon(String[][] map) {
		setCurrentSymbol(map[0][0]);
		setPlayMap(map);
		setCurrentRow(0);
		setCurrentCol(0);
	}
	
	public static String[][] readMap() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter row number: ");
		int rowNumber = input.nextInt();
		
		System.out.print("Enter column number: ");
		int colNumber = input.nextInt();
		
		System.out.println("Enter the map: ");
		
		String[][] map = new String[rowNumber][colNumber];
		
		for (int row = 0; row < rowNumber; row++) {
			String line = input.next();
			
			for (int col = 0; col < colNumber; col++) {
				map[row][col] = Character.toString(line.charAt(col));
			}
			
			input.nextLine();
		}
		System.out.println();
		
		return map;
	}
	
	public void printMap() {
		String[][] map = getPlayMap();
		int rowNumber = map.length;
		int colNumber = map[0].length;
		
		for (int row = 0; row < rowNumber; row++) {
			for (int col = 0; col < colNumber; col++) {
				String element = map[row][col];
				System.out.printf("%s", element);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	private void validateSymbol(String symbol) {
		if (!tokens.contains(symbol)) {
			throw new IllegalArgumentException("Illegal Symbol");
		}
	}
	
	private void validatePosition(int currentRow, int currentCol) {
		if (currentRow < 0 && currentRow > getPlayMap().length - 1) {
			throw new IllegalArgumentException("Illegal row");
		}
		
		if (currentCol < 0 && currentCol > getPlayMap()[0].length - 1) {
			throw new IllegalArgumentException("Illegal column");
		}
		
	}
	/**
	 * finds the specified symbol on the map
	 * @param symbol - searched symbol
	 * @param currentRow - start row
	 * @param currentCol - start column
	 * @return - HashMap with keys (row, col) and values 
	 */
	private Map<String, Integer> findSymbol(String symbol, 
			                                int currentRow,
										    int currentCol) {
		validateSymbol(symbol);
		validatePosition(currentRow, currentCol);
		
		Map<String, Integer> position = new HashMap<String, Integer>();
		position.put("row", -1);
		position.put("col", -1);
		
		for (int row = currentRow; row < getPlayMap().length;row++) {
			for (int col = currentCol; col < getPlayMap()[0].length; col++) {
				if (getPlayMap()[row][col].equalsIgnoreCase("S")) {
					position.put("row", currentRow);
					position.put("col", currentCol);
					
					return position;
				}
			}
		}
		
		return position;
	}
	
	public boolean spawn(Hero hero) {
		if (hero == null) {
			throw new IllegalArgumentException("Hero cannot be null");
		}
		
		setHero(hero);
		
		Map<String, Integer> spawnPosition = findSymbol("S", currentRow, currentCol);
		int spawnRow = spawnPosition.get("row");
		int spawnCol = spawnPosition.get("col");
		
		if ((spawnRow == -1) && (spawnCol == -1)) {
			System.out.println("Game Over!");
			return false;
		}
		
		getPlayMap()[spawnRow][spawnCol] = "H";
		
		return true;
	}
	
	/**
	 * validate if the input direction 
	 * is up, down, right or left
	 * @param direction - input direction of the hero.
	 */
	private void validateDirection(String direction) {
		if (!directions.contains(direction.toLowerCase())) {
			throw new IllegalArgumentException("Illegal direction");
		}
		
	}
	
	private boolean canMoveRight() {
		return getCurrentCol() <= getPlayMap()[0].length - 2;
	}
	
	private boolean canMoveLeft() {
		return getCurrentCol() >= 1; 
	}
	
	private boolean canMoveUp() {
		return getCurrentRow() >= 1;
	}
	
	private boolean canMoveDown() {
		return getCurrentRow() <= getPlayMap().length - 2;
	}

	private void goRight() {
		int row = getCurrentRow();
		int col = getCurrentCol();
		
		if (getPlayMap()[row][col + 1].equals("#")) {
			String heroName = getHero().getName();
			System.out.printf("%s stepped on obstacle. " +
					"Find another way to the gate of Moria.%n", heroName);
			return;
		}
		
		//the occupied symbol by the hero before he makes the move
		String swapper = getCurrentSymbol();
		
		setCurrentSymbol(getPlayMap()[row][col + 1]);
		
		if (getCurrentSymbol().equals("G")) {
			//load new level
		}
		
		processToken(getCurrentSymbol());
		
		//if occupied symbol is not "S" - put a "."
		if (!swapper.equals("S")) {
				getPlayMap()[row][col] = ".";
				
		} else {
			getPlayMap()[row][col] = "S";
		}	
		
		getPlayMap()[row][col + 1] = "H";
		
		setCurrentCol(col + 1);
		
	}
	
	private void goLeft() {
		int row = getCurrentRow();
		int col = getCurrentCol();
		
		if (getPlayMap()[row][col - 1].equals("#")) {
			String heroName = getHero().getName();
			System.out.printf("%s stepped on obstacle. " +
					"Find another way to the gate of Moria.%n", heroName);
			return;
		}
		
		//the occupied symbol by the hero before he makes the move
		String swapper = getCurrentSymbol();
		
		setCurrentSymbol(getPlayMap()[row][col - 1]);
		
		if (getCurrentSymbol().equals("G")) {
			//load new level
		}
		
		processToken(getCurrentSymbol());
		
		//if occupied symbol is not "S" - put a "."
		if (!swapper.equals("S")) {
			getPlayMap()[row][col] = ".";
			
		} else {
			getPlayMap()[row][col] = "S";
		}		
		
		getPlayMap()[row][col - 1] = "H";
		
		setCurrentCol(col - 1);
	}
	
	private void goUp() {
		int row = getCurrentRow();
		int col = getCurrentCol();
		
		if (getPlayMap()[row - 1][col].equals("#")) {
			String heroName = getHero().getName();
			System.out.printf("%s stepped on obstacle. " +
					"Find another way to the gate of Moria.%n", heroName);
			return;
		}
		
		//the occupied symbol by the hero before he makes the move
		String swapper = getCurrentSymbol();
		
		setCurrentSymbol(getPlayMap()[row - 1][col]);
		
		if (getCurrentSymbol().equals("G")) {
			//load new level
		}
		
		processToken(getCurrentSymbol());
		
		//if occupied symbol is not "S" - put a "."
			if (!swapper.equals("S")) {
					getPlayMap()[row][col] = ".";
					
			} else {
				getPlayMap()[row][col] = "S";
			}		
		
		getPlayMap()[row - 1][col] = "H";
		
		setCurrentRow(row - 1);

	}
	
	private void goDown() {
		int row = getCurrentRow();
		int col = getCurrentCol();
		
		if (getPlayMap()[row + 1][col].equals("#")) {
			String heroName = getHero().getName();
			System.out.printf("%s stepped on obstacle. " +
					"Find another way to the gate of Moria.%n", heroName);
			return;
		}
		
		//the occupied symbol by the hero before he makes the move
		String swapper = getCurrentSymbol();
		
		setCurrentSymbol(getPlayMap()[row + 1][col]);
		
		if (getCurrentSymbol().equals("G")) {
			//load new level
		}
		
		processToken(getCurrentSymbol());
		
		//if occupied symbol is not "S" - put a "."
		if (!swapper.equals("S")) {
				getPlayMap()[row][col] = ".";
				
		} else {
			getPlayMap()[row][col] = "S";
		}	
		
		getPlayMap()[row + 1][col] = "H";
		
		setCurrentRow(row + 1);

	}
	
	/**
	 * Getting current symbol and decide what to do 
	 * depending of the symbol
	 * @param currentSymbol
	 */
	private void processToken(String currentSymbol) {
		
		//if symbol = 'E' - start a fight
		if (moveOnEnemy(currentSymbol)) {
			fight();
		
		//if symbol = 'T' - pick a random treasure	
		} else if (moveOnTreasure(currentSymbol)) {
			pickTreasure();
		}
	}
	
	/**
	 * picking a random treasure between mana, health,
	 * weapon or spell.
	 */
	private void pickTreasure() {
		int min = 0;
		int max = treasures.length;
		int rnd = ThreadLocalRandom.current().nextInt(min, max);
		
		String treasure = treasures[rnd];
		
		String heroName = getHero().getName();
		
		if (treasure.equals("mana potion")) {
			getHero().setMana(getHero().getMaxMana());
			System.out.printf("Found mana potion. " +
					"%s mana is at max.%n", heroName);
			
		} else if (treasure.equals("health potion")) {
			getHero().setHealth(getHero().getMaxHealth());
			System.out.printf("Found health potion. " +
					"%s health is at max.%n", heroName);
			
		} else if (treasure.equals("weapon")) {
			getHero().equip(Weapon.getRandomWeapon());
			String weaponName = getHero().getWeapon().getName();
			System.out.printf("Found weapon!" +
					" %s is equiped with %s.%n",heroName, weaponName);
			
		} else if (treasure.equals("spell")) {
			getHero().learn(Spell.getRandomSpell());
			String spellName = getHero().getSpell().getName();
			System.out.printf("Found spell! " +
					"%s learned %s.%n",heroName, spellName);
		}
		
	}
	
	private boolean moveOnTreasure(String symbol) {
		return symbol.equalsIgnoreCase("T");
	}
	
	private boolean moveOnEnemy(String symbol) {
		return symbol.equalsIgnoreCase("E");
	}
	
	/**
	 * Moving the hero on the map
	 * @param direction - input direction
	 */
	public void moveHero(String direction) {
		validateDirection(direction);
		direction = direction.toLowerCase();
		
		String heroName = getHero().getName();
		
		if (direction.equals("right")) {
			if (canMoveRight()) {
				goRight();
				
			} else {
				System.out.printf("%s can' t move right. Take another " +
						"direction to the gate of Moria.%n", heroName);
			}
			
		} else if (direction.equals("left")) {
			if (canMoveLeft()) {
				goLeft();
				
			} else {
				System.out.printf("%s can' t move left. Take another " +
						"direction to the gate of Moria.%n", heroName);
			}
			
		} else if (direction.equals("up")) {
			if (canMoveUp()) {
				goUp();
				
			} else {
				System.out.printf("%s can' t move up. Take another " +
						"direction to the gate of Moria.%n", heroName);
			}
			
		} else if (direction.equals("down")) {
			if (canMoveDown()) {
				goDown();
				
			} else {
				System.out.printf("%s can' t move down. Take another " +
						"direction to the gate of Moria.%n", heroName);
			} 
		}
		
		printMap();
	}
	
	
	public void heroAttack(String item) {
		if (isNotWeaponOrSpell(item)) {
			throw new IllegalArgumentException("Hero can only attack " +
					"with weapon or spell.");
		}
		setEnemy(Enemy.getRandomEnemy());
		Enemy enemy = getEnemy();
		Hero hero = getHero();
		
		if (item.equalsIgnoreCase("weapon")) {
			if (getCurrentSymbol().equals("E")) {
				enemy.takeDamage(hero.attack("weapon"));
				
			} System.out.println("Have to move on enemy to " +
					"fight him wiht weapon.");
			
		} else if (item.equalsIgnoreCase("spell")) {
			if (enemyIsInRange()) {
				Fight fight = new Fight(hero, enemy);
				this.fight();
				
			} else {
				int range = hero.getSpell().getCastRange();
				System.out.printf("There is no enemy in casting range" +
						" %d%n", range);
			}
		}
	}
	
	private boolean enemyIsInRange() {
		int startRow = getCurrentRow();
		int endRow = getEndRow();
		
		int startCol = getCurrentCol();
		int endCol = getEndCol();
		
		String[][] map = getPlayMap();
		
		for (int row = startRow; row <= endRow; row++) {
			for (int col = startCol; col <= endCol; col++) {
				if (map[row][col].equals("E")) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private int getEndCol() {
		int spellRange = getHero().getSpell().getCastRange();
		
		int startCol = getCurrentCol();
		int endCol = startCol + spellRange;
		
		if (endCol > getPlayMap()[0].length - 1) {
			endCol = getPlayMap()[0].length - 1;
		}
		
		return endCol;
	}
	
	private int getEndRow() {
		int spellRange = getHero().getSpell().getCastRange();
		int startRow = getCurrentRow();
		
		int endRow = startRow + spellRange;
		
		if (endRow > getPlayMap().length - 1) {
			endRow = getPlayMap().length - 1;
		}
		
		return endRow;
	}
	
	private boolean isNotWeaponOrSpell(String item) {
		return (!item.equalsIgnoreCase("weapon") && 
				!item.equalsIgnoreCase("spell"));
	}
	
	public void fight() {
		Enemy enemy = Enemy.getRandomEnemy();
		Fight fight = new Fight(getHero(), enemy);
		fight.startFight();
	}
	
	private String chooseItem() {
		Scanner input = new Scanner(System.in);
		System.out.print("You just encountered an enemy! Choose how to " +
				"attack him!");
		String item = input.next();
		return item;
	}
	
	
}
