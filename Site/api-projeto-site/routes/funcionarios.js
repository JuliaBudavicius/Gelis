var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var funcionario = require('../models').funcionario;
var env = process.env.NODE_ENV || 'development';

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