// category part
const buttons = document.getElementsByClassName("category");
const buttonPressed = (e) => {
    let catID = e.target.id; // Get ID of Clicked Element

    for (let button of buttons) {
        button.style.backgroundColor = "#343f50";
    }
    document.getElementById(catID).style.backgroundColor = "black";

    let hides = document.getElementsByClassName("dcontent");
    for (let hide of hides) {
        hide.style.display = "none";
    }
    document.getElementById("dcontent" + catID).style.display = "grid";
};
for (let button of buttons) {
    button.addEventListener("click", buttonPressed);
}
buttons[0].click();

// select drink part
const drinks = document.getElementsByClassName("drink");
const drinkSelected = (e) => {
    let drinkID = e.target.id; // Get ID of Clicked Element
    console.log(drinkID);
    document.getElementById("sDrinkId").value = drinkID + "";
    openForm();
};
for (let drink of drinks) {
    drink.addEventListener("click", drinkSelected);
}

/* Function to open the pop-up form */
function openForm() {
    document.getElementById("myForm").style.display = "block";
}

/* Function to close the pop-up form */
function closeForm() {
    document.getElementById("myForm").style.display = "none";
}

/* Function to open the pop-up form */
function openCal() {
    document.getElementById("myForm2").style.display = "block";
}

/* Function to close the pop-up form */
function closeCal() {
    document.getElementById("myForm2").style.display = "none";
}