package br.org.obrago

class Estagio {
	int indice
	String descricao
	BigDecimal latitude
	BigDecimal longitude
	Long idTadepe

	static hasMany = [evidencias: Item]
	static belongsTo = [quest: Quest]

    static constraints = {
		descricao widget: 'textarea'
		latitude scale: 8
		longitude scale:8
		idTadepe nullble: true
    }

	static marshalling = {
		deep 'quest'
	}
}
