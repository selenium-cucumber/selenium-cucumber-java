package entities.factories;

import java.util.ArrayList;
import java.util.List;

import com.harmonia.qa.Utilities.RandomDataGenerators.RandomStringGenerator;
import com.harmonia.qa.webdriver.utilities.PasswordGenerator;

import entities.User;

public class UserFactory {

	/**
	 * Static instance of PasswordGenerator
	 */
	public static PasswordGenerator passwordGenerator = new PasswordGenerator();

	/**
	 * Generates a random username string
	 *
	 * @return a random username string
	 */
	public static String generateRandomUsername() {
		return RandomStringGenerator.nextString(20, true);
	}

	/**
	 * Creates the specified number of random user entities
	 *
	 * @param number the number of random user entities to create
	 * @param admin set to true to get admin users, false for regular
	 * @return a list of randomized user entities
	 */
	public static List<User> createRandomUsers(int number, boolean admin) {
		List<User> users = new ArrayList<User>(0);
		for (int i = 0; i < number; i++) {
			User newUser = new User(false);
			newUser.setUsername(generateRandomUsername());
			newUser.setPassword(passwordGenerator.getRandomPassword());
			users.add(newUser);
		}
		return users;
	}
}
