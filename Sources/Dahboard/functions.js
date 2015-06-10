var http = require('http');
var server = http.createServer();
server.listen(80);
var express = require('express');
var app = new express();
server.on('request', app);
var norris = require('norris-rtc');
var nrr = norris(server, app,  '/');

/*	-------------------------------------------------------------------------------------------------  */
/*	--------------------------------------- INIZIALIZZAZIONE ----------------------------------------  */
/*	-------------------------------------------------------------------------------------------------  */

//	Creazione di un mapchart vuoto
var mapchartAPS = new nrr.createChart('mapchart', 'mapAPS');

/*	Creazione dell'oggetto mapData (che rappresenta i dati iniziali del mapchart). Tale oggetto viene creato
	inserendo gia' i nomi di tutte le linee dell'APS, pur senza inserire alcun mezzo. Quindi i dati sono
	semplicemente un array di linee vuote, ovvero senza alcun mezzo.  */
var lines = ['01','03','05','06','07','09','10','11','12','13','15','16','18','22','24','41','42','43','CC','DC','SIR1'];

var mapData = {
	datasets: []
};

for (var i = 0; i < lines.length; i++) {
	var line = {
		name: lines[i],
		values: []
	}
	mapData.datasets.push(line);
}

//	Aggiunta dei dati appena creati al mapchart
mapchartAPS.setData(mapData);

//	Creazione di una nuova pagina intitolata 'Dashboard APS' e aggiunta del grafico mapchartAPS
var dashboardPage = new nrr.createPage('Dashboard APS');
dashboardPage.add(mapchartAPS);

//	Si rende disponibile la nuova pagina al path '/dashboardAPS'
app.use('/dashboardAPS', nrr.getMiddleware());

/*	-------------------------------------------------------------------------------------------------  */
/*	------------------------------------------- UTILITIES -------------------------------------------  */
/*	-------------------------------------------------------------------------------------------------  */

/*	La seguente funzione e' resa disponibile a tutti gli oggetti di tipo array. Il suo comportamento e'
	molto simile a quello della funzione array.indexOf(obj): quest'ultima ritorna il primo indice
	dell'array nel quale si puo' trovare l'oggetto obj; la funzione descritta sotto, invece, ritorna il
	primo indice dell'array nel quale si puo' trovare un oggetto con proprieta' 'propertyname' che abbia
	come valore 'value'.  */
Array.prototype.indexOfField = function(propertyName, value) {
	for (var i = 0; i < this.length; i++)
		if (this[i][propertyName] === value)
			return i;
	return -1;
};

/*	La seguente funzione si occupa di ottenere informazioni riguardanti una linea dell'APS. Essa,
	in particolare, prende come parametro una stringa che rappresenta il nome della linea, fa una richiesta
	appropriata al server dell'APS, e ritorna i dati che le arrivano, senza fare alcuna conversione.  */
getLineFromAPS = function(line) {
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

	var body = '';
	var req = http.request(options, function (res) {
		res.setEncoding('utf8');
		res.on('data', function (chunk) {
			body += chunk;
		}
		res.on('end', function () {
			info = JSON.parse(body);
			// ordinamento dei dati??
		}
	};

	req.write(data);
	req.end();
	//	qui manca il return dei dati!!
};


/*	-------------------------------------------------------------------------------------------------  */
/*	------------------------------------- MOVIE DATA CREATION ---------------------------------------  */
/*	-------------------------------------------------------------------------------------------------  */

/*	La seguente funzione crea l'oggetto che deve essere passato al metodo che esegue l'update di tipo
	movie sui mapchart. Tale funzione, in particolare, crea separatamente gli oggetti inplace, stream
	e delete che sono richiesti, mettendoli poi insieme per formare l'oggetto richiesto  */

movieDataFromAPS = function() {
	var valuesToDelete = [];
	var valuesToStream = [];
	var valuesToInplace = [];

	for (var i = 0; i < lines.length; i++) {
		var line = lines[i];

		//	APSdata contiene i dati in formato JSON ritornati da APS riguardanti la linea
		var APSdata = getLineFromAPS(line);
		indexLine = mapData.datasets.indexOfField('name', line); // mapData.datasets[indexLine] e' la linea che si vuole
		// Do per scontato che indexLine non sia -1, ovvero che la linea sia presente fra i dati (assunzione PRE)

		// DELETE - Punti della mappa da cancellare
		// Devo controllare che ogni punto presente all'interno di mapData.datasets[indexLine] sia anche in APSdata

		for (var j = 0; j < mapData.datasets[indexLine].values.length; j++) {
			var value = mapData.datasets[indexLine].values[j];
			console.log('pippo');
			// controllo se value.id e' presente nei dati aggiornati, ovvero in APSdata. se non c'e' aggiungi a valuesToDelete
			if (APSdata.indexOfField('idMezzo', value.id) == -1) {
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

		// STREAM - Punti da aggiungere alla mappa
		// Devo controllare che ogni punto presente all'interno di APSdata sia anche in mapData.datasets[indexLine]
		for (var j = 0; j < APSdata.length; j++) {
			var value = APSdata[j];
			// controllo se value.idMezzo e' presente anche nei dati della mappa, ovvero in mapData
			// se non c'e' allora aggiungo a valuesToStream
			if (mapData.datasets[indexLine].values.indexOfField('id', value.idMezzo) == -1) {
				// creo un oggetto che rappresenta un punto da aggiungere e lo aggiungo a valuesToStream
				var valueToStream = {
					series: indexLine,
					data: {
						x: value.WGS84Fi,
						y: value.WGS84La,
						id: value.id
					}
				};
				valuesToStream.push(valueToStream);
			}
		}

		// INPLACE - Punti la cui posizione e' stata modificata
		// Devo cercare tutti i punti presenti sia in APSdata sia in mapData.datasets[indexLine] e li modifico
		for (var j = 0; j < APSdata.length; j++) {
			var value = APSdata[j];
			// controllo se value.idMezzo e' presente anche nei dati della mappa, ovvero in mapData.
			// se c'e' allora mapData.datasets[indexLine].values[indexValue] e' il punto relativo a value
			var indexValue = mapData.datasets[indexLine].values.indexOfField('id', value.idMezzo);
			if (indexValue != -1) {
				// se c'e' allora controllo se sono necessarie delle modifiche, ovvero controllo se x e y sono uguali
				// se sono uguali non c'e' bisogno di fare un aggiornamento
				var mapValue = mapData.datasets[indexLine].values[indexValue];
				if (mapValue.x != value.WGS84Fi || mapValue.y != value.WGS84La) {
					// posso creare un nuovo oggetto da aggiungere a valuesToInplace
					var valueToInplace = {
						position: {
							series: indexLine,
							index: indexValue,
							id: value.idMezzo
						},
						data: {
							x: value.WGS84Fi,
							y: value.WGS84La
						}
					};
					valuesToInplace.push(valueToInplace);
				}
			}
		}
	}
	var movieData = {
		'inplace': valuesToInplace,
		'stream': valuesToStream,
		'delete': valuesToDelete
	};
	return movieData;
}
