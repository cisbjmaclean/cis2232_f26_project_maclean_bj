# \# Squash Scorer #

Sample cis2232 project



\---

\## Development Team ##

Business Client:  BJ MacLean

<br/>

Lead Developer:  BJ MacLean

<br/>

Quality Control:  BJ MacLean

<br/>

\---

\## Description ##

This web application will allow a user to enter the score for squash matches and keep track of player history.  It is allowing the user to enter scores after a match.  A squash match is a best of five games with each game going to 11 and the winner of each game needing to win by two points.  The application will determine the winner based on the scores entered.  

\---

\## Color ##

Main Color:  Kelly Green<br/>

Secondary Color: Light Green<br/>

\---

\## Required Fields ##

This will be a list of fields and their datatype (class design format).  There are expected to be a minimum of six fields.  

id	int	Unique identifier for database table

matchDate	String	Date match played

createdDateTime	String	Date entered in the application

player1Name	String	

player2Name	String	

player1Game1Score	int	

player2Game1Score	Int	

player1Game2Score	int	

player2Game2Score	Int	

player1Game3Score	int	

player2Game3Score	int	

player1Game4Score	int	

player2Game4Score	int	

player1Game5Score	int	

player2Game5Score	Int	

winnerName	String	Either player1Name or player2Name

\---

\## Calculation ##

The calculation / processing needed when the player enters a new record will be to determine the winner.  The entry will be analyzed to ensure that one of the players has won three games and the winner will be added to the row of the database.



\---

\## Report Details##

To be determined in future sprint

