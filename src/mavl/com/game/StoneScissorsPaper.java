package mavl.com.game;

import java.util.*;

class Items{
    enum ItemsList {STONE, SCISSORS, PAPER}
    public static ItemsList getItem(String getItem){
        try {
            return ItemsList.valueOf(getItem);
        }
        catch (IllegalArgumentException ex){
            return null;
        }
    }
    static void printItem(){
        for(int i=0; i<ItemsList.values().length;i++){
            System.out.println(ItemsList.values()[i]);
//            System.out.println((i+1) + " " +ItemsList.values()[i]);
        }
    }
}

interface Answers{
    void setAnswer();
    Items.ItemsList getAnswer();
}

abstract class Player implements Answers{
    Items.ItemsList answer;

    public Player(){}
}

class User extends Player{
    User(){}
    @Override
    public void setAnswer(){
        Scanner sc = new Scanner(System.in);
        answer= Items.getItem(sc.nextLine().toUpperCase());

    }
    public Items.ItemsList getAnswer(){
        return answer;
    }
    boolean checkAnswer(Items.ItemsList answer){
        return answer!=null ? true:false;
    }

}


class Robot extends Player{
    Robot(){

    }
    public void setAnswer(){
        answer=Items.ItemsList.values()[(int) (Math.random()*(Items.ItemsList.values().length-1))];
    }
    public Items.ItemsList getAnswer(){
        return answer;
    }
}
class StoneScissorsPaper{
    void print(){
        System.out.println("Let's start!");
//        System.out.println("The first player will be:");
        Robot robot = new Robot();
        robot.setAnswer();
        Items.ItemsList answerRobot = robot.getAnswer();
//        System.out.println(answerRobot);
        System.out.println("\nChoose item: ");
        Items.printItem();
        User user =new User();
        user.setAnswer();
        Items.ItemsList answerUser = user.getAnswer();
        if(user.checkAnswer(answerUser)){
            System.out.println("Your answer: " + answerUser);
        }else{
            System.out.println("Nothing found");
        }
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