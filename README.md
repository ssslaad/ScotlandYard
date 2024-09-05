# ScotlandYard
This repository is for a popular board game "ScotlandYard" where detectives tries to find Mr. X in the Scotland City.

# Terminologies:
- Players - Detectives and Mr. X (Characters in the game).
- Users - People who are logged in to the game.
- Roles - Detective or Mr. X (either of them is a role. Based on role, we will restrict the display of information).
- Host - User who created the room.
- Tickets: 
	- Transportation:
		- **Taxi - 54** (detectives will have 10 tickets each)
		- **Bus - 43** (detectives will have 8 tickets each)
		- **Underground - 23** (detectives will have 4 tickets each)
		- **Black Ticket - 5** (Mr. X will have all 5 tickets)
		- **Label Ticket - 1** (Mr. X will have 1 ticket)
	
	- Special Abilities:
   		- **2x(Double Move) - 2** (Mr. X will have all 2 tickets)

	- Start Card:
   		- List of 18 Stations (starting station), and 6 will be picked out of those stations randomly (1 for each player).

# HLD Discussions:

- Room ID (So that multiple users can connect to this room)
	- Create (host)
	- Join 
	- Turn Table UI (Mr. X first, then random turns)
	- Host should decide the **roles** of all the players in the room. It should be 2 step process - First decide Imposter, then remove the player name (who is imposter) from detectives dropdown.

- Role wise functionalities:
	- Imposter's movement should not be visible to other players but mode of the transport should be visible.
	- Imposter msut reveal his position occasionally.

- Login Not Needed (As of now, can be implemented in future)

- Start card For all players (Station Number - Random)
  	

- Validations:
	- If target location of any player is same as target location of other player in previous step, then we should enter the entries.
	- Source station of player for a turn should be same as target station of previous turn.
	- Automatically populate source station.

Game Over (for a player):
	- Movement not possible for player. (based on available tickets and current location)
  	- Tickets finished.
   	- If Mr. X plays all 24 moves, he Wins.

Game Over (for Mr. X):
  	- If Mr. X's current location is same as any detectives current location, it's GAME OVER for Mr. X


// step 1 : 
// step 2 : 
// step 3 : Mr. x reveal location
// step 4 : Mr. x
// step 5 : Mr. x
