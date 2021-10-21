package out.homework4;

public class ClientsGenerator implements IndividualGenerator, EntityGenerator {

    public Client[] generateClientsArray(int countClients) {
        Client[] clients = new Client[countClients];

        for (int i = 0; i < countClients; i++) {
            clients[i] = generateIndividual(i);
            if (i + 1 != countClients) {
                clients[i + 1] = generateEntity(i + 1);
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
