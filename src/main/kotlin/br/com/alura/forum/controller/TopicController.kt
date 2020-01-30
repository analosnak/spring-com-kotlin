package br.com.alura.forum.controller

import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto
import br.com.alura.forum.dao.TopicDao
import br.com.alura.forum.model.Category
import br.com.alura.forum.model.Course
import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.User
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TopicController(private val topicDao: TopicDao) {
    @GetMapping("/api/topics")
    fun listTopics(): List<TopicBriefOutputDto> {
        val owner = User("Ana", "ana@caelum.com.br", "1234")
        val subcategory = Category("Java", Category("Programação"))
        val course = Course("Java e JSF", subcategory)
        val topic = Topic(
            shortDescription = "Problemas com o JSF", content = "Erro ao fazer conversão da data",
            owner =  owner, course =  course
        )
        val topics = topicDao.findAll()
        return topics.map { TopicBriefOutputDto(it) }

    }
}