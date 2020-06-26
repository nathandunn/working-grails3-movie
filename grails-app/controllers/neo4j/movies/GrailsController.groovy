package neo4j.movies

import grails.converters.JSON
import grails.gorm.transactions.Transactional
import grails.web.Controller

@Transactional
@Controller
class GrailsController {
    static responseFormats = ['json', 'xml']

    Movie index(){
        println "test"
        def movie = Movie.findByTitle("Developer")
        println "found it ${movie}"
        render movie as JSON
    }

    Movie test2(){
        println "test2"
        respond "works2"
    }
}
