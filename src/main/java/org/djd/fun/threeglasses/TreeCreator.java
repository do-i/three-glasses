package org.djd.fun.threeglasses;

import java.util.LinkedList;
import java.util.Queue;

public class TreeCreator {
   final static int GOAL_FIRST = 4;
   final static int GOAL_SECOND = 4;
   final static int GOAL_THIRD = 0;

   Queue<Node> q = new LinkedList<Node>();

   public TreeCreator(Node root) {
      q.add(root);

   }

   /**
    * create possible moves Node and add to root node.
    */
   public void create() {

      while (!q.isEmpty()) {
         Node node = q.remove();
         produceChildren(node);
         q.addAll(node.children);
      }

   }

   /**
    * produce as many children as possible and add to {@link Node#children}
    * list.
    * 
    * @param node
    */
   private void produceChildren(Node node) {

      node.addChild(node.pourFirstToSecond());
      node.addChild(node.pourFirstToThird());
      node.addChild(node.pourSecondToFirst());
      node.addChild(node.pourSecondToThird());
      node.addChild(node.pourThirdToFirst());
      node.addChild(node.pourThirdToSecond());

   }

}
