package mavl.com.game;

import java.util.*;

class Items{
    enum ItemsList {STONE, SCISSORS, PAPER}

    Items(int itemNumber) {
        ItemsList il = ItemsList.values()[itemNumber];
    }
    void printItem(){
        for(int i=0; i<ItemsList.values().length;i++){
            System.out.println((i+1) + " " +ItemsList.values()[i]);

        }
    }
}

interface Answers{
    void getAnswer();
}

abstract class Player implements Answers{
    String answer;

    public Player(){}
}

class User extends Player{
    User(){
        Scanner sc = new Scanner(System.in);
        answer=sc.nextLine().toLowerCase();
    }
    @Override
    public void getAnswer(){
        System.out.println();
    }
}


class Robot extends Player{
    Robot(){
        answer = "1";
    }
    public void getAnswer(){
        System.out.println();
    }
}
class StoneScissorsPaper{
    void print(){
        Items items= new Items(0);
        System.out.println();
    }
}


/*
class StoneScissorsPaper {
    ArrayList<String> arr=
            new ArrayList<String>(List.of("Stone", "Scissors", "Paper"));

    String user;
    String robot;

    String getWinner(String user, String robot){
        if (user.equals(robot)){
            return "A draw!";
        }
        else if( (user.equals("Stone") && robot.equals("Scissors")) ||
                (user.equals("Scissors") && robot.equals("Paper")) ||
                (user.equals("Paper") && robot.equals("Stone"))
        ){
            return "You won!";
        }
        else{
            return "Robot";
        }
    }

    String playerChoice(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println((i + 1) + " " + arr.get(i));
        }
        String choice= sc.nextLine();

        switch(choice){
            case "1":
                return arr.get(0);
            case "2":
                return arr.get(1);
            case "3":
                return arr.get(2);
            default:
                return "0";
        }
    }

    String robotChoice(){
        return arr.get((int)(Math.random()*(arr.size()-1)));
    }
    void play(){
        System.out.println("Let's start! The first player will be:");
        int playerQueue=(int) (Math.random()*2);

        if (playerQueue==1) {
            System.out.println("You first! Choose number of item: ");
            user = playerChoice();
            if (user.equals("0")) {
                System.out.println("nothing found :(");
                start();
            } else {
                System.out.println("Your answer: " + user);
                System.out.println("\nRobot's making choose...");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException ex) {
                }
                robot = robotChoice();
                System.out.println("Your answer: " + user + "\nRobot answer: " + robot);
                System.out.println("WINNER: " + getWinner(user, robot));

            }
        }
        else{
            System.out.print("Robot first!");
            try{
                Thread.sleep(4000);
            }catch (InterruptedException ex){}
            robot=robotChoice();
            System.out.println( "Robot have chosen item! \nLet's you! Choose number of item: ");
            user = playerChoice();
            if (user.equals("0")) {
                System.out.println("nothing found :(");
                start();
            } else {
                System.out.println("Your answer: " + user + "\nRobot's answer: " + robot);
                System.out.println("WINNER: " + getWinner(user, robot));
            }
        }


    }
    void start(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Hello!");
        while (true) {
            System.out.println("\nWould you like to play game with me? (yes/no):");
            String answer = sc.nextLine().toLowerCase();
            System.out.println();
            if (answer.equals("yes")) {
                play();
            } else {
                System.out.println("Oh ok, bye;)");
                break;
            }
        }



    }
}
*/