package com;

import org.junit.Test;

import junit.framework.*;

public class TestPoker {
	@Test
	public void TexasPokerTest1() {
		String white = "2C 3H 4S 8C AH";
		String black = "2H 3D 5S 9C KD";
		String result = TexasPoker.contest(white, black);
		Assert.assertEquals("White wins - high card: Ace", result);
	}
	
	@Test
	public void TexasPokerTest2() {
		String white = "2S 8S AS QS 3S";
		String black = "2H 4S 4C 2D 4H";
		String result = TexasPoker.contest(white, black);
		Assert.assertEquals("Black wins - full house", result);
	}
	
	@Test
	public void TexasPokerTest3() {
		String white = "2C 3H 4S 8C KH";
		String black = "2H 3D 5S 9C KD";
		String result = TexasPoker.contest(white, black);
		Assert.assertEquals("Black wins - high card: 9", result);
	}
	
	@Test
	public void TexasPokerTest4() {
		String white = "2D 3H 5C 9S KH";
		String black = "2H 3D 5S 9C KD";
		String result = TexasPoker.contest(white, black);
		Assert.assertEquals("Tie", result);
	}
	
}
