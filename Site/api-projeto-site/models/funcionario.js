	'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let Maquinas = sequelize.define('Maquinas',{
		idMaquinas: {
			field: 'idMaquinas',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},		
		fkEmpresa: {
			field: 'fkEmpresa',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		hostname: {
			field: 'hostname',
			type: DataTypes.STRING,
			allowNull: false
		},
		modCPU: {
			field: 'modCPU',
			type: DataTypes.STRING,
			allowNull: true
		},
		modGPU: {
			field: 'modGPU',
			type: DataTypes.STRING,
			allowNull: true
		},
		qntRAM: {
			field: 'qntRAM',
			type: DataTypes.DOUBLE,
			allowNull: true
		},
		senhaMaquina: {
			field: 'senhaMaquina',
			type: DataTypes.STRING,
			allowNull: false
		},
		nomeResp: {
			field: 'nomeResp',
			type: DataTypes.STRING,
			allowNull: false
		},
		sobrenomeResp: {
			field: 'sobrenomeResp',
			type: DataTypes.STRING,
			allowNull: false
		},
		emailFunc: {
			field: 'emailFunc',
			type: DataTypes.STRING,
			allowNull: false
		},
		loginMaquina: {
			field: 'loginMaquina',
			type: DataTypes.STRING,
			allowNull: false
		}
	}, 
	{
		tableName: 'Maquinas', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return Maquinas;
};
