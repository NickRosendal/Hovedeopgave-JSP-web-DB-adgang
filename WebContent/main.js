//Fiels handels
var inputYear;
var inputMonth;
var inputDay;
var inputName;
var saveAndNextButton;

// Boolean Values
var yearOK = false;
var dayOK = false;
var monthOK = false;
var nameOK = false;

// Get Year, this year -18 should be the year allowed to enter minimum!
var yearAllowed;

function runOnWelcomeJsp(){
	welcomeSetUp();
}

function runOnMainJsp(){
	var container = document.getElementById('container');
	var theScreenHeight = window.innerHeight;
	theScreenHeight = theScreenHeight-50;
	container.style.height = theScreenHeight+"px";
	testIfIpad();
}

function runOnEditorJsp() {

	testIfIpad();
	manipulateHeight_editor();
	asignHandels();
	setUpButton();
	setInterval(validating, 500);
	
}

function manipulateHeight_editor() {

	var img = document.getElementById('imgContainer');
	// or however you get a handle to the IMG

	var height = img.clientHeight+50;

	// var theScreenWidth = screen.width
	var theScreenHeight = window.innerHeight;

	var formhight = theScreenHeight - height;

	document.getElementById('formContainer').style.height = formhight + "px";
}

function asignHandels() {
	// Fiels handele
	inputYear = document.getElementById('yearInput');
	inputMonth = document.getElementById('monthInput');
	inputDay = document.getElementById('dayInput');
	inputName = document.getElementById('nameForm');
	saveAndNextButton = document.getElementById('formSaveButton');

	// Get Year, this year -18 should be the year allowed to enter minimum!
	var date = new Date();
	yearAllowed = date.getFullYear() - 18;
}

function testIfIpad(){
    var isiPad = navigator.userAgent.match(/iPad/i) != null;
    
    if(isiPad)
    {
/*
    	
        // Create element node - link object
        var fileref=document.createElement('link');

        // Set link object attributes like
        // <link rel="stylesheet" type="text/css" href="filename" />
        fileref.setAttribute('rel', 'stylesheet');
        fileref.setAttribute('type', 'text/css');
        fileref.setAttribute('href', 'ipad.css');

        // Append link object inside html's head
        document.getElementsByTagName("head")[0].appendChild(fileref);
    	
    	
    	//document.write('<link rel="stylesheet" type="text/css" href="ipad.css">');
*/
    	
    }
    
}

function validating() {
	// Testing Year
	if (inputYear.value > 1912 && inputYear.value <= yearAllowed) {
		inputYear.style.background = "green";
		// set background coller to
		yearOK = true;
	} else {
		// set white color
		inputYear.style.background = "white";
		yearOK = false;

	}

	// Testing Month
	if (inputMonth.value > 0 && inputMonth.value < 13) {
		// set ok color
		inputMonth.style.background = "green";
		monthOK = true;
	} else {
		// set false color
		inputMonth.style.background = "white";

		monthOK = false;
	}

	// Testing Day
	if (inputDay.value > 0 && inputDay.value < 32) {
		inputDay.style.background = "green";
		dayOK = true;
	} else {
		inputDay.style.background = "white";
		dayOK = false;
	}

	// Testing Name

	if (inputName.value.length > 4) {
		inputName.style.background = "green";
		
		
		nameOK = true;
	} else {

		inputName.style.background = "white";

		
		nameOK = false;
	}

	// Testing if all booleans are true, Activating Save and Next Button
	if (nameOK == true && yearOK == true && monthOK == true && dayOK == true) {
		saveAndNextButton.disabled = false;
	} else {
		saveAndNextButton.disabled = true;
	}

}

function setUpButton() {

	var button = document.getElementById('formSexButton');
	var gender = document.getElementById('gender');

	button.addEventListener("click", change, false);

	function change() {

		if (gender.value == 'Female') {

			button.value = 'Male';
			gender.value = 'Male';

			this.setAttribute("id", "formSexButtonPushed");

		} else {
			button.value = 'Female';
			gender.value = 'Female';
			this.setAttribute("id", "formSexButton");

		}

	}
}
function welcomeSetUp(){
	
	var thur_button = document.getElementById('thur_showHide');
	var thur_info = document.getElementById('thur_barInfoContainer');
	var thur_open = false;

	thur_button.addEventListener("click", thur_click, false);

	function thur_click() {

		if (thur_open == true) {
			thur_info.style.height = "20px";
			thur_open = false;

		} else {
			thur_info.style.height = "85px";
			thur_open = true;

		}

	}
	var sat_button = document.getElementById('sat_showHide');
	var sat_info = document.getElementById('sat_barInfoContainer');
	var sat_open = false;

	sat_button.addEventListener("click", sat_click, false);

	function sat_click() {

		if (sat_open == true) {
			sat_info.style.height = "20px";
			sat_open = false;

		} else {
			sat_info.style.height = "85px";
			sat_open = true;

		}

	}
	
	var fri_button = document.getElementById('fri_showHide');
	var fri_info = document.getElementById('fri_barInfoContainer');
	var fri_open = false;

	fri_button.addEventListener("click", fri_click, false);

	function fri_click() {

		if (fri_open == true) {
			fri_info.style.height = "20px";
			fri_open = false;

		} else {
			fri_info.style.height = "85px";
			fri_open = true;

		}

	}
}