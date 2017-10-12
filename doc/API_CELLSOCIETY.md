#Slogo API


1.	We would ideally like parsing to take place almost constantly so we could let the user know when they made a mistake in syntax. So, we would parse every time we detect a whitespace, that way we can check if they correctly typed in a key word and we would check every time we detect a new line to see if there are an overall problem with syntax.

2.	The result of parsing is the directions for the turtle and GUI and it is passed to the frontend and controller.

3.	They should be checked in time and reported through the front end so the user can know exactly what happened. 

4.	Commands need to know their parameters and their resulting action. They get the information from a method. 

5.	 The backend gives the front end directions and the front end carries it out accordingly.