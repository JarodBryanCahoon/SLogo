Introduction
=================
* Our design will follow the Model-View-Controller architecture. The primary design goal of this architecture is to provide a level of abstraction in how models (turtles in this case) will be manipulated.
    * The backend model and frontend view would be held together with a central controller that processes command logic
    * Our group is trying to provide extensibility in how we process commands in order to handle more than just the basics provided
    * The ability to add new commands, to add features to the model, and vary the structure of the frontend is open. Everything else is closed.
        * Ideally, MVC would allow us to substitutue an entirely new controller as long as the APIs remain the same.  
    * The primary design goals of this project are for the user to be able to manipulate one or many objects on the screen, both by the command line which will provided to the right of the display, and by clicking elements of the GUI. We want our code to be flexible enough to accomidate both new objects which have their own behaviors, and new commands which the user can input for the Object to do.
    * We plan to implement a hierarchical system which will allow the programmer to extend existing code to create new classes with unique behavior, but be closed to changing the methods that the object possesses. This will be done using an interface.


Design Overview
===================
* External APIs will be linked to either "side" of the Controller
    * Frontend -> Backend
        * Give commands
        * Change language
    * Backend -> Frontend
        * Change Turtles
        * Give errors
        * Change GUI config

User Interface
=====================
The user interface is simple; it contains an overhead menu bar with dropdown menu options, a render screen on the left to display sprites/turtles/pen movements, a console on the right that allows the user to type in code, and a debug screen on the bottom that shows the users errors in coding, etc. 
* Users can interact with the interface by selecting menu options from the bar, typing in SLOGO commands in the console, or (potentially later) clicking in the render screen (clicking on turtle, etc).
* Errors reported to the user include bad syntax (potentially include realtime syntax help like eclipse or an IDE), empty/bad data, errors with turtle reported from backend, etc.
* Clicking on the turtle may (in the future) select a turtle from multiple turtles, change pen color, etc. For now many of these options will be in the menu toolbar

![Perfectly Rendered Image of Design](IMG_20171012_222408440.jpg)

API Details
========================
