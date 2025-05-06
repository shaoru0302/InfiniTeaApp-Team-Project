## **Scenario summary for buildfeature**

These scenarios cover the essential flow of "Customizing the order feature":  
**View ➜ Build ➜ Customize ➜ Order**, with test coverage and minimal UI.

It supports viewing, building, and ordering drink orders. 3 main tested scenarios:

---

## **Scenario 1: Navigate to Build-Your-Own Page**

- **Goal:** Allows users to navigate from home page to build drink page.
- **Tests:**
    - 1 UI Espresso test: Buttons correctly navigate to right page
    - 2 Unit tests: Logic works as expected.

- **Features:**
    - Home ➜ Order ➜ Build Your Own .

---

## **Scenario 2: Select Multiple Toppings**

- **Goal:** Let users add multiple toppings to their drink.
- **Tests:**
    - 1 UI Espresso test: User selected toppings appear in 'Selected' section.
    - 2 Unit tests: Topping selection list updates in real-time.

- **Features:**
    - Toppings' checkboxes.
    - Real-time visual updates.

---

## **Scenario 3: Adjust Ice Level**

- **Goal:** Support custom ice amount(Regular, 50%, None).
- **Tests:**
    - 1 UI Espresso test: Selecting ice level updates in selected section.
    - 2 Unit tests: Ice amount is saved and given in final drink.

- **Features:**
    - Slider or Checkboxes.
    - Connected to final order.

---

## **Scenario 4: Place the Customized Order**

- **Goal:** Place custom-drink order.
- **Tests:**
    - 1 UI Espresso test: Selecting "Place Order" adds drink to cart and navigates to menu.
    - 2 Unit tests: Order shows all selected options.

- **Features:**
    - Order summary.
    - Cart integration.
