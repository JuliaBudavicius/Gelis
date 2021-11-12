var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var funcionario = require('../models').funcionario;
var env = process.env.NODE_ENV || 'development';

router.get('/dashboard/:idSensor', function (req, res, next) {
	console.log('Recuperando id dos Sensores');

	var idSensor = req.params.idSensor;
	let instrucaoSql = "";

	if (env == 'dev') {

	} else if (env == 'production') {
		instrucaoSql = `select top 1 tempGPU as temperatura,
		idDadosMaquinas,
		FORMAT(dataHora,'HH:mm:ss') as momento_grafico
		from [dbo].[dadosMaquinas] WHERE fkMaquinas = ${idSensor} ORDER BY idDadosMaquinas DESC`;
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
router.get('/ultimas/:idSensor', function (req, res, next) {
	const limite_linhas = 7;
	var idSensor = req.params.idSensor;
	console.log(`Recuperando as ultimas ${limite_linhas} capturas`);
	if (env == 'dev') {

	} else if (env == 'production') {
		instrucaoSql = `select top ${limite_linhas}
		idDadosMaquinas,
		tempGPU as temperatura, 
		FORMAT(dataHora,'HH:mm:ss') as momento_grafico
		from [dbo].[dadosMaquinas]
		where fkMaquinas = ${idSensor}
		order by idDadosMaquinas desc;`;
	} else {
		console.log("\n\n\n\nVERIFIQUE O VALOR DE LINHA 1 EM APP.JS!\n\n\n\n")
	}
	sequelize.query(instrucaoSql, {
		model: funcionario,
		mapToModel: false
	})
		.then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado[0]);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});
router.get('/:idEmpresa', function (req, res, next) {
	let idEmpresa = req.params.idEmpresa;
	console.log('Recuperando todos funcionarios da empresa');
	let instrucaoSql = "";

	if (env == "dev") {
		instrucaoSql = `SELECT idMaquinas as idMaquina,
        hostname as Hostname,
        nomeResp as Nome,
        sobrenomeResp as Sobrenome,
        emailFunc as email
        FROM maquinas JOIN empresa 
        WHERE fkEmpresa = idEmpresa and fkEmpresa = ${idEmpresa}`;
	} else {
		instrucaoSql = `SELECT idMaquinas as idMaquina,
        hostname as Hostname,
        nomeResp as Nome,
        sobrenomeResp as Sobrenome,
        emailFunc as email
        FROM maquinas JOIN empresa
        ON fkEmpresa = idEmpresa and fkEmpresa = ${idEmpresa};`;
	}
	sequelize.query(instrucaoSql, {
		model: funcionario,
		mapToModel: true
	})
		.then(resultado => {
			console.log(`Encontrados: ${resultado.length}`);
			res.json(resultado[0]);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});


module.exports = router;