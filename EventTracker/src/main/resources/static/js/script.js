window.addEventListener('load', function(e) {
	console.log("Document Loaded");
	init();

});

function init() {
	// TODO Add event listeners to buttons; Call functions to put events on
	// table;
	document.musicFestForm.lookup.addEventListener('click', function(event) {
		event.preventDefault();
		var musicFestId = document.musicFestForm.musicFestId.value;
		if (!isNaN(musicFestId) && musicFestId > 0) {
			getMusicFest(musicFestId);
		}
	});

	document.listAllMusicFests.listAll.addEventListener('click',
			function(event) {
				event.preventDefault();
				listAllMusicFests();

			});

	document.addMusicFestForm.addMusicFest.addEventListener('click', function(
			event) {
		event.preventDefault();
		addMusicFest();
	});
}

// Function to get MusicFestival

function getMusicFest(musicFestId) {

	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8087/api/musicfestivals/' + musicFestId,
			true);

	xhr.onreadystatechange = function() {

		console.log(xhr.readyState);
		console.log(xhr.status);

		if (xhr.readyState === 4 && xhr.status < 400) {
			var musicFest = JSON.parse(xhr.responseText);
			console.log(musicFest);
			displayMusicFest(musicFest);

		}
		if (xhr.readyState === 4 && xhr.status >= 400) {
			// ToDo: Display an error on web page.
			console.error(xhr.status + ': ' + xhr.responseText);
			var dataDiv = document.getElementById('musicFestData');
			dataDiv.textContent = 'Music Festival Not Found!';
		}
	};
	xhr.send(null);
}

function displayMusicFest(musicFest) {

	var dataDiv = document.getElementById('musicFestData');
	dataDiv.textContent = '';
	while (dataDiv.firstElementChild) {
		dataDiv.removeChild(dataDiv.firstElementChild);
	}

	// Music Festival Name Header
	let h1 = document.createElement('h1');
	dataDiv.appendChild(h1);
	h1.textContent = musicFest.name;

	// Music Festival Details Table
	// Table Creation Functions for Cells and rows
	var tbl = document.createElement('table');
	tbl.style.border = "solid";
	var tbdy = document.createElement('tbody');
	tbdy.style.border = "solid";
	
	tbl.appendChild(tbdy);

	addRow('Location:', musicFest.location);
	addRow('Number of Days:', musicFest.numOfDays);
	addRow('Start Date:', musicFest.startDate);
	addRow('End Date:', musicFest.endDate);
	addRow('Music Genre(s):', musicFest.musicGenre);
	addRow('Headliners:', musicFest.headliners);
	addRow('Artists Seen:', musicFest.artistsSeen);
	addRow('Ticket Price:', '$ ' + musicFest.ticketPrice);

	dataDiv.appendChild(tbl);

	function addCell(tr, val) {
		var td = document.createElement('td');

		td.innerHTML = val;

		tr.appendChild(td)
	}

	function addRow(val_1, val_2) {
		var tr = document.createElement('tr');

		addCell(tr, val_1);
		addCell(tr, val_2);

		tbdy.appendChild(tr);
	}

}

function addMusicFest() {
	console.log('Adding new Music Festival!');
	// Add Post xhr code
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'http://localhost:8087/api/musicfestivals', true);
	xhr.setRequestHeader("Content-type", "application/json");
	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status < 400) {
			var musicFestObject = JSON.parse(xhr.responseText);
			displayMusicFest(musicFestObject);
		}
		if (xhr.readyState === 4 && xhr.status >= 400) {
			console.error(xhr.status + ': ' + xhr.responseText);
			var dataDiv = document.getElementById('musicFestData');
			dataDiv.textContent = 'Error Adding Music Festival';
		}
	};

	let form = document.addMusicFestForm;
	var newMusicFestObject = {
		name : form.name.value,
		location : form.location.value,
		numOfDays : form.numOfDays.value,
		startDate : form.startDate.value,
		endDate : form.endDate.value,
		musicGenre : form.musicGenre.value,
		headliners : form.headliners.value,
		artistsSeen : form.artistsSeen.value,
		ticketPrice : form.ticketPrice.value

	};
	// Convert JS object to JSON string
	var newMusicFestJsonString = JSON.stringify(newMusicFestObject);
	xhr.send(newMusicFestJsonString);
}

function listAllMusicFests() {

	var xhr = new XMLHttpRequest();
	xhr.open('GET', 'http://localhost:8087/api/musicfestivals', true);

	xhr.onreadystatechange = function() {

		console.log(xhr.readyState);
		console.log(xhr.status);

		if (xhr.readyState === 4 && xhr.status < 400) {
			var musicFests = JSON.parse(xhr.responseText);
			console.log(musicFests);
			displayAllMusicFests(musicFests);
		}
		if (xhr.readyState === 4 && xhr.status >= 400) {
			// ToDo: Display an error on web page.
			console.error(xhr.status + ': ' + xhr.responseText);
			var dataDiv = document.getElementById('musicFestData');
			dataDiv.textContent = ' No Music Festivals Found!';
		}
	};
	xhr.send(null);
}

function displayAllMusicFests(musicFests) {

	var dataDiv = document.getElementById('musicFestData');
	dataDiv.textContent = '';
	while (dataDiv.firstElementChild) {
		dataDiv.removeChild(dataDiv.firstElementChild);
	}

	// Music Festival Name Header
	let h1 = document.createElement('h1');
	dataDiv.appendChild(h1);
	h1.textContent = 'Music Festival List';
	
	let h3 = document.createElement('h3');
	dataDiv.appendChild(h3);
	h3.textContent = '(Click Row to Edit)'; 

	// Music Festival Details Table
	// Table Creation Functions for Cells and rows
	var tbl = document.createElement('table');
	tbl.style.border = "solid";
	var tbdy = document.createElement('tbody');
	tbdy.style.border = "solid";

	// Body fields of table
	tbl.appendChild(tbdy);

	// Table Header function
	function addHeader(name) {
		var th = document.createElement('th');
		th.style.border = "solid";
		th.innerHTML = name;
		tbdy.appendChild(th);
	}

	// Table Headers
	addHeader('Name');
	addHeader('Location');
	addHeader('Number of Days');
	addHeader('Start Date');
	addHeader('End Date');
	addHeader('Music Genre(s)');
	addHeader('Headliners');
	addHeader('Artists Seen');
	addHeader('Ticket Price');

	for (let i = 0; i < musicFests.length; i++) {
		//Click Event for updates
		// Table Rows
		addRow(musicFests[i].name, musicFests[i].location,
				musicFests[i].numOfDays, musicFests[i].startDate,
				musicFests[i].endDate, musicFests[i].musicGenre,
				musicFests[i].headliners, musicFests[i].artistsSeen, 
				'$ ' + musicFests[i].ticketPrice);

		dataDiv.appendChild(tbl);
	}
	// Add cell function
	function addCell(tr, val) {
		var td = document.createElement('td');
		td.style.border = "solid";

		td.innerHTML = val;

		tr.appendChild(td)
	}
	// Add row function
	function addRow(val_1, val_2, val_3, val_4, val_5, val_6, val_7, val_8,
			val_9) {
		var tr = document.createElement('tr');
		tr.style.border = "solid";

		addCell(tr, val_1);
		addCell(tr, val_2);
		addCell(tr, val_3);
		addCell(tr, val_4);
		addCell(tr, val_5);
		addCell(tr, val_6);
		addCell(tr, val_7);
		addCell(tr, val_8);
		addCell(tr, val_9);
		tbdy.appendChild(tr);
	}

}
