Design Overview
========================
##External API

###Front End -> Backend

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
###BackEnd -> FrontEnd

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
##Internal API
###Frontend
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
            
###Backend
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

        