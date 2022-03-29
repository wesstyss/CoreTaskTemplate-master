package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private final static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {
        userService.createUsersTable();

        userService.saveUser("Руслан", "Хайруллин", (byte) 21);
        userService.saveUser("Эмиль", "Нигматуллин", (byte) 26);
        userService.saveUser("Антон", "Зорин", (byte) 19);
        userService.saveUser("Дмитрий", "Хохлов", (byte) 21);

        userService.removeUserById(2);

        userService.getAllUsers();

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
