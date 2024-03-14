package _10_dsa_list.exercise.e2_impl_linkedlist;

public class Test {
    public static void main(String[] args) {
        CustomLinkedList<String> customLinkedList= new CustomLinkedList<>();
        customLinkedList.addFirst("2");
        customLinkedList.addFirst("1");
        customLinkedList.addLast("3");
        customLinkedList.add(1, "CodeGym");

        System.out.println(customLinkedList.contains("3"));
        System.out.println(customLinkedList.getFirst());
        System.out.println(customLinkedList.getLast());
        System.out.println(customLinkedList.get(1));
        System.out.println(customLinkedList.contains("2"));
        System.out.println(customLinkedList.indexOf("3"));

        customLinkedList.remove(1);

        try {
            CustomLinkedList<String> tmp= (CustomLinkedList<String>)customLinkedList.clone();
            int size= tmp.size();
            for (int i = 0; i < size; i++) {
                System.out.println(tmp.get(i));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
