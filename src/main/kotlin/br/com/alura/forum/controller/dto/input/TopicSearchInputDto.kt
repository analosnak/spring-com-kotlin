package br.com.alura.forum.controller.dto.input

import br.com.alura.forum.model.Topic
import br.com.alura.forum.model.TopicStatus
import br.com.alura.forum.model.Course
import org.springframework.data.jpa.domain.Specification

import br.com.alura.forum.model.Category
import javax.persistence.criteria.Path
import javax.persistence.criteria.Predicate

class TopicSearchInputDto(private val status: TopicStatus?, private val categoryName: String?) {
    fun toSpecification() = Specification<Topic> { root, _, criteriaBuilder ->
        val predicates = mutableListOf<Predicate>()

        status?.let {
            val path: Path<TopicStatus> = root[Topic::status.name]
            predicates.add(criteriaBuilder.equal(path, it))
        }

        categoryName?.let {
            val categoryNamePath: Path<String> =  root
                .get<Course>(Topic::course.name)
                .get<Category>(Course::subcategory.name)
                .get<Category>(Category::category.name)
                .get<String>(Category::name.name)
            predicates.add(criteriaBuilder.equal(categoryNamePath, it))
        }

        criteriaBuilder.and(*predicates.toTypedArray())
    }


}
