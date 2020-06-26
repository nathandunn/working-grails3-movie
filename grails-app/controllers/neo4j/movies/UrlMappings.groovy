package neo4j.movies

class UrlMappings {

    static mappings = {
        //tag::endpoints[]
        "/movie/$title"(controller: 'movie', action: 'show') // <1>
        '/search'(controller: 'movie', action: 'search') // <2>
        "/create/$title/$tagline"(controller: 'movie', action: 'create') // <2>
        '/graph'(controller: 'movie', action: 'graph') // <3>
        '/test1'(controller: 'grails', action: 'index') // <3>
        '/test2'(controller: 'grails', action: 'test2') // <3>
        //end::endpoints[]

        //tag::index[]
        '/'(uri: '/index.html')
        //end::index[]
        '500'(view: '/error')
        '404'(view: '/notFound')
    }
}
