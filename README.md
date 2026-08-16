# Tea Order App

## InfiniTeaApp-Team

- Name: **Shaoru Wu-Zhu**, Email: shaoruwuzhu@gmail.com, GitHub: shaoru0302
- Name: **Kyle Cush**, Email: KYLECUSH23@bcmail.cuny.edu, GitHub: StudentKC-jpg
- Name: **Deming Huang**, Email: DemingHuang16@bcmail.cuny.edu, GitHub: DemingHuang-9294
- Name: **Anthony Sy**, Email: ANTHONY.SY50@bcmail.cuny.edu, GitHub: anthony2421

## Project Preview
An Android bubble tea ordering application developed in **Android Studio**, featuring classic menu ordering, drink customization, shopping cart management, and past-order reordering.
For screenshots and a visual overview of the completed app, please see the **InfiniTea_App_Summary_Report** in the `doc` folder.
  
## My Contributions

### My Orders Feature
Implemented the complete **View and Reorder Past Orders** workflow, including:

- Built a **My Orders** page using `RecyclerView` to display past orders with item details, total price, and order date.
- Added **live search by order number**, including handling for invalid or empty search results.
- Implemented **reorder functionality** that adds only in-stock items from previous orders back into the shopping cart.
- Added user feedback for in-stock and out-of-stock items during reorder operations.
- Wrote **Espresso UI tests** for viewing orders, searching orders, and reordering.
- Wrote **unit tests** for repository data retrieval, filtering logic, stock validation, and cart update behavior.

### UI/UX Design
- Designed the overall UI and visual style of the InfiniTea App.
- Created a consistent look and layout across the Home, Menu, Build Your Own, Shopping Cart, and My Orders screens.
