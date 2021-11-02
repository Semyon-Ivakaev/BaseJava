package out.homework8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Homework8 {
    public static void main(String[] args) {
        ClientsGenerator clientsGenerator = new ClientsGenerator();
        List<Client> clients = clientsGenerator.generateClientsArray(20);
        String sortedType = "М";
        List<Individual> individuals = sorting(clients, sortedType);

        for (Client el: individuals) {
            System.out.println(el.toString());
        }
    }

    public static List<Individual> sorting(List<Client> clientsList, String sortedType) {
        List<Individual> list = new ArrayList<>();

        for (Client element: clientsList) {
            if (element instanceof Individual && ((Individual) element).getSex().equals(sortedType)) {
                list.add((Individual) element);
            }
        }

        Collections.sort(list);
        return list;
    }
}
