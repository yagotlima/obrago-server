package br.org.obrago

import org.springframework.beans.factory.InitializingBean;

import grails.converters.JSON;
import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional

@Transactional
class TadepeService implements InitializingBean {
	private RestBuilder rest
	private final String authToken = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiYXBpLXRlc3QifQ.v_Xf7lggbg25iJCwG_UK6GSD-FXKWl2gNB0HkHlEO0c"
	private final String baseUrl = "http://tadepe.transparencia.org.br/api/projects/content"

	@Override
	public void afterPropertiesSet() throws Exception {
		rest = new RestBuilder()
	}

	private getJson(String url) {
		def connection = (HttpURLConnection) new URL(url).openConnection()
		
		connection.setConnectTimeout(3000)
		connection.setReadTimeout(30000)
		connection.setRequestMethod("GET")
		connection.addRequestProperty("Authorization", authToken);
		connection.setDoOutput(true);
		
		JSON.parse(connection.inputStream, connection.getContentEncoding())
	}

	def getObrasEm(String cidade) {
		getJson(baseUrl + "?city_name=${cidade}")
	}

}
