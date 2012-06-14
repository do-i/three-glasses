package org.djd.fun.threeglasses;

import java.util.ArrayList;
import java.util.List;

public class Node {

   final static int MAX_FIRST = 8;
   final static int MAX_SECOND = 5;
   final static int MAX_THIRD = 3;
   /**
    * null indicates this node is a root node.
    */
   Node parent;
   int first;
   int second;
   int third;

   /**
    * no children indicates this is a leaf node.
    */
   List<Node> children = new ArrayList<Node>();

   public Node(Node parent, int first, int second, int third) {
      super();
      this.parent = parent;
      this.first = first;
      this.second = second;
      this.third = third;
   }

   public void add(Node child) {
      children.add(child);
   }

   private boolean isSame(Node node) {
      boolean sameNode = true;
      sameNode &= this.first == node.first;
      sameNode &= this.second == node.second;
      sameNode &= this.third == node.third;

      return sameNode;
   }

   /**
    * 
    * @param ancestor
    * @return false means this node is uniquely exist (keep this). true means
    *         duplicate node already exists in ancestor (dump this)
    */
   public boolean existInAncestors(Node ancestor) {
      if (null == ancestor) {
         return false;
      }

      if (isSame(ancestor)) {
         return true;
      } else {
         return existInAncestors(ancestor.parent);
      }
   }

   /**
    * pour first to second and result state is created as new {@link Node} instance.
    * 
    * @return new instance of {@link Node} which state is after pour right
    *         amount from one glass to another. <code>null</code> if none is poured.
    */
   Node pourFirstToSecond() {
      Node child = null;
      int moveAmount = moveAmount(first, second, MAX_SECOND);
      if (0 != moveAmount) {
         child = new Node(this, first - moveAmount, second + moveAmount, third);
      }

      return child;
   }

   int moveAmount(int sourceAmount, int destinationAmount, int maxDestinationAmount) {
      return Math.min(sourceAmount, maxDestinationAmount - destinationAmount);
   }

}
