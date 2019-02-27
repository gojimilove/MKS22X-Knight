public class Driver {
	public static void main(String[] args) {
		KnightBoard test = new KnightBoard(5,5);
		KnightBoard test2 = new KnightBoard(5,5);
		//System.out.println(test);
		System.out.println(test.solve(0,0));
		System.out.println(test2.countSolutions(0,0));
		System.out.println(test);
		System.out.println(test2);
		// test.addKnight(2,1);
		// System.out.println(test);
		// test.removeKnight(2,1);
		// System.out.println(test);
		//System.out.println(test.printMoves());
	}
}
