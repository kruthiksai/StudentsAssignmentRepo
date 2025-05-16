
// Function to fetch questions from the API
function fetchBooks() {
    const email = sessionStorage.getItem('userEmail');
    fetch(`/api/books/showBooks`)
        .then(response => response.json())
        .then(data => {
            displayBooks(data, email);

        })
        .catch(error => {
            console.error('Error fetching questions:', error);

        });
}

function displayBooks(books) {
    const productsDiv = document.getElementById('products');

    // Clear any existing content inside the products div
    productsDiv.innerHTML = '';

    books.forEach(book => {
        // Create a new div element for each book
        const bookHTML = `
            <div class="col-lg-3">
                <div class="pro-container">
                    <div class="pro">
                        <img src="${book.imgUrl}" alt="${book.name}">
                        <div class="des">
                            <span>${book.name}</span>
                            <div id="allignment">
                            <h4>$${book.price.toFixed(2)}</h4>
                             <a href="sproduct.html?id=${book.id}"><i class="fa-solid fa-cart-shopping cart"></i></a>
                            </div>
                        </div>
                       
                    </div>
                </div>
            </div>
        `;

        // Append the new HTML to the products div
        productsDiv.innerHTML += bookHTML;
    });
}


document.addEventListener('DOMContentLoaded', function () {
    const userEmail = sessionStorage.getItem('userEmail');
    if (!userEmail) {
        alert("Login to View the Items")
        window.location.href = 'index.html';

    }
    fetchBooks();

    const userName = sessionStorage.getItem('userName');

    if (userEmail) {

        const userInfoElements = document.getElementsByClassName('user-info');

        for (let i = 0; i < userInfoElements.length; i++) {
            userInfoElements[i].style.display = 'flex';
        }

        document.getElementById('user-name').textContent = `Welcome, ${userName}`;
        document.getElementById('logout').addEventListener('click', function () {
            sessionStorage.clear();
            alert('You have been logged out');
            window.location.href = 'index.html';
        });
    } else {
        const userInfoElements = document.getElementsByClassName('user-info');
        for (let i = 0; i < userInfoElements.length; i++) {
            userInfoElements[i].style.display = 'none';
        }
    }
});


