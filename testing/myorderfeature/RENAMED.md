## **Scenario summary for myorderfeature**

These scenarios cover the essential flow of "View and Reorder past feature":  
**View ➜ Search ➜ Reorder**, with test coverage and minimal UI.

It supports viewing, searching, and reordering past drink orders. 3 main tested scenarios:

---

## **Scenario 1: View Past Orders**

- **Goal:** Display a list of previous orders.
- **Tests:**  
  - 1 UI Espresso test: My Orders page shows order history with a search bar of filtering order number.  
  - 2 Unit tests: Repository returns data and correct order content.

- **Features:**  
  - Uses RecyclerView to show orders.
  - Orders have item list, total price, and date.

---

## **Scenario 2: Search by Order Number**

- **Goal:** Allow users to filter orders by typing an order number.
- **Tests:**  
  - 1 UI Espresso test: Typing a valid order number shows matching result.  
  - 2 Unit tests: Filtering logic returns correct match or empty.

- **Features:**  
  - Input field with live search.
  - Shows “Order not found” or “Please enter” when needed.

---

## **Scenario 3: Reorder Past Orders**

- **Goal:** Reorder drinks from past orders.
- **Tests:**  
  - 1 UI Espresso test: Shows message for in-stock or out-of-stock items.  
  - 2 Unit tests: Logic for filtering out-of-stock items and updating cart.

- **Features:**  
  - Only in-stock items are added to cart.
  - Status message display for testing.