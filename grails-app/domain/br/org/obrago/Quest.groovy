package br.org.obrago

class Quest {
	String descricao
	String recompensa

	static hasMany = [estagios: Estagio]

    static constraints = {
		widget: 'textarea'
    }
	
	static marshalling = {
		deep 'estagios'
	}
}
