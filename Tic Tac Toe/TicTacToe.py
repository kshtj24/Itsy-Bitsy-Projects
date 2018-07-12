
#create the board and print out the message to start
#ask the players to choose o or x
#while game is not over
#take input from the players
#update the board
#check if game is over (win or tie)

#printing the board
def printBoard(board):
	for a,b,c in board:
		print(a,b,c)

#checks for win to tie situation
def checkWinRowWise(board):
	for a,b,c in board:
		if a == b == c != '-':
			return True
			print("Row")
	return False

def checkWinColumnWise(board):
	board = [[row[i] for row in board] for i in range(len(board[0]))]
	for a,b,c in board:
		if a == b == c != '-':
			return True
			print("Column")
	return False

def checkWinDiagonally(board):
	if (board[0][0] == board[1][1] == board[2][2] != '-') or (board[0][2] == board[1][1] == board[2][0] != '-'):
		return True
		print("Diagonal")
	return False		


#validating the character inputs
def validateCharacters(*args):
	if len(args) == 1:
		if args[0] != 'O' or args[0] != 'X':
			print("Please choose 'O' or 'X'")
			return False
		else:
			return True
			
#initializing the 2 dim array as board and printing the start message
board = [['-','-','-'],['-','-','-'],['-','-','-']]
print("Let's play some Tic Tac Toe:")
printBoard(board)

#taking the choice of O or X from player1
player1 = (input("Player 1, please select your mark 'O' or 'X' :")).upper()

if player1 == 'X':
	player2 = 'O'
else:
	player2 = 'X'

chance = 1
while(True):
	location = input(f"Player {abs(chance)}, please enter the row and column to put your mark:").split(' ')
	if chance == 1:
		board[int(location[0]) - 1][int(location[1]) - 1] = player1
	else:
		board[int(location[0]) - 1][int(location[1]) - 1] = player2
	
	printBoard(board)
	
	if(checkWinRowWise(board) or checkWinColumnWise(board) or checkWinDiagonally(board)):
		print(f"Congratulations !!! Player {abs(chance)} has won the game")
		break
	
	if not any('-' in arr for arr in board):
		print("It's a Tie")
		break
	chance = ~chance
	