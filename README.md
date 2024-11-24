Arkanoid Game - OOP Project
Overview
This project is a Java-based implementation of the classic Arkanoid game, built using Object-Oriented Programming (OOP) principles. The game involves controlling a paddle to bounce a ball and break bricks. It features multiple levels, a graphical user interface (GUI), and user input handling.

How to Clone and Run the Project
Follow these steps to clone, compile, and run the project:

1. Clone the Repository
Clone the project from GitHub:

bash
Copy code
git clone -b master https://github.com/davidNidam1/Arkanoid.git
This command clones the repository from the master branch to your local machine.

2. Navigate to the Project Directory
Change to the project folder:

bash
Copy code
cd Arkanoid
This command moves into the Arkanoid directory, which contains the src folder with all Java source files.

3. Open the Project in VS Code
Open the project in Visual Studio Code:

bash
Copy code
code .
This opens the project in VS Code, allowing you to view and edit the code.

4. Compile the Java Files
Compile all Java source files with the biuoop-1.4.jar library:

bash
Copy code
javac -d bin -cp "biuoop-1.4.jar" src\*.java src\**\*.java
javac: The Java compiler command.
-d bin: Specifies the output directory (bin) for compiled .class files.
-cp "biuoop-1.4.jar": Adds the biuoop-1.4.jar library to the classpath, which provides the necessary GUI components.
src\*.java src\**\*.java: Compiles all Java files in the src directory and subdirectories.
5. Run the Game
Run the compiled MainClass from the bin directory:

bash
Copy code
java -cp "bin;biuoop-1.4.jar" ./src/Ass6Game
java: Runs the compiled Java program.
-cp "bin;biuoop-1.4.jar": Sets the classpath to include the compiled classes (bin) and the biuoop library (biuoop-1.4.jar).
./src/Ass6Game: Specifies the entry point of the program (the class with the main method).
Game Description
Arkanoid is a brick-breaking game where the player controls a paddle to bounce a ball and destroy bricks. Key features include:

Paddle: The player controls the paddle to bounce the ball.
Ball: The ball bounces off walls and the paddle, destroying bricks.
Bricks: When hit by the ball, bricks are destroyed.
Levels: The game progresses through multiple levels.
Score: Players earn points by breaking bricks.
Controls:
Arrow keys: Move the paddle left or right.
Space: Start/resume the game.
p: Pause the game.
Why These Commands Are Important
git clone -b master: Clones the project from the correct GitHub branch (master), allowing you to download the latest version of the project.
cd Arkanoid: Changes the directory to the project folder to work within it.
code .: Opens the project in Visual Studio Code, a popular IDE for Java development.
javac: Compiles the source code into .class files so the Java Virtual Machine (JVM) can execute them.
java: Runs the compiled Java program, launching the Arkanoid game.
These commands enable you to clone, compile, and run the game, which is the basic workflow for setting up and executing a Java project.

Object-Oriented Programming (OOP) in the Project
This project demonstrates core principles of Object-Oriented Programming (OOP):

Encapsulation: Classes like Paddle, Ball, and Block encapsulate their respective properties (e.g., position, size, color) and methods (e.g., movement, collision detection).

Inheritance: Some game elements might extend base classes for reusability. For example, Block and Paddle could inherit from a common Sprite class that defines shared behavior, like rendering on the screen.

Polymorphism: Methods like drawOn(DrawSurface d) can be overridden in subclasses to implement different behaviors depending on the object type, like how different types of blocks are drawn or interacted with.

Abstraction: The game separates the logic into different classes like GameLevel, AnimationRunner, and Ball, hiding complex details from the user and allowing for easier maintenance and expansion.

Conclusion
This Arkanoid game project demonstrates good use of OOP principles, such as encapsulation, inheritance, and polymorphism, which are key concepts in modern software development. The game structure is modular, allowing for easy adjustments and extensions. For instance, adding new levels, changing the game's appearance, or adjusting the game rules could be done with minimal changes to the core logic.
