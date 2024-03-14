package _10_dsa_list.exercise.e1_impl_arraylist;

public class Test {
  public static void main(String[] args) {
    CustomArrayList<Integer> arrayList = new CustomArrayList<>();
    arrayList.add(1);
    // qg
    arrayList.remove(0);
    arrayList.add(2);
    arrayList.add(3);
    arrayList.add(6);
    arrayList.add(2, 23);

    System.out.println(arrayList.contains(6));
    System.out.println(arrayList.indexOf(3));
    System.out.println(arrayList.size());
//    arrayList.clear();

    try {
      CustomArrayList<Integer> arrayClone = (CustomArrayList<Integer>) arrayList.clone();
      for (int i = 0; i < arrayClone.size(); i++) {
        System.out.println(arrayClone.get(i));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
