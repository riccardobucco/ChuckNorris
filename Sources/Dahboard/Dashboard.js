var EventEmitter = require('events').EventEmitter;

Array.prototype.indexOfField = function(propertyName, value) {
	for (var i = 0; i < this.length; i++)
		if (this[i][propertyName] === value)
			return i;
	return -1;
};

function Dashboard(mapchart) {
	this.lines = ['01','03','05','06'];
	this.mapchart = mapchart;
	EventEmitter.call(this);
};

Dashboard.prototype.__proto__ = EventEmitter.prototype;

Dashboard.prototype.getUpdateObject = function(lineName, lineData) {
	mapData = this.mapchart.getData();
	indexLine = mapData.datasets.indexOfField('name', line);
	for (var j = 0; j < mapData.datasets[indexLine].values.length; j++) {
		var value = mapData.datasets[indexLine].values[j];
		console.log('pippo');
		// controllo se value.id e' presente nei dati aggiornati, ovvero in lineData. se non c'e' aggiungi a valuesToDelete
		if (lineData.indexOfField('IdMezzo', value.id) == -1) {
			// cerco l'index del valore che intendo rimuovere
			var indexValue = mapData.datasets[indexLine].values.indexOf(value);
			// creo un oggetto che rappresenta un punto da rimuovere e lo aggiungo a valuesToDelete
			var valueToDelete = {
				series: indexLine,
				index: indexValue
			};
			valuesToDelete.push(valueToDelete);
		}
	}
};

Dashboard.prototype.UpdateLines = function() {
	for (var i = 0; i < this.lines.length; i++) {
		var line = this.lines[i];
		var eventToListen = line + '-received';
		this.on(eventToListen, function(lineData) {

		});
	}
};

Dashboard.prototype.getLine = function(line) {
	var data = 'l=' + line;
	var options = {
		hostname: 'www.apsholding.it',
		port: 80,
		path: '/index.php/informazioni/dov-e-il-mezzo-pubblico-in-tempo-reale?option=com_mappeaps&view=posmezzi&format=raw',
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded',
			'Content-Length': data.length 
		}
	};
	var self = this;
	var body = '';
	var req = http.request(options, function (res) {
		res.setEncoding('utf8');
		res.on('data', function (chunk) {
			body += chunk;
		});
		res.on('end', function () {
			lineData = JSON.parse(body);
			console.log(lineData);
			var eventName = line + '-received';
			self.emit(eventName, lineData);
		});
	});
	req.write(data);
	req.end();
};