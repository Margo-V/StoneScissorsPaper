package mavl.com.game;

import java.util.*;

class Items{
    enum ItemsList {STONE, SCISSORS, PAPER, UNKNOWN}

    static ArrayList<ItemsList> getItems(){
        ArrayList<ItemsList> arr = new ArrayList<>();
        Collections.addAll(arr, ItemsList.values());
        arr.remove(ItemsList.UNKNOWN);
        return arr;
    }
    static int getSizeOfItems(){
        return ItemsList.values().length;
    }
}

interface Answers{
//    static ArrayList<Items.ItemsList> getListOfAnswers();
//    void setAnswer(Items.ItemsList value);
//    Items.ItemsList getAnswer();
}

abstract class Player implements Answers{
    String name;
    Items.ItemsList answer;

//    public void setAnswer(Items.ItemsList value){}
//    public Items.ItemsList getAnswer(){}
}

class Robot extends Player{
    Items.ItemsList answer;
    int resultRobot;
    String robotName;
    ArrayList<String> names = new ArrayList<>(List.of("Simon", "Jerry", "Johnny", "Archer"));
    static ArrayList<Items.ItemsList> robotListOFAnswers;
    Robot(){
        resultRobot=0;
        robotListOFAnswers = new ArrayList<>();
    }
    void setName(){
        robotName= String.valueOf(names.get((int) (Math.random()*names.size()-1)));
    }
    public void makeListAnswers(Items.ItemsList element){
        robotListOFAnswers.add(element);
    }
    int generateNum(){
        return (int) (Math.random()*(Items.getSizeOfItems() -1));
    }
    String getName(){return robotName;}
    public ArrayList<Items.ItemsList> getListOfAnswers(){
        return robotListOFAnswers;
    }
    Items.ItemsList getItemOfList(int i){
        return robotListOFAnswers.get(i);
    }

}

class User extends Player{
    int resultUser;
    Items.ItemsList answer;
    String userName;
    static final ArrayList<Items.ItemsList> userListOFAnswers= new ArrayList<>();
    User(){}
    public static void makeListAnswers(Items.ItemsList element){
        userListOFAnswers.add(element);
    }
//    getListAnswers()
    void setName(String name){
        userName = name;
    }
    String getName(){return userName;}
    public static ArrayList<Items.ItemsList> getListOfAnswers(){
        return userListOFAnswers;
    }

}


class Game{
    int resultUser;
    Robot robot;
    User user;
    Game(){
        robot = new Robot();
        user = new User();
    }
    static boolean checkUserAnswer(String answer){
        boolean check = true;
        try{
            Items.ItemsList.valueOf(answer);
        } catch(IllegalArgumentException e){
            check=false;
        }
        return check;
    }
    static Items.ItemsList getUserAnswer(String answer){
        if (checkUserAnswer(answer) == true) {
            User.makeListAnswers(Items.ItemsList.valueOf(answer));
            return Items.ItemsList.valueOf(answer);
        }else
        {
            User.makeListAnswers(Items.ItemsList.valueOf("UNKNOWN"));
            return Items.ItemsList.valueOf("UNKNOWN");
        }
    }
    Items.ItemsList getRobotAnswer(){
        Items.ItemsList answerRobot =Items.ItemsList.values()[this.robot.generateNum()];
        robot.makeListAnswers(answerRobot);
        return answerRobot;
    }
    int generateQueue(){
        return (int) (Math.random()*2);
    }
    void takePause(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {}
    }
    String compareAnswersOfPlayers(){
        ArrayList<Items.ItemsList> userArray= user.getListOfAnswers();
        ArrayList<Items.ItemsList> robotArray = robot.getListOfAnswers();
        for(int i =0; i<robot.getListOfAnswers().size();i++){
            if((userArray.get(i) == Items.ItemsList.valueOf("SCISSORS") ) &&
                    (robotArray.get(i) == Items.ItemsList.valueOf("PAPER"))){
                user.resultUser+=1;
                return "You win!";
            }else if ((userArray.get(i) == Items.ItemsList.valueOf("STONE") ) &&
                    (robotArray.get(i) == Items.ItemsList.valueOf("SCISSORS"))){
                user.resultUser+=1;
                return "You win!";
            }else if ((userArray.get(i) == Items.ItemsList.valueOf("PAPER") ) &&
                    (robotArray.get(i) == Items.ItemsList.valueOf("STONE"))) {
                user.resultUser+=1;
                return "You win!";
            }else if(userArray.get(i) == Items.ItemsList.valueOf("UNKNOWN")){
                System.out.println("User failed");
            }
            else if (userArray.get(i) == robotArray.get(i)) {
                return "You and robot WIN! A DRAW!";
            }else{
                robot.resultRobot+=1;
                return "Robot WIN!";
            }
        }
        return "";
    }
    void getResult(){

    }
}