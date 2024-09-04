# ScotlandYard
This repository is for a popular board game "ScotlandYard" where detectives tries to find Mr. X in the Scotland City.
This line is written by Shivam
This line is to check - Aniruddha


# HLD Discussions:

- Room ID (So that multiple users can connect to this room)
	-	Create (host)
	-	Join 
	-	Turn Table UI (Mr. X first, then random turns)
	-	Host should decide the **roles** of all the players in the room. It should be 2 step process - First decide Imposter, then remove the player name (who is imposter) from detectives dropdown.

- Role wise functionalities:
  - Imposter's movement should not be visible to other players but mode of the transport should be visible.
  - Imposter msut reveal his position occasionally.

- Login Not Needed (As of now, can be implemented in future)

- Initialize Node (Station Number - Random)

- Validations:
	-	If target location of any player is same as target location of other player in previous step, then we should enter the entries.
	-	Source station of player for a turn should be same as target station of previous turn.
	-	Automatically populate source station.

Game Over (for a player):
	-	Movement not possible for player.
  - Tokens finished.

Game Over (for Mr. X):
  - If Mr. X's current location is same as any detectives current location, it's GAME OVER for Mr. X

