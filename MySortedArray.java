/**
 * {@Summary} The implementation of a day planner. It stores a collection of
 * events in ascending order of their starting times.
 * The planner supports multiple operations for maintenance, including adding a
 * new event, deleting an event, and updating an event.
 * 
 * @author Warisa Khan.
 * @param <T> and extends Comparable
 */

public class MySortedArray<T extends Comparable<T>> {

	// default initial capacity / minimum capacity
	/**
	 * Default_Capacity is the initial size.
	 */
	private static final int DEFAULT_CAPACITY = 2;

	// underlying array for storage -- you MUST use this for credit!
	// Do NOT change the name or type

	/**
	 * data is the array.
	 */
	private T[] data;

	/**
	 * size is the intiial size.
	 */
	private int size;
	/**
	 * capacity variable.
	 */
	private int capacity;

	// ADD MORE PRIVATE MEMBERS HERE IF NEEDED!

	/**
	 * constrcutor.
	 */
	@SuppressWarnings("unchecked")
	public MySortedArray() {
		// Constructor
		// Initial capacity of the storage should be DEFAULT_CAPACITY
		// Hint: Can't remember how to make an array of generic Ts? It's in the
		// textbook...

		data = (T[]) new Comparable[DEFAULT_CAPACITY];
		size = 0;
		capacity = 2;

	}

	/**
	 * setting the initial capacity with a constructor.
	 * 
	 * @param initialCapacity is the initial value.
	 */
	@SuppressWarnings("unchecked")
	public MySortedArray(int initialCapacity) {

		if (initialCapacity < DEFAULT_CAPACITY) {
			throw new IllegalArgumentException("Capacity must be at least 2!");
		}

		data = (T[]) new Comparable[initialCapacity];
		size = 0;
		capacity = initialCapacity;
		// Constructor

		// Initial capacity of the storage should be initialCapacity

		// Throw IllegalArgumentException if initialCapacity is smaller than
		// 2 (which is the DEFAULT_CAPACITY).
		// Use this _exact_ error message for the exception
		// quotes are not part of the message):
		// "Capacity must be at least 2!"

	}

	/**
	 * a getter method for the size.
	 * 
	 * @return int for the size.
	 */
	public int size() {
		// Report the current number of elements
		// O(1)

		return size;

	}

	/**
	 * finding the capacity for the array.
	 * 
	 * @return int for the length of the data.
	 */
	public int capacity() {
		// Report max number of elements before the next expansion
		// O(1)

		return data.length;
	}

	/**
	 * add method to add a given value into the array and sort it.
	 * 
	 * @param value is the value being added.
	 */

	public void add(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot add: null value!");
		}

		if (size == capacity()) {
			if (this.doubleCapacity() != true) {
				throw new IllegalStateException("Cannot add: capacity upper-bound reached!");
			}
		}

		if (size == 0) {
			data[0] = value;
			size += 1;
		}

		for (int a = 0; a < size() - 1; a++) {
			if (value.compareTo(data[a]) == 0 && value.compareTo(data[a + 1]) < 0) {
				for (int b = size(); b > a; b--) {
					data[b + 1] = value;
					size += 1;

				}

			}
		}

		for (int i = 0; i < size(); i++) {

			if (value.compareTo(get(i)) < 0) {
				for (int w = size(); w > i; w++) {
					if (data[size()] != null && value.compareTo(data[size() - 1]) >= 0) {

						data[w] = data[i - 1];
						data[i] = value;
						size += 1;
						break;

					}
				}

			}

			if (value.compareTo(get(i)) > 0) {
				if ((data[size()]) == null && value.compareTo(data[size() - 1]) >= 0) {
					data[size()] = value;
					size += 1;
					break;

				} else {
					for (int j = data.length; j > i; j++) {
						data[j] = data[j - 1];
					}
					data[i + 1] = value;
					size += 1;
					break;
				}

			}

			size += 1;

		}

		// Insert the given value into the array and keep the array _SORTED_
		// in ascending order.

		// If the array already contains value(s) that are equal to the new value,
		// make sure that the new value is added at the end of the group. Check examples
		// in project spec and main() below.

		// Remember to use .compareTo() to perform order/equivalence checking.

		// Note: You _can_ append an item (and increase size) with this method.
		// - You must call doubleCapacity() if no space is available.
		// - Check below for details of doubleCapacity().
		// - For the rare case that doubleCapacity() fails to increase the max
		// number of items allowed, throw IllegalStateException.
		// - Use this _exact_ error message for the exception
		// (quotes are not part of the message):
		// "Cannot add: capacity upper-bound reached!"

		// Note: The value to be added cannot be null.
		// - Throw IllegalArgumentException if value is null.
		// - Use this _exact_ error message for the exception
		// (quotes are not part of the message):
		// "Cannot add: null value!"

		// O(N) where N is the number of elements in the storage

	}

	/**
	 * returns the item of the given index.
	 * 
	 * @param index is the given index.
	 * @return T for the array.
	 */

	public T get(int index) {
		// any checking?

		if (index >= size() || index < 0)
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds!");

		return data[index];

		// Return the item at the given index
		// O(1)
		// For an invalid index, throw an IndexOutOfBoundsException.
		// Use this code to produce the correct error message for
		// the exception (do not use a different message):
		// "Index " + index + " out of bounds!"

	}

	/**
	 * Change the item at the given index to be the given value.
	 * 
	 * @param index is the index given.
	 * @param value is the value given.
	 * @return boolean returns true is the array is sorted in ascending order.
	 */

	public boolean replace(int index, T value) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot add: null value!");
		}

		if (index >= capacity() || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds!");
		}

		if (index != 0) {
			if (data[index].compareTo(data[index - 1]) > 0) {
				data[index] = value;
				return true;

			}
		}

		if (index == 0) {
			if (data[index].compareTo(data[index - 1]) > 0) {
				data[index] = value;
				return true;
			}

		}

		if (value.compareTo(data[index - 1]) > 0 && value.compareTo(data[index + 1]) < 0) {
			data[index] = value;
			return true;

			// Change the item at the given index to be the given value.

			// For an invalid index, throw an IndexOutOfBoundsException.
			// Use the same error message as get(index).
			// Note: You _cannot_ add new items with this method.

			// For a valid index, if value is null, throw IllegalArgumentException.
			// Use the exact same error message as add(value).

			// The array must keep to be sorted in ascending order after updating.
			// For a valid index, return false if setting the value at index violates
			// the required order hence can not be performed; no change should be made
			// to the array. Otherwise, change the item and return true.

		}

		return false;

	}

	/**
	 * insert the given value at the given index.
	 * 
	 * @param index is the index given.
	 * @param value is the value given.
	 * @return boolean if the value was inserted at the correct index.
	 */

	public boolean add(int index, T value) {
		if (index > size() || index < 0) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds!");

		}

		if (value == null) {
			throw new IllegalArgumentException("Cannot add: null value!");

		}

		if (doubleCapacity() == false && data.length == size()) {
			throw new IllegalStateException("Cannot add: capacity upper bound reached");
		}

		if (data[index] == null && size() == 0) {
			data[index] = value;
			size += 1;
			return true;
		}

		if (data[index] == null) {
			if (value.compareTo(data[index - 1]) <= 0) {
				return false;

			}
			data[index] = value;
			size += 1;
			return true;
		}

		if (value.compareTo(data[index]) < 0 && data[index] != null) {
			for (int i = size() - 1; i > index; i--) {
				data[i + 1] = data[i];

			}

			data[index] = value;
			size += 1;
			return true;
		}

		// Insert the given value at the given index. Shift elements if needed.
		// Double capacity if no space available.

		// For an invalid index, throw an IndexOutOfBoundsException.
		// Use the same error message as get(index).
		// Note: You _can_ append items with this method, which is different from
		// replace().
		// For a valid index, if value is null, throw IllegalArgumentException.
		// Use the exact same error message as add(value). See add(value) above.

		// The array must keep to be sorted in ascending order after updating.
		// For a valid index, return false if inserting the value at index violates
		// the required order hence can not be performed; no change should be made
		// to the array. Otherwise, insert the value and return true.

		// You must call doubleCapacity() if no space is available.
		// Throw IllegalStateException if doubleCapacity() fails.
		// Use the exact same error message as add(value). See add(value) above.

		// O(N) where N is the number of elements in the storage

		return true; // default return, remove/change as needed
	}

	/**
	 * removes and returns the element at the given index.
	 * 
	 * @param index is the index giveen.
	 * @return T for the array.
	 */
	public T delete(int index) {

		T temporaryArray = data[index];

		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index " + index + " out of bounds!");
		}

		for (int i = 0; i < size; i++) {

			if (data[i].compareTo(temporaryArray) == 0) {
				int value = capacity() - 1;
				if (i == index) {
					for (int j = 0; j < value; j++) {
						data[j] = data[j + 1];

					}
					data[size - 1] = null;
					size -= 1;
					break;
				}

			}

		}

		if (size < (capacity() * 1 / 3)) {
			this.halveCapacity();
		}

		return temporaryArray;

		// Remove and return the element at the given index. Shift elements
		// to remove the gap. Throw an exception when there is an invalid
		// index (see replace(), get(), etc. above).

		// After deletion, if the number of elements falls below 1/3
		// of the capacity, you must call halveCapacity() to shrink the storage.
		// - Check halveCapacity() below for details.
		// - If the capacity would fall below the DEFAULT_CAPACITY,
		// shrink to the DEFAULT_CAPACITY. This should be implemented by
		// halveCapacity().

		// O(N) where N is the number of elements currently in the storage

	}

	/**
	 * doubles the capacity of the array.
	 * 
	 * @return boolean is true if the capacity is able to double in size.
	 */
	@SuppressWarnings("unchecked")
	public boolean doubleCapacity() {
		if (capacity() == Integer.MAX_VALUE - 50) {
			return false;
		} else if (capacity() * 2 > Integer.MAX_VALUE - 50) {
			int finalcapacity = Integer.MAX_VALUE - 50;
			T[] temporary = (T[]) new Comparable[finalcapacity];

			for (int i = 0; i < data.length; i++) {
				temporary[i] = data[i];

			}

			data = temporary;
			return true;
		}

		int endcapacity = capacity() * 2;
		T[] temporary = (T[]) new Comparable[endcapacity];

		for (int i = 0; i < data.length; i++) {
			temporary[i] = data[i];

		}

		data = temporary;
		return true;
		// Double the max number of items allowed in data storage.
		// Remember to copy existing items to the new storage after expansion.

		// - Out of abundance of caution, we will use (Integer.MAX_VALUE - 50)
		// as the upper-bound of our capacity.
		// - If double the current capacity would go beyond this upper-bound,
		// use this upper-bound value as the new capacity.
		// - If the current capacity is already this upper-bound (Integer.MAX_VALUE -
		// 50),
		// do not expand and return false.

	}

	/**
	 * halves the capacity of the data array.
	 * 
	 * @return boolean if capacity is able to be halved.
	 */
	@SuppressWarnings("unchecked")
	public boolean halveCapacity() {
		int finalcapacity = capacity() / 2;

		if (finalcapacity < size) {
			return false;
		}

		if (finalcapacity < DEFAULT_CAPACITY) {
			T[] temporary = (T[]) new Comparable[DEFAULT_CAPACITY];

			for (int i = 0; i < data.length; i++) {
				temporary[i] = data[i];

			}

			data = temporary;
			return true;

		}

		T[] temporary = (T[]) new Comparable[finalcapacity];

		for (int i = 0; i < data.length; i++) {
			temporary[i] = data[i];

		}

		data = temporary;
		return true;

		// Reduce the max number of items allowed in data storage by half.
		// - If the current capacity is an odd number, _round down_ to get the
		// new capacity;
		// - If the new capacity would fall below the DEFAULT_CAPACITY,
		// shrink to the DEFAULT_CAPACITY;
		// - If the new capacity (after necessary adjustment to DEFAULT_CAPACITY)
		// cannot hold all existing items, do not shrink and return false;
		// - Return true for a successful shrinking.

		// Remember to copy existing items to the new storage after shrinking.

		// O(N) where N is the number of elements in the array

		// default return, remove/change as needed

	}
	// ******************************************************
	// ******* BELOW THIS LINE IS TESTING CODE *******
	// ******* Edit it as much as you'd like! *******
	// ******* Remember to add JavaDoc *******
	// ******************************************************

	/**
	 * to String that creates a sentece.
	 * 
	 * @return updated String.
	 */
	public String toString() {
		// This method is provided for debugging purposes
		// (use/modify as much as you'd like), it just prints
		// out the MySortedArray for easy viewing.
		StringBuilder s = new StringBuilder("MySortedArray with " + size()
				+ " items and a capacity of " + capacity() + ":");
		for (int i = 0; i < size(); i++) {
			s.append("\n  [" + i + "]: " + get(i));
		}
		return s.toString();

	}

	/**
	 * main method.
	 * 
	 * @param args takes in arguments.
	 */
	public static void main(String[] args) {
		// These are _sample_ tests. If you're seeing all the "yays" that's
		// an excellend first step! But it might not mean your code is 100%
		// working... You may edit this as much as you want, so you can add
		// own tests here, modify these tests, or whatever you need!

		// create a MySortedArray of integers
		MySortedArray<Integer> nums = new MySortedArray<>();
		if ((nums.size() == 0) && (nums.capacity() == 2)) {
			System.out.println("Yay 1");
		}

		// append some numbers
		for (int i = 0; i < 3; i++) {
			nums.add(i, i * 2);
		}
		// uncomment to check the array details
		// System.out.println(nums.toString());

		if (!nums.add(nums.size(), 1) && nums.size() == 3 && nums.get(2) == 4 && nums.capacity() == 4) {
			System.out.println("Yay 2");
		}
		// System.out.println(nums.toString());

		// add more numbers, your insertion need to keep the array sorted
		nums.add(1);
		nums.add(-1);
		nums.add(5);
		if (nums.size() == 6 && nums.get(0) == -1 && nums.get(2) == 1 && nums.get(5) == 5) {
			System.out.println("Yay 3");
		}
		// System.out.println(nums.toString());

		// add with index
		if (nums.add(4, 2) && nums.add(3, 2) && nums.get(3) == nums.get(4)
				&& nums.get(4) == nums.get(5) && nums.get(5) == 2) {
			System.out.println("Yay 4");
		}
		// System.out.println(nums.toString());

		// replace with index
		if (nums.replace(5, 3) && nums.get(5) == 3 && nums.replace(6, 5) && nums.get(6) == 5
				&& !nums.replace(1, 2) && nums.get(1) == 0) {
			System.out.println("Yay 5");
		}
		// System.out.println(nums.toString());

		MySortedArray<String> names = new MySortedArray<>();

		// insert some strings
		names.add("alice");
		names.add("charlie");
		names.add("bob");
		names.add("adam");
		// System.out.println(names.toString());

		// delete
		if (names.add(4, "emma") && names.delete(3).equals("charlie")) {
			System.out.println("Yay 6");
		}

		names.delete(0);
		names.delete(0);

		// shrinking
		if (names.size() == 2 && names.capacity() == 4) {
			System.out.println("Yay 7");
		}
		// System.out.println(names.toString());

		// insert equal values: sorted by insertion order
		String dylan1 = new String("dylan");
		String dylan2 = new String("dylan");
		names.add(dylan1);
		names.add(dylan2);
		if (names.size() == 4 && names.get(1) == dylan1 && names.get(2) == dylan2
				&& names.get(1) != names.get(2)) {
			System.out.println("Yay 8");
		}
		// System.out.println(names.toString());

		// exception checking example
		// make sure you write more testings by yourself
		try {
			names.get(-1);
		} catch (IndexOutOfBoundsException ex) {
			if (ex.getMessage().equals("Index -1 out of bounds!"))
				System.out.println("Yay 9");
		}

		// call doubleCapacity() and halveCapacity() directly
		if (names.doubleCapacity() && names.capacity() == 8
				&& names.halveCapacity() && names.capacity() == 4
				&& !names.halveCapacity() && names.capacity() == 4) {
			System.out.println("Yay 10");

		}
		// System.out.println(names.toString());

	}

}