package org.djd.fun.threeglasses;

import java.util.LinkedList;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TreeCreator {

   private static final Logger LOG = LoggerFactory.getLogger(TreeCreator.class);
   private static final Node GOAL_NODE = new Node(null, 4, 4, 0);

   Node root;

   /**
    * this is to hold reference to the goal node
    */
   Node leafGoalNode;

   public TreeCreator(Node root) {
      this.root = root;

   }

   /**
    * quit loop as soon as first goal node is found. create possible moves Node
    * and add to root node.
    */
   public void create() {
      Queue<Node> q = new LinkedList<Node>();
      q.add(root);
      while (!q.isEmpty()) {
         LOG.debug("Q-size:{}", q.size());
         Node node = q.remove();

         if (goalReached(node)) {
            leafGoalNode = node;
            LOG.info("Goal Reached.");
            break;
         }
         produceChildren(node);
         q.addAll(node.children);
      }

   }

   private boolean goalReached(Node node) {
      return GOAL_NODE.isSame(node);
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

   public void traverse() {

      if (null == leafGoalNode) {
         throw new IllegalStateException("No leaf Goal node found yet.");
      }

      for (Node currNode = leafGoalNode; null != currNode; currNode = currNode.parent) {
         LOG.info("{}", currNode);
      }
   }

}
