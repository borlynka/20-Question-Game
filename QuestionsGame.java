// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.

public class QuestionsGame {
    // Your code here

    private static class QuestionNode {
        public String data;
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
}
