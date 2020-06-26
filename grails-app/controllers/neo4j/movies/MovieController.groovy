package neo4j.movies

import grails.converters.JSON
import groovy.transform.CompileStatic
import org.grails.web.json.JSONObject

//tag::controller[]
//@CompileStatic
class MovieController {
    static responseFormats = ['json', 'xml']
//end::controller[]

    // tag::service[]
    MovieService movieService
    //end::service[]

    // tag::create[]
    def create(String title,String tagline) {
        println "creating title ${title} $tagline"
        respond movieService.create(title,tagline)
    }
    //end::show[]

    // tag::show[]
    def show(String title) {
        println "finding title ${title}"
        respond movieService.find(title)
    }
    //end::show[]

    // tag::search[]
    def search(String q) {
        respond movieService.search(q)
    }
    //end::search[]

    // tag::graph[]
    def graph() {
        respond movieService.graph(params.int('limit', 100))
    }
    //end::graph[]

    def dynamicQuery() {
        println "dynamic query"
        respond {}
    }

    def findByTitle(String title){
        println "type 2 "
        def movie = movieService.dynamicFind(title)
//        println "trying to find by title ${title}"
//        def movie = Movie.findByTitleIlike("%"+title+"%")
        println "found ${movie}"
        if(movie){
            respond movie
        }
        else{
            render new JSONObject() as JSON
        }
    }
}
