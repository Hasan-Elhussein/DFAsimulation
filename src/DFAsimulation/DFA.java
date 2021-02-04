package DFAsimulation;

import java.util.Scanner;

public class DFA {
	
	
	public static void printTransactionTable(String[][] transactionTable) {
		
		System.out.println("\nTransaction table:\n");
		
		for(int i = 0; i < transactionTable.length; i++) {
			for(int j = 0; j < transactionTable[0].length; j++) {
				if(i==0 && j==0) {
					j++;
					for(int k = 0; k <= transactionTable[1][0].length(); k ++)
						System.out.print(" ");
					System.out.print("| ");
				}
				System.out.print(transactionTable[i][j] + " | ");
			}
			System.out.println();
			for(int k = 0; k < transactionTable[0].length; k++)
				System.out.print("-----");
			System.out.println();
		}
	}
	
	
	public static String[][] getTransactionTableFromUser(){
		
		Scanner scanner = new Scanner(System.in);
		String[][] transactionTable = null;
		
		int nodeNum = 0;
		int stateNum = 0;
		
		System.out.println("please enter the Table's Height (node number):");
		nodeNum = scanner.nextInt();
		System.out.println("Please enter the table's Width (state number):");
		stateNum = scanner.nextInt();
		
		transactionTable = new String[nodeNum][stateNum];
		
		System.out.println("Please enter the Transaction table: (row by row!)");
		for(int i = 0; i < nodeNum; i++) {
			for(int j = 0; j < stateNum; j++) {
				if(i==0 && j==0) {
					j++;
					transactionTable[0][0] = " ";
				}
					
				transactionTable[i][j] = scanner.next();
			}
			System.out.println("-----------------------------------");
		}
		
		//scanner.close();
		return transactionTable;
	}
	
	
	public static boolean checkNode(String[][] table, String node) {
		
		boolean check = false;
		
		for(int i = 0; i < table.length; i++) {
			if(table[i][0].equals(node)) {
				check = true;
				break;
			}
			if((i+1) == table.length && check == false) {
				System.out.println("The state you entered is not available in the table!");
			}
		}
		
		return check;
	}
	
	
	public static boolean checkWord(String[][] table, String word) {
		
		boolean masterCheck = true;
		
		for(int index = 0; index < word.length(); index++) {
			
			boolean check = false;
			String state = Character.toString(word.charAt(index));
			
			for(int i = 0; i < table[0].length; i++) {
				if(table[0][i].equals(state)) {
					check = true;
					break;
				}
				if((i+1) == table[0].length && check == false) {
					System.out.println("Invalid word!  ,  Error at: " + state);
					masterCheck = false;
				}
			}
			
		}
		
		return masterCheck;
	}
	
	
	public static boolean simulate(String[][] transactionTable,String startingState, String[] acceptStates,int acceptStatesCount, String word) {
		
		
		for(int index = 0; index < word.length(); index++) {
			String currentState = Character.toString(word.charAt(index));
			startingState = transactionTable[getIndexOfNode(transactionTable, startingState)][getIndexOfState(transactionTable, currentState)];
		}
		
		for(int i = 0; i < acceptStatesCount; i++) {
			if(startingState.equals(acceptStates[i])) {
				System.out.println("The word is -VALID- for this automata.\n");
				return true;
			}
		}

			System.out.println("The word is -NOT VALID- for this automata.\n");
			return false;
	}
	
	
	public static int getIndexOfNode(String[][] transactionTable,String node) {
		
		int index = 0;
		
		for(int i = 1; i < transactionTable.length; i++) {
			if(transactionTable[i][0].equals(node))
				index = i;
		}
		
		return index;
	}
	
	
	public static int getIndexOfState(String[][] transactionTable,String state) {
		
		int index = 0;
		
		for(int i = 1; i < transactionTable[0].length; i++) {
			if(transactionTable[0][i].equals(state))
				index = i;
		}
		
		return index;
	}
	
	
	public static String[][] readyToUseExample(){
		String[][] transactionTable = new String[5][3];
		
		transactionTable[0][0] = " ";
		transactionTable[0][1] = "a";
		transactionTable[0][2] = "b";
		transactionTable[1][0] = "A";
		transactionTable[1][1] = "B";
		transactionTable[1][2] = "A";
		transactionTable[2][0] = "B";
		transactionTable[2][1] = "B";
		transactionTable[2][2] = "C";
		transactionTable[3][0] = "C";
		transactionTable[3][1] = "B";
		transactionTable[3][2] = "D";
		transactionTable[4][0] = "D";
		transactionTable[4][1] = "B";
		transactionTable[4][2] = "A";
		
		return transactionTable;
	}
	
	
	public static String[][] readyToUseExample2(){
		System.out.println("(En az uc adet '1' iceren otomata.)");
		System.out.println("(Baslangic durumu: q0)");
		System.out.println("(Kabul durumlari : q3)");
		String[][] transactionTable = new String[5][3];
		
		transactionTable[0][0] = " ";
		transactionTable[0][1] = "0";
		transactionTable[0][2] = "1";
		transactionTable[1][0] = "q0";
		transactionTable[1][1] = "q0";
		transactionTable[1][2] = "q1";
		transactionTable[2][0] = "q1";
		transactionTable[2][1] = "q1";
		transactionTable[2][2] = "q2";
		transactionTable[3][0] = "q2";
		transactionTable[3][1] = "q2";
		transactionTable[3][2] = "q3";
		transactionTable[4][0] = "q3";
		transactionTable[4][1] = "q3";
		transactionTable[4][2] = "q3";
		
		return transactionTable;
	}
	
	
	public static String[][] readyToUseExample3(){
		System.out.println("(En az iki '0' ve en fazla bir adet '1' iceren otomata.)");
		System.out.println("(Baslangic durumu: q0)");
		System.out.println("(Kabul durumlari : q2,q5)");
		String[][] transactionTable = new String[9][3];
		
		transactionTable[0][0] = " ";
		transactionTable[0][1] = "0";
		transactionTable[0][2] = "1";
		transactionTable[1][0] = "q0";
		transactionTable[1][1] = "q1";
		transactionTable[1][2] = "q3";
		transactionTable[2][0] = "q1";
		transactionTable[2][1] = "q2";
		transactionTable[2][2] = "q4";
		transactionTable[3][0] = "q2";
		transactionTable[3][1] = "q2";
		transactionTable[3][2] = "q5";
		transactionTable[4][0] = "q3";
		transactionTable[4][1] = "q7";
		transactionTable[4][2] = "q6";
		transactionTable[5][0] = "q4";
		transactionTable[5][1] = "q5";
		transactionTable[5][2] = "q6";
		transactionTable[6][0] = "q5";
		transactionTable[6][1] = "q5";
		transactionTable[6][2] = "q6";
		transactionTable[7][0] = "q6";
		transactionTable[7][1] = "q6";
		transactionTable[7][2] = "q6";
		transactionTable[8][0] = "q7";
		transactionTable[8][1] = "q5";
		transactionTable[8][2] = "q6";

		
		return transactionTable;
	}
	

}
