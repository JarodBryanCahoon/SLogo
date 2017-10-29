Design Overview
===============
*External API
    *FrontEnd -> BackEnd
        *Console
            update
            turn
        *Render
            addTurtle
            drawLine
            clearScreen
        *View
            getModules
        Colorpick
            setColor
    *BackEnd -> FrontEnd
        *Turtle
            getX
            getY
            getAngle
            getPen
            getValue
            getId
        *Manager
            setCommand
            getHistory
            getVariables
*Internal API
    *FrontEnd
        *render
            *get
        *MenuStrategy
            *execute
        *Module
            *getXMLPreferences
        *Module
            *getParent
        *ColorReader
            *getWords
            *getWindow
            *getRender
        *ConfigReader
            *getWidth
            *getHeight
            *getTitle
        *MenuReader
            *getSubMenus
    *Backend
        *Word
            *getType
            *getName
            *getNumber
            *getNode
        *GeneralObject
            *act
            *getID
        *MoveInterface
            *act
        *TextParse
            *setCommand
        
        
            