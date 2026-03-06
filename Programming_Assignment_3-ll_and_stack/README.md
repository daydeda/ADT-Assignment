# Infix to Postfix Converter

Name: Puri Sangnawakit
Student ID: 682115036

## Compilation Instructions
To compile the program, navigate to the directory containing the source files and run the following command:

```bash
javac Node.java Stack.java InfixToPostfix.java
```

## Running the Program
After compiling, you can run the program by providing the input file as a command-line argument. `input1.txt` is an example input file provided for testing.

```bash
java InfixToPostfix input1.txt
```

## Example Output
Below is an example of the program's terminal output when running against the sample `input1.txt`:

```text
Expression 1:
Infix exp:a-b/(c+d-e)*(f^g*h+i)
Valid
Postfix exp: abcd+e-/fg^h*i+*-

Expression 2:
Infix exp:1+2+3^4**
Not-Valid
```
