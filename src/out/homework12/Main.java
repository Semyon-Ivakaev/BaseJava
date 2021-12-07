package out.homework12;

import out.homework12.api.DataItem;
import out.homework12.api.DeleteUserResponse;
import out.homework12.api.Response;
import out.homework12.api.User;
import out.homework12.api.requests.Requests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Response object = Requests.getMapper().readValue(Requests.getUsersInfo(1), Response.class);

        List<DataItem> allUsers = getUsers(object.getTotalPages());

        List<Integer> usersForDelete = getUsersIdForDelete(allUsers, "George");
        List<User> deleteUsers = deleteSomeUsers(usersForDelete);

        createSomeUsers(deleteUsers);
    }

    public static List<DataItem> getUsers(int pages) throws IOException, InterruptedException {
        List<DataItem> users = new ArrayList<>();

        for (int page = 1; page <= pages; page++) {
            Response object = Requests.getMapper().readValue(Requests.getUsersInfo(page), Response.class);
            users.addAll(object.getData());
        }

        return users;
    }

    public static List<Integer> getUsersIdForDelete(List<DataItem> users, String neededName) {
        List<Integer> neededUsers = new ArrayList<>();
        users.forEach(user -> {
            if (user.getFirstName().equals(neededName)) {
                neededUsers.add(user.getId());
            }
        });
        return neededUsers;
    }

    public static List<User> deleteSomeUsers(List<Integer> usersId) {
        List<User> deleteUsers = new ArrayList<>();

        usersId.forEach((id) -> {
            try {
                DeleteUserResponse object = Requests.getMapper().readValue(Requests.getDeleteUserState(id), DeleteUserResponse.class);
                int deleteStatus = Requests.deleteUser(id);

                if (deleteStatus == 204) {
                    System.out.println(String.format("User with id=%d, delete success!", id));
                } else if (deleteStatus < 200 || deleteStatus > 299){
                    throw new Exception(String.format("Error delete user: %d", id));
                } else {
                    System.out.println("Request success, but request code != 204");
                }

                User user = new User();
                user.setId(object.getData().getId());
                user.setEmail(object.getData().getEmail());
                user.setFirstName(object.getData().getFirstName());
                user.setLastName(object.getData().getLastName());
                user.setAvatar(object.getData().getAvatar());

                deleteUsers.add(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return deleteUsers;
    }

    public static void createSomeUsers(List<User> users) {
        users.forEach(user -> {
            try {
                int createStatus = Requests.createUser(user);
                if (createStatus == 201) {
                    System.out.println("User: " + user + "\nCreate Success!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
