package br.com.alura.forum.controller.dto.input

import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.TopicStatus
import br.com.alura.forum.model.Course
import org.springframework.data.jpa.domain.Specification

import au.com.console.jpaspecificationdsl.*
import br.com.alura.forum.model.Category

class TopicSearchInputDto(private val status: TopicStatus?, private val categoryName: String?) {
    fun toSpecification(): Specification<Topic>? = and(
            hasStatus(),
            hasCategoryName()
    )

    private fun hasStatus() = status?.let { Topic::status.equal(it) }

    private fun hasCategoryName(): Specification<Topic>? = categoryName?.let { name ->
        where {
            equal(
                it.get(Topic::course).get(Course::subcategory).get(Category::category).get(Category::name),
                name
            )
        }
    }

}
