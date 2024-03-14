package _12_java_collection_framework.exercise.s_1_2_3_4;

public class Test {
  public static void main(String[] args) {
    CustomBST<Integer> customBST = new CustomBST<>();
    customBST.add(1);
    customBST.add(2);
    customBST.add(5);
    customBST.add(3);
    customBST.add(8);
    customBST.delete(8);
    customBST.traversePostOrder(customBST.getRoot());
  }
}
