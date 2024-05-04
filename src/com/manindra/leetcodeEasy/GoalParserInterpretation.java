package com.manindra.leetcodeEasy;

public class GoalParserInterpretation { //solution 1678

    public static void main(String[] args) {

        String command1 = "G()(al)";
        String command2 = "(al)G(al)()()G";
        String command3 = "()G";
        String command4 = "(G)";

        System.out.println("Interpretation 1: " + interpret(command1));
        System.out.println("Interpretation 2: " + interpret(command2));
        System.out.println("Interpretation 3: " + interpret(command3));
        System.out.println("Interpretation 4: " + interpret(command4));

        System.out.println("Interpretation (Solution Two) 1: " + interpretSolutionTwo(command1));
        System.out.println("Interpretation (Solution Two) 2: " + interpretSolutionTwo(command2));
        System.out.println("Interpretation (Solution Two) 3: " + interpretSolutionTwo(command3));
        System.out.println("Interpretation (Solution Two) 4: " + interpretSolutionTwo(command4));
    }

    static String interpret(String command) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G')
                sb.append("G");
            else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')')
                    sb.append('o');
                else if (command.charAt(i + 1) == 'a') {
                    sb.append("al");
                }
            }
        }
        return sb.toString();
    }

    static String interpretSolutionTwo(String command) {

        String result = "";
        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);

            if (ch == 'G') {
                result += "G";
            } else if (ch == '(' && command.charAt(i + 1) == ')') {
                result += 'o';
                i++;
            } else {
                result += "al";
                i += 3;
            }
        }
        return result;
    }
}
