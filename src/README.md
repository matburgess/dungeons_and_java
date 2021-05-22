From the home directory, use the following commands:

Build the files by using the command:
    find ./src -name '*.java' | xargs javac -d ./out/

Run the game by using the command:
    java -classpath ./out game.Dungeon

Build the documentation by running the command:
    javadoc -d ./docs -sourcepath ./src -subpackages game:validation:utility