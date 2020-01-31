package br.com.alura.forum.controller

import br.com.alura.forum.controller.dto.input.TopicSearchInputDto
import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto
import br.com.alura.forum.repository.TopicRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TopicController(private val topicRepository: TopicRepository) {
    @GetMapping("/api/topics", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun listTopics(
        topicSearch: TopicSearchInputDto,
        @PageableDefault(sort = ["creationInstant"], direction = Sort.Direction.DESC) pageRequest: Pageable
    ): Page<TopicBriefOutputDto> =
        topicRepository.findAll(topicSearch.toSpecification(), pageRequest)
            .map { TopicBriefOutputDto(it) }
}
