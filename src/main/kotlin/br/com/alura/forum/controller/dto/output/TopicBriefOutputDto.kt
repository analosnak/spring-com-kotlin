package br.com.alura.forum.controller.dto.output

import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.TopicStatus.SOLVED
import java.time.Duration
import java.time.Instant

class TopicBriefOutputDto(topic: Topic) {
    val id: Long? = topic.id
    val shortDescription: String = topic.shortDescription
    val secondsSinceLastUpdate: Long = Duration.between(topic.lastUpdate, Instant.now()).seconds
    val ownerName: String = topic.owner.name
    val courseName: String = topic.course.name
    val subcategoryName: String = topic.course.subcategory.name
    val categoryName: String = topic.course.categoryName
    val numberOfResponses: Int = topic.answers.size
    val solved: Boolean = SOLVED == topic.status
}