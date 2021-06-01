# Jets Project

### Overview

This program keeps track of and allows the user to manage an airfield containing
a variety of Jets. The types of Jets allowed for are Cargo Jets, Fighter Jets,
Passenger Jets, and Custom Jets. (Custom Jets are a basic implementation of the
Super Class Jet)

Initially, an airfield is populated by reading in data from
a csv file that contains several models of jets along with their speed, range,
price, and cargo capacity.

The user is then given a variety of options to manage their airfield and fleet
of jets.

The program will maintain all applicable data and allow interactions based on
the menu until the user selects "Quit".

### Technologies Used

* Java
* Inheritance (Abstract Classes, Interfaces, SuperClass, SubClass)
* Array Lists
* Abstraction (Only relevant data is made visable)
* Encapsulation
* Polymorphism (Casting Objects up to SuperClass or down through InstanceOf)
* Constructors, Getters, Setters, toString

### How to Run

At the beginning of the program, the user is prompted to name their airfield.
Then the airfield is initially populated with 5 Jets by reading in data from a
CSV file.

The user is then provided a menu of options as outlined:
* List Fleet - Will display all of the details of each aircraft stored at the
  airfield.

* Fly all Jets - Will display each jets model, the speed it can fly at, the
  length of time it can fly, and the total distance it can fly.

* View fastest jet - Will display all of the details of the jet which has the
  highest speed out of all of the jets at the airfield.

* View jet with longest range - Will display all of the details of the jet which
  has the longest flight range out of all of the jets at the airfield.

* Load cargo jet - This option will allow the user to select one or all cargo
  jets and load them with cargo. Only jets of the type CargoJet are shown and
  the user is able to choose how much cargo is loaded based on a percentage of
  the jets cargo capacity.

* Arm fighter jet - This option will allow the user to select one or all fighter
  jets and load them with cargo. Only jets of the type FighterJet are shown and
  the user is able to choose how much payload is loaded based on a percentage of
  the jets payload capacity.

* Board a passenger jet - This option will allow the user to select one or all
  passenger jets and load them with passengers. Only jets of the type
  PassengerJet are shown and the user is able to choose how many passengers board
  based on a percentage of the jets passenger capacity.

* Deliver the goods - This option will show the user only Cargo Jets, Fighter
  Jets, and Passenger Jets that have been loaded with cargo, payload, or passengers
  respectively. The user may select one of the jets to fly and deliver what they
  are carrying. Following flight and delivery, the jet will not show up on the
  list again unless they are loaded through one of the other menu options.

* Add a jet to the fleet - Allows the user to manually add a jet to the airfield.
  The user is provided with options for Cargo Jets, Fighter Jets, Passenger
  Jets, or a Custom Jet. Following their selection, they are prompted to enter
  all of the applicable data and the Jet will then become available for use through
  the main menu.

* Remove a jet from the fleet- This option shows the user all of the Jets at the
  airfield and allow them select a Jet to remove from the airfield by entering
  the corresponding number. Once this is performed, that jet will no longer be
  available from any of the menu options.

* Quit - Exits the program.

### Lessons Learned

This program taught me that a UML diagram can be of great help as programs get
longer and begin to contain multiple classes, interfaces, and methods. I found it
to be easiest to plan out the general function of the program first, followed by
the data needed to acheive that function. I was then able to start building the
program one menu item at a time always thinking along the lines of "IS A".
This assisted me in reducing duplicate code and keeping my thought process from
bouncing around the program.
