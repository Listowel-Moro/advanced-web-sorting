# Advanced Web Sorting Application

A web-based application to demonstrate various sorting algorithms, allowing users to manage a dataset, sort it using different algorithms, and view the results interactively.

## Features

- **Dataset Management**:
    - Add new elements to the dataset.
    - Update or remove specific elements.
    - Replace the entire dataset or clear it entirely.

- **Sorting Algorithms**:
    - Sort the dataset using various algorithms:
        - Heap Sort
        - Quick Sort
        - Merge Sort
        - Bucket Sort
        - Radix Sort

- **Interactive Interface**:
    - HATEOAS-based REST API backend for seamless integration between frontend and backend.
    - A user-friendly interface built with JSP and HTML, styled with CSS for a modern look.

---

## Technologies Used

### Backend:
- **Java**: Core logic and REST API implementation.
- **Spring Framework**: Provides RESTful endpoints and HATEOAS support.
- **Maven**: Dependency management and build tool.

### Frontend:
- **JSP**: Dynamic webpage rendering.
- **HTML/CSS/JavaScript**: Interactive UI with custom styling and client-side logic.

### Server:
- **Apache Tomcat**: Deployed the web application.

---

## Prerequisites

Before running the project, ensure you have the following installed:

1. **Java Development Kit (JDK)** (version 17 or higher recommended).
2. **Apache Tomcat** (version 11 or higher).
3. **Maven** for dependency management.
4. A modern web browser for testing the application.

---

## How to Use

### Managing the Dataset:
1. Use the form on the homepage to:
    - Replace the dataset (provide comma-separated values).
    - Update a specific element by providing its index and new value.
    - Remove an element by its index.
    - Clear the entire dataset.

### Sorting the Dataset:
1. Select a sorting algorithm from the dropdown.
2. Click "Sort" to sort the current dataset using the chosen algorithm.
3. View the sorted dataset displayed on the page.

---

## API Endpoints

- `POST /sorting/change-input`  
  Replace the dataset with a new one.

- `POST /sorting/update-element/{index}`  
  Update a specific element in the dataset.

- `POST /sorting/remove-element/{index}`  
  Remove an element by its index.

- `POST /sorting/delete-data`  
  Clear the dataset.

- `POST /sorting/{algorithm}`  
  Sort the dataset using the specified algorithm (e.g., `quicksort`, `heapsort`, etc.).

- `GET /sorting/current-dataset`  
  Retrieve the current dataset.

---

## Example Response

### Sorting Dataset:
Request:
```http
POST /sorting/quicksort
```

Response:
```json
{
  "statusCode": 200,
  "message": "Sorting successful!",
  "data": [3, 5, 8, 12, 45],
  "links": [
    { "rel": "heapSort", "href": "http://localhost:8080/sorting/heapsort" },
    { "rel": "quickSort", "href": "http://localhost:8080/sorting/quicksort" },
    { "rel": "mergeSort", "href": "http://localhost:8080/sorting/mergesort" },
    { "rel": "bucketSort", "href": "http://localhost:8080/sorting/bucketsort" },
    { "rel": "radixSort", "href": "http://localhost:8080/sorting/radixsort" }
  ]
}
```

---

## Acknowledgments

- **Spring Framework** for simplifying backend development.
- **Apache Tomcat** for providing a robust servlet container.
- **HATEOAS** for REST API enhancements.