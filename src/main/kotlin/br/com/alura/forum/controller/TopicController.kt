package br.com.alura.forum.controller

import br.com.alura.forum.model.Category
import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class TopicController {
    @ResponseBody
    @RequestMapping("/api/topics")
    fun listTopics(): List<Topic> {
        val owner = User("Ana", "ana@caelum.com.br", "1234")
        val subcategory = Category("Java", Category("Programação"))
        val course = Course("Java e JSF", subcategory)
        val topic = Topic(
            shortDescription = "Problemas com o JSF", content = "Erro ao fazer conversão da data",
            owner =  owner, course =  course
        )
        return listOf(topic, topic, topic)
    }
}