class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

		"/api/$controller?(.${format})?"{
			action = [POST: "save", PUT: "save", GET: "index", DELETE:"error"]
		}

		"/api/$controller/$id?(.${format})?" {
			action = [POST: "update", PUT: "update", GET: "show", DELETE: "delete"]
		}

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
