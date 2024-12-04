<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sorting Application</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            color: #333;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #4CAF50;
            color: white;
            padding: 1rem 2rem;
            text-align: center;
        }

        main {
            padding: 2rem;
            max-width: 800px;
            margin: 2rem auto;
            background: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2, h3 {
            color: #4CAF50;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 1rem;
        }

        input, select, button {
            width: 100%;
            padding: 0.5rem;
            margin-top: 0.5rem;
            margin-bottom: 1rem;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        .section {
            margin-bottom: 2rem;
        }

        #currentDataset, #result {
            padding: 1rem;
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            border-radius: 4px;
            margin-top: 1rem;
        }

        #result p {
            color: #4CAF50;
            font-weight: bold;
        }

        footer {
            text-align: center;
            padding: 1rem;
            background-color: #333;
            color: white;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
    </style>
    <script>
        async function fetchDataset() {
            try {
                const response = await fetch('/advanced-web-sorting/sorting/current-dataset', { method: "GET" });

                if (!response.ok) {
                    throw new Error("Failed to fetch dataset");
                }

                const result = await response.json();
                document.getElementById("currentDataset").innerHTML = `
                    <h3>Current Dataset:</h3>
                    <p>${result.data.join(", ")}</p>
                `;
            } catch (error) {
                document.getElementById("currentDataset").innerHTML = `
                    <h3>Error:</h3>
                    <p>${error.message}</p>
                `;
            }
        }

        async function modifyDataset(action, index = null, value = null) {
            let url = `/advanced-web-sorting/sorting/${action}`;
            let body = null;

            if (action === "update-element") {
                url += `/${index}`;
                body = JSON.stringify(value);
            } else if (action === "remove-element") {
                url += `/${index}`;
            } else if (action === "change-input") {
                body = JSON.stringify(value);
            }

            try {
                const response = await fetch(url, {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: body ? body : null,
                });

                if (!response.ok) {
                    throw new Error("Failed to modify dataset");
                }

                await fetchDataset();
            } catch (error) {
                alert(error.message);
            }
        }

        async function sortData() {
            const algorithm = document.getElementById("algorithm").value;

            try {
                const response = await fetch(`/advanced-web-sorting/sorting/${algorithm}`, {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                });

                if (!response.ok) {
                    throw new Error("Failed to sort data");
                }

                const result = await response.json();
                document.getElementById("result").innerHTML = `
                    <h3>Sorted Data:</h3>
                    <p>${result.data.join(", ")}</p>
                `;
            } catch (error) {
                document.getElementById("result").innerHTML = `
                    <h3>Error:</h3>
                    <p>${error.message}</p>
                `;
            }
        }

        window.onload = fetchDataset;
    </script>
</head>
<body>
    <header>
        <h1>Welcome to the Advanced Web Sorting Application!</h1>
    </header>
    <main>
        <div class="section" id="currentDataset">
            <!-- Current dataset will be displayed here -->
        </div>

        <div class="section">
            <h3>Modify Dataset</h3>
            <form onsubmit="event.preventDefault(); modifyDataset('change-input', null, document.getElementById('newInput').value.split(',').map(Number));">
                <label for="newInput">Replace Entire Dataset (comma-separated):</label>
                <input type="text" id="newInput" placeholder="e.g., 5,3,8,6">
                <button type="submit">Update Dataset</button>
            </form>

            <form onsubmit="event.preventDefault(); modifyDataset('update-element', document.getElementById('updateIndex').value, document.getElementById('updateValue').value);">
                <label>Update Element:</label>
                <label for="updateIndex">Index:</label>
                <input type="number" id="updateIndex" placeholder="e.g., 2">
                <label for="updateValue">Value:</label>
                <input type="number" id="updateValue" placeholder="e.g., 10">
                <button type="submit">Update Element</button>
            </form>

            <form onsubmit="event.preventDefault(); modifyDataset('remove-element', document.getElementById('removeIndex').value);">
                <label for="removeIndex">Remove Element at Index:</label>
                <input type="number" id="removeIndex" placeholder="e.g., 2">
                <button type="submit">Remove Element</button>
            </form>

            <button onclick="modifyDataset('delete-data')">Clear Dataset</button>
        </div>

        <div class="section">
            <h3>Sort Dataset</h3>
            <label for="algorithm">Select Sorting Algorithm:</label>
            <select id="algorithm">
                <option value="heapsort">Heap Sort</option>
                <option value="quicksort">Quick Sort</option>
                <option value="mergesort">Merge Sort</option>
                <option value="bucketsort">Bucket Sort</option>
                <option value="radixsort">Radix Sort</option>
            </select>
            <button onclick="sortData()">Sort</button>
        </div>

        <div class="section" id="result">
            <!-- Sorted data will be displayed here -->
        </div>
    </main>
    <footer>
        <p>&copy; 2024 Web Sorting Application</p>
    </footer>
</body>
</html>
