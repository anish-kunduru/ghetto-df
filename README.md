# ghetto-df
A simple program to get all the files located under a given mountpoint and print the list to console.

## Requirements
1. Java is installed on your system.
2. Maven is installed on your system.
3. The specified mountpoint must exist.

### Running the Demo
1. From the root directory where the POM file is located, run `mvn clean install` to build the Java jar.
2. Navigate to the folder where the jar was build. By default, it will be located in the target directory.
3. Run the program by using `java -jar ghettoDf.jar /folder` Note that the passed argument is the folder under which you wish to find the files.