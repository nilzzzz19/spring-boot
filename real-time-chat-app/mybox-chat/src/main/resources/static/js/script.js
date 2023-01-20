let chatInput = document.getElementById("chat-input");
let chatForm = document.getElementById("chat-form");
let chatMessages = document.getElementById("chat-messages");

chatForm.addEventListener("submit", function (e) {
    e.preventDefault();
    let message = chatInput.value;
    if (message) {
        // Send message to the server
        // Clear the chat input field
        chatInput.value = "";
    }
});

// Handle incoming messages from the server
function handleIncomingMessage(message) {
    let messageElement = document.createElement("div");
    messageElement.innerText = message;
    chatMessages.appendChild(messageElement);
}
