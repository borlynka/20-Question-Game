// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.

import java.io.*;


public class QuestionsGame {
    QuestionNode game;
    // Your code here

    private static class QuestionNode {
        public final String data;
        public QuestionNode left;
        public QuestionNode right;

        //constructs a leaf node with given data
        public QuestionNode(String data){
            this(data,null,null);
        }

        //constructs a node with the given data and links
        public QuestionNode(String data, QuestionNode left, QuestionNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public QuestionsGame(String object){
        QuestionNode game = new QuestionNode(object);

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
        
        if(root.left != null){
            questiontree(output,root.left);
        }
        if(root.right != null){
            questiontree(output,root.right);
        }

    }
}
