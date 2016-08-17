package entities.utitities;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;

import com.harmonia.qa.Entities.BaseEntity;
import com.harmonia.qa.Entities.Utilities.EntityManager;

import entities.User;

/**
 * Entity manager for cucumber tests
 *
 * @author jfoley
 */
public class CucumberEntityManager {

	/**
	 * Private constructor to prevent construction
	 */
	private CucumberEntityManager() {
	}

	/**
	 * Gets the current list of entities. If the list is null, the entity list
	 * will be deserialized and returned.
	 *
	 * @return The current list of all entities
	 */
	public static List<BaseEntity> getEntities() {
		return EntityManager.getEntities();
	}

	/**
	 * Generic method for getting an entity of any type by comparing its ID
	 *
	 * @param <T> Type of entity to be returned
	 * @param id the ID of the entity which is being searched
	 * @param kls the class of the entity to be returned
	 * @return the entity of the given class with the specified ID, or Null if
	 *         it cannot be found
	 */
	public static <T extends BaseEntity> T getEntity(UUID id, Class<T> kls) {
		return EntityManager.getEntity(id, kls);
	}

	/**
	 * Generic method for getting multiple entities of a given type by comparing
	 * their IDs
	 *
	 * @param <T> Type of entity to be returned
	 * @param ids a list of the ID of the entities which are being searched for
	 * @param kls the class of the entities to be returned
	 * @return the entities of the given class with the specified IDs, or an
	 *         empty list if none can be found
	 */
	public static <T extends BaseEntity> List<T> getEntities(List<UUID> ids, Class<T> kls) {

		return EntityManager.getEntities(ids, kls);
	}

	/**
	 * Generic method for getting a list of entities of a specified type
	 *
	 * @param <T> Type of entities to be returned
	 * @param kls the class of the entities to be returned
	 * @return a list of entities of the given class or an empty list if none
	 *         can be found
	 */
	public static <T extends BaseEntity> List<T> getTypedEntities(Class<T> kls) {
		return EntityManager.getTypedEntities(kls);
	}

	/**
	 * Generic method for getting an entity of a given type
	 *
	 * @param <T> Type of entity to be returned
	 * @param kls the class of the entity to be returned
	 * @return the entity of the given class, or Null if an instance of that
	 *         class cannot be found
	 */
	public static <T extends BaseEntity> T getEntity(Class<T> kls) {
		return EntityManager.getEntity(kls);
	}

	/**
	 * Adds an entity or entities to the managed list of entities
	 *
	 * @throws IllegalArgumentException if a null argument is passed in
	 * @param entities a variable number of entities to add to the entity
	 *        manager
	 */
	public static void addEntity(BaseEntity... entities) {
		EntityManager.addEntity(entities);
	}

	/**
	 * Adds a set of entities to the managed list of entities
	 *
	 * @param <T>
	 * @param newEntities a list of the entities to be added
	 */
	public static <T extends BaseEntity> void addEntities(List<T> newEntities) {
		EntityManager.addEntities(newEntities);
	}

	/**
	 * Removes an entity from the managed list of entities
	 *
	 * @throws IllegalArgumentException if a null argument is passed in
	 * @param entity the entity to be removed
	 */
	public static void removeEntity(BaseEntity entity) {
		EntityManager.removeEntity(entity);
	}

	/**
	 * Removes a list of entities from the managed list of entities
	 *
	 * @param <T>
	 * @param ents a list of the entities to be removed
	 */
	public static <T extends BaseEntity> void removeEntities(List<T> ents) {
		EntityManager.removeEntities(ents);
	}

	/**
	 * Gets a regular or admin user depending on the specified value.
	 *
	 * @param admin set to true to return an admin, false for regular user
	 * @return a regular or admin User
	 */
	public static User getUser(boolean admin) {
		List<User> users = getTypedEntities(User.class);
		for (User u : users) {
			if (u.isAdmin == admin) {
				return u;
			}
		}
		return null;
	}

	/**
	 * Gets an entity of the specified class with the specified value for the
	 * field with the specified name
	 *
	 * @param klazz the class of the entity
	 * @param fieldName the name of the entity's field
	 * @param value the value the field should have
	 * @return the entity
	 */
	public static <T extends BaseEntity> T getEntityWithField(Class<T> klazz, String fieldName, Object value) {
		List<T> ents = getTypedEntities(klazz);
		T result = null;
		Field f = null;
		Class<?> temp = klazz;
		while (BaseEntity.class.isAssignableFrom(temp)) {
			try {
				f = klazz.getDeclaredField(fieldName);
			}
			catch (NoSuchFieldException e) {
				temp = klazz.getSuperclass();
			}
			catch (SecurityException e) {
				throw new RuntimeException(e);
			}
		}
		Assert.assertNotNull("No entity field found with name: " + fieldName, f);
		for (T ent : ents) {
			try {
				if (f.get(ent).equals(value)) {
					result = ent;
				}
			}
			catch (IllegalArgumentException | IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
		return result;
	}

	/**
	 * Gets a user with the specified username
	 *
	 * @param name the name of the user
	 * @return the user
	 */
	public static User getUserWithUsername(String name) {
		List<User> users = getTypedEntities(User.class);
		User result = null;
		for (User u : users) {
			if (u.getUsername().equals(name)) {
				result = u;
			}
		}
		return result;
	}

}
