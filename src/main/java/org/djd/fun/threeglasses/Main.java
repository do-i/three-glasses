package org.djd.fun.threeglasses;

public class Main {

   public static void main(String[] args) {

      Node root = new Node(null, 8, 0, 0);
      TreeCreator treeCreator = new TreeCreator(root);
      treeCreator.create();
      treeCreator.traverse();
      
   }
}
