package out.homework4;

import java.util.*;

public class Homework4 {
    public static void main(String[] args) {
        ClientsGenerator clientsGenerator = new ClientsGenerator();
        Client[] clients = clientsGenerator.generateClientsArray(20);
        String sortedType = "М";
        List<Individual> individuals = sorting(clients, sortedType);

        for (Client el: individuals) {
            System.out.println(el.toString());
        }
    }

    public static List<Individual> sorting(Client[] arr, String sortedType) {
        List<Individual> list = new ArrayList<>();

        for (Client element: arr) {
            if (element instanceof Individual && ((Individual) element).getSex().equals(sortedType)) {
                list.add((Individual) element);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getYear() > list.get(j).getYear()) {
                    Individual client = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, client);
                }
            }
        }

        return list;
    }

    /**
     * Не требуется, так как задание изменилось.
     * @param arr
     * @return
     */
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

    /**
     * Не требуется, так как задание изменилось.
     * @param arr
     * @param sortedType
     * @return
     */
    public static List<Individual> returnSortedIndividualListWithType(Individual[] arr, String sortedType) {
        List<Individual> list = new ArrayList<>();
        for (Individual el: arr) {
            if (el.getSex().equals(sortedType)) {
                list.add(el);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getYear() > list.get(j).getYear()) {
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
