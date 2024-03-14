package _12_java_collection_framework.exercise.e1.advance;

import java.io.IOException;
import java.util.Optional;

public class Menu {
    private static GenericService generalService = new GenericService();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Optional<RunTimeClass> opRunTimeClass = CommonUtil.jSonToClass("src/_12_java_collection_framework/exercise/e1/advance/t.json").stream().findFirst();

        if(opRunTimeClass.isPresent()) {
            while(true){
                System.out.println("----- Menu " + opRunTimeClass.get().getEntityName() + " -----");
                System.out.println("1. Create\n2. Update\n3. Delete\n4. Display\n5. Search\n6. Sort");
                int choice = Integer.parseInt(CommonUtil.inputWithoutEmpty("Enter your choice"));

                switch (choice) {
                    case 1:
                        create(opRunTimeClass.get());
                        break;
                    case 2:
                    update(opRunTimeClass.get());
                        break;
                    case 3:
                    delete(opRunTimeClass.get());
                        break;
                    case 4:
                    display(opRunTimeClass.get());
                        break;
                    case 5:
                    search(opRunTimeClass.get());
                        break;
                    case 6:
                    sort(opRunTimeClass.get());
                        break;
                    case 7:
                        System.exit(0);
                }
            }
        }
    }

    private static void sort(RunTimeClass runTimeClass) {
        String fieldSort = runTimeClass.getSort().get("by");
        boolean isDESC = runTimeClass.getSort().get("dir").equals("DESC");
        generalService.sort(fieldSort, isDESC);
        System.out.println("Sorted successfully...");
    }

    private static void search(RunTimeClass runTimeClass) {
        String val = CommonUtil.inputWithoutEmpty("Input " +  runTimeClass.getSearchBy() + " to search");
        generalService.search(runTimeClass.getSearchBy(), val).forEach(System.out::println);
    }

    private static void delete(RunTimeClass runTimeClass) {
        int id = Integer.parseInt(CommonUtil.inputWithoutEmpty("Enter id to delete"));
        generalService.delete(id);
        System.out.println("Deleted successfully...");
    }

    private static void display(RunTimeClass runTimeClass) {
        System.out.println("----- List " + runTimeClass.getEntityName()  + "-----");
        generalService.findAll().forEach(System.out::println);
    }

    private static void update(RunTimeClass runTimeClass) {
        Object o = CommonUtil.createInstance(runTimeClass, CommonUtil.inputFields(runTimeClass));
        generalService.update(o);
        System.out.println("Updated successfully...");
    }

    private static void create(RunTimeClass runTimeClass) {
        Object o = CommonUtil.createInstance(runTimeClass, CommonUtil.inputFields(runTimeClass));
        generalService.create(o);
        System.out.println("Created successfully...");
    }
}
