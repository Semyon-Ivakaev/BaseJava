package out.homework8;

import java.util.ArrayList;
import java.util.List;

public class ClientsGenerator implements IndividualGenerator, EntityGenerator {

    public List<Client> generateClientsArray(int countClients) {
        List<Client> clients = new ArrayList<>();

        for (int i = 0; i < countClients; i++) {
            clients.add(generateIndividual(i));
            if (i + 1 != countClients) {
                clients.add(generateEntity(i + 1));
                i++;
            }
        }
        return clients;
    }

    @Override
    public Individual generateIndividual(int id) {
        return new Individual(id);
    }

    @Override
    public Entity generateEntity(int id) {
        return new Entity(id);
    }
}
