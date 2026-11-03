// Get the elements we need from the page
const form = document.querySelector("form");
const usernameInput = document.getElementById("username");
const passwordInput = document.getElementById("password");
const rememberCheckbox = document.getElementById("remember");

// Get all the error boxes (first one is for username, second for password)
const errors = document.querySelectorAll(".error");
const usernameError = errors[0];
const passwordError = errors[1];

// When the page loads, check if a username was saved before
const savedUsername = localStorage.getItem("savedUsername");
if (savedUsername) {
    usernameInput.value = savedUsername;
    rememberCheckbox.checked = true;
}

// Run this when the user clicks the Login button
form.addEventListener("submit", function (event) {
    // Stop the page from reloading
    event.preventDefault();

    // Clear old error messages
    usernameError.textContent = "";
    passwordError.textContent = "";

    // Get the values and remove extra spaces
    const username = usernameInput.value.trim();
    const password = passwordInput.value.trim();

    let isValid = true;

    // Username validation
    if (username === "") {
        usernameError.textContent = "Username is required";
        isValid = false;
    } else if (username.length < 3) {
        usernameError.textContent = "Username must be at least 3 characters";
        isValid = false;
    } else if (username.includes(" ")) {
        usernameError.textContent = "Username cannot contain spaces";
        isValid = false;
    }

    // Password validation
    if (password === "") {
        passwordError.textContent = "Password is required";
        isValid = false;
    } else if (password.length < 6) {
        passwordError.textContent = "Password must be at least 6 characters";
        isValid = false;
    }

    // If everything is correct
    if (isValid) {
        // Remember Me: save or remove the username
        if (rememberCheckbox.checked) {
            localStorage.setItem("savedUsername", username);
        } else {
            localStorage.removeItem("savedUsername");
        }

        alert("Login successful!");
    }
});