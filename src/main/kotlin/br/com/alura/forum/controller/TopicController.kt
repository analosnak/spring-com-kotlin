package br.com.alura.forum.controller

import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto
import br.com.alura.forum.repository.TopicRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TopicController(private val topicRepository: TopicRepository) {
    @GetMapping("/api/topics")
    fun listTopics(): List<TopicBriefOutputDto> {
        val topics = topicRepository.findAll()
        return topics.map { TopicBriefOutputDto(it) }
    }
}