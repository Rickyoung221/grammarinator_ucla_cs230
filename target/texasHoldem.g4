grammar TexasHoldem;

// Entry point
game : player1Hand SPACE player2Hand SPACE board EOF;

// Hands for player 1 and player 2
player1Hand : card card;
player2Hand : card card;

// The board (5 cards)
board : card card card card card;

// Card definition
card : rank suit;

// Rank and suit definitions
rank : '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' | 'T' | 'J' | 'Q' | 'K' | 'A';
suit : 'h' | 'd' | 'c' | 's';

// Whitespace
SPACE : ' ';
