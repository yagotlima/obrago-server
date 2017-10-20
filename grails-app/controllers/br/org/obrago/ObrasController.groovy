package br.org.obrago

import org.springframework.http.HttpStatus;

class ObrasController {
	def tadepeService

    def index() {
	}

	def search() {
		def cidade = params.id

		if(!cidade) {
			return response.sendError(HttpStatus.NOT_FOUND.value)
		}

		def obras = tadepeService.getObrasEm(cidade)

		[obras: obras]
	}
}
