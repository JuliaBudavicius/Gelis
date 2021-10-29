var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Empresa = require('../models').Empresa;
var env = process.env.NODE_ENV || 'development';

let sessoes = [];

router.post('/atualizar/:idEmpresa', function (req, res, next) {
	console.log('atualizando informações');
	var idEmpresa = req.params.idEmpresa;
	var nomeEmpresa = req.body.nomeEmpresa;
	var emailEmpresa = req.body.emailEmpresa;
	var cnpjEmpresa = req.body.cnpjEmpresa;
	var whatsEmpresa = req.body.whatsEmpresa;
	var cepEmpresa = req.body.cepEmpresa;
	var estadoEmpresa = req.body.estadoEmpresa;
	var cidadeEmpresa = req.body.cidadeEmpresa;
	var logradouroEmpresa = req.body.logradouroEmpresa;
	var instrucaoSql;
	if (env == "dev") {
		instrucaoSql = `update Empresa set nomeEmpresa ='${nomeEmpresa}',
	email='${emailEmpresa}',
	CNPJ='${cnpjEmpresa}',
	whatsApp='${whatsEmpresa}',
	CEP='${cepEmpresa}',
	estado='${estadoEmpresa}',
	cidade='${cidadeEmpresa}',
	logradouro='${logradouroEmpresa}'
	where idEmpresa = ${idEmpresa};`;
	} else {
		
	}
	console.log(instrucaoSql);
	sequelize.query(instrucaoSql, { type: sequelize.QueryTypes.UPDATE })
		.then(resultado => {
			res.json(resultado[0]);
		}).catch(erro => {
			console.error(erro);
			res.status(500).send(erro.message);
		});
});

/* Recuperar usuário por login e senha */
router.post('/autenticar', function (req, res, next) {
	console.log('Recuperando usuário por login e senha');

	var email = req.body.email;
	var senha = req.body.senha;
	var instrucaoSql;
	if (env == "dev") {
		instrucaoSql = `select * from Empresa where email='${email}' and senha='${senha}'`;
	} else {

	}
	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Empresa
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.email);
			console.log('sessoes: ', sessoes);
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
router.post('/cadastrar', function (req, res, next) {
	console.log('Cadastrando uma nova empresa');

	Empresa.create({
		nomeEmpresa: req.body.nomeEmpresa,
		CNPJ: req.body.cnpj,
		CEP: req.body.cep,
		logradouro: req.body.logradouro,
		cidade: req.body.cidade,
		estado: req.body.estado,
		email: req.body.email,
		senha: req.body.senha,
		whatsApp: req.body.telefone

	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
		res.send(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});
router.get('/sessao/:email', function (req, res, next) {
	let email = req.params.email;
	console.log(`Verificando se o usuário ${email} tem sessão`);

	let tem_sessao = false;
	for (let u = 0; u < sessoes.length; u++) {
		if (sessoes[u] == email) {
			tem_sessao = true;
			break;
		}
	}

	if (tem_sessao) {
		let mensagem = `Usuário ${email} possui sessão ativa!`;
		console.log(mensagem);
		res.send(mensagem);
	} else {
		res.sendStatus(403);
	}

});

module.exports = router;
