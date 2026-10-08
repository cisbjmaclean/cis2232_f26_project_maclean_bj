# Squash Scorer #

Sample cis2232 project

## Development Team ##

Business Client:  BJ MacLean	<br/>
Lead Developer:  BJ MacLean	<br/>
Quality Control:  BJ MacLean	<br/>

## Description ##

This web application will allow a user to enter the score for squash matches and keep track of player history.  It is allowing the user to enter scores after a match.  A squash match is a best of five games with each game going to 11 and the winner of each game needing to win by two points.  The application will determine the winner based on the scores entered.  

## Color ##

Main Color:  Kelly Green
Secondary Color: Light Green


## Required Fields ##

id	int	Unique identifier for database table	<br/>
matchDate	String	Date match played	<br/>
createdDateTime	String	Date entered in the application	<br/>
player1Name	String	<br/>
player2Name	String		<br/>
player1Game1Score	int		<br/>
player2Game1Score	Int		<br/>
player1Game2Score	int		<br/>
player2Game2Score	Int		<br/>
player1Game3Score	int		<br/>
player2Game3Score	int		<br/>
player1Game4Score	int		<br/>
player2Game4Score	int		<br/>
player1Game5Score	int		<br/>
player2Game5Score	Int		<br/>
winnerName	String	Either player1Name or player2Name	<br/>

## Calculation ##

The calculation / processing needed when the player enters a new record will be to determine the winner.  The entry will be analyzed to ensure that one of the players has won three games and the winner will be added to the row of the database.

## Report Details ##

### Player name report ###

Enter a player name and the report will return any rows that have that name 'like' the player 1 name or the player 2 name. On the report results page, only show the player, the opponent and the game scores.

### Player matches report ###

Enter a player name and a date range and show the matches where that player played as either player 1 or player 2.  Give a drop down of all players as part of the user input.
