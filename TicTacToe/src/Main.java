import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
	//get user input
		Scanner userInput = new Scanner(System.in);
	//create board
		char [][] board = new char[3][3];
	//current player
		char player='x';
	//number of moves
		int movesLeft = 9;
	//holds the row and col of move
		int [] playerMove = new int[2];
		boolean isValid = false;
		intializeArray(board);
		
	
	  while(true) {
		while(isValid == false) {
			  System.out.println("Player " + player + " turn, please enter coordinates");
			  playerMove[0] = userInput.nextInt();
			  playerMove[1] = userInput.nextInt();
			  isValid = validMove(board,playerMove,player);
			  if(isValid == false)
				  System.out.println("Invalid Input please try again");
		  }
	//decrement amount of moves left
		  movesLeft--;
	//display board
		  printBoard(board);
		
	//if we have a winner break out of loop
		if(hasWinner(board, player)) {
			userInput.close();
			break;
		}
		
	//reset flag
			isValid = false;
	//toggle between players
			player = changePlayer(player);
		
	//rest the game if no moves remaining
		if(movesLeft == 0) {
			movesLeft = 9;
			intializeArray(board);
			player = 'x';
			System.out.println("Restarting game no winner");
		}
	  }
	 System.out.println("winner is player " + player);
}
	

	
	// toggle player to switch turns
	    public static char changePlayer(char player) {
		  if(player == 'x')
			  return 'o';
		  return 'x';
	  }
	  
	// check to see if the move is valid if it is execute users move
	    public static boolean validMove(char [][] board, int [] playerMove,char player) {
		  if(playerMove[0] >= 0 && playerMove[0] <=2 &&
			playerMove[1] >= 0 && playerMove[1] <=2	) {
			  if(board[playerMove[0]][playerMove[1]] == '0') {
				  board[playerMove[0]][playerMove[1]] = player;
				  return true;
			  }
		  }
		 return false;
	  }
	
	//Intialize tic tac toe board to o's
		private static void intializeArray(char[][] board) {
		for(int i =0; i < board.length;i++) {
			for(int j =0; j < board[i].length;j++) {
				board[i][j] = '0';
			}
		}
	}
	//print tic tac toe board out
		public static void printBoard(char [][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	//checks to see if there is a winner
		public static boolean hasWinner(char[][] board, char player) {
	
			if(board[0][0] == player && board[1][0] == player && board[2][0] == player)
				return true;
			else if(board[0][1] == player && board[1][1] == player && board[2][1] == player)
				return true;
			else if(board[0][2] == player && board[1][2] == player && board[2][2] == player)
				return true;
			else if(board[0][0] == player && board[0][1] == player && board[0][2] == player)
				return true;
			else if(board[1][0] == player && board[1][1] == player && board[1][2] == player)
				return true;
			else if(board[2][0] == player && board[2][1] == player && board[2][2] == player)
				return true;
			else if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
				return true;
			else if(board[2][0] == player && board[1][1] == player && board[0][2] == player)
				return true;
			else 
				return false;
		}
	
	
	
	}
		



