A custom Java implementation of a `HashMap` using generic types and separate chaining for collision handling, alongside an optimized solution for calculating continuous subarrays with a given target sum using hashing.

## 🚀 Key Features

* **Custom HashMap (`Hashmapdemo.java`):**
  * **Generic Key-Value Storage:** Supports parameterization via Java Generics `<K, V>`.
  * **Separate Chaining Collision Handling:** Uses array buckets containing Java `LinkedList` nodes.
  * **Dynamic Rehashing:** Automatically resizes and doubles the bucket array when the load factor exceeds threshold `2.0`.
  * **Core Map Operations:** `add()`, `remove()`, `contains()`, `keys()`, `values()`, and `isEmpty()`.

* **Subarray Sum Equals K (`hashsubarray.java`):**
  * Implements prefix-sum combined with hashing to calculate the number of continuous subarrays that sum up to a target integer `K`.

---

## 🛠️ Method & Complexity Summary

### Custom HashMap (`Hashmapdemo.HashMap`)

| Method | Description | Time Complexity |
| :--- | :--- | :--- |
| `add(K key, V value)` | Inserts or updates a key-value pair; rehashes if load factor > 2.0. | **O(1)** Average / **O(N)** Worst Case |
| `remove(K key)` | Removes a key and its value from the corresponding bucket. | **O(1)** Average / **O(N)** Worst Case |
| `contains(K key)` | Checks whether a key exists in the map. | **O(1)** Average / **O(N)** Worst Case |
| `keys()` | Returns an `ArrayList` of all active keys. | **O(N)** |
| `values()` | Returns an `ArrayList` of all active values. | **O(N)** |

### Subarray Analysis (`hashsubarray`)

| Method | Description | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- |
| `Totalsubarray(arr, K)` | Calculates total continuous subarrays matching target sum `K`. | **O(N)** | **O(N)** |

---
