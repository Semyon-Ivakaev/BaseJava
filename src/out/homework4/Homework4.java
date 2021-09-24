package out.homework4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework4 {
    public static void main(String[] args) {
        Data data = new Data();
        String sortedType = "М";

        List<Individual> individualArray = returnSortedIndividualListWithType(data.individual, sortedType);
        List<Entity> entityList = returnSortedEntity(data.entity);


        for (Client el: individualArray) {
            System.out.println(el.toString());
        }
        System.out.println("----------------------");
        for (Client el: entityList) {
            System.out.println(el.toString());
        }
    }

    public static List<Entity> returnSortedEntity(Entity[] arr) {
        List<Entity> list = new ArrayList<>(Arrays.asList(arr));

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getName().compareToIgnoreCase(list.get(j).getName()) > 0) {
                    Entity client = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, client);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(i);
                }
            }
        }

        return list;

    }

    public static List<Individual> returnSortedIndividualListWithType(Individual[] arr, String sortedType) {
        List<Individual> list = new ArrayList<>();
        for (Individual el: arr) {
            if (el.getSex().equals(sortedType)) {
                list.add(el);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getAge() > list.get(j).getAge()) {
                    Individual client = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, client);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(i);
                }
            }
        }

        return list;
    }
}
