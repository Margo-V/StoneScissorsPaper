package mavl.com.game;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Robot robot = new Robot();
        robot.setName();
        User user =new User();


        ArrayList<Items.ItemsList> arrItems = Items.getItems();
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello! Welcome to \" Scissors, stone, paper\" game!");
        System.out.println("What's your name?");
        String name = sc.nextLine();
        user.setName(name);
        String str = String.format("Nice to see you, %s! ", name);
        System.out.print(str);
        String str1 = String.format("%s will play against you.", robot.getName());
        System.out.println(str1);
        System.out.println("Now, it will be chosen who will be the first!");


        String str2 = String.format("%s making choice ... ", robot.getName());
        String str3= String.format("%s have chosen item! ", robot.getName());
        String str4 = String.format("%s's answer is ", robot.getName());
        if(game.generateQueue()==1) {
            System.out.println(String.format("%s first!", robot.getName()));
            System.out.println(str2);
            game.getRobotAnswer();
            game.takePause();
            System.out.println(str3);
            System.out.println("Let's you! Choose number of item: ");

            for (int i =0; i <arrItems.size(); i++){
                System.out.println(arrItems.get(i));
            }
            String answer = sc.nextLine().toUpperCase();
            game.getUserAnswer(answer);
            System.out.println("\nYou answer is " + User.getListOfAnswers().get(0));
            System.out.println(str4 + robot.getListOfAnswers().get(0));

            System.out.println("\n\t\t" +game.compareAnswersOfPlayers().toUpperCase().replace("ROBOT", robot.getName()));

        }else{
            System.out.println("You first!");
            System.out.println("Choose number of item: ");

            for (int i =0; i <arrItems.size(); i++){
                System.out.println("\t"+arrItems.get(i));
            }
            String answer = sc.nextLine().toUpperCase();
            game.getUserAnswer(answer);
            System.out.println(str2);
            game.getRobotAnswer();
            game.takePause();
            System.out.println("\nYou answer is " + User.getListOfAnswers().get(0));
            System.out.println(str4 + robot.getListOfAnswers().get(0));
            System.out.println("\n\t\t" + game.compareAnswersOfPlayers().toUpperCase().replace("ROBOT", robot.getName()));
        }

    }
}
