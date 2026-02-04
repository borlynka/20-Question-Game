//Borlynka Xiang and Analeigh Wagner
//Period 7
//Description:
import java.io.*;
import java.util.*;


public class QuestionsGame {
    QuestionNode game;

    // Your code here

    public static class QuestionNode<E> {
        public final E data;
        public QuestionNode<E> left;
        public QuestionNode<E> right;

        //constructs a leaf node with given data
        public QuestionNode(E data){
            this(data,null,null);
        }

        //constructs a node with the given data and links
        public QuestionNode(E data, QuestionNode<E> left, QuestionNode<E> right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public QuestionsGame(String object){
        QuestionNode game = new QuestionNode(object);

    }

     public QuestionsGame(Scanner input) {
    	Scanner key = new Scanner(System.in);
    	game = readTree(input);
    }
    private QuestionNode readTree(Scanner input) {
        String type = input.nextLine();   //Q: or A:
        String text = input.nextLine();   //actual question or answer
        
        //leaf node - answer
        if (type.equals("A:")) {
            return new QuestionNode(text);
        } 
        else {
            //branch node - question
            QuestionNode yesBranch = readTree(input);
            QuestionNode noBranch = readTree(input);
            return new QuestionNode(text, yesBranch, noBranch);
        }
    }
    
    public void saveQuestions(PrintStream output){  

        if(output== null){
            throw new IllegalArgumentException();
        }

        questiontree(output, game);


    }
     
    private void questiontree(PrintStream output,QuestionNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right ==null){
            output.println("A");
            output.println(root.data);
        }else{
            output.println("Q");
            output.println(root.data);
        }
        

        questiontree(output,root.left);
        questiontree(output,root.right);


    }


    public void paly(){
        gametree(game, null,false);

    }

    private void gametree(QuestionNode root, QuestionNode prev, boolean where){
        
        Scanner scanner = new Scanner(System.in);
        //leaf
        if(root.left == null && root.right == null){
            System.out.println("I guess that your object is "+root.data);
            System.out.println("Am I right? (y/n)");
            //if start with y for answers
            if(scanner.nextLine().trim().toLowerCase().startsWith("y")){
                System.out.println("Awesome! I win!");
            }else{ //response =="n"
                System.out.println("Boo! I Lose. Please help me get better!");
                System.out.println("What is your object?");
                QuestionNode newanswer =  new QuestionNode(scanner.nextLine());
                System.out.println("Please give me a yes/no question that distinguishes between " + newanswer + " and "+root.data+".\nQ: ");
                QuestionNode newquestion = new QuestionNode(scanner.nextLine());
                System.out.println("Is the answer \"yes\" for "+ newanswer + "? (y/n)");
                Boolean decision = false;
                if(scanner.nextLine().trim().toLowerCase().startsWith("y")){
                    decision = true;
                }

                add(prev, root,newquestion, newanswer,where, decision );
                //add to the tree with a add method

            }
        }else{
            System.out.println(root.data + "(y/n)?");
            //if start with y
            if(scanner.nextLine().trim().toLowerCase().startsWith("y")){
                gametree(root.left, root, true);
            }else{
                gametree(root.right, root, false);
            }
        }
    }


    private void add(QuestionNode prev, QuestionNode root, QuestionNode question, QuestionNode answer, boolean where, boolean decision){   

            

        if(decision){
            question.left = answer;
            question.right = root;
        }else{
            question.right = answer;
            question.left = root;
        }
    
        if(where){ //where it come from the mama y/n?
            prev.left = question;
        }else{
            prev.right = question;
        }


            
    }

}

