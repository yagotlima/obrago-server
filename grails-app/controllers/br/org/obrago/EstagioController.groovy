package br.org.obrago

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EstagioController {
	def scaffold = true
}
