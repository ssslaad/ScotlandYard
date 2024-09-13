# ScotlandYard
This repository is for a popular board game "ScotlandYard" where detectives tries to find Mr. X in the Scotland City.

# Figma (Draft)
https://www.figma.com/design/tBbWLISE7G41F2QKVyHDoC/Scotland-Yard-Tracker?node-id=0-1&m=dev&t=2oUOz3cFpTC0zhxq-1

# Terminologies:
- Players - Detectives and Mr. X (Characters in the game - Max. 6)
- Step - When all roles plays their turn a step completes.
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
    
  	- Mr. X's respective transportation tickets should increase by 1 when detective plays.
	
	- Special Abilities:
   		- **2x(Double Move) - 2** (Mr. X will have all 2 tickets)

	- Start Card:
   		- List of 18 Stations (starting station), and 6 will be picked out of those stations randomly (1 for each player).
       
# Requirements:
## Functional Requirements:
1. User should be able to host the room and give the password (can be empty) for the room.
2. User should be able to join the room using the room id & password (can be empty).
	- If user tries to join the non-existing room or existing room with wrong password, an error popup should give the appropriate message.
	- If user tries to join a room, which is already full (contains 6 players), an error popup should give the appropriate message.
4. Game can start only if minimum 2 players have joined the room.
5. Room can contain maximum of 6 players.
6. Once everyone is joined and host wants to start the game, they should be able to do it from UI using a "Start Game" button.
7. Once the host starts the game:
	- Roles (Mr. X and detective) should be randomly assigned to players. If players are less than 6, then single player should be assigned multiple detectives role. Player having Mr. X's role should not be given detective's role and vice-versa.
 	- All the players should be shown the roles of every player. (like we see on Among-Us game)
	- Each player should be given a starting position out of a possible list of starting-positions.
	- Imposter should be given 1st turn/move to play.
	- Next moves can be randomly assigned to detectives and sequence should be same for rest of the game.
	- The player (who is playing) should be shown all the possible options of movement along with tickets count (ex. Taxi, Bus, Underground, Black Ticket, White Ticket, 2x move etc).
 	- After every step/move, appropriate ticket should be deducted from players tickets.
  	- Give "Edit Last Move" option - incase user submits wrong information and that edit can be done before next player plays.
 	- Mr. X's movement should **not** be visible to other players but mode of transport should be visible.
  	- Detective's movement should be visible to every other players along with mode of transport.
  	- Automatically populate the source location of the players and Source location of player should be same as previous target location (user should not be able to enter source location). For the very 1st move, the starting location will be the source location of the player.
  	- Automatically disclose Mr. X's location after 3, 8, 13, 18, 24 steps.
 	- If player with role "Detective" drops/disconnects in between the game, wait 1 mins for that player to rejoin, else assign that particular character/role to different player. If the player rejoins after 1 min, lets say after few mins, that user again joins the room, assign back that role back to that player.
		For ex. if player with role Detective Blue disconnects, wait for 1 min, else assign Detective blue's role to different player.
	- If player with role 'Mr. X' disconnects/drops, wait for next 5 mins, else close the game.
8. Game Over Scenarios for players:
 		- If at any point of time, any of the detectives location and Mr. X's location is same, we should show the message "Game Over" for Mr. X. 
		- Movement not possible for player (based on available tickets and current location)
	  	- Tickets finished.
	   	- If Mr. X plays all 24 moves, he Wins and it's game over for Detectives.
9. Once the game is over:
	- An option to "Show moves" of all the players during entire game should be visible to everyone.
	- If user clicks on Show Moves", visual graph should be visible with step by step movement of each player in sequence(sequence should be same as was in the game).
	- If user doesn't click on "Show Moves", they should be redirected to Start Screen (where they can either join/host the room). Name of the user should be automatically populated in the Start Screen.

## Non-functional Requirements:
1. If transaction is not successful (write operation for DB), then wait for it or retry it. Even after it if it is not successful, then ask player to re-submit the movement.
2. Every important information should be encrypted.
3. Future capabilities possible:
	- DB, backend can be changed in future. So design accordingly (lets say from mongo-db to firebase or from spring-boot to express/node etc.)
	- Entire game can be integrated.
 	- Login using 3rd party APIs. (like google, contact-number etc)
  	- 
4. 
5. 


# Requirements Discussions
## Functional Requirements Discussions:
- Room ID (So that multiple users can connect to this room)
	- Create (host)
	- Join 
	- Turn Table UI (Mr. X first, then random turns)
	- Host should decide the **roles** of all the players in the room. It should be 2 step process - First decide Imposter, then remove the player name (who is imposter) from detectives dropdown.
	- Room should be closed once the game analysis is done.
	- Disconnected players should be able to join same room. 
   
- Role wise functionalities:
	- Imposter's movement should not be visible to other players but mode of the transport should be visible.
	- Imposter must reveal his position occasionally.

- Login Not Needed (As of now, can be implemented in future)

- Start card For all players (Station Number - Random)
  	
- Validations:
	- If target location of any player is same as target location of other player in previous step, then we should enter the entries.
	- Source station of player for a turn should be same as target station of previous turn.
	- Automatically populate source station.
 	- App should reveal Mr. X's location on specific steps (which we will hardcode - Step 3, 8, 13, 18, 24).

Game Over (for a player):
	- Movement not possible for player. (based on available tickets and current location)
  	- Tickets finished.
   	- If Mr. X plays all 24 moves, he Wins.

Game Over (for Mr. X):
  	- If Mr. X's current location is same as any detectives current location, it's GAME OVER for Mr. X

## Non-functional Requirements Discussions:
1. Room ID should be unique and given from backend.
2. All passwords should be encrypted.
3. The list of possible starting positions should be stored in DB.
4. Room and associated users along with role of the user (for that particular game/room) should be stored in DB.
5. User should be stored in DB and should be uniquely identifiable.
6. Moves of all the players of all the games should be stored in DB for future references.
7. Game should be marked as incomplete/complete based on if Detectives were able to catch Mr. X or not. Also store who won for future references.
 
# High Level Design (HLD)
<p align="center">
  <img src="![scotlandyardtracker](https://github.com/user-attachments/assets/6bd0d963-2d1c-45d4-b085-d57fd014563f)" />
</p>
![scotlandyardtracker](https://github.com/user-attachments/assets/6bd0d963-2d1c-45d4-b085-d57fd014563f)

- All the players creates a communication channel with game server.
- Player (Host) sends request to create a room to the server (along with password), Game server creates room id, persists id and pwd of room in DB.
- Another player requests to joins a room using room id and pwd, Game server persists this information (player joined which room) in DB.
- Host starts the game, random roles are assigned to all the players and persisted in DB.
- Any player sends move/step mesasge to the game server, Game server receives the message, persist it in DB and broadcasts the move to all the players of that room.
- Whenever Game is over, then room id should be marked as inactive in the DB.

# Modules :
- Landing page
- Create Room (no. of players, roles assignment option - random/custom)
- Join Room
- Loby - Role assignment(random/custom), start game button (disabled until all roles assigned)
- Game(Playground)
	- Initialization (Start locations)
	- Step (max. 24)
	- Mr.X special abilities (2 step + reveal position) 
	- Game Over
- Reconnecting Module
- Add Friend(Good to have)
 
 
