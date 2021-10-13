'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
    let captura = sequelize.define('captura',{	
		idCaptura: {
			field: 'idCaptura',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},	
		temperatura: {
			field: 'temperatura',
			type: DataTypes.REAL,
			allowNull: false
		},
		fkSensor: {
			field: 'fkSensor',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		momentoCaptura: {
			field: 'momentoCaptura',
			type: DataTypes.DATE, // NÃO existe DATETIME. O tipo DATE aqui já tem data e hora
			allowNull: false
		},
		momento_grafico: {
			type: DataTypes.VIRTUAL, // campo 'falso' (não existe na tabela). Deverá ser preenchido 'manualmente' no select
			allowNull: true
		}
	}, 
	{
		tableName: 'captura', 
		freezeTableName: true, 
		underscored: true,
		timestamps: false,
	});

    return captura;
};
