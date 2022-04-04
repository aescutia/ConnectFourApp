import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyTest {
	// I couldnt use the game logic class since it all relies on
	// the game button class. I made a similar version of how the logic
	// would work if it didnt rely on game button so the tests could run
	String pieces[][] = new String[6][7];
	@Test
	void winVerticalTest1() {
		pieces[5][0] = "p1";
		pieces[4][0] = "p1";
		pieces[3][0] = "p1";
		pieces[2][0] = "p1";
		boolean checkWin = false;
		
		if(pieces[5][0] == pieces[5][0] && pieces[5][0] == pieces[5][0] && pieces[5][0] == pieces[5][0]) {
			checkWin = true;
		}
		assertEquals(true, checkWin, "Incorrect value for win!");
	}
	@Test
	void winVerticalTest2() {
		pieces[3][6] = "p1";
		pieces[2][6] = "p1";
		pieces[1][6] = "p1";
		pieces[0][6] = "p1";
		boolean checkWin = false;
		
		if(pieces[3][6] == pieces[2][6] && pieces[3][6] == pieces[1][6] && pieces[3][6] == pieces[0][6]) {
			checkWin = true;
		}
		assertEquals(true, checkWin, "Incorrect value for win!");
	}
	
	@Test
	void winHorizontalTest1() {
		pieces[3][0] = "p1";
		pieces[3][1] = "p1";
		pieces[3][2] = "p1";
		pieces[3][3] = "p1";
		boolean checkWin = false;
		
		if(pieces[3][0] == pieces[3][1] && pieces[3][0] == pieces[3][2] && pieces[3][0] == pieces[3][3]) {
			checkWin = true;
		}
		assertEquals(true, checkWin, "Incorrect value for win!");
	}
	
	@Test
	void winHorizontalTest2() {
		pieces[0][0] = "p1";
		pieces[0][1] = "p1";
		pieces[0][2] = "p1";
		pieces[0][3] = "p1";
		boolean checkWin = false;
		
		if(pieces[0][0] == pieces[0][1] && pieces[0][0] == pieces[0][2] && pieces[0][0] == pieces[0][3]) {
			checkWin = true;
		}
		assertEquals(true, checkWin, "Incorrect value for win!");
	}
	
	@Test
	void winDiagonalTest1() {
		pieces[2][0] = "p1";
		pieces[3][1] = "p1";
		pieces[4][2] = "p1";
		pieces[5][3] = "p1";
		boolean checkWin = false;
		
		if(pieces[2][0] == pieces[3][1] && pieces[2][0] == pieces[4][2] && pieces[2][0] == pieces[5][3]) {
			checkWin = true;
		}
		assertEquals(true, checkWin, "Incorrect value for win!");
	}
	
	@Test
	void winDiagonalTest2() {
		pieces[5][3] = "p1";
		pieces[4][4] = "p1";
		pieces[3][5] = "p1";
		pieces[2][6] = "p1";
		boolean checkWin = false;
		
		if(pieces[5][3] == pieces[4][4] && pieces[5][3] == pieces[3][5] && pieces[5][3] == pieces[2][6]) {
			checkWin = true;
		}
		assertEquals(true, checkWin, "Incorrect value for win!");
	}
	@Test
	void winDiagonalTest3() {
		pieces[2][0] = "p1";
		pieces[3][1] = "p2";
		pieces[4][2] = "p1";
		pieces[5][3] = "p1";
		boolean checkWin = false;
		
		if(pieces[2][0] == pieces[3][1] && pieces[2][0] == pieces[4][2] && pieces[2][0] == pieces[5][3]) {
			checkWin = true;
		}
		assertEquals(false, checkWin, "Incorrect value for win!");
	}

}
