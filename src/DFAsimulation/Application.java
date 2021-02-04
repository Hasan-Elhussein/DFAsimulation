package DFAsimulation;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String startingState = null;
		int acceptStatesCount = 0;
		String[] acceptStates;
		String word = null;
		String check = "";
		
		//String[][] transactionTable = DFA.readyToUseExample();
		//String[][] transactionTable = DFA.readyToUseExample2();
		//String[][] transactionTable = DFA.readyToUseExample3();
		String[][] transactionTable = DFA.getTransactionTableFromUser();
		
		DFA.printTransactionTable(transactionTable);
		
		
		do {
			System.out.println("Enter starting state:");
			startingState = scan.next();
		} while (!DFA.checkNode(transactionTable, startingState));
		
		System.out.println("How many accepting state(s) available?");
		acceptStatesCount = scan.nextInt();
		acceptStates = new String[acceptStatesCount];
		
		for(int i = 0; i < acceptStatesCount; i++) {
			do {
				System.out.println("Enter accepting state(s):");
				acceptStates[i] = scan.next();
			} while (!DFA.checkNode(transactionTable, acceptStates[i]));
		}
		
		
		while(!check.equals("end")) {
			do {
				System.out.println("Enter a word to simulate: (the input)");
				word = scan.next();
			} while (!DFA.checkWord(transactionTable, word));
			
			
			DFA.simulate(transactionTable,startingState,acceptStates,acceptStatesCount,word);
			
			
			System.out.println("Continue? (type 'end' to exit, or anything else to continue.)");
			check = scan.next();
			System.out.println();
		}
		
		
		scan.close();	
	}
	
}
