var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var captura = require('../models').captura;
var env = process.env.NODE_ENV || 'development';

/* Recuperar as últimas N leituras */
router.get('/ultimas/:idSensor', function (req, res, next) {

	// quantas são as últimas leituras que quer? 7 está bom?
	const limite_linhas = 7;

	var idSensor = req.params.idSensor;

	console.log(`Recuperando as ultimas ${limite_linhas} capturas`);

	// let limite_linhas = "";

	if (env == 'dev') {
		// abaixo, escreva o select de dados para o Workbench
		instrucaoSql = `SELECT temperatura AS temperatura,
		 DATE_FORMAT(momentoCaptura,'%H:%i:%s') as momento_grafico,
		 fkSensor from captura where fkSensor = ${idSensor} order by idCaptura desc limit ${limite_linhas};`;	
	} else if (env == 'production') {
		// abaixo, escreva o select de dados para o SQL Server
		instrucaoSql = `select top ${limite_linhas} 
		temperatura, 
		momentoCaptura,
		FORMAT(momentoCaptura,'HH:mm:ss') as momento_grafico
		from captura
		where fkSensor = ${idSensor}
		order by fkSensor desc`;
	} else {
		console.log("\n\n\n\nVERIFIQUE O VALOR DE LINHA 1 EM APP.JS!\n\n\n\n")
	}

	sequelize.query(instrucaoSql, {
		model: captura,
		mapToModel: true
	})
		.then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});


router.get('/dashboard/:idSensor', function (req, res, next) {
	console.log('Recuperando id dos Sensores');

	var idSensor = req.params.idSensor;
	let instrucaoSql = "";

	if (env == 'dev') {
		// abaixo, escreva o select de dados para o Workbench
		instrucaoSql = `select temperatura AS temperatura, 
		DATE_FORMAT(momentoCaptura,'%H:%i:%s') as momento_grafico, 
		fkSensor from captura where fkSensor = ${idSensor} order by idCaptura desc limit 1`;
	} else if (env == 'production') {
		// abaixo, escreva o select de dados para o SQL Server
		instrucaoSql = `select top 1 temperatura, FORMAT(momentoCaptura,'HH:mm:ss') as momento_grafico,
		 fkSensor from captura WHERE fkSensor = ${idSensor} ORDER BY idCaptura DESC`;
	} else {
		console.log("\n\n\n\nVERIFIQUE O VALOR DE LINHA 1 EM APP.JS!\n\n\n\n")
	}

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado[0]);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});

// estatísticas (max, min, média, mediana, quartis etc)
router.get('/estatisticas/:idSensor', function (req, res, next) {
	var idSensor = req.params.idSensor;
	console.log(`Recuperando as estatísticas atuais`);
	var instrucaoSql = ``;
	if (env == 'dev') {
		instrucaoSql = `select avg(temperatura) as media from captura where fkSensor = ${idSensor} and momentoCaptura > CURDATE() - INTERVAL 1 DAY;`;

	} else if (env == 'production') {
		instrucaoSql = `SELECT AVG(temperatura) AS media FROM captura WHERE fkSensor = ${idSensor} AND GETDATE() > 1;`;
	}

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado[0]);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});

});

router.get('/tempo-real/:idSensor', function (req, res, next) {
	console.log('Recuperando dados para o alerta');

	var idSensor = req.params.idSensor

	let instrucaoSql = "";

	if (env == 'dev') {
		// abaixo, escreva o select de dados para o Workbench
		instrucaoSql = `select temperatura from captura where fkSensor = ${idSensor} order by idCaptura desc limit 1`;

	} else if (env == 'production') {
		// abaixo, escreva o select de dados para o SQL Server
		instrucaoSql = `SELECT top 1 temperatura FROM captura WHERE fkSensor = ${idSensor} ORDER BY idCaptura DESC`;
	} else {
		console.log("\n\n\n\nVERIFIQUE O VALOR DE LINHA 1 EM APP.JS!\n\n\n\n")
	}

	console.log("Executando instrução: ")
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado[0]);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});

// estatísticas (max, min, média, mediana, quartis etc)
router.get('/idgranja', function (req, res, next) {

	console.log(`idgranja relacionada ao usuário`);

	if (env == 'dev') {
		var instrucaoSql = `SELECT usuario.nomeUsuario as nome, granja.idGranja as idGranja FROM usuario
	                      JOIN empresa
	                      ON fkEmpresa = idEmpresa
	                      JOIN granja;`;

	} else if (env == 'production') {

	}

	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.SELECT })
		.then(resultado => {
			res.json(resultado[0]);
		}).catch(erro => {
			console.error(erro);
			console.log(instrucaoSql);
			res.status(500).send(erro.message);
		});

});

module.exports = router;
