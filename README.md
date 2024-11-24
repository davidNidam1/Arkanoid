# Arkanoid Game - OOP Project

![image](https://github.com/user-attachments/assets/c2ccbd82-b475-4430-9416-1b670e352cdf)


## Overview

This is a **Java-based** implementation of the **Arkanoid** game, utilizing **Object-Oriented Programming (OOP)** principles. The game is designed to simulate a brick-breaking arcade game where the player controls a paddle to bounce a ball and break bricks. The game progresses through various levels, with increasing difficulty, and includes graphical elements and player input handling.

---

## Game Description

The **Arkanoid** game is based on the classic arcade game where the player uses a paddle to hit a ball and break a grid of bricks. The goal is to break all the bricks in each level without letting the ball fall off the screen. Features of the game include:

- **Paddle**: The player controls the paddle to bounce the ball.
- **Ball**: The ball bounces off walls and the paddle, destroying bricks when it makes contact.
- **Bricks**: When hit by the ball, bricks are destroyed and the player earns points.
- **Levels**: The game progresses through multiple levels with increasing difficulty.
- **Score**: Players earn points by breaking bricks and completing levels.

---

## How to Clone and Run the Project

Follow these steps to clone the repository, compile the source files, and run the game on your local machine.

### 1. **Clone the Repository**

Run the following command in your terminal to clone the repository:

```bash
git clone -b master https://github.com/davidNidam1/Arkanoid.git
```

This clones the repository from the master branch to your local machine.

### 2. **Navigate to the Project Directory**

Move into the project folder using the command:
```bash
cd Arkanoid
```

### 3. Open the Project in VS Code
If you are using Visual Studio Code, you can open the project with:
```bash
code .
```

### 4. Compile the Java Source Files
Compile all the Java files in the `src` directory, and output the compiled `.class` files to the `bin` directory. Use the following command:
```bash
javac -d bin -cp "biuoop-1.4.jar" src\*.java src\**\*.java
```
Explanation:
`javac:` The Java compiler.
`-d bin:` Specifies the output directory for compiled files (`bin`).
`-cp "biuoop-1.4.jar"`: Adds the `biuoop-1.4.jar` library (required for GUI and input handling) to the classpath.
`src\*.java src\**\*.java`: Includes all Java files in the `src` directory and subdirectories.

### 5. Run the Game
After compiling the files, run the game using the following command:
```bash
java -cp "bin;biuoop-1.4.jar" ./src/Ass6Game
```
Explanation:
`java`: The Java runtime command to execute the program.
`-cp "bin;biuoop-1.4.jar"`: Specifies the classpath for the compiled files (bin) and the required `biuoop-1.4.jar` library.
`./src/Ass6Game`: Points to the entry class containing the `main` method.

---

## Why These Commands Are Important
1. `git clone`: Downloads the project files to your local machine from the repository.
2. `cd Arkanoid`: Positions you in the correct working directory.
3. `code` .: Opens the project for editing or inspection in Visual Studio Code.
4. `javac`: Compiles the source code into .class files, converting human-readable Java code into bytecode runnable by the JVM.
5. `java`: Executes the compiled Java program, launching the Arkanoid game.
