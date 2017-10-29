Design Overview
========================
![enter image description here](https://coursework.cs.duke.edu/CompSci308_2017Fall/slogo_team02/raw/master/doc/629d22b48a4346e2964b6893d8c4d0c5%20%281%29.jpeg)
## External API

### Front End -> Backend

----------
-	Console
	-	update
	-	turn
-	Render
	-	addTurtle
	-	drawLine
	-	clearScreen
-	View
	-	getModules
-	Colorpick
	-	setColor
	-	
### BackEnd -> FrontEnd


------------------
-	Turtle
	-	getX
	-	getY
	-	getAngle
	-	getPen
	-	getValue
	-	getId
-	Manager
	-	setCommand
	-	getHistory
	-	getVariables
## Internal API
### Frontend
------------------
-	Render
	-	get
-	MenuStrategy
	-	execute
-	Module
	-	getXMLPreferences
	-	getParent
-	ColorReader
	-	GetWords
	-	getWindow
	-	geRender
-	ConfigReader
	-	getWidth
	-	getHeight
	-	getTitle
-	MenuReader
	-	getSubMenus
            
### Backend
-	Word
	-	getType
	-	getName
	-	getNumber
	-	getNode
-	GeneralObject
	-	act
	-	getID
-	MoveInterface
	-	act
-	TextParse
	-	setCommand

## Discussion

--------------

Overall, our design still follows the Model View Controller architecture. However, we made a few 
changes in the plans of our code.

-   One of the major changes we have made in our API is our incorporation of command classes. Before, we
had a central controller that processed the command logic. However, now we have separate command
classes to perform the commands. We believe that design is by far superior as, through reflection, we
are able to easily implement commands without having to modify any of the code we have - thus upholding
the design ideals of closed modification, open expansion.
-   We are still maintaining the observer/observable pattern for the representation of Turtles. 
We are now also using this pattern to represent the History and Variables. This, we believe was the next
logical step. 
