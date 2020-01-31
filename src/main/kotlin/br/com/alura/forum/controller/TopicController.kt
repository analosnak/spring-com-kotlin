package br.com.alura.forum.controller

import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto
import br.com.alura.forum.repository.TopicRepository
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TopicController(private val topicRepository: TopicRepository) {
    @GetMapping("/api/topics", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun listTopics(): List<TopicBriefOutputDto> =
        topicRepository.findAll().map { TopicBriefOutputDto(it) }
}