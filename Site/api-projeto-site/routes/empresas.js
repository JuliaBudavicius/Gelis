var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Empresa = require('../models').Empresa;
var env = process.env.NODE_ENV || 'development';

let sessoes = [];

/* Recuperar usuário por login e senha */
router.post('/autenticar', function(req, res, next) {
	console.log('Recuperando usuário por login e senha');

	var email = req.body.email; 
	var senha = req.body.senha; 	
	
	let instrucaoSql = `select * from Empresa where email='${email}' and senha='${senha}'`;
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Empresa
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.email);
			console.log('sessoes: ',sessoes);
			res.json(resultado[0]);
		} else if (resultado.length == 0) {
			res.status(403).send('Login e/ou senha inválido(s)');
		} else {
			res.status(403).send('Mais de um usuário com o mesmo login e senha!');
		}

	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

/* Cadastrar empresas */
router.post('/cadastrar', function(req, res, next) {
	console.log('Cadastrando uma nova empresa');
	
	Empresa.create({
		nomeEmpresa : req.body.nomeEmpresa,
		CNPJ : req.body.cnpj,
		CEP : req.body.cep,
		logradouro: req.body.logradouro,
		cidade : req.body.cidade,
		estado : req.body.estado,
		email : req.body.email,
		senha: req.body.senha,
		whatsApp : req.body.telefone	
		
	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
        res.send(resultado);
    }).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
  	});
});

module.exports = router;
